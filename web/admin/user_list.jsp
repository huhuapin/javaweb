<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>人员管理</title>
<jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title"> 本楼学生 <small>This Dormitory Student</small></h2>
                </div>
            </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="widget">
                    <div class="widget-header"> <i class="icon-user"></i>
                        <h3>Students</h3>
                    </div>
                    <div class="widget-content">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>班级</th>
                                <th>房间号</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${list_page}">
                                    <tr>
                                        <td>${user.getId()}</td>
                                        <td>${user.getUsername()}</td>
                                        <td>${user.getName()}</td>
                                        <td>${user.get_class()}</td>
                                        <td>${user.getRoom()}</td>
                                        <td>
                                            <a href="/dormitory/admin/showinfo?id=${user.getId()}&username=${user.getUsername()}&name=${user.getName()}&_class=${user.get_class()}&dormitory_id=${user.getDormitory_id()}&room=${user.getRoom()}"><button class="btn btn-sm btn-primary"> 编辑 </button></a>
                                            <a href="/dormitory/admin/userlist?id=${user.getId()}"><button  class="btn btn-sm btn-warning"> 删除 </button></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="clearfix">
                            <ul class="pagination no-margin">
                                <li><a href="/dormitory/admin/user_list?page=1">&lt;&lt; 首页 </a></li>
                                <li><a href="/dormitory/admin/user_list?page=${(page<1)? page:(page-1)}"> &lt; 上一页 </a></li>
                                <li >第${page}页/共${pageSum}页</li>
                                <li><a href="/dormitory/admin/user_list?page=${(page>=pageSum)? pageSum:(page+1)}">下一页 &gt;</a></li>
                                <li><a href="/dormitory/admin/user_list?page=${pageSum}">末页 &gt;&gt;</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
<jsp:include page="footer.jsp"/>