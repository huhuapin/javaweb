<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 19-1-15
  Time: 下午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>创建管理员</title>
    <jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title"> 创建管理员 <small>Create Admin</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-align-left"></i>
                            <h3>Student Info </h3>
                        </div>
                        <div class="widget-content">
                            <form method="post" action="${pageContext.request.contextPath}/admin/admin_create" class="form-horizontal">
                                <fieldset>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="username" class="control-label">用户名</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" name="username" id="username">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="password" class="control-label">密码</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="password" class="form-control" name="password" id="password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="name" class="control-label">姓名</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" name="name" id="name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="dormitory" class="control-label">宿舍楼</label>
                                        </div>
                                        <div class="col-md-6">
                                            <select class="form-control" name="dormitory" id="dormitory">
                                                <c:forEach var = "dormitory" items="${dormitoryList}">
                                                    <option value="${dormitory.getId()}" class="">${dormitory.getDescription()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="tel" class="control-label">联系方式</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" name="tel" id="tel">
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="form-actions">
                                    <div>
                                        <button class="btn btn-primary" type="submit">Save Changes</button>
                                        <a href="${pageContext.request.contextPath}/admin/admin_list"><button class="btn btn-default" type="button">Cancel</button></a>
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

