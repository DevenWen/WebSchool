package com.cn.lon.dao;

import java.util.List;

import com.cn.lon.entity.Student;
import com.cn.lon.entity.ZHGrades;
import com.cn.lon.utils.PageBean;

/**
 * 综合分数表数据层接口
 * @author Administrator
 *
 */
public interface IZHGradesDao {

	//通过学号查询
	public ZHGrades findById(String stuid);
	
	/***分页查询数据*****/
	//通过专业和班级进行分页查询
	public void getAllByMajorAndClas(PageBean<ZHGrades> pb,String major,String clas);
	//根据专业和学号查询该班同学的总人数
	public int getTotalCountByMajorAndClas(String major,String clas);
	
	//通过专业进行分页查询
	public void getAllByMajor(PageBean<ZHGrades> pb,String major);
	//根据专业查询该专业同学的总人数
	public int getTotalCountByMajor(String major);
	
	
	//通过班级进行分页查询
	public void getAllByClas(PageBean<ZHGrades> pb,String clas);
	//根据班级查询该专业同学的总人数
	public int getTotalCountByClas(String clas);
}
