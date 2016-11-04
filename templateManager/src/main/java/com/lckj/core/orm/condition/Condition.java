
package com.lckj.core.orm.condition;

import java.util.ArrayList;
import java.util.List;

import com.lckj.core.orm.expression.OrderBy;
import com.lckj.core.orm.expression.SqlCompareExpression;

/**
 * 
* @ClassName: Condition 
* @Description: Condition 对象 
* @author: WUJING 
* @date :2016-06-10 上午11:17:13 
*
 */
public class Condition {
    
    /** expressions */
    private List<SqlCompareExpression> expressions = null;
    
    /** orderBy */
    private OrderBy orderBy = null;
    
    /**
     * 构造函数
     */
    public Condition() {
        
    }
    
    /**
     * 添加条件表达式
     * 
     * @param expression 条件表达式
     */
    public void addExpression(SqlCompareExpression expression) {
        if (expressions == null) {
            expressions = new ArrayList<SqlCompareExpression>();
        }
        expressions.add(expression);
    }
    
    /**
     * 根据条件表达式集合组装SQL字符串
     * 
     * @return sql字符串
     */
    public String getComboedExpressions() {
        StringBuffer sql = new StringBuffer();
        if (expressions != null) {
            if (expressions.size() > 0) {
                for (int i = 0, iSize = expressions.size(); i < iSize; i++) {
                    SqlCompareExpression expression = expressions.get(i);
                    sql.append(expression.getExpression(i));
                }
            }
        }
        
        return sql.toString();
    }
    
    /**
     * 拷贝条件表达式
     * 
     * @return 条件表达式
     */
    public Condition copy() {
        Condition conditionList = new Condition();
        conditionList.orderBy = this.orderBy.copy();
        conditionList.expressions = new ArrayList<SqlCompareExpression>();
        for (SqlCompareExpression expression : this.expressions) {
            conditionList.expressions.add(expression);// fleet copy
        }
        return conditionList;
    }
    
    /**
     * 添加排序条件
     * 
     * @param propertiesNames 实体属性
     * @param direction 排序方式
     */
    public void order(String propertiesNames, String direction) {
        if (OrderBy.DESC.trim().equals(direction)) {
            this.orderDesc(propertiesNames);
        } else {
            this.orderAsc(propertiesNames);
        }
    }
    
    /**
     * 添加顺序排序条件
     * 
     * @param propertiesNames 实体属性
     */
    public void orderAsc(String propertiesNames) {
        if (this.orderBy == null) {
            this.orderBy = new OrderBy();
        }
        orderBy.orderAsc(propertiesNames);
    }
    
    /**
     * 添加倒序排序条件
     * 
     * @param propertiesNames 实体属性
     */
    public void orderDesc(String propertiesNames) {
        if (this.orderBy == null) {
            this.orderBy = new OrderBy();
        }
        orderBy.orderDesc(propertiesNames);
    }
    
    /**
     * 获取排序对象
     * 
     * @return 排序对象
     */
    public OrderBy getOrderBy() {
        return orderBy;
    }
    
    /**
     * 获取条件表达式集合
     * 
     * @return 条件表达式集合
     */
    public List<SqlCompareExpression> getExpressions() {
        return expressions;
    }
}
