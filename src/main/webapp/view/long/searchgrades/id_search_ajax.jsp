<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>根据学号查询综合测评分</title>

<style type="text/css">
	table td{
		/*文字居中*/
		text-align:center;
		height:35px;	/*设置td高度*/
		width: 25%;		/*设置td宽度*/
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>  

<script type="text/javascript">
		//创建AJAX异步对象
		function createAJAX(){
			var ajax = null;
			try{
				//如果IE5=IE12的话
				ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch(e1){
				try{
					//如果是非IE的话
					ajax = new XMLHttpRequest();
				}catch(e2){
					alert("你的浏览器中不支持异步对象，请换浏览器");
				}
			}
			return ajax;
		}
</script>

<script type="text/javascript">
	function findById(){
		//获取文本框的值
		var stuid=document.getElementById("stuid").value;
		
	//	alert(stuid);
		//1.创建AJAX异步对象
		var ajax = createAJAX();
		//2.准备发送请求
		var method = "post";
		var url = "${pageContext.request.contextPath}/SearchServlet?time=" + new Date().getTime();
		ajax.open(method,url);
		//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
		ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//3.真正发送请求体的数据到服务器，设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
		var content = "stuid=" + stuid;
		ajax.send(content);
		
		//-------------------------------------------------------------等待
	
		//4.AJAX异步对象不断监听服务器响应的状态0-1-2-3-【4】
		//一定要状态变化后，才可触发function(){}函数
		//如果状态永远是4-4-4-4-4，是不会触发function(){}函数的
		ajax.onreadystatechange = function(){
			//如果状态码为4的话
			if(ajax.readyState == 4){
				//如果响应码为200的话
				if(ajax.status == 200){
					//5.从AJAX异步对象中获取服务器响应的HTML数据
					
					var nowStr = ajax.responseText;
					
					var zgJson= eval('('+nowStr+')');
					//alert(nowStr);
					
					//获取table标签
					var tableElement=document.getElementById("tableid");
					tableElement.innerHTML ="";
					
					//创建th标签
					var thElement1 = document.createElement("th");
					thElement1.innerHTML ="学号";
					
					var thElement2 = document.createElement("th");
					thElement2.innerHTML ="姓名";
					
					var thElement3 = document.createElement("th");
					thElement3.innerHTML ="专业";
					
					var thElement4 = document.createElement("th");
					thElement4.innerHTML ="班级";
					
					var thElement5 = document.createElement("th");
					thElement5.innerHTML ="思想分";
					
					var thElement6 = document.createElement("th");
					thElement6.innerHTML ="学业分";
					
					var thElement7 = document.createElement("th");
					thElement7.innerHTML ="文体分";
					
					var thElement8= document.createElement("th");
					thElement8.innerHTML ="综合分";
										
					//创建tr标签
					var trElement1 = document.createElement("tr");
					trElement1.appendChild(thElement1);
					trElement1.appendChild(thElement2);
					trElement1.appendChild(thElement3);
					trElement1.appendChild(thElement4);
					trElement1.appendChild(thElement5);
					trElement1.appendChild(thElement6);
					trElement1.appendChild(thElement7);
					trElement1.appendChild(thElement8);
					
					//把tr标签添加到table中
					tableElement.appendChild(trElement1);
					
					
					
					//创建td标签
					var tdElement1 = document.createElement("td");
					tdElement1.innerHTML =zgJson.zg.stuid;
					
					var tdElement2 = document.createElement("td");
					tdElement2.innerHTML =zgJson.zg.name;
					
					var tdElement3 = document.createElement("td");
					tdElement3.innerHTML =zgJson.zg.major;
					
					var tdElement4 = document.createElement("td");
					tdElement4.innerHTML =zgJson.zg.clas;
					
					var tdElement5 = document.createElement("td");
					tdElement5.innerHTML =zgJson.zg.sx_score;
					
					var tdElement6 = document.createElement("td");
					tdElement6.innerHTML =zgJson.zg.xy_score;
					
					var tdElement7 = document.createElement("td");
					tdElement7.innerHTML =zgJson.zg.wt_score;
					
					var tdElement8= document.createElement("td");
					tdElement8.innerHTML =zgJson.zg.zh_score;
					
					
					//创建tr标签
					var trElement2 = document.createElement("tr");
					trElement2.appendChild(tdElement1);
					trElement2.appendChild(tdElement2);
					trElement2.appendChild(tdElement3);
					trElement2.appendChild(tdElement4);
					trElement2.appendChild(tdElement5);
					trElement2.appendChild(tdElement6);
					trElement2.appendChild(tdElement7);
					trElement2.appendChild(tdElement8);
					
					//把tr标签添加到table中
					tableElement.appendChild(trElement2);
					
				}
			}
		} 
		
	}
</script>

</head>
<body>
	<h3 align="center">根据学号查询综合测评分</h3>
	<div align="center">
		学号：<input type="text" name="stuid" id="stuid">
		<input type="button" style="width: 80px;height: 30px;font-size: 16px;" onclick="findById()" value="查询">
	</div>
	<div>
		<table border="1" align="center" width="80%" id="tableid">
	  	<!--	<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>专业</th>
				<th>班级</th>
				<th>思想分</th>
				<th>学业分</th>
				<th>文体分</th>
				<th>综合分</th>
			</tr>	
    		<tr>
    			<td>zgJson.stuid</td>
    			<td>zgJson.name</td>
		        <td>zgJson.major </td>
		        <td>zgJson.clas</td>
		        <td>zgJson.sx_score</td>
		        <td>zgJson.xy_score</td>
		        <td>zgJson.wt_score</td>
		        <td>zgJson.zh_score</td>
    		</tr>
	 -->	    	
 
		</table>
	</div>
</body>
</html>