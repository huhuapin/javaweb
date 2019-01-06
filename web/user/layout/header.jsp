<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <div class="layui-container" id="nav">
        <h1 class="brand">宿舍管理系统</h1>
        <ul class="layui-nav userinfo">
            <li class="layui-nav-item">
                <a href="javascript:;">${user.name}</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" id="openModal">修改密码</a></dd>
                    <dd><a href="/dormitory/user/edit">个人信息</a></dd>
                    <dd><a href="/dormitory/logout">登出</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav">
            <li class="layui-nav-item"><a href="/dormitory/user/index">首页</a></li>
            <li class="layui-nav-item"><a href="/dormitory/user/notice">公告</a></li>
            <li class="layui-nav-item"><a href="/dormitory/user/service">功能</a></li>
        </ul>
    </div>
</div>


