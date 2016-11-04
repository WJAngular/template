<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.lckj.core.web.Path"%>
<%@ taglib uri="/WEB-INF/tld/common.tld" prefix="ct" %>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<head>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/JavaScript" src="${ctx}/resource/js/public_easyui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<%
	String code = request.getParameter("orgCode");
%>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajaxSetup({cache: false});
		$("#organizationTree").tree({
			checkbox: false,   
		    lines:true,
	        url: ctx+'/organization/list.do?code=<%=code%>',
	        onLoadSuccess:function(node,data){
	        	//console.info(JSON.stringify(data));
	        },
			onClick: function(node){
			},
			onDblClick:function(node){
				if($("#divId").val() == 'undefined' || $("#divId").val() == ''){
					window.opener.selectOrganizationCallBack($("#inputId").val(),node);
				}else{
					window.opener.selectOrganizationDivCallBack($("#inputId").val(),node,$("#divId").val());
				}
				window.close();
			}
		});
	});
	
	/** 查询数据 */
	function searchRecord(){
	}
</script>
</head>
<body class='easyui-layout' style="padding:0px;">
	<input id="divId" type="hidden" value="${param.divId}">
	<input id="inputId" type="hidden" value="${param.inputId}">
	<div style="width:450px;height:380px;overflow-y:scroll;padding:1px">
		<ul id="organizationTree"></ul>
	</div>
</body>
</html>
