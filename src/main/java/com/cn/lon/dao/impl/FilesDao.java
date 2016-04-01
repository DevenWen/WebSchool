package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IFilesDao;
import com.cn.lon.entity.Files;
import com.cn.lon.utils.BaseDaoUtil;

public class FilesDao extends BaseDaoUtil implements IFilesDao {

	//添加上传文件的信息到数据库
	@Override
	public void addFiles(Files files) {
		//sql语句
		String sql="INSERT INTO file(uploadman,title,filename,time,fileURL) VALUES(?,?,?,?,?)";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {files.getUploadman(),files.getTitle(),files.getFilename(),files.getTime(),files.getTime()};
		
		super.update(sql, paramsValue);			
	}

	@Override
	public void deleteFiles(String title) {
		//sql语句
		String sql="DELETE FROM file WHERE title=?";
		
		//运用BaseDaoUtil
		Object[] paramsValue = {title};
		
		super.update(sql, paramsValue);
	}

	@Override
	public List<Files> getAll() {
		String sql="select * from file";
		
		Object[] paramsValue = {};
		
		List<Files> list = super.query(sql,paramsValue , Files.class);
		return list;
	}

	@Override
	public Files findByTitle(String title) {
		String sql="select * from file where title=?";
		
		Object[] paramsValue = {title};
		
		List<Files> list = super.query(sql,paramsValue , Files.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

}
