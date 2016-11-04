<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.lckj.core.web.Path"%>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<%@ page import = "com.lckj.security.user.model.UserVO" %>
<%@ page import = "com.lckj.property.land.model.RoomVO" %>
<%@ page import = "org.apache.shiro.SecurityUtils" %>
<%@ page import = "org.apache.shiro.subject.Subject" %>
<%@ page import = "com.lckj.base.systeminit.AppCache" %>

<%
	Subject currentUser = SecurityUtils.getSubject();
	UserVO user = (UserVO) currentUser.getPrincipal();
    RoomVO room =  user.getRoom();
	out.println("<script language=\"javascript\">");
	out.println("var currUserId ='"+user.getUserId()+"';\n ");
	out.println("var currAccount ='"+user.getAccount()+"';\n ");
	out.println("var currUserMobilephone ='"+user.getMobilephone()+"';\n ");
	out.println("var currUserName ='"+user.getUserName()+"';\n ");
	out.println("var currDeptId ='"+user.getDeptId()+"';\n ");
	out.println("var currDeptCode ='"+user.getDeptCode()+"';\n ");
	out.println("var currDeptName ='"+user.getDeptName()+"';\n ");
	out.println("var currSystemTime ='"+new java.util.Date().getTime()+"';\n ");
	if(user.getRoom() != null){
		out.println("var currRoomId ='"+room.getRoomId()+"';\n ");
		out.println("var currRoomName ='"+room.getRoomName()+"';\n ");
		out.println("var currRoomFullName ='"+room.getRoomFullName()+"';\n ");
		out.println("var currRoomFullCode ='"+room.getRoomFullCode()+"';\n ");
		out.println("var currOwnerId ='"+room.getOwnerId()+"';\n ");
		out.println("var currOwnerName ='"+room.getOwnerName()+"';\n ");
	}else{
		out.println("var currRoomId ='';\n ");
		out.println("var currRoomName ='';\n ");
		out.println("var currRoomFullName ='';\n ");
		out.println("var currRoomFullCode ='';\n ");
		out.println("var currOwnerId ='';\n ");
		out.println("var currOwnerName ='';\n ");
	}
	out.println("</script>");
	
	String belongArea = AppCache.getConfigMap().get("belongArea");
	String openMainTrafficUrl = AppCache.getConfigMap().get("openMainTrafficUrl");
%>
<html>
<head>
<title>顶部框架页</title>
<style type="text/css">
body {
	font: 13px Arial, Helvetica, sans-serif;
}
</style>
<script type="text/javascript">
	function openOrg(){
		if('<%=openMainTrafficUrl%>' != 'null'){
			window.open('<%=openMainTrafficUrl%>','mainTraffic11','height='+window.screen.availHeight+',width='+window.screen.availWidth+',top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizeable=no,location=no,status=no');
		}
	}
	
	function openModifyPassword(){
		var iWidth = 400;
		var iHeight = 250;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open('${ctx}/modifyPassword.jsp?userId='+currUserId+'&account='+currAccount,'modifyPassword','height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
	}
</script>
</head>
<body bgcolor="#E4EDFB">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
			<td width="300" background="${ctx}/resource/images/frame/top-middle.jpg">
				<img src="${ctx}/resource/images/frame/top-left-<%=belongArea%>.png">
			</td>
			<td align="right" valign="bottom" background="${ctx}/resource/images/frame/top-middle.png">
				当前用户：<%=user.getUserName()%>[<%=user.getDeptName()%>]&nbsp;&nbsp;<!-- <a href="javascript:void(0)" onclick="openOrg()" title="打开组织架构图">[<%=user.getDeptName()%>]</a>&nbsp; --> <a href="javascript:void(0)" onclick="window.parent.location.href='${ctx}/user/logout.do'" title="注销">注销</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="openModifyPassword()" title="修改密码">修改密码</a>&nbsp;
				</br>
			</td>
		</tr>	
	</table>
</body>
</html>
