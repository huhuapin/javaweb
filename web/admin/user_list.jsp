<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/4
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <tr>
                                    <td>1</td>
                                    <td>16111101135</td>
                                    <td>胡华聘</td>
                                    <td>计科1604</td>
                                    <td>531</td>
                                    <td>
                                        <a href="/dormitory/admin/user_edit.jsp"><button class="btn btn-sm btn-primary"> 编辑 </button></a>
                                        <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button>
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