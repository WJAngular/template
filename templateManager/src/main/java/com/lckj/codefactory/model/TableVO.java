
package com.lckj.codefactory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: TableVO 
* @Description: 数据表实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:13:36 
*
 */
public class TableVO {
    
    /** 英文名称 **/
    private String name;
    
    /** 表注释 **/
    private String comment;
    
    /** 首字母大写的java名称 **/
    private String firstUpperName;
    
    /** 首字母小写的java名称 **/
    private String firstLowerName;
    
    /** 小写名称 **/
    private String lowerName;
    
    /** 带路径的名称 **/
    private String filePath;
    
    /** 代码包路径 */
    private String packagePath;
    
    /** 主键字段-暂定只支持单主键的情况 */
    private ColumnVO pkColumn = new ColumnVO();
    
    /** 非主键字段集合 */
    private List<ColumnVO> otherColumn = new ArrayList<ColumnVO>();
    
    /** 所有字段的集合 */
    private List<ColumnVO> allColumn = new ArrayList<ColumnVO>();
    
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * @return firstUpperName
     */
    public String getFirstUpperName() {
        return firstUpperName;
    }
    
    /**
     * @param firstUpperName firstUpperName
     */
    public void setFirstUpperName(String firstUpperName) {
        this.firstUpperName = firstUpperName;
    }
    
    /**
     * @return firstLowerName
     */
    public String getFirstLowerName() {
        return firstLowerName;
    }
    
    /**
     * @param firstLowerName firstLowerName
     */
    public void setFirstLowerName(String firstLowerName) {
        this.firstLowerName = firstLowerName;
    }
    
    /**
     * @return lowerName
     */
    public String getLowerName() {
        return lowerName;
    }
    
    /**
     * @param lowerName lowerName
     */
    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }
    
    /**
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * @param filePath filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * @return packagePath
     */
    public String getPackagePath() {
        return packagePath;
    }
    
    /**
     * @param packagePath packagePath
     */
    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
    
    /**
     * @return pkColumn
     */
    public ColumnVO getPkColumn() {
        return pkColumn;
    }
    
    /**
     * @param pkColumn pkColumn
     */
    public void setPkColumn(ColumnVO pkColumn) {
        this.pkColumn = pkColumn;
    }
    
    /**
     * @return otherColumn
     */
    public List<ColumnVO> getOtherColumn() {
        return otherColumn;
    }
    
    /**
     * @param otherColumn otherColumn
     */
    public void setOtherColumn(List<ColumnVO> otherColumn) {
        this.otherColumn = otherColumn;
    }
    
    /**
     * @return allColumn
     */
    public List<ColumnVO> getAllColumn() {
        return allColumn;
    }
    
    /**
     * @param allColumn allColumn
     */
    public void setAllColumn(List<ColumnVO> allColumn) {
        this.allColumn = allColumn;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("TableVO[");
        sb.append("\n    name=").append(this.name);
        sb.append("\n    comment=").append(this.comment);
        sb.append("\n    firstUpperName=").append(this.firstUpperName);
        sb.append("\n    firstLowerName=").append(this.firstLowerName);
        sb.append("\n    lowerName=").append(this.lowerName);
        sb.append("\n    filePath=").append(this.filePath);
        sb.append("\n    packagePath=").append(this.packagePath);
        sb.append("\n    pkColumn=").append(this.pkColumn);
        sb.append("\n    otherColumn=").append(this.otherColumn);
        sb.append("\n    allColumn=").append(this.allColumn);
        sb.append("\n]");
        return sb.toString();
    }
    
}
