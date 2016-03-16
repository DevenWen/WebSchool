<%@page import="com.cn.qpm.framework.util.DashBoardHtmlUtil"%>
<%@page import="com.cn.qpm.framework.dashboard.model.Barpoint"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.cn.qpm.framework.dashboard.model.TopNarPoint"%>
<%@page import="com.cn.qpm.framework.dashboard.model.DashboardFactory"%>
<%@page import="com.cn.qpm.framework.dashboard.model.DashboardEntry"%>
<%@page import="com.cn.qpm.usermanage.model.LoginUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Hello world</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/view/common/head.jsp"></jsp:include>
	
  </head>
  	<h1>jQuery扩展测试栏</h1>
  	<h1>jQuery扩展测试栏2</h1>
  	<script type="text/javascript">
  		//sco.js
  		$(function(){
  			$('h1').scojs_modal({
  			  title: '对象调用modal',
  			  content: "No, they're not"
  			});
  		});
  		
  		/*
  		$("h1").hide("fast",function(){
  		   alert("Animation Done.");
  		 });
  		*/
  		
  	</script>
  
  <body>
  
  </body>
  
  
</html>
