
package com.lckj.core.orm.expression;

/**
 * 
* @ClassName: NoValueExpression 
* @Description: 无值类型的条件表达式 
* @author: WUJING 
* @date :2016-06-10 上午11:20:57 
*
 */
public class NoValueExpression extends SqlCompareExpressionImpl {
    
    /**
     * 构造函数
     * 
     * @param prefix 前缀
     * @param column 字段名
     * @param compareSymbol 条件表达式
     * @param value 条件值
     * @param suffix 后缀
     */
    public NoValueExpression(String prefix, String column, String compareSymbol, String suffix) {
        super(prefix, column, compareSymbol, suffix);
    }
    
    @Override
    public String getExpression(int indexInCondition) {
        StringBuffer expression = new StringBuffer();
        expression.append(this.prefix);
        expression.append(this.column);
        expression.append(this.compareSymbol);
        expression.append(this.suffix);
        return expression.toString();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append(this.prefix).append(this.column);
        sb.append(this.compareSymbol).append(this.suffix).append("\n");
        return sb.toString();
    }
    
}
