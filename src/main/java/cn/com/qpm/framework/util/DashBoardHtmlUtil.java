package cn.com.qpm.framework.util;

import java.io.IOException;

import javax.json.Json;
import javax.servlet.jsp.JspWriter;

import cn.com.qpm.framework.dashboard.model.Barpoint;

/**
 * declaration： 
 *		控制台html构造工具类
 * author wenkangqiang
 * date   2016年3月13日
 */
public class DashBoardHtmlUtil {
	
	/**
	 * 通过中序遍历构造Bar
	 * @param root
	 * @param out
	 * @throws IOException
	 */
	public static void printSaidBar(Barpoint root, JspWriter out) throws Exception{
		if ("root".equals(root.getType())){
			//假如这个是根节点
			out.println("<ul id=\"main-nav\" class=\"nav nav-tabs nav-stacked\" style=\"\">\n");
			for (Barpoint kid : root.getKids()){
				printSaidBar(kid, out);
			}
			out.write("</ul>\n");
		} else if("parent".equals(root.getType())){
			//假如这是一个父节点
			StringBuilder code = new StringBuilder();
			code.append("<li>\n <a href=\"#").append(root.getTitle()).append("_sidebar\"")
			.append(" class=\"nav-header collapsed\" data-toggle=\"collapse\">\n")
			.append(" <i class=\"").append(root.getIcon()).append("\"></i>\n")
			.append(root.getTitle())
			.append(" \n<span class=\"pull-right glyphicon glyphicon-menu-right\"></span>\n</a>\n")
			.append(" <ul id=\"").append(root.getTitle()).append("_sidebar\"")
			.append(" class=\"nav nav-list collapse secondmenu\" style=\"height: 0px;\">\n");
			out.println(code.toString());
			for (Barpoint kid : root.getKids()){
				printSaidBar(kid, out);
			}
			out.write("</ul>\n");         
		} else if("leave".equals(root.getType())){
			StringBuilder code = new StringBuilder();
			code.append("<li>\n <a class=\"sideBarleave\" href=\"#\" url=\"").append(root.getUrl()).append("\">\n")
			.append("<i class=\"").append(root.getIcon()).append("\"></i>\n")
			.append(root.getTitle())
			.append("\n</a>\n </li>\n");
			out.println(code.toString());
		} else {
			ExceptionUtil.throwRuntimeException("侧边栏节点(Title =" + root.getTitle() +")的type类型无法识别，请查看配置。");
		}
	}

}
