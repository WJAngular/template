
package com.lckj.security.user.service;

import org.acegisecurity.providers.encoding.PasswordEncoder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.lckj.base.util.Crypto;

/**
 * 
* @ClassName: MyPasswordEncoder 
* @Description: 加密解密的操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:32:58 
*
 */
@Service
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * 加密
     * 
     * @param rawPass 加密后的密码
     * @param salt 盐值
     * @return 加密后的密码
     * @throws DataAccessException 错误
     * @see org.acegisecurity.providers.encoding.PasswordEncoder#encodePassword(java.lang.String, java.lang.Object)
     */
    @Override
    public String encodePassword(String rawPass, Object salt) throws DataAccessException {
        try {
            salt = null;
            return Crypto.encode(rawPass);
        } catch (Exception localException) {
        }
        throw new RuntimeException("Encode password error!");
    }
    
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {
        String pass1 = encPass;
        String pass2 = encodePassword(rawPass, salt);
        return pass1.equals(pass2);
    }
    
    /**
     * 解密
     * 
     * @param rawPass 解密后的密码
     * @param salt 盐值
     * @return 解密后的密码
     * @throws DataAccessException 错误
     */
    public String decodePassword(String rawPass, Object salt) throws DataAccessException {
        try {
            salt = null;
            return Crypto.decode(rawPass);
        } catch (Exception localException) {
        }
        throw new RuntimeException("Encode password error!");
    }
}
