
package com.lckj.codefactory.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lckj.codefactory.model.TableVO;
import com.lckj.codefactory.model.TemplateVO;

/**
 * 
* @ClassName: CodeFactoryUtil 
* @Description:  代码生成工具工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:14:14 
*
 */
public class CodeFactoryUtil {
    
    /** jdbc类型集合 */
    private static Map<String, String> dataBaseToJdbc = new HashMap<String, String>();
    
    /** java类型集合 */
    private static Map<String, String> dataBaseToJava = new HashMap<String, String>();
    
    /** 初始化java、jdbc、db 中的数据类型映射关系 */
    static {
        dataBaseToJava.put("VARCHAR", "String");
        dataBaseToJdbc.put("VARCHAR", "VARCHAR");
        dataBaseToJava.put("VARCHAR2", "String");
        dataBaseToJdbc.put("VARCHAR2", "VARCHAR");
        dataBaseToJava.put("NUMBER", "Integer");
        dataBaseToJdbc.put("NUMBER", "NUMERIC");
        dataBaseToJava.put("TEXT", "String");
        dataBaseToJdbc.put("TEXT", "VARCHAR");
        dataBaseToJava.put("INT", "Integer");
        dataBaseToJdbc.put("INT", "INTEGER");
        dataBaseToJava.put("DATE", "Date");
        dataBaseToJdbc.put("DATE", "TIMESTAMP");
        dataBaseToJava.put("TIMESTAMP", "Date");
        dataBaseToJdbc.put("TIMESTAMP", "TIMESTAMP");
        dataBaseToJava.put("DATETIME", "Date");
        dataBaseToJdbc.put("DATETIME", "TIMESTAMP");
        dataBaseToJava.put("TINYINT", "Integer");
        dataBaseToJdbc.put("TINYINT", "TINYINT");
        dataBaseToJava.put("DECIMAL", "BigDecimal");
        dataBaseToJdbc.put("DECIMAL", "DECIMAL");
    }
    
    /**
     * 将数据库类型的参数转换成驼峰命名的方式 （如：USER_NAME-->UserName）
     * 
     * @param columnName 字段名称
     * @return 首字母大写的字段名称
     */
    public static String getBigCamelCase(String columnName) {
        StringBuffer sbParam = new StringBuffer();
        if (StringUtils.isNotBlank(columnName)) {
            String[] params = columnName.toUpperCase().split("_");
            for (String param : params) {
                sbParam.append(param.substring(0, 1)).append(param.substring(1).toLowerCase());
            }
        }
        return sbParam.toString();
    }
    
    /**
     * 将数据库类型的参数转换成驼峰命名的方式（如：USER_NAME-->userName）
     * 
     * @param columnName 字段名称
     * @return 驼峰格式的字段名称
     */
    public static String getSmallCamelCase(String columnName) {
        StringBuffer sbParam = new StringBuffer();
        if (StringUtils.isNotBlank(columnName)) {
            String[] params = columnName.toUpperCase().split("_");
            sbParam.append(params[0].toLowerCase());
            for (int i = 1; i < params.length; i++) {
                sbParam.append(params[i].substring(0, 1)).append(params[i].substring(1).toLowerCase());
                
            }
        }
        return sbParam.toString();
    }
    
    /**
     * 将所有字母转换成小写格式
     * 
     * @param dbparam 名称
     * @return 所有单词首字母小写的名称
     */
    public static String getLowerName(String dbparam) {
        return dbparam.replaceAll("_", "").toLowerCase();
    }
    
