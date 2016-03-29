package com.cn.lon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.lon.entity.ZHGrades;
import com.cn.lon.service.impl.ZHGradesService;

/**
 * Servlet implementation class SearchServlet_ajax
 */
@WebServlet("/SearchServlet_ajax")
public class SearchServlet_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

    //实现service
    private ZHGradesService zhGrades=new ZHGradesService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				
				//1.获取要查询的学号
				String stuid=request.getParameter("stuid");
				
				//2.根据学号查询
				ZHGrades zg = zhGrades.findById(stuid);
				JSONObject result = new JSONObject();
				result.put("zg", zg);
				//通知AJAX异步对z象，服务器响应的数据为xml格式的
				response.setContentType("text/xml;charset=UTF-8");
				//获取字符输出流
				PrintWriter pw = response.getWriter();
//				System.out.println(result.toString());
				pw.write(result.toString());
				
				pw.flush();
				pw.close();
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
