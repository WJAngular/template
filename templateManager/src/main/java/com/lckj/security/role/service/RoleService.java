
package com.lckj.security.role.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.base.BaseConstant;
import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;
import com.lckj.security.menu.mapper.MenuMapper;
import com.lckj.security.menu.model.MenuVO;
import com.lckj.security.operation.mapper.OperationMapper;
import com.lckj.security.operation.model.RoleROperationVO;
import com.lckj.security.role.mapper.RoleMapper;
import com.lckj.security.role.model.RoleRMenuVO;
import com.lckj.security.role.model.RoleVO;
import com.lckj.security.user.mapper.UserMapper;
import com.lckj.security.user.model.UserRRoleVO;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: RoleService 
* @Description:  角色业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:31:34 
*
 */
@Service
public class RoleService extends AbstractService<RoleVO> {
    
    /** 角色持久化处理接口 */
    @Autowired
    RoleMapper roleMapper;
    
    /** 菜单持久化处理接口 */
    @Autowired
    MenuMapper menuMapper;
    
    /** 用户持久化处理接口 */
    @Autowired
    UserMapper userMapper;
    
    /** 操作持久化处理接口 */
    @Autowired
    OperationMapper operationMapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<RoleVO> getMapper() {
        return this.roleMapper;
    }
    
    /**
     * 根据角色查询角色对应的菜单信息
     * 
     * @param roleVO 角色信息
     * @return 菜单map集合
     */
    public Map<String, Object> queryRoleMappingMenu(RoleVO roleVO) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 查询角色对应的菜单
        SimpleCondition conditionRole = new SimpleCondition();
        conditionRole.andEqual("roleId", roleVO.getRoleId());
        conditionRole.andEqual("status", BaseConstant.STATUS_ENABLE);
        result.put("current", menuMapper.queryMenuByRole(conditionRole));
        
        // 查询操作权限列表和角色对应的操作权限
        result.put("permissions", operationMapper.list(new Condition()));
        result.put("currentPermissions", operationMapper.queryRolePermissions(roleVO));
        
        // 查询所有的根菜单
        SimpleCondition conditionBase = new SimpleCondition();
        conditionBase.andEqual("parentMenuId", "0");
        conditionBase.andEqual("status", BaseConstant.STATUS_ENABLE);
        
        // 查询所有的子菜单
        SimpleCondition conditionChild = new SimpleCondition();
        conditionChild.andNotEqual("parentMenuId", "0");
        conditionChild.andEqual("status", BaseConstant.STATUS_ENABLE);
        
