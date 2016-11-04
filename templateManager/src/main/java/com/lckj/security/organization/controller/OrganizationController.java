
package com.lckj.security.organization.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.orm.util.StringUtil;
import com.lckj.security.organization.model.OrganizationVO;
import com.lckj.security.organization.service.OrganizationService;
import com.lckj.security.user.model.UserVO;
import com.lckj.security.user.service.UserService;

/**
 * 
* @ClassName: OrganizationController 
* @Description: 组织结构信息控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:53 
*
 */
@Controller
public class OrganizationController {
    
    /** 注入组织结构信息业务操作类 */
    @Autowired
    OrganizationService organizationService;
    
    /** 注入用户业务操作类 */
    @Autowired
    UserService userService;
    
    /**
     * 查询组织结构树信息
     * 
     * @param organizationVO 查询参数
     * @return 查询结果
     */
    @RequestMapping("/organization/list.do")
    @ResponseBody
    public List<OrganizationVO> organizationList(OrganizationVO organizationVO) {
        SimpleCondition condition = new SimpleCondition();
        Integer id = organizationVO.getId();
        if (StringUtil.isNotBlank(organizationVO.getCode()) && !"undefined".equals(organizationVO.getCode()) && (id == null || id == 0)) {
            id = organizationService.getOrgIdByCode(organizationVO);
            condition.andEqual("id", id);
        } else {
            id = id == null ? 0 : id;
            condition.andEqual("parentId", id);
        }
        condition.orderAsc("sortNo");
        
        List<OrganizationVO> treeNodeList = organizationService.list(condition);
        return treeNodeList;
    }
    
    /**
     * 查询组织人员信息
     * 
     * @param organizationVO 查询参数
     * @return 查询结果
     */
    @RequestMapping("/organization/usertree/list.do")
    @ResponseBody
    public List<OrganizationVO> organizationUserList(OrganizationVO organizationVO) {
        SimpleCondition condition = new SimpleCondition();
        Integer id = organizationVO.getId();
        if (StringUtil.isNotBlank(organizationVO.getCode()) && !"undefined".equals(organizationVO.getCode()) && (id == null || id == 0)) {
            id = organizationService.getOrgIdByCode(organizationVO);
            condition.andEqual("id", id);
            condition.andEqual("status", 1);
        } else {
            id = id == null ? 0 : id;
            condition.andEqual("parentId", id);
        }
        // condition.andEqual("parentId", id);
        condition.orderAsc("sortNo");
        condition.orderDesc("userType");
        List<OrganizationVO> treeNodeList = organizationService.userTreeList(condition);
        return treeNodeList;
    }
    
    /**
     * 查询角色授权用户列表
     * 
     * @param organizationVO 查询参数
     * @return 查询结果
     */
    @RequestMapping("/organization/usertree/role/list.do")
    @ResponseBody
    public List<OrganizationVO> organizationRoleMappingUserList(OrganizationVO organizationVO) {
        SimpleCondition condition = new SimpleCondition();
        Integer id = organizationVO.getId();
        if (StringUtil.isNotBlank(organizationVO.getCode()) && !"undefined".equals(organizationVO.getCode()) && (id == null || id == 0)) {
            id = organizationService.getOrgIdByCode(organizationVO);
            condition.andEqual("id", id);
            condition.andNotEqual("userType", "2");
        } else {
            id = id == null ? 0 : id;
            condition.andEqual("parentId", id);
        }
        condition.orderAsc("sortNo");
        List<OrganizationVO> treeNodeList = organizationService.userTreeList(condition);
        Map<Integer, Integer> users = userService.queryUserIdByRoleId(organizationVO.getRoleId(), organizationVO.getCode());
        for (OrganizationVO org : treeNodeList) {
            if (org.getUserType() == 2 && users.get(org.getId()) != null) {
                org.setChecked(true);
            }
        }
        return treeNodeList;
    }
    
    /**
     * 根据人员ID查询组织信息
     * 
     * @param userId 用户ID
     * @return 组织信息
     */
    @RequestMapping("/organization/organizationInfo/userid.do")
    @ResponseBody
    public OrganizationVO organizationInfoByUserId(int userId) {
        UserVO user = userService.read(userId);
        return organizationService.read(user.getDeptId());
    }
    
    /**
     * 编辑组织结构信息
     * 
     * @param organizationVO 组织结构信息
     * @param model 数据模型
     * @return 组织结构信息
     */
    @RequestMapping("/organization/edit.do")
    @ResponseBody
    public OrganizationVO update(OrganizationVO organizationVO, Model model) {
        try {
            if (organizationVO.getId() > 0) {
                if (getRepeatCount(organizationVO) > 0) {
                    organizationVO.setErrorMessage("此组织编号已经存在，不能重复增加！");
                    return organizationVO;
                }
                organizationService.updateOrganization(organizationVO);
            } else {
                if (getRepeatCount(organizationVO) > 0) {
                    organizationVO.setErrorMessage("此组织编号已经存在，不能重复增加！");
                    return organizationVO;
                }
                organizationService.insertOrganization(organizationVO);
            }
        } catch (Exception ex) {
            organizationVO.setMessage("编制组织结构信息失败！");
        }
        return organizationVO;
    }
    
    /**
     * 删除组织结构信息
     * 
     * @param organizationVO 组织对象
     * @param model 数据模型
     * @return 删除的记录数
     */
    @RequestMapping("/organization/delete.do")
    @ResponseBody
    public OrganizationVO delete(OrganizationVO organizationVO, Model model) {
        try {
            organizationService.delete(organizationVO);
        } catch (Exception ex) {
            organizationVO.setErrorCode();
        }
        return organizationVO;
    }
    
    /**
     * 检查组织编号是否重复
     * 
     * @param organizationVO 组织信息
     * @param model 数据模型
     * @return 组织信息
     */
    @RequestMapping("/organization/checkRepeat.do")
    @ResponseBody
    public OrganizationVO checkRepeat(OrganizationVO organizationVO, Model model) {
        try {
            if (getRepeatCount(organizationVO) > 0) {
                organizationVO.setErrorMessage("此组织编号已经存在，不能重复增加！");
                return organizationVO;
            }
        } catch (Exception ex) {
            organizationVO.setErrorCode();
        }
        return organizationVO;
    }
    
    /**
     * 获取组织编号重复的数量
     * 
     * @param organizationVO 用户信息
     * @return 重复的数量
     */
    private int getRepeatCount(OrganizationVO organizationVO) {
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("code", organizationVO.getCode());
        condition.andNotEqualByParamGreaterZero("id", organizationVO.getId());
        return organizationService.count(condition);
    }
}
