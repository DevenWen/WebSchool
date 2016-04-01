package com.cn.lon.service.impl;

import java.util.List;

import com.cn.lon.dao.impl.AnnounceDao;
import com.cn.lon.entity.Announce;
import com.cn.lon.service.IAnnounceService;

public class AnnounceService implements IAnnounceService {

	//
	private AnnounceDao announceDao=new AnnounceDao();
	public void addAnnounce(Announce announce) {
		announceDao.addAnnounce(announce);

	}

	public void deleteAnnounce(String title) {
		announceDao.deleteAnnounce(title);

	}

	public List<Announce> getAll() {
		
		return announceDao.getAll();
	}

	public Announce findByTitle(String title) {
		
		return announceDao.findByTitle(title);
	}

}
