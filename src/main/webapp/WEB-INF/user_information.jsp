<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta charset="utf-8" />
	<title>Webarch - Responsive Admin Dashboard</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta content="" name="description" />
	<meta content="" name="author" />

	<!-- BEGIN PLUGIN CSS -->
	<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="assets/plugins/jquery-nestable/jquery.nestable.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PLUGIN CSS -->
	<!-- BEGIN CORE CSS FRAMEWORK -->
	<link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="assets/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
	<link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
	<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css"/>
	<!-- END CORE CSS FRAMEWORK -->

	<!-- BEGIN CSS TEMPLATE -->
	<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/responsive.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/large_screen_tweak.css" rel="stylesheet" type="text/css"/>
	<link href="assets/css/custom-icon-set.css" rel="stylesheet" type="text/css"/>
	<link href="use_info.css" rel="stylesheet" type="text/css"/>
	<!-- END CSS TEMPLATE -->
</head>
	<!-- END HEAD -->
	<!-- BEGIN BODY -->
<body class="">

	<!-- BEGIN 头部 -->
	<div class="header navbar navbar-inverse ">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="header-seperation" style="display:none">
				<ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">
					<li class="dropdown">
						<a id="main-menu-toggle" href="#main-menu"  class="" >
							<div class="iconset top-menu-toggle-white"></div>
						</a>
					</li>
				</ul>
				<!-- BEGIN LOGO -->
				<a href="index.html">
					<img src="assets/img/logo.png" class="logo" alt=""  data-src="assets/img/logo.png" data-src-retina="assets/img/logo2x.png" width="106" height="21"/>
				</a>
				<!-- END LOGO -->
				<ul class="nav pull-right notifcation-center">
					<li class="dropdown" id="header_task_bar">
						<a href="index.html" class="dropdown-toggle active" data-toggle="">
							<div class="iconset top-home"></div>
						</a>
					</li>
					<li class="dropdown" id="header_inbox_bar" >
						<a href="email.html" class="dropdown-toggle" >
							<div class="iconset top-messages"></div>
							<span class="badge" id="msgs-badge">2</span>
						</a>
					</li>
					<li class="dropdown" id="portrait-chat-toggler" style="display:none">
						<a href="#sidr" class="chat-menu-toggle">
							<div class="iconset top-chat-white "></div>
						</a>
					</li>
				</ul>
			</div>
			<!-- END RESPONSIVE MENU TOGGLER -->

			<!-- BEGIN 顶部导航栏 -->
			<div class="header-quick-nav" >
				<!-- BEGIN 顶部导航栏左侧 -->
				<div class="pull-left">
					<ul class="nav quick-section">
						<li class="quicklinks">
							<a href="#" class="" id="layout-condensed-toggle" >
								<div class="iconset top-menu-toggle-dark"></div>
							</a>
						</li>
					</ul>
					<ul class="nav quick-section">
						<li class="quicklinks">
							<a href="#" class="" >
								<div class="iconset top-reload"></div>
							</a>
						</li>
						<li class="quicklinks">
							<span class="h-seperate"></span>
						</li>
						<li class="quicklinks">
							<a href="#" class="" >
								<div class="iconset top-tiles"></div>
							</a>
						</li>
						<li class="m-r-10 input-prepend inside search-form no-boarder">
							<span class="add-on">
								<span class="iconset top-search"></span>
							</span>
							<input name="" type="text"  class="no-boarder " placeholder="Search Dashboard" style="width:250px;"></li>
					</ul>
				</div>
				<!-- END BEGIN 顶部导航栏左侧 -->

				<!-- BEGIN 聊天窗口 -->
				<div class="pull-right">
					<div class="chat-toggler">
						<a href="#" class="dropdown-toggle" id="my-task-list" data-placement="bottom"  data-content='' data-toggle="dropdown" data-original-title="Notifications">
							<div class="user-details">
								<div class="username">
									<span class="badge badge-important">3</span>
									<span class="bold" id="top-logo-username">邓金德</span>
								</div>
							</div>
							<div class="iconset top-down-arrow"></div>
						</a>
						<div id="notification-list" style="display:none">
							<div style="width:300px">
								<div class="notification-messages info">
									<div class="user-profile">
										<img src="assets/img/profiles/avatar_small.jpg"  alt="" data-src="assets/img/profiles/avatar_small.jpg" data-src-retina="assets/img/profiles/avatar_small2x.jpg" width="35" height="35" />
									</div>
									<div class="message-wrapper">
										<div class="heading">David Nester - Commented on your wall</div>
										<div class="description">Meeting postponed to tomorrow</div>
										<div class="date pull-left">A min ago</div>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="notification-messages danger">
									<div class="iconholder"> <i class="icon-warning-sign"></i>
									</div>
									<div class="message-wrapper">
										<div class="heading">Server load limited</div>
										<div class="description">Database server has reached its daily capicity</div>
										<div class="date pull-left">2 mins ago</div>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="notification-messages success">
									<div class="user-profile">
										<img src="assets/img/profiles/h.jpg"  alt="" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" width="35" height="35"></div>
									<div class="message-wrapper">
										<div class="heading">You haveve got 150 messages</div>
										<div class="description">150 newly unread messages in your inbox</div>
										<div class="date pull-left">An hour ago</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
						<div class="top-use-tou">
							<span style="font-family: Microsoft Yahei;font-size:15pt;color:#FFFFFF;position:relative;top:2px;left:4px" id="small-tou"></span>
						</div>
					</div>
					<ul class="nav quick-section ">
						<li class="quicklinks">
							<a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">
								<div class="iconset top-settings-dark "></div>
							</a>
							<ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
								<li>
									<a href="user-profile.html">My Account</a>
								</li>
								<li>
									<a href="calender.html">My Calendar</a>
								</li>
								<li>
									<a href="email.html">
										My Inbox&nbsp;&nbsp;
										<span class="badge badge-important animated bounceIn">2</span>
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="login.html"> <i class="fa fa-power-off"></i>
										&nbsp;&nbsp;Log Out
									</a>
								</li>
							</ul>
						</li>
						<li class="quicklinks">
							<span class="h-seperate"></span>
						</li>
						<li class="quicklinks">
							<a id="chat-menu-toggle" href="#sidr" class="chat-menu-toggle" >
								<div class="iconset top-chat-dark ">
									<span class="badge badge-important hide" id="chat-message-count">1</span>
								</div>
							</a>
							<div class="simple-chat-popup chat-menu-toggle hide" >
								<div class="simple-chat-popup-arrow"></div>
								<div class="simple-chat-popup-inner">
									<div style="width:100px">
										<div class="semi-bold">David Nester</div>
										<div class="message">Hey you there</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<!-- END 聊天窗口 -->
			</div>
			<!-- END 顶部导航栏 -->
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END 头部-->

	<!-- BEGIN CONTAINER开始 -->
	<div class="page-container row">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar mini" id="main-menu">
			<div class="page-sidebar-wrapper scrollbar-dynamic" id="main-menu-wrapper">
				<!-- BEGIN MINI-PROFILE -->
				<div class="user-info-wrapper">
					<div class="profile-wrapper">
						<img src="assets/img/profiles/avatar.jpg"  alt="" data-src="assets/img/profiles/avatar.jpg" data-src-retina="assets/img/profiles/avatar2x.jpg" width="69" height="69" />
					</div>
					<div class="user-info">
						<div class="greeting">Welcome</div>
						<div class="username">
							John
							<span class="semi-bold">Smith</span>
						</div>
						<div class="status">
							Status
							<a href="#">
								<div class="status-icon green"></div>
								Online
							</a>
						</div>
					</div>
				</div>
				<!-- END MINI-PROFILE -->

				<!-- BEGIN SIDEBAR MENU -->
				<p class="menu-title">
					BROWSE
					<span class="pull-right">
						<a href="javascript:;">
							<i class="fa fa-refresh"></i>
						</a>
					</span>
				</p>
				<ul>
					<li class="start ">
						<a href="index.html">
							<i class="icon-custom-home"></i>
							<span class="title">Dashboard</span>
							<span class="selected"></span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="dashboard_v1.html">Dashboard v1</a>
							</li>
							<li class="">
								<a href="index.html ">
									Dashboard v2
									<span class=" label label-info pull-right m-r-30">NEW</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="widgets.html">
							<i class="fa fa-th"></i>
							<span class="title">Widgets</span>
							<span class="label label-important pull-right ">HOT</span>
						</a>
					</li>
					<li class="">
						<a href="email.html">
							<i class="fa fa-envelope"></i>
							<span class="title">Email</span>
							<span class=" badge badge-disable pull-right ">203</span>
						</a>
					</li>
					<li class="">
						<a href="../../frontend/index.html">
							<i class="fa fa-flag"></i>
							<span class="title">Frontend</span>
						</a>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="fa fa fa-adjust"></i>
							<span class="title">Themes</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="theme_coporate.html">Coporate</a>
							</li>
							<li >
								<a href="theme_simple.html">Simple</a>
							</li>
							<li >
								<a href="theme_elegant.html">Elegant</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="fa fa-file-text"></i>
							<span class="title">Layouts</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="layout_options.html">Layout Options</a>
							</li>
							<li >
								<a href="boxed_layout.html">Boxed Layout</a>
							</li>
							<li >
								<a href="boxed_layout_v2.html">Inner Boxed Layout</a>
							</li>
							<li >
								<a href="extended_layout.html">Extended Layout</a>
							</li>
							<li >
								<a href="RTL.html">RTL Layout</a>
							</li>
							<li >
								<a href="horizontal_menu.html">Horizontal Menu</a>
							</li>
							<li >
								<a href="horizontal_menu_boxed.html">Horizontal Menu & Boxed</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-ui"></i>
							<span class="title">UI Elements</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="typography.html">Typography</a>
							</li>
							<li >
								<a href="messages_notifications.html">Messages & Notifications</a>
							</li>
							<li >
								<a href="notifications.html">Notifications</a>
							</li>
							<li >
								<a href="icons.html">Icons</a>
							</li>
							<li >
								<a href="buttons.html">Buttons</a>
							</li>
							<li >
								<a href="tabs_accordian.html">Tabs & Accordions</a>
							</li>
							<li >
								<a href="sliders.html">Sliders</a>
							</li>
							<li >
								<a href="group_list.html">Group list</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-form"></i>
							<span class="title">Forms</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="form_elements.html">Form Elements</a>
							</li>
							<li >
								<a href="form_validations.html">Form Validations</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-portlets"></i>
							<span class="title">Grids</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="grids_simple.html">Simple Grids</a>
							</li>
							<li >
								<a href="grids_draggable.html">Draggable Grids</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-thumb"></i>
							<span class="title">Tables</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="tables.html">Basic Tables</a>
							</li>
							<li >
								<a href="datatables.html">Data Tables</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-map"></i>
							<span class="title">Maps</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="google_map.html">Google Maps</a>
							</li>
							<li >
								<a href="vector_map.html">Vector Maps</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="charts.html">
							<i class="icon-custom-chart"></i>
							<span class="title">Charts</span>
						</a>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="icon-custom-extra"></i>
							<span class="title">Extra</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="user-profile.html">User Profile</a>
							</li>
							<li >
								<a href="time_line.html">Time line</a>
							</li>
							<li >
								<a href="support_ticket.html">Support Ticket</a>
							</li>
							<li >
								<a href="gallery.html">Gallery</a>
							</li>
							<li class="">
								<a href="calender.html">Calendar</a>
							</li>
							<li >
								<a href="search_results.html">Search Results</a>
							</li>
							<li >
								<a href="invoice.html">Invoice</a>
							</li>
							<li >
								<a href="404.html">404 Page</a>
							</li>
							<li >
								<a href="500.html">500 Page</a>
							</li>
							<li >
								<a href="blank_template.html">Blank Page</a>
							</li>
							<li >
								<a href="login.html">Login</a>
							</li>
							<li >
								<a href="login_v2.html">Login v2</a>
							</li>
							<li >
								<a href="lockscreen.html">Lockscreen</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="javascript:;">
							<i class="fa fa-folder-open"></i>
							<span class="title">Menu Levels</span>
							<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li >
								<a href="javascript:;">Level 1</a>
							</li>
							<li >
								<a href="javascript:;">
									<span class="title">Level 2</span>
									<span class="arrow "></span>
								</a>
								<ul class="sub-menu">
									<li >
										<a href="javascript:;">Sub Menu</a>
									</li>
									<li >
										<a href="ujavascript:;">Sub Menu</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<li class="hidden-lg hidden-md hidden-xs" id="more-widgets" >
						<a href="javascript:;">
							<i class="fa fa-plus"></i>
						</a>
						<ul class="sub-menu">
							<li class="side-bar-widgets">
								<p class="menu-title">
									FOLDER
									<span class="pull-right">
										<a href="#" class="create-folder">
											<i class="icon-plus"></i>
										</a>
									</span>
								</p>
								<ul class="folders" >
									<li>
										<a href="#">
											<div class="status-icon green"></div>
											My quick tasks
										</a>
									</li>
									<li>
										<a href="#">
											<div class="status-icon red"></div>
											To do list
										</a>
									</li>
									<li>
										<a href="#">
											<div class="status-icon blue"></div>
											Projects
										</a>
									</li>
									<li class="folder-input" style="display:none">
										<input type="text" placeholder="Name of folder" class="no-boarder folder-name" name="" id="folder-name"></li>
								</ul>
								<p class="menu-title">PROJECTS</p>
								<div class="status-widget">
									<div class="status-widget-wrapper">
										<div class="title">
											Freelancer
											<a href="#" class="remove-widget">
												<i class="icon-custom-cross"></i>
											</a>
										</div>
										<p>Redesign home page</p>
									</div>
								</div>
								<div class="status-widget">
									<div class="status-widget-wrapper">
										<div class="title">
											envato
											<a href="#" class="remove-widget">
												<i class="icon-custom-cross"></i>
											</a>
										</div>
										<p>Statistical report</p>
									</div>
								</div>
							</li>
						</ul>
					</li>
				</ul>
				<div class="side-bar-widgets">
					<p class="menu-title">
						FOLDER
						<span class="pull-right">
							<a href="#" class="create-folder">
								<i class="fa fa-plus"></i>
							</a>
						</span>
					</p>
					<ul class="folders" >
						<li>
							<a href="#">
								<div class="status-icon green"></div>
								My quick tasks
							</a>
						</li>
						<li>
							<a href="#">
								<div class="status-icon red"></div>
								To do list
							</a>
						</li>
						<li>
							<a href="#">
								<div class="status-icon blue"></div>
								Projects
							</a>
						</li>
						<li class="folder-input" style="display:none">
							<input type="text" placeholder="Name of folder" class="no-boarder folder-name" name="" ></li>
					</ul>
					<p class="menu-title">PROJECTS</p>
					<div class="status-widget">
						<div class="status-widget-wrapper">
							<div class="title">
								Freelancer
								<a href="#" class="remove-widget">
									<i class="icon-custom-cross"></i>
								</a>
							</div>
							<p>Redesign home page</p>
						</div>
					</div>
					<div class="status-widget">
						<div class="status-widget-wrapper">
							<div class="title">
								envato
								<a href="#" class="remove-widget">
									<i class="icon-custom-cross"></i>
								</a>
							</div>
							<p>Statistical report</p>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<a href="#" class="scrollup ">Scroll</a>
		<!-- END SIDEBAR -->


		<!-- BEGIN 中间部分page-->
		<div class="page-content condensed">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">Widget settings form goes here</div>
			</div>
			<div class="clearfix"></div>
			<div class="content">
				<div class="row">
					<!--start中间左侧内容-->
					<div class="col-md-6">
						<div class=" tiles white col-md-12 no-padding">
							<div class="tiles green cover-pic-wrapper">
								<div class="overlayer bottom-right">
									<div class="overlayer-wrapper">
										<div class="padding-10 hidden-xs">
											<button type="button" class="btn btn-primary btn-small" id="edit_info">
												<i class="fa fa-check"></i>
												&nbsp;&nbsp;编辑信息
											</button>
											<button type="button" class="btn btn-primary btn-small">帮助</button>
										</div>
									</div>
								</div>
								<img src="assets/img/cover_pic.png" alt="">
							</div>
							<div class="tiles white">
								<div class="row animated fadeInUp" id="info-display">
									<div class="col-md-3 col-sm-3" >
										<div class="user-profile-pic">
											<img width="69" height="69">
											<span style="font-family: Microsoft Yahei;font-size:20pt;position:relative;left:-52px;top:5px" id="logo_username"></span>
										</div>
										<div class="user-mini-description">
											<h3 class="text-success semi-bold" id="login_name">孔罗星</h3>
											<h5>用户名</h5>
											<h3 class="text-success semi-bold" id="ass_user_id">457</h3>
											<h5>ASS_ID</h5>
										</div>
									</div>
									<div class="col-md-5 user-description-box  col-sm-5">
										<h3 class="text-success semi-bold">用户详细信息</h3>
										<br>
										<p>
											<i class="fa fa-user"></i>
											<span id="x_username">登录名：</span>
											<span id="x_username">金德</span>
										</p>
										<p>
											<i class="fa fa-globe"></i>
											<span id="x_username">状态：</span>
											<span id="x_status">在线</span>
										</p>
										<p>
											<i class="fa fa-file-o"></i>
											<span id="x_username">用户类型：</span>
											<span id="x_usertype">单位用户</span>
										</p>
										<p>
											<i class="fa fa-male"></i>
											<span id="x_username">性别：</span>
											<span id="x_status">男</span>
										</p>
										<p>
											<i class="fa fa-phone-square"></i>
											<span id="x_username">办公电话：</span>
											<span id="x_usertype">0591-68686868</span>
										</p>
										<p>
											<i class="fa fa-envelope"></i>
											<span id="x_username">邮箱：</span>
											<span id="x_usertype">AronJ@gmail.com</span>
										</p>
										<p>
											<i class="fa fa-phone"></i>
											<span id="x_username">手机号码：</span>
											<span id="x_usertype">18655960698</span>
										</p>
										<p>
											<i class="fa fa-pencil"></i>
											<span id="x_username">创建时间：</span>
											<span id="x_usertype">2014-11-05</span>
										</p>

									</div>
									<div class="col-md-3  col-sm-3">
										<h5 class="normal">
											同组成员 (
											<span class="text-success">1223</span>
											)
										</h5>
										<ul class="my-friends">
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/d2x.jpg" data-src="assets/img/profiles/d.jpg" src="assets/img/profiles/d.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/c2x.jpg" data-src="assets/img/profiles/c.jpg" src="assets/img/profiles/c.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/h2x.jpg" data-src="assets/img/profiles/h.jpg" src="assets/img/profiles/h.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/avatar_small2x.jpg" data-src="assets/img/profiles/avatar_small.jpg" src="assets/img/profiles/avatar_small.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/e2x.jpg" data-src="assets/img/profiles/e.jpg" src="assets/img/profiles/e.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/b2x.jpg" data-src="assets/img/profiles/b.jpg" src="assets/img/profiles/b.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/h2x.jpg" data-src="assets/img/profiles/h.jpg" src="assets/img/profiles/h.jpg" alt=""></div>
											</li>
											<li>
												<div class="profile-pic">
													<img width="35" height="35" data-src-retina="assets/img/profiles/d2x.jpg" data-src="assets/img/profiles/d.jpg" src="assets/img/profiles/d.jpg" alt=""></div>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>
								</div>
								<!--begin修改个人信息div-->
								<div class="tiles-body  animated fadeInUp" id="info-jk" style="display:none">
									<div class="row">
										<div class="post col-md-12">
											<div class="user-profile-pic-wrapper">
												<div class="user-profile-pic">
													<img width="69" height="69">												
													<span style="font-family: Microsoft Yahei;font-size:20pt;position:relative;left:-52px;top:5px" id="update_logo_username"></span>
												</div>
											</div>
											<div class="info-wrapper">
												<div class="username">
													<span class="dark-text" style="font-family:Mricosoft Yahei;font-size:15pt;">用户信息的修改</span>
												</div>
												<div class="info">
													<span class="dark-text">用户上次修改信息的时间</span>
												</div>
												<div class="more-details">
													<ul class="post-links">
														<li>
															<a href="#" class="muted" id="last-update-time">2014年11月4日</a>
														</li>
														<li>
															<a href="#" class="text-info">Collapse</a>
														</li>
														<li>
															<a href="#" class="text-info" >
																<i class="fa fa-reply"></i>
																Reply
															</a>
														</li>
														<li>
															<a href="#" class="text-warning">
																<i class="fa fa-star"></i>
																Favourited
															</a>
														</li>
														<li>
															<a href="#"  class="muted">More</a>
														</li>
													</ul>
												</div>
												<div class="clearfix"></div>
												<!--用户信息修改的表单-->
												<div class="post comments-section">
													<div class="info-wrapper">

													</div>
													
												</div>
												<!--用户信息修改的表单-->
											</div>
											<div class="clearfix"></div>
											<br>
											<br></div>
									</div>
								</div>
								<!--end修改个人信息div-->
							</div>
						</div>
					</div>
					<!--end中间左侧内容-->

					<!--start中间右侧内容-->
					<div class="col-md-6" style="margin-top:-80px">
						<div class="content">
							<div class="row">
							    <div  class="col-md-8 col-md-offset-1 col-sm-8 col-sm-offset-2" style="background:rgb(193,224,226);padding-top:5px">
							        <div class="col-md-5 col-sm-5">
							    		 <span style="font-family:Microsoft Yahei;font-size:18pt;">时间轴</span>
							    	</div>
							    	<div class="col-md-7 col-sm-7">
							    		<div class="cbp_tmicon primary animated bounceIn col-md-4 col-sm-4">
										 	<i class="fa fa-comments tooltip-tz" data-toggle="tooltip" data-placement="top" title="通知" style="font-size:20pt;color:rgb(251,176,94);cursor:pointer"></i>
										</div>
										<div class="cbp_tmicon primary animated bounceIn col-md-4 col-sm-4">
										 	<i class="fa fa-map-marker tooltip-hs" data-toggle="tooltip" data-placement="top"  title="登录历史" style="font-size:20pt;color:green;cursor:pointer"></i>
										</div>
										<div class="cbp_tmicon primary animated bounceIn col-md-4 col-sm-4">
										 	<i class="fa fa-desktop tooltip-cz" data-toggle="tooltip" data-placement="top" title="操作记录" style="font-size:20pt;color:black;cursor:pointer"></i>
										</div>
									</div>
							    </div>
							    <br>
								<div class="col-md-10 col-vlg-7">
									<ul class="cbp_tmtimeline">
										<li>
											<time class="cbp_tmtime" datetime="2013-04-10 18:30">
												<span class="date">今天</span>
												<span class="time">
													10:05
													<span class="semi-bold">am</span>
												</span>
											</time>
											<div class="cbp_tmicon primary animated bounceIn">
												<i class="fa fa-comments"></i>
											</div>
											<div class="cbp_tmlabel">
												<div class="p-t-10 p-l-30 p-r-20 p-b-20 xs-p-r-10 xs-p-l-10 xs-p-t-5">
													<h4 class="inline m-b-5">
														<span class="text-success semi-bold">金 德</span>
													</h4>
													<h5 class="inline muted semi-bold m-b-5">@系统通知</h5>
													<div class="muted">时间 - 12:45pm</div>
													<p class="m-t-5 dark-text">
														告警信息：1001: cpu使用率过高
													</p>
												</div>
												<div class="clearfix"></div>
												<div class="tiles grey p-t-10 p-b-10 p-l-20">
													<ul class="action-links">
														<li>Like</li>
														<li>Comment</li>
													</ul>
													<div class="clearfix"></div>
												</div>
											</div>
										</li>
										<li>
											<time class="cbp_tmtime" datetime="2013-04-10 18:30">
												<span class="date">昨天</span>
												<span class="time">
													8:45
													<span class="semi-bold">pm</span>
												</span>
											</time>
											<div class="cbp_tmicon success animated bounceIn">
												<i class="fa fa-map-marker"></i>
											</div>
											<div class="cbp_tmlabel">
												<div class="p-t-10 p-l-30 p-r-20 p-b-20 xs-p-r-10 xs-p-l-10 xs-p-t-5">
													<h4 class="inline m-b-5">
														<span class="text-success semi-bold">金 德</span>
													</h4>
													<h5 class="inline muted semi-bold m-b-5">@上次登录</h5>
													<div class="muted">时间 - 8:45pm</div>
												</div>
												<div id="map" class="" style="width:100%;height:250px"></div>
												<div class="clearfix"></div>
												<div class="tiles grey p-t-10 p-b-10 p-l-20">
													<ul class="action-links">
														<li>Like</li>
														<li>Comment</li>
													</ul>
													<div class="clearfix"></div>
												</div>
											</div>
										</li>

										<li>
											<time class="cbp_tmtime" datetime="2013-04-10 18:30">
												<span class="date">昨天</span>
												<span class="time">
													1:30
													<span class="semi-bold">pm</span>
												</span>
											</time>
											<div class="cbp_tmicon info animated bounceIn">
												<i class="fa fa-quote-left"></i>
											</div>
											<div class="cbp_tmlabel">
												<div class="p-t-10 p-l-30 p-r-20 p-b-20 xs-p-r-10 xs-p-l-10 xs-p-t-5">
													<h4 class="inline m-b-5">
														<span class="text-success semi-bold">金 德</span>
													</h4>
													<h5 class="inline muted semi-bold m-b-5">@操作记录</h5>
													<div class="muted">时间 - 8:45pm</div>
													<div class="m-t-5 dark-text">
														<h3 >
															<span class="semi-bold">修改了个人信息</span>
															Time Capsule` is  Finally Unearthed on
															<span class="semi-bold">Skyace News</span>
														</h3>
													</div>
												</div>
												<div class="clearfix"></div>
												<div class="tiles grey p-t-10 p-b-10 p-l-20">
													<ul class="action-links">
														<li>Like</li>
														<li>Comment</li>
													</ul>
													<div class="clearfix"></div>
												</div>
											</div>
										</li>
										<li>
											<time class="cbp_tmtime" datetime="2013-04-10 18:30">
												<span class="date">today</span>
												<span class="time">
													<span class="animate-number" data-value="12" data-animation-duration="600"></span>
													:
													<span class="animate-number" data-value="45" data-animation-duration="600"></span>
													<span class="semi-bold">pm</span>
												</span>
											</time>
											<div class="cbp_tmicon animated bounceIn">
												<div class="user-profile">
													<img src="assets/img/profiles/d.jpg" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35" alt=""></div>
											</div>
											<div class="cbp_tmlabel">
												<div class="p-t-10 p-l-30 p-r-20 p-b-20 xs-p-r-10 xs-p-l-10 xs-p-t-5">
													<h4 class="inline m-b-5">
														<span class="text-success semi-bold">Jane smith</span>
													</h4>
													<h5 class="inline muted semi-bold m-b-5">@johnsmith</h5>
													<div class="muted">Shared publicly - 12:45pm</div>
													<p class="m-t-5 dark-text">
														Painter Lucian Freud was also born on December 8th a few years later - in 1922. Here's his "Girl with Roses"
														<a href="#" class="text-primary">http://goo.gl/LWmNLq</a>
														...
													</p>
													<a href="#" class="muted">Read more(10 lines)</a>
												</div>
												<div class="m-l-10 m-r-10 xs-m-l-5 xs-m-r-5">
													<img src="assets/plugins/jquery-superbox/img/superbox/superbox-full-18.jpg" style="width:100%" alt=""></div>
												<div class="clearfix"></div>
												<div class="xs-p-r-10 xs-p-l-10 p-l-30 p-r-20 p-b-10 p-t-20 row">
													<div class="col-md-6">
														<h5 class="inline m-r-10">205 comments</h5>
														<h5 class="inline">21,586 People like this</h5>
													</div>
													<div class="col-md-6">
														<ul class="my-friends no-margin pull-right">
															<li>
																<div class="profile-pic">
																	<img width="35" height="35" data-src-retina="assets/img/profiles/e2x.jpg" data-src="assets/img/profiles/e.jpg" src="assets/img/profiles/e.jpg" alt=""></div>
															</li>
															<li>
																<div class="profile-pic">
																	<img width="35" height="35" data-src-retina="assets/img/profiles/b2x.jpg" data-src="assets/img/profiles/b.jpg" src="assets/img/profiles/b.jpg" alt=""></div>
															</li>
															<li>
																<div class="profile-pic">
																	<img width="35" height="35" data-src-retina="assets/img/profiles/h2x.jpg" data-src="assets/img/profiles/h.jpg" src="assets/img/profiles/h.jpg" alt=""></div>
															</li>
														</ul>
														<div class="clearfix"></div>
													</div>
												</div>
												<div class="tiles grey p-t-10 p-b-10 p-l-20">
													<ul class="action-links">
														<li>Like</li>
														<li>Comment</li>
													</ul>
													<div class="clearfix"></div>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!--end中间右侧内容-->

				</div>

			</div>
		</div>
		<!-- END 中间部分page -->

		<!-- BEGIN 聊天窗口 -->
		<div class="chat-window-wrapper">
			<div id="main-chat-wrapper" class="inner-content">
				<div class="chat-window-wrapper scroller scrollbar-dynamic" id="chat-users" >
					<div class="chat-header">
						<div class="pull-left">
							<input type="text" placeholder="search"></div>
						<div class="pull-right">
							<a href="#" class="" >
								<div class="iconset top-settings-dark "></div>
							</a>
						</div>
					</div>
					<div class="side-widget">
						<div class="side-widget-title">group chats</div>
						<div class="side-widget-content">
							<div id="groups-list">
								<ul class="groups" >
									<li>
										<a href="#">
											<div class="status-icon green"></div>
											Office work
										</a>
									</li>
									<li>
										<a href="#">
											<div class="status-icon green"></div>
											Personal vibes
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="side-widget fadeIn">
						<div class="side-widget-title">favourites</div>
						<div id="favourites-list">
							<div class="side-widget-content" >
								<div class="user-details-wrapper active" data-chat-status="online" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="Jane Smith">
									<div class="user-profile">
										<img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"></div>
									<div class="user-details">
										<div class="user-name">Jane Smith</div>
										<div class="user-more">Hello you there?</div>
									</div>
									<div class="user-details-status-wrapper">
										<span class="badge badge-important">3</span>
									</div>
									<div class="user-details-count-wrapper">
										<div class="status-icon green"></div>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="user-details-wrapper" data-chat-status="busy" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="David Nester">
									<div class="user-profile">
										<img src="assets/img/profiles/c.jpg"  alt="" data-src="assets/img/profiles/c.jpg" data-src-retina="assets/img/profiles/c2x.jpg" width="35" height="35"></div>
									<div class="user-details">
										<div class="user-name">David Nester</div>
										<div class="user-more">Busy, Do not disturb</div>
									</div>
									<div class="user-details-status-wrapper">
										<div class="clearfix"></div>
									</div>
									<div class="user-details-count-wrapper">
										<div class="status-icon red"></div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="side-widget">
						<div class="side-widget-title">more friends</div>
						<div class="side-widget-content" id="friends-list">
							<div class="user-details-wrapper" data-chat-status="online" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="Jane Smith">
								<div class="user-profile">
									<img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="user-name">Jane Smith</div>
									<div class="user-more">Hello you there?</div>
								</div>
								<div class="user-details-status-wrapper"></div>
								<div class="user-details-count-wrapper">
									<div class="status-icon green"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="user-details-wrapper" data-chat-status="busy" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="David Nester">
								<div class="user-profile">
									<img src="assets/img/profiles/h.jpg"  alt="" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="user-name">David Nester</div>
									<div class="user-more">Busy, Do not disturb</div>
								</div>
								<div class="user-details-status-wrapper">
									<div class="clearfix"></div>
								</div>
								<div class="user-details-count-wrapper">
									<div class="status-icon red"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="user-details-wrapper" data-chat-status="online" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="Jane Smith">
								<div class="user-profile">
									<img src="assets/img/profiles/c.jpg"  alt="" data-src="assets/img/profiles/c.jpg" data-src-retina="assets/img/profiles/c2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="user-name">Jane Smith</div>
									<div class="user-more">Hello you there?</div>
								</div>
								<div class="user-details-status-wrapper"></div>
								<div class="user-details-count-wrapper">
									<div class="status-icon green"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="user-details-wrapper" data-chat-status="busy" data-chat-user-pic="assets/img/profiles/d.jpg" data-chat-user-pic-retina="assets/img/profiles/d2x.jpg" data-user-name="David Nester">
								<div class="user-profile">
									<img src="assets/img/profiles/h.jpg"  alt="" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="user-name">David Nester</div>
									<div class="user-more">Busy, Do not disturb</div>
								</div>
								<div class="user-details-status-wrapper">
									<div class="clearfix"></div>
								</div>
								<div class="user-details-count-wrapper">
									<div class="status-icon red"></div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>

				<div class="chat-window-wrapper" id="messages-wrapper" style="display:none">
					<div class="chat-header">
						<div class="pull-left">
							<input type="text" placeholder="search"></div>
						<div class="pull-right">
							<a href="#" class="" >
								<div class="iconset top-settings-dark "></div>
							</a>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="chat-messages-header">
						<div class="status online"></div>
						<span class="semi-bold">Jane Smith(Typing..)</span>
						<a href="#" class="chat-back">
							<i class="icon-custom-cross"></i>
						</a>
					</div>
					<div class="chat-messages scrollbar-dynamic clearfix">
						<div class="inner-scroll-content clearfix">
							<div class="sent_time">Yesterday 11:25pm</div>
							<div class="user-details-wrapper " >
								<div class="user-profile">
									<img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="bubble">Hello, You there?</div>
								</div>
								<div class="clearfix"></div>
								<div class="sent_time off">Yesterday 11:25pm</div>
							</div>
							<div class="user-details-wrapper ">
								<div class="user-profile">
									<img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="bubble">How was the meeting?</div>
								</div>
								<div class="clearfix"></div>
								<div class="sent_time off">Yesterday 11:25pm</div>
							</div>
							<div class="user-details-wrapper ">
								<div class="user-profile">
									<img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"></div>
								<div class="user-details">
									<div class="bubble">Let me know when you free</div>
								</div>
								<div class="clearfix"></div>
								<div class="sent_time off">Yesterday 11:25pm</div>
							</div>
							<div class="sent_time ">Today 11:25pm</div>
							<div class="user-details-wrapper pull-right">
								<div class="user-details">
									<div class="bubble sender">Let me know when you free</div>
								</div>
								<div class="clearfix"></div>
								<div class="sent_time off">Sent On Tue, 2:45pm</div>
							</div>
						</div>
					</div>
					<div class="chat-input-wrapper" style="display:none">
						<textarea id="chat-message-input" rows="1" placeholder="Type your message"></textarea>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- END 聊天窗口 -->
	</div>
    <!-- END CONTAINER结束-->


	<!-- BEGIN CORE JS FRAMEWORK-->
	<script src="assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/plugins/breakpoints.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
	<!-- END CORE JS FRAMEWORK -->

	<!-- BEGIN PAGE LEVEL JS -->
	<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-block-ui/jqueryblockui.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src="assets/plugins/jquery-gmap/gmaps.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN CORE TEMPLATE JS -->
	<script src="assets/js/core.js" type="text/javascript"></script>
	<script src="assets/js/chat.js" type="text/javascript"></script>
	<script src="assets/js/demo.js" type="text/javascript"></script>
	<!-- END CORE TEMPLATE JS -->
	<script type="text/javascript">
		$(document).ready(function(){
			$(function () { $('.tooltip-tz').tooltip('hide');});
			$(function () { $('.tooltip-hs').tooltip('hide');});
			$(function () { $('.tooltip-cz').tooltip('hide');});

			window.onload=function(){

				var str=$("#login_name").text();
				$("#logo_username").text(str.substring(0,1));
				var strr=$("#top-logo-username").text();
				$("#small-tou").text(strr.substring(0,1));
			}

			var trag=false;
			$("#edit_info").click(function(){
				if(trag==false){
					$("#info-jk").css("display","block");
					$("#info-display").css("display","none");
					$(this).removeClass("btn-primary").addClass("btn-warning");
					$(this).text("保存");
					$("<i></i>").addClass("fa").addClass("fa-check").appendTo($("#edit_info"));
					var str=$("#login_name").text();
					$("#update_logo_username").text(str.substring(0,1));
					trag=true;
					
				}else{
					$("#info-jk").css("display","none");
					$("#info-display").css("display","block");
					$(this).removeClass("btn-warning").addClass("btn-primary");
					$(this).text("编辑信息");
					$("<i></i>").addClass("fa").addClass("fa-pencil-square-o").appendTo($("#edit_info"));
					trag=false;
				}	
				//location.href="#info-jk";
			})
		})
	</script>
</body>
</html>