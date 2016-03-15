package com.cn.qpm.usermanage.controller;


import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.qpm.usermanage.model.LoginUser;
import com.cn.qpm.usermanage.service.IUserService;

/**
 * 
 * author Administrator date 2016年3月1日
 *
 */
@Controller
@RequestMapping(value = "user")
public class LoginController {

	@Resource(name = "userService")
	private IUserService userService;
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public void logincheck(String email, String password,
			HttpServletRequest requset, HttpServletResponse response) throws Exception {
		LoginUser loginUser = userService.checkLogin(email, password);
		if (loginUser != null){
			response.sendRedirect(requset.getContextPath()+"/view/framework/dashboard.jsp");
		} else {
			response.sendRedirect(requset.getContextPath()+"/view/login.jsp");
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public Map loginout(){
		
		
		return null;
	}
	

}
