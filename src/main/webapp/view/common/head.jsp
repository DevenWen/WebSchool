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
 


<!-- bootstrap V2 
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
-->
<!-- sco js插件  http://www.bootcss.com/p/sco.js/-->
<link rel="stylesheet" type="text/css" href="<%=path %>/css/sco/sco.message.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/sco/scojs.css">

<script src="<%=path %>/js/sco/sco.ajax.js"></script>
<script src="<%=path %>/js/sco/sco.collapse.js"></script>
<script src="<%=path %>/js/sco/sco.confirm.js"></script>
<script src="<%=path %>/js/sco/sco.countdown.js"></script>
<script src="<%=path %>/js/sco/sco.message.js"></script>
<script src="<%=path %>/js/sco/sco.modal.js"></script>
<script src="<%=path %>/js/sco/sco.panes.js"></script>
<script src="<%=path %>/js/sco/sco.tab.js"></script>
<script src="<%=path %>/js/sco/sco.tooltip.js"></script>
<script src="<%=path %>/js/sco/sco.valid.js"></script>

 


<!-- *********************我的JS和CSS文件*************************** -->
<link rel="stylesheet" type="text/css" href="<%=path %>/css/qpm.css">
<script type="text/javascript">
		//定义一些js的全局变量
		var ctx = '${ctx}';
</script>
<script src="<%=path %>/js/qpm.js"></script>

