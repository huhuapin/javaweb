<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thin Admin</title>
    <jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title"> 概览 <small>General View</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <c:if test="${identity == 1}">
                            <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
                                <div class="stats-heading">宿舍楼</div>
                                <div class="stats-body-alt">
                                    <div class="text-center">${description}</div>
                                </div>
                                <div class="stats-footer">more info</div>
                            </a> </div>
                        </c:if>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="/dormitory/admin/notice_list" class="stats-container">
                            <div class="stats-heading">公告数量</div>
                            <div class="stats-body-alt">
                                <div class="text-center">${noticeSum}</div>
                            </div>
                            <div class="stats-footer">go to account</div>
                        </a> </div>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="/dormitory/admin/user_list" class="stats-container">
                            <div class="stats-heading">公寓学生数</div>
                            <div class="stats-body-alt">
                                <div class="text-center">${userSum}</div>
                            </div>
                            <div class="stats-footer">manage members</div>
                        </a> </div>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="/dormitory/admin/admin_list" class="stats-container">
                            <div class="stats-heading">管理员数</div>
                            <div class="stats-body-alt">

                                <div class="text-center">${adminSum}</div>
                            </div>
                            <div class="stats-footer">manage orders</div>
                        </a> </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <div class="widget-container">
                        <div class="padded"> <a href="#" class="pull-right"><i class="icon-map-marker"></i></a> <span class="h4">McLean, VA</span>
                            <div class="text-center padder m-t"> <span class="h1"><i class="icon-cloud text-muted"></i> 68A</span> </div>
                        </div>
                        <div class="widget-footer lt">
                            <div class="row">
                                <div class="col-xs-4"> <small class="text-muted block">Humidity</small> <span>56 %</span> </div>
                                <div class="col-xs-4"> <small class="text-muted block">Precip.</small> <span>0.00 in</span> </div>
                                <div class="col-xs-4"> <small class="text-muted block">Winds</small> <span>7 mp</span> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"/>

