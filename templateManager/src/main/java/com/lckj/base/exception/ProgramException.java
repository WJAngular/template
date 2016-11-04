
package com.lckj.base.exception;

/**
 * 
* @ClassName: ProgramException 
* @Description: 业务异常处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:01:59 
*
 */
public class ProgramException extends RuntimeException {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 7716917075582368053L;
    
    /** 无参构造函数 */
    public ProgramException() {
        super();
    }
    
    /**
     * 构造函数
     * 
     * @param message 异常信息
     * @param cause 异常链
     */
    public ProgramException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 构造函数
     * 
     * @param message 异常信息
     */
    public ProgramException(String message) {
        super(message);
    }
    
    /**
     * 构造函数
     * 
     * @param cause 异常链
     */
    public ProgramException(Throwable cause) {
        super(cause);
    }
    
}
