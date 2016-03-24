package com.cn.lon.service.impl;

import java.util.List;

import com.cn.lon.dao.IStudentDao;
import com.cn.lon.dao.impl.StudentDao;
import com.cn.lon.entity.Student;
import com.cn.lon.service.IStudentService;
import com.cn.lon.utils.PageBean;
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

	@Override
	public List<Student> findByMajorAndClas(String major, String clas) {
		return studentDao.findByMajorAndClas(major, clas);
	}

	/***分页查询数据*****/
	public void getAll(PageBean<Student> pb, String major, String clas) {
		try {
			studentDao.getAll(pb, major, clas);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
