<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/2
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="layui-col-md8 repiar">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>时间</th>
                    <th>原因</th>
                    <th>进度</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${repairs}" var="repair">
                    <tr>
                        <td>${repair.created_at}</td>
                        <td>${repair.reason}</td>
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
                        <td>
                            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                            <c:if test="${repair.status ==0}">
                                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                            </c:if>
                            <c:if test="${repair.status == 2}">
                                <a class="layui-btn layui-btn-xs" lay-event="edit">评分</a>
                            </c:if>
                            <c:if test="${repair.status != 1}">
                                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="layui-table-page">
                <div>
                    <div class="layui-box layui-laypage layui-laypage-default">
                        <%--上一页--%>
                        <a href="/dormitory/user/notice?page=${page.page-1}" class="layui-laypage-prev <c:if test="${page.page <=0}"> layui-disabled  </c:if>">
                            <i class="layui-icon"></i>
                        </a>
                        <%--当前页--%>
                        <span class="layui-laypage-curr">
                                <em class="layui-laypage-em">
                                </em>
                                <em>${page.page+1}</em>
                            </span>

                        <%--下一页--%>
                        <a href="/dormitory/user/index?page=${page.page+1}" class="layui-laypage-next <c:if test="${page.page+1 >= page.pageNum}"> layui-disabled  </c:if>">
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