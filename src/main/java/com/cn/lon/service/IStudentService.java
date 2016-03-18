package com.cn.lon.service;

import com.cn.lon.entity.Student;

/**
 * 学生业务逻辑层接口
 * @author Administrator
 *
 */
public interface IStudentService {
	public Student findByEmail(String email);	//通过email查找学生
}
