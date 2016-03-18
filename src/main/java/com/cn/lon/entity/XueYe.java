package com.cn.lon.entity;
/**
 * 学业评分实体类
 * @author Administrator
 *
 */
public class XueYe {
	private int id;		//学习评分的编号
	private String stuid;	//被评分学生编号
	private String gradingtype;		//评分类型
	private String gradingManId;		//评分人编号
	private double chengji;		//学习成绩
	private double jiangfen;	//学业奖分
	private double koufen;		//学业扣分
	private double count;		//学业小计
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getGradingtype() {
		return gradingtype;
	}
	public void setGradingtype(String gradingtype) {
		this.gradingtype = gradingtype;
	}
	public String getGradingManId() {
		return gradingManId;
	}
	public void setGradingManId(String gradingManId) {
		this.gradingManId = gradingManId;
	}
	public double getChengji() {
		return chengji;
	}
	public void setChengji(double chengji) {
		this.chengji = chengji;
	}
	public double getJiangfen() {
		return jiangfen;
	}
	public void setJiangfen(double jiangfen) {
		this.jiangfen = jiangfen;
	}
	public double getKoufen() {
		return koufen;
	}
	public void setKoufen(double koufen) {
		this.koufen = koufen;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	
	
}
