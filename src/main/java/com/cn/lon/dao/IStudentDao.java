package com.cn.lon.dao;

import java.util.List;

import com.cn.lon.entity.Student;
import com.cn.lon.utils.PageBean;

/**
 * 学生数据层接口
 * @author Administrator
 *
 */
public interface IStudentDao {
	
	public Student findByEmail(String email);	//通过email查找学生
	public List<Student> findByMajorAndClas(String major,String clas);	//通过专业和班级查找学生
	public Student findByStuid(String stuid);	//通过学号查询学生
	
	/***分页查询数据*****/
	//通过专业和班级查询
	public void getAll(PageBean<Student> pb,String major,String clas);
	//根据专业和学号查询该班同学的总人数
	public int getTotalCount(String major,String clas);
	
	
	//通过学号模糊查询符合要求的学生
	public void getAllByStuid(PageBean<Student> pb,String stuid);
	//根据Stuid模糊查询同学的总人数
	public int getTotalCountByStuid(String stuid);
}
