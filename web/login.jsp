<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
                    <input type="submit" value="登录" class="form-control submit">
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="register">
            <form action="/dormitory/sign" class="form-horizontal" method="post">
                <div class="form-group">
                    <label for="" class="label-control col-md-4">用户名</label>
                    <div class="col-md-8">
                        <input type="text" name="username" class="form-control" id="username" placeholder="学生注册请填写学号">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="label-control col-md-4">密码</label>
                    <div class="col-md-8">
                        <input type="text" name="password" class="form-control" id="password" placeholder="请填写密码">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="label-control col-md-4">确认密码</label>
                    <div class="col-md-8">
                        <input type="text" name="password_confirmation" class="form-control" id="password-confirmed" placeholder="请再次输入密码">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="label-control col-md-4">姓名</label>
                    <div class="col-md-8">
                        <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-md-4 label-control">宿舍楼</label>
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
                    <label for="" class="label-control col-md-4">身份</label>
                    <div class="col-md-8">
                        <label class="radio-inline">
                            <input type="radio" name="admin" id="inlineRadio2" value="1" checked> 管理员
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="admin" id="inlineRadio3" value="0"> 学生
                        </label>
                    </div>
                </div>
                <div id="student" style="display: none">
                <div class="form-group">
                    <label for="" class="label-control col-md-4">昵称</label>
                    <div class="col-md-8">
                        <input type="text" name="nickname" class="form-control" placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="class" class="label-control col-md-4">班级</label>
                    <div class="col-md-8">
                    <input type="text" name="class" class="form-control" id="class" placeholder="请输入班级">
                    </div>
                </div>
                    <div class="form-group">
                        <label for="room" class="label-control col-md-4">房间号</label>
                        <div class="col-md-8">
                        <input type="text" name="room" class="form-control" id="room" placeholder="请输入房间号">
                        </div>
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
<script src="./statics/js/login.js"></script>
</body>
</html>
