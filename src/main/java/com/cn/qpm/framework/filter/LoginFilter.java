package com.cn.qpm.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.qpm.framework.context.ThreadLocalWebSchoolContext;
import com.cn.qpm.framework.util.UserUtil;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * declaration：登陆过滤器 
 *		
 * author wenkangqiang
 * date   2016年3月3日
 */
public class LoginFilter implements Filter {
	
	private ThreadLocalWebSchoolContext threadLocal;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.threadLocal = ThreadLocalWebSchoolContext.getInstance();
		//System.out.println("LoginFilter start!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//在设置登陆的同时，先把request和response更新到上下文中
		this.threadLocal.setRequest(request);
		this.threadLocal.setResponse(response);
		
		//把必要的变量先取出来
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		String path = servletRequest.getRequestURI();
		String context = servletRequest.getContextPath();
		
		//在登陆Service中，当用户登陆成功的时候，会把LoginUser对象写入session中去
		LoginUser user = UserUtil.getCurrentUser(servletRequest);
		
		if (path.indexOf("/login") > -1 || path.indexOf("/img/back.jpg") > -1 
				|| path.indexOf("/css/") > -1 || path.indexOf("/js/") > -1){
			
			/*
			 * 放行登陆页面和login页面中图片,css,js相关的http请求
			 * 这里还必需考虑login方面的请求
			 * 
			 * 切记：慎用/*匹配的过滤器
			 */
			chain.doFilter(request, response);
			return;
		}
		
		if (user == null) {
			//跳转至登陆页面
			servletResponse.sendRedirect(context+"/view/login.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("LoginFilter close!");
	}

}
