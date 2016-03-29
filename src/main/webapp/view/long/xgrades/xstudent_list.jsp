<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生综合测评班评评分表</title>
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
	<h3 align="center">查询要系评的专业班级</h3>
	<form action="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&gradingtype=系评" method="post">
		<div align="center">
			班级：<input type="text" name="clas" value="${clas}">
			<input type="submit" style="width: 80px;height: 25px;font-size: 16px;" value="查询">
		</div>
		<br>
	</form>
	
	 <table align="center" border="1" width="700px">
    	<tr>
    		<th>编号</th>
    		<th>学号</th>
    		<th>姓名</th>
    		<th>专业</th>
    		<th>班级</th>
    		<th>操作</th>
    	</tr>
    	<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
		    	<c:forEach items="${requestScope.pageBean.pageData}" var="stu" varStatus="varSta">
		    		<tr>
		    			<td>${varSta.count }</td>
		    			<td>${stu.stuid}</td>
		    			<td>${stu.name }</td>
				        <td>${stu.major }</td>
				        <td id="class">${stu.clas }</td>
				        <td>
				        	<a href="${pageContext.request.contextPath }/XGradesServlet?method=listXGrades&gradingtype=${gradingtype}&stuid=${stu.stuid}&name=${stu.name}&clas=${stu.clas}">评分</a>&nbsp;
				        </td>
		    		</tr>
		    	</c:forEach>
		     </c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="6">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="6" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&clas=${clas}&gradingtype=系评&currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&clas=${clas}&gradingtype=系评&currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&clas=${clas}&gradingtype=系评&currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/XGradesServlet?method=listStudent&clas=${clas}&gradingtype=系评&currentPage=${requestScope.pageBean.totalPage}">末页</a>
  			</td>
  		</tr>
  <!--  	
    	<tr>
    		<td colspan="6">
	    		<a href="${pageContext.request.contextPath }/view/long/xgrades/clas_search.jsp">
	    			<button style="width: 80px;height: 30px;font-size: 16px;">返回</button>
	    		</a>
	    	</td>
    	</tr>
    -->	
    </table>
</body>
</html>