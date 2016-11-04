
package com.lckj.security.operation.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.base.model.PagerVO;
import com.lckj.base.util.BeanMapUtil;
import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.security.operation.model.OperationVO;
import com.lckj.security.operation.service.OperationService;

/**
 * 
* @ClassName: OperationController 
* @Description: 操作控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:29:01 
*
 */
@Controller
public class OperationController {
    
    /** 注入操作业务操作类 */
    @Autowired
    OperationService operationService;
    
    /**
     * 查询操作
     * 
     * @param operationVO 操作对象
     * @param pagerVO 分页对象
     * @param model 数据对象
     * @return 操作列表
     */
    @RequestMapping("/operation/list.do")
    @ResponseBody
    public PagerVO operationList(OperationVO operationVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.orderDesc("operationId");
            condition.andLike("operationName", operationVO.getOperationName());
            pagerVO.setTotalRows(operationService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(operationService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取操作
     * 
     * @param operationVO 操作对象
     * @param model 数据模型
     * @return 操作对象
     */
    @RequestMapping("/operation/read.do")
    @ResponseBody
    public OperationVO read(OperationVO operationVO, Model model) {
        try {
            return operationService.read(operationVO.getOperationId());
        } catch (Exception ex) {
            operationVO.setErrorCode();
        }
        return operationVO;
    }
    
    /**
     * 新增操作
     * 
     * @param operationVO 操作对象
     * @param model 数据模型
     * @return 操作对象
     */
    @RequestMapping("/operation/add.do")
    @ResponseBody
    public OperationVO add(OperationVO operationVO, Model model) {
        try {
            operationService.insertPartitive(BeanMapUtil.beanToMap(operationVO));
        } catch (Exception ex) {
            operationVO.setErrorCode();
        }
        return operationVO;
    }
    
    /**
     * 修改操作
     * 
     * @param operationVO 操作对象
     * @param model 数据模型
     * @return 操作对象
     */
    @RequestMapping("/operation/update.do")
    @ResponseBody
    public OperationVO update(OperationVO operationVO, Model model) {
        try {
            operationService.updatePartitive(BeanMapUtil.beanToMap(operationVO), operationVO.getOperationId());
        } catch (Exception ex) {
            operationVO.setErrorCode();
        }
        return operationVO;
    }
    
    /**
     * 修改操作状态信息
     * 
     * @param operationVO 操作对象
     * @param model 数据模型
     * @return 操作对象
     */
    @RequestMapping("/operation/changestate.do")
    @ResponseBody
    public OperationVO changeState(OperationVO operationVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("status", operationVO.getStatus());
            operationService.updatePartitive(fields, operationVO.getOperationId());
        } catch (Exception ex) {
            operationVO.setErrorCode();
        }
        return operationVO;
    }
    
    /**
     * 删除操作
     * 
     * @param operationVO 操作对象
     * @param model 数据模型
     * @return 删除操作的数量
     */
    @RequestMapping("/operation/delete.do")
    @ResponseBody
    public OperationVO delete(OperationVO operationVO, Model model) {
        try {
            operationService.delete(operationVO.getOperationId());
        } catch (Exception ex) {
            operationVO.setErrorCode();
        }
        return operationVO;
    }
    
    /**
     * 查询角色对应的菜单
     * 
     * @param operationVO 操作对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 角色菜单对应关系
     */
    @RequestMapping("/query/menuoperation.do")
    @ResponseBody
    public PagerVO roleMenuList(OperationVO operationVO, PagerVO pagerVO, Model model) {
        try {
            pagerVO.setList(operationService.queryMenuOpration());
            pagerVO.setShowPageFlag(1);
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
}
