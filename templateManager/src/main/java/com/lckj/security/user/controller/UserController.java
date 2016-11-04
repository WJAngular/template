
package com.lckj.security.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lckj.base.model.PagerVO;
import com.lckj.base.util.BeanMapUtil;
import com.lckj.base.util.Md5Util;
import com.lckj.core.orm.PartitiveFields;
import com.lckj.core.orm.condition.SimpleCondition;
import com.lckj.security.user.model.UserVO;
import com.lckj.security.user.service.UserService;

/**
 * 
* @ClassName: UserController 
* @Description: 用户信息控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:31:50 
*
 */
@Controller
public class UserController {
    
    /** 注入用户业务操作类 */
    @Autowired
    UserService userService;
    
    /**
     * 查询用户信息
     * 
     * @param userVO 用户对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 用户数据列表
     */
    @RequestMapping("/user/list.do")
    @ResponseBody
    public PagerVO userList(UserVO userVO, PagerVO pagerVO, Model model) {
        try {
            SimpleCondition condition = new SimpleCondition();
            condition.orderDesc("userId");
            condition.andLike("userName", userVO.getUserName());
            condition.andLike("account", userVO.getAccount());
            condition.andBeginWith("deptCode", userVO.getDeptCode());
            pagerVO.setTotalRows(userService.count(condition));
            RowBounds rowBounds = new RowBounds(pagerVO.getStartRow(), pagerVO.getPageSize());
            pagerVO.setList(userService.list(condition, rowBounds));
        } catch (Exception ex) {
            pagerVO.setErrorCode();
        }
        return pagerVO;
    }
    
