<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/2
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>公告--宿舍管理系统</title>
    <link rel="stylesheet" href="./statics/css/layui.css">
    <link rel="stylesheet" href="./statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>
<jsp:include page="header.jsp"/>

<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
    <div class="layui-col-md8 notice">
        <div class="layui-collapse " lay-accordion>
            <c:forEach items="${notices}" var="notice">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">${notice.title} <span class="title-time">${notice.created_at}</span></h2>
                <div class="layui-colla-content">${notice.content}</div>
            </div>
            </c:forEach>
        </div>
        <div class="layui-table-page">
            <div>
                <div class="layui-box layui-laypage layui-laypage-default">
                    <%--上一页--%>
                    <a href="" class="layui-laypage-prev layui-disabled">
                        <i class="layui-icon"></i>
                    </a>
                        <%--当前页--%>
                        <span class="layui-laypage-curr">
                            <em class="layui-laypage-em"></em>
                            <em>1</em>
                        </span>


                    <a href="">2</a>
                    <a href="">3</a>
                    <a href="" class="layui-laypage-last" >100</a>
                    <%--下一页--%>
                    <a href="" class="layui-laypage-next">
                        <i class="layui-icon"></i>
                    </a>
                    <%--跳转到第X页--%>
                    <span class="layui-laypage-skip">
                                到第
                                <select name="" id="">
                                    <option value="1">1</option>
                                </select>
                                页
                                <button type="button" class="layui-laypage-btn">确定</button>
                            </span>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="sidebar.jsp"/>
</div>
</div>


<script src="./statics/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
    layui.use(['jquery', 'layer'], function(){
        var $ = layui.$ //重点处
            ,layer = layui.layer;
        $('.btn-praise').click(function (e) {
            var flag = $(this).context.classList[5] == "layui-btn-disabled";
            if (flag)
            {
                return;
            }
            //发送ajax请求
            $(this).find('span').text(function (i,old) {
                return Number(old) + 1;
            });
            $(this).addClass("praise-active layui-btn-disabled");
        })
        //屏幕宽度太小时，将导航栏高度变为原来两倍
        function mobileNav() {
            var nav = $("#nav").children();
            var sum = 0;
            for(var i = 0;i<nav.length;i++) {
                sum += nav[i].clientWidth;
            }
            var width = sum + 30;
            if (width>$(window).width()) {
                $('.layui-header').css("height","120px");
            } else {
                $('.layui-header').css("height","60px")
            }
        }
        mobileNav();
        $(window).resize(mobileNav)
    });

</script>
</body>
</html>