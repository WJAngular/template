
package com.lckj.core.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.Condition;

/**
 * 
* @ClassName: AbstractService 
* @Description:  Service 操作抽象类 
* @author: WUJING 
* @date :2016-06-10 上午11:25:58 
* 
* @param <T>
 */
@Transactional
public abstract class AbstractService<T> implements AgaveService<T> {
    
    /**
     * 获取具体mapper操作对象
     * 
     * <pre>
     *  每个继承该类的操作类都需要实现该方法，以返回具体的mapper操作类
     * </pre>
     * 
     * @return mapper 业务mapper操作类
     */
    protected abstract MybatisMapper<T> getMapper();
    
    @Override
    public void insert(T model) {
        getMapper().insert(model);
    }
    
    @Override
    public void insertBatch(List<T> models) {
        getMapper().insertBatch(models);
    }
    
    @Override
    public void insertPartitive(PartitiveFields fields) {
        fields.prepareInsertSql();
        getMapper().insertPartitive(fields);
    }
    
    @Override
    public T read(Object... id) {
        return getMapper().read(id);
    }
    
    @Override
    public int count(Condition condition) {
        return getMapper().count(condition);
    }
    
    @Override
    public List<T> list(Condition condition, RowBounds rowBounds) {
        return getMapper().list(condition, rowBounds);
    }
    
    @Override
    public List<T> list(Condition condition) {
        return getMapper().list(condition);
    }
    
    @Override
    public void update(T model) {
        getMapper().update(model);
    }
    
    @Override
    public void updatePartitive(PartitiveFields fields, Object... id) {
        fields.prepareUpdateSql();
        getMapper().updatePartitive(fields, id);
    }
    
    @Override
    public void updateBatch(PartitiveFields fields, Condition condition) {
        fields.prepareUpdateSql();
        getMapper().updateBatch(fields, condition);
    }
    
    @Override
    public void delete(Object... id) {
        getMapper().delete(id);
    }
    
    @Override
    @Transactional
    public void deleteBatch(Object[] idList) {
        for (Object id : idList) {
            this.delete(id);
        }
    }
    
    @Override
    public void deleteBatch(Condition condition) {
        getMapper().deleteBatch(condition);
    }
}
