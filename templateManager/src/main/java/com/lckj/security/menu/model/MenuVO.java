
package com.lckj.security.menu.model;

import java.util.List;

import com.lckj.base.model.MessageInfo;

/**
 * 
* @ClassName: MenuVO 
* @Description: 菜单实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:28:39 
*
 */
public class MenuVO extends MessageInfo {
    
    /** 菜单ID **/
    private Integer menuId;
    
    /** 父菜单ID **/
    private Integer parentMenuId;
    
    /** 菜单名称 **/
    private String menuName;
    
    /** 菜单地址 **/
    private String menuUrl;
    
    /** 菜单图标 **/
    private String menuIcon;
    
    /** 菜单禁用图标 **/
    private String disableIcon;
    
    /** 状态(1:激活、2:禁用) **/
    private Integer status;
    
    /** 菜单排序 **/
    private Integer menuSort;
    
    /** 菜单描述 **/
    private String description;
    
    /** 子菜单列表 */
    private List<MenuVO> childMenuVOs;
    
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
     * 获取父菜单ID
     * 
     * @return 父菜单ID
     */
    public Integer getParentMenuId() {
        return parentMenuId;
    }
    
    /**
     * 设值父菜单ID
     * 
     * @param parentMenuId 父菜单ID
     */
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }
    
    /**
     * 获取菜单名称
     * 
     * @return 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }
    
    /**
     * 设值菜单名称
     * 
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    /**
     * 获取菜单地址
     * 
     * @return 菜单地址
     */
    public String getMenuUrl() {
        return menuUrl;
    }
    
    /**
     * 设值菜单地址
     * 
     * @param menuUrl 菜单地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    
    /**
     * 获取菜单图标
     * 
     * @return 菜单图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }
    
    /**
     * 设值菜单图标
     * 
     * @param menuIcon 菜单图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
    
    /**
     * 获取菜单禁用图标
     * 
     * @return 菜单禁用图标
     */
    public String getDisableIcon() {
        return disableIcon;
    }
    
    /**
     * 设值菜单禁用图标
     * 
     * @param disableIcon 菜单禁用图标
     */
    public void setDisableIcon(String disableIcon) {
        this.disableIcon = disableIcon;
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
     * 获取菜单排序
     * 
     * @return 菜单排序
     */
    public Integer getMenuSort() {
        return menuSort;
    }
    
    /**
     * 设值菜单排序
     * 
     * @param menuSort 菜单排序
     */
    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }
    
    /**
     * 获取菜单描述
     * 
     * @return 菜单描述
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * 设值菜单描述
     * 
     * @param description 菜单描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * 获取子菜单信息
     * 
     * @return childMenuVOs 子菜单集合
     */
    public List<MenuVO> getChildMenuVOs() {
        return childMenuVOs;
    }
    
    /**
     * 设置子菜单信息
     * 
     * @param childMenuVOs 子菜单集合
     */
    public void setChildMenuVOs(List<MenuVO> childMenuVOs) {
        this.childMenuVOs = childMenuVOs;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("MenuVO[");
        sb.append(super.toString());
        sb.append("\n    menuId=").append(this.menuId);
        sb.append("\n    parentMenuId=").append(this.parentMenuId);
        sb.append("\n    menuName=").append(this.menuName);
        sb.append("\n    menuUrl=").append(this.menuUrl);
        sb.append("\n    menuIcon=").append(this.menuIcon);
        sb.append("\n    disableIcon=").append(this.disableIcon);
        sb.append("\n    status=").append(this.status);
        sb.append("\n    menuSort=").append(this.menuSort);
        sb.append("\n    description=").append(this.description);
        sb.append("\n    childMenuVOs=").append(this.childMenuVOs);
        sb.append("\n]");
        return sb.toString();
    }
}
