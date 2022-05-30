package com.ljr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljr.domain.Sale;
import com.ljr.service.BuyGoodsservice;

import com.ljr.service.web.ajaxtest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class mytest {
    @Test
    public void test01() throws JsonProcessingException {
        String config = "applicationContext.xml" ;
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config) ;
        BuyGoodsservice service = (BuyGoodsservice) ctx.getBean("buyGoodsservice");
        System.out.println(service);
        String names[] = ctx.getBeanDefinitionNames() ;
        for(String name : names){
            System.out.println("容器中的对象："+name);
            System.out.println(ctx.getBean(name));
        }
        System.out.println("service是代理："+service.getClass().getName());
        service.buy(10001,1);
        Sale sale = service.buydetailed();
        System.out.println(sale);

        ObjectMapper om = new ObjectMapper() ;
        String json = om.writeValueAsString(sale) ;
        System.out.println(json);
    }
    @Test
    public void test02(){
        ajaxtest ajaxtest = new ajaxtest() ;
    }
    @Test
    public void test03(){
        UUID uuid = UUID.randomUUID() ;
        String str = uuid.toString() ;
        System.out.println(str);
        str = str.replaceAll("-","") ;
        System.out.println(str);
        System.out.println(str.length());
    }
}
