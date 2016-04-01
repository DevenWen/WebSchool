<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加公告</title>
<style type="text/css">
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
	
	
</style>  

</head>
<!-- 
<body style="margin-top: 5px; margin-left: 5px;">
	<form action="${pageContext.request.contextPath }/announcementAdd.action" name="formAdd"
		method="post">
		<table width="515px" border="0" cellpadding="4"
			cellspacing="1" bgcolor="#CBD8AC" style="margin-top: 5px; margin-left: 5px;">
			<tr bgcolor="#EEF4EA">
				<td colspan="3" class='title'><span>公告添加</span></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onmousemove="javascript:this.bgColor='red';"
				onmouseout="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="30%" bgcolor="#FFFFFF" align="right">标题：</td>
				<td width="70%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="title" size="70" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onmousemove="javascript:this.bgColor='red';"
				onmouseout="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="30%" bgcolor="#FFFFFF" align="right">内容：</td>
				<td width="70%" bgcolor="#FFFFFF" align="left">
					<FCK:editor
						instanceName="content" basePath="/fckeditor" width="450px"
						height="220" value="请输入内容" toolbarSet="Basic">
					</FCK:editor>
				</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onmousemove="javascript:this.bgColor='red';"
				onmouseout="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="30%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td width="70%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="提交" />&nbsp; <input type="reset" value="重置" />&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
 -->
<body>
	<form action="${pageContext.request.contextPath }/AnnounceServlet?method=addAnnounce" method="post">	
		<table align="center" width="70%">
	        <caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >添加发布公告</caption>
	           <tr> 
	           	<td style="font-weight: bold;">公告标题:</td>
	           	<td>
	           		<input type="text" name="title" style="width: 600px">
	           	</td>
	           </tr>
	
	           <tr>
	           	<td colspan="2" style="font-weight: bold;">公告内容：</td>
	           </tr>
	           <tr>
	           	<td colspan="2">
	           		<textarea rows="40" cols="100" name="content" ></textarea>
	           	</td>
	           </tr>
	            <tr>
	           	<td colspan="2" align="center">
	           		<input type="submit" style="width: 60px;height: 25px;font-size: 16px;" value="提交" />&nbsp;&nbsp;
	           		<input type="reset" style="width: 60px;height: 25px;font-size: 16px;" value="重置" />
	           	</td>
	           </tr>
	    </table>
	</form>
</body>

</html>