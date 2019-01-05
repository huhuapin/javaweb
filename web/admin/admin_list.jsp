<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>管理员审核</title>
<jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title"> 管理员 <small>Administrator</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-user"></i>
                            <h3>Administrators</h3>
                        </div>
                        <div class="widget-content">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>用户名</th>
                                    <th>姓名</th>
                                    <th>宿舍楼</th>
                                    <th>状态</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="admin" items="${adminList}">
                                        <tr>
                                            <td>${admin.getId()}</td>
                                            <td>${admin.getUsername()}</td>
                                            <td>${admin.getName()}</td>
                                            <td>${admin.getDescription()}</td>
                                            <c:if test="${admin.getStatus() == 1}">
                                                <td>已审核</td>
                                            </c:if>
                                            <c:if test="${admin.getStatus() == 0}">
                                                <td>未审核</td>
                                                <td>
                                                    <a href="/dormitory/admin/admincheck?id=${admin.getId()}"><button class="btn btn-sm btn-primary"> 通过审核 </button></a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"/>
