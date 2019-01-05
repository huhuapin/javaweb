<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <form method="post" class="form-horizontal">
                                <fieldset>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="username" class="control-label">学号</label>
                                        </div>
                                        <div class="col-md-6">
                                                <input type="text" placeholder="请输入学号" class="form-control" disabled id="username">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="name" class="control-label">姓名</label>
                                        </div>
                                        <div class="col-md-6">
                                                <input type="text" placeholder="请输入姓名" class="form-control" disabled id="name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="class" class="control-label">班级</label>
                                        </div>
                                        <div class="col-md-6">
                                                <input type="text" placeholder="请输入班级" class="form-control" id="class">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="dormitory" class="control-label">宿舍</label>
                                        </div>
                                        <div class="col-md-6">
                                                <select class="form-control" name="" id="dormitory">
                                                    <option value="" disabled >请选择</option>
                                                    <option value="" class="">研究生南楼</option>
                                                </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <label for="room" class="control-label">房间号</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" placeholder="请输入房间号" class="form-control" id="room">
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="form-actions">
                                    <div>
                                        <button class="btn btn-primary" type="submit">Save Changes</button>
                                        <button class="btn btn-default" type="button">Cancel</button>
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
