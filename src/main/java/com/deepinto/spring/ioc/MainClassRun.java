package com.deepinto.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @描述 主函数
 */

/**
 * @总结 通过日志我们可以看到
 * <p>
 * Spring在配置文件加载的时候会通过bean标签,将已配置好Bean的类创建该类对象,
 * <p>
 * 并且在Spring开启包扫描的同时通过 @Component注解来创建该类对象
 */
public class MainClassRun {

    public static void main(String[] args) {

        testIoc();

    }


    public static void testIoc() {

        new ClassPathXmlApplicationContext("classpath:applicationContext-ioc.xml");
    }
}
