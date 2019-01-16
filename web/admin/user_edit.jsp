
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>信息修改</title>
    <jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title"> 学生修改 <small>Edit Student</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-align-left"></i>
                            <h3>Student Info </h3>
                        </div>
                        <div class="widget-content">
                            <form method="post" action="${pageContext.request.contextPath}/admin/modifyinfo" class="form-horizontal">
                                <fieldset>
                                    <input type="hidden" value="${id}" name="id">
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="username" class="control-label">学号</label>
                                        </div>
                                        <div class="col-md-6">
                                                <input type="text" value="${username}" class="form-control" disabled id="username">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="name" class="control-label">姓名</label>
                                        </div>
                                        <div class="col-md-6">
                                            <c:choose>
                                                <c:when test="${identity == 2}">
                                                    <input type="text" value="${name}" class="form-control" name="name" id="name">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" value="${name}" class="form-control" disabled id="name">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="_class" class="control-label">班级</label>
                                        </div>
                                        <div class="col-md-6">
                                                <input type="text" value="${_class}" class="form-control" name="_class" id="_class">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="dormitory" class="control-label">宿舍</label>
                                        </div>
                                        <div class="col-md-6">
                                                <select class="form-control" name="dormitory" id="dormitory">
                                                    <c:forEach var = "dormitory" items="${dormitoryList}">
                                                        <option value="${dormitory.getId()}" class=""  <c:if test="${dormitory.getId() == dormitory_id}"> selected </c:if> >${dormitory.getDescription()}</option>
                                                    </c:forEach>
                                                </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="room" class="control-label">房间号</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" value="${room}" class="form-control" name="room" id="room">
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="form-actions">
                                    <div>
                                        <button class="btn btn-primary" type="submit">Save Changes</button>
                                        <a href="${pageContext.request.contextPath}/admin/user_list"><button class="btn btn-default" type="button">Cancel</button></a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <jsp:include page="footer.jsp"/>
