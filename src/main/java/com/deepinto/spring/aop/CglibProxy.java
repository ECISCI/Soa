package com.deepinto.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author Aming
 * <p>
 * Cglib的动态代理模式
 */
public class CglibProxy {

    public static BookImpl getProxy() {

        // 1.创建Cglib核心类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(BookImpl.class);

        // 3.设置回调函数
        enhancer.setCallback(new org.springframework.cglib.proxy.MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {

                if (method.getName().equals("save")) {
                    System.out.println("打印日志");
                }

                return methodProxy.invokeSuper(obj, args);
            }
        });

        BookImpl proxy = (BookImpl) enhancer.create();
        return proxy;

    }

}
