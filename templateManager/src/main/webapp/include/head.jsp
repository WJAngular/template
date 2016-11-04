<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<%@ page import="com.lckj.core.web.Path"%>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<!--页面路径：  <%=request.getServletPath() %>-->
<link href="${ctx}/resource/css/base.css" rel="stylesheet" type="text/css" />
<%@ taglib uri="/WEB-INF/tld/common.tld" prefix="ct" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript" src="${ctx}/resource/js/jquery-1.7.2.min.js"></script>
<!-- 
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
 -->
<script type="text/JavaScript" src="${ctx}/resource/js/left_menu.js"></script>
<script type="text/JavaScript" src="${ctx}/resource/js/public.js"></script>
<script type="text/JavaScript">var currPageNo;</script>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>