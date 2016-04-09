package com.cn.lon.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.lon.entity.Student;
import com.cn.lon.service.ILoginUserService;
import com.cn.lon.service.IStudentService;
import com.cn.lon.service.impl.LoginUserService;
import com.cn.lon.service.impl.StudentService;
import com.cn.lon.utils.PageBean;
import com.cn.lon.utils.TimeOpenUtils;
import com.cn.lon.utils.UserUtil;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;


@WebServlet("/ImpowerServlet")
public class ImpowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ImpowerServlet() {
        super();       
    }

    
    //实现service
  	private IStudentService studentService=new StudentService();
  	private ILoginUserService userService=new LoginUserService();
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		/*
		 * 关于授权与系统开发时间的问题：
		 * 1.班长授予普通学生有班评学生权限在班评结束前，在此之后该授权功能失效，建议在自评时间段进行
		 * 2.老师授予普通学生有班长权限必须在班评时间开放前
		 * 3.老师授予学生有系评学生权限必须在班评结束后，系评结束前。以防如果在班评时授予影响班评情况
		 */
		
		//获取当前时间和开放时间
		long date = new Date().getTime();
		//获取系统的部分开发时间
		long beginTimeBP = TimeOpenUtils.getBeginTime("班评").getTime();
		long endTimeBP = TimeOpenUtils.getEndTime("班评").getTime();
		long endTimeXP = TimeOpenUtils.getEndTime("系评").getTime();		
		
		// 获取操作类型和评分类型
		String method = request.getParameter("method");
		String man = request.getParameter("man");
				
		//1.班长授予普通学生有班评学生权限在班评结束前
		if("student".equals(man)){	
			if(date<endTimeBP){
				//班长授权班评学生
				if("listMyClasStudents".equals(method)){
					listMyClasStudents(request,response);
				}
				else if("listMyClasStudent".equals(method)){
					listMyClasStudent(request,response);
				}
				else if("impowerToBpstu".equals(method)){
					impowerToBpstu(request,response);
				}
				else{
					request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
				}
			}else{
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
			}
		}
		//2.老师授予普通学生有班长权限必须在班评时间开放前
		if("teacher".equals(man)){
			if(date<beginTimeBP){
				if("findStuid".equals(method)){
					findStuid(request,response);
				}
				else if("listStudents".equals(method)){
					listStudents(request,response);
				}
				else if("listStudent".equals(method)){
					listStudent(request,response);
				}
				else if("impowerToBz".equals(method)){
					impowerToBz(request,response);
				}
				else{
					request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
				}
			}
			//3.老师授予学生有系评学生权限必须在班评结束后，系评结束前
			else if(date>beginTimeBP&date<endTimeXP){
				if("findStuid".equals(method)){
					findStuid(request,response);
				}
				else if("listStudents".equals(method)){
					listStudents(request,response);
				}
				else if("listStudent".equals(method)){
					listStudent(request,response);
				}
				else if("impowerToXpstu".equals(method)){
					impowerToXpstu(request,response);
				}
				else{
					request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
				}
			}
			else{
				request.getRequestDispatcher("/view/long/message/tips.jsp").forward(request, response);
				
			}
		}

