package com.lckj.base.util;

import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

/**
 * 
* @ClassName: DES 
* @Description: 加密解密工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:07:59 
*
 */
public class DES {
    
    /** Algorithm */
    private static String Algorithm = "DES";
    
    static {
        Security.addProvider(new SunJCE());
    }
    
    /**
     * getKey
     * 
     * @return key
     * @throws Exception Exception
     */
    public static byte[] getKey() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
        SecretKey deskey = keygen.generateKey();
        
        return deskey.getEncoded();
    }
    
    /**
     * encode
     * 
     * @param input input
     * @param key key
     * @return cipherByte
     * @throws Exception Exception
     */
    public static byte[] encode(byte[] input, byte[] key) throws Exception {
        SecretKey deskey = new SecretKeySpec(key, Algorithm);
        
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(1, deskey);
        byte[] cipherByte = c1.doFinal(input);
        
        return cipherByte;
    }
    
    /**
     * decode
     * 
     * @param input input
     * @param key key
     * @return clearByte
     * @throws Exception Exception
     */
    public static byte[] decode(byte[] input, byte[] key) throws Exception {
        SecretKey deskey = new SecretKeySpec(key, Algorithm);
        
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(2, deskey);
        
        byte[] clearByte = c1.doFinal(input);
        
        return clearByte;
    }
    
    /**
     * md5
     * 
     * @param input input
     * @return digest
     * @throws Exception Exception
     */
    public static byte[] md5(byte[] input) throws Exception {
        MessageDigest alg = MessageDigest.getInstance("MD5");
        
        alg.update(input);
        byte[] digest = alg.digest();
        
        return digest;
    }
}
