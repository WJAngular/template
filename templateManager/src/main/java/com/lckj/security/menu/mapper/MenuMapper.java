
package com.lckj.security.menu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lckj.core.orm.MybatisMapper;
import com.lckj.core.orm.condition.Condition;
import com.lckj.security.menu.model.MenuVO;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: MenuMapper 
* @Description: 菜单持久化操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:28:26 
*
 */
@Repository
public interface MenuMapper extends MybatisMapper<MenuVO> {
    
    /**
     * 根据用户信息查询菜单
     * 
     * @param userVO 用户信息
     * @return 菜单信息
     */
    List<MenuVO> queryMenuByUser(UserVO userVO);
    
    /**
     * 删除关联的菜单信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    MenuVO deleteMenuAndRelation(int menuId);
    
    /**
     * 根据角色查询对应的菜单
     * 
     * @param condition 查询条件
     * @return 菜单集合
     */
    public List<MenuVO> queryMenuByRole(@Param("condition") Condition condition);
    
    /**
     * 根据用户查询对应的菜单信息
     * 
     * @param param 查询条件
     * @return 菜单集合
     */
    public List<MenuVO> queryMenuByUser(Map<String, Object> param);
}
