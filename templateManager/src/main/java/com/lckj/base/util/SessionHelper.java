
package com.lckj.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
* @ClassName: SessionHelper 
* @Description: HttpSession 帮助类 
* @author: WUJING 
* @date :2016-06-10 上午11:11:04 
*
 */
public final class SessionHelper {
    
    /** Logger */
    protected static final Logger LOGGER = LoggerFactory.getLogger(SessionHelper.class);
    
    /**
     * 构造函数
     */
    private SessionHelper() {
    }
    
    /**
     * 获取 HttpServletRequest
     * 
     * @return HttpServletRequest,非web环境下返回null
     */
    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (request == null || request.getRequest() == null) {
            return null;
        }
        HttpServletRequest httpServletRequest = request.getRequest();
        return httpServletRequest;
    }
    
    /**
     * 获取HttpSession
     * 
     * @return HttpSession,非web环境下返回null
     */
    public static HttpSession getSession() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return null;
        }
        HttpSession session = request.getSession();
        return session;
    }
    
    /**
     * 获取ContextPath
     * 
     * @return ContextPath,非web环境下返回空字符串
     */
    public static String getContextPath() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return StringUtils.EMPTY;
        }
        return request.getContextPath();
    }
    
    /**
     * 获取服务器IP和端口信息
     * 
     * @return ContextPath,非web环境下返回空字符串
     */
    public static String getServerInfo() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getLocalAddr() + ":" + request.getLocalPort();
    }
    
    // /**
    // * 获取当前用户信息
    // *
    // * @return UserInfoVO 当前用户信息
    // */
    // public static UserVO getLoginUser() {
    // return (UserVO) getSession().getAttribute(BaseConstant.BASE_LOGIN_INFO);
    // }
}
