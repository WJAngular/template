<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.lckj.core.web.Path"%>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="ct" %>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<script type="text/javascript"></script>
<title>left</title>
<style type="text/css">
body {
	font: 14px Arial, Helvetica, sans-serif;
}

ul,h5 {
	margin: 0;
	padding: 0;
	width: 100%;
	list-style: none;
}

#levelmenu {
	margin: 0;
	padding: 0;
	padding: 0px;
}

#levelmenu div.unit ul {
	margin: 0;
	padding: 0;
	border: solid 0px #1A5189;
	border-top: none;
}

#levelmenu h5 {
	margin: 0;
	width: 160px;
	height: 34px;
	line-height: 34px;
	overflow: hidden;
	background-image: url("${ctx}/resource/images/frame/menu.gif");
	background-repeat: repeat-x;
	text-align: center;
	font-weight: bold;
	cursor: default;
	color:#fff;
}

#levelmenu div.unit ul {
	background-image: url("${ctx}/resource/images/frame/menudi.gif");
	margin: 0;
	padding: 0;
	display: none;
	line-height: 23px;
}

#levelmenu div.current ul {
	margin: 0;
	padding: 0;
	display: block;
}

#levelmenu div.current ul li a {
	font: 12px Arial;
	height: 27px;
	line-height: 27px;
	margin-left:10px;
	padding: 0;
	color: #3B475F;
	text-decoration: none;
}

#levelmenu div.current ul li a:hover {
	font: 12px Arial;
	height: 27px;
	line-height: 27px;
	margin-left:20px;
	text-decoration: underline;
}

#levelmenu div.current h5 {
	margin: 0;
	padding: 0;
	background-position: left bottom;
}
</style>
</head>
<body bgcolor="#FCFFED" onload="document.getElementById('defalut').click();">
	<div id="levelmenu">
		<ct:menu></ct:menu>
	</div>
</body>
</html>
<script type="text/javascript">
	function init() {
		if (!document.getElementById || !document.getElementsByTagName) {
			retun;
		}
		var arrayDiv = document.getElementById("levelmenu");
		if (!arrayDiv) {
			return;
		}
		var divObj = arrayDiv.getElementsByTagName("div");
		var length = divObj.length;
		var agreeDiv = new Array();
		for ( var i = 0; i < length; i++) {
			if (divObj[i].className.indexOf("unit") >= 0) {
				agreeDiv.push(divObj[i]);
				divObj[i].onclick = function(event) {
					showCurrentMenu(agreeDiv, this, event);
				}
			}
		}
	}
	function showCurrentMenu(agreeDiv, currentObj, event) {
		if (!event) {
			event = window.event;
		}
		var eventObj = event.srcElement ? event.srcElement : event.target;
		//先隐藏所有ul
		var length = agreeDiv.length;
		for ( var i = 0; i < length; i++) {
			if (eventObj.parentNode == agreeDiv[i] || eventObj.nodeName != "H5") {
				continue;
			}
			agreeDiv[i].className = "unit";
		}
		if (eventObj.nodeName == "H5") {
			if (eventObj.parentNode.className == "unit") {
				eventObj.parentNode.className = "unit current"
			} else {
				eventObj.parentNode.className = "unit"
			}
		}
	}
	init();
	
	function openOtherSystem(ip){
		var url = "http://"+ip+":8081/login.jsp?userName=admin&password=111"
		window.open(url,'other','height='+window.screen.availHeight+',width='+window.screen.availWidth+',top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizeable=no,location=no,status=no');
	}
</script>
