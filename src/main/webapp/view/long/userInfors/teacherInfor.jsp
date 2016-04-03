<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教职工信息</title>
</head>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
		width: 50%;		/*设置td宽度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>
<body>
	<table align="center" border="1" width="60%">
		<caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >个人信息</caption>
		<tr>
			<th>工号</th>
			<td>${teacher.teaid }</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td>${teacher.name }</td>
		</tr>
		<tr>
			<th>性别</th>
			<td>${teacher.sex}</td>
		</tr>
		<tr>
			<th>年龄</th>
			<td>${teacher.age}</td>
		</tr>
		<tr>
			<th>身份</th>
			<td>${teacher.position}</td>
		</tr>
	</table>
</body>
</html>