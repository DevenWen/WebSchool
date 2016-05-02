package cn.com.qpm.usermanage.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.qpm.usermanage.model.LoginUser;
import cn.com.qpm.usermanage.service.IUserService;

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
	
	/**
	 * 注销控制器
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginout(HttpServletRequest request){
		/*
		 * 注销主要是把session域中的用户信息给去掉
		 * 
		 * 需要其它扩展再编写
		 * 
		 */
		HttpSession session = request.getSession();
		session.removeAttribute(LoginUser.class.getName());
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "logoutsuccess");
		return result;
	}
	

}
