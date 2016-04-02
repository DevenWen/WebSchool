<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" description="ID"%>
<%@ attribute name="name" required="true" description="name"%>
<%@ attribute name="className" description="css类名"%>
<%@ attribute name="style" description="样式"%>
<%@ attribute name="value" description="日期控件值"%>
<%@ attribute name="readonly" description="是否只读" %>
<%@ attribute name="required"  description="是否必填"%>
<%@ attribute name="isShowWeek" description="是否显示周数"%>
<%@ attribute name="isShowClear" description="是否显示清除按钮 "%>
<%@ attribute name="firstDayOfWeek" description="每周首日"%>
<%@ attribute name="dateFormat" description="日期格式 yyyy-MM-dd"%>
<%@ attribute name="minDate" description="最小日期"%>
<%@ attribute name="maxDate" description="最大日期"%>
<%@ attribute name="onpicked" description="选定日期后回调方法"%>
<%@ attribute name="onpicking" description="选定日期时回调方法"%>
<%@ attribute name="onclearing" description="清值时回调方法"%>
<%@ attribute name="oncleared" description="清值后回调方法"%>
<%@ attribute name="callback" description="验证回调函数名"%>
<%@ attribute name="editable" description="是否能编辑输入框"%>
<%@ attribute name="onInitComplete" description="控件初始化完成的回调"%>
<%@ attribute name="title" description="中文提示"%>
<input type="text" id="<%=id%>" name="<%=name%>" title="<%=null!=title?title:""%>" class='sinobest-date <%=null!=className?className:""%>' <%=null!=style?"style='"+style+"'":""%>
	data-options="{ 
		<%=null!=value?"value:'"+value+"',":""%>
		<%=null!=readonly?"readonly:"+readonly+",":""%>
		<%=null!=required?"required:"+required+",":""%>
		<%=null!=isShowWeek?"isShowWeek:'"+isShowWeek+"',":""%>
		<%=null!=isShowClear?"isShowClear:'"+isShowClear+"',":""%>
		<%=null!=firstDayOfWeek?"firstDayOfWeek:'"+firstDayOfWeek+"',":""%>
		<%=null!=dateFormat?"dateFormat:'"+dateFormat+"',":""%>
		<%=null!=minDate?"minDate:'"+minDate+"',":""%>
		<%=null!=maxDate?"maxDate:'"+maxDate+"',":""%>
		<%=null!=onpicked?"onpicked:"+onpicked+",":""%>
		<%=null!=onpicking?"onpicking:"+onpicking+",":""%>
		<%=null!=onclearing?"onclearing:"+onclearing+",":""%>
		<%=null!=oncleared?"oncleared:"+oncleared+",":""%>
		<%=null!=callback?"callback:"+callback+",":""%>
		<%=null!=dateFormat?"dateFormat:'"+dateFormat+"',":""%>
		<%=null!=editable?"editable:"+editable+",":""%>
		<%=null!=onInitComplete?"onInitComplete:"+onInitComplete+",":""%>
		name:'<%=name%>'
}"/>
