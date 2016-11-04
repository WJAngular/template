
package com.lckj.base.model;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import com.lckj.base.BaseConstant;

/**
 * 
* @ClassName: PagerVO 
* @Description:  分页处理对象 
* @author: WUJING 
* @date :2016-06-10 上午11:04:23 
*
 */
public class PagerVO {
    
    /** 构造函数 */
    public PagerVO() {
    }
    
    /**
     * 构造函数
     * 
     * @param pageNo 页码
     */
    public PagerVO(String pageNo) {
        setPageNo(pageNo);
    }
    
    /**
     * 构造函数
     * 
     * @param pageNo 页码
     * @param pageScale pageScale
     */
    public PagerVO(String pageNo, String pageScale) {
        setPageNo(pageNo);
        setPageScale(pageScale);
    }
    
    /** 默认分页大小 */
    private static int PAGE_SIZE = 20;
    
    /** 是否显示分页栏目，0：显示，1：不显示 */
    private int showPageFlag = 0;
    
    /** 总行数 */
    private int totalRows;
    
    /** 起始行数 */
    private int startRow;
    
    /** 每页显示的行数 */
    private int pageSize = PAGE_SIZE;
    
    /** 当前页号 */
    private int currentPage;
    
    /** 总页数 */
    private int totalPages;
    
    /** 存放查询出的数据结果 */
    private List<?> list;
    
    /** 0：表示成功，1：表示失败.返回结果默认为成功 */
    private int returncode = 0;
    
    /** 错误信息 */
    private String errmsg;
    
    /** 对外使用 */
    private String pageNo;
    
    /** pageScale */
    private String pageScale;
    
    /** reportHtml */
    private String reportHtml;
    
    /**
     * 设值总行数
     * 
     * @param totalRows 总行数
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        totalPages = totalRows / pageSize;
        int mod = totalRows % pageSize;
        if (mod > 0) {
            totalPages++;
        }
        setCurrentPage(this.currentPage);
    }
    
    /**
     * 设置当前页
     * 
     * @param currentPage 当前页码
     */
    private void setCurrentPage(int currentPage) {
        // 当前页小于第一页
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if (currentPage > this.totalPages) { // 当前页大于总页数
            this.currentPage = this.totalPages;
        } else {
            this.currentPage = currentPage;
        }
        this.pageNo = String.valueOf(this.currentPage);
        this.startRow = (this.currentPage - 1) * this.pageSize;
        if (this.currentPage == 0) {
            this.startRow = 0;
        }
    }
    
    /**
     * 设置错误消息
     */
    public void setErrorCode() {
        this.returncode = BaseConstant.RETURN_CODE_FAILURE;
    }
    
    /**
     * 设值页码
     * 
     * @param pageNo 页码
     */
    public void setPageNo(String pageNo) {
        if (pageNo == null || "".equals(pageNo)) {
            this.currentPage = 1;
        } else {
            try {
                this.currentPage = Integer.parseInt(pageNo);
            } catch (Exception e) {
                this.currentPage = 1;
            }
        }
        this.pageNo = String.valueOf(this.currentPage);
    }
    
    /**
     * 设值 pageScale
     * 
     * @param pageScale pageScale
     */
    public void setPageScale(String pageScale) {
        this.pageScale = pageScale;
        if (pageScale == null || "".equals(pageScale)) {
            this.pageSize = PAGE_SIZE;
        } else {
            try {
                this.pageSize = Integer.parseInt(pageScale);
            } catch (Exception e) {
                this.pageSize = PAGE_SIZE;
            }
        }
        this.pageScale = String.valueOf(this.pageSize);
    }
    
    /**
     * 获取错误信息
     * 
     * @return 错误信息
     */
    public String getErrmsg() {
        return errmsg;
    }
    
    /**
     * 设值错误信息
     * 
     * @param errmsg 错误信息
     */
    public void setErrmsg(String errmsg) {
        this.returncode = 1;
        this.errmsg = errmsg;
    }
    
