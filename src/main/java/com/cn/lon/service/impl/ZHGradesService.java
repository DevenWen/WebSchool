package com.cn.lon.service.impl;

import java.util.List;

import com.cn.lon.dao.IZHGradesDao;
import com.cn.lon.dao.impl.ZHGradesDao;
import com.cn.lon.entity.ZHGrades;
import com.cn.lon.service.IZHGradesService;
import com.cn.lon.utils.PageBean;
/**
 * 综合分数表业务逻辑层实现类
 * @author Administrator
 *
 */
public class ZHGradesService implements IZHGradesService {

	//实例service
	private IZHGradesDao zhGrades=new ZHGradesDao();
	
	//通过学号进行查询
	@Override
	public ZHGrades findById(String stuid) {
		
		return zhGrades.findById(stuid);
	}

	//通过专业查询学生评优名单
	@Override
	public List<ZHGrades> getAllByMajor(String major) {
		
		return zhGrades.getAllByMajor(major);
	}
	
	
	//通过专业进行分页查询
	@Override
	public void getAllByMajor(PageBean<ZHGrades> pb, String major) {
		try {
			zhGrades.getAllByMajor(pb, major);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	//通过专业和班级进行分页查询
	@Override
	public void getAllByMajorAndClas(PageBean<ZHGrades> pb, String major,
			String clas) {
		try {
			zhGrades.getAllByMajorAndClas(pb, major, clas);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	//通过班级进行分页查询
	@Override
	public void getAllByClas(PageBean<ZHGrades> pb, String clas) {
		try {
			zhGrades.getAllByClas(pb, clas);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

}
