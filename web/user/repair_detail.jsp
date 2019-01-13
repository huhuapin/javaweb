<%@ page import="domain.Repair" %>
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
<%
    Repair repair = (Repair) request.getAttribute("repair");
%>
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
                    <td rowspan="<%=repair.getImage().length %>">照片</td>
                    <td><img src="${repair.image[0]}" alt=""></td>
                </tr>
                <c:forEach begin="1" end="<%=repair.getImage().length-1 %>"  var="image">
                <tr>
                    <td><img src="${repair.image[image]}" alt=""></td>
                </tr>
                </c:forEach>
                <tr>
                    <td>联系方式</td>
                    <td>${repair.tel}</td>
                </tr>
                <tr>
                    <td>管理员原回复</td>
                    <td>${reapair.message}</td>
                </tr>

                <tr>
                    <td>报修时间</td>
                    <td><span class="date">${repair.created_at}</span></td>
                </tr>

                </tbody>
            </table>
        </div>
        <jsp:include page="layout/sidebar.jsp"/>
    </div>
</div>

<jsp:include page="layout/script.jsp"/>

</body>
</html>
