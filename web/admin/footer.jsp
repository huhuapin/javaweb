<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/3
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
<div class="bottom-nav footer"> 2018 &copy; Thin Admin modified by huhuapin and jiangxinyu. </div>
<!-- switcher html start-->
<div class="demo_changer active" style="right: 0px;">
    <div class="demo-icon"></div>
    <div class="form_holder">
        <div class="predefined_styles"> <a class="styleswitch" rel="a" href=""><img alt="" src="images/a.jpg"></a> <a class="styleswitch" rel="b" href=""><img alt="" src="images/b.jpg"></a> <a class="styleswitch" rel="c" href=""><img alt="" src="images/c.jpg"></a> <a class="styleswitch" rel="d" href=""><img alt="" src="images/d.jpg"></a> <a class="styleswitch" rel="e" href=""><img alt="" src="images/e.jpg"></a> <a class="styleswitch" rel="f" href=""><img alt="" src="images/f.jpg"></a> <a class="styleswitch" rel="g" href=""><img alt="" src="images/g.jpg"></a> <a class="styleswitch" rel="h" href=""><img alt="" src="images/h.jpg"></a> <a class="styleswitch" rel="i" href=""><img alt="" src="images/i.jpg"></a> <a class="styleswitch" rel="j" href=""><img alt="" src="images/j.jpg"></a> </div>
    </div>
</div>


<!--switcher html end  -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 id="myModalLabel2" class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
                <div data-validate="parsley" class="form-horizontal">
                    <fieldset>
                        <div class="control-group">
                            <div class="col-md-3">
                                <label class="control-label" for="old_password">原密码 <span class="required">*</span></label>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <input type="password" required class="form-control parsley-validated" name="title" id="old_password">
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="col-md-3">
                                <label class="control-label" for="new_password">新密码 <span class="required">*</span></label>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <input type="password" required class="form-control parsley-validated" name="title" id="new_password">
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="col-md-3">
                                <label class="control-label" for="new_password_confirmation">再次输入 <span class="required">*</span></label>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <input type="password" required class="form-control parsley-validated" name="title" id="new_password_confirmation">
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <%--<div class="form-actions">--%>
                    <%--<button class="btn btn-success" type="submit">Submit</button>--%>
                    <%--<a href="/dormitory/admin/notice_list"><button class="btn btn-default" type="button">Cancel</button></a>--%>
                    <%--</div>--%>
                </div>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary" type="button" id="submit">保存</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/dormitory/admin/js/jquery.js"></script>
<%--<script src="js/jquery-3.3.1.min.js"></script>--%>
<script>
    $('#submit').click(function () {
        var old_password = $("#old_password").val();
        var new_password = $("#new_password").val();
        var new_password_confirmation = $("#new_password").val();
        var url = "${pageContext.request.contextPath}" + "/password";
        var obj = {
            old_password:old_password,
            new_password:new_password,
            new_password_confirmation: new_password_confirmation,
        };
        $.post(url,obj,
            function (data) {
                var data = JSON.parse(data);
                console.log(data);
                if (data.code == 0) {
                    alert(data.message);
                    $('#myModal').modal('hide');
                } else {
                    alert(data.message)
                }
            });
    });
</script>
<script src="/admin/js/bootstrap.min.js"></script>
<script type="/admin/text/javascript" src="js/smooth-sliding-menu.js"></script>
<%--<script class="include" type="text/javascript" src="javascript/jquery191.min.js"></script>--%>
<%--<script class="include" type="text/javascript" src="javascript/jquery.jqplot.min.js"></script>--%>
<%--<script src="assets/sparkline/jquery.sparkline.js" type="text/javascript"></script>--%>
<%--<script src="assets/sparkline/jquery.customSelect.min.js" ></script>--%>
<%--<script src="assets/sparkline/sparkline-chart.js"></script>--%>
<%--<script src="assets/sparkline/easy-pie-chart.js"></script>--%>
<%--<script src="js/select-checkbox.js"></script>--%>
<%--<script src="js/to-do-admin.js"></script>--%>

<script src="/dormitory/admin/switcher/switcher.js"></script>
<script src="/dormitory/admin/switcher/moderziner.custom.js"></script>
<link href="/dormitory/admin/switcher/switcher.css" rel="stylesheet">
<link href="/dormitory/admin/switcher/switcher-defult.css" rel="stylesheet">

<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/a.css" title="a" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/b.css" title="b" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/c.css" title="c" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/d.css" title="d" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/e.css" title="e" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/f.css" title="f" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/g.css" title="g" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/h.css" title="h" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/i.css" title="i" media="all" />
<link rel="alternate stylesheet" type="text/css" href="/dormitory/admin/switcher/j.css" title="j" media="all" />



</body>
</html>