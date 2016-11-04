
package com.lckj.core.orm;

import java.util.Map;

/**
 * 
* @ClassName: TreeNode 
* @Description: 树接口类 
* @author: WUJING 
* @date :2016-06-10 上午11:25:45 
*
 */
public interface TreeNode {
    
    /** 关闭状态 **/
    public static final String STATA_CLOSE = "closed";
    
    /** 展开状态 **/
    public static final String STATA_OPEN = "open";
    
    /**
     * 获取树节点ID
     * 
     * @return 取树节点ID
     */
    public int getId();
    
    /**
     * 获取树节点名称
     * 
     * @return 树节点名称
     */
    public String getText();
    
    /**
     * 获取树节点状态
     * 
     * @return 树节点状态
     */
    public String getState();
    
    /**
     * 获取树节点选中状态
     * 
     * @return 树节点选中状态
     */
    public Boolean getChecked();
    
    /**
     * 获取树节点图标
     * 
     * @return 树节点图标
     */
    public String getIconCls();
    
    /**
     * 获取树节点属性
     * 
     * @return 树节点属性
     */
    public Map<String, String> getAttributes();
    
}
