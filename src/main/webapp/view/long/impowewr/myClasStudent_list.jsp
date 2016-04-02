<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
</head>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:36px;	/*设置td高度*/
		width: 50%;		/*设置td宽度*/
	}
	
	input{
		height:30px;	/*设置td高度*/
		width: 80px;		/*设置td宽度*/
		font-size: 16px;
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>

<!-- 去掉a标签下面的下划线 -->
<style>a{TEXT-DECORATION:none}</style>

<script type="text/javascript">

	function load(){		
		var authority=document.getElementById("span").innerHTML;
		
		if(authority=="8"){
			document.getElementById("td").innerHTML="学生";
		}
		else if(authority=="6"){
			document.getElementById("td").innerHTML="班评学生";
		}
		else if(authority=="5"){
			document.getElementById("td").innerHTML="班长";
		}
		else if(authority=="3"){
			document.getElementById("td").innerHTML="系评学生";
		}
	}
</script>

<body onload="load()">
	<table align="center" border="1" width="60%">
		<caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >授权页面</caption>
		<tr>
			<th>学号</th>
			<td>${student.stuid }</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td>${student.name }</td>
		</tr>
		<tr>
			<th>性别</th>
			<td>${student.sex}</td>
		</tr>
		<tr>
			<th>年龄</th>
			<td>${student.age}</td>
		</tr>
		<tr>
			<th>专业</th>
			<td>${student.major }</td>
		</tr>
		<tr>
			<th>班级</th>
			<td>${student.clas }</td>
		</tr>
		<tr>
			<th>身份</th>
			<td id="td"></td>
		</tr>
		<span style="visibility: hidden;" id="span" >${authority }</span>
			
		<tr>
			<td colspan="2">				
				<a href="${pageContext.request.contextPath }/ImpowerServlet?method=impowerToBpstu&stuid=${student.stuid }&authority=${authority }">
					<input type="button" value="班评学生">
				</a>&nbsp;
				<a href="${pageContext.request.contextPath }/ImpowerServlet?method=listMyClasStudents">
					<input type="button" value="返回">
				</a>&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>