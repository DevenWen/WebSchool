package com.cn.lon.entity;

import java.util.Date;

/**
 * 系统开放时间实体类
 * @author Administrator
 *
 */
public class TimeOpen {
	private Date zbegin;
	private Date zend;
	private Date bbegin;
	private Date bend;
	private Date xbegin;
	private Date xend;
	public Date getZbegin() {
		return zbegin;
	}
	public void setZbegin(Date zbegin) {
		this.zbegin = zbegin;
	}
	public Date getZend() {
		return zend;
	}
	public void setZend(Date zend) {
		this.zend = zend;
	}
	public Date getBbegin() {
		return bbegin;
	}
	public void setBbegin(Date bbegin) {
		this.bbegin = bbegin;
	}
	public Date getBend() {
		return bend;
	}
	public void setBend(Date bend) {
		this.bend = bend;
	}
	public Date getXbegin() {
		return xbegin;
	}
	public void setXbegin(Date xbegin) {
		this.xbegin = xbegin;
	}
	public Date getXend() {
		return xend;
	}
	public void setXend(Date xend) {
		this.xend = xend;
	}

	
}
