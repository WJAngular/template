package com.lckj.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 * 
* @ClassName: IpUtil 
* @Description: ip操作帮助类 
* @author: WUJING 
* @date :2016-06-10 上午11:08:39 
*
 */
public class IpUtil {
    
    /**
     * 输出打印日志信息
     */
    private final static Logger LOGGER = Logger.getLogger(IpUtil.class);
    
    /**
     * 获取采集站IP
     * 
     * @return 获取采集站IP
     */
    public static String getCollectionIp() {
        String collectionIp = "";
        try {
            collectionIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.error("获取采集站IP失败" + e.getMessage());
        }
        return collectionIp;
    }
}
