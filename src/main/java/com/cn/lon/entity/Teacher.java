package com.cn.lon.entity;
/**
 * 教师以及管理员实体类
 * @author Administrator
 *
 */
public class Teacher {
	private String teaid;	//教工号
	private String email;	//email
	private String name;	//姓名
	private String sex;		//性别
	private int age;		//年龄
	private String position;	//职位
	public String getTeaid() {
		return teaid;
	}
	public void setTeaid(String teaid) {
		this.teaid = teaid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
