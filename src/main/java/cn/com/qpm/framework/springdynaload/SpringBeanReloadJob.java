package cn.com.qpm.framework.springdynaload;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;

/**
 * declaration： 
 *		设计线程，保持对资源文件的不断探测
 * author wenkangqiang
 * date   2016年3月5日
 */
public class SpringBeanReloadJob implements Runnable {
	
	
	private static final Logger log = LogManager
			.getLogger(SpringBeanReloadJob.class);
	

	@Override
	public void run() {
		try{
			XmlRefreshWebApplicationContext applicationContext = (XmlRefreshWebApplicationContext)ContextLoader
					.getCurrentWebApplicationContext();
			applicationContext.reload();
		} catch (Exception ex) {
			log.error("Sping重载配置失败", ex);
		}
		
	}

}
