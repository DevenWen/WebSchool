package com.cn.lon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.service.ILoginUserService;
import com.cn.lon.service.impl.LoginUserService;
import com.cn.lon.utils.UserUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;


@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdatePasswordServlet() {
        super();
      
    }

	//
    private ILoginUserService userService=new LoginUserService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型和评分类型
		String method = request.getParameter("method");
		
		if("enterupdate".equals(method)){
			enterupdate(request,response);
		}
		else if("updatepassword".equals(method)){
			updatepassword(request,response);
		}
	}

	//进行密码更新
	private void updatepassword(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取页面数据
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			String againnewpassword = request.getParameter("againnewpassword");
			
			//2.获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			//获取当前登录用户的密码
			String password = currentUser.getPassword();
			//获取当前登录用户的email
	//		String email = currentUser.getEmail();
			
			//3.判断
			if(password.equals(oldpassword)){
				//输对了旧密码
				if(newpassword.equals(againnewpassword)){
					//新密码两次输入一致
					
					//4.封装
					currentUser.setPassword(newpassword);
					
					//5.更新
					userService.updatePassword(currentUser);
					
					//
					
					
					//6.1输出密码成功信息
					//request.getRequestDispatcher("/view/long/updatepassword/updatesuccess.jsp").forward(request, response);
				//	String url = request.getContextPath();
				//	response.sendRedirect(url+"/view/long/updatepassword/updatesuccess.jsp");
					response.getWriter().println("<div  style='color: blue; font-size: 25px'>密码修改成功！</div>");
					return;
				}
			}
			
			String message="你输入的密码有误，请重新输入！";
			//6.2跳转到重新输入页面
			request.getRequestDispatcher("/UpdatePasswordServlet?method=enterupdate&message="+message).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//进入更新页面
	private void enterupdate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			
			//2.得到用户名
			String userName = UserUtil.getUserName(currentUser);
			String message=request.getParameter("message");
			
			//3.保存到域中
			request.setAttribute("userName", userName);
			request.setAttribute("message", message);
			
			//4.跳转页面
			request.getRequestDispatcher("/view/long/updatepassword/updatepassword.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
