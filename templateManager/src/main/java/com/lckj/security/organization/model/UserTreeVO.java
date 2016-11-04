
package com.lckj.security.organization.model;

import java.util.Map;

import com.lckj.base.model.MessageInfo;
import com.lckj.core.orm.TreeNode;

/**
 * 
* @ClassName: UserTreeVO 
* @Description: 组织结构信息实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:30:28 
*
 */
public class UserTreeVO extends MessageInfo implements TreeNode {
    
    /** 组织ID **/
    private Integer id;
    
    /** 父组织ID **/
    private Integer parentId;
    
    /** 组织名称 **/
    private String name;
    
    /** 是否叶子节点 **/
    private Integer leafMark;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
    /**
     * 获取组织ID
     * 
     * @return 组织ID
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * 设值组织ID
     * 
     * @param id 组织ID
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 获取父组织ID
     * 
     * @return 父组织ID
     */
    public Integer getParentId() {
        return parentId;
    }
    
    /**
     * 设值父组织ID
     * 
     * @param parentId 父组织ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    /**
     * 获取组织名称
     * 
     * @return 组织名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 设值组织名称
     * 
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取是否叶子节点
     * 
     * @return 是否叶子节点
     */
    public Integer getLeafMark() {
        return leafMark;
    }
    
    /**
     * 设值是否叶子节点
     * 
     * @param leafMark 是否叶子节点
     */
    public void setLeafMark(Integer leafMark) {
        this.leafMark = leafMark;
    }
    
    @Override
    public String getIconCls() {
        return null;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("OrganizationVO[");
        sb.append(super.toString());
        sb.append("\n    id=").append(this.id);
        sb.append("\n    parentId=").append(this.parentId);
        sb.append("\n    name=").append(this.name);
        sb.append("\n    status=").append(this.status);
        sb.append("\n    text=").append(this.getText());
        sb.append("\n    state=").append(this.getState());
        sb.append("\n    checked=").append(this.getChecked());
        sb.append("\n]");
        return sb.toString();
    }
    
    @Override
    public String getText() {
        return this.name;
    }
    
    @Override
    public String getState() {
        return leafMark == 2 ? TreeNode.STATA_CLOSE : TreeNode.STATA_OPEN;
    }
    
    @Override
    public Boolean getChecked() {
        return false;
    }
    
    @Override
    public Map<String, String> getAttributes() {
        return null;
    }
}
