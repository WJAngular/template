/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-25 02:48:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.property.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lckj.core.web.Path;
import java.util.*;

public final class repairInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/include/head.jsp", Long.valueOf(1456365968913L));
    _jspx_dependants.put("/include/fusionchars.jsp", Long.valueOf(1456365973039L));
    _jspx_dependants.put("/WEB-INF/tld/common.tld", Long.valueOf(1456365987292L));
    _jspx_dependants.put("/include/formhead.jsp", Long.valueOf(1456365973042L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write('\r');
      out.write('\n');
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/include/fusioncharts/jsclass/FusionCharts.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/include/fusioncharts/jsclass/FusionChartsExportComponent.js\"></script>");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#searchOrgCode\").val(getCurrDeptCode());\r\n");
      out.write("\t\t$(\"#searchOrgName\").val(getCurrDeptName());\r\n");
      out.write("\t\tshowFusionCharts();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction showFusionCharts(){\r\n");
      out.write("\t\tvar sendData = {\r\n");
      out.write("\t\t\torgCode:$(\"#searchOrgCode\").val()\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$.getJSON(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/report/statRepairInfo.do\",sendData, function(data){\r\n");
      out.write("\t\t\tvar chart = new FusionCharts(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/include/fusioncharts/charts/Pie3D.swf\", \"count\", \"100%\", \"100%\", \"0\", \"1\");\r\n");
      out.write("\t\t\tvar charxml = \"\";\r\n");
      out.write("\t\t\tcharxml +=\"<chart caption='报修信息分布图' numberSuffix='起'\";\r\n");
      out.write("\t\t\tcharxml += \"useRoundEdges='1' bgColor='FFFFFF,FFFFFF' showBorder='0'  \";\r\n");
      out.write("\t\t\tcharxml += \"showValues='1' decimalPrecision='2' decimals='2' formatNumberScale='0' baseFont='Arial' baseFontSize ='12'>\";\r\n");
      out.write("\t\t\t$.each(data, function(i, obj) {\r\n");
      out.write("\t\t\t\tcharxml += \"<set label='\"+obj.auditStateName+\"' value='\"+obj.num+\"'/> \";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tcharxml += \"</chart> \";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tchart.setDataXML(charxml);\r\n");
      out.write("\t\t\tchart.render(\"repairPie\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.getJSON(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/report/statRepairTypeInfo.do\",sendData, function(data){\r\n");
      out.write("\t\t\tvar typeChart = new FusionCharts(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/include/fusioncharts/charts/Pie3D.swf\", \"count\", \"100%\", \"100%\", \"0\", \"1\");\r\n");
      out.write("\t\t\tvar typeChartxml = \"\";\r\n");
      out.write("\t\t\ttypeChartxml +=\"<chart caption='报修类别信息分布图' numberSuffix='起'\";\r\n");
      out.write("\t\t\ttypeChartxml += \"useRoundEdges='1' bgColor='FFFFFF,FFFFFF' showBorder='0'  \";\r\n");
      out.write("\t\t\ttypeChartxml += \"showValues='1' decimalPrecision='2' decimals='2' formatNumberScale='0' baseFont='Arial' baseFontSize ='12'>\";\r\n");
      out.write("\t\t\t$.each(data, function(i, obj) {\r\n");
      out.write("\t\t\t\ttypeChartxml += \"<set label='\"+obj.repairTypeName+\"' value='\"+obj.num+\"'/> \";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\ttypeChartxml += \"</chart> \";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttypeChart.setDataXML(typeChartxml);\r\n");
      out.write("\t\t\ttypeChart.render(\"repairTypePie\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"tbg\">\r\n");
      out.write("\t<div class=\"b_frame\">\r\n");
      out.write("\t\t<h4 class=\"tit\">报修统计报表</h4>\r\n");
      out.write("\t\t<div class=\"key_body\">\t\r\n");
      out.write("\t\t\t<input id=\"searchOrgCode\" name=\"searchOrgCode\" type=\"hidden\"/>\r\n");
      out.write("\t\t\t所属区域：<input id=\"searchOrgName\" name=\"searchOrgName\" relationCode=\"searchOrgCode\" type=\"text\" \r\n");
      out.write("\t\t\t\t\tonclick=\"selectOrganization(this,getCurrDeptCode())\"\r\n");
      out.write("\t\t\t\t\treadonly=\"readonly\" class=\"input_ro\"/>&nbsp;\r\n");
      out.write("\t    \t<input type=\"button\" onclick=\"showFusionCharts();\" id=\"search_btn\" value=\"统计\" class=\"bt_search\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"repairPie\" style=\"width:100%;height:300px;border-collapse: collapse;overflow-y:hidden;\"></div>\r\n");
      out.write("\t\t<div id=\"repairTypePie\" style=\"width:100%;height:300px;border-collapse: collapse;overflow-y:hidden;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
