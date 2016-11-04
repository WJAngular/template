
package com.lckj.codefactory.service;

import java.util.List;

import com.lckj.codefactory.model.GenerateVO;
import com.lckj.codefactory.model.TableVO;

/**
 * 
* @ClassName: CodeFactoryService 
* @Description: 生成工具业务操作接口 
* @author: WUJING 
* @date :2016-06-10 上午11:13:56 
*
 */
public interface CodeFactoryService {
    
    /**
     * 读取表清单信息
     * 
     * @param generateVO 生成工具实体类
     * @return 数据表信息集合
     */
    public List<TableVO> readTableList(GenerateVO generateVO);
    
    /**
     * 读取数据表名称集合
     * 
     * @param generateVO 生成工具实体类
     * @return 数据表名称集合
     */
    public List<String> listTableNames(GenerateVO generateVO);
    
    // public List<String> listSchems(GenerateVO generateVO);
}
