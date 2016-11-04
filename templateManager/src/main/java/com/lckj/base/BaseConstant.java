
package com.lckj.base;

/**
 * 
* @ClassName: BaseConstant 
* @Description: 权限常量类 
* @author: WUJING 
* @date :2016-06-10 上午11:12:45 
*
 */
public final class BaseConstant {
    
    /** 构造函数 */
    private BaseConstant() {
    }
    
    /** 数据状态 - 激活 */
    public static final int STATUS_ENABLE = 1;
    
    /** 数据状态 - 禁用 */
    public static final int STATUS_DISABLE = 2;
    
    /** 返回编码CODE - 成功 */
    public static final int RETURN_CODE_SUCCESS = 0;
    
    /** 返回编码CODE - 失败 */
    public static final int RETURN_CODE_FAILURE = 1;
    
    /** 当前登录用户信息 */
    public static final String CURR_LOGIN_USER = "login.info";
}
