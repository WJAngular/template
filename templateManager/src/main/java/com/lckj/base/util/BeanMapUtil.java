
package com.lckj.base.util;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.SimpleCondition;

/**
 * 
* @ClassName: BeanMapUtil 
* @Description: 实体与map转换帮助类 
* @author: WUJING 
* @date :2016-06-10 上午11:06:49 
*
 */
public class BeanMapUtil {
    
    /** 日志参数 ***/
    public static Logger logger = Logger.getLogger(BeanMapUtil.class);
    
    /**
     * 实体转换成map对象（将对象中为null的字段排除）
     * 
     * @param Entity bean信息
     * @param dest map 信息
     * @return return 成功
     * @throws Exception 异常
     */
    public static PartitiveFields beanToMap(Object Entity) {
        PartitiveFields result = new PartitiveFields();
        try {
            Field[] fields = Entity.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                if (PropertyUtils.isReadable(Entity, name)) {
                    Object value = PropertyUtils.getSimpleProperty(Entity, name);
                    if (value == null || value == "") {
                        continue;
                    } else if (value instanceof Integer) {
                        if (Integer.parseInt(value.toString()) == 0) {
                            continue;
                        } else {
                            result.put(name, value);
                        }
                    } else if (value instanceof Float) {
                        if (Float.parseFloat(value.toString()) == 0.0) {
                            continue;
                        } else {
                            result.put(name, value);
                        }
                    } else {
                        result.put(name, value);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", ex);
        }
        return result;
    }
    
    /**
     * 实体转换成map对象（将对象中为null的字段排除）,排除部分字段
     * 
     * @param Entity bean信息
     * @param excludeFields 待排除的字段
     * @param dest map 信息
     * @return return 成功
     * @throws Exception 异常
     */
    public static PartitiveFields beanToMap(Object Entity, String excludeFields) {
        PartitiveFields result = new PartitiveFields();
        try {
            Field[] fields = Entity.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                // 如果对应的字段在排除的范围内，则排除并循环下一个
                if (excludeFields.indexOf("、" + name + "、") >= 0) {
                    continue;
                }
                if (PropertyUtils.isReadable(Entity, name)) {
                    Object value = PropertyUtils.getSimpleProperty(Entity, name);
                    if (value == null || value == "") {
                        continue;
                    } else if (value instanceof Integer) {
                        if (Integer.parseInt(value.toString()) == 0) {
                            continue;
                        } else {
                            result.put(name, value);
                        }
                    } else if (value instanceof Float) {
                        if (Float.parseFloat(value.toString()) == 0.0) {
                            continue;
                        } else {
                            result.put(name, value);
                        }
                    } else if (value instanceof List) {
                        continue;
                    } else {
                        result.put(name, value);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", ex);
        }
        return result;
    }
    
    /**
     * bean 转换为 condition
     * 
     * @param orig bean 对象
     * @param condition condition 对象
     * @return return
     * @throws Exception ex
     */
    public static boolean beanToCondition(Object orig, SimpleCondition condition) throws Exception {
        try {
            Field[] fields = orig.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                if (PropertyUtils.isReadable(orig, name)) {
                    Object value = PropertyUtils.getSimpleProperty(orig, name);
                    String vals = ObjectUtils.toString(value);
                    if (StringUtils.isBlank(vals)) {
                        continue;
                    }
                    if (value instanceof Integer) {
                        if (Integer.parseInt(value.toString()) == 0) {
                            continue;
                        }
                    }
                    if (value instanceof Float) {
                        if (Float.parseFloat(value.toString()) == 0.0) {
                            continue;
                        }
                    }
                    addQueryCondition(name, value, condition);
                    
                }
            }
            return true;
        } catch (Exception e) {
            throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
        }
    }
    
    /**
     * 新增查询条件
     * 
     * @param name name
     * @param valueObj value
     * @param condition condition
     */
    private static void addQueryCondition(String name, Object valueObj, SimpleCondition condition) {
        
        if (valueObj instanceof String) {
            String value = valueObj.toString();
            if (value != null && value.indexOf(",") >= 0) {
                condition.andIn(name, value);
            } else if (value.startsWith("%") && value.endsWith("%")) {
                value = value.replaceAll("%", "");
                condition.andLike(name, value);
            } else if (value.startsWith("%")) {
                value = value.replaceAll("%", "");
                condition.andEndWith(name, value);
            } else if (value.endsWith("%")) {
                value = value.replaceAll("%", "");
                condition.andBeginWith(name, value);
            } else {
                condition.andEqual(name, value);
            }
        } else if (valueObj instanceof Integer) {
            int value = Integer.parseInt(valueObj.toString());
            if (value != 0) {
                condition.andEqualByParamGreaterZero(name, value);
            }
        }
    }
    
    /**
     * 将request内容存入map
     * 
     * @param request request
     * @return map
     */
    public static Map<String, String> requestToMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }
    
}
