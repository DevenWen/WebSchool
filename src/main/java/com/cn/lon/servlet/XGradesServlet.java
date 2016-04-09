package com.cn.lon.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.Grades;
import com.cn.lon.entity.Student;
import com.cn.lon.service.IGradesService;
import com.cn.lon.service.IStudentService;
import com.cn.lon.service.impl.GradesService;
import com.cn.lon.service.impl.StudentService;
import com.cn.lon.utils.PageBean;
import com.cn.lon.utils.TimeOpenUtils;
import com.cn.lon.utils.UserUtil;
import com.cn.lon.utils.WebUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;
/**
 * a.显示要系评班级的学生列表
 * b.显示自评和班评的平均分信息，判断该同学的系评信息是否有数据，有就显示，没有就跳转到添加页面
 * c.添加系评信息
 * d.进入系评更新页面
 * e.更新系评信息
 * @author Administrator
 *
 */

@WebServlet("/XGradesServlet")
public class XGradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//实现service
	private IStudentService studentService=new StudentService();
	private IGradesService gradesService=new GradesService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			//还没到系评时间
			try {
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		else if(date>beginTime&date<endTime){
			//系评时间
			//1.获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			
			//2.获取权限
			String authority = currentUser.getAuthority();
			
			//3.判断权限
			if(!"3".equals(authority)){
				//其他学生
				try {
					request.getRequestDispatcher("/view/long/message/xgtips.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			else if("3".equals(authority)){
				//系评人员
			//	type="show";
				
				//判断
				if("findClas".equals(method)){
					findClas(request,response);
				}
				if("listStudent".equals(method)){
					listStudent(request,response);
				}
				else if("listXGrades".equals(method)){
					listXGrades(request,response);
				}
				else if("addXGrades".equals(method)){
					addXGrades(request,response);
				}
				else if("viewUpdate".equals(method)){
					viewUpdate(request,response);
				}
				else if("updateXGrades".equals(method)){
					updateXGrades(request,response);
				}
			}
						
		}
		else if(date>endTime){
			//过了系评时间			
			type="hidden";
			
			if("findClas".equals(method)){
				listXGradesLater(request,response,type);
			}
		}
		
	}

	//f.系评过后显示系评成绩
	private void listXGradesLater(HttpServletRequest request,
			HttpServletResponse response, String type) {
		try {
			//1.获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();		
			//通过用户工具类获取当前用户的账号
			String gradingManId = UserUtil.getUserId(currentUser);
			//被评分人就是当前用户
			String stuid=gradingManId;
			
			//2.获取当前用户的姓名，班级并保存
			String userName = UserUtil.getUserName(currentUser);
			String userClas = UserUtil.getUserClas(currentUser);
			request.setAttribute("zname", userName);
			request.setAttribute("zclas", userClas);
			request.setAttribute("zstuid", stuid);
			
			//3.查询自评成绩对象
			Grades zgra=gradesService.findById(stuid, "自评", gradingManId);
			//查询班评平均成绩对象
			Grades bgra=gradesService.findAverageGrades(stuid, "班评");
			//查询系评平均成绩对象
			Grades xgra=gradesService.findAverageGrades(stuid, "系评");
			
			//4.保存到域对象中
			request.setAttribute("zgra",zgra);
			request.setAttribute("bgra",bgra);
			request.setAttribute("xgra",xgra);
			request.setAttribute("type",type);
			
			//5.跳转
			request.getRequestDispatcher("/view/long/xgrades/xgrades_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//e.更新系评信息
	private void updateXGrades(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		Grades xgrades= WebUtil.copyToBean(request, Grades.class);
		
		try {
			//封装剩下的数据
			String zstuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			//通过用户工具类获取当前用户的账号
			String xgradingManId = UserUtil.getUserId(currentUser);
			
			xgrades.setStuid(zstuid);
			xgrades.setGradingtype(gradingtype);
			xgrades.setGradingManId(xgradingManId);
			
			//2. 调用Service更新
			gradesService.updateGrades(xgrades);
			
			//获取被评分学生的名字和班级，用于传递给显示页面
			String zname=request.getParameter("name");
			String zclas=request.getParameter("clas");
			
			//3.跳转到显示页面
			request.getRequestDispatcher("/XGradesServlet?method=listXGrades&stuid="+zstuid+"&gradingtype="+gradingtype+"&name="+zname+"&clas="+zclas).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//d.进入系评更新页面
	private void viewUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			//1.获取被评学生编号，评分类型，评分人编号
			String stuid = request.getParameter("stuid");
			String gradingtype = request.getParameter("gradingtype");
				
			//2.1根据条件查询被评分人自评信息对象
			Grades zgra= gradesService.findById(stuid, "自评", stuid);
			//2.2根据条件查询被评分人班评信息对象
			Grades bgra= gradesService.findAverageGrades(stuid, "班评");
			//2.3根据条件查询被评分人系评信息对象
			Grades xgra= gradesService.findAverageGrades(stuid, gradingtype);
			
			//获取被评分人的姓名，班级
			String name=request.getParameter("name");
			String clas=request.getParameter("clas");
			
			//3.保存
			request.setAttribute("zgra", zgra);
			request.setAttribute("bgra", bgra);
			request.setAttribute("xgra", xgra);
			request.setAttribute("name", name);
			request.setAttribute("clas",clas);
			
			//4.跳转到班评更新页面
			request.getRequestDispatcher("/view/long/xgrades/xgrades_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//c.添加系评信息
	private void addXGrades(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单上的对象
		Grades xgrades = WebUtil.copyToBean(request, Grades.class);
		
		try {
			//封装剩下的数据
			String zstuid=request.getParameter("stuid");
			String gradingtype=request.getParameter("gradingtype");
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			//通过用户工具类获取当前用户的账号
			String xgradingManId = UserUtil.getUserId(currentUser);
			
			xgrades.setStuid(zstuid);
			xgrades.setGradingtype(gradingtype);
			xgrades.setGradingManId(xgradingManId);
			
			//执行添加方法
			gradesService.addGrades(xgrades);
			
			//获取被评分学生基本信息
			String zname = request.getParameter("name");
			String zclas = request.getParameter("clas");
			
			//跳转
			request.getRequestDispatcher("/XGradesServlet?method=listXGrades&stuid="+zstuid+"&name="+zname+"&clas="+zclas+"&gradingtype="+gradingtype).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//b.显示自评和班评的平均分信息，判断该同学的系评信息是否有数据，有就显示，没有就跳转到添加页面
	private void listXGrades(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取评分类型
			String gradingtype=request.getParameter("gradingtype");
			
			//2.1获取被评分人的学号，姓名，班级
			String zstuid=request.getParameter("stuid");
			String zname=request.getParameter("name");
			String zclas=request.getParameter("clas");
			
			//2.2得到被评分人的自评信息
			Grades zgra=gradesService.findById(zstuid, "自评", zstuid);
			//2.3把信息保存到域中和传递被评分人的基本信息
			request.setAttribute("zgra", zgra);
			request.setAttribute("zstuid", zstuid);
			request.setAttribute("zname", zname);
			request.setAttribute("zclas", zclas);
			
			//3.1得到被评分同学的班评平均分信息
			Grades bgra=gradesService.findAverageGrades(zstuid, "班评");
			//3.2把班评信息保存到域中
			request.setAttribute("bgra",bgra);
			
			//判断评分类型
			if("系评".equals(gradingtype)){ 
				//如果是系评，先查出该被评分人的班评信息
				//获取当前登录用户对象
				LoginUser currentUser = WebSchoolContext.getCurrentUser();
				//通过用户工具类获取当前用户的账号
				String xgradingManId = UserUtil.getUserId(currentUser);
				Grades xgra=gradesService.findById(zstuid, gradingtype, xgradingManId);
				
				//判断获取的对象是否为空
				if(xgra==null){
					//为空说明还没有数据，第一次进行系评，进入添加系评信息页面	
					request.setAttribute("gradingtype", gradingtype);
					//跳转到添加页面
					request.getRequestDispatcher("/view/long/xgrades/xgrades_add.jsp").forward(request, response);
				}else{
					//3.把对象的信息保存到域中
					request.setAttribute("xgra", xgra);
					
					//4.跳转到显示页面
					request.getRequestDispatcher("/view/long/xgrades/xgrades_list.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//a.显示要系评班级的学生列表
	private void listStudent(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			//通过用户工具类获取当前用户的专业
			String major=UserUtil.getUserMajor(currentUser);
			//获取要查询的班级
			String clas=request.getParameter("clas");
			//获取评分类型
			String gradingtype=request.getParameter("gradingtype");
			
			
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = request.getParameter("currentPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 类型转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<Student> pageBean=new PageBean<Student>();
			pageBean.setCurrentPage(currentPage);
			
			//3. 调用service  
			studentService.getAll(pageBean, major, clas);
			
			//4. 保存pageBean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("clas", clas);
			
			//调用方法获取要查询班的所有学生
	//		List<Student> list= studentService.findByMajorAndClas(major, clas);
			
			//2.把结果保存到域对象中
	//		request.setAttribute("students",list);
			request.setAttribute("gradingtype", gradingtype);
			
			//3.跳转到jsp页面
			request.getRequestDispatcher("/view/long/xgrades/xstudent_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//进入班级输入页面
	private void findClas(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/xgrades/clas_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
