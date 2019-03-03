package com.deepinto.spring.annotation;


/**
 * @author Ming
 */
@CustomA("CustomAServiceImpl") // 这里为注解传入值,这个值必须是唯一的
public class CustomAServiceImpl implements CustomAService {


    @Override
    public String hello(String name) {

        return "Hello::" + name;
    }
}
