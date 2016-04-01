<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
	 <form action="${pageContext.request.contextPath }/FilesServlet?method=upload" method="post" enctype="multipart/form-data">
  	 	 <%--<input type="hidden" name="method" value="upload">--%>
  	 	 
  	 	 标题：<input type="text" name="title">  <br/>
  	 	文件：   <input type="file" name="file">   <br/>
  	 	
  	 	<input type="submit" value="提交">
   	 </form>
</body>
</html>