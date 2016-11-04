
package com.lckj.base.model;

/**
 * 
* @ClassName: PagerResult 
* @Description: 分页输出参数实体 
* @author: WUJING 
* @date :2016-06-10 上午11:04:10 
*
 */
public class PagerResult extends MessageInfo {
    
    /** 记录总数 */
    private int total;
    
    /** 记录集合 */
    private Object rows;
    
    /**
     * @return total
     */
    public int getTotal() {
        return total;
    }
    
    /**
     * @param total total
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
    /**
     * @return rows
     */
    public Object getRows() {
        return rows;
    }
    
    /**
     * @param rows rows
     */
    public void setRows(Object rows) {
        this.rows = rows;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("PagerResult[");
        sb.append("\n    total=").append(this.total);
        sb.append("\n    rows=").append(this.rows);
        sb.append("\n]");
        return sb.toString();
    }
}
