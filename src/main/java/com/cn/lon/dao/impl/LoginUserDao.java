package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.ILoginUserDao;
import com.cn.lon.entity.Student;
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

	//通过email查询用户
	@Override
	public LoginUser findByEmail(String email) {
		String sql="select * from user where email=?";
		
		Object[] paramsValue = {email};
		
		List<LoginUser> list = super.query(sql,paramsValue , LoginUser.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}


}
