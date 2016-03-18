package com.cn.lon.service;

import com.cn.lon.entity.SiXiang;
/**
 * 思想品德评分业务逻辑接口层
 * @author Administrator
 *
 */
public interface ISiXiangService {
	public void addSiXiang(SiXiang sixiang);	//添加思想品德分
	public void updateSiXiang(SiXiang sixiang);	//更新思想评分
	public SiXiang findById(String stuid,String gradingtype,String gradingManId);	//根据思想评分编号查询
}
