<%@page import="cn.com.qpm.framework.util.ExceptionUtil"%>
<%@page import="cn.com.qpm.framework.context.WebSchoolContext"%>
<%@page import="cn.com.qpm.usermanage.model.LoginUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上方的导航栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/view/common/head.jsp" %>
	
  </head>
  <%
  	//String loginUser = request.getParameter("loginUser");
  	LoginUser user = WebSchoolContext.getCurrentUser();
  	if (user == null) {
  		ExceptionUtil.throwRuntimeException("不明登录用户！");
  	}
  	
   %>
  
  
  <body>
  	<!-- 设置导航栏 -->
  	
	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">WebSchool</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-left">
          	<li class="active"><a href="#">主页</a>
          	<li><a href="#">待定</a>
          	<li><a href="#">待定</a>
          	<li><a href="#">待定</a>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
  	
  </body>
</html>
