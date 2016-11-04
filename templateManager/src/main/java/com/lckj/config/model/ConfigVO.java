
package com.lckj.config.model;

import com.lckj.base.model.PagerParam;

/**
 * 
* @ClassName: ConfigVO 
* @Description: 配置管理实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:16:30 
*
 */
public class ConfigVO extends PagerParam {
    
    /** 配置项ID **/
    private Integer configId;
    
    /** 配置项键 **/
    private String code;
    
    /** 配置项名 **/
    private String name;
    
    /** 配置项值 **/
    private String value;
    
    /** 排序 **/
    private Integer sortNo;
    
    /** 配置描述 **/
    private String description;
    
    /**
     * 获取配置项ID
     * 
     * @return 配置项ID
     */
    public Integer getConfigId() {
        return configId;
    }
    
    /**
     * 设值配置项ID
     * 
     * @param configId 配置项ID
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }
    
    /**
     * 获取配置项键
     * 
     * @return 配置项键
     */
    public String getCode() {
        return code;
    }
    
    /**
     * 设值配置项键
     * 
     * @param code 配置项键
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * 获取配置项名
     * 
     * @return 配置项名
     */
    public String getName() {
        return name;
    }
    
    /**
     * 设值配置项名
     * 
     * @param name 配置项名
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取配置项值
     * 
     * @return 配置项值
     */
    public String getValue() {
        return value;
    }
    
    /**
     * 设值配置项值
     * 
     * @param value 配置项值
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * 获取排序
     * 
     * @return 排序
     */
    public Integer getSortNo() {
        return sortNo;
    }
    
    /**
     * 设值排序
     * 
     * @param sortNo 排序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
    
    /**
     * 获取配置描述
     * 
     * @return 配置描述
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * 设值配置描述
     * 
     * @param description 配置描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("ConfigVO[");
        sb.append(super.toString());
        sb.append("\n    configId=").append(this.configId);
        sb.append("\n    code=").append(this.code);
        sb.append("\n    name=").append(this.name);
        sb.append("\n    value=").append(this.value);
        sb.append("\n    sortNo=").append(this.sortNo);
        sb.append("\n    description=").append(this.description);
        sb.append("\n]");
        return sb.toString();
    }
}
