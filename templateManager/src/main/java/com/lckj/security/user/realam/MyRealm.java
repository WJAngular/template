
package com.lckj.security.user.realam;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.core.orm.util.StringUtil;
import com.lckj.security.user.model.UserVO;
import com.lckj.security.user.service.UserService;

/**
 * 
* @ClassName: MyRealm 
* @Description: 用户授权控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:32:33 
*
 */
public class MyRealm extends AuthorizingRealm {
    
    /** log日志 */
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
    
    /** 注入用户操作接口 */
    @Autowired
    UserService userService;
    
    /**
     * 授权信息
     * 
     * <pre>
     *      授权，即权限验证,验证某个已认证的用户是否拥有某个权限, 即判断用户是否能做事情
     *      常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限
     * </pre>
     * 
     * <pre>
     *      主体（Subject）:即访问应用的用户，在Shiro中使用Subject代表该用户。用户只有授权后才允许访问相应的资源
     *      资源（Resource）:在应用中用户可以访问的任何东西，比如访问JSP 页面、查看/编辑某些数据、访问某个业务方法、打印文本等等都是资源。用户只要授权后才能访问
     *      权限（Permission）安全策略中的原子授权单位，通过权限我们可以表示在应用中用户有没有操作某个资源的权力。即权限表示在应用中用户能不能访问某个资源，如：查看/新增/修改/删除用户数据（即很多时候都是CRUD（增查改删）式权限控制）
     *      角色（Role）:角色代表了操作集合，可以理解为权限的集合，一般情况下我们会赋予用户角色而不是权限，即这样用户可以拥有一组权限，赋予权限时比较方便。典型的如：项目经理、技术总监、CTO、开发工程师等都是角色，不同的角色拥有一组不同的权限。
     * </pre>
     * 
     * @param principals 权限信息
     * @return 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        SimpleCondition condition = new SimpleCondition();
        condition.orderDesc("accountId");
        condition.andLike("accountName", userName);
        log.info("MyRealm.doGetAuthenticationInfo success! user_name: {}", userName);
        return null;
    }

	/** 
	* @Title: doGetAuthenticationInfo 
	* @Description: TODO
	* @param: @param token
	* @param: @return
	* @param: @throws AuthenticationException 
	* @throws 
	*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        UserVO user = new UserVO();
        user.setAccount(token.getUsername());
        user.setPassword(String.valueOf(token.getPassword()));
        if (StringUtil.isNotBlank(userName)) {
            user = userService.getLoginUser(user);
            if (user != null) {
                return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            }
        }
		return null;
	}
}
