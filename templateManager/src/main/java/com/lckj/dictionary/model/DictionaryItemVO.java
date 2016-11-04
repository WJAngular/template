
package com.lckj.dictionary.model;

import com.lckj.base.model.MessageInfo;

/**
 * 
* @ClassName: DictionaryItemVO 
* @Description: 字典明细实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:27:38 
*
 */
public class DictionaryItemVO extends MessageInfo {
    
    /** 字典明细ID **/
    private Integer itemId;
    
    /** 字典类别ID **/
    private Integer dictionaryId;
    
    /** 字典类别编码 **/
    private String dictionaryCode;
    
    /** 字典类别名称 **/
    private String dictionaryName;
    
    /** 字典明细名称 **/
    private String itemName;
    
    /** 字典明细值 **/
    private Integer itemValue;
    
    /** 字典明细排序 **/
    private Integer itemSort;
    
    /**
     * 获取字典明细ID
     * 
     * @return 字典明细ID
     */
    public Integer getItemId() {
        return itemId;
    }
    
    /**
     * 设值字典明细ID
     * 
     * @param itemId 字典明细ID
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    
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
     * 获取字典明细名称
     * 
     * @return 字典明细名称
     */
    public String getItemName() {
        return itemName;
    }
    
    /**
     * 设值字典明细名称
     * 
     * @param itemName 字典明细名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    /**
     * 获取字典明细值
     * 
     * @return 字典明细值
     */
    public Integer getItemValue() {
        return itemValue;
    }
    
    /**
     * 设值字典明细值
     * 
     * @param itemValue 字典明细值
     */
    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }
    
    /**
     * 获取字典明细排序
     * 
     * @return 字典明细排序
     */
    public Integer getItemSort() {
        return itemSort;
    }
    
    /**
     * 设值字典明细排序
     * 
     * @param itemSort 字典明细排序
     */
    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
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
     * @return dictionaryName
     */
    public String getDictionaryName() {
        return dictionaryName;
    }
    
    /**
     * @param dictionaryName dictionaryName
     */
    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("DictionaryItemVO[");
        sb.append(super.toString());
        sb.append("\n    itemId=").append(this.itemId);
        sb.append("\n    dictionaryId=").append(this.dictionaryId);
        sb.append("\n    dictionaryCode=").append(this.dictionaryCode);
        sb.append("\n    dictionaryName=").append(this.dictionaryName);
        sb.append("\n    itemName=").append(this.itemName);
        sb.append("\n    itemValue=").append(this.itemValue);
        sb.append("\n    itemSort=").append(this.itemSort);
        sb.append("\n]");
        return sb.toString();
    }
}
