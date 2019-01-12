<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/2
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>服务--宿舍管理系统</title>
    <link rel="stylesheet" href="./statics/css/layui.css">
    <link rel="stylesheet" href="./statics/css/main.css">
</head>
<body>
<%--头部导航栏--%>

<jsp:include page="layout/header.jsp"/>
<%--主体内容--%>
<div class="layui-container">
    <div class="layui-row main">
        <div class="layui-col-md8 grade">
            <fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a name="grade">卫生成绩</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>录入日期</th>
                    <th>周次</th>
                    <th>公寓楼</th>
                    <th>房间号</th>
                    <th>得分</th>
                    <th>加减分</th>
                </tr>
                </thead>
                <tbody id="view">
                                    
                </tbody>
            </table>
            <fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a name="elec">电费信息</a></legend>
            </fieldset>
            <div class="site-block">
                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-block">查询中...</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">剩余电量</label>
                    <div class="layui-input-block">查询中...</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用电状态</label>
                    <div class="layui-input-block">查询中...</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">可用天数</label>
                    <div class="layui-input-block">查询中...</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">统计时间</label>
                    <div class="layui-input-block">查询中...</div>
                </div>
            </div>
        </div>


        <%--侧边栏--%>
        <jsp:include page="layout/sidebar.jsp"/>
        </div>
</div>
<jsp:include page="layout/script.jsp"/>
<%--模板标签--%>
<script id="grade" type="text/html">
    {{#
    var sum = 0;
    layui.each(d.data, function(index, item){
    }}
    <tr>
        <td>{{item.date}}</td>
        <td>{{item.week}}</td>
        <td>{{item.dormitory}}</td>
        <td>{{item.room}}</td>
        <td>{{item.score}}</td>
        <td>
            {{# if(item.score >=85 && item.score<95){ }}
                0
            {{# }else if(item.score >=95 ){  sum+=0.1;}}
            <font color="#01AAED">0.1</font>
            {{# }else { sum-=0.1;}}
            <font color="#FF5722">0.1</font>
            {{# } }}
        </td>
    </tr>
    {{#   });  }}
        <tr>
            <td colspan="5">合计加/减分</td>
            <td>
                {{# if( sum.toFixed(1) == 0){ }}
                0
                {{# }else if(sum.toFixed(1) > 0 ){  }}
                <font color="#01AAED">{{sum.toFixed(1)}}</font>
                {{# }else { }}
                <font color="#FF5722"> {{sum.toFixed(1)}} </font>
                {{# } }}
            </td>
        </tr>
</script>
<script>
    function Message(message) {
        //弹出一个公告层
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确定']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' + message + '</div>'
        });
    }
    layui.use(['jquery', 'layer','laytpl'], function(){
        var laytpl = layui.laytpl;
        var $ = layui.$ //重点处
        var layer = layui.layer;
        $(function () {
            var index1 = layer.load(2, {time: 3*1000});
            //查询卫生成绩
            var url = "https://api.youthol.cn/api/service/hygiene?dormitory=${dormitory.name}&room=${object.room}";
            $.ajax({
                url : url,
                type: 'GET',
                success :function (data) {
                    var getTpl = $('#grade').html();
                    laytpl(getTpl).render(data,function (html) {
                        $('#view').html(html);
                    })
                },
                error:function (data,status) {
                    var message = data.responseJSON.message;
                    Message(message);
                }
            })//查询卫生结束
            //查询电费
            var url = "https://api.youthol.cn/api/service/elec";
            $.ajax({
                url: url,
                type: 'GET',
                data: {
                    school: '${dormitory.school}',
                    dormitory: '${dormitory.elec_name}',
                    room: '${object.room}',
                },
                success: function (data,status) {
                    console.log(data);
                    var inp = $('.layui-input-block');
                    inp[0].innerHTML = (data.data.room);
                    inp[1].innerHTML = (data.data.elec);
                    inp[2].innerHTML = (data.data.status);
                    inp[3].innerHTML = (data.data.remain);
                    inp[4].innerHTML = (data.data.time);
                    layer.close(index1);
                },
                error: function (data,status) {
                    var message = data.responseJSON.message;
                    Message(message);
                },
                complete: function () {
                    layer.close(index1);
                }
            });//查询电费结束
        });
    });
</script>
</body>
</html>
