
package cn.com.qpm.framework.dashboard.model;

import java.util.HashMap;
import java.util.Map;

import cn.com.qpm.framework.util.ExceptionUtil;
import cn.com.qpm.framework.util.SpringUtil;

/*
 * 控制台工厂，保存控制台实例
 * 
 * @date 2016年3月11日
 * @author wenkangqiang
 *
 */
public class DashboardFactory {
	private Map<String, DashboardEntry> boardEntryMap = null;
	
	public DashboardFactory(){
		boardEntryMap = new HashMap<String, DashboardEntry>(); 
	}
	
	public static final DashboardFactory getInstance() {
		return (DashboardFactory)SpringUtil.getBean("dashboardFactory");
	}

	public Map<String, DashboardEntry> getBoardEntryMap() {
		return boardEntryMap;
	}

	public void setBoardEntryMap(Map<String, DashboardEntry> boardEntryMap) {
		this.boardEntryMap = boardEntryMap;
	}
	
	/**
	 * 根据权限获得控制台实体
	 * @param auth 权限
	 * @return
	 */
	public DashboardEntry getDashboardEntry(String auth){
		DashboardEntry boardEntry = (DashboardEntry)boardEntryMap.get(auth);
		if (null == boardEntry) {
			try {
				ExceptionUtil.throwNullPointerException("权限值为："+ auth + "的dashBoardEntry不存在");
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		return boardEntry;
	}
	
	

}
