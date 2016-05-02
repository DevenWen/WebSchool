package cn.com.qpm.framework.context;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qpm.framework.util.UserUtil;
import cn.com.qpm.usermanage.model.LoginUser;

/**
 * declaration： 
 *		通过代理模式 构建应用上下文对象
 * author wenkangqiang
 * date   2016年3月3日
 */
public class WebSchoolContext {

	/**
	 * 获取request
	 * @return
	 */
	public static ServletRequest getRequest(){
		return ThreadLocalWebSchoolContext.getInstance().getRequest();
	}
	
	/**
	 * 获取httpServletRequest
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest(){
		return (HttpServletRequest)ThreadLocalWebSchoolContext.getInstance().getRequest();
	}
	
	/**
	 * 获取response
	 * @return
	 */
	public static ServletResponse getResponse(){
		return ThreadLocalWebSchoolContext.getInstance().getResponse();
	}
	
	/**
	 * 获取httpServletResponse
	 * @return
	 */
	public static HttpServletResponse getHttpServletResponse(){
		return (HttpServletResponse)ThreadLocalWebSchoolContext.getInstance().getResponse();
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public static LoginUser getCurrentUser(){
		return UserUtil.getCurrentUser(getHttpServletRequest());
				
	}
}
