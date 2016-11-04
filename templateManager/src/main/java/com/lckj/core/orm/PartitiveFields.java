
package com.lckj.core.orm;

import java.util.HashMap;
import java.util.Map;

import com.lckj.core.orm.util.NameConverter;

/**
 * 
* @ClassName: PartitiveFields 
* @Description: 字段属性操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:25:08 
*
 */
public class PartitiveFields extends HashMap<String, Object> {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 3865131202288816404L;
    
    /**
     * 编译插入字段集合
     * 
     * @param fields 字段集合
     */
    public void prepareInsertSql() {
        if (this.get("_insertFields") == null) {
            
            StringBuffer sbInsertFields = new StringBuffer();
            StringBuffer sbInsertValues = new StringBuffer();
            boolean firstFiled = true;
            for (Map.Entry<String, Object> entry : this.entrySet()) {
                String key = entry.getKey();
                if (!firstFiled) {
                    sbInsertFields.append(" , ");
                    sbInsertValues.append(" , ");
                }
                sbInsertFields.append(NameConverter.propertyToColumn(key));
                
                sbInsertValues.append("#{fields[");
                sbInsertValues.append(key);
                sbInsertValues.append("]}");
                
                firstFiled = false;
            }
            this.put("_insertFields", sbInsertFields.toString());
            this.put("_insertValues", sbInsertValues.toString());
        }
    }
    
    /**
     * 编译修改字段集合
     * 
     * @param fields 字段集合
     */
    public void prepareUpdateSql() {
        if (this.get("_updateSql") == null) {
            StringBuffer sbUpdateSql = new StringBuffer();
            boolean firstFiled = true;
            for (Map.Entry<String, Object> entry : this.entrySet()) {
                String key = entry.getKey();
                if (!firstFiled) {
                    sbUpdateSql.append(" , ");
                }
                if (key.endsWith("+=")) {
                    String column = NameConverter.propertyToColumn(key.replaceAll("\\+=", ""));
                    if (Double.valueOf(String.valueOf(entry.getValue())) > 0) {
                        sbUpdateSql.append(column + "=" + column + "+" + entry.getValue());
                    } else {
                        sbUpdateSql.append(column + "=" + column + entry.getValue());
                    }
                } else {
                    sbUpdateSql.append(NameConverter.propertyToColumn(key));
                    sbUpdateSql.append(" = #{fields[");
                    sbUpdateSql.append(key);
                    sbUpdateSql.append("]}");
                }
                firstFiled = false;
            }
            this.put("_updateSql", sbUpdateSql.toString());
        }
    }
    
    /**
     * 根据键值获取字段值
     * 
     * @param key 字段对应的键值
     * @return 字段值
     */
    public int getIntValueByKey(String key) {
        if (this.get(key) == null) {
            return 0;
        } else {
            return Integer.parseInt(this.get(key).toString());
        }
    }
}
