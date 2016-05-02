package cn.com.qpm.usermanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.qpm.framework.context.WebSchoolContext;
import cn.com.qpm.framework.dashboard.model.DashboardEntry;
import cn.com.qpm.framework.dashboard.model.DashboardFactory;
import cn.com.qpm.framework.util.UserUtil;
import cn.com.qpm.usermanage.dao.LoginUserMapper;
import cn.com.qpm.usermanage.model.LoginUser;
import cn.com.qpm.usermanage.service.IUserService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		
		/*
		 * 编写一下分页的测试代码 
		 */
		PageHelper.startPage(1, 3);
		List<LoginUser> users =  (Page<LoginUser>) this.loginUserMapper.selectall();
		
		return user;
				
	}

}
