
package com.lckj.dictionary.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.base.model.PagerVO;
import com.lckj.base.systeminit.AppCache;
import com.lckj.base.util.BeanMapUtil;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.dictionary.model.DictionaryItemVO;
import com.lckj.dictionary.model.DictionaryTypeVO;
import com.lckj.dictionary.service.DictionaryItemService;
import com.lckj.dictionary.service.DictionaryTypeService;

/**
 * 
* @ClassName: DictionaryController 
* @Description: 数据字典控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:26:48 
*
 */
@Controller
public class DictionaryController {
    
    /** 注入字典类别业务操作类 */
    @Autowired
    DictionaryTypeService dictionaryTypeService;
    
    /** 注入字典明细业务操作类 */
    @Autowired
    DictionaryItemService dictionaryItemService;
    
    /**
     * 查询字典类别
     * 
     * @param dictionaryTypeVO 字典类别对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 查询结果
     */
    @RequestMapping("/dictionary/type/list.do")
    @ResponseBody
    public PagerVO dictionaryTypeList(DictionaryTypeVO dictionaryTypeVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.andLike("dictionaryName", dictionaryTypeVO.getDictionaryName());
            condition.orderDesc("dictionaryId");
            pagerVO.setTotalRows(dictionaryTypeService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(dictionaryTypeService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取字典类型
     * 
     * @param dictionaryTypeVO 字典类型对象
     * @param model 数据模型
     * @return 字典类型对象
     */
    @RequestMapping("/dictionary/type/read.do")
    @ResponseBody
    public DictionaryTypeVO read(DictionaryTypeVO dictionaryTypeVO, Model model) {
        try {
            return dictionaryTypeService.read(dictionaryTypeVO.getDictionaryId());
        } catch (Exception ex) {
            dictionaryTypeVO.setErrorCode();
        }
        return dictionaryTypeVO;
    }
    
    /**
     * 新增字典类型
     * 
     * @param dictionaryTypeVO 字典类型对象
     * @param model 数据模型
     * @return 字典类型对象
     */
    @RequestMapping("/dictionary/type/add.do")
    @ResponseBody
    public DictionaryTypeVO add(DictionaryTypeVO dictionaryTypeVO, Model model) {
        try {
            dictionaryTypeService.insertPartitive(BeanMapUtil.beanToMap(dictionaryTypeVO));
            this.initDict();
        } catch (Exception ex) {
            dictionaryTypeVO.setErrorCode();
        }
        return dictionaryTypeVO;
    }
    
    /**
     * 修改字典类型
     * 
     * @param dictionaryTypeVO 字典类型对象
     * @param model 数据模型
     * @return 字典类型对象
     */
    @RequestMapping("/dictionary/type/update.do")
    @ResponseBody
    public DictionaryTypeVO update(DictionaryTypeVO dictionaryTypeVO, Model model) {
        try {
            dictionaryTypeService.updatePartitive(BeanMapUtil.beanToMap(dictionaryTypeVO), dictionaryTypeVO.getDictionaryId());
            this.initDict();
        } catch (Exception ex) {
            dictionaryTypeVO.setErrorCode();
        }
        return dictionaryTypeVO;
    }
    
    /**
     * 删除字典类型
     * 
     * @param dictionaryTypeVO 字典类型
     * @param model 数据模型
     * @return 删除的记录数
     */
    @RequestMapping("/dictionary/type/delete.do")
    @ResponseBody
    public DictionaryTypeVO delete(DictionaryTypeVO dictionaryTypeVO, Model model) {
        try {
            dictionaryTypeService.delete(dictionaryTypeVO.getDictionaryId());
            this.initDict();
        } catch (Exception ex) {
            dictionaryTypeVO.setErrorCode();
        }
        return dictionaryTypeVO;
    }
    
    /**
     * 查询字典明细
     * 
     * @param dictionaryItemVO 字典明细对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 查询结果
     */
    @RequestMapping("/dictionary/item/list.do")
    @ResponseBody
    public PagerVO dictionaryItemList(DictionaryItemVO dictionaryItemVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.andEqual("dictionaryId", dictionaryItemVO.getDictionaryId());
            condition.orderDesc("itemId");
            pagerVO.setList(dictionaryItemService.list(condition, new RowBounds(0, 100)));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取字典明细
     * 
     * @param dictionaryItemVO 字典明细
     * @param model 数据模型
     * @return 字典明细
     */
    @RequestMapping("/dictionary/item/read.do")
    @ResponseBody
    public DictionaryItemVO read(DictionaryItemVO dictionaryItemVO, Model model) {
        try {
            return dictionaryItemService.read(dictionaryItemVO.getItemId());
        } catch (Exception ex) {
            dictionaryItemVO.setErrorCode();
        }
        return dictionaryItemVO;
    }
    
    /**
     * 新增字典明细
     * 
     * @param dictionaryItemVO 字典明细
     * @param model 数据模型
     * @return 字典明细
     */
    @RequestMapping("/dictionary/item/add.do")
    @ResponseBody
    public DictionaryItemVO add(DictionaryItemVO dictionaryItemVO, Model model) {
        try {
            dictionaryItemService.insertPartitive(BeanMapUtil.beanToMap(dictionaryItemVO));
            this.initDict();
        } catch (Exception ex) {
            dictionaryItemVO.setErrorCode();
        }
        return dictionaryItemVO;
    }
    
    /**
     * 修改字典明细
     * 
     * @param dictionaryItemVO 字典明细
     * @param model 数据模型
     * @return 字典明细
     */
    @RequestMapping("/dictionary/item/update.do")
    @ResponseBody
    public DictionaryItemVO update(DictionaryItemVO dictionaryItemVO, Model model) {
        try {
            dictionaryItemService.update(dictionaryItemVO);
            dictionaryItemService.updatePartitive(BeanMapUtil.beanToMap(dictionaryItemVO), dictionaryItemVO.getItemId());
            this.initDict();
        } catch (Exception ex) {
            dictionaryItemVO.setErrorCode();
        }
        return dictionaryItemVO;
    }
    
    /**
     * 删除字典明细
     * 
     * @param dictionaryItemVO 字典明细
     * @param model 数据模型
     * @return 删除的记录数
     */
    @RequestMapping("/dictionary/item/delete.do")
    @ResponseBody
    public DictionaryItemVO delete(DictionaryItemVO dictionaryItemVO, Model model) {
        try {
            dictionaryItemService.delete(dictionaryItemVO.getItemId());
            this.initDict();
        } catch (Exception ex) {
            dictionaryItemVO.setErrorCode();
        }
        return dictionaryItemVO;
    }
    
    /**
     * 初始化数据字典到缓存
     */
    private void initDict() {
        AppCache.initDict(dictionaryItemService.queryAllItem());
    }
}
