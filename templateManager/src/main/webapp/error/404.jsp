<%@ page contentType="text/html; charset=GBK" %>
<%response.setStatus(HttpServletResponse.SC_NOT_FOUND);%>
<!DOCTYPE html>
<html>
<head>
	<title>404ҳ��</title>
<top:link href="/top/component/common/error.css" /> 
<script type="text/javascript">
   function seturl(){
	   var urlHref = location.href;
	   var newHref = urlHref,
	       urlDom=document.getElementById("url");
	   if(urlHref.length>100){
		   newHref = urlHref.substring(0,100)+"...";
	   }

	   urlDom.setAttribute("title",urlHref);
	   urlDom.innerHTML=newHref;
 
   }
   window.onload=function(){

	   seturl();
  }
</script>	
</head>
<body  class="topui_error_bg" style="width:auto;height:auto;">
<div class="topui_error">
    <div class="topui_error_box404">
        <div class="topui_error_box_line">
            <h1>
                404 - ҳ�治���ڡ�
            </h1>
            <p>
                	�������ҳ��<label id="url"></label>�����ڣ��������Ѿ�ת��������ַ�������������URL�д���
            </p>
        </div>
        <div class="topui_error_box_font">
            <p>
                	��������������������⣬����������
            </p>
            <p>
                	�Դ˲����Ĳ������Ǳ�ʾǸ��
            </p>

        </div>
    </div>
</div>
</body>
</html>