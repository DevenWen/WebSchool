<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>加扣分列表</title>
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
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>



</head>
<body>
	<div align="center">
		学号：<span>${stuid}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<span>${name}</span><br><br>
	</div>
	<table align="center" border="1" width="700px">
    	<tr>
    		<th>编号</th>
    		<th>评分类型</th>
    		<th>分值</th>
    		<th>操作</th>
    	</tr>
    	<c:choose>
    		<c:when test="${not empty addandcuts}">
		    	<c:forEach items="${addandcuts}" var="ac" varStatus="varSta">
		    		<tr>
		    			<td>${varSta.count }</td>
		    			<c:choose>
		    				<c:when test="${ac.type==1 }">
		    					<td>思想加分</td>
		    				</c:when>
		    				<c:when test="${ac.type==2 }">
		    					<td>思想扣分</td>
		    				</c:when>
		    				<c:when test="${ac.type==3 }">
		    					<td>学业加分</td>
		    				</c:when>
		    				<c:when test="${ac.type==4 }">
		    					<td>学业扣分</td>
		    				</c:when>
		    				<c:when test="${ac.type==5 }">
		    					<td>文体加分</td>
		    				</c:when>
		    				<c:when test="${ac.type==6 }">
		    					<td>文体扣分</td>
		    				</c:when>
		    			</c:choose>			
		    			<td>${ac.score }</td>
		    			<c:choose>
					       	<c:when test="${ac.checked==1}">
					       		<td>已审核</td>
					       	</c:when>
					        <c:otherwise>
					        	<td>
					        		<a href="${pageContext.request.contextPath }/AddandCutServlet?method=listAddAndCut&stuid=${stuid}&name=${name}&id=${ac.id}">审核</a>&nbsp;
					        	</td>
					        </c:otherwise>
					    </c:choose>
		    		</tr>
		    	</c:forEach>
		    </c:when>
		    <c:otherwise>
		    	<tr>
		    		<td colspan="4">对不起，没有你要找的数据!</td>
		    	</tr>
		    </c:otherwise>
    </c:choose>	
    	<tr>
	    	<td colspan="4">
	    		<a href="${pageContext.request.contextPath }/AddandCutServlet?method=listStudents">
              			<input type="button" style="width: 80px;height: 30px;font-size: 16px;" value="返回" />
              		</a>
	    	</td>
	    </tr>
    </table>
</body>
</html>