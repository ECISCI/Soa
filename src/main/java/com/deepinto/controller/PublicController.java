package com.deepinto.controller;

import com.deepinto.utils.L;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ming
 * @描述 一些公共的jsp页面
 */
@Controller
public class PublicController {

    /**
     * 登录页
     *
     * @return login
     */
    @RequestMapping("/login")
    public String index() {
        L.i("请求访问:login");

        return "login";
    }

    /**
     * 首页
     *
     * @return main
     */
    @RequestMapping("/main")
    public String main() {
        L.i("请求访问:main");

        return "main";
    }

    /**
     * welcome
     *
     * @return welcome
     */
    @RequestMapping("/welcome")
    public String welcome() {
        L.i("请求访问:welcome");

        return "welcome";
    }

}
