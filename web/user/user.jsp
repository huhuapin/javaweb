<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="layui-col-md8 mine">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">学号</label>
                    <div class="layui-input-block">
                        <input type="text" name="sdut_id" required  lay-verify="required" disabled autocomplete="off" class="layui-input" value="16111101135">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" value="胡华聘">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="nickname" required  lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input" value="墨染堇年">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-block">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="test1">上传头像</button>
                            <div class="layui-upload-list">
                                <img class="layui-upload-img" id="demo1">
                                <p id="demoText"></p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">班级 <span>*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="class" required lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input" value="计科1604">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍楼 <span>*</span></label>
                    <div class="layui-input-block">
                        <select name="dormitory" lay-verify="required">
                            <option value="">请选择宿舍楼</option>
                            <option value="1" selected>研究生南楼</option>
                            <option value="2">研究生北楼</option>
                            <option value="3">1号宿舍楼</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">房间号 <span>*</span></label>
                    <div class="layui-input-inline">
                        <input type="text" name="room" required lay-verify="required|number" placeholder="请输入房间号" autocomplete="off" class="layui-input" value="531" lay-search>
                    </div>
                    <div class="layui-form-mid layui-word-aux">辅助文字</div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="sidebar.jsp"/>
    </div>
</div>


<script src="./statics/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['element','form','upload'], function(){
        var element = layui.element;
        var upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
    layui.use(['jquery', 'layer'], function(){
        var $ = layui.$ //重点处
            ,layer = layui.layer;
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
