
package com.lckj.dictionary.model;

import com.lckj.base.model.MessageInfo;

/**
 * 
* @ClassName: DictionaryTypeVO 
* @Description: 字典类别实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:27:46 
*
 */
public class DictionaryTypeVO extends MessageInfo {
    
    /** 字典类别ID **/
    private Integer dictionaryId;
    
    /** 字典类别编码 **/
    private String dictionaryCode;
    
    /** 字典类别名称 **/
    private String dictionaryName;
    
    /**
     * 获取字典类别ID
     * 
     * @return 字典类别ID
     */
    public Integer getDictionaryId() {
        return dictionaryId;
    }
    
    /**
     * 设值字典类别ID
     * 
     * @param dictionaryId 字典类别ID
     */
    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }
    
    /**
     * 获取字典类别编码
     * 
     * @return 字典类别编码
     */
    public String getDictionaryCode() {
        return dictionaryCode;
    }
    
    /**
     * 设值字典类别编码
     * 
     * @param dictionaryCode 字典类别编码
     */
    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }
    
    /**
     * 获取字典类别名称
     * 
     * @return 字典类别名称
     */
    public String getDictionaryName() {
        return dictionaryName;
    }
    
    /**
     * 设值字典类别名称
     * 
     * @param dictionaryName 字典类别名称
     */
    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("DictionaryTypeVO[");
        sb.append(super.toString());
        sb.append("\n    dictionaryId=").append(this.dictionaryId);
        sb.append("\n    dictionaryCode=").append(this.dictionaryCode);
        sb.append("\n    dictionaryName=").append(this.dictionaryName);
        sb.append("\n]");
        return sb.toString();
    }
}
