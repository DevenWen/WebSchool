package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IGradesDao;
import com.cn.lon.entity.Grades;
import com.cn.lon.utils.BaseDaoUtil;
/**
 * 评分表数据层实现类
 * @author Administrator
 *
 */
public class GradesDao extends BaseDaoUtil implements IGradesDao {

	//添加评分信息
	public void addGrades(Grades grades) {
		//sql语句
		String sql="INSERT INTO grades_table(stuid,gradingtype,gradingManId," +
				"sixiang,jilv,jiti,wenming,gongyu,shijian,chengji,tiyu,wenti)" +				
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {grades.getStuid(),grades.getGradingtype(),grades.getGradingManId(),
				grades.getSixiang(),grades.getJilv(),grades.getJiti(),grades.getWenming(),grades.getGongyu(),
				grades.getShijian(),grades.getChengji(),grades.getTiyu(),grades.getWenti()};
		
		super.update(sql, paramsValue);

	}

	@Override
	//更新评分信息
	public void updateGrades(Grades grades) {
		//准备sql
		String sql="update grades_table set sixiang=?,jilv=?,jiti=?,wenming=?," +
				"gongyu=?,shijian=?,chengji=?,tiyu=?,wenti=?" +
				"where stuid=? and gradingtype=? and gradingManId=?";
		

		//运用BaseDaoUtil
		Object[] paramsValue = {grades.getSixiang(),grades.getJilv(),grades.getJiti(),
				grades.getWenming(),grades.getGongyu(),grades.getShijian(),
				grades.getChengji(),grades.getTiyu(),grades.getWenti(),
				grades.getStuid(),grades.getGradingtype(),grades.getGradingManId()};
		super.update(sql, paramsValue);

	}

	@Override
	//通过被评分人学号，评分类型，评分人的账号查询评分数据
	public Grades findById(String stuid, String gradingtype,
			String gradingManId) {
		String sql="select * from grades_table where stuid=? and gradingtype=? and gradingManId=?";
		
		Object[] paramsValue = {stuid,gradingtype,gradingManId};
		
		List<Grades> list = super.query(sql,paramsValue , Grades.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

	//通过被评分人学号，评分类型，查询评分的平均分数据
	public Grades findAverageGrades(String stuid, String gradingtype){
		String sql="select stuid,gradingtype,avg(sixiang) as sixiang,avg(jilv) as jilv,avg(jiti) as jiti,"
				+ "avg(wenming) as wenming,avg(gongyu) as gongyu,avg(shijian) as shijian,avg(chengji) as chengji,"
				+ "avg(tiyu) as tiyu,avg(wenti) as wenti from grades_table where stuid=? and gradingtype=?";
		
		Object[] paramsValue = {stuid,gradingtype};
		
		List<Grades> list = super.query(sql,paramsValue , Grades.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}
}
