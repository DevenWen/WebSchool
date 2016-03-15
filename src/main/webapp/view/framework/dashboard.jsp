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

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	/*获取用户信息和对应该权限的控制台实体信息，这个.jsp将会把这个控制台信息翻译过来，形成页面*/
  	LoginUser user = (LoginUser)request.getSession().getAttribute(LoginUser.class.getName());
  	//out.write(user.toString());
  	DashboardEntry entry = DashboardFactory.getInstance().getDashboardEntry(user.getAuthority());
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><%="WebSchool-"+user.getName()+"-控制台" %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/view/common/head.jsp"></jsp:include>
	
	<!-- 框架CSS  -->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/dashboard.css">
  </head>
  
  
  
  <body>
  	<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <a class="navbar-brand" href="#">
          	<span class="<%=entry.getIcon()%>" ></span>
         	 WebSchool
          </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        
          <ul class="nav navbar-nav navbar-left">
          	<!-- 作为扩展点 -->
          	<%for (TopNarPoint point : entry.getTopkids()){ %>
          	
          		<li><a href="<%=point.getUrl() %>">
          		<%if(StringUtils.isNotBlank(point.getIcon())){
          			out.write("<span class=\""+point.getIcon()+"\"></span>");
          		}%>
          		<%=point.getTitle() %>
          		</a>
          	<%} %>
          	
          </ul>
        
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">欢迎你，<%=user.getName() %></a></li>
            
            
            <!-- a调用一个js方法，ajax登出系统 -->
            <li><a href="<%=path %>/user/logout.action">退出系统</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          			<!-- 扩展侧边下拉框 -->
          			<%
          				Barpoint root = new Barpoint();
          				root.setType("root");
          				root.setTitle("parent");
          				//把实体中的侧边下拉框提供一个根，使之成为一个树，然后再使用中序遍历对树进行构造
          				for (Barpoint point : entry.getSidekids()){
							root.getKids().add(point);
          				}
          				//下面是构建
          				DashBoardHtmlUtil.printSaidBar(root, out);
          			 %>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        	<iframe id="mainiframe" frameborder="0" scrolling="no" width="100%" height="100%" src=""></iframe>
        </div>
      </div>
    </div>
  </body>
  
  <script src="<%=path %>/js/dashborad.js"></script>
  
</html>
