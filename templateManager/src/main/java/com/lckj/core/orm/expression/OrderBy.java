
package com.lckj.core.orm.expression;

import java.util.ArrayList;
import java.util.List;

import com.lckj.core.orm.util.NameConverter;

/**
 * 
* @ClassName: OrderBy 
* @Description: 排序操作对象 
* @author: WUJING 
* @date :2016-06-10 上午11:21:08 
*
 */
public class OrderBy {
    
    /** 升序标识 */
    public static String ASC = " ASC ";
    
    /** 降序标识 */
    public static String DESC = " DESC ";
    
    /** 排序集合 */
    private List<String[]> orders = new ArrayList<String[]>(2);
    
    /**
     * 升序操作
     * 
     * @param propertyNames 属性名称
     */
    public void orderAsc(String propertyNames) {
        order(propertyNames, ASC);
    }
    
    /**
     * 降序操作
     * 
     * @param propertyNames 属性名称
     */
    public void orderDesc(String propertyNames) {
        order(propertyNames, DESC);
    }
    
    @Override
    public String toString() {
        StringBuffer sbSql = new StringBuffer(64);
        sbSql.append(" ORDER BY ");
        for (int i = 0; i < orders.size(); i++) {
            String[] order = orders.get(i);
            if (i != 0) {
                sbSql.append(" , ");
            }
            
            sbSql.append(order[0]);
            sbSql.append(" ");
            sbSql.append(order[1]);
        }
        return sbSql.toString();
    }
    
    /**
     * 排序操作
     * 
     * @param propertyNames 属性名称
     * @param direction 排序方式
     */
    private void order(String propertyNames, String direction) {
        String[] propertyNameArray = propertyNames.split(",");
        for (String property : propertyNameArray) {
            String[] order = { NameConverter.propertyToColumnWithTableAlias(property), direction };
            orders.add(order);
        }
    }
    
    /**
     * 复制排序操作
     * 
     * @return 排序对象
     */
    public OrderBy copy() {
        OrderBy orderBy = new OrderBy();
        for (String[] order : orders) {
            orderBy.orders.add(order);
        }
        return orderBy;
    }
}
