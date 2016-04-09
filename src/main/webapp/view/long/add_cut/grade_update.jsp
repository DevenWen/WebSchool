<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改学生的评分</title>
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
	<div align="center">
		学号：<span>${stuid}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<span>${name}</span><br><br>
	</div>
	<form action="${pageContext.request.contextPath }/AddandCutServlet?method=updateGrade&stuid=${stuid}" method="post">
		<table align="center" border="1px" width="60%">
			<tr>
				<td>评分类型</td>
				<td>
					<select name="type">
					   <option value="1">思想加分</option>
					   <option value="2">思想扣分</option>
					   <option value="3">学业加分</option>
					   <option value="4">学业扣分</option>
					   <option value="5">文体加分</option>
					   <option value="6">文体扣分</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>分值</td>
				<td>
					<input type="text" name="score">
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<input type="text" name="explains">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>