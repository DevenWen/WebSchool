package com.cn.lon.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.Grades;
import com.cn.lon.service.impl.GradesService;
import com.cn.lon.utils.TimeOpenUtils;
import com.cn.lon.utils.UserUtil;
import com.cn.lon.utils.WebUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * 评分控制层
 * 
 * a.添加评分信息
 * b.显示评分信息
 * c.进入评分更新页面
 * d.更新评分信息
 * @author Administrator
 *
 */
@WebServlet("/GradesServlet")
public class GradesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	//实现service
	private GradesService gradesService=new GradesService();
	
	/**
	 * 问题：有时候可以进去有时候报错或找不路径
	 * 原因：不可以把它放到方法外，因为servlet是单实例，线程是不安全的
	 * 解决方法：把它放到方法里面
	 */
	//获取当前登录用户对象
//	LoginUser currentUser = WebSchoolContext.getCurrentUser();		
	//通过用户工具类获取当前用户的账号
//	String gradingManId = UserUtil.getUserId(currentUser);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型和评分类型
		String method = request.getParameter("method");
		String gradingtype = request.getParameter("gradingtype");
		
		//获取当前时间和开放时间
		long beginTime = TimeOpenUtils.getBeginTime(gradingtype).getTime();
		long endTime = TimeOpenUtils.getEndTime(gradingtype).getTime();
		long date = new Date().getTime();
		
		//定义按钮显示类型
		String type;
		
		//判断
		if(date<beginTime){
			//还没到自评时间
			try {
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		else if(date>beginTime&date<endTime){	
			//自评时间
			type="show";
			
			if("addGrades".equals(method)){
				addGrades(request,response);
			}
			else if("listGrades".equals(method)){
				listGrades(request,response,type);
			}
			else if("viewUpdate".equals(method)){
				viewUpdate(request,response);
			}
			else if("updateGrades".equals(method)){
				updateGrades(request,response);
			}
		}
		else if(date>endTime){
			//过了自评时间
			type="hidden";
			if("listGrades".equals(method)){
				listGrades(request,response,type);
			}
		}		
	}

	//d.更新评分信息
	private void updateGrades(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		Grades grades= WebUtil.copyToBean(request, Grades.class);
		
		try {
			//封装剩下的数据
			String stuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			
			grades.setStuid(stuid);
			grades.setGradingtype(gradingtype);
			grades.setGradingManId(gradingManId);
			
			//2. 调用Service更新
			gradesService.updateGrades(grades);
			
			//3.跳转到显示页面
			request.getRequestDispatcher("/GradesServlet?method=listGrades&stuid="+stuid+"&gradingtype="+gradingtype).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//c.进入评分更新页面
	private void viewUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取被评学生编号，评分类型，评分人编号
			String stuid = request.getParameter("stuid");
			String gradingtype = request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);			
			
			//2.根据条件查询对象
			Grades gra= gradesService.findById(stuid, gradingtype, gradingManId);
			
			//获取当前用户的姓名，班级
			String userName = UserUtil.getUserName(currentUser);
			String userClas = UserUtil.getUserClas(currentUser);
			
			//3.保存
			request.setAttribute("gra", gra);
			request.setAttribute("userName", userName);
			request.setAttribute("userClas", userClas);
			
			//4.跳转到更新页面
			request.getRequestDispatcher("/view/long/grades/grades_update.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//b.显示评分信息
	private void listGrades(HttpServletRequest request,
			HttpServletResponse response,String type) {
		
		try {
			//1.获取评分类型
			String gradingtype=request.getParameter("gradingtype");
			
			//判断评分类型
			if("自评".equals(gradingtype)){				
				//获取当前登录用户对象
				LoginUser currentUser = WebSchoolContext.getCurrentUser();		
				//通过用户工具类获取当前用户的账号
				String gradingManId = UserUtil.getUserId(currentUser);
				//如果是自评，那么被评分账号就是评分账号
				String stuid=gradingManId;			
				//获取当前用户的姓名，班级并保存
				String userName = UserUtil.getUserName(currentUser);
				String userClas = UserUtil.getUserClas(currentUser);
				request.setAttribute("userName", userName);
				request.setAttribute("userClas", userClas);
				
				//2.根据stuid查询对象
				Grades gra=gradesService.findById(stuid, gradingtype, gradingManId);
				
				//判断获取的对象是否为空
				if(gra==null){
					//为空说明还没有数据，第一次评分，进入添加信息页面
					//保存
					request.setAttribute("stuid", stuid);
					request.setAttribute("gradingManId", gradingManId);
					request.setAttribute("gradingtype", gradingtype);
										
					//跳转到添加页面
					request.getRequestDispatcher("/view/long/grades/grades_add.jsp").forward(request, response);
				}else{
					//3.把对象的信息保存到域中
					request.setAttribute("gra", gra);
					//把按钮类型保存到域中
					request.setAttribute("type", type);
					
					//4.跳转
					request.getRequestDispatcher("/view/long/grades/grades_list.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//a.添加评分信息
	private void addGrades(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		Grades grades = WebUtil.copyToBean(request, Grades.class);
		
		try {
			//封装剩下的数据
			String stuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			
			grades.setStuid(stuid);
			grades.setGradingtype(gradingtype);
			grades.setGradingManId(gradingManId);
			
			//执行添加方法
			gradesService.addGrades(grades);
			
			//跳转
			request.getRequestDispatcher("/GradesServlet?method=listGrades&stuid="+stuid+"&gradingtype="+gradingtype).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
