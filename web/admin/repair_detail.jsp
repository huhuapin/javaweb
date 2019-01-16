
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>报修详情</title>
    <style>
        .table img{
            max-width: 500px;
            max-height: 300px;
        }
    </style>
    <jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title">报修详情 <small>Repair Detail</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-table"></i>
                            <h3>Repair Detail</h3>
                        </div>
                        <div class="widget-content">
                            <div class="body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>说明</th>
                                        <th>详情</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>原因</td>
                                        <td>${repair.reason}</td>
                                    </tr>
                                    <c:if test="${identity == 2}">
                                        <tr>
                                            <td>宿舍楼</td>
                                            <td>${repair.dormitory.description}</td>
                                        </tr>
                                    </c:if>
                                    <tr>
                                        <td>地点</td>
                                        <td>${repair.address}</td>
                                    </tr>
                                    <tr>
                                        <td rowspan="${repair.image_length}">照片</td>
                                        <td><img src="${repair.image[0]}" alt=""></td>
                                    </tr>
                                    <c:forEach begin="1" end="${repair.image_length - 1}"  var="image">
                                        <tr>
                                            <td><img src="${repair.image[image]}" alt=""></td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td>学生姓名</td>
                                        <td>${repair.user.name}</td>
                                    </tr>
                                    <tr>
                                        <td>房间号</td>
                                        <td>${repair.user.room}</td>
                                    </tr>
                                    <tr>
                                        <td>联系方式</td>
                                        <td>${repair.tel}</td>
                                    </tr>
                                    <tr>
                                        <td>报修时间</td>
                                        <td><span class="date">${repair.created_at}</span></td>
                                    </tr>
                                    <tr>
                                        <td>状态</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${repair.status == 0}">
                                                    待处理
                                                    <a href="${pageContext.request.contextPath}/admin/repair_change?id=${repair.id}" class="btn btn-primary">设置为正在处理</a>
                                                </c:when>
                                                <c:when test="${repair.status  == 1}">
                                                    处理中
                                                    <a href="${pageContext.request.contextPath}/admin/repair_change?id=${repair.id}" class="btn btn-success">设置已完成</a>
                                                </c:when>
                                                <c:when test="${repair.status == 2}">
                                                    已完成
                                                </c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <c:if test="${repair.status == 2}">
                                        <tr>
                                            <td>评分</td>
                                            <td>
                                                <c:if test="${repair.rate == 0}">未评分</c:if>
                                                <c:if test="${repair.rate !=0}">${repair.rate}</c:if>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <form action="${pageContext.request.contextPath}/admin/repair_change" method="post">
                                    <tr>
                                        <td>
                                            <label class="control-label" for="message">回复</label>
                                        </td>
                                        <td>
                                            <input type="hidden" name="id" value="${repair.id}">
                                            <textarea id="message" rows="10" name="message" class="form-control">${repair.message}</textarea>
                                        </td>
                                    </tr>
                                        <tr>
                                            <td><a href="${pageContext.request.contextPath}/admin/repair_list" class="btn btn-danger">返回</a></td>
                                            <td><button type="submit" class="btn-success btn">回复</button></td>
                                        </tr>
                                    </form>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"/>