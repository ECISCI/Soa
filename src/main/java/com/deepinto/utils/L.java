package com.deepinto.utils;

/**
 * @author Ming
 * @描述 日志打印工具类
 */
public class L {

    public static boolean isDebug = true;


    public static void i(Object log) {

        if (isDebug)

            System.out.println(log);

    }

    public static void i(String TAG, Object log) {

        if (isDebug)

            System.out.println(TAG + "::" + log);

    }
}
