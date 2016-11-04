
package com.lckj.security.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lckj.base.BaseConstant;
import com.lckj.base.systeminit.AppCache;
import com.lckj.base.util.Md5Util;
import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;
import com.lckj.security.role.model.RoleVO;
import com.lckj.security.role.service.RoleService;
import com.lckj.security.user.mapper.UserMapper;
import com.lckj.security.user.model.UserRRoleVO;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: UserService 
* @Description:  用户信息业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:33:07 
*
 */
@Service
public class UserService extends AbstractService<UserVO> {
    
    /** 用户持久化处理接口 */
    @Autowired
    UserMapper userMapper;
    
    /** 角色持久化处理接口 */
    @Autowired
    RoleService roleService;
    
    @Override
    protected MybatisMapper<UserVO> getMapper() {
        return this.userMapper;
    }
    
    /**
     * 检查登陆用户信息
     * 
     * @param userVO 用户信息
     * @return 用户信息
     */
    public UserVO getLoginUser(UserVO userVO) {
        UserVO result = null;
        Map<String, String> param = new HashMap<String, String>();
        param.put("account", userVO.getAccount());
        param.put("password", Md5Util.hash(userVO.getPassword()));
        List<UserVO> userVOs = userMapper.getLoginUser(param);
        if (userVOs.size() > 0) {
            result = userVOs.get(0);
            // result.setPassword(userVO.getPassword());
            if (result.getOwnerId() != null && result.getOwnerId() > 0) {
                SimpleCondition condition = new SimpleCondition();
                condition.andEqual("t.ownerId", result.getOwnerId());
            }
        }
        return result;
    }
    
    
    /**
     * 查询用户角色关系
     * 
     * @param userVO 用户信息
     * @return 用户map集合
     */
    public Map<String, Object> queryUserMappingRole(UserVO userVO) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 查询用户对应的角色
        SimpleCondition conditionUser = new SimpleCondition();
        conditionUser.andEqual("userId", userVO.getUserId());
        conditionUser.andEqual("status", BaseConstant.STATUS_ENABLE);
        result.put("current", roleService.queryRoleByUser(conditionUser));
        
        // 查询所有启用的角色（包含角色级别过滤）
        Map<String, Integer> conditionRole = new HashMap<String, Integer>();
        Subject currentUser = SecurityUtils.getSubject();
        UserVO user = (UserVO) currentUser.getPrincipal();
        conditionRole.put("userId", user.getUserId());
        result.put("all", roleService.roleList(conditionRole));
        return result;
    }
    
    /**
     * 根据角色ID查询对应的用户信息
     * 
     * @param roleId 角色Id
     * @return 用户map集合
     */
    public List<UserVO> queryUserByRoleId(int roleId) {
        SimpleCondition conditionRole = new SimpleCondition();
        conditionRole.andEqual("roleId", roleId);
        conditionRole.andEqual("status", BaseConstant.STATUS_ENABLE);
        return userMapper.queryUserByRole(conditionRole);
    }
    
    /**
     * 根据角色ID查询对应的用户Id集合
     * 
     * @param roleId 角色Id
     * @param depCode 组织code
     * @return 用户map集合
     */
    public Map<Integer, Integer> queryUserIdByRoleId(int roleId, String depCode) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        SimpleCondition conditionRole = new SimpleCondition();
        conditionRole.andEqual("roleId", roleId);
        conditionRole.andBeginWith("deptCode", depCode);
        conditionRole.andEqual("status", BaseConstant.STATUS_ENABLE);
        List<UserVO> users = userMapper.queryUserByRole(conditionRole);
        if (users != null && users.size() > 0) {
            for (UserVO userVO : users) {
                result.put(userVO.getUserId(), userVO.getUserId());
            }
        }
        return result;
    }
    
    /**
     * 添加用户角色关系
     * 
     * @param userVO 用户信息
     * @return 添加用户角色关系的数量
     */
    public int insertUserMappingRole(UserVO userVO) {
        int result = 0;
        String roleIds = userVO.getRoleId();
        if (roleIds.endsWith(";")) {
            roleIds = roleIds.substring(0, roleIds.length() - 1);
        }
        
        // 删除此用户对应的权限关系
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("userId", userVO.getUserId());
        roleService.deleteUserRRole(condition);
        
        if (roleIds.length() > 0) {
            // 循环插入用户权限关系
            List<UserRRoleVO> userRRoleVOs = new ArrayList<UserRRoleVO>();
            for (String roleId : roleIds.split(";")) {
                userRRoleVOs.add(new UserRRoleVO(userVO.getUserId(), Integer.parseInt(roleId)));
            }
            roleService.batchInsertUserRRole(userRRoleVOs);
            result = userRRoleVOs.size();
        }
        return result;
    }
    
    /**
     * 判断是否有操作权限
     * 
     * @param condition 查询条件
     * @return 是否有操作权限
     */
    public boolean hasPermission(Map<String, String> condition) {
        List<String> permissions = userMapper.hasPermission(condition);
        return !CollectionUtils.isEmpty(permissions);
    }
    
    /**
     * 修改用户信息
     * 
     * @param userVO 用户信息
     */
    public void updateUser(UserVO userVO) {
        userMapper.update(userVO);
    }
    
    /**
     * 获取数据查看中对应的用户数量
     * 
     * @param condition 查询条件
     * @return 用户集合
     */
    public int videoUserCount(Condition condition) {
        return userMapper.videoUserCount(condition);
    }
    
    /**
     * 获取数据查看中对应的用户信息
     * 
     * @param condition 查询条件
     * @param rowBounds 分页对象
     * @return 用户集合
     */
    public List<UserVO> videoUserList(Condition condition, RowBounds rowBounds) {
        return userMapper.videoUserList(condition, rowBounds);
    }
    
    /**
     * <pre>
     * 1、删除用户权限信息
     * 2、删除用户信息
     * </pre>
     * 
     * @param userId 用户id
     */
    public void deleteUserAndRelation(int userId) {
        SimpleCondition roleCondition = new SimpleCondition();
        roleCondition.andEqual("userId", userId);
        roleService.deleteUserRRole(roleCondition);
        userMapper.delete(userId);
    }
    
    /**
     * 查询excel导出记录
     * 
     * @param condition 查询条件
     * @return 视频记录清单
     */
    public List<UserVO> exportList(Condition condition) {
        return userMapper.exportList(condition);
    }
    
    /**
     * 根据用户ID获取对应的角色类别
     * 
     * @param userId 用户编码
     * @return 角色类型
     */
    public int getRoleTypeByUserId(int userId) {
        Map<String, RoleVO> roles = roleService.queryRoleByUserId(userId);
        if (roles.get(AppCache.getConfigMap().get("ownerRoleName")) != null) {
            return 1;
        } else {
            return 2;
        }
    }
    
    /**
     * 根据用户ID获取对应的角色类别
     * 
     * @param userId 用户编码
     * @param roleName 角色名称
     * @return 角色类型
     */
    public boolean isRoleByUserId(int userId, String roleName) {
        Map<String, RoleVO> roles = roleService.queryRoleByUserId(userId);
        if (roles.get(roleName) != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
