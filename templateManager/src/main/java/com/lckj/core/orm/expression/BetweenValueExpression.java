
package com.lckj.core.orm.expression;

/**
 * 
* @ClassName: BetweenValueExpression 
* @Description: 区间值类型的条件表达式 
* @author: WUJING 
* @date :2016-06-10 上午11:20:31 
*
 */
public class BetweenValueExpression extends SqlCompareExpressionImpl {
    
    /**
     * 构造函数
     * 
     * @param prefix 前缀
     * @param column 字段名
     * @param beginValue 起始值
     * @param endValue 结束值
     * @param suffix 后缀
     */
    public BetweenValueExpression(String prefix, String column, Object beginValue, Object endValue, String suffix) {
        super(prefix, column, " BETWEEN ", suffix);
        this.beginValue = beginValue;
        this.endValue = endValue;
    }
    
    /** 条件起始值 */
    private Object beginValue;
    
    /** 条件结束值 */
    private Object endValue;
    
    /**
     * 获取条件起始值
     * 
     * @return 条件起始值
     */
    public Object getBeginValue() {
        return beginValue;
    }
    
    /**
     * 设值条件起始值
     * 
     * @param beginValue 条件起始值
     */
    public void setBeginValue(Object beginValue) {
        this.beginValue = beginValue;
    }
    
    /**
     * 获取条件结束值
     * 
     * @return 条件结束值
     */
    public Object getEndValue() {
        return endValue;
    }
    
    /**
     * 设值条件结束值
     * 
     * @param endValue 条件结束值
     */
    public void setEndValue(Object endValue) {
        this.endValue = endValue;
    }
    
    @Override
    public String getExpression(int indexInCondition) {
        StringBuffer expression = new StringBuffer(128);
        expression.append(this.prefix);
        expression.append(this.column);
        expression.append(this.compareSymbol);
        expression.append(" #{condition.expressions[");
        expression.append(indexInCondition);
        expression.append("].beginValue} AND #{condition.expressions[");
        expression.append(indexInCondition);
        expression.append("].endValue} ");
        expression.append(this.suffix);
        return expression.toString();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append(this.prefix).append(this.column).append(this.compareSymbol).append(this.beginValue);
        sb.append(" AND ").append(this.endValue).append(this.suffix).append("\n");
        return sb.toString();
    }
    
}
