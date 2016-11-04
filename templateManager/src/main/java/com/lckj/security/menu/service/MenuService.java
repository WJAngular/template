
package com.lckj.security.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.service.AbstractService;
import com.lckj.security.menu.mapper.MenuMapper;
import com.lckj.security.menu.model.MenuVO;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: MenuService 
* @Description: 菜单业务逻辑处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:28:48 
*
 */
@Service
public class MenuService extends AbstractService<MenuVO> {
    
    /** 菜单持久化处理接口 */
    @Autowired
    MenuMapper menuMapper;
    
    /** 获取Mapper接口 */
    @Override
    protected MybatisMapper<MenuVO> getMapper() {
        return this.menuMapper;
    }
    
    /**
     * 根据用户查询已分配权限的菜单
     * 
     * @param userVO 用户信息
     * @return 菜单集合
     */
    public List<MenuVO> queryMenuByUser(UserVO userVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userVO.getUserId());
        return menuMapper.queryMenuByUser(param);
    }
    
    /**
     * 删除菜单及子菜单信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public MenuVO deleteMenuAndRelation(int menuId) {
        MenuVO result = menuMapper.read(menuId);
        // 删除菜单
        menuMapper.delete(menuId);
        
        // 根据菜单id删除子菜单
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("parentMenuId", menuId);
        menuMapper.deleteBatch(condition);
        
        return result;
    }
    
}
