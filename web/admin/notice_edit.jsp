<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<jsp:include page="header.jsp"/>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title">编辑公告 <small>Edit Notice</small></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-7">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-file-alt"></i>
                            <h3> Notice</h3>
                        </div>
                        <div class="widget-content">
                            <form data-validate="parsley" novalidate method="post" class="form-horizontal">
                                <fieldset>
                                    <div class="control-group">
                                        <div class="col-md-3">
                                            <label class="control-label" for="title">Title <span class="required">*</span></label>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <input type="text" required class="form-control parsley-validated" name="title" id="title">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="col-md-3">
                                            <label class="control-label" for="text">Content</label>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <textarea class="form-control" name="text" rows="10" id="text" style="display: none;"></textarea>
                                                <input type="hidden" name="_wysihtml5_mode" value="1">
                                                <div class="form-group">
                                                    <textarea id="text" rows="10" name="text" class="form-control"></textarea>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </fieldset>
                                <div class="form-actions">
                                    <button class="btn btn-success" type="submit">Submit</button>
                                    <button class="btn btn-default" type="button">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>