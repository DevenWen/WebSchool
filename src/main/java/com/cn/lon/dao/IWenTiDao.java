package com.cn.lon.dao;

import com.cn.lon.entity.WenTi;

/**
 * 文体评分数据层接口
 * @author Administrator
 *
 */
public interface IWenTiDao {
	public void addWenTi(WenTi wenTi);	//添加学业分
	public void updateWenTi(WenTi wenTi);	//更新学业分
	public WenTi findById(String stuid,String gradingtype,String gradingManId);	//根据学业编号查询
}
