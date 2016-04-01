package com.cn.lon.service.impl;

import com.cn.lon.dao.impl.TimeOpenDao;
import com.cn.lon.entity.TimeOpen;
import com.cn.lon.service.ITimeOpenService;

public class TimeOpenService implements ITimeOpenService {

	private TimeOpenDao timeOpenDao=new TimeOpenDao();
	@Override
	public void addTime(TimeOpen timeOpen) {
		timeOpenDao.addTime(timeOpen);
	}
	@Override
	public TimeOpen find() {
		return timeOpenDao.find();
	}
	@Override
	public void updateTime(TimeOpen timeOpen) {
		timeOpenDao.updateTime(timeOpen);
	}

}
