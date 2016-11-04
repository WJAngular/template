
package com.lckj.core.orm.dialect;

/**
 * 
* @ClassName: MySqlDialect 
* @Description: mysql分页条件 
* @author: WUJING 
* @date :2016-06-10 上午11:18:16 
*
 */
public class MySqlDialect extends Dialect {
    
    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ") + " limit " + offset + " ," + limit;
    }
    
}
