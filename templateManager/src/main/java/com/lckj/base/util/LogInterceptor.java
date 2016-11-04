
package com.lckj.base.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 
* @ClassName: LogInterceptor 
* @Description: 日志切面处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:08:55 
*
 */
@Repository
public class LogInterceptor {
    
    /** 日志对象 **/
    protected Logger logger = Logger.getLogger(this.getClass());
    
    /**
     * 异常处理
     * 
     * @param ex 异常对象
     */
    public void doThrowing(Throwable ex) {
        System.out.println("logcut");
        logger.error(ex.getLocalizedMessage(), ex);
    }
}
