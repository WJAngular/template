<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<%@ include file="/include/ztree/include.jsp"%>
<!-- 
<script type="text/javascript" src="${appPath}/resource/js/public.js"></script>
<script type="text/javascript" src="${appPath}/security/organization/organizationList.js"></script>
-->
<SCRIPT type="text/javascript">
		var setting = {
			async: {
				enable: true,
				url:ctx+"/organization/list.do",
				autoParam:["id"]
			},data: {
				simpleData: {
					enable: true
				}
			}
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
		});
</SCRIPT>

<style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	}
	div, p, table, th, td {
		list-style:none;
		margin:0; padding:0;
		color:#333; font-size:12px;
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	#testIframe {margin-left: 10px;}
  </style>
</head>
<body>
	<ul id="treeDemo" class="ztree" style="width:260px; overflow:auto;"></ul>
</body>
</html>
