package com.cn.lon.dao.impl;
/**
 * 教职工数据层实体
 */
import java.util.List;

import com.cn.lon.dao.ITeacherDao;
import com.cn.lon.entity.Teacher;
import com.cn.lon.utils.BaseDaoUtil;

public class TeacherDao extends BaseDaoUtil implements ITeacherDao {

	@Override
	public Teacher findByEmail(String email) {
		String sql="select * from teacher where email=?";
		
		Object[] paramsValue = {email};
		
		List<Teacher> list = super.query(sql,paramsValue , Teacher.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
