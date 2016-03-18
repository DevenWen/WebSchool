package com.cn.lon.dao;

import com.cn.lon.entity.Student;

/**
 * 学生数据层接口
 * @author Administrator
 *
 */
public interface IStudentDao {
	
	public Student findByEmail(String email);	//通过email查找学生
}
