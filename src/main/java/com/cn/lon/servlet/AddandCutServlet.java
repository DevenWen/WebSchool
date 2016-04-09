package com.cn.lon.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.AddandCut;
import com.cn.lon.entity.Student;
import com.cn.lon.service.IAddAndCutService;
import com.cn.lon.service.IStudentService;
import com.cn.lon.service.impl.AddAndCutService;
import com.cn.lon.service.impl.StudentService;
import com.cn.lon.utils.PageBean;
import com.cn.lon.utils.TimeOpenUtils;
import com.cn.lon.utils.UserUtil;
import com.cn.lon.utils.WebUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;

@WebServlet("/AddandCutServlet")
public class AddandCutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddandCutServlet() {
        super();
       
    }

    //实现service
  	private IStudentService studentService=new StudentService();
  	private IAddAndCutService addAndCutService=new AddAndCutService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取当前时间和开放时间
		long date = new Date().getTime();
		//获取系统的部分开发时间
		long beginTimeZP = TimeOpenUtils.getBeginTime("自评").getTime();
		long endTimeZP = TimeOpenUtils.getEndTime("自评").getTime();
		long beginTimeBP = TimeOpenUtils.getBeginTime("班评").getTime();
		long endTimeBP = TimeOpenUtils.getEndTime("班评").getTime();
		long endTimeXP = TimeOpenUtils.getEndTime("系评").getTime();	
		
		//获取用户的权限
		LoginUser currentUser = WebSchoolContext.getCurrentUser();
		String authority = currentUser.getAuthority();
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		//判断：学生在自评阶段可以添加加扣分信息
		if(date>beginTimeZP&date<endTimeZP){
			//判断为学生身份
			if(Integer.parseInt(authority)>1){
				if("listStudents".equals(method)){
					jionAddAndCut(request,response);
				}
			}
			else{
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			}
		}
		
		//班长在班评时间段可以审核加扣分
		else if(date>beginTimeBP&date<endTimeBP){
			if(Integer.parseInt(authority)==5){
				if("listStudents".equals(method)){
					listStudents(request,response);
				}
				else if("listAddAndCuts".equals(method)){
					listAddAndCuts(request,response);
				}
				else if("listAddAndCut".equals(method)){
					listAddAndCut(request,response);
				}
				else if("checkAddAndCut".equals(method)){
					checkAddAndCut(request,response);
				}
			}
			else{
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			}
		}
		
		//教师和管理员在系评结束后可以修改学生的评分信息
		else if(date>endTimeXP){
			if(Integer.parseInt(authority)==0||Integer.parseInt(authority)==1){
				if("searchStudentsByTeacher".equals(method)){
					searchStudentsByTeacher(request,response);
				}
				else if("listStudentsByTeacher".equals(method)){
					listStudentsByTeacher(request,response);
				}
				else if("updateView".equals(method)){
					updateView(request,response);
				}
				else if("updateGrade".equals(method)){
					updateGrade(request,response);
				}
			}
			else{
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			}
		}
		else{
			request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
		}
	}

	//更新评分（老师修改评分信息）
	private void updateGrade(HttpServletRequest request,
			HttpServletResponse response) {
		//通过工具获取像
		AddandCut addandcut = WebUtil.copyToBean(request, AddandCut.class);
		
		//获取学号
		String stuid = request.getParameter("stuid");
		
		//设置通过审核
		String checked="1";
		String pictureurl="pass";
		//获取当前登录用户对象，以及他的学号
		LoginUser currentUser = WebSchoolContext.getCurrentUser();
		String checkManId = UserUtil.getUserId(currentUser);
		
		//封装剩下数据
		addandcut.setChecked(checked);
		addandcut.setPictureurl(pictureurl);
		addandcut.setStuid(stuid);
		addandcut.setCheckemanid(checkManId);
		
		//调用service更新（即添加）
		addAndCutService.addAddandCut(addandcut);
		
		//显示成功信息
		try {
			response.getWriter().println("<div  style='color: blue; font-size: 25px'>信息提交成功！</div>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//进入修改页面（老师修改评分信息）
	private void updateView(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取学号和姓名
			String stuid = request.getParameter("stuid");
			String name = request.getParameter("name");
			
			//保存到域中
			request.setAttribute("stuid", stuid);
			request.setAttribute("name", name);
			
			//跳转页到修改页面
			request.getRequestDispatcher("/view/long/add_cut/grade_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//老师通过学号查询出学生列表（老师修改评分信息）
	private void listStudentsByTeacher(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取要查询的学号
			String stuid_search = request.getParameter("stuid_search");
			
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
			studentService.getAllByStuid(pageBean, stuid_search);
			
			//4. 保存pageBean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("stuid_search", stuid_search);
			
			//5.跳转到jsp页面
			request.getRequestDispatcher("/view/long/add_cut/students_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//老师查询学生进入首页（老师修改评分信息）
	private void searchStudentsByTeacher(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/add_cut/id_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	//通过审核（班长审核）
	private void checkAddAndCut(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取当前登录用户对象，以及他的学号
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			String checkManId = UserUtil.getUserId(currentUser);
			
			//设置通过审核的标识为1
			String checked="1";
			
			//获取要更新数据的id，学号，姓名
			String id = request.getParameter("id");
			String stuid = request.getParameter("stuid");
			String name = request.getParameter("name");
			//获取该id的数据对象
			AddandCut addandcut = addAndCutService.findById(Integer.parseInt(id));
			
			//封装
			addandcut.setChecked(checked);
			addandcut.setCheckemanid(checkManId);
			
			//更新数据
			addAndCutService.updateAddandCut(addandcut);
			
			//跳转到加扣分信息列表页面
			request.getRequestDispatcher("/AddandCutServlet?method=listAddAndCuts&stuid="+stuid+"&name="+name).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//显示加扣分信息（班长审核）
	private void listAddAndCut(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取加扣分数据的编号
			String id = request.getParameter("id");
			String stuid = request.getParameter("stuid");
			String name = request.getParameter("name");
			
			//获取加扣分对象
			AddandCut ac = addAndCutService.findById(Integer.parseInt(id));
			
			//保存到域中
			request.setAttribute("ac", ac);
			request.setAttribute("stuid", stuid);
			request.setAttribute("name", name);
			
			//跳转页面
			request.getRequestDispatcher("/view/long/add_cut/add_cut_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//显示该学生的加扣分信息列表（班长审核）
	private void listAddAndCuts(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取学号
			String stuid = request.getParameter("stuid");
			String name = request.getParameter("name");
			
			//查询出加扣分信息对象
			List<AddandCut> addandcuts = addAndCutService.findByStuid(stuid);
			
			//保存到域中
			request.setAttribute("addandcuts", addandcuts);
			request.setAttribute("stuid", stuid);
			request.setAttribute("name", name);
			
			//跳转页面
			request.getRequestDispatcher("/view/long/add_cut/add_cuts_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//显示该班的所有学生(班长审核)
	private void listStudents(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//获取当前登录用户对象
			LoginUser currentUser = WebSchoolContext.getCurrentUser();
			//通过用户工具类获取当前用户的专业和班级
			String major=UserUtil.getUserMajor(currentUser);
			String clas=UserUtil.getUserClas(currentUser);
			
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
			
			//5. 跳转 
			request.getRequestDispatcher("/view/long/add_cut/students_list.jsp").forward(request, response);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//进入加扣分信息（学生添加自评信息）
	private void jionAddAndCut(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/add_cut/add_cut_input.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
