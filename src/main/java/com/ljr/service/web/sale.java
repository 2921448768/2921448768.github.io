package com.ljr.service.web;

import com.ljr.service.BuyGoodsservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sale", value = "/sale")
public class sale extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");

//        String config = "applicationContext.xml" ;
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config) ;

          WebApplicationContext ctx = null ;
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attr  =  getServletContext().getAttribute(key) ;
//        if(attr != null){
//           ctx = (WebApplicationContext)attr;
//        }
        ServletContext sc = getServletContext();

        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc) ;
        System.out.println("容器对象信息："+ctx);

        BuyGoodsservice service = (BuyGoodsservice) ctx.getBean("buyGoodsservice");
        service.buy(Integer.parseInt(id),Integer.parseInt(quantity));

        request.getRequestDispatcher("/result.jsp").forward(request,response);


    }
}
