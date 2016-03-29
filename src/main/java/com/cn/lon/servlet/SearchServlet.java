package com.cn.lon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.ZHGrades;
import com.cn.lon.service.impl.ZHGradesService;
import com.cn.lon.utils.PageBean;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //实现service
    private ZHGradesService zhGrades=new ZHGradesService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		if("listByIdFirst".equals(method)){
			listByIdFirst(request,response);
		}
		else if("listById".equals(method)){
			listById(request,response);
		}
		else if("listByIdFirst".equals(method)){
			listByIdFirst(request,response);
		}
		else if("listByMajorOrClasFirst".equals(method)){
			listByMajorOrClasFirst(request,response);
		}
		else if("listByMajorOrClas".equals(method)){
			listByMajorOrClas(request,response);
		}
		
		
	}

	

	private void listByMajorOrClasFirst(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/searchgrades/mOrc_search_first.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//通过专业或学号进行模糊查询
	private void listByMajorOrClas(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = request.getParameter("currentPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 类型转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<ZHGrades> pb=new PageBean<ZHGrades>();
			pb.setCurrentPage(currentPage);
			
			//3.获取要查询的专业和班级
			String major=request.getParameter("major");
			String clas=request.getParameter("clas");
					
			//4.判断
			if(major!=null&&major.length()!=0&&clas!=null&&clas.length()!=0){
				//4.1如果专业和班级都不为空,调用service,把数据传递pb对象中
				zhGrades.getAllByMajorAndClas(pb, major, clas);
			}
			else if(major!=null&&major.length()!=0&&(clas==null||clas.length()==0)){
				//4.2如果专业不为空,班级为空，调用service,把数据传递pb对象中
				zhGrades.getAllByMajor(pb, major);
			}
			else if((major==null||major.length()==0)&&clas!=null&&clas.length()!=0){
				//4.3如果专业为空,班级不为空，调用service,把数据传递pb对象中
				zhGrades.getAllByMajor(pb, major);
			}
			
			//5.把对象保存到域中
			request.setAttribute("pb", pb);
			request.setAttribute("major", major);
			request.setAttribute("clas", clas);
			
			//6.跳转
			request.getRequestDispatcher("/view/long/searchgrades/mOrc_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	private void listByIdFirst(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/searchgrades/id_search_first.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	//通过学号查询
	private void listById(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取要查询的学号
			String stuid=request.getParameter("stuid");
			
			//2.根据学号查询
			ZHGrades zg = zhGrades.findById(stuid);
			
			//3.把对象保存到域中
			request.setAttribute("zg", zg);
			
			//4.跳转页面
			request.getRequestDispatcher("/view/long/searchgrades/id_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
