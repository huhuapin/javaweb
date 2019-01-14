<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>报修详情--宿舍管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>
<jsp:include page="layout/header.jsp"/>
<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 repair">
            <blockquote class="layui-elem-quote">报修详情</blockquote>
            <table lay-skin="line" lay-size="lg" class="layui-table">
                <colgroup>
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                    <tr>
                        <td>说明</td>
                        <td>详情</td>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td>原因</td>
                    <td>${repair.reason}</td>
                </tr>
                <tr>
                    <td>地点</td>
                    <td>${repair.address}</td>
                </tr>
                <tr>
                    <td rowspan="${repair.image_length}">照片</td>
                    <td><img src="${repair.image[0]}" alt=""></td>
                </tr>
                <c:forEach begin="1" end="${repair.image_length - 1}"  var="image">
                <tr>
                    <td><img src="${repair.image[image]}" alt=""></td>
                </tr>
                </c:forEach>
                <tr>
                    <td>联系方式</td>
                    <td>${repair.tel}</td>
                </tr>
                <tr>
                    <td>管理员回复</td>
                    <td>${repair.message}</td>
                </tr>
                <c:if test="${repair.message != null}">
                    <tr>
                        <td>回复时间</td>
                        <td><span class="date">${repair.updated_at}</span></td>
                    </tr>
                </c:if>
                <tr>
                    <td>报修时间</td>
                    <td><span class="date">${repair.created_at}</span></td>
                </tr>
                <tr>
                    <td>状态</td>
                    <td>
                        <c:choose>
                            <c:when test="${repair.status == 0}">
                                待处理
                            </c:when>
                            <c:when test="${repair.status  == 1}">
                                处理中
                            </c:when>
                            <c:when test="${repair.status == 2}">
                                已完成
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
                <c:if test="${repair.status == 2}">
                    <tr>
                        <td>评分</td>
                        <td><div class="layui-rate"></div></td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
        <jsp:include page="layout/sidebar.jsp"/>
    </div>
</div>

<jsp:include page="layout/script.jsp"/>
<c:if test="${repair.status == 2}">
<script>
    layui.use('rate', function(){
        var rate = layui.rate;

        //渲染
        var ins1 = rate.render({
            elem: '.layui-rate',  //绑定元素
            value:${repair.rate},
            <c:if test="${repair.rate !=0 }">
            readonly: true,
            </c:if>
            choose: function(value){
                if(value > 4) alert( '么么哒' )
            }
        });
    });
</script>
</c:if>
</body>
</html>
