package com.cn.lon.entity;
/**
 * 文体评分实体类
 * @author Administrator
 *
 */
public class WenTi {
	private int id;		//文体评分的编号
	private String stuid;	//被评分学生编号
	private String gradingtype;		//评分类型
	private String gradingManId;		//评分人编号
	private double tiyu;		//体育课分
	private double wenti;		//文体活动分
	private double jiangfen;	//文体奖分
	private double koufen;		//文体扣分
	private double count;		//文体小计
	
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
	public double getTiyu() {
		return tiyu;
	}
	public void setTiyu(double tiyu) {
		this.tiyu = tiyu;
	}
	public double getWenti() {
		return wenti;
	}
	public void setWenti(double wenti) {
		this.wenti = wenti;
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
