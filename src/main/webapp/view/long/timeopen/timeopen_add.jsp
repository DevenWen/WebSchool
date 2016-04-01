<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测评开发时间设置</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/long/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
		width: 33.3%;		/*设置td宽度*/
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
	<form action="${pageContext.request.contextPath }/TimeOpenServlet?method=addTime" method="post">
		<table align="center" border="1px" width="80%">
		<caption>系统开发时间设置</caption>
       	<tr>
       		<th>类型</th>
       		<th>开始时间</th>
       		<th>结束时间</th>
       	</tr>
       	<tr>
       		<td>自评</td>
       		<td><input  type="text" width="100%"  name="zbegin" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       		<td><input  type="text"  name="zend" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       	</tr>
       	<tr>
       		<td>班评</td>
       		<td><input  type="text"  name="bbegin" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       		<td><input  type="text"  name="bend" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       	</tr>
       	<tr>
       		<td>系评</td>
       		<td><input  type="text"  name="xbegin" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       		<td><input  type="text"  name="xend" maxlength="25" class="input-medium Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"></td>
       	</tr>
       	<tr>
       		<td colspan="3">
       		<input type="submit" value="提交">
       		</td>
       	</tr>
       	
       	</table>
	</form>
</body>
</html>