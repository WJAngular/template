
package com.lckj.base.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;

import com.lckj.base.systeminit.EnviromentInfo;
import com.lckj.security.user.model.UserVO;
import com.lckj.security.user.service.UserService;

/**
 * 
* @ClassName: OperationTag 
* @Description: 操作权限标签 
* @author: WUJING 
* @date :2016-06-10 上午11:06:17 
*
 */
public class OperationTag extends ConditionalTagSupport {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    /** 操作编码 */
    private String operationCode;
    
    @Override
    protected boolean condition() throws JspTagException {
        Subject currentUser = SecurityUtils.getSubject();
        UserVO user = (UserVO) currentUser.getPrincipal();
        ApplicationContext ctx = EnviromentInfo.getWebApplicationContext();
        UserService userService = ctx.getBean(UserService.class);
        Map<String, String> condition = new HashMap<String, String>();
        condition.put("userId", String.valueOf(user.getUserId()));
        condition.put("operationCode", operationCode);
        boolean hasPermission = userService.hasPermission(condition);
        return hasPermission;
    }
    
    /**
     * 获取操作编码
     * 
     * @return 操作编码
     */
    public String getOperationCode() {
        return operationCode;
    }
    
    /**
     * 设值操作编码
     * 
     * @param operationCode 操作编码
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }
}
