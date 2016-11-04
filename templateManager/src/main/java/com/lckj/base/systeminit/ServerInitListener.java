package com.lckj.base.systeminit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化监听类
 */
public class ServerInitListener implements ServletContextListener {

	/** 服务器启动时调用 */
	public void contextInitialized(ServletContextEvent sce) {
		EnviromentInfo.setServletContext(sce.getServletContext());
	}

	/** 服务器关闭时调用 */
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
