
package com.lckj.base.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
* @ClassName: ExceptionAspect 
* @Description: 异常切面处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:02:47 
*
 */
@Service
public class ExceptionAspect {
    
    /**
     * 异常拦截器
     * 
     * @param pjp 异常点
     * @return 异常
     */
    public Object doAround(ProceedingJoinPoint pjp) {
        Logger objLogger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        
        // / 此处返回的是拦截的方法的返回值，如果不执行此方法，则不会执行被拦截的方法，利用环绕通知可以很好的做权限管理
        // long lBegin = System.currentTimeMillis();
        Object objResult = null;
        try {
            objResult = pjp.proceed();
        } catch (Throwable throwable) {
            objLogger.error("平台捕获到系统异常,进行日志输出定位", throwable);
            throw new RuntimeException(throwable);
            // Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        }
        // long lEnd = System.currentTimeMillis();
        // Object[] objLogOut = { pjp, Arrays.deepToString(pjp.getArgs()), lEnd - lBegin };
        return objResult;
    }
    
    /**
     * 异常处理
     * 
     * @param throwable 产生的异常
     */
    public void processException(Throwable throwable) {
    }
}
