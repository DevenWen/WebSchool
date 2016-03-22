package com.cn.lon.service;

import com.cn.lon.entity.Grades;

/**
 * 评分表业务层接口
 * @author Administrator
 *
 */
public interface IGradesService {
	public void addGrades(Grades grades);	//添加评分信息
	public void updateGrades(Grades grades);	//更新评分信息
	public Grades findById(String stuid,String gradingtype,String gradingManId);	//根据各编号查询
	public Grades findAverageGrades(String stuid, String gradingtype);	//通过被评分人学号，评分类型，查询评分的平均分数据
}
