
package com.lckj.codefactory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lckj.codefactory.model.GenerateVO;
import com.lckj.codefactory.service.CodeFactoryService;
import com.lckj.codefactory.util.GenerateEngine;

/**
 * 
* @ClassName: CodeFactoryController 
* @Description: 生成工具控制类 
* @author: WUJING 
* @date :2016-06-10 上午11:13:05 
*
 */
@Controller
public class CodeFactoryController {
    
    /** 注入业务逻辑处理类 */
    @Autowired
    CodeFactoryService service;
    
    /**
     * 数据库链接操作
     * 
     * @param model 数据模型
     * @param generateVO 生成工具实体类
     * @return 跳转链接
     */
    @RequestMapping("/codefactory/connect.do")
    public String tableList(Model model, GenerateVO generateVO) {
        List<String> tableNames = service.listTableNames(generateVO);
        model.addAttribute("tableNames", tableNames);
        model.addAttribute("dbInfo", generateVO);
        return "/codefactory/codeFactoryIndex";
    }
    
    /**
     * 生成代码操作
     * 
     * @param model 数据模型
     * @param generateVO 生成工具实体类
     * @return 跳转链接
     */
    @RequestMapping("/codefactory/generate.do")
    public String tabledetailList(Model model, GenerateVO generateVO) {
        try {
            GenerateEngine.generateCode(service.readTableList(generateVO), generateVO.getModelName(), generateVO.getCodeTemplate(),
                generateVO.getAuthor());
            model.addAttribute("message", generateVO.getGenerateTable() + " 代码生成成功");
            model.addAttribute("dbInfo", generateVO);
        } catch (Exception ex) {
            model.addAttribute("message", generateVO.getGenerateTable() + " 代码生成失败");
            model.addAttribute("dbInfo", generateVO);
        }
        return "/codefactory/codeFactoryIndex";
    }
}
