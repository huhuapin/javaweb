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
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/thin-admin.css" rel="stylesheet" media="screen">
<link href="css/font-awesome.css" rel="stylesheet" media="screen">
<link href="style/style.css" rel="stylesheet">
<link href="style/dashboard.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="top-navbar header b-b"> <a data-original-title="Toggle navigation" class="toggle-side-nav pull-left" href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left">
            <a href="/dormitory/admin/index.jsp">宿舍管理系统</a>
        </div>
        <ul class="nav navbar-nav navbar-right  hidden-xs">
            <li class="dropdown user  hidden-xs"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-male"></i> <span class="username">John Doe</span> <i class="icon-caret-down small"></i> </a>
                <ul class="dropdown-menu">
                    <li><a href="user_profile.html"><i class="icon-user"></i> 修改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="icon-key"></i> 登出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="wrapper">
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <li class="current"> <a href="/dormitory/admin/index.jsp"> <i class="icon-desktop"></i> 首页</a></li>
                <li> <a href="/dormitory/admin/notice——.jsp"> <i class="icon-edit"></i> 公告管理 </a></li>
                <li> <a href="#"> <i class="icon-table"></i> 人员管理 <i class="arrow icon-angle-left"></i></a>
                    <ul class="sub-menu">
                        <li> <a href="/dormitory/admin/user_list.jsp"> <i class="icon-angle-right"></i> 学生信息修改 </a> </li>
                        <li> <a href="/dormitory/admin/admin_list.jsp"> <i class="icon-angle-right"></i> 管理员信息审核 </a> </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>