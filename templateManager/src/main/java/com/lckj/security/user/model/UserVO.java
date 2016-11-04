
package com.lckj.security.user.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.lckj.base.jsondate.JsonDateSerializer;
import com.lckj.base.model.MessageInfo;

/**
 * 
* @ClassName: UserVO 
* @Description: 用户信息实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:32:22 
*
 */
public class UserVO extends MessageInfo {
    
    /** 用户ID **/
    private Integer userId;
    
    /** 客户编号 **/
    private Integer ownerId;
    
    /** 组织ID **/
    private Integer deptId;
    
    /** 组织编码 **/
    private String deptCode;
    
    /** 组织名称 **/
    private String deptName;
    
    /** 用户名称 **/
    private String userName;
    
    /** 用户帐号 **/
    private String account;
    
    /** 用户密码 **/
    private String password;
    
    /** 身份证号 **/
    private String identityCard;
    
    /** 籍贯 **/
    private String nativePlace;
    
    /** QQ号码 **/
    private String qqNumber;
    
    /** 邮箱地址 **/
    private String email;
    
    /** 手机号码 **/
    private String mobilephone;
    
    /** 文化程度(1:初中、2:高中、3:大专、4:本科、5:硕士、6:博士、7:其他) **/
    private Integer educationDegree;
    
    /** 联系电话 **/
    private String telephone;
    
    /** 出生日期 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    /** 联系地址 **/
    private String relationAddress;
    
    /** 创建人ID **/
    private Integer creatorId;
    
    /** 创建人名称 **/
    private String creatorName;
    
    /** 人员排序 **/
    private Integer userSort;
    
    /** 性别(1:男、2:女) **/
    private Integer sex;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
    /** 岗位(1:保安、2:清洁员) **/
    private Integer post;
    
    /** 用户类型(1:公司职员、2:业主、3:业主家属、9:其他) **/
    private Integer userType;
    
    /** 备注 **/
    private String remark;
    
    /** 照片名称 **/
    private String photo;
    
    /** 照片地址 **/
    private String photoPath;
    
    /** 角色ID **/
    private String roleId;
    
    /** 角色名称 **/
    private String roleName;
    
    /** 待打印的用户ID **/
    private String printUserId;
    
    /**
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * @return ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }
    
    /**
     * @param ownerId ownerId
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
    
    /**
     * @return deptId
     */
    public Integer getDeptId() {
        return deptId;
    }
    
    /**
     * @param deptId deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    /**
     * @return deptCode
     */
    public String getDeptCode() {
        return deptCode;
    }
    
    /**
     * @param deptCode deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    
    /**
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }
    
    /**
     * @param deptName deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    /**
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }
    
    /**
     * @param account account
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return identityCard
     */
    public String getIdentityCard() {
        return identityCard;
    }
    
    /**
     * @param identityCard identityCard
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    
    /**
     * @return nativePlace
     */
    public String getNativePlace() {
        return nativePlace;
    }
    
    /**
     * @param nativePlace nativePlace
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    /**
     * @return qqNumber
     */
    public String getQqNumber() {
        return qqNumber;
    }
    
    /**
     * @param qqNumber qqNumber
     */
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }
    
    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return mobilephone
     */
    public String getMobilephone() {
        return mobilephone;
    }
    
    /**
     * @param mobilephone mobilephone
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    
    /**
     * @return educationDegree
     */
    public Integer getEducationDegree() {
        return educationDegree;
    }
    
    /**
     * @param educationDegree educationDegree
     */
    public void setEducationDegree(Integer educationDegree) {
        this.educationDegree = educationDegree;
    }
    
    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }
    
    /**
     * @param telephone telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    /**
     * @return birthday
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getBirthday() {
        return birthday;
    }
    
    /**
     * @param birthday birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    /**
     * @return relationAddress
     */
    public String getRelationAddress() {
        return relationAddress;
    }
    
    /**
     * @param relationAddress relationAddress
     */
    public void setRelationAddress(String relationAddress) {
        this.relationAddress = relationAddress;
    }
    
    /**
     * @return creatorId
     */
    public Integer getCreatorId() {
        return creatorId;
    }
    
    /**
     * @param creatorId creatorId
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
    
    /**
     * @return creatorName
     */
    public String getCreatorName() {
        return creatorName;
    }
    
    /**
     * @param creatorName creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    
    /**
     * @return userSort
     */
    public Integer getUserSort() {
        return userSort;
    }
    
    /**
     * @param userSort userSort
     */
    public void setUserSort(Integer userSort) {
        this.userSort = userSort;
    }
    
    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }
    
    /**
     * @param sex sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }
    
    /**
     * @param status status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * @return post
     */
    public Integer getPost() {
        return post;
    }
    
    /**
     * @param post post
     */
    public void setPost(Integer post) {
        this.post = post;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * @return roleId
     */
    public String getRoleId() {
        return roleId;
    }
    
    /**
     * @param roleId roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    /**
     * @return printUserId
     */
    public String getPrintUserId() {
        return printUserId;
    }
    
    /**
     * @param printUserId printUserId
     */
    public void setPrintUserId(String printUserId) {
        this.printUserId = printUserId;
    }
    
    /**
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }
    
    /**
     * @param roleName roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }
    
    /**
     * @param photo photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    /**
     * @return photoPath
     */
    public String getPhotoPath() {
        return photoPath;
    }
    
    /**
     * @param photoPath photoPath
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("UserVO[");
        sb.append(super.toString());
        sb.append("\n    userId=").append(this.userId);
        sb.append("\n    ownerId=").append(this.ownerId);
        sb.append("\n    deptId=").append(this.deptId);
        sb.append("\n    deptCode=").append(this.deptCode);
        sb.append("\n    deptName=").append(this.deptName);
        sb.append("\n    userName=").append(this.userName);
        sb.append("\n    account=").append(this.account);
        sb.append("\n    password=").append(this.password);
        sb.append("\n    identityCard=").append(this.identityCard);
        sb.append("\n    nativePlace=").append(this.nativePlace);
        sb.append("\n    qqNumber=").append(this.qqNumber);
        sb.append("\n    email=").append(this.email);
        sb.append("\n    mobilephone=").append(this.mobilephone);
        sb.append("\n    educationDegree=").append(this.educationDegree);
        sb.append("\n    telephone=").append(this.telephone);
        sb.append("\n    birthday=").append(this.birthday);
        sb.append("\n    relationAddress=").append(this.relationAddress);
        sb.append("\n    creatorId=").append(this.creatorId);
        sb.append("\n    creatorName=").append(this.creatorName);
        sb.append("\n    userSort=").append(this.userSort);
        sb.append("\n    sex=").append(this.sex);
        sb.append("\n    status=").append(this.status);
        sb.append("\n    post=").append(this.post);
        sb.append("\n    userType=").append(this.userType);
        sb.append("\n    remark=").append(this.remark);
        sb.append("\n    photo=").append(this.photo);
        sb.append("\n    photoPath=").append(this.photoPath);
        sb.append("\n    roleId=").append(this.roleId);
        sb.append("\n    roleName=").append(this.roleName);
        sb.append("\n    printUserId=").append(this.printUserId);
        sb.append("\n]");
        return sb.toString();
    }
}
