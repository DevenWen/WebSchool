package com.cn.lon.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 通用的dao，自己写的所有的dao都继承此类;
 * 此类定义了2个通用的方法：
 * 	1. 更新
 *  2. 查询
 * @author Jie.Yuan
 *
 */
public class BaseDaoUtil {
	// 初始化参数
		private Connection con;
		private PreparedStatement pstmt;
		private ResultSet rs;

		/**
		 * 更新的通用方法
		 * @param sql   更新的sql语句(update/insert/delete)
		 * @param paramsValue  sql语句中占位符对应的值(如果没有占位符，传入null)
		 */
		public void update(String sql,Object[] paramsValue){
			try {
				//获取连接
				con=JdbcUtil.getConnection();		//jdbc连接方式
				//con=DbcpUtil.getConnection();		//dbcp连接池方式（有乱码）
				
				
				//创建执行命令的stmt对象
				pstmt= con.prepareStatement(sql);
				
				//设置参数
				//参数元数据：得到占位符参数的个数
				int count = pstmt.getParameterMetaData().getParameterCount();
				//设置占位符参数的值
				if(paramsValue!=null && paramsValue.length>0){
					//循环给参数赋值
					for(int i=0;i<count;i++){
						pstmt.setObject(i+1, paramsValue[i]);
					}
				}
				
				//执行更新
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JdbcUtil.close(con, pstmt);
			}
		}
		
		/**
		 * 查询的通用方法
		 * @param sql
		 * @param paramsValue
		 */
		public <T> List<T> query(String sql, Object[] paramsValue,Class<T> clazz){
			
			try {
				// 返回的集合
				List<T> list = new ArrayList<T>();
				// 对象
				T t = null;
				
				// 1. 获取连接
				con = JdbcUtil.getConnection();
				// 2. 创建stmt对象
				pstmt = con.prepareStatement(sql);
				// 3. 获取占位符参数的个数， 并设置每个参数的值
				//int count = pstmt.getParameterMetaData().getParameterCount();
				if (paramsValue != null && paramsValue.length > 0) {
					for (int i=0; i<paramsValue.length; i++) {
						pstmt.setObject(i+1, paramsValue[i]);
					}
				}
				// 4. 执行查询
				rs = pstmt.executeQuery();
				// 5. 获取结果集元数据
				ResultSetMetaData rsmd = rs.getMetaData();
				// ---> 获取列的个数
				int columnCount = rsmd.getColumnCount();
				
				// 6. 遍历rs
				while (rs.next()) {
					// 要封装的对象
					t = clazz.newInstance();
					
					// 7. 遍历每一行的每一列, 封装数据
					for (int i=0; i<columnCount; i++) {
						// 获取每一列的列名称
						String columnName = rsmd.getColumnName(i + 1);
						// 获取每一列的列名称, 对应的值
						Object value = rs.getObject(columnName);
						// 封装： 设置到t对象的属性中  【BeanUtils组件】
						BeanUtils.copyProperty(t, columnName, value);				
					}
					
					// 把封装完毕的对象，添加到list集合中
					list.add(t);
				}
				
				return list;
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				JdbcUtil.close(con, pstmt, rs);
			}
		}
}

