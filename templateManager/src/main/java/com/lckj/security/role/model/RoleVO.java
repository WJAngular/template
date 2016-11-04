
package com.lckj.security.role.model;

import com.lckj.base.model.PagerParam;

/**
 * 
* @ClassName: RoleVO 
* @Description: 角色实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:31:25 
*
 */
public class RoleVO extends PagerParam {
    
    /** 角色ID **/
    private Integer roleId;
    
    /** 角色名称 **/
    private String roleName;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
    /** 备注 **/
    private String remark;
    
    /** 菜单ID **/
    private String menuId;
    
    /** 用户ID **/
    private String userId;
    
    /** 操作权限id */
    private String operationId;
    
    /** 角色级别 **/
    private Integer roleLevel;
    
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
    
    /**
     * 获取角色名称
     * 
     * @return 角色名称
     */
    public String getRoleName() {
        return roleName;
    }
    
    /**
     * 设值角色名称
     * 
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * 获取状态(1:激活、2:禁用)
     * 
     * @return 状态(1:激活、2:禁用)
     */
    public Integer getStatus() {
        return status;
    }
    
    /**
     * 设值状态(1:激活、2:禁用)
     * 
     * @param status 状态(1:激活、2:禁用)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * 获取备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * 设值备注
     * 
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取菜单ID
     * 
     * @return 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }
    
    /**
     * 设置菜单ID
     * 
     * @param menuId 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
    /**
     * 获取用户ID
     * 
     * @return 用户ID
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * 设置用户ID
     * 
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * 获取操作ID
     * 
     * @return 操作ID
     */
    public String getOperationId() {
        return operationId;
    }
    
    /**
     * 设置操作ID
     * 
     * @param operationId 操作ID
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
    
    /**
     * @return roleLevel
     */
    public Integer getRoleLevel() {
        return roleLevel;
    }
    
    /**
     * @param roleLevel roleLevel
     */
    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("RoleVO[");
        sb.append(super.toString());
        sb.append("\n    roleId=").append(this.roleId);
        sb.append("\n    roleName=").append(this.roleName);
        sb.append("\n    status=").append(this.status);
        sb.append("\n    remark=").append(this.remark);
        sb.append("\n    menuId=").append(this.menuId);
        sb.append("\n    userId=").append(this.userId);
        sb.append("\n    operationId=").append(this.operationId);
        sb.append("\n    roleLevel=").append(this.roleLevel);
        sb.append("\n]");
        return sb.toString();
    }
}
