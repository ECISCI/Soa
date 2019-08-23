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
    <meta charset="utf-8">
    <title>MS后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="后台管理系统">
    <meta name="description" content="API网关 v1.0，它是一款基于Layui框架的轻量级扁平化的网站后台管理系统。">
    <link rel="shortcut icon" href="../../static/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
    <link rel="stylesheet" href="../../static/css/okadmin.css">
    <link rel="stylesheet" href="../../static/css/font_693759_ciewkz7d5vo.css">
    <link rel="stylesheet" href="../../static/lib/nprogress/nprogress.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <!--头部导航-->
    <div class="layui-header">
        <div class="layui-logo">MS后台管理系统</div>
        <div class="menu-switch">
            <i class="iconfont icon-caidan"></i>
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../../static/images/head.jpg" class="layui-nav-img">
                    bobi
                </a>
            </li>
            <li class="layui-nav-item"><a href="javascript:void(0)" id="logout">退出</a></li>
        </ul>
    </div>
    <!--左侧导航区域-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="" id="treeFunction">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        <i class="layui-icon">&#xe62a;</i> 功能列表
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>销量统计</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>推送统计</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>新增商品</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>商品列表</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>上传图片</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>上传视频</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="" id="treeIndexSync">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        <i class="layui-icon">&#xe62a;</i> 索引同步
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>ES索引同步</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>Solar索引同步</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>Hive索引同步</a></dd>
                        <dd><a href="javascript:;" path="donate.html" tab-id="1-11"><i
                                class="iconfont "></i>Hbase索引同步</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <%--<!-- 内容主体区域 -->--%>
    <%--<div class="content-body">--%>
        <%--<div class="layui-tab layui-tab-brief" lay-filter="ok-tab" lay-allowClose="true">--%>
            <%--<ul class="layui-tab-title">--%>
                <%--<li class="layui-this"><i class="layui-icon">&#xe68e;</i> 控制台</li>--%>
            <%--</ul>--%>
            <%--<div class="layui-tab-content">--%>
                <%--<div class="layui-tab-item layui-show">--%>
                    <%--<iframe src='welcome'></iframe>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!--底部信息-->
    <div class="layui-footer">
        MS后台管理系统 v1.0
    </div>
</div>
<div class="yy"></div>
<!--js逻辑-->
<script src="../../static/js/jquery.1.12.4.min.js"></script>
<script src="../../static/js/jquerysession.js"></script>
<script src="../../static/js/common.js"></script>
<script src="../../static/lib/layui/layui.js"></script>
<script src="../../static/lib/nprogress/nprogress.js"></script>
<script src="../../static/ms/index.js"></script>
</body>
</html>
