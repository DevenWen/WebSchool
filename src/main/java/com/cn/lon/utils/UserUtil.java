package com.cn.lon.utils;

import com.cn.lon.entity.Student;
import com.cn.lon.entity.Teacher;
import com.cn.lon.service.impl.StudentService;
import com.cn.lon.service.impl.TeacherService;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * 用户工具类：用来获取用户信息
 * @author Administrator
 *
 */
public class UserUtil {
	//调用的service
	private static final StudentService studentService=new StudentService();
	private static final TeacherService teacherService=new TeacherService();
	
	/**
	 * 获取当前用户的账号
	 * @param currentUser
	 * @return	返回账号
	 */
	public static String getUserId(LoginUser currentUser){
		//获取email
		String email = currentUser.getEmail();
		//判断当前用户的身份
		if(Integer.parseInt(currentUser.getAuthority())>1){
			//通过email查找获取学生对象
			Student student= studentService.findByEmail(email);
			//通过学生用户表获取评分人的账号
			String stuid=student.getStuid();
			return stuid;
		}
		else{
			//通过email查找获取教师对象
			Teacher teacher = teacherService.findByEmail(email);
			//通过教师用户表获取他的工号
			String teaid = teacher.getTeaid();
			return teaid;		
		}
	}
	
	/**
	 * 获取当前用户的名字
	 * @param currentUser
	 * @return	用户的名字
	 */
	public static String getUserName(LoginUser currentUser){
		//根据登录用户表查询当前用户的名字
		String name = currentUser.getName();
		return name;
	}
	
	
	/**
	 * 获取当前用户的账号
	 * @param currentUser
	 * @return	返回账号
	 */
	public static String getUserClas(LoginUser currentUser){
		//判断当前用户的身份
		if(Integer.parseInt(currentUser.getAuthority())>1){
			//如果是学生，获取他的email
			String email = currentUser.getEmail();	
			//通过email查找获取学生对象
			Student student= studentService.findByEmail(email);
			//通过学生用户表获取评分人的账号
			String stuClas=student.getClas();
			return stuClas;
		}
			
		return null;				
	}
	
	/**
	 * 获取当前用户的专业
	 * @param currentUser
	 * @return
	 */
	public static String getUserMajor(LoginUser currentUser){
		//判断当前用户的身份
		if(Integer.parseInt(currentUser.getAuthority())>1){
			//如果是学生，获取他的email
			String email = currentUser.getEmail();	
			//通过email查找获取学生对象
			Student student= studentService.findByEmail(email);
			//通过学生用户表获取评分人的专业
			String stuMajor=student.getMajor();
			return stuMajor;
		}
		return null;	
	}
	
	
}
