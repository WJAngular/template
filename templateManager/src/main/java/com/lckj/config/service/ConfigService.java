
package com.lckj.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.config.mapper.ConfigMapper;
import com.lckj.config.model.ConfigVO;
import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;

/**
 * 
* @ClassName: ConfigService 
* @Description:  配置管理业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:16:46 
*
 */
@Service
public class ConfigService extends AbstractService<ConfigVO> {
    
    /** 配置管理持久化处理接口 */
    @Autowired
    ConfigMapper configmapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<ConfigVO> getMapper() {
        return this.configmapper;
    }
    
    /**
     * 配置项值
     * 
     * @param configKey 配置项主键
     * @return 配置项值
     */
    public String getConfigValueByKey(String configKey) {
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("configKey", configKey);
        List<ConfigVO> configs = configmapper.list(condition);
        if (configs == null || configs.size() == 0) {
            return "";
        } else {
            return configs.get(0).getValue();
        }
    }
}
