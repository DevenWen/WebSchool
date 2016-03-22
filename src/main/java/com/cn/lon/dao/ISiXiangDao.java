package com.cn.lon.dao;

import com.cn.lon.entity.SiXiang;

/**
 * 思想品德评分数据层接口
 * @author Administrator
 *
 */
public interface ISiXiangDao {
	public void addSiXiang(SiXiang sixiang);	//添加评分信息
	public void updateSiXiang(SiXiang sixiang);	//更新评分信息
	public SiXiang findById(String stuid,String gradingtype,String gradingManId);	//根据评分各编号查询
}

