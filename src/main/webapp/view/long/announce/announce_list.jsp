<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>公告显示</title>
<style type="text/css">
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
		
</style>  

</head>

<body>
	<div align="center">
		<div style="width: 70%">
			<h3 align="center">${announce.title }</h3>
			<div align="right">${announce.announceman }</div>   <br>
		    <textarea rows="40" cols="100" name="content" readonly="readonly">${announce.content }</textarea>
		</div>
	</div>
</body>
</html>