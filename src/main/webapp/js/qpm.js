/*第一个：定一个全局函数*/
jQuery.foo = function() {
	alert("全局添加一个foo函数！");
}

/*第二个：使用extend方法进行批量全局函数的定义*/
jQuery.extend({
	foo1:function(){
		alert("全局函数的extend定义方法：foo1")
	}
	,
	foo2:function(){
		alert("extend可以轻易的定义多个方法");
	}

});

jQuery.plugin = {
	foo2:function(){
		alert("使用命名空间进行扩展：plugin.foo2")
	}
}

//以上是对类的方法的扩展

/*
	第三：对象级别的插件开发
 */
$(function(){
	(function($){
	 	$.fn.extend({
	 		foo3:function(){
	 			alert("对象级别插件extend方式开发");
			},
			foo4:function(){
				alert("对象级别插件extend方式开发");
	 		}
	 	})
	})(jQuery);
	 
	 

	/*对象级别的扩展，需要在页面加载完成后，运行一次*/
	(function($) {
		$.fn.foo5 = function(){
			alert("对象级别插件一般方式开发");
		}
	})(jQuery);
	
	//接收参数来控制插件行为
	(function($) {
		$.fn.fooOption = function(options){
			alert("接收参数来控制插件行为");
			var defaults = {aaa:'1',bbb:'2'};
			//这个函数什么意思？对象扩展方法
			var opts = $.extend(defaults, options);		
			alert('参数值:aaa:'+opts.aaa+';bbb:'+opts.bbb);
		}
	})(jQuery);
	
	//提供公有方法访问插件的配置的值
	(function($){
		$.fn.foo6 = function(options){
			alert("提供公有方法访问插件的配置的值");
			var opts = $.extend({}, $.fn.foo6.defaults, options);
			alert('参数值:aaa:'+opts.aaa+';bbb:'+opts.bbb);
		}
		$.fn.foo6.defaults = {aaa:'1',bbb:'2'};
	})(jQuery);
});
