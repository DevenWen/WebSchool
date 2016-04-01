package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.ITimeOpenDao;
import com.cn.lon.entity.TimeOpen;
import com.cn.lon.utils.BaseDaoUtil;

public class TimeOpenDao extends BaseDaoUtil implements ITimeOpenDao{

	public void addTime(TimeOpen timeOpen) {
		//sql语句
		String sql="INSERT INTO timeopen(zbegin,zend,bbegin,bend,xbegin,xend) VALUES(?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {timeOpen.getZbegin(),timeOpen.getZend(),timeOpen.getBbegin(),timeOpen.getBend(),timeOpen.getXbegin(),timeOpen.getXend()};
		
		super.update(sql, paramsValue);			
	}

	@Override
	public TimeOpen find() {
		String sql="select * from timeopen";
		
		Object[] paramsValue = {};
		
		List<TimeOpen> list = super.query(sql,paramsValue , TimeOpen.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

	@Override
	public void updateTime(TimeOpen timeOpen) {
		//sql语句
		String sql="UPDATE timeopen SET zbegin=?,zend=?,bbegin=?,bend=?,xbegin=?,xend=?";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {timeOpen.getZbegin(),timeOpen.getZend(),timeOpen.getBbegin(),timeOpen.getBend(),timeOpen.getXbegin(),timeOpen.getXend()};
		
		super.update(sql, paramsValue);	
		
	}

}
