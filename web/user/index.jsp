<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/1
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>宿舍管理系统</title>
    <link rel="stylesheet" href="./statics/css/layui.css">
    <link rel="stylesheet" href="./statics/css/main.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 message">
            <div class="layui-carousel" id="test1">
                <div carousel-item>
                    <div>条目1</div>
                    <div>条目2</div>
                    <div>条目3</div>
                    <div>条目4</div>
                    <div>条目5</div>
                </div>
            </div>
            <div class="message-content">
                <div class="layui-card">
                    <div class="layui-card-header">
                        <img src="../statics/images/user.jpg" alt="" class="layui-nav-img">
                        姜新宇
                    </div>
                    <div class="layui-card-body">
                        卡片式面板面板通常用于非白色背景色的主体内
                        <p>今天又是元气满满的一天呦</p>
                        <div>2019，你好</div>
                        从而映衬出边框投影
                    </div>
                    <div class="card-footer">
                        <div class="card-footer-left">
                            2019-01-01 20:00:00
                        </div>
                        <div class="card-footer-right">
                            <button class="layui-btn layui-btn-radius btn-praise layui-btn-primary">
                                <i class="layui-icon layui-icon-praise"></i>
                                <span>122</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="layui-card">
                    <div class="layui-card-header">
                        <img src="../statics/images/user.jpg" alt="" class="layui-nav-img">
                        姜新宇
                    </div>
                    <div class="layui-card-body">
                        卡片式面板面板通常用于非白色背景色的主体内
                        <p>今天又是元气满满的一天呦</p>
                        <div>2019，你好</div>
                        从而映衬出边框投影
                    </div>
                    <div class="card-footer">
                        <div class="card-footer-left">
                            2019-01-01 20:00:00
                        </div>
                        <div class="card-footer-right">
                            <button class="layui-btn layui-btn-radius layui-btn-primary btn-praise">
                                <i class="layui-icon layui-icon-praise "></i>
                                <span>123</span>
                            </button>
                        </div>
                    </div>
                </div>
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
                                <em class="layui-laypage-em">
                                </em>
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
            <div class="new-message">
                <form action="" class="layui-form">
                    <div class="layui-row">
                        <div class="layui-col-md1">
                            <img class="layui-nav-img" src="../statics/images/user.jpg" alt="">
                        </div>
                        <div class="layui-col-md11">
                            <textarea name="message" class="layui-textarea">

                            </textarea>
                            <div class="writer">
                                <button class="layui-btn layui-btn-primary">取消</button>
                                <button type="submit" class="layui-btn">留言</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="sidebar.jsp"/>
    </div>
</div>
<script src="../statics/layui.js"></script>
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
