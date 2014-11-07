<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
      <meta charset="utf-8" />
      <title>Oops|404 ERROR</title>
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
      <!-- END CSS TEMPLATE -->
      </head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-body no-top">
<div class="error-wrapper container">
      <div class="row">
           <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-offset-1 col-xs-10">
                <div class="error-container" >
                     <div class="error-main" style="font-family: Microsoft Yahei;">
                           <div class="error-number"> 404 </div>
                           <div class="error-description" > 我们似乎已经失去了你的云. </div>
                           <div class="error-description-mini"> 你要找的页面不在这里. </div>
                           <br>
                           <button class="btn btn-primary btn-cons" id="back-page" type="button" style=" font-family: Microsoft Yahei;">返回首页</button>
                     </div>
                </div>
          </div>
      </div>
</div>
<!-- END CONTAINER -->

<!-- BEGIN CORE JS FRAMEWORK-->
<script src="../../assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="../../assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/plugins/pace/pace.min.js" type="text/javascript"></script>
<script type="text/javascript">
     $(document).ready(function(){
           $("#back-page").click(function(){
                location.href="/";  
           }); 

          // function jump(count) {    
          //       window.setTimeout(function(){    
          //            count--;    
          //           if(count > 0) {    
          //               $('#num').text(count);    
          //               jump(count);    
          //           } else {    
          //               location.href="/";    
          //           }    
          //       }, 1000);    
          //   }    
          //   jump(5);    
     })
</script>
<!-- END CORE TEMPLATE JS -->

</body>
</html>
