
package com.lckj.security.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.security.user.model.UserRRoleVO;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: UserMapper 
* @Description:  用户信息持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:32:00 
*
 */
@Repository
public interface UserMapper extends MybatisMapper<UserVO> {
    
    /**
     * 新增用户角色对应关系
     * 
     * @param userRRoleVO 用户角色对应关系
     */
    public void insertUserRRole(UserRRoleVO userRRoleVO);
    
    /**
     * 批量新增用户与角色对应关系
     * 
     * @param userRRoleVOs 用户角色对应关系集合
     */
    public void batchInsertUserRRole(List<UserRRoleVO> userRRoleVOs);
    
    /**
     * 删除用户角色对应关系
     * 
     * @param condition 操作条件
     */
    public void deleteUserRRole(@Param("condition") Condition condition);
    
    /**
     * 根据角色查询用户信息
     * 
     * @param map 查询条件
     * @return 用户信息集合
     */
    public List<UserVO> getLoginUser(Map<String, String> map);
    
    
    /**
     * 根据角色查询用户信息
     * 
     * @param condition 查询条件
     * @return 用户信息集合
     */
    public List<UserVO> queryUserByRole(@Param("condition") Condition condition);
    
    /**
     * 判断用户是否具有操作权限
     * 
     * @param map 操作集合
     * @return 用户对应的操作集合
     */
    public List<String> hasPermission(Map<String, String> map);
    
    /**
     * 获取数据查看中对应的用户数量
     * 
     * @param condition 查询条件
     * @return 用户集合
     */
    public int videoUserCount(@Param("condition") Condition condition);
    
    /**
     * 获取数据查看中对应的用户信息
     * 
     * @param condition 查询条件
     * @param rowBounds 分页对象
     * @return 用户集合
     */
    public List<UserVO> videoUserList(@Param("condition") Condition condition, @Param("rowBounds") RowBounds rowBounds);
    
    /**
     * 查询excel导出记录
     * 
     * @param condition 查询条件
     * @return 用户记录清单
     */
    public List<UserVO> exportList(@Param("condition") Condition condition);
}
