
package com.lckj.core.orm.expression;

/**
 * 过滤操作组装表达式接口
 * 
 * <pre>
 * it now supports : 
 * no value := is null ,is not null
 * single value : = , <> , > , < ,>=, <= 
 * between value :between and
 * list value: in(),not in()
 * </pre>
 * 
 * @author 吴景
 * @since 1.0
 * @date:2016-06-10 上午11:22:32 
 */
public interface SqlCompareExpression {
    
    /**
     * 获取前缀
     * 
     * @return 前缀
     */
    public String getPrefix();
    
    /**
     * 获取后缀
     * 
     * @return 后缀
     */
    public String getSuffix();
    
    /**
     * 获取字段
     * 
     * @return 字段
     */
    public String getColumn();
    
    /**
     * 获取CompareSymbol
     * 
     * @return CompareSymbol
     */
    public String getCompareSymbol();
    
    /**
     * 获取indexInCondition
     * 
     * @param indexInCondition indexInCondition
     * @return indexInCondition
     */
    public String getExpression(int indexInCondition);
    
}
