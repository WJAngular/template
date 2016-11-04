
package com.lckj.base.systeminit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.lckj.config.model.ConfigVO;
import com.lckj.dictionary.model.DictionaryItemVO;

/**
 * 
* @ClassName: AppCache 
* @Description: 应用缓存 
* @author: WUJING 
* @date :2016-06-10 上午11:04:42 
*
 */
@Controller
public class AppCache {
    
    /** 日志对象 */
    private static final Logger logger = Logger.getLogger(AppCache.class);
    
    /** 字典表缓存 */
    private static Map<String, List<DictionaryItemVO>> dictMap = new HashMap<String, List<DictionaryItemVO>>();
    
    /** 配置项缓存 */
    private static Map<String, String> configMap = new HashMap<String, String>();
    
    /** 系统参数缓存 */
    private static Map<String, String> systemParmMap = new HashMap<String, String>();
    
    /** 构造函数 */
    public AppCache() {
    }
    
    /** 初始化加载缓存数据 */
    public void init() {
    }
    
    /**
     * 初始化数据字典到内存中
     * 
     * @param dictList 字典集合
     */
    public static void initDict(final List<DictionaryItemVO> dictList) {
        AppCache.logger.info("初始化数据字典到内存中");
        dictMap = new HashMap<String, List<DictionaryItemVO>>();
        if (dictList != null && dictList.size() > 0) {
            for (final DictionaryItemVO dictionaryVO : dictList) {
                List<DictionaryItemVO> tempList = AppCache.dictMap.get(dictionaryVO.getDictionaryCode());
                if (tempList == null) {
                    tempList = new ArrayList<DictionaryItemVO>();
                    AppCache.dictMap.put(dictionaryVO.getDictionaryCode(), tempList);
                }
                tempList.add(dictionaryVO);
            }
        }
    }
    
    /**
     * 初始化配置项内存中
     * 
     * @param configList 配置项集合
     */
    public static void initConfig(final List<ConfigVO> configList) {
        AppCache.logger.info("初始化配置项到内存中");
        configMap = new HashMap<String, String>();
        if (configList != null && configList.size() > 0) {
            for (final ConfigVO configVO : configList) {
                AppCache.configMap.put(configVO.getCode(), configVO.getValue());
            }
        }
    }
    
    /**
     * 获取字典名称
     * 
     * @param type 字典类型
     * @param val 字典值
     * @return 字典名称
     */
    public static String getDictName(final String type, final String val) {
        final List<DictionaryItemVO> temp = AppCache.dictMap.get(type);
        for (final DictionaryItemVO item : temp) {
            if (val.equals(String.valueOf(item.getItemValue()))) {
                return item.getItemName();
            }
        }
        return null;
    }
    
    /**
     * 获取字典明细
     * 
     * @param type 字典类型
     * @return 字典明细集合
     */
    public static List<DictionaryItemVO> getDictItemsByTypeId(final String type) {
        return AppCache.dictMap.get(type);
    }
    
    /**
     * 获取字典明细集合
     * 
     * @return 字典明细集合
     */
    public static Map<String, List<DictionaryItemVO>> getDictMap() {
        return dictMap;
    }
    
    /**
     * 获取配置项集合
     * 
     * @return 字典明细集合
     */
    public static Map<String, String> getConfigMap() {
        return configMap;
    }
    
    /**
     * 根据配置项名称获取配置项值
     * 
     * @param name 配置项名称
     * @return 字典明细集合
     */
    public static String getConfigValue(String name) {
        return configMap.get(name);
    }
    
    /**
     * 设值字典明细集合
     * 
     * @param dictMap 字典明细集合
     */
    public static void setDictMap(Map<String, List<DictionaryItemVO>> dictMap) {
        AppCache.dictMap = dictMap;
    }
    
    /**
     * 获取系统参数集合
     * 
     * @return 系统参数集合
     */
    public static Map<String, String> getSystemParmMap() {
        return systemParmMap;
    }
    
    /**
     * 设值系统参数集合
     * 
     * @param systemParmMap 系统参数集合
     */
    public static void setSystemParmMap(Map<String, String> systemParmMap) {
        AppCache.systemParmMap = systemParmMap;
    }
}
