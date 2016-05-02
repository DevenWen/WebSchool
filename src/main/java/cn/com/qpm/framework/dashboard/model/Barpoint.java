
package cn.com.qpm.framework.dashboard.model;

import java.util.ArrayList;
import java.util.List;

import cn.com.qpm.framework.context.WebSchoolContext;

/*
 * 侧边导航sidebar的节点元素
 * 其实，这就是一个<li>的标签模型，它可以递归的应用于各种的<li>，它可以包含一个List<Barpoint>以此完成下级菜单栏
 * @date 2016年3月9日
 * @author Administrator
 *
 */
public class Barpoint {
	
	//li标题
	private String title;
	
	//li的icon标签
	private String icon;

	//Barpoint的类型：可选："parent"/"leave"  
	//配置为parent父节点的将可以在在面添加子菜单，这时配置url是无效的
	//(默认值)配置为leave叶子节点，即可以为选项添加url，并调用JS对iframe进行src的设定
	private String type = "leave";
	
	private String url;
	
	private List<Barpoint> kids = new ArrayList<Barpoint>();

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		String path = WebSchoolContext.getHttpServletRequest().getContextPath();
		return url.replace(":{path}", path);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Barpoint> getKids() {
		return kids;
	}

	public void setKids(List<Barpoint> kids) {
		this.kids = kids;
	}
	
}
