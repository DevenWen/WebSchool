<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>加扣分列表</title>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>

<!-- 去掉a标签下面的下划线 -->
<style>a{TEXT-DECORATION:none}</style>

</head>
<body>
	<div align="center">
		学号：<span>${stuid}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<span>${name}</span><br><br>
	</div>
	
	
	<table align="center" border="1" width="700px">
    	<tr>
    		<th>评分类型</th>
    		<c:choose>
    				<c:when test="${ac.type==1 }">
    					<td>思想加分</td>
    				</c:when>
    				<c:when test="${ac.type==2 }">
    					<td>思想扣分</td>
    				</c:when>
    				<c:when test="${ac.type==3 }">
    					<td>学业加分</td>
    				</c:when>
    				<c:when test="${ac.type==4 }">
    					<td>学业扣分</td>
    				</c:when>
    				<c:when test="${ac.type==5 }">
    					<td>文体加分</td>
    				</c:when>
    				<c:when test="${ac.type==6 }">
    					<td>文体扣分</td>
    				</c:when>
    			</c:choose>
    	</tr>
   		<tr>
   			<th>分值</th>
   			<td>${ac.score }</td>
   		</tr>
   		<tr>
    		<th>说明</th>
    		<td>${ac.explains }</td>
   		</tr>
   	
    	<tr>
     		<th>证明</th>	
    		<td>
    			<img width="400px" height="300px" src="${ac.pictureurl }">
    		</td>
    	</tr>
     	
     	<tr>
     		<td colspan="2" align="center">
     			<a href="${pageContext.request.contextPath }/AddandCutServlet?method=checkAddAndCut&id=${ac.id}&stuid=${stuid}&name=${name}">
               		<input type="button" style="width: 80px;height: 30px;font-size: 16px;" value="通过审核" />
               	</a>
               	<a href="${pageContext.request.contextPath }/AddandCutServlet?method=listAddAndCuts&stuid=${stuid}&name=${name}">
               		<input type="button" style="width: 80px;height: 30px;font-size: 16px;" value="返回" />
               	</a>
     		</td>
     	</tr>
    </table>
   
</body>
</html>