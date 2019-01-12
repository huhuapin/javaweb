<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./statics/css/bootstrap.css">
    <link rel="stylesheet" href="./statics/css/font-awesome.min.css">
    <link rel="stylesheet" href="./statics/css/login.css">
</head>
<body>
<div class="father">
    <ul class="nav nav-tabs nav-justified">
        <li class="active"><a href="#login" data-toggle="tab" aria-expanded="true" id="a-login">Login</a></li>
        <li><a href="#register" data-toggle="tab" id="a-register">Sign</a></li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade in active" id="login">
            <form action="/dormitory/login" method="post">
                <div class="form-group username">
                    <input type="text" name="username" class="form-control">
                </div>
                <div class="form-group password">
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="identity" id="inlineRadio0" value="0" checked> 学生
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="identity" id="inlineRadio1" value="1"> 宿舍管理员
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="identity" id="inlineRadio2" value="2"> 系统管理员
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" value="登录" class="form-control submit">
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="register">
            <form action="/dormitory/sign" class="form-horizontal" method="post">
                <div class="form-group">
                    <label for="nickname" class="label-control col-md-4">昵称</label>
                    <div class="col-md-8">
                        <input type="text" name="nickname" class="form-control" placeholder="请输入昵称" id="nickname">
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="label-control col-md-4">用户名</label>
                    <div class="col-md-8">
                        <input type="text" name="username" class="form-control" id="username" placeholder="学生注册请填写学号">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="label-control col-md-4">密码</label>
                    <div class="col-md-8">
                        <input type="password" name="password" class="form-control" id="password" placeholder="请填写密码">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password-confirmed" class="label-control col-md-4">确认密码</label>
                    <div class="col-md-8">
                        <input type="password" name="password_confirmed" class="form-control" id="password-confirmed" placeholder="请再次输入密码">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="label-control col-md-4">姓名</label>
                    <div class="col-md-8">
                        <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="class" class="label-control col-md-4">班级</label>
                    <div class="col-md-8">
                        <input type="text" name="class" class="form-control" id="class" placeholder="请输入班级">
                    </div>
                </div>
                <div class="form-group">
                    <label for="dormiroty" class="col-md-4 label-control">宿舍楼</label>
                    <div class="col-md-8">
                        <select name="dormitory" id="dormiroty" class="form-control">
                            <option selected="" value="" disabled>请选择...</option>
                            <c:forEach items="${dormitories}" var="dormitory">
                                <option value="${dormitory.id}">${dormitory.description}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="room" class="label-control col-md-4">房间号</label>
                    <div class="col-md-8">
                        <input type="text" name="room" class="form-control" id="room" placeholder="请输入房间号">
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" value="注册" class="form-control submit">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="./statics/js/jquery-3.3.1.min.js"></script>
<script src="./statics/js/bootstrap.js"></script>
<script src="./statics/js/three.min.js"></script>
<script src="./statics/js/three-waves.min.js"></script>
<script src="./statics/js/canvas-nest.js"></script>
<%--<script src="./statics/js/login.js"></script>--%>
<script>

    var yanzheng = new Array(10);
    $('#a-register').click(function(){

        setTimeout(function () {
            var e = $('.father');
            var wi = $(window).width();
            var hi = $(window).height();
            console.log(e.height());
            if(hi<886){
                e.css('top','0');
                e.css('transform','translate(-50%,0)');
            }else{
                e.css('top','50%');
                e.css('transform','translate(-50%,-50%)');
            }
        })

    });
    $('#a-login').click(function(){
        setTimeout(function () {
            var e = $('.father');
            var wi = $(window).width();
            if(wi>768){
                e.css('width','362px');
            }else{
                e.css('top','0');
                e.css('transform','translate(-50%,50%)');
            }
        },2000)

    });

    $('#username').blur(function () {
        var v = this.value;
        console.log(v);
        console.log(v.length);
        var reg = /^[a-zA-Z0-9_]{6,16}$/;
        if(reg.test(v)){
            $('#username').next().text("");
            $('#username').parent().addClass("has-success");
            $('#username').parent().removeClass("has-error");
            yanzheng[0] = true;
        }else{
            $('#username').parent().addClass("has-error");
            $('#username').parent().removeClass("has-success")
            $('#username').next().text("请输入6-16位字母、数字、下划线");
            yanzheng[0] = false;
        }
    });
    $('#password').blur(function () {
        var v = this.value;
        var reg = /^[a-zA-Z0-9_]{6,16}$/;
        if(reg.test(v.trim())){
            $('#password').next().text("");
            $('#password').parent().addClass("has-success");
            $('#password').parent().removeClass("has-error")
            yanzheng[1] = true;
        }else{
            $('#password').parent().addClass("has-error");
            $('#password').parent().removeClass("has-success")
            $('#password').next().text("请输入6-16位字母、数字、下划线");
            yanzheng[1] = false;
        }

    });
    $('#password-confirmed').blur(function () {
        var v = this.value;
        var p = $('#password').val();
        var reg = /^[a-zA-Z0-9_]{6,16}$/;
        if(!reg.test(v)){
            yanzheng[2] = false;
            $('#password-confirmed').parent().addClass("has-error");
            $('#password-confirmed').parent().removeClass("has-success")
            $('#password-confirmed').next().text("请输入6-16位字母、数字、下划线");
            return;
        }
        console.log(v);
        console.log(p);
        if(v==p){
            yanzheng[2] = true;
            $('#password-confirmed').next().text("");
            $('#password-confirmed').parent().addClass("has-success");
            $('#password-confirmed').parent().removeClass("has-error")
        }else{
            yanzheng[2] = false;
            console.log($('#password-confirmed').parent());
            $('#password-confirmed').next().text("两次密码输入不一致！");
            $('#password-confirmed').parent().addClass("has-error");
            $('#password-confirmed').parent().removeClass("has-success")
        }

    });
    $('input:radio').click(function () {
        if ($(this).val() == 0) {
            console.log($(this).val())
            $('#student').css('display','block');
        } else {
            $('#student').css('display','none');
        }
    })

    $('#register').children('form').submit(function(){
        var inp = $(this).find('input');
        console.log(inp.length);
        for(var i=0;i<inp.length;i++){
            if(i<3){
                if(!yanzheng[i]){
                    var inputname = $(inp[i]).parent().prev().text();
                    alert(inputname+" 不符合规则");
                    return false;
                }
            }
        }
    });
</script>
</body>
</html>
