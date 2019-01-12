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
        <div class="layui-col-md8 mine">
            <table lay-even lay-skin="line" lay-size="lg">
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
                    <td rowspan="${repair.image.length}">照片</td>
                    <td></td>
                </tr>
                <c:forEach items="${repair.image}" var="image">
                <tr>
                    <td><img src="${image}" alt=""></td>
                </tr>
                </c:forEach>
                <tr>
                    <td>联系方式</td>
                    <td>${reapair.tel}</td>
                </tr>
                <tr>
                    <td>管理员原回复</td>
                    <td>${reapair.tel}</td>
                </tr>
                <tr>
                    <td>报修时间</td>
                    <td><span class="date">${repair.created_at}</span></td>
                </tr>
                <tr>
                    <td>回复时间</td>
                    <td><span class="date">${repair.updated_at}</span></td>
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
