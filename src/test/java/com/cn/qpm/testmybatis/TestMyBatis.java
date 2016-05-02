package com.cn.qpm.testmybatis;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.qpm.usermanage.model.LoginUser;
import cn.com.qpm.usermanage.service.IUserService;

import com.alibaba.fastjson.JSON;

/**
 * 
 * author Administrator
 * date   2016年3月1日
 *
 */


public class TestMyBatis {

	
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		IUserService userService = (IUserService) ctx.getBean("userService");
		LoginUser user = userService.getUserById("01");
		LoginUser user2 = userService.checkLogin("945766863@qq.com", "123456");
		System.out.println(user2.getName());
	}
	
}
