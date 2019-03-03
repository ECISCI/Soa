package com.deepinto.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @author Ming
 * @描述 第三个class
 */
// Spring配置文件加载的时候,会扫描这个注解,并且创建该类对象
@Component
public class ThreeClass {

    private String three;

    public ThreeClass() {
        System.out.println("塞进来:");
    }


    public ThreeClass(String three) {
        System.out.println("塞进来:" + three);
    }

}
