package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IAnnounceDao;
import com.cn.lon.entity.Announce;
import com.cn.lon.utils.BaseDaoUtil;

public class AnnounceDao extends BaseDaoUtil implements IAnnounceDao{

	public void addAnnounce(Announce announce) {
		//sql语句
		String sql="INSERT INTO announce(announceman,title,time,content) VALUES(?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {announce.getAnnounceman(),announce.getTitle(),announce.getTime(),announce.getContent()};
		
		super.update(sql, paramsValue);
		
	}

	public void deleteAnnounce(String title) {
		//sql语句
		String sql="DELETE FROM announce WHERE title=?";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {title};
		
		super.update(sql, paramsValue);
		
	}

	public List<Announce> getAll() {
		String sql="select * from announce";
		
		Object[] paramsValue = {};
		
		List<Announce> list = super.query(sql,paramsValue , Announce.class);
		return list;
	}

	public Announce findByTitle(String title) {
		String sql="select * from announce where title=?";
		
		Object[] paramsValue = {title};
		
		List<Announce> list = super.query(sql,paramsValue , Announce.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
