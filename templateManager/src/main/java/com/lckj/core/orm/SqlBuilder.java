
package com.lckj.core.orm;

import java.util.Arrays;
import java.util.List;

import com.lckj.core.orm.expression.BetweenValueExpression;
import com.lckj.core.orm.expression.ListValueExpression;
import com.lckj.core.orm.expression.NoValueExpression;
import com.lckj.core.orm.expression.SingleValueExpression;
import com.lckj.core.orm.expression.SqlCompareExpression;
import com.lckj.core.orm.util.NameConverter;

/**
 * 
* @ClassName: SqlBuilder 
* @Description: SQL构建器 
* @author: WUJING 
* @date :2016-06-10 上午11:25:20 
*
 */
public class SqlBuilder {
    
    /** AND ( */
    public static final String AND_PT = " AND ( ";
    
    /** AND */
    public static final String AND = " AND ";
    
    /** OR ( */
    public static final String OR_PT = " OR ( ";
    
    /** OR */
    public static final String OR = " OR ";
    
    /** ) */
    public static final String END_PT = " ) ";
    
    /** )) */
    public static final String END_DOUBLE_PT = " )) ";
    
    /**
     * 组装单个值的查询条件
     * 
     * @param prefix 前缀
     * @param propertyName 字段名
     * @param compareSymbol 条件表达式
     * @param value 条件值
     * @param suffix 后缀
     * @return SQL表达式
     */
    public static SqlCompareExpression singleValue(String prefix, String propertyName, String compareSymbol, Object value, String suffix) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        return new SingleValueExpression(prefix, column, compareSymbol, value, suffix);
    }
    
    /**
     * 组装没有值的查询条件
     * 
     * @param prefix 前缀
     * @param propertyName 字段名
     * @param compareSymbol 条件表达式
     * @param suffix 后缀
     * @return SQL表达式
     */
    public static SqlCompareExpression noValue(String prefix, String propertyName, String compareSymbol, String suffix) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        return new NoValueExpression(prefix, column, compareSymbol, suffix);
    }
    
    /**
     * 组装范围的查询条件
     * 
     * @param prefix 前缀
     * @param propertyName 字段名
     * @param begin 开始值
     * @param end 结束值
     * @param compareSymbol 条件表达式
     * @param suffix 后缀
     * @return SQL表达式
     */
    public static SqlCompareExpression betweenValue(String prefix, String propertyName, Object begin, Object end, String suffix) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        return new BetweenValueExpression(prefix, column, begin, end, suffix);
    }
    
    /**
     * 组装列表的查询条件
     * 
     * @param prefix 前缀
     * @param propertyName 字段名
     * @param compareSymbol 条件表达式
     * @param value 字段值
     * @param suffix 后缀
     * @return SQL表达式
     */
    public static SqlCompareExpression listValue(String prefix, String propertyName, String compareSymbol, List<?> value, String suffix) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        return new ListValueExpression(prefix, column, compareSymbol, value, suffix);
    }
    
    /**
     * 组装列表的查询条件
     * 
     * @param prefix 前缀
     * @param propertyName 字段名
     * @param compareSymbol 条件表达式
     * @param values 字段值
     * @param suffix 后缀
     * @return SQL表达式
     */
    public static SqlCompareExpression listValue(String prefix, String propertyName, String compareSymbol, String values, String suffix) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        return new ListValueExpression(prefix, column, compareSymbol, Arrays.asList((Object[]) values.split(",")), suffix);
    }
    
}
