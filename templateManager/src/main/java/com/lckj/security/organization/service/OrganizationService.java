
package com.lckj.security.organization.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.Condition;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;
import com.lckj.security.organization.mapper.OrganizationMapper;
import com.lckj.security.organization.model.OrganizationVO;

/**
 * 
* @ClassName: OrganizationService 
* @Description: 组织结构信息业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:30:40 
*
 */
@Service
public class OrganizationService extends AbstractService<OrganizationVO> {
    
    /** 组织结构信息持久化处理接口 */
    @Autowired
    OrganizationMapper organizationmapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<OrganizationVO> getMapper() {
        return this.organizationmapper;
    }
    
    /**
     * 新增组织信息
     * 
     * <pre>
     * 1、新增组织信息
     * 2、将父组织修改非叶子节点
     * </pre>
     * 
     * @param organizationVO 组织信息
     */
    public void insertOrganization(OrganizationVO organizationVO) {
        organizationmapper.insert(organizationVO);
        changeLeafState(organizationVO.getParentId(), 2);
    }
    
    /**
     * 修改组织信息
     * 
     * <pre>
     * 1、修改组织信息
     * 2、修改组织相关冗余信息
     * </pre>
     * 
     * @param organizationVO 组织信息
     */
    public void updateOrganization(OrganizationVO organizationVO) {
        OrganizationVO oldOrganizationVO = organizationmapper.read(organizationVO.getId());
        organizationmapper.update(organizationVO);
        
        if (!organizationVO.getCode().equals(oldOrganizationVO.getCode()) || !organizationVO.getName().equals(oldOrganizationVO.getName())) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("orgId", organizationVO.getId());
            param.put("orgCode", organizationVO.getCode());
            param.put("orgName", organizationVO.getName());
            organizationmapper.updateOrganizationRelation(param);
        }
        
    }
    
    /**
     * 根据组织code查询组织ID
     * 
     * @param organizationVO 组织信息
     * @return 组织ID
     */
    public int getOrgIdByCode(OrganizationVO organizationVO) {
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("code", organizationVO.getCode());
        List<OrganizationVO> orgs = organizationmapper.list(condition);
        if (orgs != null && orgs.size() > 0) {
            return orgs.get(0).getId();
        } else {
            return 0;
        }
    }
    
    /**
     * 查询组织与用户列表
     * 
     * @param condition 查询条件
     * @return 记录集合
     */
    public List<OrganizationVO> userTreeList(@Param("condition") Condition condition) {
        return organizationmapper.userTreeList(condition);
    }
    
    /**
     * 删除组织信息
     * 
     * <pre>
     * 1、删除当前组织信息
     * 2、判断父组织是否还有子节点，如果没有则将父组织修改叶子节点
     * </pre>
     * 
     * @param organizationVO 组织信息
     */
    public void delete(OrganizationVO organizationVO) {
        SimpleCondition deleteCondition = new SimpleCondition();
        deleteCondition.andBeginWith("code", organizationVO.getCode());
        organizationmapper.deleteBatch(deleteCondition);
        
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("parentId", organizationVO.getParentId());
        int count = organizationmapper.count(condition);
        if (count == 0) {
            changeLeafState(organizationVO.getParentId(), 1);
        }
    }
    
    /**
     * 修改叶子节点标识
     * 
     * @param leafmark 待修改的叶子状态
     * @param id 待修改的节点ID
     */
    private void changeLeafState(int id, int leafmark) {
        PartitiveFields fields = new PartitiveFields();
        fields.put("leafMark", leafmark);
        fields.prepareUpdateSql();
        organizationmapper.updatePartitive(fields, id);
    }
}
