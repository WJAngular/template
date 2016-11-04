
package com.lckj.security.operation.model;

import com.lckj.base.model.MessageInfo;

/**
 * 
* @ClassName: OperationVO 
* @Description:  操作实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:22 
*
 */
public class OperationVO extends MessageInfo {
    
    /** 操作ID **/
    private Integer operationId;
    
    /** 菜单ID **/
    private Integer menuId;
    
    /** 菜单名称 **/
    private String menuName;
    
    /** 父菜单名称 **/
    private String parentMenuName;
    
    /** 操作名称 **/
    private String operationName;
    
    /** 操作编码 **/
    private String operationCode;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
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
    
    /**
     * 获取菜单ID
     * 
     * @return 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }
    
    /**
     * 设值菜单ID
     * 
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    
    /**
     * @return menuName
     */
    public String getMenuName() {
        return menuName;
    }
    
    /**
     * @param menuName menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    /**
     * 获取操作名称
     * 
     * @return 操作名称
     */
    public String getOperationName() {
        return operationName;
    }
    
    /**
     * 设值操作名称
     * 
     * @param operationName 操作名称
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
    
    /**
     * @return operationCode
     */
    public String getOperationCode() {
        return operationCode;
    }
    
    /**
     * @param operationCode operationCode
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
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
     * @return parentMenuName
     */
    public String getParentMenuName() {
        return parentMenuName;
    }
    
    /**
     * @param parentMenuName parentMenuName
     */
    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("OperationVO[");
        sb.append(super.toString());
        sb.append("\n    operationId=").append(this.operationId);
        sb.append("\n    menuId=").append(this.menuId);
        sb.append("\n    menuName=").append(this.menuName);
        sb.append("\n    parentMenuName=").append(this.parentMenuName);
        sb.append("\n    operationName=").append(this.operationName);
        sb.append("\n    operationCode=").append(this.operationCode);
        sb.append("\n    status=").append(this.status);
        sb.append("\n]");
        return sb.toString();
    }
}
