<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="basepath.jsp" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <base href="<%= base %>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>${title}</title>

    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Custom styles for this template -->
    <link href="static/css/xland.common.css" rel="stylesheet">
  </head>
  <body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-mini navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button><c:url value='/' var='HOME_PATH' />
				<a class="navbar-brand" href="${HOME_PATH}">学之问</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${HOME_PATH}"><spring:message code="main.home" /></a></li>
					<li><a href="${HOME_PATH}login">登录</a></li>
					<li><a href="${HOME_PATH}register">注册</a></li>
					<li><a href="${HOME_PATH}about">关于我</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div class="container">
