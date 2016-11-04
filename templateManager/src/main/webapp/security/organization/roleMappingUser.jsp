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
<link href="${ctx}/resource/css/base.css" rel="stylesheet" type="text/css" />
<%
	String code = request.getParameter("orgCode");
	String roleId = request.getParameter("roleId");
%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#userTree").tree({
			checkbox: true,   
		    lines:true,
	        url: ctx+'/organization/usertree/role/list.do?roleId='+<%=roleId%>+'&code=<%=code%>',
	        onLoadSuccess:function(node,data){
	        	//console.info(JSON.stringify(data));
	        	$(this).tree('expandAll');
	        },
			onClick: function(node){
			},
			onDblClick:function(node){
			}
		});
	});
	
	function saveMapping(){
		var node = $('#userTree').tree('getChecked');
		var selectUserId = "";
		for (var i = 0; i < node.length; i++) {
			if(node[i].userType == 2){
				selectUserId+=node[i].id+";"
			}
		}
		window.opener.saveRoleMappingUser("<%=roleId%>","<%=code%>",selectUserId);
		window.close();
	}
	
	/** 查询数据 */
	function searchRecord(){
	}
</script>
</head>
<body class='easyui-layout' style="padding:0px;">
	<div region="center" style="width:450px;padding:1px">
		<div style="height:470px;overflow-y:scroll;padding:1px">
			<ul id="userTree"></ul>
		</div>
		<div align="center">
			<input type="button" value="保存" onclick="saveMapping()"  class="bt_modify"/>
			<input type="button" value="关闭" onclick="window.close()"  class="bt_stop"/>
		</div>
	</div>
</body>
</html>
