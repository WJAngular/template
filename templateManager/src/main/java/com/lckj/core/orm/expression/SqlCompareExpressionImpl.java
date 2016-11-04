
package com.lckj.core.orm.expression;

/**
 * 
* @ClassName: SqlCompareExpressionImpl 
* @Description: 过滤操作组装表达式抽象类 
* @author: WUJING 
* @date :2016-06-10 上午11:23:51 
*
 */
public abstract class SqlCompareExpressionImpl implements SqlCompareExpression {
    
    /**
     * 构造函数
     * 
     * @param prefix 前缀
     * @param column 字段名
     * @param compareSymbol 条件表达式
     * @param value 条件值
     * @param suffix 后缀
     */
    public SqlCompareExpressionImpl(String prefix, String column, String compareSymbol, String suffix) {
        this.prefix = prefix;
        this.column = column;
        this.compareSymbol = compareSymbol;
        this.suffix = suffix;
    }
    
    /**
     * "AND," "AND (" , "OR" , "OR ("
     */
    protected String prefix;
    
    /**
     * "",")"
     */
    protected String suffix;
    
    /** column */
    protected String column;
    
    /** compareSymbol */
    protected String compareSymbol;
    
    @Override
    public String getPrefix() {
        return prefix;
    }
    
    @Override
    public String getSuffix() {
        return suffix;
    }
    
    @Override
    public String getColumn() {
        return column;
    }
    
    @Override
    public String getCompareSymbol() {
        return compareSymbol;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("SqlCompareExpressionImpl[");
        sb.append("  prefix=").append(this.prefix);
        sb.append("  suffix=").append(this.suffix);
        sb.append("  column=").append(this.column);
        // sb.append("\n    compareSymbol=").append(this.compareSymbol);
        sb.append("]");
        return sb.toString();
    }
    
}
