
package com.lckj.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.service.AbstractService;
import com.lckj.dictionary.mapper.DictionaryItemMapper;
import com.lckj.dictionary.model.DictionaryItemVO;

/**
 * 
* @ClassName: DictionaryItemService 
* @Description: 字典明细业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:27:55 
*
 */
@Service
public class DictionaryItemService extends AbstractService<DictionaryItemVO> {
    
    /** 字典明细持久化处理接口 */
    @Autowired
    DictionaryItemMapper mapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<DictionaryItemVO> getMapper() {
        return this.mapper;
    }
    
    /**
     * 查询所有字典明细记录
     * 
     * @return 字典明细记录集合
     */
    public List<DictionaryItemVO> queryAllItem() {
        return mapper.queryAllItem();
    }
}
