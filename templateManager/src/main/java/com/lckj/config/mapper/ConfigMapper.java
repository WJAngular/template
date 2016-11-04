package com.lckj.config.mapper;

import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.config.model.ConfigVO;

/**
 * 
* @ClassName: ConfigMapper 
* @Description: 配置管理持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:14:56 
*
 */
@Repository
public interface ConfigMapper extends MybatisMapper<ConfigVO> {
}
