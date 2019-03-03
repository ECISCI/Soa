package com.deepinto.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Ming
 * @描述 第一个class
 */
public class OneClass implements ApplicationContextAware, InitializingBean {


    private OneClass(String one) {

        System.out.println(one);
    }

    @Override// Spring创建该类对象的同时会调用此方法,此方法可以做一些初始化操作
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        System.out.println("setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
