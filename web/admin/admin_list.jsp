<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                            <td>${user.get_class()}</td>
                                            <td>${user.getRoom()}</td>
                                            <td>
                                                <a href="/dormitory/admin/user_edit.jsp"><button class="btn btn-sm btn-primary"> 编辑 </button></a>
                                                <a href="/dormitory/admin/DelStudentServlet?id=${user.getId()}"></a> <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                <tr>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>胡华聘</td>
                                    <td>研究生公寓南楼</td>
                                    <td>已通过</td>
                                    <td>
                                        <button class="btn btn-sm btn-primary"> 通过审核 </button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"/>
