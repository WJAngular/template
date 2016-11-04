
package com.lckj.codefactory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: GenerateVO 
* @Description: 生成工具实体类 
* @author: WUJING 
* @date :2016-06-10 上午11:13:24 
*
 */
public class GenerateVO {
    
    /** 数据库驱动 */
    private String driver;
    
    /** 数据库链接 */
    private String url;
    
    /** 用户名 */
    private String userName;
    
    /** 密码 */
    private String password;
    
    /** 表计划 */
    private String tableSchem;
    
    /** 待生成代码的表 */
    private String generateTable;
    
    /** 代码包路径 */
    private String filePath;
    
    /** 忽略表前缀 */
    private String ignoreTablePrefix;
    
    /** 过滤条件 */
    private String tablePrefix;
    
    /** 模块名称 */
    private String modelName;
    
    /** 模板 */
    private String codeTemplate;
    
    /** 作者 */
    private String author;
    
    /**
     * @return driver
     */
    public String getDriver() {
        return driver;
    }
    
    /**
     * @param driver driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return tableSchem
     */
    public String getTableSchem() {
        return tableSchem;
    }
    
    /**
     * @param tableSchem tableSchem
     */
    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }
    
    /**
     * @return generateTable
     */
    public String getGenerateTable() {
        return generateTable;
    }
    
    /**
     * @param generateTable generateTable
     */
    public void setGenerateTable(String generateTable) {
        this.generateTable = generateTable;
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
     * @return ignoreTablePrefix
     */
    public String getIgnoreTablePrefix() {
        return ignoreTablePrefix;
    }
    
    /**
     * @param ignoreTablePrefix ignoreTablePrefix
     */
    public void setIgnoreTablePrefix(String ignoreTablePrefix) {
        this.ignoreTablePrefix = ignoreTablePrefix;
    }
    
    /**
     * @return tablePrefix
     */
    public String getTablePrefix() {
        return tablePrefix;
    }
    
    /**
     * @param tablePrefix tablePrefix
     */
    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
    
    /**
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }
    
    /**
     * @param modelName modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    /**
     * @return codeTemplate
     */
    public String getCodeTemplate() {
        return codeTemplate;
    }
    
    /**
     * @param codeTemplate codeTemplate
     */
    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }
    
    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * @param author author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * 组装表名称信息
     * 
     * @return 表名称集合
     */
    public List<String> compareTableList() {
        if (generateTable.length() == 0) {
            return null;
        } else {
            generateTable = generateTable.substring(0, generateTable.length() - 1);
        }
        
        List<String> tableList = new ArrayList<String>();
        String[] tables = generateTable.split(";");
        for (int i = 0; i < tables.length; i++) {
            tableList.add(tables[i]);
        }
        return tableList;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("GenerateVO[");
        sb.append("\n    driver=").append(this.driver);
        sb.append("\n    url=").append(this.url);
        sb.append("\n    userName=").append(this.userName);
        sb.append("\n    password=").append(this.password);
        sb.append("\n    tableSchem=").append(this.tableSchem);
        sb.append("\n    generateTable=").append(this.generateTable);
        sb.append("\n    filePath=").append(this.filePath);
        sb.append("\n    ignoreTablePrefix=").append(this.ignoreTablePrefix);
        sb.append("\n    tablePrefix=").append(this.tablePrefix);
        sb.append("\n    modelName=").append(this.modelName);
        sb.append("\n    codeTemplate=").append(this.codeTemplate);
        sb.append("\n    author=").append(this.author);
        sb.append("\n]");
        return sb.toString();
    }
    
}
