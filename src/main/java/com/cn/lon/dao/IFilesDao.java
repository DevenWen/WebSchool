package com.cn.lon.dao;

import java.util.List;

import com.cn.lon.entity.Files;

/**
 * 文件数据层接口
 * @author Administrator
 *
 */
public interface IFilesDao {
	public void addFiles(Files files);		//添加上传文件信息
	public void deleteFiles(String title);	//删除文件
	public List<Files> getAll();				//查询所有的文件标题
	public Files findByTitle(String title);	//通过标题查询文件
}
