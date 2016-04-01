package com.cn.lon.service;

import java.util.List;

import com.cn.lon.entity.Announce;

public interface IAnnounceService {
	public void addAnnounce(Announce announce);		//添加公告
	public void deleteAnnounce(String title);	//删除公告
	public List<Announce> getAll();		//查询所有的公告标题
	public Announce findByTitle(String title);	//通过标题查询公告内容
}
