package com.cn.lon.dao.impl;

import com.cn.lon.dao.ILoginUserDao;
import com.cn.lon.utils.BaseDaoUtil;
import com.cn.qpm.usermanage.model.LoginUser;

public class LoginUserDao extends BaseDaoUtil implements ILoginUserDao {

	//修改密码
	@Override
	public void updatePassword(LoginUser loginUser) {
		String sql="UPDATE user SET password=? WHERE email=?";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {loginUser.getPassword(),loginUser.getEmail()};
		
		super.update(sql, paramsValue);		
	}

	//修改用户权限
	@Override
	public void updateAuthority(LoginUser loginUser) {
		String sql="UPDATE user SET authority=? WHERE email=?";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {loginUser.getAuthority(),loginUser.getEmail()};
		
		super.update(sql, paramsValue);	
		
	}


}
