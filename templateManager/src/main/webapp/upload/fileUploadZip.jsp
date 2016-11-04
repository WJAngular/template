<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lckj.core.web.Path"%>
<% request.setAttribute("ctx", Path.getContextPath()); %>

<!DOCTYPE html">
<html>
<head>
<script>
	var ctx = "${ctx}";
</script>
<script type="text/javascript" src="${ctx}/resource/js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resource/js/webuploader/webuploader.css">
<script type="text/javascript" src="${ctx}/resource/js/webuploader/webuploader.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/webuploader/upload.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var extensions = "${param.extensions}";
		var mimeTypes = "${param.mimeTypes}";
		var fileSizeLimit = "${param.fileSizeLimit}";
		var fileType = "${param.fileType}";
		fileSizeLimit=fileSizeLimit==""?undefined:fileSizeLimit;//文件大小限制
		var accept={title: 'RAR',extensions: extensions,mimeTypes: mimeTypes};//允许的类型
		if(mimeTypes==""||extensions==""){
			accept =null;
		}
		$("#uploader").powerWebUpload({ hiddenInputId: "hfFilePath",accept :accept,
		    fileNumLimit:3,fileSizeLimit:fileSizeLimit,fileType:fileType,//fileNumLimit:文件数量限制
		    onAllComplete:uploadComplete//单个成功的回调函数 onAllComplete:XXX 所有成功回调函数
		});
	});
	
	function uploadComplete(json){
		//console.log(JSON.stringify(json));
		var callBackFunctionName = "${param.callBackFunctionName}";
		var callBackParamsString = "${param.callBackParamsString}";
		parent[callBackFunctionName](json,callBackParamsString);
	}
</script>
</head>
<body>
	<div id="uploader" class="wu-example">
	</div>
    <input id="hfFilePath" type="hidden" name="uploadhidden" />
</body>
</html>
