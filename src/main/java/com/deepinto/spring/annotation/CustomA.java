package com.deepinto.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解用在接口上
 */
@Target({ElementType.TYPE})
/**
 * VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 这个注解代表Spring加载的时候回扫描这个类
 */
@Component
public @interface CustomA {

    /*
     * String value() 设置注解的值,默认值
     *
     * default 给一个默认的值
     *
     * @解释 这个值是唯一的, 后续要根据这个唯一的值拿到对应的类,
     *
     * 并通过反射方法拿到类中的方法和属性进行操作
     */
    String value() default "我是一个快乐的注解";
}
