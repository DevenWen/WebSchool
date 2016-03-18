package com.cn.lon.service.impl;

import com.cn.lon.dao.IStudentDao;
import com.cn.lon.dao.impl.StudentDao;
import com.cn.lon.entity.Student;
import com.cn.lon.service.IStudentService;
/**
 * 学生业务逻辑层实现类
 * @author Administrator
 *
 */
public class StudentService implements IStudentService {
	private IStudentDao studentDao=new StudentDao();
	
	public Student findByEmail(String email) {
		
		return studentDao.findByEmail(email);
	}

}
