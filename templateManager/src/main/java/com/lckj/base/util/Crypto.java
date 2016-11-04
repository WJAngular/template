
package com.lckj.base.util;

/**
 * 
* @ClassName: Crypto 
* @Description: TODO 
* @author: WUJING 
* @date :2016-06-10 上午11:07:29 
*
 */
public class Crypto {
    
    /** CKEY */
    private static String CKEY = "bRigHtCn";
    
    /**
     * encodeByKey
     * 
     * @param keyStr keyStr
     * @param str str
     * @return toHex
     * @throws Exception Exception
     */
    public static String encodeByKey(String keyStr, String str) throws Exception {
        byte[] key = keyStr.getBytes();
        return StringUtil.toHex(DES.encode(str.getBytes(), key));
    }
    
    /**
     * decodeByKey
     * 
     * @param keyStr keyStr
     * @param str str
     * @return decode
     * @throws Exception Exception
     */
    public static String decodeByKey(String keyStr, String str) throws Exception {
        byte[] key = keyStr.getBytes();
        return new String(DES.decode(StringUtil.hexToBytes(str), key));
    }
    
    /**
     * encode
     * 
     * @param str str
     * @return encodeByKey
     * @throws Exception Exception
     */
    public static String encode(String str) throws Exception {
        return encodeByKey(CKEY, str);
    }
    
    /**
     * decode
     * 
     * @param str str
     * @return decodeByKey
     * @throws Exception Exception
     */
    public static String decode(String str) throws Exception {
        return decodeByKey(CKEY, str);
    }
    
    /**
     * main
     * 
     * @param args args
     */
    public static void main(String[] args) {
        try {
            System.out.println(encode("888888"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
 * Location: F:\PVM\VideoManager\web\WEB-INF\classes\ Qualified Name: cn.com.bright.util.Crypto JD-Core Version: 0.6.0
 */
