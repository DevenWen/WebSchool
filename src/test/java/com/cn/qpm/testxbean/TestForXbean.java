package com.cn.qpm.testxbean;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

import cn.com.qpm.usermanage.model.LoginUser;

/**
 * declaration： 
 *
 * author wenkangqiang
 * date   2016年3月4日
 */
public class TestForXbean {
	
	
	/**
	 * 测试xbean的解析
	 */
	@Test
	public void test() {
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("classpath:spring/spring-xbean-test.xml");
		LoginUser user = (LoginUser) context.getBean("testuser123");
		System.out.println(user.toString());
		
	}

}
