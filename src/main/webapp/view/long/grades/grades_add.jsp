<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生综合测评评分表</title>
<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
		width: 50%;		/*设置td宽度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
	
	/*显示鼠标所在的行*/
	tr:hover{background-color:#CCC}
</style>  

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
</head>

<body>
	<div align="center">
		学号：<span>${stuid}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<span>${userName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		班级:<span>${userClas}</span>	<br><br>
	</div>
	<form action="${pageContext.request.contextPath }/GradesServlet?method=addGrades&
	stuid=${stuid}&gradingtype=${gradingtype}" method="post" >
    	<table border="1" align="center" width="60%">
        	<caption align="top" style="font-size:24px;margin:5px 0;font-weight: bold;" >学生综合测评评分表</caption>
            <tr> 
            	<td colspan="2" style="font-weight: bold;">思想品德分 20分</td>
            </tr>

            <tr>
            	<td>思想政治观念（15分）</td>
                <td>
                	<input type="text" name="sixiang" id="sixiang" onblur="checkText(0,15,this.id)"/>
                	<span id="sixiang1"></span>
                </td>
            </tr>
            <tr>
            	<td>纪律观念（14分）</td>
                <td>
                	<input type="text" name="jilv" id="jilv" onblur="checkText(0,14,this.id)"/>
                	<span id="jilv1"></span>
                </td>
            </tr>
            <tr>
            	<td>集体观念（13分）</td>
                <td>
                	<input type="text" name="jiti" id="jiti" onblur="checkText(0,13,this.id)"/>
                	<span id="jiti1"></span>
                </td>
            </tr>
            <tr>
            	<td>基础文明修养（13分）</td>
                <td>
                	<input type="text" name="wenming" id="wenming" onblur="checkText(0,13,this.id)"/>
                	<span id="wenming1"></span>
                </td>
            </tr>
            <tr>
            	<td>学生公寓表现（15分）</td>
                <td>
                	<input type="text" name="gongyu" id="gongyu" onblur="checkText(0,15,this.id)"/>
                	<span id="gongyu1"></span>
                </td>
            </tr>
            <tr>
            	<td>社会实践（15分）</td>
                <td>
                	<input type="text" name="shijian" id="shijian" onblur="checkText(0,15,this.id)"/>
                	<span id="shijian1"></span>
                </td>
            </tr>
            
            <tr> 
            	<td colspan="2" style="font-weight: bold;">学业分 70分</td>
            </tr>
            
            <tr>
            	<td>学习成绩（90分）</td>
                <td>
                	<input type="text" name="chengji" id="chengji" onblur="checkText(0,90,this.id)"/>
                	<span id="chengji1"></span>
                </td>
            </tr>
            
            <tr> 
            	<td colspan="2" style="font-weight: bold;">文体表现 10分</td>
            </tr>
            
            <tr>
            	<td>体育课分（60分）</td>
                <td>
                	<input type="text" name="tiyu" id="tiyu" onblur="checkText(0,60,this.id)"/>
                	<span id="tiyu1"></span>
                </td>
            </tr>
             <tr>
                <td>文体活动分（10分）</td>
                <td>
                	<input type="text" name="wenti" id="wenti" onblur="checkText(0,10,this.id)"/>
                	<span id="wenti1"></span>
                </td>
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