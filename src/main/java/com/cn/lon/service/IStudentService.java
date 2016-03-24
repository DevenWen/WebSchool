package com.cn.lon.service;

import java.util.List;

import com.cn.lon.entity.Student;
import com.cn.lon.utils.PageBean;

/**
 * 学生业务逻辑层接口
 * @author Administrator
 *
 */
public interface IStudentService {
	public Student findByEmail(String email);	//通过email查找学生
	public List<Student> findByMajorAndClas(String major,String clas);	//通过专业和班级查找学生
	
	//分页查询数据
	public void getAll(PageBean<Student> pb, String major, String clas);
}
