<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lckj.core.web.Path"%>
<%
    request.setAttribute("ctx", Path.getContextPath());
%>
<!DOCTYPE html">
<html>
<head>
<script type="text/javascript" src="${ctx}/resource/js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		var success = "${success}";
		if ("y" == success) {
			var filePath = "${imgPath}";
			var fileNameAll = "${fileNameAll}";
			var callBackFunctionName = "${callBackFunctionName}";
			var callBackParamsString = "${callBackParamsString}";
			parent[callBackFunctionName](fileNameAll,filePath, callBackParamsString);
			parent.layer.close(parent.indexStart);
		}
	});
	function checkSubmit() {
		var info = "${checkInfo}";
		var filePath = $("#filepath").val();
		var limit = "${limit}";
		if (!filePath) {
			alert("请选取文件后再上传!");
			return false;
		}//选取文件完成，检查文件名不存在后开始上传

		if (limit) {
			var agent = window.navigator.userAgent;
			var isIE = agent.indexOf('MSIE') != -1;
			if (!isIE) {
				var file = $("#filepath")[0].files[0];
				var fileSize = file.size;
				limit = Number(limit);
				if (limit < fileSize) {
					alert("文件超过限制大小！");
					return false;
				}
			}
		}
		var FileName = new String(filePath);//文件名
		var extension = new String(FileName.substring(
				FileName.lastIndexOf(".") + 1, FileName.length));//文件扩展名
		if (info) {
			if (info.indexOf(extension) == -1) {
				alert("文件格式不正确");
				return false;
			}
		}
		return true;

	}
</script>
</head>
<body>
	<form name="userForm2" action="${ctx }/file/uploadFile.do" enctype="multipart/form-data" method="post" onsubmit="return checkSubmit()">
		<input type="hidden" value="${callBackFunctionName }" name="callBackFunctionName" />
		<input type="hidden" value="${callBackParamsString }" name="callBackParamsString" />
		<input type="hidden" value="${checkInfo }" name="checkInfo" />
		<input type="hidden" value="${fileType }" name="fileType" />
		<input type="hidden" value="${limit}" name="limit" />
		<input type="hidden" value="${isCreateImg}" name="isCreateImg" />
		<input type="hidden" value="${width}" name="width" />
		<input type="hidden" value="${height}" name="height" />
		<div id="newUpload2" align="center">
			<input type="file" id="filepath" name="file">
		</div>
		<div align="center" style="padding-top: 20px;">
			<input type="submit" value="上传">

		</div>
	</form>
</body>
</html>
