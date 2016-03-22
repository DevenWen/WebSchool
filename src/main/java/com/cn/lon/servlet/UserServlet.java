package com.cn.lon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.Student;
import com.cn.lon.service.IStudentService;
import com.cn.lon.service.impl.StudentService;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//实现service
	private IStudentService studentService=new StudentService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取当前登录用户对象
		LoginUser currentUser = WebSchoolContext.getCurrentUser();
		//获取登录用户的email
		String email = currentUser.getEmail();	
		
		//判断当前用户的身份
		if(Integer.parseInt(currentUser.getAuthority())>1){
			//该用户是学生
			listStudent(request,response,email);
		}
		
	}

	
	private void listStudent(HttpServletRequest request,
			HttpServletResponse response, String email) {
		try {
			//1.通过email查找获取学生对象
			Student student= studentService.findByEmail(email);
			
			//2.把它保存到域中
			request.setAttribute("student", student);
			
			//3.跳转
			request.getRequestDispatcher("/view/long/userInfors/studentInfor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
