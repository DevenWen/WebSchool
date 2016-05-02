
package cn.com.qpm.framework.dashboard.model;

import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import cn.com.qpm.framework.context.WebSchoolContext;

/*
 * 导航栏上级的菜单选项模型
 * @date 2016年3月9日
 * @author Administrator
 *
 */
public class TopNarPoint {
	
	
	private String title;
	
	private String icon;
	
	/*
	 * url:
	 */
	private String url;
	
	//顶部菜单栏，先不设下拉选项。
	//private List<Barpoint> kids;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		/*
		 * 返回URL的时候，要注意匹配该项目的项目名。
		 * 当dashboard，指定:{path}为该项目的名称，这里返回的时候应该注意把:{path}翻译
		 */
		String path = WebSchoolContext.getHttpServletRequest().getContextPath();
		return url.replace(":{path}", path);
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
