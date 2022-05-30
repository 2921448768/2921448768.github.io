package com.ljr.service.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljr.domain.Sale;
import com.ljr.service.BuyGoodsservice;
import com.ljr.service.impl.BuyGoodsserviceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ajaxtest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("局部刷新");
//        BuyGoodsservice service = new BuyGoodsserviceImpl() ;
//        Sale sale = service.buydetailed(40);
//        System.out.println(sale);
//        resp.getWriter().println("123") ;



        WebApplicationContext ctx = null ;
        ServletContext sc = getServletContext();

        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc) ;
        System.out.println("容器对象信息："+ctx);

        BuyGoodsservice service = (BuyGoodsservice) ctx.getBean("buyGoodsservice");
        Sale sale = service.buydetailed() ;
        resp.setContentType("text/html;charset=utf-8");

        //{“str1”:"1000" ,“str2”:"hello",“str3”:20}
        String str = "{\"str1\":\"1000\",\"str2\":\"hello\",\"str3\":\"20\"}" ;


        ObjectMapper om = new ObjectMapper() ;
        String json = om.writeValueAsString(sale) ;

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        resp.getWriter().println(json);
    }
}
