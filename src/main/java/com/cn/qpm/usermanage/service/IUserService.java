package com.cn.qpm.usermanage.service;

import com.cn.qpm.usermanage.model.LoginUser;


/**
 * declaration： 
 *
 */
public interface IUserService {
	
	public LoginUser getUserById(String userId);
	
	public LoginUser checkLogin(String email, String password);

}
