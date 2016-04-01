package com.cn.lon.service.impl;

import com.cn.lon.dao.impl.LoginUserDao;
import com.cn.lon.service.ILoginUserService;
import com.cn.qpm.usermanage.model.LoginUser;

public class LoginUserService implements ILoginUserService {

	private LoginUserDao loginUserDao=new LoginUserDao();
	@Override
	public void updatePassword(LoginUser loginUser) {
		loginUserDao.updatePassword(loginUser);

	}

	@Override
	public void updateAuthority(LoginUser loginUser) {
		loginUserDao.updateAuthority(loginUser);

	}

}
