
package com.lckj.codefactory.model;

/**
 * 
* @ClassName: ColumnVO 
* @Description: 字段实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:13:15 
*
 */
public class ColumnVO {
    
    /** 字段名称 */
    private String name;
    
    /** java属性名称 */
    private String javaName;
    
    /** java属性名称-首字母大写 */
    private String firstUpperName;
    
    /** 字段注释 */
    private String comment;
    
    /** 字段类别 */
    private String type;
    
    /** 列对应的java类型 */
    private String javaType;
    
    /** 列对应的java类型 */
    private String jdbcType;
    
    /** 字段长度 */
    private int size;
    
    /** 是否主键 */
    private boolean isPk;
    
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
     * @return javaName
     */
    public String getJavaName() {
        return javaName;
    }
    
    /**
     * @param javaName javaName
     */
    public void setJavaName(String javaName) {
        this.javaName = javaName;
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
     * @return type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return javaType
     */
    public String getJavaType() {
        return javaType;
    }
    
    /**
     * @param javaType javaType
     */
    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
    
    /**
     * @return jdbcType
     */
    public String getJdbcType() {
        return jdbcType;
    }
    
    /**
     * @param jdbcType jdbcType
     */
    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }
    
    /**
     * @return size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * @param size size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * @return isPk
     */
    public boolean getIsPk() {
        return isPk;
    }
    
    /**
     * @param isPk isPk
     */
    public void setIsPk(boolean isPk) {
        this.isPk = isPk;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("ColumnVO[");
        sb.append("\n    name=").append(this.name);
        sb.append("\n    javaName=").append(this.javaName);
        sb.append("\n    firstUpperName=").append(this.firstUpperName);
        sb.append("\n    comment=").append(this.comment);
        sb.append("\n    type=").append(this.type);
        sb.append("\n    javaType=").append(this.javaType);
        sb.append("\n    jdbcType=").append(this.jdbcType);
        sb.append("\n    size=").append(this.size);
        sb.append("\n    isPk=").append(this.isPk);
        sb.append("\n]");
        return sb.toString();
    }
    
}
