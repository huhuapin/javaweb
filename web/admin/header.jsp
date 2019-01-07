<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="/dormitory/admin/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="/dormitory/admin/css/thin-admin.css" rel="stylesheet" media="screen">
<link href="/dormitory/admin/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="/dormitory/admin/style/style.css" rel="stylesheet">
<link href="/dormitory/admin/style/dashboard.css" rel="stylesheet">
<style>
    .pagination > li {
        display: inline;
        line-height: 34px;
    }
</style>
</head>
<body>
<div class="container">
    <div class="top-navbar header b-b"> <a data-original-title="Toggle navigation" class="toggle-side-nav pull-left" href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left">
            <a href="/dormitory/admin/index.jsp">宿舍管理系统</a>
        </div>
        <ul class="nav navbar-nav navbar-right  hidden-xs">
            <li class="dropdown user  hidden-xs"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-male"></i> <span class="username">${sessionScope.user.getName()}</span> <i class="icon-caret-down small"></i> </a>
                <ul class="dropdown-menu">
                    <li><a href= "#" data-target="#myModal" data-toggle="modal"><i class="icon-user"></i> 修改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="/dormitory/logout"><i class="icon-key"></i> 登出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="wrapper">
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <li <c:if test="${pageContext.request.getServletPath().equals(\"/admin/index.jsp\")}"> class="current" </c:if> > <a href="/dormitory/admin/index"> <i class="icon-desktop"></i> 首页</a></li>
                <li <c:if test="${pageContext.request.getServletPath().equals(\"/admin/notice_list.jsp\")}"> class="current" </c:if> ><a href="/dormitory/admin/notice_list"> <i class="icon-edit"></i> 公告管理 </a></li>
                <li > <a href="#"> <i class="icon-table"></i> 人员管理 <i class="arrow <c:choose><c:when test="${pageContext.request.getServletPath().equals(\"/admin/user_list.jsp\") || pageContext.request.getServletPath().equals(\"/admin/admin_list.jsp\")}">icon-angle-down</c:when><c:otherwise>icon-angle-left</c:otherwise></c:choose>"></i></a>
                    <ul class="sub-menu" style="display: <c:choose><c:when test="${pageContext.request.getServletPath().equals(\"/admin/user_list.jsp\") || pageContext.request.getServletPath().equals(\"/admin/admin_list.jsp\")}">block</c:when><c:otherwise>none</c:otherwise></c:choose>">
                        <li <c:if test="${pageContext.request.getServletPath().equals(\"/admin/user_list.jsp\")}"> class="current" </c:if> > <a href="/dormitory/admin/user_list"> <i class="icon-angle-right"></i> 学生信息修改 </a> </li>
                        <li <c:if test="${pageContext.request.getServletPath().equals(\"/admin/admin_list.jsp\")}"> class="current" </c:if> > <a href="/dormitory/admin/admin_list"> <i class="icon-angle-right"></i> 管理员信息审核 </a> </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>