
package com.lckj.base.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.lckj.base.systeminit.AppCache;
import com.lckj.dictionary.model.DictionaryItemVO;

/**
 * 
* @ClassName: DictTag 
* @Description: 数据字典自定义标签 
* @author: WUJING 
* @date :2016-06-10 上午11:05:56 
*
 */
public class DictTag extends TagSupport {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    /** 字典名称 */
    private String name;
    
    /** 字典样式 */
    private String style;
    
    /** 类名称 */
    private String className;
    
    /** tab序号 */
    private String tabIndex;
    
    /** change事件 */
    private String onchange;
    
    /** 单击事件 */
    private String onclick;
    
    /** 数据类型 */
    private String datatype;
    
    /** 为空提示信息 */
    private String nullmsg;
    
    /** 错误提示信息 */
    private String errormsg;
    
    /** 是否只读 */
    private String readonly;
    
    /** 是否显示 */
    private String disabled;
    
    /** 选中的字典值，支持多个值,以","分割 */
    private String selectValue;
    
    /** 显示信息 */
    private Boolean showTip;
    
    /** 字典过滤项 */
    private String filterStr;
    
    /** 字典类型 */
    private String dictType;
    
    /** 是否降序 */
    private Boolean isDESC;
    
    /** 控件类型 */
    private String controlType;
    
    /** 控件类型 */
    private String defaultValue;
    
    /** 字典类型 - 选择框格式 */
    private static String CONTROL_TYPE_SELECT = "1";
    
    /** 字典类型 - 单选框格式 */
    private static String CONTROL_TYPE_RADIO = "2";
    
    /** 字典类型 - lable格式 */
    private static String CONTROL_TYPE_LABLE = "3";
    
    /** 字典类型 - 复选框格式 */
    private static String CONTROL_TYPE_CHECKBOX = "4";
    
    /** 字典类型 - 表单格式 */
    private static String CONTROL_TYPE_TABLEVALUE = "5";
    
    /** 字典类型 - json格式 */
    private static String CONTROL_TYPE_JSON = "6";
    
    /** 字典类型 - 文本格式 */
    private static String CONTROL_TYPE_TEXT = "7";
    
    /** 字典类型 - 文本格式 (多个值) */
    private static String CONTROL_TYPE_MULTI_TEXT = "8";
    
