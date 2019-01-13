<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
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
                                    <th>联系方式</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="admin" items="${list_page}">
                                        <tr>
                                            <c:if test="${admin.getDormitory_id() != 0}">
                                                <td>${admin.getId()}</td>
                                                <td>${admin.getUsername()}</td>
                                                <td>${admin.getName()}</td>
                                                <td>${admin.getDescription()}</td>
                                                <td>${admin.getTel()}</td>
                                                <td>
                                                    <a href="/dormitory/admin/showadmin?id=${admin.getId()}&username=${admin.getUsername()}&name=${admin.getName()}&dormitory_id=${admin.getDormitory_id()}&tel=${admin.getTel()}"><button class="btn btn-sm btn-primary"> 编辑 </button></a>
                                                    <a href="/dormitory/admin/deladmin?id=${admin.getId()}"><button  class="btn btn-sm btn-warning"> 删除 </button></a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix">
                                <ul class="pagination no-margin">
                                    <li><a href="/dormitory/admin/admin_list?page=1">&lt;&lt; 首页 </a></li>
                                    <li><a href="/dormitory/admin/admin_list?page=${(page<1)? page:(page-1)}"> &lt; 上一页 </a></li>
                                    <li >第${page}页/共${pageSum}页</li>
                                    <li><a href="/dormitory/admin/admin_list?page=${(page>=pageSum)? pageSum:(page+1)}">下一页 &gt;</a></li>
                                    <li><a href="/dormitory/admin/admin_list?page=${pageSum}">末页 &gt;&gt;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"/>
