
package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.lckj.base.util.Crypto;

/**
 * 
* @ClassName: PropertiesUtil 
* @Description:  properties文件操作工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:33:58 
*
 */
public class PropertiesUtil {
    
    /** 日志参数 ***/
    public static Logger logger = Logger.getLogger(PropertiesUtil.class);
    
    /**
     * 获取配置文件相关信息
     * 
     * @param fileName properties 文件名称
     * @param key 需要获取的properties属性
     * @return 配置文件信息集合
     */
    public static Map<String, String> getConfigByProperties(String fileName, String key) {
        Map<String, String> result = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream in = PropertiesUtil.class.getResourceAsStream("../" + fileName);
        try {
            prop.load(in);
        } catch (IOException e) {
            logger.error("读取配置" + fileName + "文件失败，" + e.getMessage());
        }
        String[] keys = key.split("、");
        for (String item : keys) {
            String propertieValue = prop.getProperty(item, "");
            if (propertieValue.length() > 0) {
                result.put(item, propertieValue.trim());
            }
        }
        return result;
    }
    
    /**
     * 测试加密
     * 
     * @param args 字符
     */
    public static void main(String[] args) {
        // MyPasswordEncoder passwordEncoder = new MyPasswordEncoder();
        try {
            System.out.println(Crypto.decode("752280bcbd1864ac"));
            System.out.println(Crypto.encode("111"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(passwordEncoder.encodePassword("123456", null));
        // System.out.println(passwordEncoder.decodePassword("84092879509914b8", null));
    }
}
