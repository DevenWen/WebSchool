<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>思想品德评分</title>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:36px;	/*设置td高度*/
		width: 50%;		/*设置td宽度*/
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
		姓名：<span>${userName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		班级:<span>${userClas}</span>	<br><br>
	</div>
	<form action="${pageContext.request.contextPath }/SiXiangServlet?method=addSiXiang&
	stuid=${stuid}&gradingtype=${gradingtype}" method="post" >
    	<table border="1" align="center" width="60%">
        	<caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >学生综合测评思想品德分</caption>
            <tr> 
            	<td colspan="2" style="font-weight: bold;">思想品德分 20分</td>
            </tr>

            <tr>
            	<td>思想政治观念（15分）</td>
                <td><input type="text" name="sixiang"/></td>
            </tr>
            <tr>
            	<td>纪律观念（14分）</td>
                <td><input type="text" name="jilv"/></td>
            </tr>
            <tr>
            	<td>集体观念（13分）</td>
                <td><input type="text" name="jiti"/></td>
            </tr>
            <tr>
            	<td>基础文明修养（13分）</td>
                <td><input type="text" name="wenming"/></td>
            </tr>
            <tr>
            	<td>学生公寓表现（15分）</td>
                <td><input type="text" name="gongyu"/></td>
            </tr>
            <tr>
            	<td>社会实践（15分）</td>
                <td><input type="text" name="shijian"/></td>
            </tr>
            <tr>
            	<td>奖分（+）（14分）</td>
                <td><input type="text" name="jiangfen"/></td>
            </tr>
            <tr>
            	<td>扣分（-）</td>
                <td><input type="text" name="koufen"/></td>
            </tr>
             <tr>
                <td>小计</td>
                <td><input type="text" name="count"/></td>
            </tr>
            
            <tr>
            	<td align="center" colspan="2"> 
                	<input type="submit" style="width: 80px;height: 30px;font-size: 16px;" value="提交" />
                </td>
            </tr>
        </table>	
    </form>
</body>
</html>