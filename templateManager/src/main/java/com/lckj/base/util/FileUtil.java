
package com.lckj.base.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;

import com.lckj.core.web.Path;

/**
 * 
* @ClassName: FileUtil 
* @Description: 文件操作工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:08:20 
*
 */
public class FileUtil {
    
    /**
     * 获取允许上传的文件类型
     * 
     * @return 文件类型集合
     */
    public static HashMap<String, String> getFileType() {
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,mp4,mkv,3gp");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
        extMap.put("workfile", "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,mp4,mkv,3gp");
        return extMap;
    }
    
    /**
     * 获取excel模版路径
     * 
     * @return 模版路径
     */
    public static String getExcelTemplatePath() {
        return Path.getPhysicalPath() + "template" + File.separator + "exceltemplate" + File.separator;
    }
    
    /**
     * 获取word模版路径
     * 
     * @return 模版路径
     */
    public static String getWordTemplatePath() {
        return Path.getPhysicalPath() + "template" + File.separator + "wordtemplate" + File.separator;
    }
    
    /**
     * 获取代码生成工具模版路径
     * 
     * @return 模版路径
     */
    public static String getCodeTemplatePath() {
        return Path.getPhysicalPath() + "template" + File.separator + "codetemplate" + File.separator;
    }
    
    /**
     * 获取生成文件模版路径
     * 
     * @param module 模块名称
     * @return 模版路径
     */
    public static String getGeneratePath(String module) {
        return Path.getPhysicalPath() + "savefiles" + File.separator + module + File.separator;
    }
    
    /**
     * 获取相关附件对应的文件夹路径 complaint：投诉建议 decoration：装修 repair:装修 checkroom：验房
     * 
     * @param fileType 文件类型
     * @return 模版路径
     */
    public static String getPropertyPhysicalPath(String fileType) {
        String filePath = Path.getPhysicalPath() + "savefiles/" + fileType + "/";
        File myFilePath = new File(filePath);
        if (!myFilePath.exists()) {
            myFilePath.mkdirs();
        }
        return filePath;
    }
    
    /**
     * 获取相关附件对应的文件夹路径 complaint：投诉建议 decoration：装修 repair:装修 checkroom：验房
     * 
     * @param fileType 文件类型
     * @return 模版路径
     */
    public static String getPropertyContextPath(String fileType) {
        return Path.getContextPath() + "savefiles/" + fileType + "/";
    }
    
    /**
     * 关闭操作流
     * 
     * @param sos 流对象
     */
    public static void closeIo(ServletOutputStream sos) {
        if (sos != null) {
            try {
                sos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭操作流
     * 
     * @param os 流对象
     */
    public static void closeIo(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭操作流
     * 
     * @param br 流对象
     * @param sos 流对象
     */
    public static void closeIo(BufferedReader br, ServletOutputStream sos) {
        if (sos != null) {
            try {
                sos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭操作流
     * 
     * @param br 流对象
     * @param os 流对象
     */
    public static void closeIo(BufferedReader br, OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭操作流
     * 
     * @param fis 流对象
     * @param os 流对象
     */
    public static void closeIo(FileInputStream fis, OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
