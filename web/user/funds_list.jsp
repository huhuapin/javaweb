<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>舍费查询--宿舍管理系统</title>
    <link rel="stylesheet" href="./statics/css/layui.css">
    <link rel="stylesheet" href="./statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>
<jsp:include page="layout/header.jsp"/>

<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 funds_list">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>时间</th>
                    <th>原因</th>
                    <th>金额</th>
                    <th>操作人</th>
                    <th>余额</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:set var="balance" value="0" />--%>
                <c:forEach items="${list_page}" var="allfunds">
                    <%--<c:set var="balance" value="${balance+allfunds.money}" />--%>
                    <tr>
                        <td>${allfunds.created_at}</td>
                        <td>${allfunds.description}</td>
                        <td>${allfunds.money}</td>
                        <td>${allfunds.name}</td>
                        <td>${allfunds.balance}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="layui-table-page">
                <div>
                    <div class="layui-box layui-laypage layui-laypage-default">
                        <%--上一页--%>
<<<<<<< HEAD
                        <a href="${pageContext.request.contextPath}/user/notice?page=${page.page-1}" class="layui-laypage-prev <c:if test="${page.page <=0}"> layui-disabled  </c:if>">
=======
                        <a href="/dormitory/user/funds?page=${(page<1)? page:(page-1)}" class="layui-laypage-prev <c:if test="${page <= 1}"> layui-disabled  </c:if>">
>>>>>>> ac82c9466716295b307aaaf2d9ac1c5642585ce3
                            <i class="layui-icon"></i>
                        </a>
                        <%--当前页--%>
                        <span class="layui-laypage-curr">
                                <em class="layui-laypage-em">
                                </em>
                                <em>${page}</em>
                            </span>

                        <%--下一页--%>
                        <a href="/dormitory/user/funds?page=${(page>=pageSum)? pageSum:(page+1)}" class="layui-laypage-next <c:if test="${page >= pageSum}"> layui-disabled  </c:if>">
                            <i class="layui-icon"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="layout/sidebar.jsp"/>
    </div>
</div>
<jsp:include page="layout/script.jsp"/>

</body>
</html>