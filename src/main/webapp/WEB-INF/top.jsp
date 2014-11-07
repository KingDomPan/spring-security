	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
	  <head>
	    <base href="<%=basePath%>">
	    
	    <title>My JSP 'top.jsp' starting page</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="resource/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
   	    <link rel="stylesheet" type="text/css" href="resource/css/right.css">
        <script src="resource/js/jquery-1.11.1.min.js"></script>
        <script src="resource/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="resource/js/right.js"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/top.css">
		</head>
		
		<body>
			<div class="navbar navbar-fixed-top">
			
			<div class="navbar-header logo">
				<a class="navbar-brand" href="#">
					<img src="resource/image/logo2.png"/>
					<font class="logo-text" color="#B8EBA1" style="position:relative;top:-13px;margin-left:90px;">Data Center</font>
				</a>
				
			</div>
			<div class="nav_ul">
				<ul class="nav nav-pills" >
					<li>
						<a href="#" class="dropdown-toggle " data-toggle="dropdown" style="color:#ffffff;">监控</a>
						<ul class="dropdown-menu multi-level top-dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
			                <li><a href="#">监控1</a></li>
			                <li><a href="#">监控3333333332</a></li>
			                <li class="dropdown-submenu">
			                    <a tabindex="-1" href="#">监控3</a>
			                    <ul class="dropdown-menu">
			                        <li><a href="#">二级菜单</a></li>
			                        <li><a href="#">二级菜单</a></li>
	                    		</ul>
	                		</li>
			      		</ul>
					</li>
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color : #ffffff;">远程管理</a>
						<ul class="dropdown-menu">
			                <li><a href="#">远程控制台</a></li>
			      		</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color : #ffffff;">事件</a>
						<ul class="dropdown-menu">
			                <li><a href="#">远程控制台</a></li>
			      		</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#ffffff;">团队</a>
						<ul class="dropdown-menu">
			                <li><a href="#">远程控制台</a></li>
			      		</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#ffffff;">配置</a>
						<ul class="dropdown-menu">
			                <li><a href="#">远程控制台</a></li>
			      		</ul>
					</li>
				</ul>
			</div>
			<div class="top-right">
				<span class="login-email">konglx@ffcs.cn</span>
				<div class="btn-group setting-dropdown" id="nav_right">
					<button type="button" class="btn btn-default dropdown-toggle setting-btn" data-toggle="dropdown" data-toggle="tooltip" data-placement="bottom" title="设置菜单">
						<span class="glyphicon glyphicon-cog" style="margin-left:-10px;color:#FFFFFD;font-size:20px;"></span> 
						<span class="caret" style="margin-top:-8px;margin-left:2px;color:white;"></span>
	  				</button>
					<ul class="dropdown-menu setting-ul" role="menu">
		  				<li><a href="#">帮助</a></li>
		  				<li><a href="#">快捷键</a></li>
					    <li class="divider"></li>
					    <li><a href="#">联系我们</a></li>
					    <li><a href="#">账户设置</a></li>
					    <li class="divider"></li>
					    <li><a href="">退出</a></li>
		  			</ul>
				</div>
				<div class="question-sign-span">?</div>
			</div>
		</div>
		
	</body>
	</html>