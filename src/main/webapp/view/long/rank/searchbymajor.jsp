<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询专业生成评优报表</title>
</head>
<body>
	<h3 align="center">根据专业生成评优报表</h3>
	<div align="center">
		<form action="${pageContext.request.contextPath}/RankingServlet?method=DbToExcel" method="post">
			专业：<input type="text" name="major">
			<input type="submit" value="生成报表">
		</form>
	</div>
</body>
</html>