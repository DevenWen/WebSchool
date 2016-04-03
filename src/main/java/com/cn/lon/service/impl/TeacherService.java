package com.cn.lon.service.impl;

import com.cn.lon.dao.impl.TeacherDao;
import com.cn.lon.entity.Teacher;
import com.cn.lon.service.ITeacherService;
/**
 * 教职工的业务层实体
 * @author Administrator
 *
 */
public class TeacherService implements ITeacherService{

	private TeacherDao teacherDao=new TeacherDao();
	@Override
	public Teacher findByEmail(String email) {
		
		return teacherDao.findByEmail(email);
	}

}
