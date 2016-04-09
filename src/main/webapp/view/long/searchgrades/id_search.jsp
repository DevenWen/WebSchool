<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>根据学号查询综合测评分</title>

<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
		width: 12.5%;		/*设置td宽度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>  


</head>
<body>
	<h3 align="center">根据学号查询综合测评分</h3>
	<form action="${pageContext.request.contextPath }/SearchServlet?method=listById" method="post">
		<div align="center">
			学号：<input type="text" name="stuid" value="${stuid }">
			<input type="submit" style="width: 80px;height: 25px;font-size: 16px;" value="查询">
		</div>
		<br>
		<br>
	</form>
	<div id="div" >
		<table border="1" align="center" width="80%" id="tableid">
	  		<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>专业</th>
				<th>班级</th>
				<th>思想分</th>
				<th>学业分</th>
				<th>文体分</th>
				<th>综合分</th>
			</tr>	
			<c:choose>
	  			<c:when test="${not empty zg}">
		    		<tr>
		    			<td>${zg.stuid}</td>
		    			<td>${zg.name}</td>
				        <td>${zg.major} </td>
				        <td>${zg.clas}</td>
				        <td>
				        	<fmt:formatNumber type="number" value="${zg.sx_score}" maxFractionDigits="4"/>	
				        </td>
				        <td>
				        	<fmt:formatNumber type="number" value="${zg.xy_score}" maxFractionDigits="4"/>	
				        </td>
				        <td>
				        	<fmt:formatNumber type="number" value="${zg.wt_score}" maxFractionDigits="4"/>	
				        </td>
				        <td>
				        	<fmt:formatNumber type="number" value="${zg.zh_score}" maxFractionDigits="4"/>	
				        </td>
		    		</tr>	
			    	
			    </c:when>
	  			<c:otherwise>
	  				<tr>
	  					<td colspan="8">对不起，没有你要找的数据</td>
	  				</tr>
	  			</c:otherwise>
  			</c:choose> 	    	
 
		</table>
	</div>
</body>
</html>