package cn.com.qpm.framework.util;

import javax.servlet.http.HttpServletRequest;

import cn.com.qpm.usermanage.model.LoginUser;

/**
 * declaration： 
 *		登陆用户工具类
 * author wenkangqiang
 * date   2016年3月3日
 */
public class UserUtil {
	
	/**
	 * 获得request中的LoginUser对象
	 * @param request
	 * @return
	 */
	public static final LoginUser getCurrentUser(HttpServletRequest request){
		return (LoginUser) request.getSession().getAttribute(LoginUser.class.getName());
	}
	
	/**
	 * 设置user进request中
	 * @param request
	 * @param user
	 */
	public static final void setCurrentUser(HttpServletRequest request, LoginUser user){
		request.getSession().setAttribute(LoginUser.class.getName(), user);
		
	}

}
