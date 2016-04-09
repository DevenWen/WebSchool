package com.cn.lon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.lon.dao.impl.AddandCutDao;
import com.cn.lon.entity.AddandCut;
import com.cn.lon.service.IAddAndCutService;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.framework.util.UserUtil;
import com.cn.qpm.usermanage.dao.AddandCutMapper;
import com.cn.qpm.usermanage.model.LoginUser;

/**
 * declaration： 
 *		加扣分Service实现类
 */
@Service("addAndCutService")
public class AddAndCutService implements IAddAndCutService {

	@Resource
	private AddandCutMapper addAndCutMapper;
	
	private AddandCutDao addandCut=new AddandCutDao();
	/**
	 * 通过传入的model保存一个加扣分记录
	 */
	@Override
	public int SaveAnRecord(AddandCut model) {
		// TODO Auto-generated method stub
		/*
		 * 为model设置stuid
		 */
		LoginUser user = UserUtil.getCurrentUser(WebSchoolContext.getHttpServletRequest());
		model.setStuid(com.cn.lon.utils.UserUtil.getUserId(user));
		
		return this.addAndCutMapper.insertSelective(model);
	}

	@Override
	public void addAddandCut(AddandCut addandcut) {
		addandCut.addAddandCut(addandcut);
	}

	@Override
	public void updateAddandCut(AddandCut addandcut) {
		addandCut.updateAddandCut(addandcut);
		
	}

	@Override
	public List<AddandCut> findByStuid(String stuid) {
		return addandCut.findByStuid(stuid);
	}

	@Override
	public AddandCut findById(Integer id) {
		return addandCut.findById(id);
	}

}
