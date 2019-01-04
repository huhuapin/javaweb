<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <h3>公告</h3>
                    </div>
                    <div class="widget-content">
                        <div class="body">
                            <table class="table table-striped table-images">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>标题</th>
                                    <th>时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>这是一个标题</td>
                                    <td> 2018-12-13 </td>
                                    <td class="hidden-xs"><button class="btn btn-sm btn-primary"> 编辑 </button>
                                        <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button></td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>这是一个标题</td>
                                    <td> 2018-12-13 </td>
                                    <td class="hidden-xs"><button class="btn btn-sm btn-primary"> 编辑 </button>
                                        <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button></td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>这是一个标题</td>
                                    <td> 2018-12-13 </td>
                                    <td class="hidden-xs"><button class="btn btn-sm btn-primary"> 编辑 </button>
                                        <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button></td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>这是一个标题</td>
                                    <td> 2018-12-13 </td>
                                    <td class="hidden-xs">
                                        <button class="btn btn-sm btn-primary"> 编辑 </button>
                                        <button data-toggle="button" class="btn btn-sm btn-warning"> 删除 </button>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                            <div class="clearfix">
                                <ul class="pagination no-margin">
                                    <li class="disabled"><a href="#">Prev</a></li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">Next</a></li>
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