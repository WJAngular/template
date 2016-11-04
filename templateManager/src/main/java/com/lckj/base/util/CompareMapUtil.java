
package com.lckj.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lckj.base.BaseConstant;

/**
 * 
* @ClassName: CompareMapUtil 
* @Description: 查询返回工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:07:05 
*
 */
public class CompareMapUtil {
    
    /**
     * 组装查询操作返回对象
     * 
     * @return 操作返回对象
     */
    public static HashMap<String, Object> compareSuccessMapCode() {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("returncode", BaseConstant.RETURN_CODE_SUCCESS);
        return resultMap;
    }
    
    /**
     * 组装查询操作返回对象
     * 
     * @param lstVO 操作返回对象
     * @return 操作返回对象
     */
    public static HashMap<String, Object> compareSuccessMapResult(List<?> lstVO) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        if (null != lstVO) {
            resultMap.put("list", lstVO);
        }
        resultMap.put("returncode", BaseConstant.RETURN_CODE_SUCCESS);
        return resultMap;
    }
    
    /**
     * 组装统计时间参数
     * 
     * @param param 统计时间参数
     * @return 统计时间参数
     */
    public static Map<String, Object> compareStatDate(String param) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("statDate", param);
        return result;
    }
}
