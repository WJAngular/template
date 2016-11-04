
package com.lckj.core.orm.condition;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.lckj.base.util.DateUtil;
import com.lckj.core.orm.SqlBuilder;
import com.lckj.core.orm.expression.BetweenValueExpression;
import com.lckj.core.orm.expression.ListValueExpression;
import com.lckj.core.orm.expression.NoValueExpression;
import com.lckj.core.orm.expression.SingleValueExpression;
import com.lckj.core.orm.expression.SqlCompareExpression;
import com.lckj.core.orm.util.NameConverter;
import com.lckj.core.orm.util.StringUtil;

/**
 * 
* @ClassName: SimpleCondition 
* @Description: 简单条件表达式对象 
* @author: WUJING 
* @date :2016-06-10 上午11:17:30 
*
 */
public class SimpleCondition extends Condition {
    
    /**
     * 添加不为空条件表达式
     * 
     * @param propertyName 实体属性
     */
    public void andIsNotNull(String propertyName) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        SqlCompareExpression expression = new NoValueExpression(SqlBuilder.AND, column, " IS NOT NULL ", "");
        this.addExpression(expression);
    }
    
    /**
     * 添加为空条件表达式
     * 
     * @param propertyName 实体属性
     */
    public void andIsNull(String propertyName) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        SqlCompareExpression expression = new NoValueExpression(SqlBuilder.AND, column, " IS NULL ", "");
        this.addExpression(expression);
    }
    
    /**
     * 添加对象类型相等条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andEqual(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " = ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型相等条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andEqual(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " = ", value.trim(), "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型相等条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andEqualByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " = ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型相等条件表达式
     * 
     * @param propertyName 实体属性
     * @param propertyName1 实体属性
     * @param value 属性值
     */
    public void andOrEqualByParamGreaterZero(String propertyName, String propertyName1, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            String column1 = NameConverter.propertyToColumnWithTableAlias(propertyName1);
            this.addExpression(new SingleValueExpression(SqlBuilder.AND_PT, column, " = ", value, ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.OR, column1, " = ", value, SqlBuilder.END_PT));
        }
    }
    
    /**
     * 添加时间字符串表达式（带有格式化 date_format(makerTime, '%Y-%m-%d')）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andDateEqual(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String[] format = propertyName.split(",");
            String column = NameConverter.propertyToColumnWithTableAlias(format[0]) + "," + format[1];
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " = ", value.trim(), "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型like条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andLike(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " LIKE ", "%" + value.trim() + "%", "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型notlike条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNotLike(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " NOT LIKE ", "%" + value.trim() + "%", "");
            this.addExpression(expression);
        }
        
    }
    
    /**
     * 添加以某个字符串开头的条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andBeginWith(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " LIKE ", value.trim() + "%", "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加以某个字符串结尾的条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andEndWith(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " LIKE ", "%" + value.trim(), "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对类型的不相等条件表达式
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNotEqual(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " <> ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加整数型的不相等条件表达式（已判断属性值大于0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNotEqualByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " <> ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对象类型的大于等于条件表达式（已判断属性值不为null）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andGreater(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " > ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加整数类型的大于等于条件表达式（已判断属性值大于0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andGreaterByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " > ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对象类型的小于等于条件表达式（已判断属性值不为null）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNoLess(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " >= ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加整数类型的小于等于条件表达式（已判断属性值不为0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNoLessByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " >= ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对象类型的小于条件表达式（已判断属性值不为null）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andLess(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " < ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加整数类型的小于条件表达式（已判断属性值不为0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andLessByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " < ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对象类型的大于条件表达式（已判断属性值不为null）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNoGreater(String propertyName, Object value) {
        if (value != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " <= ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加整数类型的大于条件表达式（已判断属性值大于0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNoGreaterByParamGreaterZero(String propertyName, Integer value) {
        if (value != null && value > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new SingleValueExpression(SqlBuilder.AND, column, " <= ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加对象在某个区间的条件表达式（已判断起始和结束值不为null）
     * 
     * @param propertyName 实体属性
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andBetween(String propertyName, Object beginValue, Object endValue) {
        if (beginValue != null && endValue != null) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new BetweenValueExpression(SqlBuilder.AND, column, beginValue, endValue, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加日期范围查询条件
     * 
     * @param propertyName 实体属性
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andDateRange(String propertyName, String beginValue, String endValue) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        if (StringUtil.isNotBlank(beginValue)) {
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " >= ", DateUtil.parseDate(beginValue), ""));
        }
        if (StringUtil.isNotBlank(endValue)) {
            Date endDate = endValue.length() > 10 ? DateUtil.parseDate(endValue) : DateUtil.addDate(DateUtil.parseDate(endValue), 1);
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " <= ", endDate, ""));
        }
    }
    
    /**
     * 添加时间范围查询条件
     * 
     * @param propertyName 实体属性
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andDateTimeRange(String propertyName, String beginValue, String endValue) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        if (StringUtil.isNotBlank(beginValue)) {
            Date startDate = beginValue.length() > 10 ? DateUtil.parseDateTime(beginValue) : DateUtil.parseDateTime(beginValue + " 00:00:01");
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " >= ", startDate, ""));
        }
        if (StringUtil.isNotBlank(endValue)) {
            Date endDate = endValue.length() > 10 ? DateUtil.parseDateTime(endValue) : DateUtil.parseDateTime(endValue + " 23:59:59");
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " <= ", endDate, ""));
        }
    }
    
    /**
     * 添加时间范围查询条件(包含时间字段为null的值)
     * 
     * @param propertyName 实体属性
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andDateRangeContainNull(String propertyName, String beginValue, String endValue) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        if (StringUtil.isNotBlank(beginValue) && StringUtil.isNotBlank(endValue)) {
            Date endDate = endValue.length() > 10 ? DateUtil.parseDate(endValue) : DateUtil.addDate(DateUtil.parseDate(endValue), 1);
            this.addExpression(new SingleValueExpression(SqlBuilder.AND_PT, column, " >= ", DateUtil.parseDate(beginValue), ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " <= ", endDate, ""));
            this.addExpression(new NoValueExpression(SqlBuilder.OR, column, " IS NULL ", SqlBuilder.END_PT));
        } else if (StringUtil.isNotBlank(beginValue)) {
            this.addExpression(new SingleValueExpression(SqlBuilder.AND_PT, column, " >= ", DateUtil.parseDate(beginValue), ""));
            this.addExpression(new NoValueExpression(SqlBuilder.OR, column, " IS NULL ", SqlBuilder.END_PT));
        } else if (StringUtil.isNotBlank(endValue)) {
            Date endDate = endValue.length() > 10 ? DateUtil.parseDate(endValue) : DateUtil.addDate(DateUtil.parseDate(endValue), 1);
            this.addExpression(new SingleValueExpression(SqlBuilder.AND_PT, column, " <= ", endDate, ""));
            this.addExpression(new NoValueExpression(SqlBuilder.OR, column, " IS NULL ", SqlBuilder.END_PT));
        }
    }
    
    /**
     * 添加时间范围查询条件(包含时间字段为null的值)
     * 
     * @param startProperty 开始时间字段
     * @param endProperty 开始时间字段
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andDateRange(String startProperty, String endProperty, String beginValue, String endValue) {
        String startCloumn = NameConverter.propertyToColumnWithTableAlias(startProperty);
        String endCloumn = NameConverter.propertyToColumnWithTableAlias(endProperty);
        if (StringUtil.isNotBlank(beginValue) && StringUtil.isNotBlank(endValue)) {
            Date beginDate = beginValue.length() > 10 ? DateUtil.parseDateTime(beginValue) : DateUtil.parseDateTime(beginValue + " 00:00:01");
            Date endDate = endValue.length() > 10 ? DateUtil.parseDateTime(endValue) : DateUtil.parseDateTime(endValue + " 23:23:59");
            this.addExpression(new SingleValueExpression(" AND ((", startCloumn, " <= ", beginDate, ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, endCloumn, " >= ", beginDate, SqlBuilder.END_PT));
            this.addExpression(new SingleValueExpression(SqlBuilder.OR_PT, startCloumn, " <= ", endDate, ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, endCloumn, " >= ", endDate, SqlBuilder.END_PT));
            this.addExpression(new SingleValueExpression(SqlBuilder.OR_PT, startCloumn, " >= ", beginDate, ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, endCloumn, " <= ", endDate, SqlBuilder.END_PT));
            this.addExpression(new SingleValueExpression(SqlBuilder.OR_PT, startCloumn, " <= ", beginDate, ""));
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, endCloumn, " >= ", endDate, " ))"));
        } else if (StringUtil.isNotBlank(beginValue)) {
            Date beginDate = beginValue.length() > 10 ? DateUtil.parseDateTime(beginValue) : DateUtil.parseDateTime(beginValue + " 00:00:01");
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, endCloumn, " >= ", beginDate, ""));
        } else if (StringUtil.isNotBlank(endValue)) {
            Date endDate = endValue.length() > 10 ? DateUtil.parseDateTime(endValue) : DateUtil.parseDateTime(endValue + " 23:23:59");
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, startCloumn, " <= ", endDate, ""));
        }
    }
    
    /**
     * 添加整数在某个区间的条件表达式（已判断起始和结束值大于0）
     * 
     * @param propertyName 实体属性
     * @param beginValue 起始值
     * @param endValue 结束值
     */
    public void andBetweenByParamGreaterZero(String propertyName, Integer beginValue, Integer endValue) {
        String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
        if (beginValue != null && beginValue > 0 && endValue != null && endValue > 0) {
            SqlCompareExpression expression = new BetweenValueExpression(SqlBuilder.AND, column, beginValue, endValue, "");
            this.addExpression(expression);
        } else if (beginValue != null && beginValue > 0) {
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " >= ", beginValue, ""));
        } else if (endValue != null && endValue > 0) {
            this.addExpression(new SingleValueExpression(SqlBuilder.AND, column, " <= ", endValue, ""));
        }
    }
    
    /**
     * 添加List类型的in条件表达式（已判断List不为null，且List的长度大于0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andIn(String propertyName, List<Object> value) {
        if (value != null && value.size() > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new ListValueExpression(SqlBuilder.AND, column, " IN ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型的in条件表达式（已判断字符串不为空）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andIn(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new ListValueExpression(SqlBuilder.AND, column, " IN ", Arrays.asList((Object[]) value.trim()
                .split(",")), "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加List类型的not in条件表达式（已判断List不为null，且List的长度大于0）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNotIn(String propertyName, List<Object> value) {
        if (value != null && value.size() > 0) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new ListValueExpression(SqlBuilder.AND, column, " NOT IN ", value, "");
            this.addExpression(expression);
        }
    }
    
    /**
     * 添加字符串类型的not in条件表达式（已判断字符串不为空）
     * 
     * @param propertyName 实体属性
     * @param value 属性值
     */
    public void andNotIn(String propertyName, String value) {
        if (StringUtil.isNotBlank(value)) {
            String column = NameConverter.propertyToColumnWithTableAlias(propertyName);
            SqlCompareExpression expression = new ListValueExpression(SqlBuilder.AND, column, " NOT IN ", Arrays.asList((Object[]) value.trim()
                .split(",")), "");
            this.addExpression(expression);
        }
    }
}