    @Override
    public int doStartTag() throws JspException {
        try {
            List<DictionaryItemVO> dictList = getDictListByTypeList(dictType);
            removeFilterForList(dictList);
            
            if (isDESC != null) {
                Collections.sort(dictList, new DictVOComparator(isDESC));
            }
            
            if (CONTROL_TYPE_SELECT.equals(controlType)) {
                generationSelectHTML(dictList);
            } else if (CONTROL_TYPE_RADIO.equals(controlType)) {
                generationRadioHTML(dictList);
            } else if (CONTROL_TYPE_LABLE.equals(controlType)) {
                generationLableHTML(dictList);
            } else if (CONTROL_TYPE_CHECKBOX.equals(controlType)) {
                generationCheckBoxHTML(dictList);
            } else if (CONTROL_TYPE_TABLEVALUE.equals(controlType)) {
                generationTableHTML(dictList);
            } else if (CONTROL_TYPE_JSON.equals(controlType)) {
                // StringBuilder sb=new StringBuilder("json|({'1':'aaaa','2':'bbbb','3':'cccc'})");
                StringBuilder sb = new StringBuilder("json|({");
                for (int i = 0; i < dictList.size(); i++) {
                    sb.append("'" + dictList.get(i).getItemValue() + "':'" + dictList.get(i).getItemName() + "'");
                    if (i < dictList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("})");
                pageContext.getOut().write(sb.toString());
            } else if (CONTROL_TYPE_TEXT.equals(controlType)) {
                for (DictionaryItemVO item : dictList) {
                    if (item.getItemName() != null && String.valueOf(item.getItemValue()).equals(this.selectValue)) {
                        pageContext.getOut().write(item.getItemName());
                    }
                }
            } else if (CONTROL_TYPE_MULTI_TEXT.equals(controlType)) {
                StringBuilder sbResult = new StringBuilder("");
                for (DictionaryItemVO item : dictList) {
                    if (item.getItemName() != null && String.valueOf(item.getItemValue()).equals(this.selectValue)) {
                        sbResult.append("");
                    }
                }
                pageContext.getOut().write(sbResult.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
    
    /**
     * 获取指定类型下的字典列表。<br>
     * 使用字典标签的时候，需要实现本方法。
     * 
     * @param dictTypeParam 字典类别
     * @return 字典明细集合
     */
    public List<DictionaryItemVO> getDictListByTypeList(final String dictTypeParam) {
        final List<DictionaryItemVO> dictList = AppCache.getDictMap().get(dictTypeParam);
        return dictList;
    }
    
    /**
     * 获取指定类型下的字典列表。<br>
     * 使用字典标签的时候，需要实现本方法。
     * 
     * @param currDictType 字典类别
     * @param parentType 父子点类别
     * @param parentValue 父子点值
     * @return 子字典清单
     */
    public List<DictionaryItemVO> getDictList(final String currDictType, String parentType, final String parentValue) {
        final List<DictionaryItemVO> dictList = AppCache.getDictMap().get(currDictType);
        CollectionUtils.select(dictList, new Predicate() {
            
            @Override
            public boolean evaluate(Object object) {
                DictionaryItemVO vo = (DictionaryItemVO) object;
                if (parentValue.equals(vo.getItemValue())) {
                    return true;
                }
                return false;
            }
        });
        return dictList;
    }
    
    /**
     * 删除指定filterStr存在的项。
     * 
     * @param dictList 待排除的字典列表
     */
    private void removeFilterForList(Collection<DictionaryItemVO> dictList) {
        if (filterStr != null && filterStr.trim().length() > 0) {
            String[] filterIds = filterStr.split(",");
            Iterator<DictionaryItemVO> iterator = dictList.iterator();
            while (iterator.hasNext()) {
                DictionaryItemVO item = iterator.next();
                for (String fid : filterIds) {
                    if (item.getDictionaryCode().equals(dictType) && String.valueOf(item.getItemValue()).equals(fid)) {
                        iterator.remove();
                    }
                }
            }
        }
    }
    
    /**
     * 生成LABLE控件。
     * 
     * @param dictList 字典列表
     * @throws IOException 异常
     */
    private void generationLableHTML(Collection<DictionaryItemVO> dictList) throws IOException {
        StringBuffer out = new StringBuffer();
        String[] values = null;
        if (null != selectValue && !"".equals(selectValue)) {
            values = selectValue.split(",");
        }
        out.append("<span");
        if (this.id != null)
            out.append(" id=\"" + this.id + "\"");
        if (this.name != null)
            out.append(" name=\"" + this.name + "\"");
        if (this.className != null)
            out.append(" class=\"" + this.className + "\"");
        out.append(">");
        if (values != null && values.length > 0) {
            String temp;
            for (int i = 0; i < values.length; i++) {
                temp = values[i];
                if (i > 0)
                    out.append("、");
                for (DictionaryItemVO item : dictList) {
                    if (temp.equals(item.getItemValue())) {
                        out.append(item.getItemName());
                        break;
                    }
                }
            }
        }
        out.append("</span>");
        pageContext.getOut().write(out.toString());
    }
    
    /**
     * 根据list内容动态输出该HTML脚本。<br>
     * 默认情况下会有“请选择...”选项,如果有默认选择值但在列表不存在，则会默认选择“请选择...”项;<br>
     * 如果showTip=false即“请选择...”，如果有默认选择值但不存在，将会默认选择第一项;<br>
     * <p>
     * 生成的示例： <SELECT id="participantType" name="participantType" onchange="showChange();" style="width:110px"> <OPTION VALUE="001" >个人</OPTION>
     * <OPTION VALUE="002" >企业</OPTION> </SELECT>
     * </p>
     * 
     * @param dictList 字典列表
     * @throws Exception 异常
     */
    private void generationSelectHTML(Collection<DictionaryItemVO> dictList) throws Exception {
        StringBuffer out = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        boolean isBeSelected = false;// 标识默认选择值是否存在
        
        out.append("<SELECT ");
        if (this.id != null)
            out.append(" id=\"" + this.id + "\"");
        if (this.name != null)
            out.append(" name=\"" + this.name + "\"");
        else
            throw new Exception("The 'name' attrib not null! ");
        if (this.className != null)
            out.append(" class=\"" + this.className + "\"");
        if (this.onchange != null)
            out.append(" onChange=\"" + this.onchange + "\"");
        if (this.datatype != null)
            out.append(" datatype=\"" + this.datatype + "\"");
        if (this.nullmsg != null)
            out.append(" nullmsg=\"" + this.nullmsg + "\"");
        if (this.errormsg != null)
            out.append(" errormsg=\"" + this.errormsg + "\"");
        if (this.readonly != null)
            out.append(" readonly=\"" + this.readonly + "\"");
        if (this.disabled != null)
            out.append(" disabled=\"" + this.disabled + "\"");
        if (this.tabIndex != null)
            out.append(" tabIndex=\"" + this.tabIndex + "\"");
        if (this.style != null)
            out.append(" style=\"" + this.style + "\"");
        out.append(">\n");
        
        for (DictionaryItemVO item : dictList) {
            if (item.getItemName() != null && String.valueOf(item.getItemValue()).equals(this.selectValue)) {
                isBeSelected = true;
                temp.append("<OPTION VALUE=\"" + item.getItemValue() + "\" dictionaryId=\"" + item.getDictionaryId() + "\" SELECTED>"
                    + item.getItemName() + "</OPTION>\n");
            } else {
                temp.append("<OPTION VALUE=\"" + item.getItemValue() + "\" dictionaryId=\"" + item.getDictionaryId() + "\" >" + item.getItemName()
                    + "</OPTION>\n");
            }
        }
        defaultValue = defaultValue == null ? "" : defaultValue;
        if (isBeSelected && (showTip == null || showTip)) {
            out.append("<OPTION  value=\"" + defaultValue + "\">请选择...</OPTION>\n");
        } else if (showTip == null || showTip) {
            out.append("<OPTION SELECTED value=\"" + defaultValue + "\">请选择...</OPTION>\n");
        }
        
        out.append(temp);
        out.append("</SELECT>\n");
        pageContext.getOut().write(out.toString());
    }
    
    /**
     * 根据list内容动态输出该HTML脚本。<br>
     * 
     * <pre>
     * 示例：
     * <div id="sex">
     * <INPUT TYPE="radio" name="sex" id="sex0" class="validate-one-required" tabIndex="2" code="1" value="17">男&nbsp;</INPUT>
     * <INPUT TYPE="radio" name="sex" id="sex1" class="validate-one-required" tabIndex="2" code="0" value="18">女&nbsp;</INPUT>
     * </div>
     * </pre>
     * 
     * @param dictList 字典列表
     * @throws Exception 异常
     */
    private void generationRadioHTML(Collection<DictionaryItemVO> dictList) throws Exception {
        StringBuffer out = new StringBuffer();
        
        int i = 0;// 用于组合ID
        out.append("<span id=\"" + this.id + "\">\n");
        for (DictionaryItemVO item : dictList) {
            i++;
            out.append("<INPUT TYPE=\"radio\" ");
            if (this.name != null)
                out.append(" name=\"" + this.name + "\"");
            else
                throw new Exception("The 'name' attrib not null! ");
            if (this.id != null)
                out.append(" id=\"" + this.id + i + "\"");
            if (this.className != null)
                out.append(" class=\"" + this.className + "\"");
            if (this.onchange != null)
                out.append(" onChange=\"" + this.onchange + "\"");
            if (this.onclick != null)
                out.append(" onClick=\"" + this.onclick + "\"");
            if (this.datatype != null)
                out.append(" datatype=\"" + this.datatype + "\"");
            if (this.nullmsg != null)
                out.append(" nullmsg=\"" + this.nullmsg + "\"");
            if (this.errormsg != null)
                out.append(" errormsg=\"" + this.errormsg + "\"");
            if (this.readonly != null)
                out.append(" readonly=\"" + this.readonly + "\"");
            if (this.disabled != null)
                out.append(" disabled=\"" + this.disabled + "\"");
            if (this.tabIndex != null)
                out.append(" tabIndex=\"" + this.tabIndex + "\"");
            if (this.style != null)
                out.append(" style=\"" + this.style + "\"");
            out.append(" dictionaryId=\"" + item.getDictionaryId() + "\"");
            out.append(" value=\"" + item.getItemValue() + "\"");
            if (this.selectValue != null && this.selectValue.equals(String.valueOf(item.getItemValue()))) {
                out.append(" checked=\"checked\" ");
            }
            out.append("><LABEL FOR=\"" + this.id + i + "\">&nbsp;" + item.getItemName() + "&nbsp;</LABEL>");
            out.append("</INPUT>\n");
        }
        out.append("</span>\n");
        pageContext.getOut().write(out.toString());
    }
    
    /**
     * 生成复选框格式的字典
     * 
     * @param dictList 字典列表
     * @throws Exception 异常
     */
    private void generationCheckBoxHTML(Collection<DictionaryItemVO> dictList) throws Exception {
        StringBuffer out = new StringBuffer();
        String[] selectValues = this.selectValue != null ? this.selectValue.split(",") : new String[] {};
        int i = 0;// 用于组合ID
        out.append("<span id=\"" + this.id + "\">\n");
        for (DictionaryItemVO item : dictList) {
            i++;
            out.append("<INPUT TYPE=\"checkbox\" ");
            if (this.name != null)
                out.append(" name=\"" + this.name + "\"");
            else
                throw new Exception("The 'name' attrib not null! ");
            if (this.id != null)
                out.append(" id=\"" + this.id + i + "\"");
            if (this.className != null)
                out.append(" class=\"" + this.className + "\"");
            if (this.onchange != null)
                out.append(" onChange=\"" + this.onchange + "\"");
            if (this.datatype != null)
                out.append(" datatype=\"" + this.datatype + "\"");
            if (this.nullmsg != null)
                out.append(" nullmsg=\"" + this.nullmsg + "\"");
            if (this.errormsg != null)
                out.append(" errormsg=\"" + this.errormsg + "\"");
            if (this.readonly != null)
                out.append(" readonly=\"" + this.readonly + "\"");
            if (this.disabled != null)
                out.append(" disabled=\"" + this.disabled + "\"");
            if (this.tabIndex != null)
                out.append(" tabIndex=\"" + this.tabIndex + "\"");
            if (this.style != null)
                out.append(" style=\"" + this.style + "\"");
            out.append(" value=\"" + item.getItemValue() + "\"");
            for (String value : selectValues) {
                if (value.trim().equals(String.valueOf(item.getItemValue()))) {
                    out.append("checked=\"checked\" ");
                }
            }
            // if(this.selectValue !=null && this.selectValue.equals(
            // String.valueOf(item.getItemValue()) ))
            // out.append("checked=\"checked\" ");
            out.append("><LABEL FOR=\"" + this.id + i + "\">&nbsp;" + item.getItemName() + "&nbsp;</LABEL>");
            out.append("</INPUT>\n");
        }
        out.append("</span>\n");
        pageContext.getOut().write(out.toString());
    }
    
    /**
     * 生成json格式的字典串
     * 
     * @param dictList 字典列表
     * @throws Exception 异常
     */
    private void generationTableHTML(List<DictionaryItemVO> dictList) throws Exception {
        StringBuffer out = new StringBuffer();
        String temp = "";
        try {
            out.append("{");
            for (DictionaryItemVO item : dictList) {
                out.append("'" + item.getItemValue() + "':'" + item.getItemName() + "',");
            }
            out.append("}");
            temp = out.substring(0, (out.toString().length() - 2)) + "}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageContext.getOut().write(temp);
    }
    
    /******************************************************************************************************/
    
    @Override
    public String getId() {
        return id;
    }
    
    /**
     * @return className
     */
    public String getClassName() {
        return className;
    }
    
    /**
     * @param className className
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return onchange
     */
    public String getOnchange() {
        return onchange;
    }
    
    /**
     * @param onchange onchange
     */
    public void setOnchange(String onchange) {
        this.onchange = onchange;
    }
    
    /**
     * @return selectValue
     */
    public String getSelectValue() {
        return selectValue;
    }
    
    /**
     * @param selectValue selectValue
     */
    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }
    
    /**
     * @return tabIndex
     */
    public String getTabIndex() {
        return tabIndex;
    }
    
    /**
     * @param tabIndex tabIndex
     */
    public void setTabIndex(String tabIndex) {
        this.tabIndex = tabIndex;
    }
    
    /**
     * @return showTip
     */
    public Boolean getShowTip() {
        return showTip;
    }
    
    /**
     * @param showTip showTip
     */
    public void setShowTip(Boolean showTip) {
        this.showTip = showTip;
    }
    
    /**
     * @return filterStr
     */
    public String getFilterStr() {
        return filterStr;
    }
    
    /**
     * @param filterStr filterStr
     */
    public void setFilterStr(String filterStr) {
        this.filterStr = filterStr;
    }
    
    /**
     * @return dictType
     */
    public String getDictType() {
        return dictType;
    }
    
    /**
     * @param dictType dictType
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
    
    /**
     * @return controlType
     */
    public String getControlType() {
        return controlType;
    }
    
    /**
     * @param controlType controlType
     */
    public void setControlType(String controlType) {
        this.controlType = controlType;
    }
    
    /**
     * @return isDESC
     */
    public Boolean getIsDESC() {
        return isDESC;
    }
    
    /**
     * @param isDESC isDESC
     */
    public void setIsDESC(Boolean isDESC) {
        this.isDESC = isDESC;
    }
    
    /**
     * @return style
     */
    public String getStyle() {
        return style;
    }
    
    /**
     * @param style style
     */
    public void setStyle(String style) {
        this.style = style;
    }
    
    /**
     * @return datatype
     */
    public String getDatatype() {
        return datatype;
    }
    
    /**
     * @param datatype datatype
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }
    
    /**
     * @return nullmsg
     */
    public String getNullmsg() {
        return nullmsg;
    }
    
    /**
     * @param nullmsg nullmsg
     */
    public void setNullmsg(String nullmsg) {
        this.nullmsg = nullmsg;
    }
    
    /**
     * @return errormsg
     */
    public String getErrormsg() {
        return errormsg;
    }
    
    /**
     * @param errormsg errormsg
     */
    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
    
    /**
     * @return onclick
     */
    public String getOnclick() {
        return onclick;
    }
    
    /**
     * @param onclick onclick
     */
    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }
    
    /**
     * @return defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }
    
    /**
     * @param defaultValue defaultValue
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}

/**
 * 字典表的排放比较器。
 */
class DictVOComparator implements Comparator<DictionaryItemVO> {
    
    /** 是否排序 */
    private final Boolean isDesc;
    
    /**
     * 设值是否排序
     * 
     * @param isDesc 是否排序
     */
    public DictVOComparator(Boolean isDesc) {
        this.isDesc = isDesc;
    }
    
    /**
     * 判断是否排序
     */
    public DictVOComparator() {
        this.isDesc = false;
    }
    
    @Override
    public int compare(DictionaryItemVO o1, DictionaryItemVO o2) {
        if (isDesc) {
            if (o2.getItemId() > o1.getItemId()) {
                return 1;
            } else if (o2.getItemId() == o1.getItemId()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (o1.getItemId() > o2.getItemId()) {
                return 1;
            } else if (o1.getItemId() == o2.getItemId()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
