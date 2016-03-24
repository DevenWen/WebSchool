package com.cn.lon.service;


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

}
