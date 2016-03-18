package com.cn.lon.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc工具类
 */
public class JdbcUtil {
	private static String url = "jdbc:mysql://localhost:3306/webschool?"+ "characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";
	private static String driverClass = "com.mysql.jdbc.Driver";
	
	/*
	 * 静态代码块中（只加载一次）
	 */
	static{
		try{
			//注册驱动程序
			Class.forName(driverClass);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("驱动程序注册出错");
		}
	}
	
	/*
	 * 抽取获取连接对象的方法
	 */
	public static Connection getConnection(){
		try{
			Connection conn=DriverManager.getConnection(url,user,password);
			return conn;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 释放资源的方法
	 */
	public static void close(Connection conn,Statement stmt){
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
