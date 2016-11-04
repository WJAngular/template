
package com.lckj.codefactory.util;

import java.util.ArrayList;
import java.util.List;

import com.lckj.codefactory.model.TemplateVO;

/**
 * 使用说明： 生成代码时，仅需修改前三个静态成员变量： PACKET_PATH-生成代码的路径 TABLE_NAME-表的名字 MODEL_NAME-模型的名字 轻易不要换掉第四个静态成员变量FILE_PATH，因为生成的代码会覆盖原有代码。 建议生成的代码先放在临时环境中,然后在Package
 * Explorer选中生成的代码和目标代码: 右键->Compare With->Each Other,进行比较。
 */
public class TemplateInfo {
    
    /** 基础路径 */
    private static final String basePath = "";// Path.getPhysicalPath() + "codetemplate" + File.separator;
    
    /**
     * 获取模版集合
     * 
     * @return 模版集合
     */
    public static List<TemplateVO> getTemplates() {
        List<TemplateVO> templates = new ArrayList<TemplateVO>();
        
        TemplateVO template = new TemplateVO();
        template.setTemplateFile(basePath + "Controller.java.vm");
        template.setFloderName("/controller");
        template.setSuffix("Controller.java");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "Mapper.java.vm");
        template.setFloderName("/mapper");
        template.setSuffix("Mapper.java");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "Mapper.xml.vm");
        template.setFloderName("/mapper");
        template.setSuffix("Mapper.xml");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "Model.java.vm");
        template.setFloderName("/model");
        template.setSuffix("VO.java");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "Service.java.vm");
        template.setFloderName("/service");
        template.setSuffix("Service.java");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "List.jsp.vm");
        template.setFloderName("");
        template.setSuffix("List.jsp");
        templates.add(template);
        
        template = new TemplateVO();
        template.setTemplateFile(basePath + "List.js.vm");
        template.setFloderName("");
        template.setSuffix("List.js");
        templates.add(template);
        
        // template = new TemplateVO();
        // template.setTemplateFile(basePath + "Add.jsp.vm");
        // template.setFloderName("");
        // template.setSuffix("Add.jsp");
        // templates.add(template);
        //
        // template = new TemplateVO();
        // template.setTemplateFile(basePath + "Edit.jsp.vm");
        // template.setFloderName("");
        // template.setSuffix("Edit.jsp");
        // templates.add(template);
        //
        // template = new TemplateVO();
        // template.setTemplateFile(basePath + "Read.jsp.vm");
        // template.setFloderName("");
        // template.setSuffix("Read.jsp");
        // templates.add(template);
        
        return templates;
    }
}
