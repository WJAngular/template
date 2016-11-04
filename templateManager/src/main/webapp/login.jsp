<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.lckj.core.web.Path"%>
<%@page session="false" %>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<%@ page import = "com.lckj.base.systeminit.AppCache" %>
<%@ page import = "com.lckj.security.user.model.UserVO" %>
<%@ page import = "org.apache.shiro.SecurityUtils" %>
<%@ page import = "org.apache.shiro.subject.Subject" %>
<%
	String belongArea = AppCache.getConfigMap().get("belongArea");
	Subject currentUser = SecurityUtils.getSubject();
	UserVO user = (UserVO) currentUser.getPrincipal();
	String account = "";
	if(user != null){
	    account = user.getAccount();
	}
%>
<html>
<HEAD>
<TITLE>物业管理平台</TITLE>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
<script type="text/JavaScript" src="${ctx}/resource/js/jquery.sgfmdialog.js"></script>
<link href="${ctx}/resource/css/sgfmdialog.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
table {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
}

.textbox {
	font-family: "宋体";
	font-size: 12px;
	color: #102C6B;
	height:25px;
	width:150px;
}
.tdfont{
	font-size:20px;font-family:'黑体';color:#000000;
}

.submitstyle{
	width:109px; height:29px; cursor:pointer; border:none;background:url(${ctx}/resource/images/login/login_btn.png) no-repeat 0 -58px;
}
.reststyle{
	width:109px; height:29px; cursor:pointer; border:none;background:url(${ctx}/resource/images/login/login_btn.png) no-repeat 0 0px;
}

#Layer2 {
	position:absolute;
	width:800px;
	height:115px;
	z-index:2;
}
-->
</style>
<script language="JavaScript">
	function imagezoom(){
		var winw = $(window).width(); 
		var winh = $(window).height();
		$("#back1").attr({width:winw, height:winh}); 
	    var loginTable = document.getElementById("loginTable");
	    loginTable.style.top=winh-50;
	    loginTable.style.left=(winw - 700)/2;
	}
	
	function checklogin(){
		var sendData = {
			account:$("#username").val(), 
 			password:$("#password").val()
		};
		if("<%=account%>" == ""){
			$.getJSON("${ctx}/user/checklogin.do",sendData,
				function(data){
					if(data.returncode == 1){
						$.sgfmdialog("用户名或密码错误，请重新输入！",1);
					}else{
						$("#loginForm").trigger("submit");
					}
				}
			);
		}else{
			window.location.href = "${ctx}/index.jsp";
		}
	}
</script>
</head>
<body style="margin:0px;overflow:hidden;" onLoad="imagezoom();"  onresize="imagezoom();">
	<img id="back1" style="position:absolute;" src="/resource/images/login/background-<%=belongArea%>.jpg"/>
	<form id="loginForm" action="" method="post">
	<table width="100%" height="100%" height="80" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" valign="top">
				<div id="Layer2">
					<table id="loginTable" width="700" border="0" cellspacing="0" cellpadding="0" style="position:absolute;" >
						<tr>
							<td width="72" align="right" class="tdfont"><span id="uspan">账&nbsp;号:</span></td>
							<td><input id="username" name="username" type="text" value="${param.userName}" class="textbox"/></td>
							<td width="72" align="right" class="tdfont">密&nbsp;码:</td>
							<td><input id="password" name="password" type="password" value="${param.password}" class="textbox"/></td>
							<td><input type="button" value="" onclick="checklogin();" class="submitstyle"/></td>
							<td><input type="reset" value="" class="reststyle"/></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	</form>
</body>
</HTML>
