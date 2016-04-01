package com.cn.lon.service;

import com.cn.lon.entity.TimeOpen;
/**
 * 系统开发时间业务层接口
 * @author Administrator
 *
 */
public interface ITimeOpenService {
	public void addTime(TimeOpen timeOpen);	//添加开放时间
	public TimeOpen find();		//查找开发时间
	public void updateTime(TimeOpen timeOpen);	//更新开放时间
}
