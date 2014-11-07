<%@ page language="java" import="java.uitl.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta charset="utf-8" />
	<title>Oops|锁屏</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
     <meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN CORE CSS FRAMEWORK -->
	<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="assets/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
	<link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
	<!-- END CORE CSS FRAMEWORK -->
	<!-- BEGIN CSS TEMPLATE -->
	<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/responsive.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/custom-icon-set.css" rel="stylesheet" type="text/css"/>
	<!-- END CSS TEMPLATE -->
	<style type="text/css">
		body{
			overflow-x:hidden;
			overflow-y:hidden; 
		}
	</style>
	</head>
	<!-- END HEAD -->
	<!-- BEGIN BODY -->
<body class="error-body no-top">
<div class="container">
     <div class="lockscreen-wrapper animated  flipInX">
	      <div class="row ">
		      <div class="col-md-8 col-md-offset-4 col-sm-6 col-sm-offset-4 col-xs-offset-2">
			      <div class=" col-md-3 col-sm-8" style=""> 
			      	 <img style="width:136px;height:90px" src="assets/img/profiles/logo.png">
		           </div>
		           <div class="col-md-9'">
		           	<form class="user-form" action="/" method="post">
		           		 <div class="'col-md-6 ">
			   		 	      <h2 class="user" style="font-family: Microsoft Yahei;">AronJ <span class="semi-bold" >Deng</span></h2>
					 	      <input type="password" placeholder="密码"  style="font-family: Microsoft Yahei;"/>
					 	 </div>
					 	 <div class="''col-md-2 ">
					 	 	 <button type="submit" class="btn btn-primary " style="font-family: Microsoft Yahei;height:36px;width:37px"><i class="fa fa-unlock"></i></button>
					 	 </div>
		           	</form>
		           </div>
	           </div>
          </div>
     </div>
     <div id="push"></div>
</div>
<!-- END CONTAINER -->

<!-- BEGIN CORE JS FRAMEWORK-->
<script src="assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script> 
<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {  
	 $("img").unveil();
}); 
</script>

<!-- END CORE TEMPLATE JS -->
</body>
</html>