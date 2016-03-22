package com.cn.lon.dao;

import java.util.List;

import com.cn.lon.entity.Student;

/**
 * 学生数据层接口
 * @author Administrator
 *
 */
public interface IStudentDao {
	
	public Student findByEmail(String email);	//通过email查找学生
	public List<Student> findByMajorAndClas(String major,String clas);	//通过专业和班级查找学生
//	public List<>
}
