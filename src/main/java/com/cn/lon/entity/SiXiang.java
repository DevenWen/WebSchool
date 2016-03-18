package com.cn.lon.entity;
/**
 * 思想品德评分实体类
 * @author Administrator
 *
 */

public class SiXiang {
	private int id;		//思想评分的编号
	private String stuid;	//被评分学生编号
	private String gradingtype;		//评分类型
	private String gradingManId;		//评分人编号
	private double sixiang;		//思想政治观念
	private double jilv;		//纪律观念
	private double jiti;		//集体观念
	private double wenming;		//基础文明修养
	private double gongyu;		//学生公寓表现
	private double shijian;		//社会实践
	private double jiangfen;	//思想奖分
	private double koufen;		//思想扣分
	private double count;		//思想小计
	
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
	
	public double getSixiang() {
		return sixiang;
	}
	public void setSixiang(double sixiang) {
		this.sixiang = sixiang;
	}
	public double getJilv() {
		return jilv;
	}
	public void setJilv(double jilv) {
		this.jilv = jilv;
	}
	
	public String getGradingManId() {
		return gradingManId;
	}
	public void setGradingManId(String gradingManId) {
		this.gradingManId = gradingManId;
	}
	public double getJiti() {
		return jiti;
	}
	public void setJiti(double jiti) {
		this.jiti = jiti;
	}
	public double getWenming() {
		return wenming;
	}
	public void setWenming(double wenming) {
		this.wenming = wenming;
	}
	public double getGongyu() {
		return gongyu;
	}
	public void setGongyu(double gongyu) {
		this.gongyu = gongyu;
	}
	public double getShijian() {
		return shijian;
	}
	public void setShijian(double shijian) {
		this.shijian = shijian;
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
