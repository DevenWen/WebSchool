package com.cn.lon.entity;

import java.util.Date;

/**
 * 公告实体类
 * @author Administrator
 *
 */
public class Announce {
	private String announceman;		//发布公告者
	private String title;			//标题
	private Date time;				//发布时间
	private String content;			//发布内容
	public String getAnnounceman() {
		return announceman;
	}
	public void setAnnounceman(String announceman) {
		this.announceman = announceman;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
