package com.cn.lon.entity;

import java.util.Date;

/**
 * 文件上传下载的实体类
 * @author Administrator
 *
 */
public class Files {
	private String uploadman;		//文件上传者
	private String title;			//标题
	private String filename;		//上传文件的名称
	private Date time;				//上传时间
	private String fileURL;			//文件的路径
	public String getUploadman() {
		return uploadman;
	}
	public void setUploadman(String uploadman) {
		this.uploadman = uploadman;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
	
}
