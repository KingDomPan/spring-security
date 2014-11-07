<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <!-- BEGIN HEAD -->
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Oops|登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN CORE CSS FRAMEWORK -->
    <link href="../../assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="../../assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../assets/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link href="../../assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
    <!-- END CORE CSS FRAMEWORK -->
    <!-- BEGIN CSS TEMPLATE -->
    <link href="../../assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../assets/css/responsive.css" rel="stylesheet" type="text/css"/>
    <link href="../../assets/css/custom-icon-set.css" rel="stylesheet" type="text/css"/>
    <link href="./login.css" rel="stylesheet" type="text/css"/>
    <!-- END CSS TEMPLATE -->
</head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
<body class="error-body no-top lazy"  data-original="../../assets/img/work.jpg"  style="background-image: url('../../assets/img/work.jpg')">
    <div class="container">

        <!--BEGIN ERROR-INFORMATION-->
        <c:if test="${not empty message}">
            <div class=" col-md-7 col-md-offset-2 error-info animated fadeInUp">
                <div class="alert alert-danger alert-dismissable style-error" >
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="false" style="position:relative;right:2px;">&times;</button>
                    <span id="error-inf" class="error-font">用户名或密码错误，请重新输入！！！</span>
                </div>
            </div>
        </c:if>
        <!--END ERROR-INFORMATION-->

        <!--BEGIN LOGIN_WINDOW-->
        <div class="row login-container animated fadeInUp">
            <div class="col-md-7 col-md-offset-2 tiles white no-padding">
                <div class="p-t-30 p-l-40 p-b-20 xs-p-t-10 xs-p-l-10 xs-p-b-10">
                    <h2 class="normal" style="font-family: Microsoft Yahei;">登录 Oops!</h2>
                    <br>
                    <p style="font-family: Microsoft Yahei;">
                        Oops! 让每个运维的每一天，都拥有灿烂的笑容
                        <br></p>
                </div>
                <div class="tiles grey p-t-20 p-b-20 text-black"  style="background:rgb(200,200,200)">
                    <form id="frm_login" class="animated fadeIn" action="/j_security_login" method="POST">
                        <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                            <div class="col-md-6 col-sm-6 ">
                                <input  name="username"  id="login_username"  type="text"   class="form-control" placeholder="用户名" style="font-family: Microsoft Yahei;"></div>
                            <div class="col-md-6 col-sm-6">
                                <input   name="password" id="login_pass"  type="password"  class="form-control" placeholder="密码" style="font-family: Microsoft Yahei;"></div>
                        </div>
                        <br>
                        <div class="row p-t-10 m-l-20 m-r-20 xs-m-l-10 xs-m-r-10" >
                            <div class="control-group  col-md-10">
                                <div class="checkbox checkbox check-success">
                                    <div class="col-md-3 col-sm-6">
                                        <input type="checkbox" id="checkbox1" name="remember_me" value="1">
                                        <label for="checkbox1" style="font-family: Microsoft Yahei;">记住我</label>
                                    </div>
                                    <div class="col-md-8 col-sm-6">
                                        <a href="#" style="font-family: Microsoft Yahei;">忘记密码?</a>
                                    </div>
                                    <div class="col-md-1 col-sm-6">
                                        <button type="submit" class="btn btn-primary btn-cons" id="login_toggle" style="font-family: Microsoft Yahei;">登  录</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--END LOGIN_WINDOW--> </div>

    <!-- BEGIN CORE JS FRAMEWORK-->
    <script src="../../assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/pace/pace.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/jquery-lazyload/jquery.lazyload.min.js" type="text/javascript"></script>
    <script src="./login_v2.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#login_username").focus();
          }
        })
    </script>
    <!-- END CORE TEMPLATE JS -->
</body>

</html>