package com.cn.lon.dao;

import com.cn.lon.entity.TimeOpen;
/**
 * 系统开发时间数据层接口
 * @author Administrator
 *
 */
public interface ITimeOpenDao {
	public void addTime(TimeOpen timeOpen);	//添加开放时间
	public TimeOpen find();		//查找开发时间
	public void updateTime(TimeOpen timeOpen);	//更新开放时间
}
