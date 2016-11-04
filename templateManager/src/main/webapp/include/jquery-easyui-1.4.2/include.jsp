<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="ct" uri="/WEB-INF/tld/common.tld"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%request.setAttribute("ctx", request.getContextPath());%>
<title>物业综合管理平台</title>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>

<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/validate/easyui_validate.js"></script>  