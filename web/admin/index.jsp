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
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
                            <div class="stats-heading">宿舍楼</div>
                            <div class="stats-body-alt">
                                <div class="text-center">研究生公寓南楼</div>
                            </div>
                            <div class="stats-footer">more info</div>
                        </a> </div>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
                            <div class="stats-heading">公告数量</div>
                            <div class="stats-body-alt">
                                <div class="text-center">85</div>
                            </div>
                            <div class="stats-footer">go to account</div>
                        </a> </div>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
                            <div class="stats-heading">公寓学生数</div>
                            <div class="stats-body-alt">
                                <div class="text-center">207</div>
                            </div>
                            <div class="stats-footer">manage members</div>
                        </a> </div>
                        <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
                            <div class="stats-heading">管理员数</div>
                            <div class="stats-body-alt">

                                <div class="text-center">345</div>
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

