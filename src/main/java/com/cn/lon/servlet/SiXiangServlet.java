package com.cn.lon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.SiXiang;
import com.cn.lon.service.impl.SiXiangService;
import com.cn.lon.utils.UserUtil;
import com.cn.lon.utils.WebUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * 思想品德评分控制层
 * 
 * a.添加思想品德自评信息
 * b.显示思想品德评分信息
 * c.进入思想品德评分更新页面
 * d.更新思想品德评分信息
 * @author Administrator
 *
 */

@WebServlet("/SiXiangServlet")
public class SiXiangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//调用的service
	private SiXiangService siXiangService=new SiXiangService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		if("addSiXiang".equals(method)){
			addSiXiang(request,response);
		}
		else if("listSiXiang".equals(method)){
			listSiXiang(request,response);
		}
		else if("viewUpdate".equals(method)){
			viewUpdate(request,response);
		}
		else if("updateSiXiang".equals(method)){
			updateSiXiang(request,response);
		}
	}
	
	//d.更新思想品德评分信息
	private void updateSiXiang(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		SiXiang siXiang = WebUtil.copyToBean(request, SiXiang.class);
			
		try {
			//获取条件数据
			String stuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			
			siXiang.setStuid(stuid);
			siXiang.setGradingtype(gradingtype);
			siXiang.setGradingManId(gradingManId);
			
			//2. 调用Service更新
			siXiangService.updateSiXiang(siXiang);
			
			//3.跳转到显示页面
			request.getRequestDispatcher("/SiXiangServlet?method=listSiXiang&stuid="+stuid+"&gradingtype="+gradingtype).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//c.进入思想品德评分更新页面
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
			SiXiang sx = siXiangService.findById(stuid, gradingtype, gradingManId);
			
			//获取当前用户的姓名，班级
			String userName = UserUtil.getUserName(currentUser);
			String userClas = UserUtil.getUserClas(currentUser);
			
			//3.保存
			request.setAttribute("SX", sx);
			request.setAttribute("userName", userName);
			request.setAttribute("userClas", userClas);
			
			//4.跳转到更新页面
			request.getRequestDispatcher("/view/long/sixiang_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//b.显示思想品德评分信息
	private void listSiXiang(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			//1.获取评分类型
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			
			//判断评分类型
			if("自评".equals(gradingtype)){
				//如果是自评，那么被评分账号就是评分账号
				String stuid=gradingManId;			
				//获取当前用户的姓名，班级并保存
				String userName = UserUtil.getUserName(currentUser);
				String userClas = UserUtil.getUserClas(currentUser);
				request.setAttribute("userName", userName);
				request.setAttribute("userClas", userClas);
				
				//2.根据stuid查询对象
				SiXiang sx=siXiangService.findById(stuid,gradingtype,gradingManId);
			
				//判断获取的对象是否为空
				if(sx==null){
					//为空说明还没有数据，第一次评分，进入添加信息页面
					//保存
					request.setAttribute("stuid", stuid);
					request.setAttribute("gradingManId", gradingManId);
					request.setAttribute("gradingtype", gradingtype);
										
					//跳转到添加页面
					request.getRequestDispatcher("/view/long/sixiang_add.jsp").forward(request, response);
				}else{
					//3.把对象的信息保存到域中
					request.setAttribute("sx", sx);
									
					//4.跳转
					request.getRequestDispatcher("/view/long/sixiang_list.jsp").forward(request, response);
				}								
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	//a.添加思想品德自评信息
	private void addSiXiang(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		SiXiang siXiang = WebUtil.copyToBean(request, SiXiang.class);
	
		try {
			//封装剩下的数据
			String stuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			
			siXiang.setStuid(stuid);
			siXiang.setGradingtype(gradingtype);
			siXiang.setGradingManId(gradingManId);
			
			//执行添加方法
			siXiangService.addSiXiang(siXiang);
			
			//跳转
			request.getRequestDispatcher("/SiXiangServlet?method=listSiXiang&stuid="+stuid+"&gradingtype="+gradingtype).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
