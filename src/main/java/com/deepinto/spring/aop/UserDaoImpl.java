package com.deepinto.spring.aop;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("保存用户");

    }

    @Override
    public void update() {
        System.out.println("修改用户");

    }

}
