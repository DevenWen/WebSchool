package com.cn.lon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String DatetoString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
}
