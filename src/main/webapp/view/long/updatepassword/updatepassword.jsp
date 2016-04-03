<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>密码修改</title>

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
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>


</head>

<body>
	<h3 align="center">修改密码</h3>
	<form action="${pageContext.request.contextPath }/UpdatePasswordServlet?method=updatepassword" method="post">
		<table align="center" border="1px">
			<tr>
				<th>用户名</th>
				<td>${userName }</td>
			</tr>
			<tr>
				<th>旧密码</th>
				<td>
					<input type="password" name="oldpassword">
				</td>
			</tr>
			<tr>
				<th>新密码</th>
				<td>
					<input type="password" name="newpassword">
				</td>
			</tr>
			<tr>
				<th>再次确认新密码</th>
				<td>
					<input type="password" name="againnewpassword">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" style="width: 80px;height: 30px;font-size: 16px;" value="确认修改">
				</td>
			</tr>
		</table>
		<span style="color: red;" >${message}</span>

	</form>
</body>
</html>