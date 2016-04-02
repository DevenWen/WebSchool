
package com.cn.qpm.framework.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.cn.qpm.framework.util.ExceptionUtil;

/*
 * aop 定义拦截器
 * @date 2016年3月17日
 * @author Administrator
 *
 */
@Aspect
public class MyInterceptor {
	
	/*
	@Pointcut("execution(* checkLogin(..))")
	private void anyMethod(){}	
	
	@Before("anyMethod()")  
    public void doAccessCheck(){  
        System.out.println("前置通知");  
    }
    */
	
	@Before("execution(* checkLogin(..))")
	public void doAccessCheck(){
		System.out.println("aop！");
	}

}
