<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>根据专业或班级查询综合评分</title>
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
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>  
</head>
<body>
	<h3 align="center">根据专业或班级查询综合测评分</h3>
	<form action="${pageContext.request.contextPath }/SearchServlet?method=listByMajorOrClas" method="post">
		<div align="center">
			专业：<input type="text" name="major" value="${major}">
			班级：<input type="text" name="clas" value="${clas}">
			<input type="submit" style="width: 80px;height: 25px;font-size: 16px;" value="查询">
		</div>
		<br>
		<br>
	</form>
	
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
  			<c:when test="${not empty requestScope.pb.pageData}">
		    	<c:forEach items="${requestScope.pb.pageData}" var="stu" varStatus="varSta">
		    		<tr>
		    			<td>${stu.stuid}</td>
		    			<td>${stu.name }</td>
				        <td>${stu.major }</td>
				        <td>${stu.clas }</td>
				        <td>${stu.sx_score}</td>
				        <td>${stu.xy_score}</td>
				        <td>${stu.wt_score}</td>
				        <td>${stu.zh_score}</td>
		    		</tr>
		    	</c:forEach>
		     </c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="8">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="8" align="center">
  				当前${requestScope.pb.currentPage }/${requestScope.pb.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/SearchServlet?method=listByMajorOrClas&major=${major }&clas=${clas }&currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/SearchServlet?method=listByMajorOrClas&major=${major }&clas=${clas }&currentPage=${requestScope.pb.currentPage-1}">上一页 </a>
  				<a href="${pageContext.request.contextPath }/SearchServlet?method=listByMajorOrClas&major=${major }&clas=${clas }&currentPage=${requestScope.pb.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/SearchServlet?method=listByMajorOrClas&major=${major }&clas=${clas }&currentPage=${requestScope.pb.totalPage}">末页</a>
  			</td>
  		</tr>
			
	</table>

</body>
</html>