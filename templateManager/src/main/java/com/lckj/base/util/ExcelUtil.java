package com.lckj.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lckj.core.web.Path;

/**
 * 
* @ClassName: ExcelUtil 
* @Description: Excel操作工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:08:08 
*
 */
public class ExcelUtil {
    
    /**
     * 获取excel导出模版路径
     * 
     * @return excel模版路径
     */
    public static String getExcelTemplatePath() {
        return Path.getPhysicalPath() + "resource" + File.separator + "template" + File.separator + "exceltemplate" + File.separator;
    }
    
    /**
     * 获取excel临时文件存储路径
     * 
     * @return excel临时文件存储路径
     */
    public static String getExcelSavePath() {
        return Path.getPhysicalPath() + "resource" + File.separator + "template" + File.separator + "savefiles" + File.separator;
    }
    
    /**
     * 下载excel模版
     * 
     * @param fileName 文件名称
     * @param innerPath 路径
     * @param request request
     * @param response response
     */
    public static void downExcelTemp(String fileName, String innerPath, HttpServletRequest request, HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/download;charset=utf-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            String strInnerPath = (innerPath == null || "".equals(innerPath.trim())) ? "" : innerPath + File.separator;
            String filePath = FileUtil.getExcelTemplatePath() + strInnerPath + fileName;
            fis = new FileInputStream(new File(filePath));
            os = response.getOutputStream();
            byte[] b = new byte[1024];
            while (fis.read(b) != -1) {
                os.write(b);
            }
            os.flush();
        } catch (Exception ex) {
            System.out.println("下载文件失败" + ex.getMessage());
        } finally {
            FileUtil.closeIo(fis, os);
        }
    }
}
