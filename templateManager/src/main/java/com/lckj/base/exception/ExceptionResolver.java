
package com.lckj.base.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 
* @ClassName: ExceptionResolver 
* @Description: 平台 Web 异常处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:01:49 
*
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {
    
    /** 异常错误提示信息 */
    private static final String EXCEPTION_MESSAGE = "exceptionMessage";
    
    /** 异常堆栈信息 */
    private static final String EXCEPTION = "exception";
    
    /** 服务器信息 */
    // private static final String SERVER = "server";
    
    /** ObjectMapper */
    private ObjectMapper mapper = new ObjectMapper();
    
    /** 是否为生产环境 */
    // private static final String IS_PRODUCTION_ENVIRONMENT = "isProductionEnvironment";
    
    @Override
    public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) {
        // Apply HTTP status code for error views, if specified.
        // Only apply it if we're processing a top-level request.
        String viewName = determineViewName(ex, request);
        if (viewName != null) {
            Integer statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode.intValue());
            }
        } else {
            applyStatusCodeIfPossible(request, response, 500);
        }
        Map<String, String> errJsonStr = this.getErrJsonStr(ex);
        // JSONObject errJson = JSONObject.fromObject(errJsonStr);
        String stackTrace = null;
        try {
            stackTrace = mapper.writeValueAsString(errJsonStr);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // JSON格式返回
        if (this.isAjax(request)) {
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write(stackTrace);
                writer.flush();
            } catch (IOException e) {
                logger.error("返回异常信息到页面时出错：", e);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
        request.setAttribute(EXCEPTION_MESSAGE, errJsonStr.get(EXCEPTION_MESSAGE));
        return null;
    }
    
    /**
     * 组装异常json字符串
     * 
     * @param exception 异常信息
     * @return 异常json字符串
     */
    private Map<String, String> getErrJsonStr(Exception exception) {
        String exceptionMessage = exception.getMessage();
        Map<String, String> expMap = new HashMap<String, String>();
        expMap.put(EXCEPTION_MESSAGE, exceptionMessage);
        expMap.put(EXCEPTION, ExceptionUtils.getFullStackTrace(exception));
        return expMap;
    }
    
    /**
     * 是否异步请求
     * 
     * @param request 请求
     * @return 是否异步
     */
    private boolean isAjax(HttpServletRequest request) {
        String accept = request.getHeader("Accept");
        String xRequested = request.getHeader("X-Requested-With");
        return StringUtils.isNotBlank(accept) && accept.indexOf("application/json") > -1 || StringUtils.isNotBlank(xRequested)
            && xRequested.indexOf("XMLHttpRequest") > -1;
    }
}
