package com.cn.lon.service;


import java.util.List;

import com.cn.lon.entity.AddandCut;

/**
 * declaration： 
 *		加扣分Service类
 */
public interface IAddAndCutService {
	
	/**
	 * 通过一个对象向数据库保存一条数据
	 */
	int SaveAnRecord(AddandCut model);
	
	public void addAddandCut(AddandCut addandcut);	//添加加扣分信息
	public void updateAddandCut(AddandCut addandcut);	//更新加扣分信息
	public List<AddandCut> findByStuid(String stuid);	//通过学号查询出一个学生的加扣分信息
	public AddandCut findById(Integer id);		//通过编号查出一条加扣分信息

}
