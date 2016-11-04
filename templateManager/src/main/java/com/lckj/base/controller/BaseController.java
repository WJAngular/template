
package com.lckj.base.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lckj.base.model.MessageInfo;
import com.lckj.base.model.PagerVO;

/**
 * 
* @ClassName: BaseController 
* @Description: 基础控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:01:03 
* 
* @param <T>
 */
public class BaseController<T> {
    
    /** 日志对象 */
    protected final Log logger = LogFactory.getLog(BaseController.class);
    
    /** 提示信息 */
    private String promptMessage = "";
    
    /**
     * 打印日志信息
     * 
     * @param pagerVO 分页对象
     * @param throwable 错误异常链
     */
    public void printException(PagerVO pagerVO, Throwable throwable) {
        pagerVO.setErrmsg(this.promptMessage + "失败！");
        logger.error(this.promptMessage + "失败！", throwable);
    }
    
    /**
     * 打印日志信息
     * 
     * @param messageInfo 错误信息对象
     * @param throwable 错误异常链
     */
    public void printException(MessageInfo messageInfo, Throwable throwable) {
        messageInfo.setErrorMessage(this.promptMessage + "失败！");
        // logger.error(this.promptMessage + "失败！", throwable);
    }
    
    /**
     * @return promptMessage
     */
    public String getPromptMessage() {
        return promptMessage;
    }
    
    /**
     * @param promptMessage promptMessage
     */
    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
}
