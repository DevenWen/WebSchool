package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IWenTiDao;
import com.cn.lon.entity.SiXiang;
import com.cn.lon.entity.WenTi;
import com.cn.lon.utils.BaseDaoUtil;
/**
 * 文体评分数据层实现
 * @author Administrator
 *
 */
public class WenTiDao extends BaseDaoUtil implements IWenTiDao {

	@Override
	public void addWenTi(WenTi wenTi) {
		//sql语句
		String sql="INSERT INTO wenti_table(stuid,gradingtype,gradingManId," +
				"tiyu,wenti,jiangfen,koufen,count)" +				
				" VALUES(?,?,?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {wenTi.getStuid(),wenTi.getGradingtype(),wenTi.getGradingManId(),
				wenTi.getTiyu(),wenTi.getWenti(),wenTi.getJiangfen(),wenTi.getKoufen(),wenTi.getCount()};
		
		super.update(sql, paramsValue);
	}

	@Override
	public void updateWenTi(WenTi wenTi) {
		//准备sql
		String sql="update wenti_table set tiyu=?,wenti=?,jiangfen=?,koufen=?,count=?" +
				"where stuid=? and gradingtype=? and gradingManId=?";
		

		//运用BaseDaoUtil
		Object[] paramsValue = {wenTi.getTiyu(),wenTi.getWenti(),
				wenTi.getJiangfen(),wenTi.getKoufen(),wenTi.getCount(),
				wenTi.getStuid(),wenTi.getGradingtype(),wenTi.getGradingManId()};
		super.update(sql, paramsValue);

	}

	@Override
	public WenTi findById(String stuid, String gradingtype, String gradingManId) {
		String sql="select * from wenti_table where stuid=? and gradingtype=? and gradingManId=?";
		
		Object[] paramsValue = {stuid,gradingtype,gradingManId};
		
		List<WenTi> list = super.query(sql,paramsValue , WenTi.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
