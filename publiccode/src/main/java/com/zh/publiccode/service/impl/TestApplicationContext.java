package com.zh.publiccode.service.impl;

import com.zh.publiccode.service.Animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zhanghuihui
 * @Date 2022/11/14 12:29
 * @Description 反射注入
 */
public class TestApplicationContext {

    public static void main(String[] args) {
       new ClassPathXmlApplicationContext();
        ApplicationContext context=new FileSystemXmlApplicationContext("E:/codes\\PublicCodes\\publiccode\\src\\main\\resources\\applicationContext.xml");
        Animal cat=(Animal) context.getBean("Cat");
        cat.eat();
    }

}
