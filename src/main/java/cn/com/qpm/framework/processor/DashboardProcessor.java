
package cn.com.qpm.framework.processor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import cn.com.qpm.framework.dashboard.model.DashboardEntry;
import cn.com.qpm.framework.dashboard.model.DashboardFactory;
import cn.com.qpm.framework.util.ExceptionUtil;

/*
 * bean生成过程中的一个拦截器，阻截dashboard类型的bean，并写入一个Factory中去
 * @date 2016年3月11日
 * @author wenkangqiang
 *
 */
public class DashboardProcessor implements BeanPostProcessor {
	private DashboardFactory boardFactory;

	public DashboardFactory getBoardFactory() {
		return boardFactory;
	}

	public void setBoardFactory(DashboardFactory boardFactory) {
		this.boardFactory = boardFactory;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (null != bean && bean instanceof DashboardEntry) {
			DashboardEntry boardEntry = (DashboardEntry)bean;
			try {
				if (StringUtils.isBlank(boardEntry.getAuthority())){
					ExceptionUtil.throwRuntimeException("控制台实体"+beanName+"未设定Authority!");
				}
				String auth = boardEntry.getAuthority();
				boardFactory.getBoardEntryMap().put(auth, boardEntry);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
