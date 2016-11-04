
package com.lckj.core.orm.dialect;

/**
 * 
* @ClassName: PostgreSqlDialect 
* @Description: PostgreSql分页条件 
* @author: WUJING 
* @date :2016-06-10 上午11:20:17 
*
 */
public class PostgreSqlDialect extends Dialect {
    
    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ") + " limit " + limit + " offset " + offset;
    }
    
}
