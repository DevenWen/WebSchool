package com.cn.lon.service;

import java.util.List;

import com.cn.lon.entity.ZHGrades;
import com.cn.lon.utils.PageBean;

/**
 * 综合分数表业务逻辑层接口
 * @author Administrator
 *
 */
public interface IZHGradesService {

	//通过学号查询
	public ZHGrades findById(String stuid);
	
	//通过专业查询学生评优名单
	public List<ZHGrades> getAllByMajor(String major);
	
	//通过班级进行分页查询
	public void getAllByClas(PageBean<ZHGrades> pb,String clas);
	
	//通过专业查询
	public void getAllByMajor(PageBean<ZHGrades> pb,String major);
	
	//通过专业和班级查询
	public void getAllByMajorAndClas(PageBean<ZHGrades> pb,String major,String clas);
}
