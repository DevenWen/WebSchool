package com.cn.lon.service;

import com.cn.lon.entity.SiXiang;
import com.cn.lon.entity.WenTi;
import com.cn.lon.entity.XueYe;

/**
 * 评分业务层接口
 * @author Administrator
 *
 */
public interface IGradeService {
	public void addGrade(SiXiang sixiang,XueYe xueye,WenTi wenTi);	//添加评分信息
	public void updateGrade(SiXiang sixiang,XueYe xueye,WenTi wenTi);	//更新评分信息
	public SiXiang findBySXId(String stuid,String gradingtype,String gradingManId);	//根据思想评分编号查询
	public XueYe findByXYId(String stuid,String gradingtype,String gradingManId);	//根据学业评分编号查询
	public WenTi findByWTId(String stuid,String gradingtype,String gradingManId);	//根据文体评分编号查询
}
