
package com.lckj.base.log;

import org.aspectj.lang.JoinPoint;

/**
 * 
* @ClassName: ILogService 
* @Description: 日志处理接口 
* @author: WUJING 
* @date :2016-06-10 上午11:03:04 
*
 */
public interface ILogService {
    
    /** 无参的日志方法 */
    public void log();
    
    /**
     * 有参的日志方法
     * 
     * @param point 异常切入点
     */
    public void logArg(JoinPoint point);
    
    /**
     * 有参有返回值的方法
     * 
     * @param point 异常切入点
     * @param returnObj 处理对象
     */
    public void logArgAndReturn(JoinPoint point, Object returnObj);
}
