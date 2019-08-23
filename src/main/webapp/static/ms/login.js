layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form(),
        layer = layui.layer;


    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        },
        password: [/(.+){6,12}$/, '密码必须6到12位'],
    });

    //监听提交
    form.on('submit(login)', function (data) {


        // 对密码加密
        // let passwd = data.field.password;
        // let mpwd = $.md5(passwd);
        // data.field.password = mpwd;

        $.ajax({
            url: "http://localhost:8085/userlogin",
            type: "post",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify(data.field),
            //{"username","admin";}
            success: function (data) {

                console.log(data);
                if (data.status == 200 && data.msg == 'OK') {
                    layer.msg('登录成功');

                     window.location = "main"; //登录成功后页面跳转

                } else {
                    layer.msg('登录失败 ' + data.msg);
                }
            },
            error: function (data) {
                layer.msg('登录失败 ' + data.msg);
            }
        });

        return false;
    });

});