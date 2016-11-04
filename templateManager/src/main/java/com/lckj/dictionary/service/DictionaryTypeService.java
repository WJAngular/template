
package com.lckj.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;
import com.lckj.dictionary.mapper.DictionaryItemMapper;
import com.lckj.dictionary.mapper.DictionaryTypeMapper;
import com.lckj.dictionary.model.DictionaryTypeVO;

/**
 * 
* @ClassName: DictionaryTypeService 
* @Description: 字典类别业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:28:04 
*
 */
@Service
public class DictionaryTypeService extends AbstractService<DictionaryTypeVO> {
    
    /** 字典类别持久化处理接口 */
    @Autowired
    DictionaryTypeMapper dictionaryTypeMapper;
    
    /** 字典明细持久化处理接口 */
    @Autowired
    DictionaryItemMapper dictionaryItemMapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<DictionaryTypeVO> getMapper() {
        return this.dictionaryTypeMapper;
    }
    
    /**
     * 删除字典类型记录，并删除对应的字典明细记录
     * 
     * @param idList 字典类型id集合
     */
    @Transactional
    public void deleteBatch(Integer[] idList) {
        for (Integer id : idList) {
            // 删除字典明细
            SimpleCondition condition = new SimpleCondition();
            condition.andEqual("dictionaryId", id);
            dictionaryItemMapper.deleteBatch(condition);
            
            // 删除字典类型
            this.delete(id);
        }
    }
}
