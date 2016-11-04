
package com.lckj.base.systeminit;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 环境工具类
 */
public final class EnviromentInfo {
    
    /** 日志 */
    protected final static Logger logger = Logger.getLogger(EnviromentInfo.class);
    
    /** 服务器上下文 */
    private static ServletContext servletContext;
    
    /** Spring上下文 */
    private static WebApplicationContext ctx;
    
    /** 构造函数 */
    private EnviromentInfo() {
    }
    
    /**
     * 获取服务器上下文
     * 
     * @return 服务器上下文
     */
    public static ServletContext getServletContext() {
        return servletContext;
    }
    
    /**
     * 设值服务器上下文
     * 
     * @param servletContext 服务器上下文
     */
    public static void setServletContext(ServletContext servletContext) {
        EnviromentInfo.servletContext = servletContext;
    }
    
    /**
     * 获取Spring上下文
     * 
     * @return Spring上下文
     */
    public static WebApplicationContext getWebApplicationContext() {
        if (ctx == null) {
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        }
        return ctx;
    }
}
