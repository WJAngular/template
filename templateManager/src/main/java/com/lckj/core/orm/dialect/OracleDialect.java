
package com.lckj.core.orm.dialect;

/**
 * 
* @ClassName: OracleDialect 
* @Description:  oracle分页条件 
* @author: WUJING 
* @date :2016-06-10 上午11:19:07 
*
 */
public class OracleDialect extends Dialect {
    
    @Override
    public String getLimitString(String sql, int offset, int limit) {
        String strSQL = sql.trim();
        StringBuffer pagingSelect = new StringBuffer(strSQL.length() + 100);
        pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
        pagingSelect.append(strSQL);
        pagingSelect.append(" ) row_ ) where rownum_ > " + offset + " and rownum_ <= " + (offset + limit));
        return pagingSelect.toString();
    }
}
