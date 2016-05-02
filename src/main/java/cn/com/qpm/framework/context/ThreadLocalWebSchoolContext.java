package cn.com.qpm.framework.context;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.com.qpm.usermanage.model.LoginUser;

/**
 * declaration
 * 		应用上下文的类型，单例且全局
 * 
 * author wenkangqiang
 * date   2016年3月2日
 *
 */
public class ThreadLocalWebSchoolContext {
	
	private ThreadLocal<LoginUser> loginUserLocal;
	
	private ThreadLocal<ServletRequest> requestLocal;
	
	private ThreadLocal<ServletResponse> responseLocal;
	
	private static ThreadLocalWebSchoolContext local = new ThreadLocalWebSchoolContext();
	
	/**
	 * 私有化默认构造器，强化单例模式
	 */
	private ThreadLocalWebSchoolContext() {
		this.loginUserLocal = new ThreadLocal<LoginUser>();
		this.requestLocal = new ThreadLocal<ServletRequest>();
		this.responseLocal = new ThreadLocal<ServletResponse>();
	}
	
	/**
	 * 返回应用上下文
	 * @return
	 */
	public static ThreadLocalWebSchoolContext getInstance(){
		return local;
	}
	
	public void setLoginUser(LoginUser user) {
		this.loginUserLocal.set(user);
	}
	
	public void setRequest(ServletRequest request){
		this.requestLocal.set(request);
	}
	
	public void setResponse(ServletResponse response){
		this.responseLocal.set(response);
	}
	
	public LoginUser getLoginUser(){
		return this.loginUserLocal.get();
	}
	
	public ServletRequest getRequest(){
		return this.requestLocal.get();
	}
	
	public ServletResponse getResponse(){
		return this.responseLocal.get();
	}
	
	

}