    /**
     * 将首字母转换成大写格式
     * 
     * @param name 名称
     * @return 首字母大写的名称
     */
    public static String firstLetterUpper(String name) {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * 将首字母转换成小写格式
     * 
     * @param name 名称
     * @return 首字母小写的名称
     */
    public static String firstLetterLower(String name) {
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * 将数据库中的字段转换成属性
     * 
     * @param column 字段
     * @return 属性
     */
    public static String getAttributeNameByColumn(String column) {
        String result = "";
        String strColumn = column.toLowerCase();
        String[] words = strColumn.split("_");
        result += words[0];
        for (int i = 1; i < words.length; i++) {
            result += firstLetterUpper(words[i]);
        }
        return result;
    }
    
    /**
     * 将数据库类型转换成java类型
     * 
     * @param databaseType 数据库类型
     * @return java类型
     */
    public static String getJavaTypeByDBType(String databaseType) {
        String type = databaseType.contains("(") ? databaseType.split("\\(")[0] : databaseType;
        String javaType = dataBaseToJava.get(type.toUpperCase());
        return javaType == null ? "java.lang.String" : javaType;
    }
    
    /**
     * 将数据库类型转换成jdbc类型
     * 
     * @param databaseType 数据库类型
     * @return jdbc类型
     */
    public static String getJdbcTypeByDBType(String databaseType) {
        String type = databaseType.contains("(") ? databaseType.split("\\(")[0] : databaseType;
        String jdbcType = dataBaseToJdbc.get(type.toUpperCase());
        return jdbcType == null ? "VARCHAR" : jdbcType;
    }
    
    /**
     * 生成文件目录
     * 
     * @param table 表信息
     * @param modelName 模块信息
     * @param codeTemplate 模板信息
     * @return 文件目录
     */
    public static String generateFolder(TableVO table, String modelName, TemplateVO codeTemplate) {
        String folderPath = table.getFilePath().replace(".", "/").replaceAll("//", "/");// + "/" + targetPacketPath.replace(".", "/");
        if (codeTemplate.getSuffix().endsWith(".jsp") || codeTemplate.getSuffix().endsWith(".js")) {
            folderPath = folderPath.split("main")[0] + "/main/webapp/";
        } else {
            folderPath = folderPath.endsWith("/") ? folderPath : folderPath + "/";
        }
        
        // 组装模块名称
        folderPath += getModelName(modelName, table.getLowerName());
        // 组装框架结构名称：如：model、service
        folderPath += codeTemplate.getFloderName() + "/";
        
        File folder = new File(folderPath);
        folder.mkdirs();
        folderPath = folderPath.endsWith("/") ? folderPath : folderPath + "/";
        return folderPath;
    }
    
    /**
     * 组装包路径信息
     * 
     * @param filePath 文件路径
     * @param modelName 模块名称
     * @param tableName 表名称
     * @return 包路径
     */
    public static String getPackagePath(String filePath, String modelName, String tableName) {
        String result = filePath.substring(filePath.indexOf("/com/") + 1).replaceAll("/", ".");
        result = result.endsWith(".") ? result + getModelName(modelName, tableName) : result + "." + getModelName(modelName, tableName);
        return result;
    }
    
    /**
     * 获取模块路径，如有有定义模块则使用模块路径，否则使用表名小写
     * 
     * @param modelName 模块名称
     * @param tableName 小写表名称
     * @return 模块名称
     */
    public static String getModelName(String modelName, String tableName) {
        return "".equals(modelName) ? tableName : modelName;
    }
    
    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        // String str1 = "<tr>";
        // String str3 = "</tr>";
        // String str2 = "<td width='15%' align='right'>${column.comment}</td>";
        // String str4 = "<td align='right'>普通</td>";
        // String str5 = "<td align='right'>日期</td>";
        // String str6 = "<td align='right'>大文本</td>";
        //
        // for (int i = 0; i < 10; i++) {
        // System.out.println(str1);
        // if (i < 2) {
        // System.out.println(str2);
        // } else {
        // if (i == 5) {
        // System.out.println(str5);
        // } else if (i == 8) {
        // System.out.println(str6);
        // } else {
        // System.out.println(str4);
        // }
        // }
        // System.out.println(str3);
        //
        // }
        
        // String str = "D:\\FWMS\\code\\trunk\\客户端工具\\qcms\\src\\main\\java\\com\\comtop\\qcms";
        // System.out.println(str.split("main")[0] + "main/webapp/content/");
        //
        // System.out.println("varchar(0)".split("\\(")[0]);
        // System.out.println(CodeUtil.firstLetterLower("haha_hehe_hehe_hehe"));
        // System.out.println(CodeUtil.firstLetterLower("HAHA_HEHE_HEHE_HEHE"));
        //
        // System.out.println(CodeUtil.getBigCamelCase("haha_hehe_hehe_hehe"));
        // System.out.println(CodeUtil.getBigCamelCase("HAHA_HEHE_HEHE_HEHE"));
        //
        // System.out.println(CodeUtil.getSmallCamelCase("haha_hehe_hehe_hehe"));
        // System.out.println(CodeUtil.getSmallCamelCase("HAHA_HEHE_HEHE_HEHE"));
    }
}
