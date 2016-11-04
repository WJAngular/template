
package com.lckj.codefactory.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.lckj.codefactory.model.TableVO;
import com.lckj.codefactory.model.TemplateVO;
import com.lckj.core.web.Path;

/**
 * 
* @ClassName: GenerateEngine 
* @Description: 生成工具引擎 
* @author: WUJING 
* @date :2016-06-10 上午11:14:23 
*
 */
public class GenerateEngine {
    
    /** 模版引擎 */
    public static VelocityEngine ve = new VelocityEngine();
    
    /** 初始化模板引擎 */
    public static void initVelocityEngine() {
        ve = new VelocityEngine();
        ve.setProperty("resource.loader", "file");
        ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        ve.setProperty("file.resource.loader.cache", "false");
        // ve.setProperty("file.resource.loader.path", "D:/template/");
        ve.setProperty("file.resource.loader.path", Path.getPhysicalPath() + "resource/template\\codetemplate" + File.separator);
        ve.init();
    }
    
    /**
     * 根据表列表信息及模块名称生成相关代码
     * 
     * @param tableInfos 表集合
     * @param modelName 模块名称
     * @param codeTemplates 模版集合
     * @param author 作者
     */
    public static void generateCode(List<TableVO> tableInfos, String modelName, String codeTemplates, String author) {
        // 初始化模板引擎 
        initVelocityEngine();
        
        // 获取模板列表
        List<TemplateVO> allTemplates = TemplateInfo.getTemplates();
        List<TemplateVO> templates = new ArrayList<TemplateVO>();
        // 去掉不需要的模板
        for (TemplateVO templateVO : allTemplates) {
            if (codeTemplates.contains(templateVO.getSuffix())) {
                templates.add(templateVO);
            }
        }
        
        // 循环选择的表
        for (TableVO tableInfo : tableInfos) {
            // 循环待生成的模板
            for (TemplateVO codeTemplate : templates) {
                generateOneFile(tableInfo, modelName, codeTemplate, author);
            }
        }
    }
    
    /**
     * 生成单个文件
     * 
     * @param table 数据库表信息
     * @param modelName 模块 名称
     * @param codeTemplate 模版信息
     * @param author 作者
     */
    public static void generateOneFile(TableVO table, String modelName, TemplateVO codeTemplate, String author) {
        // String targetFileName = FilePathUtil.getTargetFile(table.getFirstUpperName(), codeTemplate, table.getLowerName(), table.getFilePath());
        String targetFileName = CodeFactoryUtil.generateFolder(table, modelName, codeTemplate);
        try {
            PrintWriter writer = null;
            if (codeTemplate.getSuffix().endsWith(".jsp") || codeTemplate.getSuffix().endsWith(".js")) {
                writer = new PrintWriter(targetFileName + table.getFirstLowerName() + codeTemplate.getSuffix(), "UTF-8");
            } else {
                writer = new PrintWriter(targetFileName + table.getFirstUpperName() + codeTemplate.getSuffix(), "UTF-8");
            }
            VelocityContext context = new VelocityContext();
            context.put("tableInfo", table);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            context.put("currDate", sdf.format(new Date(System.currentTimeMillis())));
            context.put("userName", author);
            context.put("flagDollar", "$");
            context.put("flagWell", "#");
            Template template = ve.getTemplate(codeTemplate.getTemplateFile(), "UTF-8");
            template.merge(context, writer);
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
    }
}
