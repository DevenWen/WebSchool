package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IXueYeDao;
import com.cn.lon.entity.SiXiang;
import com.cn.lon.entity.XueYe;
import com.cn.lon.utils.BaseDaoUtil;
/**
 * 学业评分数据层实现
 * @author Administrator
 *
 */
public class XueYeDao extends BaseDaoUtil implements IXueYeDao {

	@Override
	public void addXueYe(XueYe xueye) {
		//sql语句
		String sql="INSERT INTO xueye_table(stuid,gradingtype,gradingManId," +
				"chengji,jiangfen,koufen,count)" +				
				" VALUES(?,?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {xueye.getStuid(),xueye.getGradingtype(),xueye.getGradingManId(),
				xueye.getChengji(),xueye.getJiangfen(),xueye.getKoufen(),xueye.getCount()};
		
		super.update(sql, paramsValue);

	}

	@Override
	public void updateXueYe(XueYe xueye) {
		//准备sql
		String sql="update xueye_table set chengji=?,jiangfen=?,koufen=?,count=?" +
				"where stuid=? and gradingtype=? and gradingManId=?";
		

		//运用BaseDaoUtil
		Object[] paramsValue = {xueye.getChengji(),xueye.getJiangfen(),xueye.getKoufen(),
				xueye.getCount(),xueye.getStuid(),xueye.getGradingtype(),xueye.getGradingManId()};
		super.update(sql, paramsValue);
	}

	@Override
	public XueYe findById(String stuid, String gradingtype, String gradingManId) {
		
		String sql="select * from xueye_table where stuid=? and gradingtype=? and gradingManId=?";
		
		Object[] paramsValue = {stuid,gradingtype,gradingManId};
		
		List<XueYe> list = super.query(sql,paramsValue , XueYe.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
