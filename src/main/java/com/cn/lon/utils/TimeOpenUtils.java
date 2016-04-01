package com.cn.lon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.cn.lon.entity.TimeOpen;
import com.cn.lon.service.ITimeOpenService;
import com.cn.lon.service.impl.TimeOpenService;

/**
 * 系统时间开放工具类
 * @author Administrator
 *
 */
public class TimeOpenUtils {
	
	//时间转换以及封装
	public static void StringToDate(HttpServletRequest request,TimeOpen timeOpen){
		try {
			String zbegin1=request.getParameter("zbegin");
			String zend1=request.getParameter("zend");
			String bbegin1=request.getParameter("bbegin");
			String bend1=request.getParameter("bend");
			String xbegin1=request.getParameter("xbegin");
			String xend1=request.getParameter("xend");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date zbegin = sdf.parse(zbegin1);
			Date zend = sdf.parse(zend1);
			Date bbegin = sdf.parse(bbegin1);
			Date bend = sdf.parse(bend1);
			Date xbegin = sdf.parse(xbegin1);
			Date xend = sdf.parse(xend1);
						
			timeOpen.setZbegin(zbegin);
			timeOpen.setZend(zend);
			timeOpen.setBbegin(bbegin);
			timeOpen.setBend(bend);
			timeOpen.setXbegin(xbegin);
			timeOpen.setXend(xend);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//返回开始时间
	public static Date getBeginTime(String type){
		ITimeOpenService timeOpenService = new TimeOpenService();
		
		TimeOpen timeOpen = timeOpenService.find();
		
		if("自评".equals(type)){
			return timeOpen.getZbegin();
		}
		else if("班评".equals(type)){
			return timeOpen.getBbegin();
		}
		else if("系评".equals(type)){
			return timeOpen.getXbegin();
		}
		
		return null;
	}
	
	//返回结束时间
	public static
	Date getEndTime(String type){
		ITimeOpenService timeOpenService = new TimeOpenService();
		
		TimeOpen timeOpen = timeOpenService.find();
		
		if("自评".equals(type)){
			return timeOpen.getZend();
		}
		else if("班评".equals(type)){
			return timeOpen.getBend();
		}
		else if("系评".equals(type)){
			return timeOpen.getXend();
		}
		
		return null;
	}
}
