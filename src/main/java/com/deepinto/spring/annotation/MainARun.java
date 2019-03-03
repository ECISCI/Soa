package com.deepinto.spring.annotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Ming
 * @描述 自定义注解主函数
 */
/*
 * @总结 ###请看完全部代码再来看总结
 *
 * Spring @Component注解是如何工作的？
 *
 * 当在一个类上添加@Component注解的时候, 在Spring开启包扫描加载的时候会通过如下代码中类似
 *
 * Map<String, Object> customA = context.getBeansWithAnnotation(CustomA.class);
 *
 * 的方法拿到添加@Component注解的所有类,
 *
 * 拿到所有类以后,会通过反射的方式创建所有类的对象
 *
 * 通过反射的方式拿到所有类的内部的方法和属性
 *
 * */
@Component // Spring配置文件加载的时候回通过这个注解创建MainARun对象,会调用 setApplicationContext方法
public class MainARun implements ApplicationContextAware {


    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("classpath:applicationContext-annotation.xml");
    }


    @Override // Spring创建MainARun对象的时候回调用这个方法
    public void setApplicationContext(ApplicationContext context) throws BeansException {


        // @解释 这句代码实际上就是拿到使用@CustomA注解的所有的类
        Map<String, Object> customA = context.getBeansWithAnnotation(CustomA.class);

        // @解释 这里的beanValue其实就是CustomAServiceImpl类,因为在测试代码中只有CustomAServiceImpl类使用了@CustomA注解
        for (Object beanValue : customA.values()) {

            /*
             * @解释 beanValue.getClass().getAnnotation(CustomA.class).value();
             *
             * 这段代码最后面的.value()就是你自定义注解里面那个 String value() default "";
             *
             * @注意！！！ 这个Value的值最好设置是唯一的
             */
            String value = beanValue.getClass().getAnnotation(CustomA.class).value();

            System.out.println("注解上的value:" + value);

            try {
                /*
                 * @解释 这里通过注解找到对应类中的 hello方法
                 *
                 * @解释 其实在反射过程中可以通过注解的唯一标识（上面获取的value值）找到对应的类,
                 *
                 * 再通过反射的方法获取类中所有的属性和方法,进而对这些属性和方法进行操作
                 *
                 * @解释 ... 这里省事,当然类中的方法我是知道的,所以直接使用
                 */
                Method method = beanValue.getClass().getMethod("hello", new Class[]{String.class});

                Object invoke = method.invoke(beanValue, "我是invoke找到你的");

                System.out.println("invoke:" + invoke);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
