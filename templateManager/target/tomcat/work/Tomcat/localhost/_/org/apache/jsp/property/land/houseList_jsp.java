/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-25 02:27:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.property.land;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lckj.core.web.Path;
import java.util.*;

public final class houseList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/include/head.jsp", Long.valueOf(1456365968913L));
    _jspx_dependants.put("/WEB-INF/tld/common.tld", Long.valueOf(1456365987292L));
    _jspx_dependants.put("/include/formhead.jsp", Long.valueOf(1456365973042L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\r\n");
 request.setAttribute("ctx",Path.getContextPath()); 
      out.write("\r\n");
      out.write("<!--é¡µé¢è·¯å¾ï¼  ");
      out.print(request.getServletPath() );
      out.write("-->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/base.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.min.js\"></script>\r\n");
      out.write(" -->\r\n");
      out.write("<script type=\"text/JavaScript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/left_menu.js\"></script>\r\n");
      out.write("<script type=\"text/JavaScript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/public.js\"></script>\r\n");
      out.write("<script type=\"text/JavaScript\">var currPageNo;</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar ctx = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("</script>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/sgfmtree.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/sgfmdialog.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/sgfmpager.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/css/sgfmform.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/JavaScript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.sgfmtree.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.sgfmtable.js\"></script>\r\n");
      out.write("<script type=\"text/JavaScript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.sgfmdialog.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.sgfmpager.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery.sgfmform.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/commonLib.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/property/land/houseList.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"tbg\">\r\n");
      out.write("\t<div class=\"b_frame\">\r\n");
      out.write("\t\t<h4 class=\"tit\">项目信息</h4>\r\n");
      out.write("\t\t<div class=\"key_body\">\t\r\n");
      out.write("\t\t\t<input id=\"searchOrgCode\" name=\"searchOrgCode\" type=\"hidden\"/>\r\n");
      out.write("\t\t\t所属区域：<input id=\"searchOrgName\" name=\"searchOrgName\" relationCode=\"searchOrgCode\" type=\"text\" onclick=\"selectOrganization(this,getCurrDeptCode())\" readonly=\"readonly\" class=\"input_ro\"/>&nbsp;\r\n");
      out.write("\t\t\t项目编码：<input id=\"searchHouseCode\" name=\"searchHouseCode\" type=\"text\"/>\r\n");
      out.write("\t    \t<input type=\"button\" onclick=\"searchRecord();\" id=\"search_btn\" value=\"查询\" class=\"bt_search\" />\r\n");
      out.write("\t    \t");
      if (_jspx_meth_ct_005foperation_005f0(_jspx_page_context))
        return;
      out.write(" \t\r\n");
      out.write("\t     \t");
      if (_jspx_meth_ct_005foperation_005f1(_jspx_page_context))
        return;
      out.write(" \t     \t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table id=\"table_list\" class=\"table_base\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t<th width=\"2%\" align=\"center\" sgfm-binddata=\"houseId\" sgfm-bindmode=\"function|getCheckBox({0})\">\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" id=\"check_all\" onclick=\"checkChange()\" />\r\n");
      out.write("\t\t\t\t</th>\t\r\n");
      out.write("\t\t\t\t-->\t\t\t\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"orgName\">所属组织</th>\r\n");
      out.write("\t\t\t\t<th align=\"left\" sgfm-binddata=\"houseName\">项目名称</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"houseCode\">项目编码</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"earthArea\">占地面积</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"buildArea\">建筑面积</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"houseArea\">住宅面积</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"businessArea\">商用面积</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"buildNum\">楼宇数量</th>\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"left\" sgfm-binddata=\"carSpaceCount\">停车位数量</th>\r\n");
      out.write("\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"chargeName\">负责人名称</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"address\">地址</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"developersName\">开发商名称</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"legalPerson\">法人代表</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"contactPerson\">联系人</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"contactTelephone\">联系电话</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"contactAddress\">联系地址</th>\r\n");
      out.write("\t\t\t\t<th width=\"10%\" align=\"left\" sgfm-binddata=\"remark\">备注</th>\r\n");
      out.write("\t\t\t\t -->\r\n");
      out.write("\t\t\t\t<th width=\"8%\" align=\"center\" sgfm-binddata=\"houseId\" sgfm-bindmode=\"function|\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_ct_005foperation_005f2(_jspx_page_context))
        return;
      out.write("@\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_ct_005foperation_005f3(_jspx_page_context))
        return;
      out.write("@\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_ct_005foperation_005f4(_jspx_page_context))
        return;
      out.write("\">操作</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"modifyDiv\" class=\"float_div\" style=\"position:absolute;width:800px;top:150px;display:none;\" >\r\n");
      out.write("\t\t<h4 class=\"tit\">编辑项目信息<div class=\"b_close\"><a href=\"#\">&nbsp;</a></div></h4>\r\n");
      out.write("\t \t<div class=\"key_body\">\r\n");
      out.write("\t      \t<form id=\"modifyForm\">\r\n");
      out.write("\t        \t<table class=\"table_edit\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"15%\" align=\"right\">项目名称<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"35%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"houseName\" name=\"houseName\" maxlength=\"100\" datatype=\"*\"  nullmsg=\"请输入项目名称\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"15%\" align=\"right\">项目编码<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"35%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"houseCode\" name=\"houseCode\" onblur=\"checkHouseCode();\" maxlength=\"50\" datatype=\"*\"  nullmsg=\"请输入项目编码\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">所属区域<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"orgId\" name=\"orgId\" type=\"hidden\" datatype=\"*\"  nullmsg=\"请选择所属区域\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"orgCode\" name=\"orgCode\" type=\"hidden\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"orgName\" name=\"orgName\" relationCode=\"orgCode\" relationId=\"orgId\"  type=\"text\" onclick=\"selectOrganization(this,getCurrDeptCode())\" readonly=\"readonly\" class=\"input_ro\"/>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">负责人<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t        \t\t\t\t<input type=\"hidden\" id=\"chargeId\" name=\"chargeId\" datatype=\"*\"  nullmsg=\"请选择负责人\"/>\r\n");
      out.write("\t        \t\t\t\t<input type=\"text\" relationId=\"chargeId\" id=\"chargeName\" name=\"chargeName\" onclick=\"selectUser(this,getCurrDeptCode())\" readonly=\"readonly\" class=\"input_ro\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"areaDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">占地面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"earthArea\" name=\"earthArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">建筑面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"buildArea\" name=\"buildArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"areaDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">住宅面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"houseArea\" name=\"houseArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">商用面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"businessArea\" name=\"businessArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"areaDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">绿地面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"greenArea\" name=\"greenArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">道路面积</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"roadArea\" name=\"roadArea\" maxlength=\"15\" errormsg=\"请输入正确的数字\" ignore=\"ignore\" datatype=\"n\"/>平方米\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">楼宇数量<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"buildNum\" name=\"buildNum\" maxlength=\"2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tdatatype=\"n\" errormsg=\"请输入正确的数字\" nullmsg=\"请输入楼宇数量\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">停车位数量<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"carSpaceCount\" name=\"carSpaceCount\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdatatype=\"n\" errormsg=\"请输入正确的数字\" nullmsg=\"请输入停车场数量\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"hourseDiv\">\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">单元数量<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"unitNum\" name=\"unitNum\" maxlength=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t   datatype=\"n\" ignore=\"ignore\" errormsg=\"请输入正确的数字\" nullmsg=\"请输入单元数量\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"hourseDiv\">\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">楼层数量<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"floorNum\" name=\"floorNum\" maxlength=\"2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tdatatype=\"n\" ignore=\"ignore\" errormsg=\"请输入正确的数字\" nullmsg=\"请输入楼层数量\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">房间数量<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"roomNum\" name=\"roomNum\" maxlength=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdatatype=\"n\" ignore=\"ignore\" errormsg=\"请输入正确的数字\" nullmsg=\"请输入房间数量\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"addressDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">地址</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"address\" name=\"address\" size=\"100\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"developerDiv\"><td colspan=\"4\" align=\"center\">开发商信息</td></tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"developerDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">开发商名称</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"developersName\" name=\"developersName\" errormsg=\"请输入正确的名字(不能是纯数字)\" ignore=\"ignore\" datatype=\"s\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">法人代表</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"legalPerson\" name=\"legalPerson\" errormsg=\"请输入正确的名字(不能是纯数字)\" ignore=\"ignore\" datatype=\"s\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"developerDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">联系人</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"contactPerson\" name=\"contactPerson\" errormsg=\"请输入正确的名字(不能是纯数字)\" ignore=\"ignore\" datatype=\"s\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">联系电话</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"contactTelephone\" name=\"contactTelephone\" errormsg=\"请输入正确的手机号码(以13开头的11位数字)\" ignore=\"ignore\" datatype=\"m\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"developerDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">联系地址</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"contactAddress\" name=\"contactAddress\" errormsg=\"请输入正确的地址(不能是纯数字)\" ignore=\"ignore\" datatype=\"s\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr name=\"developerDiv\">\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">备注</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"remark\" name =\"remark\" cols=\"40\" rows=\"5\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t                 \t<td colspan=\"4\" align=\"center\">\r\n");
      out.write("\t\t                 \t<input type=\"hidden\" id=\"houseId\" name=\"houseId\" />\r\n");
      out.write("\t\t                 \t<input type=\"hidden\" name=\"operatorFlag\" id=\"operatorFlag\">\r\n");
      out.write("\t\t                 \t<input type=\"submit\" id=\"modify_btn\" value=\"保存\"  class=\"bt_modify\"/>\r\n");
      out.write("\t\t                 \t<input type=\"button\" value=\"关闭\" onclick=\"hideDiv('modifyDiv')\"  class=\"bt_stop\"/>\r\n");
      out.write("\t                  \t</td>\r\n");
      out.write("\t               \t</tr>\r\n");
      out.write("\t               \t<tr name=\"shuoming\">\r\n");
      out.write("\t               \t\t<td colspan=\"4\" align=\"left\">\r\n");
      out.write("\t               \t\t\t<font color=\"red\">\r\n");
      out.write("\t               \t\t\t\t楼宇数量：该项目对应的楼宇的数量</br>\r\n");
      out.write("\t               \t\t\t\t单元数量：其中一栋楼对应的单元数量</br>\r\n");
      out.write("\t               \t\t\t\t楼层数量：其中一个单元对应的楼层数量</br>\r\n");
      out.write("\t               \t\t\t\t房间数量：其中一层楼对应的房间数量\r\n");
      out.write("\t               \t\t\t</font>\r\n");
      out.write("\t               \t\t</td>\r\n");
      out.write("\t               \t</tr>\r\n");
      out.write("\t         \t</table>\r\n");
      out.write("\t    \t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_ct_005foperation_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:operation
    com.lckj.base.tag.OperationTag _jspx_th_ct_005foperation_005f0 = (com.lckj.base.tag.OperationTag) _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.get(com.lckj.base.tag.OperationTag.class);
    _jspx_th_ct_005foperation_005f0.setPageContext(_jspx_page_context);
    _jspx_th_ct_005foperation_005f0.setParent(null);
    // /property/land/houseList.jsp(16,6) name = operationCode type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ct_005foperation_005f0.setOperationCode("house_insert");
    int _jspx_eval_ct_005foperation_005f0 = _jspx_th_ct_005foperation_005f0.doStartTag();
    if (_jspx_eval_ct_005foperation_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t     \t<input type=\"button\" id=\"add_show_btn\" value=\"新增\" class=\"bt_add\" />\t\t    \r\n");
        out.write("\t     \t");
        int evalDoAfterBody = _jspx_th_ct_005foperation_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_ct_005foperation_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f0);
    return false;
  }

  private boolean _jspx_meth_ct_005foperation_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:operation
    com.lckj.base.tag.OperationTag _jspx_th_ct_005foperation_005f1 = (com.lckj.base.tag.OperationTag) _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.get(com.lckj.base.tag.OperationTag.class);
    _jspx_th_ct_005foperation_005f1.setPageContext(_jspx_page_context);
    _jspx_th_ct_005foperation_005f1.setParent(null);
    // /property/land/houseList.jsp(19,7) name = operationCode type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ct_005foperation_005f1.setOperationCode("house_project_insert");
    int _jspx_eval_ct_005foperation_005f1 = _jspx_th_ct_005foperation_005f1.doStartTag();
    if (_jspx_eval_ct_005foperation_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t     \t<input type=\"button\" id=\"more_add_show_btn\" value=\"新增项目向导\" class=\"bt_add\" />\t\r\n");
        out.write("\t     \t");
        int evalDoAfterBody = _jspx_th_ct_005foperation_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_ct_005foperation_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f1);
    return false;
  }

  private boolean _jspx_meth_ct_005foperation_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:operation
    com.lckj.base.tag.OperationTag _jspx_th_ct_005foperation_005f2 = (com.lckj.base.tag.OperationTag) _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.get(com.lckj.base.tag.OperationTag.class);
    _jspx_th_ct_005foperation_005f2.setPageContext(_jspx_page_context);
    _jspx_th_ct_005foperation_005f2.setParent(null);
    // /property/land/houseList.jsp(50,4) name = operationCode type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ct_005foperation_005f2.setOperationCode("house_update");
    int _jspx_eval_ct_005foperation_005f2 = _jspx_th_ct_005foperation_005f2.doStartTag();
    if (_jspx_eval_ct_005foperation_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("getModifyBtn({0})");
        int evalDoAfterBody = _jspx_th_ct_005foperation_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_ct_005foperation_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f2);
    return false;
  }

  private boolean _jspx_meth_ct_005foperation_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:operation
    com.lckj.base.tag.OperationTag _jspx_th_ct_005foperation_005f3 = (com.lckj.base.tag.OperationTag) _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.get(com.lckj.base.tag.OperationTag.class);
    _jspx_th_ct_005foperation_005f3.setPageContext(_jspx_page_context);
    _jspx_th_ct_005foperation_005f3.setParent(null);
    // /property/land/houseList.jsp(51,4) name = operationCode type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ct_005foperation_005f3.setOperationCode("house_project_update");
    int _jspx_eval_ct_005foperation_005f3 = _jspx_th_ct_005foperation_005f3.doStartTag();
    if (_jspx_eval_ct_005foperation_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("geWizardPerfectBtn({0})");
        int evalDoAfterBody = _jspx_th_ct_005foperation_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_ct_005foperation_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f3);
    return false;
  }

  private boolean _jspx_meth_ct_005foperation_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:operation
    com.lckj.base.tag.OperationTag _jspx_th_ct_005foperation_005f4 = (com.lckj.base.tag.OperationTag) _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.get(com.lckj.base.tag.OperationTag.class);
    _jspx_th_ct_005foperation_005f4.setPageContext(_jspx_page_context);
    _jspx_th_ct_005foperation_005f4.setParent(null);
    // /property/land/houseList.jsp(52,4) name = operationCode type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ct_005foperation_005f4.setOperationCode("house_delete");
    int _jspx_eval_ct_005foperation_005f4 = _jspx_th_ct_005foperation_005f4.doStartTag();
    if (_jspx_eval_ct_005foperation_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("getDelBtn({0})");
        int evalDoAfterBody = _jspx_th_ct_005foperation_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_ct_005foperation_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005foperation_0026_005foperationCode.reuse(_jspx_th_ct_005foperation_005f4);
    return false;
  }
}
