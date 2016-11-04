
package com.lckj.base.model;

/**
 * 
* @ClassName: PagerParam 
* @Description: 分页接收参数实体 
* @author: WUJING 
* @date :2016-06-10 上午11:03:56 
*
 */
public class PagerParam extends MessageInfo {
    
    /** 页码 */
    private int page;
    
    /** 查询记录行数 */
    private int rows;
    
    /** 起始行数 */
    private int startRow;
    
    /** 排序字段 */
    private String sort;
    
    /** 排序方式 */
    private String order;
    
    /**
     * @return startRow
     */
    public int getStartRow() {
        if (this.page == 0) {
            return 0;
        } else {
            return (page - 1) * rows;
        }
    }
    
    /**
     * @param startRow startRow
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    
    /**
     * @return page
     */
    public int getPage() {
        return page;
    }
    
    /**
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }
    
    /**
     * @return rows
     */
    public int getRows() {
        return rows;
    }
    
    /**
     * @param rows rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    /**
     * @return sort
     */
    public String getSort() {
        return sort;
    }
    
    /**
     * @param sort sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
    
    /**
     * @return order
     */
    public String getOrder() {
        return order;
    }
    
    /**
     * @param order order
     */
    public void setOrder(String order) {
        this.order = order;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("PagerParam[");
        sb.append(super.toString());
        sb.append("\n    page=").append(this.page);
        sb.append("\n    rows=").append(this.rows);
        sb.append("\n    startRow=").append(this.startRow);
        sb.append("\n    sort=").append(this.sort);
        sb.append("\n    order=").append(this.order);
        sb.append("\n]");
        return sb.toString();
    }
}
