
package com.lckj.security.role.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.security.operation.model.RoleROperationVO;
import com.lckj.security.role.model.RoleRMenuVO;
import com.lckj.security.role.model.RoleVO;
import com.lckj.security.user.model.UserRRoleVO;

/**
 * 
* @ClassName: RoleMapper 
* @Description: 角色持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:31:02 
*
 */
@Repository
public interface RoleMapper extends MybatisMapper<RoleVO> {
    
    /**
     * 查询角色信息（包含角色级别过滤）
     * 
     * @param param 查询条件
     * @return 角色信息清单
     */
    public List<RoleVO> roleList(Map<String, Integer> param);
    
    /**
     * 根据用户查询角色信息
     * 
     * @param condition 过滤条件
     * @return 角色集合
     */
    public List<RoleVO> queryRoleByUser(@Param("condition") Condition condition);
    
    /**
     * 批量插入用户与角色对应关系
     * 
     * @param userRRoleVOs 用户与角色关系集合
     */
    public void batchInsertUserRRole(List<UserRRoleVO> userRRoleVOs);
    
    /**
     * 删除用户与角色对应关系
     * 
     * @param condition 查询条件
     */
    public void deleteUserRRole(@Param("condition") Condition condition);
    
    /**
     * 插入角色与菜单对应关系
     * 
     * @param roleRMenu 角色与菜单关系
     */
    public void insertRoleRMenu(RoleRMenuVO roleRMenu);
    
    /**
     * 批量插入角色与菜单对应关系
     * 
     * @param roleRMenus 角色与菜单关系集合
     */
    public void batchInsertRoleRMenu(List<RoleRMenuVO> roleRMenus);
    
    /**
     * 删除角色与菜单对应关系
     * 
     * @param condition 查询条件
     */
    public void deleteRoleRMenu(@Param("condition") Condition condition);
    
    /**
     * 插入角色与操作对应关系
     * 
     * @param roleROperationVO 操作与角色关系
     */
    public void insertRoleROperation(RoleROperationVO roleROperationVO);
    
    /**
     * 批量插入角色与操作对应关系
     * 
     * @param roleROperationVOs 操作与角色关系集合
     */
    public void batchInsertRoleROperation(List<RoleROperationVO> roleROperationVOs);
    
    /**
     * 删除操作与角色对应关系
     * 
     * @param condition 查询条件
     */
    public void deleteRoleROperation(@Param("condition") Condition condition);
}
