<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>通知公告</title>
<jsp:include page="header.jsp"/>
<div class="page-content">
    <div class="content container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-title">通知公告 <small>Notice</small></h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="widget">
                    <div class="widget-header"> <i class="icon-table"></i>
                        <h3>公告 </h3>
                        <a href="/dormitory/admin/notice_create"><button  class="btn  btn-success"> 发布公告 </button></a>
                    </div>
                    <div class="widget-content">
                        <div class="body">
                            <table class="table table-striped table-images">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>标题</th>
                                    <th>时间</th>
                                    <c:if test="${identity == 2}"><th>创建者</th></c:if>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="notice" items="${list_page}">
                                        <tr>
                                            <td>${notice.getId()}</td>
                                            <td>${notice.getTitle()}</td>
                                            <td><span class="date">${notice.getCreated_at()}</span></td>
                                            <c:if test="${identity == 2}">
                                                <c:choose>
                                                    <c:when test="${notice.getDormitory_id() == 0}"><td>系统管理员</td></c:when>
                                                    <c:otherwise><td>${notice.description()}</td></c:otherwise>
                                                </c:choose>
                                            </c:if>
                                            <td>
                                                <a href="/dormitory/admin/shownotice?id=${notice.getId()}"><button class="btn btn-sm btn-primary"> 编辑 </button></a>
                                                <a href="/dormitory/admin/delnotice?id=${notice.getId()}"><button  class="btn btn-sm btn-warning"> 删除 </button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix">
                                <ul class="pagination no-margin">
                                    <li><a href="/dormitory/admin/notice_list?page=1">&lt;&lt; 首页 </a></li>
                                    <li><a href="/dormitory/admin/notice_list?page=${(page<1)? page:(page-1)}"> &lt; 上一页 </a></li>
                                    <li >第${page}页/共${pageSum}页</li>
                                    <li><a href="/dormitory/admin/notice_list?page=${(page>=pageSum)? pageSum:(page+1)}">下一页 &gt;</a></li>
                                    <li><a href="/dormitory/admin/notice_list?page=${pageSum}">末页 &gt;&gt;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>