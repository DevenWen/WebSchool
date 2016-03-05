package com.cn.qpm.usermanage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.framework.util.UserUtil;
import com.cn.qpm.usermanage.dao.LoginUserMapper;
import com.cn.qpm.usermanage.model.LoginUser;
import com.cn.qpm.usermanage.service.IUserService;

/**
 * 
 * author wenkangqiang
 * date   2016年3月1日
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private LoginUserMapper loginUserMapper;

	@Override
	public LoginUser getUserById(String userId) {
		// TODO Auto-generated method stub
		return this.loginUserMapper.selectByPrimaryKey(userId);
				
	}

	
	/**
	 * 根据email和password处理登陆、
	 * 成功：把LoginUser的资料写入session中，并且返回LoginUser对象
	 * 失败：返回空值
	 */
	@Override
	public LoginUser checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		/*
		 * 继续编写登陆逻辑
		 */
		LoginUser user = this.loginUserMapper.selectByLoginMess(email, password);
		
		if (user != null){
			UserUtil.setCurrentUser(WebSchoolContext.getHttpServletRequest(), user);
		}
		
		return user;
				
	}

}
