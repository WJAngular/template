<%@page contentType= "text/html;charset=UTF-8" %>
<html>
	<head>
		<title>物业综合管理平台</title>
	</head>
	<frameset rows="80,*" cols="*" marginheight=0 marginwidth=0 scrolling="no" framespacing="0" frameborder="0" border="0">
    	<frame scrolling="no" frameborder="0" src="include/top_menu.jsp" name="BASE_TOP" marginheight="0" marginwidth="0">
		<frameset  id='erpframe' rows="*" cols="160,8,*" framespacing="0" frameborder="0" border="0" marginheight="0" marginwidth="0">
			<frame class="frame" src="include/left_menu.jsp" name="BASE_LEFT" scrolling="true" marginheight="0" marginwidth="0">
		    <frame src="include/middle.jsp" frameborder="0" bordercolor="red" allowtransparency="true" scrolling="no" marginheight="0" marginwidth="0">
			<frame scrolling="yes" frameborder="0" src="" name="CONTENT_MAIN" marginheight="0" marginwidth="0">
		</frameset>
	</frameset>
</html>