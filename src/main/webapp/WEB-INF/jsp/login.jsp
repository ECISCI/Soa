<%--
  Created by IntelliJ IDEA.
  User: Aming
  Date: 2019/5/22
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>熊猫商城</title>
    <link rel="stylesheet" type="text/css" href="../../static/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/login.css"/>
</head>

<body>
<div class="m-login-bg">
    <div class="m-login">
        <h3>熊猫商城后台管理系统登录</h3>
        <div class="m-login-warp">
            <form class="layui-form">
                <div class="layui-form-item">
                    <input type="text" name="username" required lay-verify="required" placeholder="用户名"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="text" name="password" required lay-verify="required" placeholder="密码"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item m-login-btn">
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
                    </div>
                    <div class="layui-inline">
                        <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                    </div>
                </div>
            </form>
        </div>
        <p class="copyright">Copyright 2019 Ming</p>
    </div>
</div>

<script src="../../static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/js/jquery.1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/js/jquery.md5.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/ms/login.js" type="text/javascript" charset="utf-8"></script>

</body>

</html>
