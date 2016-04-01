package com.cn.lon.utils;



import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

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
		//	ConvertUtils.register(new DateLocaleConverter(), Date.class);
			// 创建对象
			T t = clazz.newInstance();
			// （注册日期类型转换器）
			// 注册日期类型转换器：2， 使用组件提供的转换器工具类
		//		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		//	ConvertUtils.register(new SqlDateConverter(null), Date.class);
			
	/*		ConvertUtils.register(new Converter() {
				// 转换的内部实现方法，需要重写
				@Override
				public Object convert(Class type, Object value) {
					
					// 判断
					if (type != Date.class) {
						return null;
					}
					if (value == null || "".equals(value.toString().trim())) {
						return null;
					}
					
					
					try {
						// 字符串转换为日期
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						return sdf.parse(value.toString());
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			},Date.class);
	*/		
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
