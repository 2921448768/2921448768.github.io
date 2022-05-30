package com.ljr.service.impl;

import com.ljr.Excdption.NotEnoughException;
import com.ljr.Excdption.NullPointerException;
import com.ljr.dao.GoodsDao;
import com.ljr.dao.SaleDao;
import com.ljr.domain.Goods;
import com.ljr.domain.Sale;
import com.ljr.service.BuyGoodsservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BuyGoodsserviceImpl implements BuyGoodsservice {

    private SaleDao saleDao ;
    private GoodsDao goodsDao ;
    private  static  Integer id =46;


//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false ,
//            rollbackFor = {
//                    NullPointerException.class ,  NotEnoughException.class ,
//
//            }
//    )
//    @Transactional()
    @Override
    public void buy(Integer GoodsItemId,Integer quantity) {

        id++;

        String config = "applicationContext.xml" ;
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config) ;
        Sale sale = (Sale) ctx.getBean("Sale");
        Goods good= goodsDao.selectGoods(GoodsItemId) ;

        sale.setItemID(GoodsItemId);
        sale.setCommodity(good.getCommodity());
        sale.setQuantity(quantity);
        sale.setTotalAmount(good.getPrice()*quantity);
        System.out.println(sale);
        saleDao.insertSale(sale) ;

        Goods goods= goodsDao.selectGoods(GoodsItemId) ;
        if(goods == null ){
            throw new NullPointerException("该商品已下架") ;
        }else if(goods.getQuantity()<quantity){
            throw  new NotEnoughException("该商品已售罄！看看别的商品") ;
        }
        Goods buyGood = new Goods() ;
        buyGood.setItemNumber(GoodsItemId);
        buyGood.setQuantity(quantity);
        goodsDao.updateGoods(buyGood) ;

        System.out.println("购买成功！");

    }

    @Override
    public Sale buydetailed() {
        String config = "applicationContext.xml" ;
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config) ;
        Sale sale = saleDao.selectSale(id) ;
        return sale ;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
