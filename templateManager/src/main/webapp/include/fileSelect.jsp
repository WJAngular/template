<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/head.jsp" %>
<html>
<head>
<title>文件导入页面</title>
<script>
	function loadTitileName(){
		var titleName = window.opener.titleName;
		var importUrl = window.opener.importUrl;
		$("input[name='userName']").val(window.opener.parent.frames["BASE_TOP"].currUserName);
		if(titleName == undefined){
			titleName = "文件导入";
		}else{
			titleName = titleName+"导入";
		}
		$("#titleName").html(titleName);
		$("#importForm").attr("action",importUrl);
	}
</script>

</head>
<body onload="loadTitileName();">
<div class="b_frame" id="taskContent" style="width: 98%">
	<h4 id="titleName" class="tit"></h4>
	<form id="importForm" action="" method="post" enctype="multipart/form-data">
		<input type="hidden" id="userName" name="userName">
		<table class="table_edit">
			<tr>
				<td align="right">请选择文件:</td>
				<td align="left"><input id="file" size="150" name="uploadFile" type="file"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="执行" class="bt_add"/>
					<input type="button" onclick="window.opener.location.reload();window.close();" value="关闭" class="bt_stop"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="50" align="center" valign="middle">
					<div style="width:98%; height:240px; overflow-y:auto;">
						<c:if test="${message!=''}">
							<font color="red">${message}</font>
						</c:if>
						<script>
							if("${targetFile}" != "" && window.opener.downloadMessageDoc){
								window.opener.downloadMessageDoc('${targetFile}');
							}
						</script>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>