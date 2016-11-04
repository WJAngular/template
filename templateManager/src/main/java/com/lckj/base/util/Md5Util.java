
package com.lckj.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lckj.base.systeminit.AppCache;

/**
 * 
* @ClassName: Md5Util 
* @Description: md5加密工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:09:35 
*
 */
public class Md5Util {
    
    /** digest */
    private static MessageDigest digest = null;
    
    /**
     * 获取加密后的默认密码
     * 
     * @return 加密后的密码
     */
    public static String getDefaultPassword() {
        return Md5Util.hash(AppCache.getConfigMap().get("defaultPassword"));
    }
    
    /**
     * hash
     * 
     * @param data data
     * @return hash
     */
    public static final synchronized String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException nsae) {
                System.err.println("Failed to load the MD5 MessageDigest. Jive will be unable to function normally.");
                
                nsae.printStackTrace();
            }
        }
        
        digest.update(data.getBytes());
        return toHex(digest.digest());
    }
    
    /**
     * 字符转hex
     * 
     * @param hash hash
     * @return 转换后的字符
     */
    public static final String toHex(byte[] hash) {
        StringBuffer buf = new StringBuffer(hash.length * 2);
        String stmp = "";
        
        for (int i = 0; i < hash.length; i++) {
            stmp = Integer.toHexString(hash[i] & 0xFF);
            if (stmp.length() == 1)
                buf.append(0).append(stmp);
            else
                buf.append(stmp);
        }
        return buf.toString();
    }
    
    /**
     * hex转字节
     * 
     * @param hex hex
     * @return 转换后的字符
     */
    public static final byte[] hexToBytes(String hex) {
        if (hex == null)
            return new byte[0];
        int len = hex.length();
        byte[] bytes = new byte[len / 2];
        String stmp = null;
        try {
            for (int i = 0; i < bytes.length; i++) {
                stmp = hex.substring(i * 2, i * 2 + 2);
                bytes[i] = (byte) Integer.parseInt(stmp, 16);
            }
        } catch (Exception e) {
            return new byte[0];
        }
        
        return bytes;
    }
}
