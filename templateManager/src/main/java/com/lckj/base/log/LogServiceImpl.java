
package com.lckj.base.log;

import org.aspectj.lang.JoinPoint;

/**
 * 
* @ClassName: LogServiceImpl 
* @Description: TODO 
* @author: WUJING 
* @date :2016-06-10 上午11:03:20 
*
 */
public class LogServiceImpl implements ILogService {
    
    @Override
    public void log() {
        System.out.println("*************Log*******************");
    }
    
    @Override
    public void logArg(JoinPoint point) {
        // 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("有参数无返回值得方法，目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
        }
    }
    
    @Override
    public void logArgAndReturn(JoinPoint point, Object returnObj) {
        // 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("有参数有返回值得方法，目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
            System.out.println("执行结果是：" + returnObj);
        }
    }
}
