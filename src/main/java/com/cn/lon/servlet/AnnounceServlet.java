package com.cn.lon.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.Announce;
import com.cn.lon.service.impl.AnnounceService;
import com.cn.lon.utils.WebUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * Servlet implementation class AnnounceServlet
 */
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private AnnounceService announceService=new AnnounceService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		if("listTitles".equals(method)){
			listTitles(request,response);
		}
		else if("addAnnounce".equals(method)){
			addAnnounce(request,response);
		}
		else if("listTitlesToStu".equals(method)){
			listTitlesToStu(request,response);
		}
		else if("listAnnounce".equals(method)){
			listAnnounce(request,response);
		}
		else if("deleteAnnounce".equals(method)){
			deleteAnnounce(request,response);
		}
	}

	//删除公告
	private void deleteAnnounce(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取要查看公告的标题
			String title=request.getParameter("title");
			
			//2.调用方法进行删除公告信息
			announceService.deleteAnnounce(title);

			//3.跳转
			request.getRequestDispatcher("/AnnounceServlet?method=listTitles").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//显示公告信息
	private void listAnnounce(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取要查看公告的标题
			String title=request.getParameter("title");
			
			//2.调用方法获取公告信息对象
			Announce announce=announceService.findByTitle(title);
			
			//3.把结果保存到域对象中
			request.setAttribute("announce",announce);
			
			//4.跳转
			request.getRequestDispatcher("/view/long/announce/announce_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//在学生界面显示公告标题
	private void listTitlesToStu(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.调用方法获取所有公告
			List<Announce> list= announceService.getAll();
					
			//2.把结果保存到域对象中
			request.setAttribute("ans",list);
			
			//3.跳转
			request.getRequestDispatcher("/view/long/announce/titles_list_stu.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//显示公告标题
	private void listTitles(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.调用方法获取所有公告
			List<Announce> list= announceService.getAll();
					
			//2.把结果保存到域对象中
			request.setAttribute("ans",list);
			
			//3.跳转
			request.getRequestDispatcher("/view/long/announce/titles_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//添加公告
	private void addAnnounce(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		Announce announce = WebUtil.copyToBean(request, Announce.class);
		
		try {
			//封装剩下的数据
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			String announceman=currentUser.getName();
			Date time=new Date();
			
			announce.setAnnounceman(announceman);
			announce.setTime(time);
			
			//执行添加方法
			announceService.addAnnounce(announce);
			
			//跳转
			request.getRequestDispatcher("/AnnounceServlet?method=listTitles").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
