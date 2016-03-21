<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:set var="ctx" value="<%=path %>" scope="request" />




<!-- *****************第三方 框架和插件 ****************************** -->
<!-- bootstrap V3 
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
-->
<!-- -->
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-theme.min.css">


<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
 


<!-- *********************我的JS和CSS文件*************************** -->
<link rel="stylesheet" type="text/css" href="<%=path %>/css/qpm.css">

<script type="text/javascript">
		//定义一些js的全局变量
		var ctx = '${ctx}';
</script>
