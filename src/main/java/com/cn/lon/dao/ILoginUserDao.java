package com.cn.lon.dao;

import com.cn.qpm.usermanage.model.LoginUser;

public interface ILoginUserDao {
	//修改密码
	public void updatePassword(LoginUser loginUser);
	//修改用户权限
	public void updateAuthority(LoginUser loginUser);
	//通过email查询用户
	public LoginUser findByEmail(String email);
}