        // 将对应的子菜单组装到父菜单中
        List<MenuVO> allMenu = compareChildMenuToBaseMenu(menuMapper.list(conditionBase), menuMapper.list(conditionChild));
        result.put("all", allMenu);
        return result;
    }
    
    /**
     * 根据角色查询角色对应的用户信息
     * 
     * @param roleVO 角色信息
     * @return 用户map集合
     */
    public Map<String, Object> queryUserMappingRole(RoleVO roleVO) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 查询角色对应的用户
        SimpleCondition conditionRole = new SimpleCondition();
        conditionRole.andEqual("roleId", roleVO.getRoleId());
        conditionRole.andEqual("status", BaseConstant.STATUS_ENABLE);
        result.put("current", userMapper.queryUserByRole(conditionRole));
        
        // 查询所有的用户
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("status", BaseConstant.STATUS_ENABLE);
        condition.orderAsc("userId");
        List<UserVO> allUser = userMapper.list(condition);
        result.put("all", allUser);
        return result;
    }
    
    /**
     * 将对应的子菜单组装到父菜单中
     * 
     * @param baseMenu 父菜单
     * @param childMenu 子菜单
     * @return 菜单集合
     */
    private List<MenuVO> compareChildMenuToBaseMenu(List<MenuVO> baseMenu, List<MenuVO> childMenu) {
        // 组装根节点的MAP信息
        Map<Integer, List<MenuVO>> baseMenuMappingChild = new HashMap<Integer, List<MenuVO>>();
        for (MenuVO menuVO : baseMenu) {
            baseMenuMappingChild.put(menuVO.getMenuId(), new ArrayList<MenuVO>());
        }
        
        // 循环将子菜单与父菜单对应成MAP列表
        for (MenuVO menuVO : childMenu) {
            if (baseMenuMappingChild.get(menuVO.getParentMenuId()) == null) {
                continue;
            }
            baseMenuMappingChild.get(menuVO.getParentMenuId()).add(menuVO);
        }
        
        // 循环组装父菜单对应的子菜单信息
        for (MenuVO menuVO : baseMenu) {
            menuVO.setChildMenuVOs(baseMenuMappingChild.get(menuVO.getMenuId()));
        }
        return baseMenu;
    }
    
    /**
     * 插入角色与菜单对应关系
     * 
     * @param roleVO 角色信息
     * @return 插入记录数
     */
    public int insertRoleMappingMenu(RoleVO roleVO) {
        int result = 0;
        String menuIds = roleVO.getMenuId();
        if (menuIds.endsWith(";")) {
            menuIds = menuIds.substring(0, menuIds.length() - 1);
        } else {
            result = 1;
        }
        String operationIds = roleVO.getOperationId();
        if (operationIds.endsWith(";")) {
            operationIds = operationIds.substring(0, operationIds.length() - 1);
        }
        
        // 删除此角色与菜单的关联信息
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("roleId", roleVO.getRoleId());
        roleMapper.deleteRoleRMenu(condition);
        
        // 删除此角色与操作权限的关联关系
        condition = new SimpleCondition();
        condition.andEqual("roleId", roleVO.getRoleId());
        roleMapper.deleteRoleROperation(condition);
        
        if (menuIds.length() > 0) {
            List<RoleRMenuVO> roleRMenuVOs = new ArrayList<RoleRMenuVO>();
            for (String menuId : menuIds.split(";")) {
                roleRMenuVOs.add(new RoleRMenuVO(roleVO.getRoleId(), Integer.parseInt(menuId)));
            }
            roleMapper.batchInsertRoleRMenu(roleRMenuVOs);
            result = roleRMenuVOs.size();
        }
        
        if (operationIds.length() > 0) {
            List<RoleROperationVO> roleROperationVOs = new ArrayList<RoleROperationVO>();
            for (String operationId : operationIds.split(";")) {
                roleROperationVOs.add(new RoleROperationVO(roleVO.getRoleId(), Integer.parseInt(operationId)));
            }
            roleMapper.batchInsertRoleROperation(roleROperationVOs);
        }
        return result;
    }
    
    /**
     * 新增角色与用户对应关系
     * 
     * @param roleVO 角色信息
     * @return 新增的记录数量
     */
    public int insertRoleMappingUser(RoleVO roleVO) {
        int result = 0;
        String userIds = roleVO.getUserId();
        if (userIds.endsWith(";")) {
            userIds = userIds.substring(0, userIds.length() - 1);
        }
        
        // 删除此角色与用户的关联信息
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("roleId", roleVO.getRoleId());
        roleMapper.deleteUserRRole(condition);
        
        if (userIds.length() > 0) {
            List<UserRRoleVO> userRRoleVOs = new ArrayList<UserRRoleVO>();
            for (String userId : userIds.split(";")) {
                userRRoleVOs.add(new UserRRoleVO(Integer.parseInt(userId), roleVO.getRoleId()));
            }
            roleMapper.batchInsertUserRRole(userRRoleVOs);
            result = userRRoleVOs.size();
        }
        return result;
    }
    
    /**
     * 根据用户编号查询拥有的角色
     * 
     * @param userId 用户编号
     * @return 用户map集合
     */
    public Map<String, RoleVO> queryRoleByUserId(int userId) {
        Map<String, RoleVO> result = new HashMap<String, RoleVO>();
        // 查询角色对应的用户
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("userId", userId);
        condition.andEqual("status", BaseConstant.STATUS_ENABLE);
        List<RoleVO> roles = roleMapper.queryRoleByUser(condition);
        if (roles == null || roles.size() == 0) {
            return result;
        }
        for (RoleVO roleVO : roles) {
            result.put(roleVO.getRoleName(), roleVO);
        }
        return result;
    }
    
    /**
     * 根据用户查询角色信息
     * 
     * @param condition 过滤条件
     * @return 角色集合
     */
    public List<RoleVO> queryRoleByUser(Condition condition) {
        return roleMapper.queryRoleByUser(condition);
    }
    
    /**
     * 查询角色信息（包含角色级别过滤）
     * 
     * @param param 查询条件
     * @return 角色信息清单
     */
    public List<RoleVO> roleList(Map<String, Integer> param) {
        return roleMapper.roleList(param);
    }
    
    /**
     * 删除用户与角色对应关系
     * 
     * @param condition 查询条件
     */
    public void deleteUserRRole(Condition condition) {
        roleMapper.deleteUserRRole(condition);
    }
    
    /**
     * 批量插入用户与角色对应关系
     * 
     * @param userRRoleVOs 用户与角色关系集合
     */
    public void batchInsertUserRRole(List<UserRRoleVO> userRRoleVOs) {
        roleMapper.batchInsertUserRRole(userRRoleVOs);
    }
}
