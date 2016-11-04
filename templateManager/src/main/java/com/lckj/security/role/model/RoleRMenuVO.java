
package com.lckj.security.role.model;

import com.lckj.base.model.PagerParam;

/**
 * 
* @ClassName: RoleRMenuVO 
* @Description: 菜单角色关系实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:31:13 
*
 */
public class RoleRMenuVO extends PagerParam {
    
    /** 菜单ID **/
    private int menuId;
    
    /** 角色ID **/
    private int roleId;
    
    /**
     * 构造函数
     * 
     * @param roleId 角色ID
     * @param menuId 菜单ID
     */
    public RoleRMenuVO(int roleId, int menuId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }
    
    /**
     * 获取菜单ID
     * 
     * @return 菜单ID
     */
    public int getMenuId() {
        return menuId;
    }
    
    /**
     * 设值菜单ID
     * 
     * @param menuId 菜单ID
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    
    /**
     * 获取角色ID
     * 
     * @return 角色ID
     */
    public int getRoleId() {
        return roleId;
    }
    
    /**
     * 设值角色ID
     * 
     * @param roleId 角色ID
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
