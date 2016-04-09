<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>根据学号查询学生</title>

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
	<h3 align="center">根据学号查询学生</h3>
	<form action="${pageContext.request.contextPath }/AddandCutServlet?method=listStudentsByTeacher" method="post">
		<div align="center">
			学号：<input type="text" name="stuid_search">
			<input type="submit" style="width: 80px;height: 25px;font-size: 16px;" value="查询">
		</div>
		<br>
		<br>
	</form>
</body>
</html>