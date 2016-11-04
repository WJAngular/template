
package com.lckj.core.orm.util;

/**
 * 
* @ClassName: NameConverter 
* @Description: 字段名称转换器 
* @author: WUJING 
* @date :2016-06-10 上午11:24:30 
*
 */
public class NameConverter {
    
    /**
     * java属性转换成数据库字段
     * 
     * @param property java属性
     * @return 数据库字段
     */
    public static String propertyToColumn(String property) {
        if (null == property) {
            return "";
        }
        char[] chars = property.toCharArray();
        StringBuffer field = new StringBuffer();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                field.append("_");
            }
            field.append(Character.toLowerCase(c));
        }
        return field.toString().toLowerCase();
    }
    
    /**
     * 数据库字段转换成java属性转
     * 
     * @param column 数据库字段
     * @return java属性
     */
    public static String columnToProperty(String column) {
        String[] words = column.toLowerCase().split("_");
        StringBuffer property = new StringBuffer();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                property.append(word);
            } else {
                property.append(Character.toUpperCase(word.charAt(0)));
                property.append(word.substring(1));
            }
        }
        return property.toString();
    }
    
    /**
     * java属性转数据库字符串（带表前缀）
     * 
     * @param property java属性
     * @return 数据库字段
     */
    public static String propertyToColumnWithTableAlias(String property) {
        String tableAlias = "";
        String strProperty = "";
        if (property.indexOf(".") != -1) {
            String[] parts = property.split("[.]");
            tableAlias = parts[0].toLowerCase() + ".";
            strProperty = parts[1];
        } else {
            strProperty = property;
        }
        
        return " " + tableAlias + NameConverter.propertyToColumn(strProperty) + " ";
    }
    
}
