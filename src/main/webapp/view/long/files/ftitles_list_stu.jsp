<%@ page language="java" import="java.text.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生页面文件标题显示</title>
<style type="text/css">	
	table td,th{		
		/*文字居中*/
		text-align:center;	
		height:35px;	/*设置td高度*/
		width: 50%;		/*设置td宽度*/
	}
</style>  

</head>

<body>
	<table align="center" width="80%">
        <tr>
    		<th>标题</th>
    		<th>日期</th>
  		</tr>
   		<c:choose>
 			<c:when test="${not empty requestScope.files}">
		    	<c:forEach items="${requestScope.files}" var="fs" varStatus="varSta">
		    		<tr>
		    			<td><a href="${pageContext.request.contextPath }/FilesServlet?method=down&title=${fs.title}">${fs.title }</a></td>
		    			<td>
		    				<fmt:formatDate type="both" value="${fs.time}"/>		    				
		    			</td>
		    		</tr>
		    	</c:forEach>
	    	</c:when>
 			<c:otherwise>
 				<tr>
 					<td colspan="3" align="center">对不起，没有你要找的数据</td>
 				</tr>
 			</c:otherwise>
 		</c:choose>
    </table>
	
</body>
</html>