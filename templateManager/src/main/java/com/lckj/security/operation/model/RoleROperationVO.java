
package com.lckj.security.operation.model;

import com.lckj.base.model.PagerParam;

/**
 * 
* @ClassName: RoleROperationVO 
* @Description: 操作角色关系实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:31 
*
 */
public class RoleROperationVO extends PagerParam {
    
    /** 角色ID **/
    private Integer roleId;
    
    /** 操作ID **/
    private Integer operationId;
    
    /**
     * 构造函数
     * 
     * @param roleId 角色ID
     * @param operationId 操作ID
     */
    public RoleROperationVO(Integer roleId, Integer operationId) {
        this.roleId = roleId;
        this.operationId = operationId;
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
    
    /**
     * 获取操作ID
     * 
     * @return 操作ID
     */
    public Integer getOperationId() {
        return operationId;
    }
    
    /**
     * 设值操作ID
     * 
     * @param operationId 操作ID
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("RoleROperationVO[");
        sb.append(super.toString());
        sb.append("\n    roleId=").append(this.roleId);
        sb.append("\n    operationId=").append(this.operationId);
        sb.append("\n]");
        return sb.toString();
    }
}
