
package com.lckj.codefactory.model;

/**
 * 
* @ClassName: TemplateVO 
* @Description: 模版实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:13:45 
*
 */
public class TemplateVO {
    
    /** 模板名称 */
    String templateFile = "";
    
    /** 模板路径 */
    String floderName = "";
    
    /** 前缀 */
    String prefix = "";
    
    /** 后缀 */
    String suffix = "";
    
    /**
     * @return templateFile
     */
    public String getTemplateFile() {
        return templateFile;
    }
    
    /**
     * @param templateFile templateFile
     */
    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }
    
    /**
     * @return floderName
     */
    public String getFloderName() {
        return floderName;
    }
    
    /**
     * @param floderName floderName
     */
    public void setFloderName(String floderName) {
        this.floderName = floderName;
    }
    
    /**
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }
    
    /**
     * @param prefix prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    /**
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }
    
    /**
     * @param suffix suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("TemplateVO[");
        sb.append("\n    templateFile=").append(this.templateFile);
        sb.append("\n    floderName=").append(this.floderName);
        sb.append("\n    prefix=").append(this.prefix);
        sb.append("\n    suffix=").append(this.suffix);
        sb.append("\n]");
        return sb.toString();
    }
}