/*
		if("findStuid".equals(method)){
			findStuid(request,response);
		}
		else if("listStudents".equals(method)){
			listStudents(request,response);
		}
		else if("listStudent".equals(method)){
			listStudent(request,response);
		}
		else if("impowerToBz".equals(method)){
			impowerToBz(request,response);
		}
		else if("impowerToXpstu".equals(method)){
			impowerToXpstu(request,response);
		}
		else if("listMyClasStudents".equals(method)){
			listMyClasStudents(request,response);
		}
		else if("listMyClasStudent".equals(method)){
			listMyClasStudent(request,response);
		}
		else if("impowerToBpstu".equals(method)){
			impowerToBpstu(request,response);
		}
*/		
	}

	//授权为班评学生（班长）
	private void impowerToBpstu(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取该学生的学号以及权限
			String stuid = request.getParameter("stuid");
			String authority = request.getParameter("authority");
					
			//2.获取学生对象
			Student student = studentService.findByStuid(stuid);
			//2.1获取email
			String email = student.getEmail();
			//2.2获取用户对象
			LoginUser user = userService.findByEmail(email);
			
			//3.封装数据
			user.setEmail(email);
			//判断权限
			if("6".equals(authority)){
				//班评学生-->普通学生			
				user.setAuthority("8");			
			}
			else if("8".equals(authority)){
				//普通学生-->班评学生
				user.setAuthority("6");	
			}
			else if("5".equals(authority)){
				//班长-->班长
				user.setAuthority("5");	
			}
			
			//4.执行更新权限
			userService.updateAuthority(user);
			
			String authorityLater = user.getAuthority();
			
			//5.保存到域中
			request.setAttribute("student", student);
			request.setAttribute("authority", authorityLater);
			
			//6.跳转
			request.getRequestDispatcher("/view/long/impowewr/myClasStudent_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//进入该班学生信息表（班长）
	private void listMyClasStudent(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取该学生的学号
			String stuid = request.getParameter("stuid");
			
			//2.获取学生对象
			Student student = studentService.findByStuid(stuid);
			//2.1获取email
			String email = student.getEmail();
			//2.2获取用户对象
			LoginUser user = userService.findByEmail(email);
			//2.3获取该用户的权限
			String authority = user.getAuthority();
			
			//3.保存到域中
			request.setAttribute("student", student);
			request.setAttribute("authority", authority);
			
			//4.跳转页面
			request.getRequestDispatcher("/view/long/impowewr/myClasStudent_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//进入该班学生列表（班长）
	private void listMyClasStudents(HttpServletRequest request,
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
			request.getRequestDispatcher("/view/long/impowewr/myClasStudents_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
			
		
	}

	//授权为系评学生（老师）
	private void impowerToXpstu(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取该学生的学号以及权限
			String stuid = request.getParameter("stuid");
			String authority = request.getParameter("authority");
					
			//2.获取学生对象
			Student student = studentService.findByStuid(stuid);
			//2.1获取email
			String email = student.getEmail();
			//2.2获取用户对象
			LoginUser user = userService.findByEmail(email);
			
			//3.封装数据
			user.setEmail(email);
			//判断权限
			if("3".equals(authority)){
				//系评学生-->普通学生			
				user.setAuthority("8");			
			}else{
				//其他-->系评学生
				user.setAuthority("3");	
			}
			
			//4.执行更新权限
			userService.updateAuthority(user);
			
			String authorityLater = user.getAuthority();
			
			//5.保存到域中
			request.setAttribute("student", student);
			request.setAttribute("authority", authorityLater);
			
			//6.跳转
			request.getRequestDispatcher("/view/long/impowewr/student_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//授权为班长（老师）
	private void impowerToBz(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取该学生的学号以及权限
			String stuid = request.getParameter("stuid");
			String authority = request.getParameter("authority");
					
			//2.获取学生对象
			Student student = studentService.findByStuid(stuid);
			//2.1获取email
			String email = student.getEmail();
			//2.2获取用户对象
			LoginUser user = userService.findByEmail(email);
			
			//3.封装数据
			user.setEmail(email);
			//判断权限
			if("5".equals(authority)){
				//班长-->普通学生			
				user.setAuthority("8");			
			}else{
				//其他-->班长
				user.setAuthority("5");	
			}
			
			//4.执行更新权限
			userService.updateAuthority(user);
			
			String authorityLater = user.getAuthority();
			
			//5.保存到域中
			request.setAttribute("student", student);
			request.setAttribute("authority", authorityLater);
			
			//6.跳转
			request.getRequestDispatcher("/view/long/impowewr/student_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//进入学生信息页面（老师）
	private void listStudent(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.获取该学生的学号
			String stuid = request.getParameter("stuid");
			//获取模糊查询的学号
			String stuid_search = request.getParameter("stuid_search");
			
			//2.获取学生对象
			Student student = studentService.findByStuid(stuid);
			//2.1获取email
			String email = student.getEmail();
			//2.2获取用户对象
			LoginUser user = userService.findByEmail(email);
			//2.3获取该用户的权限
			String authority = user.getAuthority();
			
			//3.保存到域中
			request.setAttribute("student", student);
			request.setAttribute("authority", authority);
			request.setAttribute("stuid_search", stuid_search);
			
			//4.跳转页面
			request.getRequestDispatcher("/view/long/impowewr/student_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	//查询符合条件的所有学生（老师）
	private void listStudents(HttpServletRequest request,
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
			request.getRequestDispatcher("/view/long/impowewr/students_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	//进入学号输入页面（老师）
	private void findStuid(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/view/long/impowewr/id_search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
