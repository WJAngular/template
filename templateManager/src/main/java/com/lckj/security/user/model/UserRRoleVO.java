
package com.lckj.security.user.model;

import com.lckj.base.model.PagerParam;

/**
 * 
* @ClassName: UserRRoleVO 
* @Description: 用户角色关系实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:32:11 
*
 */
public class UserRRoleVO extends PagerParam {
    
    /** 用户ID **/
    private Integer userId;
    
    /** 角色ID **/
    private Integer roleId;
    
    /**
     * 构造函数
     * 
     * @param userId 用户ID
     * @param roleId 角色ID
     */
    public UserRRoleVO(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
    
    /**
     * 获取用户ID
     * 
     * @return 用户ID
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设值用户ID
     * 
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * 获取角色ID
     * 
     * @return 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }
    
    /**
     * 设值角色ID
     * 
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
