
package cn.com.qpm.framework.dashboard.model;

import java.util.List;

/*
 * 控制台实体
 * @date 2016年3月9日
 * @author wenkangqiang
 *
 */
public class DashboardEntry {
	
	
	private String title;	//控制台的页面标题
	
	private String icon;	//控制台的左上方的icon
	
	private String authority;		//权限（也可以理解为：角色）	这个是控制台的唯一标识，不能出现同一权限的不同控制台。这部分也会在Spring拦截器中做监测
	
	/*
	 * 顶级菜单导航栏
	 */
	private List<TopNarPoint>	topkids;
	
	/*
	 * 侧方菜单导航栏
	 */
	private List<Barpoint> sidekids;
	
	

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<TopNarPoint> getTopkids() {
		return topkids;
	}

	public void setTopkids(List<TopNarPoint> topkids) {
		this.topkids = topkids;
	}

	public List<Barpoint> getSidekids() {
		return sidekids;
	}

	public void setSidekids(List<Barpoint> sidekids) {
		this.sidekids = sidekids;
	}

	@Override
	public String toString() {
		return "DashboardEntry [title=" + title + ", authority=" + authority
				+ ", topkids=" + topkids + ", sidekids=" + sidekids + "]";
	}
	
	

}
