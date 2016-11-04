
package com.lckj.core.orm.expression;

/**
 * 
* @ClassName: SingleValueExpression 
* @Description: 单个条件过滤表达式 
* @author: WUJING 
* @date :2016-06-10 上午11:22:32 
*
 */
public class SingleValueExpression extends SqlCompareExpressionImpl {
    
    /**
     * 构造函数
     * 
     * @param prefix 前缀
     * @param column 字段名
     * @param compareSymbol 条件表达式
     * @param value 条件值
     * @param suffix 后缀
     */
    public SingleValueExpression(String prefix, String column, String compareSymbol, Object value, String suffix) {
        super(prefix, column, compareSymbol, suffix);
        this.value = value;
    }
    
    /** 过滤条件值 */
    private Object value;
    
    /**
     * 获取过滤条件值
     * 
     * @return 过滤条件值
     */
    public Object getValue() {
        return value;
    }
    
    /**
     * 设值过滤条件值
     * 
     * @param value 过滤条件值
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public String getExpression(int indexInCondition) {
        StringBuffer expression = new StringBuffer();
        expression.append(this.prefix);
        expression.append(this.column);
        expression.append(this.compareSymbol);
        expression.append(" #{condition.expressions[");
        expression.append(indexInCondition);
        expression.append("].value} ");
        expression.append(this.suffix);
        return expression.toString();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append(this.prefix).append(this.column).append(this.compareSymbol);
        sb.append(this.value).append(this.suffix).append("\n");
        return sb.toString();
    }
    
}
