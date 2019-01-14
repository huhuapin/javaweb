<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>舍费--宿舍管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>
<jsp:include page="layout/header.jsp"/>

<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 funds">
            <form class="layui-form" action="/dormitory/user/funds/create" method="post">

                <div class="layui-form-item">
                    <label class="layui-form-label">标题<span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">类型<span>*</span></label>
                    <div class="layui-input-block">
                        <input type="radio" name="type" value="收入" title="收入">
                        <input type="radio" name="type" value="支出" title="支出" checked>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">金额<span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="money" required  lay-verify="required" placeholder="请输入金额" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">详细描述</label>
                    <div class="layui-input-block">
                        <textarea name="description" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit >立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="layout/sidebar.jsp"/>
    </div>
</div>
<jsp:include page="layout/script.jsp"/>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

    });
</script>
</body>
</html>