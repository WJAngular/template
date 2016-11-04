package com.lckj.dictionary.mapper;

import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.dictionary.model.DictionaryTypeVO;

/**
 * 
* @ClassName: DictionaryTypeMapper 
* @Description:  字典类别持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:27:22 
*
 */
@Repository
public interface DictionaryTypeMapper extends MybatisMapper<DictionaryTypeVO> {
}
