<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true" description="ID"%>
<%@ attribute name="name" required="true" description="name"%>
<%@ attribute name="className" description="css类名"%>
<%@ attribute name="style" description="样式"%>

<h1>由tag标签输出的：<%=id %></h1>
<script type="text/javascript">
		$(function(){
			alert("tag标签还附带代码");
		});
</script>