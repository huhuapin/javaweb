<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/1
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>宿舍管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/main.css">
</head>
<body>
<jsp:include page="layout/header.jsp" />
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 message">
            <div class="layui-carousel" id="test1">
                <div carousel-item>
                    <div><img src="${pageContext.request.contextPath}/user/statics/images/1.png" alt=""></div>
                    <div><img src="${pageContext.request.contextPath}/user/statics/images/2.png" alt=""></div>
                </div>
            </div>
            <div class="message-content">
                <c:forEach items="${list_page}" var="message">
                <div class="layui-card">
                    <div class="layui-card-header">
                        <c:choose>
                            <c:when test="${message.getUser().image!=null}"><img src="${message.getUser().image}" alt="" class="layui-nav-img"></c:when>
                            <c:otherwise><img src="../statics/images/user.jpg" alt="" class="layui-nav-img"></c:otherwise>
                        </c:choose>
                        ${message.getUser().nickname}
                        <c:if test="${message.user_id == object.id}">
                        <a href="${pageContext.request.contextPath}/user/message/delete?id=${message.id}" class="close"><i class="layui-icon layui-icon-close"></i></a>
                        </c:if>
                    </div>
                    <div class="layui-card-body">
                        ${message.content}
                    </div>
                    <div class="card-footer">
                        <div class="card-footer-left"><span class="date">${message.created_at}</span></div>
                        <div class="card-footer-right">
                            <button class="layui-btn layui-btn-radius btn-praise layui-btn-primary" data-id = "${message.id}">
                                <i class="layui-icon layui-icon-praise"></i>
                                <span>${message.praise}</span>
                            </button>
                            <button class="layui-btn layui-btn-radius btn-reply layui-btn-primary" data-name = "${message.user.nickname}">
                                <i class="layui-icon layui-icon-reply-fill"></i>
                                <span>回复</span>
                            </button>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <div class="layui-table-page">
                <div>
                    <div class="layui-box layui-laypage layui-laypage-default">
                        <%--上一页--%>

                        <a href="${pageContext.request.contextPath}/user/index?page=${(page<1)? page:(page-1)}" class="layui-laypage-prev <c:if test="${page <= 1}"> layui-disabled  </c:if>">
                            <i class="layui-icon"><</i>
                        </a>
                            <%--当前页--%>
                            <span class="layui-laypage-curr">
                                <em class="layui-laypage-em">
                                </em>
                                <em>${page}</em>
                            </span>
                            <%--下一页--%>
                            <a href="${pageContext.request.contextPath}/user/index?page=${(page>=pageSum)? pageSum:(page+1)}" class="layui-laypage-next <c:if test="${page >= pageSum}"> layui-disabled  </c:if>">
                                <i class="layui-icon"></i>
                            </a>
                    </div>
                </div>
            </div>
            <div class="new-message">
                <form action="${pageContext.request.contextPath}/user/message/create" class="layui-form" method="POST">
                    <div class="layui-row">
                        <div class="layui-col-md1 layui-col-sm1 layui-hide-xs">
                            <c:choose>
                                <c:when test="${object.image!=null}"><img src="${object.image}" alt="" class="layui-nav-img"></c:when>
                                <c:otherwise><img src="../statics/images/user.jpg" alt="" class="layui-nav-img"></c:otherwise>
                            </c:choose>
                        </div>
                        <div class="layui-col-md11 layui-col-sm11">
                            <textarea name="content" class="layui-textarea" id="message"></textarea>
                            <div class="writer">
                                <button type="submit" class="layui-btn">留言</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="layout/sidebar.jsp"/>
    </div>
</div>
<jsp:include page="layout/script.jsp"/>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            ,height: '100%'
            //,anim: 'updown' //切换动画方式
        });
    });
    layui.use(['jquery', 'layer'], function(){
        var $ = layui.$ //重点处
            ,layer = layui.layer;
        var bannerH = $('.layui-carousel img').height();
        $('.layui-carousel').css('height',bannerH+'px');
        $('.btn-praise').click(function (e) {
            var flag = $(this).context.classList[5] == "layui-btn-disabled";
            if (flag)
            {
                return;
            }
            //发送ajax请求
            var id = $(this).data("id");
            var url = "${pageContext.request.contextPath}" + "/user/praise?id=" + id;
            var that = $(this);
            $.get(url,function (data) {
                var data = JSON.parse(data);
                if (data.code == 0){
                    console.log(data);
                    //code为0  点赞成功
                    that.addClass("praise-active layui-btn-disabled");
                    that.find('span').text(function (i,old) {
                        return Number(old) + 1;
                    })
                    layer.msg(data.message,{icon:1});
                }else {
                    console.log(data);
                    layer.errorMessage(data.message)
                    layer.msg(data.message,{icon:2});
                }
            })
        });
        $('.btn-reply').click(function () {
            var name = $(this).data("name");
            layedit.setContent(editor,"@"+name+"&nbsp;");
            $("html,body").finish().animate({"scrollTop":$(".layui-layedit").offset().top},400);
        })
    });
    layui.use('layedit',function () {
        layedit = layui.layedit;
        editor = layedit.build('message',{
            uploadImage : {
                url:"${pageContext.request.contextPath}/images/upload",
                type: "POST",
            }
        }); //建立编辑器
    });
</script>
</body>
</html>
