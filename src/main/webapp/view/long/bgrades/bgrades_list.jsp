<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		width: 33.3%;		/*设置td宽度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>  

<!-- 去掉a标签下面的下划线 -->
<style>a{TEXT-DECORATION:none}</style>

<script type="text/javascript">
	//校验数据
	function checkText(num1,num2,id){
		var grade=document.getElementById(id).value; 
		
		//var grade=document.getElementsByName("test")[0].value;
		if(!isNaN(grade)){
			if(grade >= num1 && grade<=num2){
				showInfo2(id+"1");
			}
			else{
				showInfo1(id+"1");
			}
		}else{
			showInfo1(id+"1");
		}
	
	}
	
	//显示提示信息
	function showInfo1(id){
		var message=document.getElementById(id);
		message.innerHTML="请输入合理的数据".fontcolor("red");
		
	}
	function showInfo2(id){
		var message=document.getElementById(id);
		message.innerHTML="";
	}
</script>

<script type="text/javascript">

	function load(){		
		var type=document.getElementById("span").innerHTML;		
		if(type=="hidden"){
			document.getElementById("tr").style.visibility="hidden";
		}
	}
</script>

</head>

<body onload="load()">
	<div align="center">
		学号：<span>${zstuid}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<span>${zname}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		班级:<span>${zclas}</span>	<br><br>
	</div>
    	<table border="1" align="center" width="60%">
        	<caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >学生综合测评评分表</caption>
            <tr>
            	<th>内容</th>
            	<th>自评</th>
            	<th>班评</th>
            </tr>
            <tr> 
            	<td colspan="3" style="font-weight: bold;">思想品德分 20分</td>
            </tr>

            <tr>
            	<td>思想政治观念（15分）</td>
            	<td>${zgra.sixiang }</td>  
                <td>${bgra.sixiang }</td>
            </tr>
            <tr>
            	<td>纪律观念（14分）</td>
            	<td>${zgra.jilv }</td>
                <td>${bgra.jilv }</td>
            </tr>
            <tr>
            	<td>集体观念（13分）</td>
            	<td>${zgra.jiti }</td>
                <td>${bgra.jiti }</td>
            </tr>
            <tr>
            	<td>基础文明修养（13分）</td>
            	<td>${zgra.wenming }</td>
                <td>${bgra.wenming }</td>
            </tr>
            <tr>
            	<td>学生公寓表现（15分）</td>
            	<td>${zgra.gongyu }</td>
                <td>${bgra.gongyu }</td>
            </tr>
            <tr>
            	<td>社会实践（15分）</td>
            	<td>${zgra.shijian }</td>
                <td>${bgra.shijian }</td>
            </tr>
            
            <tr> 
            	<td colspan="3" style="font-weight: bold;">学业分 70分</td>
            </tr>
            
            <tr>
            	<td>学习成绩（90分）</td>
            	<td>${zgra.chengji}</td>
                <td>${bgra.chengji}</td>
            </tr>
            
            <tr> 
            	<td colspan="3" style="font-weight: bold;">文体表现 10分</td>
            </tr>
            
            <tr>
            	<td>体育课分（60分）</td>
            	<td>${zgra.tiyu }</td>
                <td>${bgra.tiyu }</td>
            </tr>
             <tr>
                <td>文体活动分（10分）</td>
                <td>${zgra.wenti}</td>
                <td>${bgra.wenti}</td>
            </tr>
            
            <tr id="tr">
            	<td align="center" colspan="3"> 
                	<a href="${pageContext.request.contextPath }/BGradesServlet?method=viewUpdate&stuid=${zstuid}&gradingtype=${bgra.gradingtype}&name=${zname}&clas=${zclas}">
                		<input type="button" style="width: 80px;height: 30px;font-size: 16px;" value="修改" />
                	</a>
                	<a href="${pageContext.request.contextPath }/BGradesServlet?method=listStudent&amp;gradingtype=班评">
                		<input type="button" style="width: 80px;height: 30px;font-size: 16px;" value="返回" />
                	</a>
                </td>
            </tr>
            
            <span style="visibility: hidden;" id="span" >${type}</span>
            
        </table>	
</body>
</html>