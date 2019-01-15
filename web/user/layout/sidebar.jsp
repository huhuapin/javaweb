<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-col-md4 sidebar">
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>宿舍成员</h2>
        </div>
        <div class="layui-card-body">
            <table class="layui-table">
                <thead>
                <tr>
                    <td>班级</td>
                    <td>姓名</td>
                    <td>昵称</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${roommates}" var="roommate">
                <tr>
                    <td>${roommate._class}</td>
                    <td>${roommate.name}</td>
                    <td>${roommate.nickname}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>宿舍楼公告</h2>
        </div>
        <div class="layui-card-body">
            ${firstNotice.content}
        </div>
        <div class="card-footer">
            <div class="card-footer-left">
                <span class="date">${firstNotice.created_at}</span>
            </div>
            <div class="card-footer-right">
                <a href="${pageContext.request.contextPath}/user/notice">查看历史公告 >></a>
            </div>
        </div>
    </div>
</div>
