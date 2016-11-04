
package com.lckj.security.role.controller;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.base.model.PagerVO;
import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.security.role.model.RoleVO;
import com.lckj.security.role.service.RoleService;

/**
 * 
* @ClassName: RoleController 
* @Description: 角色控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:30:51 
*
 */
@Controller
public class RoleController {
    
    /** 注入角色业务操作类 */
    @Autowired
    RoleService roleService;
    
    /**
     * 查询角色
     * 
     * @param roleVO 角色对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 角色对象
     */
    @RequestMapping("/role/list.do")
    @ResponseBody
    public PagerVO roleList(RoleVO roleVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.orderAsc("roleLevel");
            condition.andLike("roleName", roleVO.getRoleName());
            pagerVO.setTotalRows(roleService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(roleService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取角色
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色对象
     */
    @RequestMapping("/role/read.do")
    @ResponseBody
    public RoleVO read(RoleVO roleVO, Model model) {
        try {
            return roleService.read(roleVO.getRoleId());
        } catch (Exception ex) {
            roleVO.setErrorCode();
        }
        return roleVO;
    }
    
    /**
     * 新增角色
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色对象
     */
    @RequestMapping("/role/add.do")
    @ResponseBody
    public RoleVO add(RoleVO roleVO, Model model) {
        try {
            roleService.insert(roleVO);
        } catch (Exception ex) {
            roleVO.setErrorCode();
        }
        return roleVO;
    }
    
    /**
     * 修改角色
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色对象
     */
    @RequestMapping("/role/update.do")
    @ResponseBody
    public RoleVO update(RoleVO roleVO, Model model) {
        try {
            roleService.update(roleVO);
        } catch (Exception ex) {
            roleVO.setErrorCode();
        }
        return roleVO;
    }
    
    /**
     * 修改角色状态信息
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色对象
     */
    @RequestMapping("/role/changestate.do")
    @ResponseBody
    public RoleVO changeState(RoleVO roleVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("status", roleVO.getStatus());
            roleService.updatePartitive(fields, roleVO.getRoleId());
        } catch (Exception ex) {
            roleVO.setErrorCode();
        }
        return roleVO;
    }
    
    /**
     * 删除角色
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 删除记录数
     */
    @RequestMapping("/role/delete.do")
    @ResponseBody
    public RoleVO delete(RoleVO roleVO, Model model) {
        try {
            roleService.delete(roleVO.getRoleId());
        } catch (Exception ex) {
            roleVO.setErrorCode();
        }
        return roleVO;
    }
    
    /**
     * 查询角色对应的菜单
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色菜单对应关系
     */
    @RequestMapping("/role/query/menu.do")
    @ResponseBody
    public Map<String, Object> queryMenuMappingRole(RoleVO roleVO, Model model) {
        return roleService.queryRoleMappingMenu(roleVO);
    }
    
    /**
     * 给角色授权菜单
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 授权的菜单数
     */
    @RequestMapping("/role/mapping/menu.do")
    @ResponseBody
    public int roleMappingMenu(RoleVO roleVO, Model model) {
        return roleService.insertRoleMappingMenu(roleVO);
    }
    
    /**
     * 查询角色对应的用户
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 角色对应的用户
     */
    @RequestMapping("/role/query/user.do")
    @ResponseBody
    public Map<String, Object> queryUserMappingRole(RoleVO roleVO, Model model) {
        return roleService.queryUserMappingRole(roleVO);
    }
    
    /**
     * 给角色授权用户
     * 
     * @param roleVO 角色对象
     * @param model 数据模型
     * @return 授权的用户数
     */
    @RequestMapping("/role/mapping/user.do")
    @ResponseBody
    public int roleMappinguser(RoleVO roleVO, Model model) {
        return roleService.insertRoleMappingUser(roleVO);
    }
}
