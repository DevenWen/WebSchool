package com.cn.lon.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.cn.lon.entity.ZHGrades;
import com.cn.lon.service.IZHGradesService;
import com.cn.lon.service.impl.ZHGradesService;
import com.cn.lon.utils.TimeOpenUtils;


@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RankingServlet() {
        super();
       
    }

	private IZHGradesService zhGradesService=new ZHGradesService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型和评分类型
		String method = request.getParameter("method");
		
		//获取当前时间和开放时间
		long endTime = TimeOpenUtils.getEndTime("系评").getTime();
		long date = new Date().getTime();
		
		//判断
		if(date>endTime){
			//过了系评时间
			if("searchByMajor".equals(method)){
				searchByMajor(request,response);
			}
			else if("DbToExcel".equals(method)){
				DbToExcel(request,response);
			}
		}else{
			//系评前
			try {
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	//进入查询专业首页面
	private void searchByMajor(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/rank/searchbymajor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//生成评优名单
	private void DbToExcel(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String major = request.getParameter("major");

			//获取排名数据
			List<ZHGrades> list = zhGradesService.getAllByMajor(major);
			
			if(list.size()>0){
				WritableWorkbook wwb = null;
				
				// 创建可写入的Excel工作簿
				String fileName = "F://"+major+"专业评优名单.xls";
				File file=new File(fileName);
				if (!file.exists()) {
				    file.createNewFile();
				}
				//以fileName为文件名来创建一个Workbook
				wwb = Workbook.createWorkbook(file);
	
				// 创建工作表
				WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
				
				//要插入到的Excel表格的行号，默认从0开始
	            Label labelStuid= new Label(0, 0, "学号");//表示第
	            Label labelName= new Label(1, 0, "姓名");
	            Label labelMajor= new Label(2, 0, "专业");
	            Label labelClas= new Label(3, 0, "班级");
	            Label labelSx_score= new Label(4, 0, "思想分");
	            Label labelSx_place= new Label(5, 0, "思想分排名");
	            Label labelXy_score= new Label(6, 0, "学业分");
	            Label labelXy_place= new Label(7, 0, "学业分排名");
	            Label labelWt_score= new Label(8, 0, "文体分");
	            Label labelWt_place= new Label(9, 0, "文体分排名");
	            Label labelZh_score= new Label(10, 0, "综合分");
	            Label labelZh_place= new Label(11, 0, "综合分排名");
	            ws.addCell(labelStuid);
	            ws.addCell(labelName);
	            ws.addCell(labelMajor);
	            ws.addCell(labelClas);
	            ws.addCell(labelSx_score);
	            ws.addCell(labelSx_place);
	            ws.addCell(labelXy_score);
	            ws.addCell(labelXy_place);
	            ws.addCell(labelWt_score);
	            ws.addCell(labelWt_place);
	            ws.addCell(labelZh_score);
	            ws.addCell(labelZh_place);
	            for (int i = 0; i < list.size(); i++) {
	                Label labelStuid_i= new Label(0, i+1, list.get(i).getStuid());
	                Label labelName_i= new Label(1, i+1, list.get(i).getName());
	                Label labelMajor_i= new Label(2, i+1, list.get(i).getMajor());
	                Label labelClas_i= new Label(3, i+1, list.get(i).getClas());
	                Label labelSx_score_i= new Label(4, i+1, String.valueOf(list.get(i).getSx_score()));
	                Label labelSx_place_i= new Label(5, i+1, String.valueOf(list.get(i).getSx_place()));
	                Label labelXy_score_i= new Label(6, i+1, String.valueOf(list.get(i).getXy_score()));
	                Label labelXy_place_i= new Label(7, i+1, String.valueOf(list.get(i).getXy_place()));
	                Label labelWt_score_i= new Label(8, i+1, String.valueOf(list.get(i).getWt_score()));
	                Label labelWt_place_i= new Label(9, i+1, String.valueOf(list.get(i).getWt_place()));
	                Label labelZh_score_i= new Label(10, i+1, String.valueOf(list.get(i).getZh_score()));
	                Label labelZh_place_i= new Label(11, i+1, String.valueOf(list.get(i).getZh_place()));
	                ws.addCell(labelStuid_i);
	                ws.addCell(labelName_i);
	                ws.addCell(labelMajor_i);
	                ws.addCell(labelClas_i);
	                ws.addCell(labelSx_score_i);
	                ws.addCell(labelSx_place_i);
	                ws.addCell(labelXy_score_i);
	                ws.addCell(labelXy_place_i);
	                ws.addCell(labelWt_score_i);
	                ws.addCell(labelWt_place_i);
	                ws.addCell(labelZh_score_i);
	                ws.addCell(labelZh_place_i);
	            }
	          
	           //写进文档
	            wwb.write();
	           // 关闭Excel工作簿对象
	            wwb.close();
	            response.getWriter().println("<div  style='color: blue; font-size: 25px'>报表已成功生成！</div>");
			}else{
				response.getWriter().println("<div  style='color: blue; font-size: 25px'>请输入正确的数据！</div>");
			}
            
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
