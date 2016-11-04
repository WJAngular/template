package com.lckj.base.model;

import com.lckj.base.BaseConstant;

/**
 * 
* @ClassName: MessageInfo 
* @Description: 错误信息对象 
* @author: WUJING 
* @date :2016-06-10 上午11:03:43 
*
 */
public class MessageInfo {
    
    /** 0：表示成功，1：表示失败.返回结果默认为成功 */
    private int returncode = BaseConstant.RETURN_CODE_SUCCESS;
    
    /** 提示信息 */
    private String message;
    
    /**
     * 设置登陆错误信息(用于app使用)
     */
    public void setLoginErrmsg() {
        this.setErrorMessage("用户名或密码不正确，请重新输入！");
        this.setReturncode(1001);
    }
    
    /**
     * 设置登录已失效信息(用于app使用)
     */
    public void setInvalidErrmsg() {
        this.setErrorMessage("登录已失效,请重新登录！");
        this.setReturncode(1009);
    }
    
    /**
     * 设置成功消息
     * 
     * @param message 提示信息
     */
    public void setSuccessMessage(String message) {
        this.returncode = BaseConstant.RETURN_CODE_SUCCESS;
        this.message = message;
    }
    
    /**
     * 设置错误消息
     * 
     * @param message 提示信息
     */
    public void setErrorMessage(String message) {
        this.returncode = BaseConstant.RETURN_CODE_FAILURE;
        this.message = message;
    }
    
    /**
     * 设置错误消息
     */
    public void setErrorCode() {
        this.returncode = BaseConstant.RETURN_CODE_FAILURE;
    }
    
    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * @return returncode
     */
    public int getReturncode() {
        return returncode;
    }
    
    /**
     * @param returncode returncode
     */
    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("MessageInfo[");
        sb.append("\n    returncode=").append(this.returncode);
        sb.append("\n    message=").append(this.message);
        sb.append("\n]");
        return sb.toString();
    }
    
}
