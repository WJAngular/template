
package com.lckj.base.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;

import com.lckj.base.systeminit.EnviromentInfo;
import com.lckj.core.web.Path;
import com.lckj.security.menu.model.MenuVO;
import com.lckj.security.menu.service.MenuService;
import com.lckj.security.user.model.UserVO;

/**
 * 
* @ClassName: MenuTag 
* @Description: 菜单标签处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:06:06 
*
 */
public class MenuTag extends TagSupport {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    @Override
    public int doStartTag() throws JspException {
        try {
            ApplicationContext ctx = EnviromentInfo.getWebApplicationContext();
            MenuService service = ctx.getBean(MenuService.class);
            Subject currentUser = SecurityUtils.getSubject();
            UserVO user = (UserVO) currentUser.getPrincipal();
            this.generatMenuHTML(service.queryMenuByUser(user));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
    
    /**
     * 根据菜单集合动态生成菜单html
     * 
     * @param menus 菜单集合
     * @throws Exception 异常信息
     */
    private void generatMenuHTML(List<MenuVO> menus) throws Exception {
        StringBuffer out = new StringBuffer();
        List<MenuVO> baseMenu = this.getBaseMenu(menus);
        Map<Integer, List<MenuVO>> childMenu = this.getBaseMenuMappingChild(baseMenu, menus);
        boolean isFirstMenu = true;
        for (MenuVO menuVO : baseMenu) {
            if (childMenu.get(menuVO.getMenuId()).size() > 0) {
                out.append("<div class='").append(isFirstMenu ? "unit current" : "unit").append("'>");
                out.append("<h5>").append(menuVO.getMenuName()).append("</h5>");
                out.append("<ul>");
                for (MenuVO childMenuVO : childMenu.get(menuVO.getMenuId())) {
                    out.append("<li><a ").append(isFirstMenu ? "id='defalut' " : "").append("href='").append(Path.getContextPath())
                        .append(childMenuVO.getMenuUrl());
                    out.append("' target='CONTENT_MAIN'>").append(childMenuVO.getMenuName()).append("</a></li>");
                    isFirstMenu = false;
                }
                out.append("</ul>");
                out.append("</div>");
            }
        }
        pageContext.getOut().write(out.toString());
    }
    
    /**
     * 获取根菜单列表
     * 
     * @param menus 菜单信息
     * @return 根菜单信息
     */
    private List<MenuVO> getBaseMenu(List<MenuVO> menus) {
        List<MenuVO> result = new ArrayList<MenuVO>();
        for (MenuVO menuVO : menus) {
            if (menuVO.getParentMenuId() == 0) {
                result.add(menuVO);
            }
        }
        return result;
    }
    
    /**
     * 获取根菜单与子菜单的对应列表
     * 
     * @param baseMenu 根菜单集合
     * @param menus 菜单集合
     * @return 菜单Map集合
     */
    private Map<Integer, List<MenuVO>> getBaseMenuMappingChild(List<MenuVO> baseMenu, List<MenuVO> menus) {
        Map<Integer, List<MenuVO>> result = new HashMap<Integer, List<MenuVO>>();
        // 组装根节点的MAP信息
        for (MenuVO menuVO : baseMenu) {
            result.put(menuVO.getMenuId(), new ArrayList<MenuVO>());
        }
        
        // 循环将子菜单与父菜单对应成MAP列表
        for (MenuVO menuVO : menus) {
            if (menuVO.getParentMenuId() == 0 || result.get(menuVO.getParentMenuId()) == null) {
                continue;
            }
            result.get(menuVO.getParentMenuId()).add(menuVO);
        }
        return result;
    }
    
}
