package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IStudentDao;
import com.cn.lon.entity.Student;
import com.cn.lon.utils.BaseDaoUtil;
/*
 * 学生数据层实现类
 */
public class StudentDao extends BaseDaoUtil implements IStudentDao {

	@Override
	public Student findByEmail(String email) {
		String sql="select * from student where email=?";
		
		Object[] paramsValue = {email};
		
		List<Student> list = super.query(sql,paramsValue , Student.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
