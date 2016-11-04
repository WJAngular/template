
package com.lckj.base.exception;

/**
 * 
* @ClassName: BusinessException 
* @Description: 业务异常处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:01:24 
*
 */
public class BusinessException extends RuntimeException {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 4306448854352716126L;
    
    /** 无参构造函数 */
    public BusinessException() {
        super();
    }
    
    /**
     * 构造函数
     * 
     * @param message 异常信息
     * @param cause 异常链
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 构造函数
     * 
     * @param message 异常信息
     */
    public BusinessException(String message) {
        super(message);
    }
    
    /**
     * 构造函数
     * 
     * @param cause 异常链
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }
    
}
