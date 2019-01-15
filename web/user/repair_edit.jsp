<%@ page import="domain.Repair" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>报修--宿舍管理系统</title>
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
            <form class="layui-form" action="${pageContext.request.contextPath}/user/repair/edit" method="POST">
                <div class="layui-form-item">
                    <input type="hidden" name="id" value="${repair.id}">
                    <label class="layui-form-label">报修原因 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="reason" required  lay-verify="required" autocomplete="off" class="layui-input" value="${repair.reason}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">地点 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="address" required  lay-verify="required" autocomplete="off" class="layui-input" value="${repair.address}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">照片 <span>*</span></label>
                    <div class="layui-input-block">
                        <div class="layui-upload">
                            <a class="layui-btn" id="test1">上传照片</a>
                            <div class="layui-upload-list">
                                <input type="hidden" name="image" class="layui-upload-file" value="" required  lay-verify="required">
                                <p id="demoText"></p>
                            </div>
                                <div class="layui-upload-list uploader-list" style="overflow: auto;" id="uploader-list">
                                    <c:forEach var="image" items="${repair.image}">
                                        <div id="" class="file-iteme"><div class="handle"><span class="glyphicon glyphicon-trash">删除</span></div><img style="max-width: 100%" src="${image}"><div class="info"></div></div>
                                    </c:forEach>
                                </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">详细描述 <span>*</span></label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" required  lay-verify="required" class="layui-textarea" name="detail">${repair.detail}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话 <span>*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="tel" required  lay-verify="required|phone" placeholder="请输入联系方式" autocomplete="off" class="layui-input" value="${repair.tel}">
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
        var arr = [];
        <c:forEach items="${repair.image}" var="image">
            arr.push("${image}");
        </c:forEach>
        $("input[name='image']").val(JSON.stringify(arr));
        var index = 1;
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '${pageContext.request.contextPath}/images/upload' //上传接口
            ,multiple: true
            ,number: 3
            ,done: function(data){
                //上传完毕回调

                if (data.code == 0) {
                    $('#uploader-list').append(
                        '<div id="" class="file-iteme">' +
                        '<div class="handle"><span class="glyphicon glyphicon-trash"><a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></span></div>' +
                        '<img style="max-width: 100%" src='+ data.data.src +'>' +
                        '</div>'
                    );
                    //获取到上传图片的输入框
                    var image = $("input[name='image']");
                    //追加图片
                    arr.push(data.data.src);

                    image.val(JSON.stringify(arr));

                    layer.msg(data.message,{icon:1});
                } else{
                    layer.msg(data.message,{icon:1});
                }
            }
            ,error: function(){
                //请求异常回调
            }
        });

        //鼠标放在上传的图片上
        $(document).on("mouseenter mouseleave", ".file-iteme", function(event){
            if(event.type === "mouseenter"){
                //鼠标悬浮
                $(this).children(".info").fadeIn("fast");
                $(this).children(".handle").fadeIn("fast");
            }else if(event.type === "mouseleave") {
                //鼠标离开
                $(this).children(".info").hide();
                $(this).children(".handle").hide();
            }
        });
        $(document).on("click", ".file-iteme .handle", function(event){
            //在输入框中删除这个元素
            arr.splice($(this).parent().index(),1);
            if (arr.length == 0) {
                //如果数组长度为空，则将input置空
                $("input[name='image']").val("");
            } else {
                //否则，格式化删除的数组
                $("input[name='image']").val(JSON.stringify(arr));
            }
            $(this).parent().remove();
        });
    });

</script>
</body>
</html>
