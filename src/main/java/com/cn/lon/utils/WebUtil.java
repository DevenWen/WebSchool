package com.cn.lon.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	/*第一种
	public static <T>T copyToBean_old(HttpServletRequest request,Class<T> clazz){
		
		try {
			//创建对象
			T t=clazz.newInstance();
			
			//获取所有的表单元素的名称
			Enumeration<String> enums= request.getParameterNames();
		
			//遍历
			while(enums.hasMoreElements()){
				//获取表单元素的名称
				String name = enums.nextElement();
				//获取名称对应的值
				String value= request.getParameter(name);
				//把指定属性名称对应的值进行拷贝
				BeanUtils.copyProperty(t, name, value);
			}
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	*/
	
	/**
	 * 处理请求数据的封装
	 */
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			// （注册日期类型转换器）
			// 创建对象
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
