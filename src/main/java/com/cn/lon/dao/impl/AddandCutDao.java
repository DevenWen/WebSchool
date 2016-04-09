package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IAddandCutDao;
import com.cn.lon.entity.AddandCut;
import com.cn.lon.utils.BaseDaoUtil;

public class AddandCutDao extends BaseDaoUtil implements IAddandCutDao {

	public void addAddandCut(AddandCut addandcut) {
		//sql语句
		String sql="INSERT INTO jiakoufen_table(type,stuid,score,explains,pictureurl,checked,checkemanId) VALUES(?,?,?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {addandcut.getType(),addandcut.getStuid(),addandcut.getScore(),addandcut.getExplains(),
				addandcut.getPictureurl(),addandcut.getChecked(),addandcut.getCheckemanid()};
		
		super.update(sql, paramsValue);

	}

	
	public void updateAddandCut(AddandCut addandcut) {
		//sql语句
		String sql="update jiakoufen_table set checked=?,checkemanId=? where id=?";
		
		Object[] paramsValue = {addandcut.getChecked(),addandcut.getCheckemanid(),addandcut.getId()};
		
		super.update(sql, paramsValue);
	}

	@Override
	public List<AddandCut> findByStuid(String stuid) {
		String sql="select * from jiakoufen_table where stuid=?";
		
		Object[] paramsValue = {stuid};
		
		List<AddandCut> list = super.query(sql,paramsValue , AddandCut.class);
		return list;
	}

	@Override
	public AddandCut findById(Integer id) {
		String sql="select * from jiakoufen_table where id=?"; 
		
		Object[] paramsValue = {id};
		
		List<AddandCut> list = super.query(sql,paramsValue , AddandCut.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
