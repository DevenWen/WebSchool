package com.cn.lon.service.impl;

import com.cn.lon.dao.ISiXiangDao;
import com.cn.lon.dao.impl.SiXiangDao;
import com.cn.lon.entity.SiXiang;
import com.cn.lon.service.ISiXiangService;

/**
 * 思想品德评分业务逻辑实现层
 * @author Administrator
 *
 */
public class SiXiangService implements ISiXiangService {
	private ISiXiangDao siXiangDao=new SiXiangDao();
	
	public void addSiXiang(SiXiang sixiang) {
		siXiangDao.addSiXiang(sixiang);

	}

	public void updateSiXiang(SiXiang sixiang) {
		siXiangDao.updateSiXiang(sixiang);

	}

	public SiXiang findById(String stuid,String gradingtype,String gradingManId) {
		return siXiangDao.findById(stuid, gradingtype, gradingManId);
	}

}
