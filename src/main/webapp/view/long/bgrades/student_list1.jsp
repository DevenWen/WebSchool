<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生综合测评班评评分表</title>
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
</style>  

</head>

<body>
	<center><h3>班评的同学名单</h3></center>
	 <table align="center" border="1" width="700px">
    	<tr>
    		<th>编号</th>
    		<th>学号</th>
    		<th>姓名</th>
    		<th>专业</th>
    		<th>班级</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${students}" var="stu" varStatus="varSta">
    		<tr>
    			<td>${varSta.count }</td>
    			<td>${stu.stuid}</td>
    			<td>${stu.name }</td>
		        <td>${stu.major }</td>
		        <td>${stu.clas }</td>
		        <td>
		        	<a href="${pageContext.request.contextPath }/BGradesServlet?method=listBGrades&gradingtype=班评&stuid=${stu.stuid}&name=${stu.name}&clas=${stu.clas}">评分</a>&nbsp;
		        </td>
    		</tr>
    	</c:forEach>
    </table>
</body>
</html>