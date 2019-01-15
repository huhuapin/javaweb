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
                    <h2 class="page-title">报修列表 <small>Repair</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-table"></i>
                            <h3>报修 </h3>
                        </div>
                        <div class="widget-content">
                            <div class="body">
                                <table class="table table-striped table-images">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>原因</th>
                                        <th>地点</th>
                                        <c:if test="${identity == 2}"><th>宿舍楼</th></c:if>
                                        <th>时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="repair" items="${list_page}">
                                        <tr>
                                            <td>${repair.id}</td>
                                            <td>${repair.reason}</td>
                                            <td>${repair.address}</td>
                                            <c:if test="${identity == 2}">
                                                <td>${repair.dormitory.description}</td>
                                            </c:if>
                                            <td><span class="date">${repair.created_at}</span></td>
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
                                            <a href="${pageContext.request.contextPath}/admin/showrepair?id=${repair.id}"><button class="btn btn-sm btn-primary"> 详情 </button></a>
                                                <a href="${pageContext.request.contextPath}/admin/repair_change?id=${repair.id}">
                                                        <c:choose>
                                                        <c:when test="${repair.status == 0}">
                                                    <button class="btn btn-sm btn-info">设置为 处理中</button>
                                                        </c:when>
                                                        <c:when test="${repair.status  == 1}">
                                                            <button class="btn btn-sm btn-success">设置为 已完成</button>
                                                        </c:when>
                                                        </c:choose>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="clearfix">
                                    <ul class="pagination no-margin">
                                        <li><a href="${pageContext.request.contextPath}/admin/repair_list?page=1">&lt;&lt; 首页 </a></li>
                                        <li><a href="${pageContext.request.contextPath}/admin/repair_list?page=${(page<1)? page:(page-1)}"> &lt; 上一页 </a></li>
                                        <li >第${page}页/共${pageSum}页</li>
                                        <li><a href="${pageContext.request.contextPath}/admin/repair_list?page=${(page>=pageSum)? pageSum:(page+1)}">下一页 &gt;</a></li>
                                        <li><a href="${pageContext.request.contextPath}/admin/repair_list?page=${pageSum}">末页 &gt;&gt;</a></li>
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