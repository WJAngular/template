/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-06-08 15:11:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lckj.core.web.Path;
import java.util.*;

public final class modifyPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/JavaScript\">\r\n");
      out.write("\r\n");
      out.write("function searchRecord(){\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkPassword(){\r\n");
      out.write("\tvar sendData = {\r\n");
      out.write("\t\taccount:$(\"#account\").val(), \r\n");
      out.write("\t\tpassword:$(\"#oldPassword\").val()\r\n");
      out.write("\t};\r\n");
      out.write("\t$.ajaxSetup({cache: false}); \r\n");
      out.write("\t$.getJSON(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/checklogin.do\",sendData,\r\n");
      out.write("\t\tfunction(data){\r\n");
      out.write("\t\t\tif(data.returncode == 1){\r\n");
      out.write("\t\t\t\t$.sgfmdialog(\"用户名或密码错误，请重新输入！\",1);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkConfirePassword(){\r\n");
      out.write("\tvar newPassword = $(\"#newPassword\").val();\r\n");
      out.write("\tvar confirePassword = $(\"#confirePassword\").val();\r\n");
      out.write("\tif(newPassword != confirePassword){\r\n");
      out.write("\t\t$.sgfmdialog(\"确认密码不正确，请重新输入！\",1);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/** 修改密码 */\r\n");
      out.write("function modifyPassword(){\r\n");
      out.write("\tvar sendData = {\r\n");
      out.write("\t\tuserId : $(\"#userId\").val(),\r\n");
      out.write("\t\tpassword : $(\"#newPassword\").val()\r\n");
      out.write("\t};\r\n");
      out.write("\t$.ajaxSetup({cache: false}); \r\n");
      out.write("\t$.getJSON(ctx+\"/user/modifyPassword.do\",sendData,\r\n");
      out.write("\t\tfunction(data){\r\n");
      out.write("\t\t\tif(data.returncode == 1){\r\n");
      out.write("\t\t\t\t$.sgfmdialog(\"修改密码失败！\",1);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$.sgfmdialog(\"修改密码成功!\",2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"tbg\">\r\n");
      out.write("<div id=\"modifyDiv\" class=\"float_div\">\r\n");
      out.write("\t<h4 class=\"tit\">修改用户密码</h4>\r\n");
      out.write(" \t<div class=\"key_body\">\r\n");
      out.write("       \t<table class=\"table_edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\">用户帐号</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t<input size=\"30\" type=\"text\" id=\"account\" name=\"account\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.account}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly=\"readonly\" class=\"input_ro\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\">旧密码<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t<input size=\"30\" type=\"password\" id=\"oldPassword\" name=\"oldPassword\" maxlength=\"20\" datatype=\"*\"  nullmsg=\"请输入旧密码！\" onblur=\"checkPassword();\"/>\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\">新密码<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t<input size=\"30\" type=\"password\" id=\"newPassword\" name=\"newPassword\" maxlength=\"20\" datatype=\"*\"  nullmsg=\"请输入新密码！\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\">确认密码<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t<input size=\"30\" type=\"password\" id=\"confirePassword\" name=\"confirePassword\" maxlength=\"20\" datatype=\"*\"  nullmsg=\"请输入确认密码！\" onblur=\"checkConfirePassword();\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("               \t<td colspan=\"4\" align=\"center\">\r\n");
      out.write("                 \t<input type=\"hidden\" id=\"userId\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                 \t<input type=\"button\" id=\"modify_btn\" value=\"保存\"  class=\"bt_modify\" onclick=\"modifyPassword();\"/>\r\n");
      out.write("                 \t<input type=\"button\" value=\"关闭\" onclick=\"window.close()\"  class=\"bt_stop\"/>\r\n");
      out.write("               \t</td>\r\n");
      out.write("           \t</tr>\r\n");
      out.write("       \t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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