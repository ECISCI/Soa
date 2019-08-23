<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>API网关</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="API网关 v1.0,API网关网站后台模版">
    <meta name="description" content="API网关 v1.0是一款基于Layui框架的轻量级扁平化后台管理系统。">
    <link rel="shortcut icon" href="../../static/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
    <link rel="stylesheet" href="../../static/css/scroll-bar.css">
    <link rel="stylesheet" href="../../static/css/sub-page.css">
    <link rel="stylesheet" href="../../static/css/font_693759_hsptnwurztv.css">
</head>
<body>
<div class="ok-body">
    <blockquote class="layui-elem-quote">
        欢迎管理员：<span class="x-red" id="cnname"></span>！当前时间: <span id="nowTime"></span> <span id="weekday"></span>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据统计</legend>
        <div class="layui-row layui-col-space10 layui-row-margin">
            <div class="layui-col-md2">
                <div class="layui-bg-green md2-sub1" path="register">
                    <i class="iconfont icon-wenzhang2"></i>
                </div>
                <div class="md2-sub2">
                    <span id="apinum">100</span>
                    <cite>API总数</cite>
                </div>
            </div>
            <div class="layui-col-md2">
                <div class="layui-bg-blue md2-sub1" path="apiuser">
                    <i class="iconfont icon-dianliyonghuzongshu"></i>
                </div>
                <div class="md2-sub2">
                    <span id="usernum">100</span>
                    <cite>用户总数</cite>
                </div>
            </div>
            <div class="layui-col-md2">
                <div class="layui-bg-black md2-sub1">
                    <i class="iconfont icon-pinglun"></i>
                </div>
                <div class="md2-sub2">
                    <span id="nodenum">100</span>
                    <cite>节点总数</cite>
                </div>
            </div>
            <div class="layui-col-md2">
                <div class="layui-bg-orange md2-sub1" path="logrecord">
                    <i class="iconfont icon-goods"></i>
                </div>
                <div class="md2-sub2">
                    <span id="accessnum">100</span>
                    <cite>当天访问量</cite>
                </div>
            </div>
            <div class="layui-col-md2">
                <div class="layui-bg-red md2-sub1" path="logrecord">
                    <i class="iconfont icon-jiaose"></i>
                </div>
                <div class="md2-sub2">
                    <span id="exceptaccessnum">100</span>
                    <cite>当天异常访问量</cite>
                </div>
            </div>
            <div class="layui-col-md2">
                <div class="layui-bg-cyan md2-sub1">
                    <i class="iconfont icon-webpage"></i>
                </div>
                <div class="md2-sub2">
                    <span id="accessedapinum">100</span>
                    <cite>当天访问API数</cite>
                </div>
            </div>
        </div>
    </fieldset>

    <blockquote class="layui-elem-quote">
        系统基本参数
    </blockquote>
    <table id="nodeinfo" lay-filter="node"></table>
</div>
<!--js逻辑-->
<script src="../../static/js/jquery.1.12.4.min.js"></script>
<script src="../../static/js/jquerysession.js"></script>
<script src="../../static/js/common.js"></script>
<script src="../../static/lib/layui/layui.js"></script>
<script src="../../static/ms/welcome.js"></script>
</body>
</html>