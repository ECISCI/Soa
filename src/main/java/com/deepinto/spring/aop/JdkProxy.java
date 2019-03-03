package com.deepinto.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * JDK动态代理
 *
 * @author Ming
 * <p>
 * <p>
 * 使用JDK的方式来生成代理对象
 */
public class JdkProxy {

    public static UserDao getProxy(final UserDao dao) {

        UserDao proxy = (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {

                        if (method.getName().equals("save")) {
                            System.out.println("记录日志");
                        } else if (method.getName().equals("update")) {
                            System.out.println("更新日志");
                        }

                        return method.invoke(dao, args);
                    }
                });

        return proxy;
    }

}
