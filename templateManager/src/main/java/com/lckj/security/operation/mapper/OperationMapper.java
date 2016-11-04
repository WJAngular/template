
package com.lckj.security.operation.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.security.operation.model.OperationVO;
import com.lckj.security.role.model.RoleVO;

/**
 * 
* @ClassName: OperationMapper 
* @Description: 操作持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:13 
*
 */
@Repository
public interface OperationMapper extends MybatisMapper<OperationVO> {
    
    /**
     * 根据角色查询对应的操作授权信息
     * 
     * @param role 角色信息
     * @return 操作授权集合
     */
    public List<OperationVO> queryRolePermissions(RoleVO role);
    
    /**
     * 根据角色查询对应的操作授权信息
     * 
     * @param role 角色信息
     * @return 操作授权集合
     */
    public List<OperationVO> queryPermissions(RoleVO role);
    
    /**
     * 查询所有菜单及操作清单
     * 
     * @return 菜单及操作集合
     */
    public List<OperationVO> queryMenuOpration();
}
