<%@ page contentType="text/html; charset=GBK" %>
<%response.setStatus(HttpServletResponse.SC_NOT_FOUND);%>
<!DOCTYPE html>
<html>
<head>
	<title>404页面</title>
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
                404 - 页面不存在。
            </h1>
            <p>
                	您请求的页面<label id="url"></label>不存在，它可能已经转到其他地址，或者您输入的URL有错误
            </p>
        </div>
        <div class="topui_error_box_font">
            <p>
                	如果您持续遇到这类问题，请联络我们
            </p>
            <p>
                	对此产生的不便我们表示歉意
            </p>

        </div>
    </div>
</div>
</body>
</html>