/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-25 02:27:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lckj.core.web.Path;

public final class left_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/tld/common.tld", Long.valueOf(1456365987292L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fct_005fmenu_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fct_005fmenu_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fct_005fmenu_005fnobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
 request.setAttribute("ctx",Path.getContextPath()); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("<script type=\"text/javascript\"></script>\r\n");
      out.write("<title>left</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont: 14px Arial, Helvetica, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul,h5 {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.unit ul {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tborder: solid 0px #1A5189;\r\n");
      out.write("\tborder-top: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu h5 {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\twidth: 160px;\r\n");
      out.write("\theight: 34px;\r\n");
      out.write("\tline-height: 34px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tbackground-image: url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/images/frame/menu.gif\");\r\n");
      out.write("\tbackground-repeat: repeat-x;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcursor: default;\r\n");
      out.write("\tcolor:#fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.unit ul {\r\n");
      out.write("\tbackground-image: url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/images/frame/menudi.gif\");\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tline-height: 23px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.current ul {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.current ul li a {\r\n");
      out.write("\tfont: 12px Arial;\r\n");
      out.write("\theight: 27px;\r\n");
      out.write("\tline-height: 27px;\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tcolor: #3B475F;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.current ul li a:hover {\r\n");
      out.write("\tfont: 12px Arial;\r\n");
      out.write("\theight: 27px;\r\n");
      out.write("\tline-height: 27px;\r\n");
      out.write("\tmargin-left:20px;\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#levelmenu div.current h5 {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tbackground-position: left bottom;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#FCFFED\" onload=\"document.getElementById('defalut').click();\">\r\n");
      out.write("\t<div id=\"levelmenu\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_ct_005fmenu_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tif (!document.getElementById || !document.getElementsByTagName) {\r\n");
      out.write("\t\t\tretun;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar arrayDiv = document.getElementById(\"levelmenu\");\r\n");
      out.write("\t\tif (!arrayDiv) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar divObj = arrayDiv.getElementsByTagName(\"div\");\r\n");
      out.write("\t\tvar length = divObj.length;\r\n");
      out.write("\t\tvar agreeDiv = new Array();\r\n");
      out.write("\t\tfor ( var i = 0; i < length; i++) {\r\n");
      out.write("\t\t\tif (divObj[i].className.indexOf(\"unit\") >= 0) {\r\n");
      out.write("\t\t\t\tagreeDiv.push(divObj[i]);\r\n");
      out.write("\t\t\t\tdivObj[i].onclick = function(event) {\r\n");
      out.write("\t\t\t\t\tshowCurrentMenu(agreeDiv, this, event);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showCurrentMenu(agreeDiv, currentObj, event) {\r\n");
      out.write("\t\tif (!event) {\r\n");
      out.write("\t\t\tevent = window.event;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar eventObj = event.srcElement ? event.srcElement : event.target;\r\n");
      out.write("\t\t//先隐藏所有ul\r\n");
      out.write("\t\tvar length = agreeDiv.length;\r\n");
      out.write("\t\tfor ( var i = 0; i < length; i++) {\r\n");
      out.write("\t\t\tif (eventObj.parentNode == agreeDiv[i] || eventObj.nodeName != \"H5\") {\r\n");
      out.write("\t\t\t\tcontinue;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tagreeDiv[i].className = \"unit\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (eventObj.nodeName == \"H5\") {\r\n");
      out.write("\t\t\tif (eventObj.parentNode.className == \"unit\") {\r\n");
      out.write("\t\t\t\teventObj.parentNode.className = \"unit current\"\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\teventObj.parentNode.className = \"unit\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tinit();\r\n");
      out.write("\t\r\n");
      out.write("\tfunction openOtherSystem(ip){\r\n");
      out.write("\t\tvar url = \"http://\"+ip+\":8081/login.jsp?userName=admin&password=111\"\r\n");
      out.write("\t\twindow.open(url,'other','height='+window.screen.availHeight+',width='+window.screen.availWidth+',top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizeable=no,location=no,status=no');\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_ct_005fmenu_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:menu
    com.lckj.base.tag.MenuTag _jspx_th_ct_005fmenu_005f0 = (com.lckj.base.tag.MenuTag) _005fjspx_005ftagPool_005fct_005fmenu_005fnobody.get(com.lckj.base.tag.MenuTag.class);
    _jspx_th_ct_005fmenu_005f0.setPageContext(_jspx_page_context);
    _jspx_th_ct_005fmenu_005f0.setParent(null);
    int _jspx_eval_ct_005fmenu_005f0 = _jspx_th_ct_005fmenu_005f0.doStartTag();
    if (_jspx_th_ct_005fmenu_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fct_005fmenu_005fnobody.reuse(_jspx_th_ct_005fmenu_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fct_005fmenu_005fnobody.reuse(_jspx_th_ct_005fmenu_005f0);
    return false;
  }
}
