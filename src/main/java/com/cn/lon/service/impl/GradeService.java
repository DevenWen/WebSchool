package com.cn.lon.service.impl;

import com.cn.lon.dao.ISiXiangDao;
import com.cn.lon.dao.IWenTiDao;
import com.cn.lon.dao.IXueYeDao;
import com.cn.lon.dao.impl.SiXiangDao;
import com.cn.lon.dao.impl.WenTiDao;
import com.cn.lon.dao.impl.XueYeDao;
import com.cn.lon.entity.SiXiang;
import com.cn.lon.entity.WenTi;
import com.cn.lon.entity.XueYe;
import com.cn.lon.service.IGradeService;
import com.cn.lon.utils.BaseDaoUtil;
/**
 * 评分业务层实现类
 * @author Administrator
 *
 */
public class GradeService extends BaseDaoUtil implements IGradeService {
	//实例
	private ISiXiangDao siXiangDao=new SiXiangDao();
	private IXueYeDao xueYeDao=new XueYeDao();
	private IWenTiDao wenTiDao=new WenTiDao();
	
	@Override
	public void addGrade(SiXiang sixiang, XueYe xueye, WenTi wenTi) {
		siXiangDao.addSiXiang(sixiang);
		xueYeDao.addXueYe(xueye);
		wenTiDao.addWenTi(wenTi);

	}

	@Override
	public void updateGrade(SiXiang sixiang, XueYe xueye, WenTi wenTi) {
		siXiangDao.updateSiXiang(sixiang);
		xueYeDao.updateXueYe(xueye);
		wenTiDao.updateWenTi(wenTi);

	}

	@Override
	public SiXiang findBySXId(String stuid, String gradingtype,
			String gradingManId) {
		
		return siXiangDao.findById(stuid, gradingtype, gradingManId);
	}

	@Override
	public XueYe findByXYId(String stuid, String gradingtype,
			String gradingManId) {
		
		return xueYeDao.findById(stuid, gradingtype, gradingManId);
	}

	@Override
	public WenTi findByWTId(String stuid, String gradingtype,
			String gradingManId) {
		
		return wenTiDao.findById(stuid, gradingtype, gradingManId);
	}

}
