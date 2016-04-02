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
	public Student findByStuid(String stuid);	//通过学号查询学生
	
	
	//根据专业和班级分页查询数据
	public void getAll(PageBean<Student> pb, String major, String clas);
	
	//通过学号模糊查询学生
	public void getAllByStuid(PageBean<Student> pb,String stuid);

}
