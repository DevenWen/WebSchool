package com.cn.lon.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.TimeOpen;
import com.cn.lon.service.impl.TimeOpenService;
import com.cn.lon.utils.TimeOpenUtils;


@WebServlet("/TimeOpenServlet")
public class TimeOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TimeOpenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //实现service
    private TimeOpenService timeOpenService=new TimeOpenService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		if("addTime".equals(method)){
			addTime(request,response);
		}
		else if("listTime".equals(method)){
			listTime(request,response);
		}
		else if("updateTime".equals(method)){
			updateTime(request,response);
		}
	}

	//更新时间
	private void updateTime(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.创建对像
			TimeOpen timeOpen=new TimeOpen();
				
			//2.调用转换封装工具类
			TimeOpenUtils.StringToDate(request, timeOpen);

			//3.执行添加方法
			timeOpenService.updateTime(timeOpen);
			
			//4.跳转
			request.getRequestDispatcher("/TimeOpenServlet?method=listTime").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//显示时间
	private void listTime(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取对象
			TimeOpen times = timeOpenService.find();
			
			//2.判断
			if(times==null){
				//2.1如果为空，调到添加页面
				request.getRequestDispatcher("/view/long/timeopen/timeopen_add.jsp").forward(request, response);
			}else{	
				//2.2不为空就保存到域中
				request.setAttribute("times", times);
				//2.3跳转到显示页面
				request.getRequestDispatcher("/view/long/timeopen/timeopen_list.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	private void addTime(HttpServletRequest request,
			HttpServletResponse response) {
		//1.获取表单上的对象
//		TimeOpen timeOpen = WebUtil.copyToBean(request, TimeOpen.class);
		try {
			//1.创建对像
			TimeOpen timeOpen=new TimeOpen();
				
			//2.调用转换封装工具类
			TimeOpenUtils.StringToDate(request, timeOpen);
		
			//3.执行添加方法
			timeOpenService.addTime(timeOpen);
			
			//4.跳转页面
			request.getRequestDispatcher("/TimeOpenServlet?method=listTime").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
