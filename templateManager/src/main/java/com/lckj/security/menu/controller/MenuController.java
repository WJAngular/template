
package com.lckj.security.menu.controller;

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
import com.lckj.security.menu.model.MenuVO;
import com.lckj.security.menu.service.MenuService;

/**
 * 
* @ClassName: MenuController 
* @Description: 菜单控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:28:16 
*
 */
@Controller
public class MenuController {
    
    /** 注入菜单业务操作类 */
    @Autowired
    MenuService menuService;
    
    /**
     * 查询菜单
     * 
     * @param menuVO 菜单对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 列表数据
     */
    @RequestMapping("/menu/list.do")
    @ResponseBody
    public PagerVO menuList(MenuVO menuVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.andLike("menuName", menuVO.getMenuName());
            condition.andEqual("parentMenuId", menuVO.getParentMenuId() == null ? 0 : menuVO.getParentMenuId());
            condition.orderAsc("menuSort");
            pagerVO.setTotalRows(menuService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(menuService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取菜单
     * 
     * @param menuVO 菜单对象
     * @param model 数据模型
     * @return 菜单对象
     */
    @RequestMapping("/menu/read.do")
    @ResponseBody
    public MenuVO read(MenuVO menuVO, Model model) {
        try {
            return menuService.read(menuVO.getMenuId());
        } catch (Exception ex) {
            menuVO.setErrorCode();
        }
        return menuVO;
    }
    
    /**
     * 新增菜单
     * 
     * @param menuVO 菜单对象
     * @param model 数据模型
     * @return 菜单对象
     */
    @RequestMapping("/menu/add.do")
    @ResponseBody
    public MenuVO add(MenuVO menuVO, Model model) {
        try {
            menuService.insertPartitive(BeanMapUtil.beanToMap(menuVO));
        } catch (Exception ex) {
            menuVO.setErrorCode();
        }
        return menuVO;
    }
    
    /**
     * 修改菜单
     * 
     * @param menuVO 菜单对象
     * @param model 数据模型
     * @return 菜单对象
     */
    @RequestMapping("/menu/update.do")
    @ResponseBody
    public MenuVO update(MenuVO menuVO, Model model) {
        try {
            menuService.updatePartitive(BeanMapUtil.beanToMap(menuVO), menuVO.getMenuId());
        } catch (Exception ex) {
            menuVO.setErrorCode();
        }
        return menuVO;
    }
    
    /**
     * 删除菜单
     * 
     * @param menuVO 菜单对象
     * @param model 数据模型
     * @return 菜单对象
     */
    @RequestMapping("/menu/delete.do")
    @ResponseBody
    public MenuVO delete(MenuVO menuVO, Model model) {
        try {
            menuService.deleteMenuAndRelation(menuVO.getMenuId());
        } catch (Exception ex) {
            menuVO.setErrorCode();
        }
        return menuVO;
    }
    
    /**
     * 修改菜单状态信息
     * 
     * @param menuVO 菜单对象
     * @param model 数据模型
     * @return 菜单对象
     */
    @RequestMapping("/menu/changestate.do")
    @ResponseBody
    public MenuVO changeState(MenuVO menuVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("status", menuVO.getStatus());
            menuService.updatePartitive(fields, menuVO.getMenuId());
        } catch (Exception ex) {
            menuVO.setErrorCode();
        }
        return menuVO;
    }
}
