
package com.lckj.security.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.service.AbstractService;
import com.lckj.security.operation.mapper.OperationMapper;
import com.lckj.security.operation.model.OperationVO;

/**
 * 
* @ClassName: OperationService 
* @Description:  操作业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:41 
*
 */
@Service
public class OperationService extends AbstractService<OperationVO> {
    
    /** 操作持久化处理接口 */
    @Autowired
    OperationMapper operationmapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<OperationVO> getMapper() {
        return this.operationmapper;
    }
    
    /**
     * 查询所有菜单及操作清单
     * 
     * @return 菜单及操作集合
     */
    public List<OperationVO> queryMenuOpration() {
        return operationmapper.queryMenuOpration();
    }
}
