package com.cn.lon.service;

import com.cn.lon.entity.Teacher;
/**
 * 教职工的业务层接口
 * @author Administrator
 *
 */
public interface ITeacherService {
	public Teacher findByEmail(String email);
}
