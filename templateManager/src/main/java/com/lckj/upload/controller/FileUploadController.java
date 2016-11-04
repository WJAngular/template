
package com.lckj.upload.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.lckj.base.util.DateUtil;
import com.lckj.base.util.FileUtil;

/**
 * 
* @ClassName: FileUploadController 
* @Description: 文件上传 
* @author: WUJING 
* @date :2016-06-10 上午11:33:24 
*
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    
    /**
     * springMVC方式上传文件 使用控件进行文件上传(多文件上传)
     * 
     * @param request request对象
     * @param response response 对象
     * @param model model
     * @param fileType 文件类型
     * @throws IllegalStateException 异常
     * @throws IOException IO异常
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public void fileUpload(HttpServletRequest request, HttpServletResponse response, Model model, String fileType) {
        try {
            PrintWriter pw = response.getWriter();
            String filePath = FileUtil.getPropertyPhysicalPath(fileType);
            String imgPath = "";
            String fileNameAll = "";// 上传后文件名称
            // 创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            // 判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;// 转换成多部分request
                Iterator<String> iter = multiRequest.getFileNames();// 取得request中的所有文件名
                String myFileName = "";
                String subFileName = "";
                String suffix = "";
                MultipartFile file = null;
                while (iter.hasNext()) {
                    file = multiRequest.getFile(iter.next());// 取得上传文件
                    if (file == null) {
                        continue;
                    }
                    // 取得当前上传文件的文件名称
                    myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if ("".equals(myFileName)) {
                        continue;
                    }
                    // 解析上传文件信息，如上传文件为：记事本.txt、subFileName即是：记事本、suffix即是txt
                    subFileName = myFileName.substring(0, myFileName.lastIndexOf("."));
                    suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
                    // 重命名上传后的文件名（文件名+yyyyMMddHHmmss格式的时间序列+文件后缀，如：记事本_20160129010101.txt）
                    fileNameAll = subFileName + "_" + DateUtil.getCurrDateTime() + "." + suffix; // 保存后的文件名称
                    file.transferTo(new File(filePath + fileNameAll));
                    imgPath = FileUtil.getPropertyContextPath(fileType) + fileNameAll;
                }
            }
            pw.print("{\"jsonrpc\" : \"2.0\", \"result\" : null,\"filePath\":\"" + imgPath + "\", \"id\" : \"id\",\"fileName\":\"" + fileNameAll
                + "\"}");
            pw.flush();
            pw.close();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 跳转上传页面
     * 
     * @param checkInfo 验证
     * @param limit 限制大小
     * @param callBackFunctionName callback方法
     * @param callBackParamsString callback参数
     * @param isCreateImg isCreateImg
     * @param width width
     * @param height height
     * @param fileType 文件夹名称类型
     * @return 页面路径
     */
    @RequestMapping("/uploadInit")
    public ModelAndView toUpload(String checkInfo, String limit, String callBackFunctionName, String callBackParamsString, String isCreateImg,
        String width, String height, String fileType) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("checkInfo", checkInfo);
        modelAndView.addObject("fileType", fileType);
        modelAndView.addObject("limit", limit);
        modelAndView.addObject("callBackFunctionName", callBackFunctionName);
        modelAndView.addObject("callBackParamsString", callBackParamsString);
        
        if ("true".equals(isCreateImg)) {
            modelAndView.addObject("isCreateImg", isCreateImg);
            modelAndView.addObject("width", width);
            modelAndView.addObject("height", height);
        }
        modelAndView.setViewName("/upload/fileUpload");
        return modelAndView;
    }
    
    /**
     * springMVC方式上传文件
     * 
     * @param request request对象
     * @param response response 对象
     * @param model model
     * @param fileType 文件夹类型()
     * @return 跳转
     * @throws IllegalStateException 异常
     * @throws IOException IO异常
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, Model model, String fileType) {
        try {
            String filePath = FileUtil.getPropertyPhysicalPath(fileType);
            String imgPath = "";
            String fileNameAll = "";// 上传后文件名称
            // 创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            // 判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                // 转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                // 取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                String myFileName = "";
                String subFileName = "";
                String suffix = "";
                MultipartFile file = null;
                while (iter.hasNext()) {
                    file = multiRequest.getFile(iter.next());
                    if (file == null) {
                        continue;
                    }
                    // 取得当前上传文件的全文件名称(如：记事本.txt)
                    myFileName = file.getOriginalFilename();
                    if ("".equals(myFileName)) {
                        continue;
                    }
                    // 解析上传文件信息，如上传文件为：记事本.txt、subFileName即是：记事本、suffix即是txt
                    subFileName = myFileName.substring(0, myFileName.lastIndexOf("."));
                    suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
                    // 重命名上传后的文件名（文件名+yyyyMMddHHmmss格式的时间序列+文件后缀，如：记事本_20160129010101.txt）
                    fileNameAll = subFileName + "_" + DateUtil.getCurrDateTime() + "." + suffix; // 保存后的文件名称
                    file.transferTo(new File(filePath + fileNameAll));
                    imgPath = FileUtil.getPropertyContextPath(fileType) + fileNameAll;
                }
            }
            setRequestToModel(request, model);
            model.addAttribute("success", "y");
            model.addAttribute("imgPath", imgPath);
            model.addAttribute("fileNameAll", fileNameAll);
            return "/upload/fileUpload";
        } catch (Exception ex) {
            return "/upload/fileUpload";
        }
    }
    
    /**
     * 将request中的参数设置到paramMap中去
     * 
     * @param request request
     * @param model model
     */
    protected void setRequestToModel(HttpServletRequest request, Model model) {
        Enumeration<String> keyNames = request.getParameterNames();
        while (keyNames.hasMoreElements()) {
            String attrName = keyNames.nextElement();
            model.addAttribute(attrName, request.getParameter(attrName));
        }
    }
    
    /**
     * 将request 放到Map
     * 
     * @param request request
     * @param model map
     */
    protected void setRequestToMap(HttpServletRequest request, Map<String, Object> model) {
        Enumeration<String> keyNames = request.getParameterNames();
        while (keyNames.hasMoreElements()) {
            String attrName = keyNames.nextElement();
            model.put(attrName, request.getParameter(attrName));
        }
    }
}
