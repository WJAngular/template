
package com.lckj.core.orm.dialect;

/**
 * 
* @ClassName: Dialect 
* @Description: 数据库类型枚举类 
* @author: WUJING 
* @date :2016-06-10 上午11:17:42 
*
 */
public abstract class Dialect {
    
    /**
     * 数据库类型枚举类
     * 
     * @author 黄洪波
     * @since 1.0
     * @version 2014-03-07 黄洪波
     */
    public static enum Type {
        /** MYSQL */
        MYSQL,
        /** ORACLE */
        ORACLE,
        /** POSTGRESQL */
        POSTGRESQL,
        /** H2 */
        H2
    }
    
    /**
     * 获取分页条件方法
     * 
     * @param sql sql
     * @param skipResults skipResults
     * @param maxResults maxResults
     * @return 分页字符串
     */
    public abstract String getLimitString(String sql, int skipResults, int maxResults);
    
}
