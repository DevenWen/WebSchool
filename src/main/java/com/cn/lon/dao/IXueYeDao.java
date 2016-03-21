package com.cn.lon.dao;

import com.cn.lon.entity.XueYe;

/**
 * 学业评分数据层接口
 * @author Administrator
 *
 */
public interface IXueYeDao {
	public void addXueYe(XueYe xueye);	//添加学业分
	public void updateXueYe(XueYe xueye);	//更新学业分
	public XueYe findById(String stuid,String gradingtype,String gradingManId);	//根据学业编号查询
}
