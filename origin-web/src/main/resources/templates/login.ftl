<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | 登录</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<#include "${request.contextPath}/manage/common/css.ftl"/>
    <!-- iCheck -->
    <link rel="stylesheet" href="${request.contextPath}/manage/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="/index"><b>Dy</b>Enigma</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录系统</p>
        <form action="/index" method="post">
            <div class="form-group has-feedback">
                <input type="email" class="form-control" name="username" id="username" placeholder="邮箱或用户名">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 记住我
                        </label>
                    </div>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
        <div class="social-auth-links text-center">
            <p>- 其他登录方式 -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i>
                使用微信账号登录</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> 使用QQ账号登录</a>
        </div>
        <a href="#">忘记密码</a><br>
        <a href="/register" class="text-center">注册一个新的账号</a>
    </div>
</div>
<!-- jQuery 3 -->
<script src="${request.contextPath}/manage/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${request.contextPath}/manage/js/bootstrap.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${request.contextPath}/manage/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
        });
    });
</script>
</body>
</html>
