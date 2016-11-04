
package com.lckj.core.orm.expression;

import java.util.List;

/**
 * 
* @ClassName: ListValueExpression 
* @Description: 列表类型的条件表达式 
* @author: WUJING 
* @date :2016-06-10 上午11:20:47 
*
 */
public class ListValueExpression extends SqlCompareExpressionImpl {
    
    /**
     * 构造函数
     * 
     * @param prefix 前缀
     * @param column 字段名
     * @param compareSymbol 条件表达式
     * @param value 条件值
     * @param suffix 后缀
     */
    public ListValueExpression(String prefix, String column, String compareSymbol, List<?> value, String suffix) {
        super(prefix, column, compareSymbol, suffix);
        this.value = value;
    }
    
    /** 过滤条件值 */
    private List<?> value;
    
    /**
     * 获取过滤条件值
     * 
     * @return 过滤条件值
     */
    public List<?> getValue() {
        return value;
    }
    
    /**
     * 设值过滤条件值
     * 
     * @param value 过滤条件值
     */
    public void setValue(List<?> value) {
        this.value = value;
    }
    
    @Override
    public String getExpression(int indexInCondition) {
        StringBuffer expression = new StringBuffer(128);
        expression.append(this.prefix);
        expression.append(this.column);
        expression.append(this.compareSymbol);
        expression.append(" ( ");
        for (int i = 0; i < this.value.size(); i++) {
            if (i != 0) {
                expression.append(" , ");
            }
            expression.append("#{condition.expressions[");
            expression.append(indexInCondition);
            expression.append("].value[");
            expression.append(i);
            expression.append("]}");
        }
        expression.append(" ) ");
        expression.append(this.suffix);
        return expression.toString();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append(this.prefix).append(this.column).append(this.compareSymbol).append(" ( ");
        sb.append(this.value).append(" ) ").append(this.suffix).append("\n");
        return sb.toString();
    }
    
}
