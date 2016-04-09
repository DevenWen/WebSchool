package com.cn.lon.dao.impl;

import java.util.List;

import com.cn.lon.dao.IZHGradesDao;
import com.cn.lon.entity.ZHGrades;
import com.cn.lon.utils.BaseDaoUtil;
import com.cn.lon.utils.PageBean;
/**
 * 综合分数表数据层实现类
 * @author Administrator
 *
 */
public class ZHGradesDao extends BaseDaoUtil implements IZHGradesDao{

	//a.通过学号查询
	public ZHGrades findById(String stuid) {
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where stuid=?";
		
		Object[] paramsValue = {stuid};
		
		List<ZHGrades> list = super.query(sql,paramsValue , ZHGrades.class);
		return (list!=null&&list.size()>0) ? list.get(0) : null;
	}
	
	//通过专业获取所有学生的综合评分排名
	@Override
	public List<ZHGrades> getAllByMajor(String major) {
		String sql="select d.stuid as stuid, d.name as name,d.major as major,d.clas as clas,"
				+ "d.sx_score as sx_score,sx.sx_place as sx_place,d.xy_score as xy_score,xy.xy_place as xy_place,"
				+ "d.wt_score as wt_score,wt.wt_place as wt_place,d.zh_score as zh_score,zh.zh_place as zh_place "
				+ "from (select a.stuid ,count(b.stuid)+1 as sx_place from (select * from view_totalgrades where major=?) as a "
				+ "left join (select * from view_totalgrades where major= ?) as  b on a.sx_score < b.sx_score group by a.stuid) as  sx,"
				+ "(select a.stuid  ,count(b.stuid)+1 as xy_place from (select * from view_totalgrades where major=?) as  a "
				+ "left join (select * from view_totalgrades where major=?) as b on a.xy_score < b.xy_score group by a.stuid) as  xy,"
				+ "(select a.stuid ,count(b.stuid)+1 as wt_place from (select * from view_totalgrades where major=?) as  a "
				+ "left join (select * from view_totalgrades where major=?) as  b on a.wt_score < b.wt_score group by a.stuid) as  wt,"
				+ "(select a.stuid ,count(b.stuid)+1 as zh_place from (select * from view_totalgrades where major=?) as  a"
				+ " left join (select * from view_totalgrades where major=?) as  b on a.zh_score < b.zh_score group by a.stuid) as  zh,"
				+ "(select * from view_totalgrades where major=?) as d "
				+ "where  sx.stuid = d.stuid  and d.stuid = wt.stuid and  xy.stuid = d.stuid and d.stuid=zh.stuid "
				+ "order by zh_score desc";
		
		Object[] paramsValue = {major,major,major,major,major,major,major,major,major};
		
		List<ZHGrades> list = super.query(sql,paramsValue , ZHGrades.class);
		
		return list;
	}



	
	/*********分页查询**********/
	
	//b.通过专业和班级查询
	@Override
	public void getAllByMajorAndClas(PageBean<ZHGrades> pb, String major,
			String clas) {
		//1.1获取总行数
		int totalCount=this.getTotalCountByMajorAndClas(major, clas);
		pb.setTotalCount(totalCount);
		
		//1.2判断设置当前页
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getTotalPage()>=1&&pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		
		//1.3获取当前页： 计算查询的起始行、返回的行数
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1 )*pb.getPageCount();
		int count=pb.getPageCount();
		
		
		//2.分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where major like '%' ? '%' and clas like '%' ? '%' limit ?,?";
		
		Object[] paramsValue = {major,clas,index,count};
		// 根据当前页，查询当前页数据(一页数据)
		List<ZHGrades> pageData = super.query(sql,paramsValue , ZHGrades.class);
	
		// 设置到pb对象中
		pb.setPageData(pageData);
		
	}

	//通过专业和班级查询总数
	@Override
	public int getTotalCountByMajorAndClas(String major, String clas) {
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where major like '%' ? '%' and clas like '%' ? '%'";
		
		Object[] paramsValue = {major,clas};
		
		List<ZHGrades> count = super.query(sql,paramsValue , ZHGrades.class);
		return count.size();
	}

	
	//c.通过专业查询
	@Override
	public void getAllByMajor(PageBean<ZHGrades> pb, String major) {
		int totalCount=this.getTotalCountByMajor(major);
		pb.setTotalCount(totalCount);
		
		//1.2判断设置当前页
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getTotalPage()>=1&&pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//1.3获取当前页： 计算查询的起始行、返回的行数
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1 )*pb.getPageCount();
		int count=pb.getPageCount();
		
		
		//2.分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where major like '%' ? '%' limit ?,?";
		
		Object[] paramsValue = {major,index,count};
		// 根据当前页，查询当前页数据(一页数据)
		List<ZHGrades> pageData = super.query(sql,paramsValue , ZHGrades.class);
	
		// 设置到pb对象中
		pb.setPageData(pageData);
		
	}

	//通过专业查询总数
	@Override
	public int getTotalCountByMajor(String major) {
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where major like '%' ? '%'";
		
		Object[] paramsValue = {major};
		
		List<ZHGrades> count = super.query(sql,paramsValue , ZHGrades.class);
		return count.size();
	}


	//通过班级查询
	@Override
	public void getAllByClas(PageBean<ZHGrades> pb, String clas) {
		int totalCount=this.getTotalCountByClas(clas);
		pb.setTotalCount(totalCount);
		
		//1.2判断设置当前页
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getTotalPage()>=1&&pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//1.3获取当前页： 计算查询的起始行、返回的行数
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1 )*pb.getPageCount();
		int count=pb.getPageCount();
		
		
		//2.分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where clas like '%' ? '%' limit ?,?";
		
		Object[] paramsValue = {clas,index,count};
		// 根据当前页，查询当前页数据(一页数据)
		List<ZHGrades> pageData = super.query(sql,paramsValue , ZHGrades.class);
	
		// 设置到pb对象中
		pb.setPageData(pageData);
		
	}


	//通过专业查询总数
	@Override
	public int getTotalCountByClas(String clas) {
		String sql="select stuid,name,major,clas,sx_score,xy_score,wt_score,"
				+ "zh_score from view_totalGrades where clas like '%' ? '%'";
		
		Object[] paramsValue = {clas};
		
		List<ZHGrades> count = super.query(sql,paramsValue , ZHGrades.class);
		return count.size();
	}



	
}
