
package com.lckj.core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.Condition;

/**
 * 
* @ClassName: AgaveService 
* @Description: Service 操作接口 
* @author: WUJING 
* @date :2016-06-10 上午11:26:08 
* 
* @param <T>
 */
public interface AgaveService<T> {
    
    /**
     * 插入单条数据
     * 
     * @param model 实体对象
     */
    public void insert(T model);
    
    /**
     * 批量新增数据
     * 
     * @param models 实体对象集合
     */
    public void insertBatch(List<T> models);
    
    /**
     * 指定字段新增记录
     * 
     * @param fields 字段集合
     */
    public void insertPartitive(@Param("fields") PartitiveFields fields);
    
    /**
     * 根据主键读取单条记录
     * 
     * @param id 主键
     * @return 实体对象
     */
    public T read(@Param("id") Object... id);
    
    /**
     * 查询记录数
     * 
     * @param condition 条件
     * @return 符合条件的记录数量
     */
    int count(Condition condition);
    
    /**
     * 查询记录列表（分页）
     * 
     * @param condition 条件
     * @param rowBounds 分页条件
     * @return 记录集合
     */
    List<T> list(Condition condition, RowBounds rowBounds);
    
    /**
     * 查询记录列表（不分页）
     * 
     * @param condition 查询条件
     * @return 记录集合
     */
    List<T> list(Condition condition);
    
    /**
     * 修改记录
     * 
     * @param model 实体对象
     */
    public void update(T model);
    
    /**
     * 根据主键修改部分字段
     * 
     * @param fields 字段集合
     * @param id 主键
     */
    public void updatePartitive(PartitiveFields fields, @Param("id") Object... id);
    
    /**
     * 批量更新
     * 
     * @param fields 字段集合
     * @param condition 条件
     */
    public void updateBatch(PartitiveFields fields, @Param("condition") Condition condition);
    
    /**
     * 根据主键删除记录
     * 
     * @param id 主键
     */
    public void delete(Object... id);
    
    /**
     * 根据主键集合删除记录
     * 
     * @param idList id集合
     */
    @Transactional
    public void deleteBatch(Object[] idList);
    
    /**
     * 根据查询条件删除记录
     * 
     * @param condition 条件
     */
    public void deleteBatch(Condition condition);
}
