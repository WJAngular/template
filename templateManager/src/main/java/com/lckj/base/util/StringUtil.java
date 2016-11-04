
package com.lckj.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
* @ClassName: StringUtil 
* @Description: 字符串工具处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:11:28 
*
 */
public class StringUtil {
    
    /** publickeyString */
    private static String publickeyString = "308201B73082012C06072A8648CE3804013082011F02818100FD7F53811D75122952DF4A9C2EECE4E7F611B7523CEF4400C31E3F80B6512669455D402251FB593D8D58FABFC5F5BA30F6CB9B556CD7813B801D346FF26660B76B9950A5A49F9FE8047B1022C24FBBA9D7FEB7C61BF83B57E7C6A8A6150F04FB83F6D3C51EC3023554135A169132F675F3AE2B61D72AEFF22203199DD14801C70215009760508F15230BCCB292B982A2EB840BF0581CF502818100F7E1A085D69B3DDECBBCAB5C36B857B97994AFBBFA3AEA82F9574C0B3D0782675159578EBAD4594FE67107108180B449167123E84C281613B7CF09328CC8A6E13C167A8B547C8D28E0A3AE1E2BB3A675916EA37F0BFA213562F1FB627A01243BCCA4F1BEA8519089A883DFE15AE59F06928B665E807B552564014C3BFECF492A038184000281803B0A2EB6D4B0222FE203804D91472C1409A7A0BE618F3A6B230DD86CF83E07FA03EC07CA7634EBD25B0AC623B007E76161B4E7C8C21930A2049642A5841BE041CF906114D3192DF6264B8967755A699CE526C3799699809708D93F8854F62236180CFD869F9C6A0C2D54A6679D4C795F0C046F3E18B522F30A0A7095A5954EFF";
    
    /** digest */
    private static MessageDigest digest = null;
    
    /**
     * getPublicKeyString
     * 
     * @return publickeyString
     */
    public static String getPublicKeyString() {
        return publickeyString;
    }
    
    /**
     * 字符串转换
     * 
     * @param line line
     * @param oldString oldString
     * @param newString newString
     * @return newString
     */
    public static final String replace(String line, String oldString, String newString) {
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = line.indexOf(oldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }
    
    /**
     * escapeHTMLTags
     * 
     * @param input input
     * @return input
     */
    public static final String escapeHTMLTags(String input) {
        if ((input == null) || (input.length() == 0)) {
            return input;
        }
        StringBuffer buf = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            switch (ch) {
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                case '"':
                    buf.append("&quot;");
                    break;
                default:
                    buf.append(ch);
            }
        }
        return buf.toString();
    }
    
    /**
     * js转码
     * 
     * @param input input
     * @return input
     */
    public static final String escapeJS(String input) {
        if ((input == null) || (input.length() == 0)) {
            return input;
        }
        StringBuffer buf = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            switch (ch) {
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                case '"':
                    buf.append("&quot;");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                case '\r':
                    buf.append("\\r");
                    break;
                case '\n':
                    buf.append("\\n");
                    break;
                default:
                    buf.append(ch);
            }
        }
        return buf.toString();
    }
    
    /**
     * html转码
     * 
     * @param input input
     * @return input
     */
    public static final String escapeJsHtml(String input) {
        if ((input == null) || (input.length() == 0)) {
            return input;
        }
        StringBuffer buf = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            switch (ch) {
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                case '"':
                    buf.append("&quot;");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                case '\r':
                    buf.append("\\r");
                    break;
                case '\n':
                    buf.append("\\n");
                    break;
                case '\'':
                    buf.append("\\'");
                    break;
                default:
                    buf.append(ch);
            }
        }
        return buf.toString();
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
    
    /**
     * xml字符转码
     * 
     * @param param 参数
     * @return 转码后的字符串
     */
    public static final String escapeForXML(String param) {
        if ((param == null) || (param.length() == 0)) {
            return param;
        }
        char[] sArray = param.toCharArray();
        StringBuffer buf = new StringBuffer(sArray.length);
        
        for (int i = 0; i < sArray.length; i++) {
            char ch = sArray[i];
            if (ch == '<') {
                buf.append("&lt;");
            } else if (ch == '>') {
                buf.append("&gt;");
            } else if (ch == '"') {
                buf.append("&quot;");
            } else if (ch == '&') {
                buf.append("&amp;");
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }
    
    /**
     * 字符串反转码
     * 
     * @param parm 参数
     * @return 反转码后的字符串
     */
    public static final String unescapeFromXML(String parm) {
        String result = parm;
        result = replace(parm, "&lt;", "<");
        result = replace(parm, "&gt;", ">");
        result = replace(parm, "&quot;", "\"");
        return replace(result, "&amp;", "&");
    }
}
