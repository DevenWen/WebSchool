package cn.com.qpm.framework.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import cn.com.qpm.framework.dashboard.model.DashboardEntry;
import cn.com.qpm.usermanage.model.LoginUser;

/**
 * declaration： 
 *		用于测试Xbean工作效果的一个processer
 * author wenkangqiang
 * date   2016年3月5日
 */
public class XbeanTestProcesser implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		if (bean instanceof DashboardEntry){
			System.out.println("从xml文件中读取到bean" + ((DashboardEntry)bean).toString());
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
