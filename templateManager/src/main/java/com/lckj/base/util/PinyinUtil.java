
package com.lckj.base.util;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * 
* @ClassName: PinyinUtil 
* @Description: 汉字转拼音帮助类 
* @author: WUJING 
* @date :2016-06-10 上午11:09:48 
*
 */
public class PinyinUtil {
    
    /**
     * 将汉字转换成拼音
     * 
     * @param name 汉字
     * @return 转换后的拼音
     */
    public static String HanyuToPinyin(String name) {
        String pinyinName = "";
        char[] nameChar = name.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if ((nameChar[i] == '±') || (nameChar[i] == '(') || (nameChar[i] == ')')) {
                continue;
            }
            if (nameChar[i] > '') {
                try {
                    pinyinName += net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
                } catch (Exception e) {
                    System.out.println(nameChar[i] + "转换出错！");
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }
    
    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        System.out.println(PinyinUtil.HanyuToPinyin("吴景"));
    }
}
