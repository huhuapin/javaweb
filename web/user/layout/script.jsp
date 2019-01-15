<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/6
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="layui-col-md12 password" style="display: none">
    <div class="layui-form">
    <div class="layui-form-item">
    <label class="layui-form-label">原密码 <span>*</span></label>
    <div class="layui-input-block">
    <input type="password" name="old_password" placeholder="请输入原密码" required  lay-verify="required"autocomplete="off" class="layui-input" value="">
    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">新密码<span>*</span></label>
    <div class="layui-input-block">
    <input type="password" name="new_password" required  lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">确认密码<span>*</span></label>
    <div class="layui-input-block">
    <input type="password" name="new_password_confirmation" required  lay-verify="required" placeholder="请再次输入" autocomplete="off" class="layui-input"   >
    </div>
    </div>
    <div class="layui-form-item">
    <div class="layui-input-block">
    <button class="layui-btn" lay-submit lay-filter="formDemo" id="submit">修改密码</button>
    <button type="reset" class="layui-btn layui-btn-primary" id="close">关闭</button>
    </div>
    </div>
    </div>
    </div>
    <script src="../statics/layui.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8">
    //注意：导航 依赖 element 模块，否则无法进行功能性操作

    layui.use(['layer','element'],function () {
    var element = layui.element;
    var layer = layui.layer,$=layui.$;
    //截取日期后两位
    $('.date').each(function () {
        var s = this.innerHTML;
        this.innerHTML = s.trim().substring(0,s.length-2);
    });
        //修改密码
    $('#openModal').click(function () {
        var modal = layer.open({
            type:1,//类型
            offset: '200px',
            area:['600px','300px'],//定义宽和高
            title:'修改密码',//题目
            shadeClose:false,//点击遮罩层关闭
            content: $('.password')//打开的内容
        });
        $('#submit').click(function () {
        var old_password = $("input[name='old_password']").val();
        var new_password = $("input[name='new_password']").val();
        var new_password_confirmation = $("input[name='new_password_confirmation']").val();
        var url = "${pageContext.request.contextPath}" + "/password";
        $.post(url, {
            'old_password':old_password,
            'new_password':new_password,
            'new_password_confirmation': new_password_confirmation,
            },
            function (data) {
                var data = JSON.parse(data);
                console.log(data);
                if (data.code == 0) {
                    layer.msg(data.message,{icon:1});
                    layer.close(modal);
                } else {
                    layer.msg(data.message,{icon:2});
                }
             });
        });
        $('#close').click(function () {
            layer.close(modal);
        });
    });
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
    $(window).resize(function() {
        mobileNav();
    var bannerH = $('.layui-this img').height();
    $('.layui-carousel').css('height',bannerH+'px');
    });

    });
    </script>