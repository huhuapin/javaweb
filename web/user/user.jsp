<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>公告--宿舍管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>
<jsp:include page="layout/header.jsp"/>

<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 mine">
            <form class="layui-form" action="${pageContext.request.contextPath}/user/edit" method="POST">
                <div class="layui-form-item">
                    <label class="layui-form-label">学号</label>
                    <div class="layui-input-block">
                        <input type="text" name="sdut_id" required  lay-verify="required" disabled autocomplete="off" class="layui-input" value="${object.username}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" disabled class="layui-input" value="${object.name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="nickname" required  lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input" value="${object.nickname}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-block">
                        <div class="layui-upload">
                            <a class="layui-btn" id="test1">上传头像</a>
                            <div class="layui-upload-list">
                                <c:choose>
                                    <c:when test="${object.image != null}">
                                        <input type="hidden" name="image" class="layui-upload-file" value="${object.image}">
                                        <img class="layui-upload-img" id="demo1" src="${object.image}">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="hidden" name="image" class="layui-upload-file" value="/${pageContext.request.contextPath}/user/statics/images/user.jpg">
                                        <img class="layui-upload-img" id="demo1" src="/${pageContext.request.contextPath}/user/statics/images/user.jpg">
                                    </c:otherwise>
                                </c:choose>
                                <p id="demoText"></p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">班级</label>
                    <div class="layui-input-inline">
                        <input type="text" name="class" required lay-verify="required" placeholder="请输入班级" disabled autocomplete="off" class="layui-input" value="${object._class}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍楼 </label>
                    <div class="layui-input-block">
                        <select name="dormitory" lay-verify="required" disabled>
                            <option value="${dormitory.id}">${dormitory.description}</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="room" required lay-verify="required|number" disabled  placeholder="请输入房间号" autocomplete="off" class="layui-input" value="${object.room}" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['form','upload','layer'], function(){
        var layer = layui.layer,$=layui.$;
        var upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '${pageContext.request.contextPath}/images/upload' //上传接口
            ,done: function(data){
                //上传完毕回调
                console.log(data);
                if (data.code == 0) {
                    $('#demo1').attr("src",data.data.src);
                    console.log(this.item);
                    $("input[name='image']").val(data.data.src);
                    layer.msg(data.message,{icon:1});
                } else{
                    layer.msg(data.message,{icon:1});
                }
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });

</script>
</body>
</html>
