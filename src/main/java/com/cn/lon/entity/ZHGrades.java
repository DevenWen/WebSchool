package com.cn.lon.entity;
/**
 * 综合分数表
 * @author Administrator
 *
 */
public class ZHGrades {
	private String stuid;	//学号
	private String name;	//姓名
	private String major;	//专业
	private String clas;	//班级
	private double sx_score;	//思想总分
	private double xy_score;	//学业总分
	private double wt_score;	//文体总分
	private double zh_score;	//综合总分
	
	private int sx_place;	//思想分排名
	private int xy_place;	//学业分排名
	private int wt_place;	//文体分排名
	private int zh_place;		//综合分排名
	
	
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public int getSx_place() {
		return sx_place;
	}
	public void setSx_place(int sx_place) {
		this.sx_place = sx_place;
	}
	public int getXy_place() {
		return xy_place;
	}
	public void setXy_place(int xy_place) {
		this.xy_place = xy_place;
	}
	public int getWt_place() {
		return wt_place;
	}
	public void setWt_place(int wt_place) {
		this.wt_place = wt_place;
	}
	public int getZh_place() {
		return zh_place;
	}
	public void setZh_place(int zh_place) {
		this.zh_place = zh_place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public double getSx_score() {
		return sx_score;
	}
	public void setSx_score(double sx_score) {
		this.sx_score = sx_score;
	}
	public double getXy_score() {
		return xy_score;
	}
	public void setXy_score(double xy_score) {
		this.xy_score = xy_score;
	}
	public double getWt_score() {
		return wt_score;
	}
	public void setWt_score(double wt_score) {
		this.wt_score = wt_score;
	}
	public double getZh_score() {
		return zh_score;
	}
	public void setZh_score(double zh_score) {
		this.zh_score = zh_score;
	}
	
	
}
