package com.deepinto.controller;

import com.deepinto.entity.LoginEntity;
import com.deepinto.service.LoginService;
import com.deepinto.utils.L;
import com.deepinto.utils.MsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ming
 * @描述 管理员登录
 */
@Controller
public class LoginController {

    public static final String TAG = LoginController.class.getSimpleName();

    @Autowired
    LoginService service;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public MsResult login(@RequestBody LoginEntity entity) {

        try {

            L.i(TAG,"用户名:"+entity.getUsername()+"密码:"+entity.getPassword());

            return service.login(entity);

        } catch (Exception e) {

            return MsResult.fail(e);
        }
    }
}
