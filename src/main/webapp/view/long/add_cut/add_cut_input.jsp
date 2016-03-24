<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>加扣分上传页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="/view/common/head.jsp"></jsp:include>
	 
	<style type="text/css">
		.form-control{
			width: 80%;
		}
		
	</style>

  </head>
 
  
  
  <body>
    <div style="width:60%;margin-left: auto;margin-right: auto;">
    <form action="<%= path %>/uploadController/upload.do" method="post"  enctype="multipart/form-data">
	    <div class="form-group">
		    <label for="exampleInputEmail1">加扣分类别</label>
		    <select name="type" class="form-control">
			   <option value="1">思想加分</option>
			   <option value="2">思想扣分</option>
			   <option value="3">学业加分</option>
			   <option value="4">学业扣分</option>
			   <option value="5">文体加分</option>
			   <option value="6">文体扣分</option>
			</select>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">分值</label>
	    <input type="text" class="form-control" id="score" name="score" placeholder="分值" onblur="func(this);">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputFile">上传证明</label>
	    <input type="file" name="file" onchange="preview(this)" />
	    <div id="viewpre"></div>
	  </div>
	  <div class="form-group">
	    <label>备注</label>
	     <textarea name="explains" class="form-control" rows="3"></textarea>
	  </div>
	  <button type="submit" class="btn btn-default">提交</button>
    </form>
    </div>
  </body>
  
  <script type="text/javascript">
  	/*图片预览*/
  	function preview(file) {
  		var prevDiv = document.getElementById("viewpre");
  		if (file.files && file.files[0]) {
  			var reader = new FileReader();
  			reader.onload = function(evt){
  				prevDiv.innerHTML = '<img style="width:300px" class="img-thumbnail" src="' + evt.target.result + '" />';
  			}
  			reader.readAsDataURL(file.files[0]);
  		} else {
  			prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>'; 
  		}
  	}
  	
  	var sub
  	
  	
  	function func(obj){
  		var a = $(obj).val();
  		if (!isNaN(a)){
  		//	alert("is number!");
  		} else {
  		//	$(obj).after('<span class="glyphicon glyphicon-remove">请输入数字</span>');
  		}
  		//<span class="label label-warning">请输入合适的分值</span>
  		
  	}
  	
  	$(function(){
  		$("#score").focus(function(){
  			//alert("获得焦点");
  			$(this).popover("hide");
  		});
  	
  		$("#score").on("blur", function(){
  			var a = $(this).val();
  			if (!isNaN(a)){
  				//是数字，不作设置
  				$(this).popover("hide");
  			} else {
  				//
  				$(this).popover({
		  			animation : true,
		  			content	  : '请输入合适的分值',
		  			title	  : 'ERROR'
		  		});
		  		$(this).popover("show");
  			}
  		});
  		
  		
  		
  		
  	});
  
  </script>
  
  
  
</html>
