package com.ljr.dao;

import com.ljr.domain.Goods;

public interface GoodsDao {
     int updateGoods(Goods goods) ;
     Goods selectGoods(Integer ItemID) ;
}
