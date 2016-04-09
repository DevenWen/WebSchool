package com.cn.lon.dao;

import java.util.List;

import com.cn.lon.entity.AddandCut;

public interface IAddandCutDao {
	public void addAddandCut(AddandCut addandcut);	//添加加扣分信息
	public void updateAddandCut(AddandCut addandcut);	//更新加扣分信息
	public List<AddandCut> findByStuid(String stuid);	//通过学号查询出一个学生的加扣分信息
	public AddandCut findById(Integer id);		//通过编号查出一条加扣分信息
}
