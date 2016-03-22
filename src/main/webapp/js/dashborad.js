/*
	这里是编写dashboard控制台的JS代码，仅限与控制台使用。
	2016.03.13	by wenkangqiang
*/


$(function(){
	/*
	 * 实现侧边框叶子被点击时，iframe页面被跳转，样式也要相应设置
	 */
	$(".sideBarleave").click(function(){
		var leaves = $(".sideBarleave");
		var url = $(this).attr("url");
		var parent = $(this).parent();
		$(leaves.parent()).removeClass("active");	//去除active
		$(parent).addClass("active");					//添加active
		//撤销被激活的父节点
		$(".active_nav").removeClass("active_nav");
		$($(this).parents("li")).addClass("active_nav");
		$("#mainiframe").attr("src",url);
	});
	
	/*节点下拉时的动态效果*/
	$("#main-nav .nav-header").click(function(){
		//alert("侧边父节点被点击！");
		if ($(this).hasClass("bar_open")){
			$(this).removeClass("bar_open");
			$(this).addClass("bar_close");
		} else {
			$(this).removeClass("bar_close");
			$(this).addClass("bar_open");
		}
	});
	
});