
package com.lckj.base.systeminit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lckj.config.service.ConfigService;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.dictionary.service.DictionaryItemService;

/**
 * 系统启动和销毁的支撑类
 * 
 * @author 黄洪波
 * @since 1.0
 * @version 2012-11-6 黄洪波
 */
@Component
public class SystemMgr {
    
    /** 注入字典服务类 */
    @Resource
    DictionaryItemService dictionaryItemService;
    
    /** 注入配置项服务类 */
    @Resource
    ConfigService configService;
    
    /** 交易系统初始化加载的配置或者初始化的数据 */
    @PostConstruct
    public void init() {
        initCfgs();
        initDict();
        initConfig();
    }
    
    /**
     * 销毁系统级别的资源
     */
    @PreDestroy
    public void destroy() {
    }
    
    /**
     * 初始化的系统配置
     */
    private void initCfgs() {
    }
    
    /**
     * 初始化数据字典数据
     */
    public void initDict() {
        AppCache.initDict(dictionaryItemService.queryAllItem());
    }
    
    /**
     * 初始化配置项数据
     */
    public void initConfig() {
        SimpleCondition condition = new SimpleCondition();
        AppCache.initConfig(configService.list(condition));
    }
}
