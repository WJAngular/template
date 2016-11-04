<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.lckj.core.web.Path"%>
<%@ page import = "com.lckj.security.user.model.UserVO" %>
<%@ page import = "org.apache.shiro.SecurityUtils" %>
<%@ page import = "org.apache.shiro.subject.Subject" %>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<%
	Subject currentUser = SecurityUtils.getSubject();
	UserVO user = (UserVO) currentUser.getPrincipal();
	out.println("<script language=\"javascript\">");
	out.println("var currUserName ='"+user.getUserName()+"';\n ");
	out.println("var currSystemTime ='"+new java.util.Date().getTime()+"';\n ");
	out.println("</script>");
%>