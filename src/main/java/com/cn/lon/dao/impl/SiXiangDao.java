package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.ISiXiangDao;
import com.cn.lon.entity.SiXiang;
import com.cn.lon.utils.BaseDaoUtil;
/**
 * 思想品德评分数据层实现
 * @author Administrator
 *
 */
public class SiXiangDao extends BaseDaoUtil implements ISiXiangDao {

	@Override
	public void addSiXiang(SiXiang sixiang) {
		//sql语句
		String sql="INSERT INTO sixiang_table(stuid,gradingtype,gradingManId," +
				"sixiang,jilv,jiti,wenming,gongyu,shijian,jiangfen,koufen,count)" +				
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {sixiang.getStuid(),sixiang.getGradingtype(),sixiang.getGradingManId(),
				sixiang.getSixiang(),sixiang.getJilv(),sixiang.getJiti(),sixiang.getWenming(),sixiang.getGongyu(),
				sixiang.getShijian(),sixiang.getJiangfen(),sixiang.getKoufen(),sixiang.getCount()};
		
		super.update(sql, paramsValue);

	}

	@Override
	public void updateSiXiang(SiXiang sixiang) {
		//准备sql
		String sql="update sixiang_table set sixiang=?,jilv=?,jiti=?,wenming=?," +
				"gongyu=?,shijian=?,jiangfen=?,koufen=?,count=?" +
				"where stuid=? and gradingtype=? and gradingManId=?";
		

		//运用BaseDaoUtil
		Object[] paramsValue = {sixiang.getSixiang(),sixiang.getJilv(),sixiang.getJiti(),
				sixiang.getWenming(),sixiang.getGongyu(),sixiang.getShijian(),
				sixiang.getJiangfen(),sixiang.getKoufen(),sixiang.getCount(),
				sixiang.getStuid(),sixiang.getGradingtype(),sixiang.getGradingManId()};
		super.update(sql, paramsValue);

	}

	@Override
	public SiXiang findById(String stuid,String gradingtype,String gradingManId) {
	/*	String sql="select sixiang,jilv,jiti,wenming,gongyu,shijian,jiangfen,koufen,count from sixiang_table"
				+ " where stuid=? and gradingtype=? and gradingManId=?";
	*/
		String sql="select * from sixiang_table where stuid=? and gradingtype=? and gradingManId=?";
		
		Object[] paramsValue = {stuid,gradingtype,gradingManId};
		
		List<SiXiang> list = super.query(sql,paramsValue , SiXiang.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
