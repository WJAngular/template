
package com.lckj.dictionary.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.dictionary.model.DictionaryItemVO;

/**
 * 
* @ClassName: DictionaryItemMapper 
* @Description: 字典明细持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:26:59 
*
 */
@Repository
public interface DictionaryItemMapper extends MybatisMapper<DictionaryItemVO> {
    
    /**
     * 查询所有字典明细信息
     * 
     * @return 字典明细
     */
    public List<DictionaryItemVO> queryAllItem();
}
