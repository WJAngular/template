
package com.lckj.config.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.base.model.PagerVO;
import com.lckj.base.systeminit.AppCache;
import com.lckj.config.model.ConfigVO;
import com.lckj.config.service.ConfigService;
import com.lckj.core.orm.condition.SimpleCondition;

/**
 * 
* @ClassName: ConfigController 
* @Description: 配置管理控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:14:45 
*
 */
@Controller
public class ConfigController {
    
    /** 注入配置管理业务操作类 */
    @Autowired
    ConfigService configService;
    
    /**
     * 查询配置管理
     * 
     * @param configVO 配置管理
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 配置管理列表
     */
    @RequestMapping("/config/list.do")
    @ResponseBody
    public PagerVO configList(ConfigVO configVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.andLike("name", configVO.getName());
            condition.orderDesc("configId");
            pagerVO.setTotalRows(configService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(configService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取配置管理
     * 
     * @param configVO 配置管理
     * @param model 数据模型
     * @return 配置管理
     */
    @RequestMapping("/config/read.do")
    @ResponseBody
    public ConfigVO read(ConfigVO configVO, Model model) {
        try {
            return configService.read(configVO.getConfigId());
        } catch (Exception ex) {
            configVO.setErrorCode();
        }
        return configVO;
    }
    
    /**
     * 新增配置管理
     * 
     * @param configVO 配置管理
     * @param model 数据模型
     * @return 配置管理
     */
    @RequestMapping("/config/add.do")
    @ResponseBody
    public ConfigVO add(ConfigVO configVO, Model model) {
        try {
            configService.insert(configVO);
            this.initConfig();
        } catch (Exception ex) {
            configVO.setErrorCode();
        }
        return configVO;
    }
    
    /**
     * 修改配置管理
     * 
     * @param configVO 配置管理
     * @param model 数据模型
     * @return 配置管理
     */
    @RequestMapping("/config/update.do")
    @ResponseBody
    public ConfigVO update(ConfigVO configVO, Model model) {
        try {
            configService.update(configVO);
            this.initConfig();
        } catch (Exception ex) {
            configVO.setErrorCode();
        }
        return configVO;
    }
    
    /**
     * 删除配置管理
     * 
     * @param configVO 配置管理
     * @param model 数据模型
     * @return 配置管理
     */
    @RequestMapping("/config/delete.do")
    @ResponseBody
    public ConfigVO delete(ConfigVO configVO, Model model) {
        try {
            configService.delete(configVO.getConfigId());
            this.initConfig();
        } catch (Exception ex) {
            configVO.setErrorCode();
        }
        return configVO;
    }
    
    /**
     * 初始化配置项到缓存
     */
    private void initConfig() {
        SimpleCondition condition = new SimpleCondition();
        AppCache.initConfig(configService.list(condition));
    }
}
