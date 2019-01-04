
var yanzheng = new Array(10);
$('#a-register').click(function(){

    setTimeout(function () {
        var e = $('.father');
        var wi = $(window).width();
        var hi = $(window).height();
        console.log(e.height());
        if(hi<886){
            e.css('top','0');
            e.css('transform','translate(-50%,0)');
        }else{
            e.css('top','50%');
            e.css('transform','translate(-50%,-50%)');
        }
    })

});
$('#a-login').click(function(){
    setTimeout(function () {
        var e = $('.father');
        var wi = $(window).width();
        if(wi>768){
            e.css('width','362px');
        }else{
            e.css('top','0');
            e.css('transform','translate(-50%,50%)');
        }
    },2000)

});

$('#username').blur(function () {
    var v = this.value;
    console.log(v);
    console.log(v.length);
    var reg = /^[a-zA-Z0-9_]{6,16}$/;
    if(reg.test(v)){
        $('#username').next().text("");
        $('#username').parent().addClass("has-success");
        $('#username').parent().removeClass("has-error");
        yanzheng[0] = true;
    }else{
        $('#username').parent().addClass("has-error");
        $('#username').parent().removeClass("has-success")
        $('#username').next().text("请输入6-16位字母、数字、下划线");
        yanzheng[0] = false;
    }
});
$('#password').blur(function () {
    var v = this.value;
    var reg = /^(?=.*[a-zA-Z\d])(?=.*[\d!@#$%&*])(?=.*[a-zA-Z!@#$%&*])[a-zA-Z\d!@#$%&*]{6,16}$/;
    if(reg.test(v)){
        $('#password').next().text("");
        $('#password').parent().addClass("has-success");
        $('#password').parent().removeClass("has-error")
        yanzheng[1] = true;
    }else{
        $('#password').parent().addClass("has-error");
        $('#password').parent().removeClass("has-success")
        $('#password').next().text("密码必须由6-16位的字母、数字、下划线两种或两种以上的字符组成");
        yanzheng[1] = false;
    }

});
$('#password-confirmed').blur(function () {
    var v = this.value;
    var p = $('#password').val();
    var reg = /^(?=.*[a-zA-Z\d])(?=.*[\d!@#$%&*])(?=.*[a-zA-Z!@#$%&*])[a-zA-Z\d!@#$%&*]{6,16}$/;
    if(!reg.test(v)){
        yanzheng[2] = false;
        $('#password-confirmed').parent().addClass("has-error");
        $('#password-confirmed').parent().removeClass("has-success")
        $('#password-confirmed').next().text("密码必须由6-16位的字母、数字、下划线两种或两种以上的字符组成");
        return;
    }
    console.log(v);
    console.log(p);
    if(v==p){
        yanzheng[2] = true;
        $('#password-confirmed').next().text("");
        $('#password-confirmed').parent().addClass("has-success");
        $('#password-confirmed').parent().removeClass("has-error")
    }else{
        yanzheng[2] = false;
        console.log($('#password-confirmed').parent());
        $('#password-confirmed').next().text("两次密码输入不一致！");
        $('#password-confirmed').parent().addClass("has-error");
        $('#password-confirmed').parent().removeClass("has-success")
    }

});
$('input:radio').click(function () {
    if ($(this).val() == 0) {
        console.log($(this).val())
        $('#student').css('display','block');
    } else {
        $('#student').css('display','none');
    }
})

$('#email').blur(function(){
    var v = this.value;
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if(reg.test(v)){
        yanzheng[3] = true;
        $('#email').next().text("");
        $('#email').parent().addClass("has-success");
        $('#email').parent().removeClass("has-error")
    }else{
        yanzheng[3] = false;
        $('#email').next().text("邮箱格式不正确！");
        $('#email').parent().addClass("has-error");
        $('#email').parent().removeClass("has-success")
    }
});
$('#register').children('form').submit(function(){
    var inp = $(this).find('input');
    console.log(inp.length);
    for(let i=0;i<inp.length;i++){
        if(i<=3){
            if(!yanzheng[i]){
                var inputname = $(inp[i]).parent().prev().text();
                alert(inputname+" 不符合规则");
                return false;
            }
        }
    }
});