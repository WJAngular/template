<meta http-equiv=��Content-Type�� content=��text/html; charset=gb2312��>
<%@page import="java.io.PrintWriter"%><%
	String exceptionMessage = (String)request.getAttribute("exceptionMessage");
	String server = (String)request.getAttribute("server");
	if(exceptionMessage==null){
	    exceptionMessage = "ϵͳ��ʱ�޷����������������Ժ����ԡ�";
	}
	String accept = request.getHeader("accept");
	String xRequested = request.getHeader("X-Requested-With");
	boolean isAjax =  accept.indexOf("application/json") > -1 || (xRequested!=null && xRequested.indexOf("XMLHttpRequest") > -1);
	if(isAjax){
	    PrintWriter writer = response.getWriter();
	    exception.printStackTrace(writer);
        writer.flush();
        writer.close();
        out.clear();
        out = pageContext.pushBody();
	}else{
%>
<!DOCTYPE html>
<%@page isErrorPage="true" pageEncoding="GBK" contentType="text/html; charset=GBK"  %>
<%@ page contentType="text/html; charset=GBK" %>
<%@page import="java.io.PrintStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.lang.Exception"%>
<html>
<head>
	<title>errorҳ��</title>
<script type="text/javascript">
   function showError(){
	   document.getElementById("errorId").style.display="block"; 
   }
</script>
</head>
<body class="topui_error_bg" style="width:auto;height:auto;">
<div class="topui_error">
    <div class="topui_error_boxErr">
        <div class="topui_error_box_line">
            <h1>
                <%=exceptionMessage %>
            </h1>
            <p>
                �����׳����쳣������ Web ������Ŀǰ�޷����� HTTP ����
            </p>
        </div>
        <div class="topui_error_box_font">
            <p>
                ��������������������⣬����������
            </p>
            <p>
                �Դ˲����Ĳ������Ǳ�ʾǸ��
            </p>
            <p>
                &nbsp;
            </p>
            <p>
                &nbsp;
            </p>
            <!-- �����쳣����ķ�����:<%=server%> -->
            <!-- 
            <p>
 
                &nbsp;&nbsp;
                <a href="javascript:showError();">
                    	��ʾ������Ϣ
                </a>
            </p>
             -->
        </div>
    </div>
	<div id="errorId" style="display: none;background-color:#F2F2F2;padding:15px;">
		<fieldset>
			<legend>
				<strong>��̨�쳣��Ϣ:<%=exceptionMessage %></strong>
				&nbsp;&nbsp;
 
			</legend>
			<font color="red"><code id="errorStackTrace"><%exception.printStackTrace(new PrintWriter(out));%></code></font>
		</fieldset>
	</div>
</div>
</body>
<script type="text/javascript">
   console.error("�쳣��ջ��Ϣ:" + document.getElementById("errorStackTrace").innerHTML);
</script>
</html>
<%}%>