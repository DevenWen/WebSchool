package com.cn.lon.service;

import com.cn.qpm.usermanage.model.LoginUser;

public interface ILoginUserService {
	//修改密码
	public void updatePassword(LoginUser loginUser);
	//修改用户权限
	public void updateAuthority(LoginUser loginUser);
}