    /**
     * 读取用户信息
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/read.do")
    @ResponseBody
    public UserVO read(UserVO userVO, Model model) {
        UserVO result = null;
        try {
            result = userService.read(userVO.getUserId());
            // result.setPassword(myPasswordEncoder.decodePassword(result.getPassword(), null));
        } catch (Exception ex) {
            result.setErrorCode();
        }
        return result;
    }
    
    /**
     * 检查用户帐号是否重复
     * 
     * @param userVO 执法记录仪信息
     * @param model 数据模型
     * @return 用户帐号信息
     */
    @RequestMapping("/user/checkAccountRepeat.do")
    @ResponseBody
    public UserVO checkRepeat(UserVO userVO, Model model) {
        try {
            if (getRepeatCount(userVO) > 0) {
                userVO.setErrorMessage("此用户帐号已经存在，不能重复增加！");
                return userVO;
            }
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 获取用户帐号重复的数量
     * 
     * @param userVo 用户信息
     * @return 重复的数量
     */
    private int getRepeatCount(UserVO userVo) {
        SimpleCondition condition = new SimpleCondition();
        condition.andEqual("account", userVo.getAccount());
        condition.andNotEqualByParamGreaterZero("userId", userVo.getUserId());
        return userService.count(condition);
    }
    
    /**
     * 新增用户信息
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/add.do")
    @ResponseBody
    public UserVO add(UserVO userVO, Model model) {
        try {
            if (getRepeatCount(userVO) > 0) {
                userVO.setErrorMessage("此用户帐号已经存在，不能重复增加！");
                return userVO;
            }
            Subject currentUser = SecurityUtils.getSubject();
            UserVO user = (UserVO) currentUser.getPrincipal();
            userVO.setCreatorId(user.getUserId());
            userVO.setCreatorName(user.getUserName());
            userVO.setAccount(userVO.getAccount());
            // 获取Md5密码
            userVO.setPassword(Md5Util.getDefaultPassword());
            userService.insertPartitive(BeanMapUtil.beanToMap(userVO));
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 修改用户信息
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/update.do")
    @ResponseBody
    public UserVO update(UserVO userVO, Model model) {
        try {
            if (getRepeatCount(userVO) > 0) {
                userVO.setErrorMessage("此用户帐号已经存在，不能重复增加！");
                return userVO;
            } else {
                userService.updatePartitive(BeanMapUtil.beanToMap(userVO), userVO.getUserId());
            }
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 修改用户密码
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    // @RequestMapping("/user/updatepassword.do")
    // @ResponseBody
    // public UserVO updatepassword(UserVO userVO, Model model) {
    // try {
    // PartitiveFields fields = new PartitiveFields();
    // fields.put("account", userVO.getAccount());
    // fields.put("password", Md5Util.hash(userVO.getPassword()));
    // userService.updatePartitive(fields, userVO.getUserId());
    // } catch (Exception ex) {
    // userVO.setErrorCode();
    // }
    // return userVO;
    // }
    
    /**
     * 修改用户状态信息
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/changestate.do")
    @ResponseBody
    public UserVO changeState(UserVO userVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("status", userVO.getStatus());
            userService.updatePartitive(fields, userVO.getUserId());
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 获取用户信息
     * 
     * @param userVO 用户对象
     * @param pagerVO 分页对象
     * @param model 数据模型
     * @return 用户数据列表
     */
    // @RequestMapping("/user/printPassword.do")
    // @ResponseBody
    // public PagerVO read(UserVO userVO, PagerVO pagerVO, Model model) {
    // try {
    // if (StringUtil.isNotBlank(userVO.getPrintUserId())) {
    // SimpleCondition condition = new SimpleCondition();
    // condition.andIn("userId", userVO.getPrintUserId());
    // List<UserVO> users = userService.list(condition);
    // for (UserVO user : users) {
    // user.setPassword(myPasswordEncoder.decodePassword(user.getPassword(), null));
    // }
    // pagerVO.setList(users);
    // } else {
    // SimpleCondition condition = new SimpleCondition();
    // condition.andLike("userName", URLDecoder.decode(userVO.getUserName(), "utf-8"));
    // condition.andLike("account", userVO.getAccount());
    // condition.andBeginWith("deptCode", userVO.getDeptCode());
    // List<UserVO> users = userService.list(condition);
    // for (UserVO user : users) {
    // user.setPassword(myPasswordEncoder.decodePassword(user.getPassword(), null));
    // }
    // pagerVO.setList(users);
    //
    // }
    // } catch (Exception ex) {
    // pagerVO.setErrorCode();
    // }
    // return pagerVO;
    // }
    
    /**
     * 修改用户打印标识
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/changeprint.do")
    @ResponseBody
    public UserVO changePrint(UserVO userVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("printFlag", 2);
            userService.updatePartitive(fields, userVO.getUserId());
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 修改用户密码
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户对象
     */
    @RequestMapping("/user/modifyPassword.do")
    @ResponseBody
    public UserVO modifyPassword(UserVO userVO, Model model) {
        try {
            PartitiveFields fields = new PartitiveFields();
            fields.put("password", Md5Util.hash(userVO.getPassword()));
            userService.updatePartitive(fields, userVO.getUserId());
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 删除用户信息
     * 
     * @param userVO 用户信息
     * @param model 数据模型
     * @return 删除的记录数
     */
    @RequestMapping("/user/delete.do")
    @ResponseBody
    public UserVO delete(UserVO userVO, Model model) {
        try {
            userService.deleteUserAndRelation(userVO.getUserId());
        } catch (Exception ex) {
            userVO.setErrorCode();
        }
        return userVO;
    }
    
    /**
     * 查询用户对应的角色
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 用户角色列表
     */
    @RequestMapping("/user/query/role.do")
    @ResponseBody
    public Map<String, Object> queryUserMappingRole(UserVO userVO, Model model) {
        return userService.queryUserMappingRole(userVO);
    }
    
    /**
     * 给用户授权角色
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 授权的角色数
     */
    @RequestMapping("/user/mapping/role.do")
    @ResponseBody
    public int insertUserMappingRole(UserVO userVO, Model model) {
        return userService.insertUserMappingRole(userVO);
    }
    
    /**
     * 注销退出
     * 
     * @param request request
     * @return 注销后的跳转页面链接
     */
    @RequestMapping("/user/logout.do")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.jsp";
    }
    /**
     * 检查用户登陆
     * 
     * @param userVO 用户对象
     * @param model 数据模型
     * @return 检查用户名密码是否正确
     */
    @RequestMapping("/user/checklogin.do")
    @ResponseBody
    public UserVO checklogin(UserVO userVO, Model model) {
        UserVO result = new UserVO();
        try {
            result = userService.getLoginUser(userVO);
            if (result == null) {
                userVO.setErrorMessage("用户名或密码不正确，请重新输入！");
                return userVO;
            }
        } catch (Exception ex) {
            result.setErrorCode();
        }
        return result;
    }
}
