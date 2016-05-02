
package cn.com.qpm.framework.util;

/*
 * 异常工具类
 * @date 2016年3月9日
 * @author wenkangqiang
 *
 */
public class ExceptionUtil {
	
	/**
	 * 跑出运行时异常
	 * @param msg
	 */
	public static void throwRuntimeException(String msg){
		throw new RuntimeException(msg);
	}
	
	public static void throwRuntimeException(Throwable e){
		if (e instanceof RuntimeException){
			throw (RuntimeException) e;
		}
		
		throw new RuntimeException(e);
	}
	
	public static void throwRuntimeException(String msg, Exception e){
		if (e instanceof RuntimeException) {
			throw (RuntimeException) e;
		}
		throw new RuntimeException(msg, e);
	}
	
	/**
	 * 违法的状态异常。当在Java环境和应用尚未处于某个方法的合法调用状态，而调用了该方法时，抛出该异常。
	 * 
	 * @param msg
	 */
	public static void throwIllegalStateException(String msg){
		throw new IllegalStateException(msg);
	}
	
	
	public static void throwNullPointerException(String msg){
		throw new NullPointerException(msg);
	}

}
