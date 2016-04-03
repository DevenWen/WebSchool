package com.cn.lon.dao;

import com.cn.lon.entity.Teacher;

/**
 * 教职工数据层接口
 * @author Administrator
 *
 */
public interface ITeacherDao {
	public Teacher findByEmail(String email);	//通过email查找教职工
}
