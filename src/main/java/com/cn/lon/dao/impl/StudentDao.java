package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IStudentDao;
import com.cn.lon.entity.Student;
import com.cn.lon.utils.BaseDaoUtil;
import com.cn.lon.utils.PageBean;
/*
 * 学生数据层实现类
 */
public class StudentDao extends BaseDaoUtil implements IStudentDao {

	@Override
	public Student findByEmail(String email) {
		String sql="select * from student where email=?";
		
		Object[] paramsValue = {email};
		
		List<Student> list = super.query(sql,paramsValue , Student.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}

	@Override
	public List<Student> findByMajorAndClas(String major, String clas) {
		String sql="select * from student where major=? and clas=?";
		
		Object[] paramsValue = {major,clas};
		
		List<Student> list = super.query(sql,paramsValue , Student.class);
		return list;
	}

	
	
	/***分页查询数据*****/
	
	@Override
	public void getAll(PageBean<Student> pb, String major, String clas) {
		//1.封装好pb对象
		//1.1查询总记录书，并设置到pb对象中
		int totalCount=this.getTotalCount(major, clas);
		pb.setTotalCount(totalCount);
		
		//1.2判断设置当前页
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//1.3获取当前页： 计算查询的起始行、返回的行数
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1 )*pb.getPageCount();
		int count=pb.getPageCount();
		
		
		//2.分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select * from student where major=? and clas=? limit ?,?";
		
		Object[] paramsValue = {major,clas,index,count};
		// 根据当前页，查询当前页数据(一页数据)
		List<Student> pageData = super.query(sql,paramsValue , Student.class);
	
		// 设置到pb对象中
		pb.setPageData(pageData);
	}

	@Override
	public int getTotalCount(String major, String clas) {
		String sql="select * from student where major=? and clas=?";
		
		Object[] paramsValue = {major,clas};
		
		List<Student> count = super.query(sql,paramsValue , Student.class);
	//	return Integer.parseInt(count.toString());
		return count.size();
	}

}
