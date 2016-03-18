package com.cn.lon.entity;

/**
 * 1.登录用户实体类
 * @author Administrator
 *
 */
public class User {
	private String id;	//登录用户编号
	private String name;	//登录用户名
	private String email;	//登录用户email
	private String password;	//登录用户密码
	private String authority;	//登录用户权限
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
