
package com.lckj.core.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
* @ClassName: ExceptionInterceptor 
* @Description: TODO 
* @author: WUJING 
* @date :2016-06-10 上午11:26:22 
*
 */
public class ExceptionInterceptor extends HandlerInterceptorAdapter {
    
    /** logger */
    public static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.error("ExceptionInterceptor Catach The Controller Error", ex);
    }
}
