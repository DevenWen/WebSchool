
package cn.com.qpm.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*
 * Spring工具箱
 * 
 * @date 2016年3月11日
 * @author wenkangqiang
 *
 */
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext context;
	
	/*
	 * 实现接口，注入context变量
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		context = arg0;
	}
	
	/*
	 * 获取context变量
	 */
	public static ApplicationContext getApplicationContext() {
		if (null == context){
			ExceptionUtil.throwIllegalStateException("applicationContext未注入，请检查Spring-XML文件的配置");
		}
		return context;
	}
	
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	/**
     * 因为$符号出现在spring配置文件中，会被当作   符
     * 所以我们在spring配置文件中用:代替
     * @param src
     * @return
     */
    public static String unEscapeSpringXml(String src) {
		return src.replace(":{", "${");
	}
	
}
