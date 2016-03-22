<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">查询要系评的专业班级</h3>
	<form action="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&gradingtype=系评" method="post">
		<div align="center">
			班级：<input type="text" name="clas">
			<input type="submit" style="width: 80px;height: 30px;font-size: 16px;" value="查询">
		</div>
	</form>
</body>
</html>