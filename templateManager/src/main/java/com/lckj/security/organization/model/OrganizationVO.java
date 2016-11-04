
package com.lckj.security.organization.model;

import java.util.Map;

import com.lckj.base.model.MessageInfo;
import com.lckj.core.orm.TreeNode;

/**
 * 
* @ClassName: OrganizationVO 
* @Description: 组织结构信息实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:30:16 
*
 */
public class OrganizationVO extends MessageInfo implements TreeNode {
    
    /** 组织ID **/
    private int id;
    
    /** 父组织ID **/
    private Integer parentId;
    
    /** 组织名称 **/
    private String name;
    
    /** 组织简称 **/
    private String shortName;
    
    /** 组织编码 **/
    private String code;
    
    /** 机构类别(1:省厅、2:市局、3:支队、4:大队、5:中队) **/
    private Integer type;
    
    /** 是否叶子节点 **/
    private Integer leafMark;
    
    /** 排序号 **/
    private Integer sortNo;
    
    /** 联系人 **/
    private String linkMan;
    
    /** 联系电话 **/
    private String telephone;
    
    /** 手机号码 **/
    private String mobilephone;
    
    /** 邮箱地址 **/
    private String email;
    
    /** 联系地址 **/
    private String address;
    
    /** 邮编 **/
    private String postCode;
    
    /** 负责人ID **/
    private Integer managerId;
    
    /** 负责人名称 **/
    private String managerName;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
    /** 用户类型(1:组织、2:用户) **/
    private Integer userType;
    
    /** 备注 **/
    private String remark;
    
    /** 获取是否选中 **/
    private Boolean checked;
    
    /** 角色ID **/
    private Integer roleId;
    
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
     * 获取组织简称
     * 
     * @return 组织简称
     */
    public String getShortName() {
        return shortName;
    }
    
    /**
     * 设值组织简称
     * 
     * @param shortName 组织简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    
    /**
     * 获取组织编码
     * 
     * @return 组织编码
     */
    public String getCode() {
        return code;
    }
    
    /**
     * 设值组织编码
     * 
     * @param code 组织编码
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * 获取机构类别(1:省厅、2:市局、3:支队、4:大队、5:中队)
     * 
     * @return 机构类别(1:省厅、2:市局、3:支队、4:大队、5:中队)
     */
    public Integer getType() {
        return type;
    }
    
    /**
     * 设值机构类别(1:省厅、2:市局、3:支队、4:大队、5:中队)
     * 
     * @param type 机构类别(1:省厅、2:市局、3:支队、4:大队、5:中队)
     */
    public void setType(Integer type) {
        this.type = type;
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
    
    /**
     * 获取排序号
     * 
     * @return 排序号
     */
    public Integer getSortNo() {
        return sortNo;
    }
    
    /**
     * 设值排序号
     * 
     * @param sortNo 排序号
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
    
    /**
     * 获取联系人
     * 
     * @return 联系人
     */
    public String getLinkMan() {
        return linkMan;
    }
    
    /**
     * 设值联系人
     * 
     * @param linkMan 联系人
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    
    /**
     * 获取联系电话
     * 
     * @return 联系电话
     */
    public String getTelephone() {
        return telephone;
    }
    
    /**
     * 设值联系电话
     * 
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    /**
     * 获取手机号码
     * 
     * @return 手机号码
     */
    public String getMobilephone() {
        return mobilephone;
    }
    
    /**
     * 设值手机号码
     * 
     * @param mobilephone 手机号码
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    
    /**
     * 获取邮箱地址
     * 
     * @return 邮箱地址
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 设值邮箱地址
     * 
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 获取联系地址
     * 
     * @return 联系地址
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * 设值联系地址
     * 
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * 获取邮编
     * 
     * @return 邮编
     */
    public String getPostCode() {
        return postCode;
    }
    
    /**
     * 设值邮编
     * 
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    /**
     * @return managerId
     */
    public Integer getManagerId() {
        return managerId;
    }
    
    /**
     * @param managerId managerId
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    
    /**
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }
    
    /**
     * @param managerName managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
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
     * @return userType
     */
    public Integer getUserType() {
        return userType;
    }
    
    /**
     * @param userType userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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
     * @param checked checked
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    
    /**
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }
    
    /**
     * @param roleId roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        return this.checked;
    }
    
    @Override
    public Map<String, String> getAttributes() {
        return null;
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
        sb.append("\n    shortName=").append(this.shortName);
        sb.append("\n    code=").append(this.code);
        sb.append("\n    type=").append(this.type);
        sb.append("\n    leafMark=").append(this.leafMark);
        sb.append("\n    sortNo=").append(this.sortNo);
        sb.append("\n    linkMan=").append(this.linkMan);
        sb.append("\n    telephone=").append(this.telephone);
        sb.append("\n    mobilephone=").append(this.mobilephone);
        sb.append("\n    email=").append(this.email);
        sb.append("\n    address=").append(this.address);
        sb.append("\n    postCode=").append(this.postCode);
        sb.append("\n    managerId=").append(this.managerId);
        sb.append("\n    managerName=").append(this.managerName);
        sb.append("\n    status=").append(this.status);
        sb.append("\n    userType=").append(this.userType);
        sb.append("\n    remark=").append(this.remark);
        sb.append("\n    checked=").append(this.checked);
        sb.append("\n    roleId=").append(this.roleId);
        sb.append("\n]");
        return sb.toString();
    }
}
