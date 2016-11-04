
package com.lckj.security.organization.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.security.organization.model.OrganizationVO;

/**
 * 
* @ClassName: OrganizationMapper 
* @Description: 组织结构信息持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:30:04 
*
 */
@Repository
public interface OrganizationMapper extends MybatisMapper<OrganizationVO> {
    
    /**
     * 查询组织与用户列表
     * 
     * @param condition 查询条件
     * @return 记录集合
     */
    List<OrganizationVO> userTreeList(@Param("condition") Condition condition);
    
    /**
     * 修改相关冗余表的组织编码及组织名称
     * 
     * @param param 查询条件
     */
    void updateOrganizationRelation(Map<String, Object> param);
}