    /**
     * 设置用户超期错误信息(用于app使用)
     */
    public void setInvalidErrmsg() {
        this.returncode = 1009;
        this.errmsg = "登录已过期,请重新登录";
    }
    
    /**
     * 未授权用户(用于app使用)
     */
    public void setGrantErrmsg() {
        this.returncode = 9999;
        this.errmsg = "此用户未进行授权，请联系管理员";
    }
    
    /**
     * 获取返回编码
     * 
     * @return 返回编码
     */
    public int getReturncode() {
        return returncode;
    }
    
    /**
     * 设值返回编码
     * 
     * @param returncode 返回编码
     */
    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }
    
    /**
     * 获取列表数据
     * 
     * @return 列表数据
     */
    public List<?> getList() {
        return list;
    }
    
    /**
     * 设值列表数据
     * 
     * @param list 列表数据
     */
    public void setList(List<?> list) {
        this.list = list;
    }
    
    /**
     * 获取总行数
     * 
     * @return 总行数
     */
    public int getTotalRows() {
        return totalRows;
    }
    
    /**
     * 设置总页数
     * 
     * @return 总页数
     */
    public int getTotalPages() {
        return totalPages;
    }
    
    /**
     * 获取pageScale
     * 
     * @return pageScale
     */
    public String getPageScale() {
        return pageScale;
    }
    
    /**
     * 获取页码
     * 
     * @return 获取页码
     */
    public String getPageNo() {
        return pageNo;
    }
    
    /**
     * 获取页码 (用于app使用)
     * 
     * @return 获取页码
     */
    public int getIntPageNo() {
        return NumberUtils.toInt(pageNo, 1);
    }
    
    /**
     * 获取页码 (用于app使用)
     * 
     * @return 获取页码
     */
    public boolean isLastPage() {
        int newPageNo = NumberUtils.toInt(pageNo, 1);
        if (totalPages != 0 && newPageNo > totalPages) {
            this.setPageNo(String.valueOf(newPageNo));
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 设值起始行数
     * 
     * @return 起始行数
     */
    public int getStartRow() {
        return this.startRow;
    }
    
    /**
     * 获取分页大小
     * 
     * @return 分页大小
     */
    public int getPageSize() {
        return this.pageSize;
    }
    
    /**
     * 设置分页大小
     * 
     * @param pageSize 分页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * 获取reportHtml
     * 
     * @return reportHtml
     */
    public String getReportHtml() {
        return reportHtml;
    }
    
    /**
     * 设值 reportHtml
     * 
     * @param reportHtml reportHtml
     */
    public void setReportHtml(String reportHtml) {
        this.reportHtml = reportHtml;
    }
    
    /**
     * @return showPageFlag
     */
    public int getShowPageFlag() {
        return showPageFlag;
    }
    
    /**
     * @param showPageFlag showPageFlag
     */
    public void setShowPageFlag(int showPageFlag) {
        this.showPageFlag = showPageFlag;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append("PagerVO[");
        sb.append("\n    showPageFlag=").append(this.showPageFlag);
        sb.append("\n    totalRows=").append(this.totalRows);
        sb.append("\n    startRow=").append(this.startRow);
        sb.append("\n    pageSize=").append(this.pageSize);
        sb.append("\n    currentPage=").append(this.currentPage);
        sb.append("\n    totalPages=").append(this.totalPages);
        sb.append("\n    list=").append(this.list);
        sb.append("\n    returncode=").append(this.returncode);
        sb.append("\n    errmsg=").append(this.errmsg);
        sb.append("\n    pageNo=").append(this.pageNo);
        sb.append("\n    pageScale=").append(this.pageScale);
        sb.append("\n    reportHtml=").append(this.reportHtml);
        sb.append("\n]");
        return sb.toString();
    }
}
