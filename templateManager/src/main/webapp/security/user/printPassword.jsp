<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>

<script type="text/JavaScript" src="${ctx}/security/user/userList.js"></script>
 <script type="text/javascript" language="javascript"></script>
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" TYPE="application/x-print-lodop" width=0 height=0 PLUGINSPAGE="install_lodop.exe"></embed>
</object> 
<style type="text/css">
	table.gridtable {
		font-family: verdana,arial,sans-serif;
		font-weight:bold;
		font-size:14px;
		color:#333333;
		border-width: 1px;
		border-color: #666666;
		border-collapse: collapse;
	}
	table.gridtable th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #d4e3e5;
	}
	table.gridtable td {
		text-align:center;vertical-align: middle;border-width: 1px;border-style: solid;border-color: #666666;background-color: #ffffff;
	}
</style>
<style type="text/css" media=print> 
.noprint{display : none } 
</style> 
<script type="text/javascript">
$(function(){
	getPrintUserInfo();
	
});

//打印选中的用户的信息 
function getPrintUserInfo(){
	var selectUserId = window.opener.$("#printUserId").val();
	var sendData = {};
	if(selectUserId != ''){
		sendData.printUserId = selectUserId;
	}else{
		sendData.userName =encodeURI(window.opener.$("#searchUserName").val(),"utf-8");
		sendData.account = window.opener.$("#searchAccount").val();
		sendData.deptCode = window.opener.$("#searchDeptCode").val();
	}
	
	$.getJSON(ctx+"/user/printPassword.do",sendData,
		function(data){
			if(data.returncode == 0){
				var user=data.list;
				var userHtml = "";
				for(var i = 0; i < user.length; i++){
					userHtml +="<h2 align='center'>音视频后台数据管理系统</h><table class='gridtable' style='width:100%;' border='1' cellpadding='2' cellspacing='0'><tr align='center'><td style='padding: 8px;'>用户名</td><td style='padding: 8px;'>账号</td><td style='padding: 8px;'>密码</td></tr>";
					userHtml += "<tr align='center'><td style='padding: 8px;width:34%;' >"+user[i].userName+"</td>";
					userHtml += "<td style='padding: 8px;width:34%;'>"+user[i].account+"</td>";
					userHtml += "<td style='padding: 8px;width:32%;'>"+user[i].password+"</td></tr>";
					userHtml +="</table>"
				}
				$("#lists").html(userHtml); 
			}else{
				$.sgfmdialog("查询业务单据失败！",1);
			}
		}
	);
}

   //设置网页打印的页眉页脚为空
    var HKEY_Root,HKEY_Path,HKEY_Key;    
    HKEY_Root="HKEY_CURRENT_USER";    
    HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";    
        //设置网页打印的页眉页脚为空    
    function PageSetup_Null()   
     {    
       try {    
           var Wsh=new ActiveXObject("WScript.Shell");    
	       HKEY_Key="header";    
	       Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");    
	       HKEY_Key="footer";    
	       Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");    
	       }  catch(e){}    
     }    
     //恢复网页打印的页眉页脚   
     function PageSetup_default()   
     {    
       try {    
           var Wsh=new ActiveXObject("WScript.Shell");    
	       HKEY_Key="header";    
	       Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"&w&b页码,&p/&P");    
	       HKEY_Key="footer";    
	       Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"&u&b&d");    
	       }  catch(e){}    
     }    

    function doPrintPreview(){  
        //打印预览  
        PageSetup_Null();
        printWB.ExecWB(7,1);
       
    }  
    function doPrint(){  
        //直接打印  
        PageSetup_Null();
        printWB.ExecWB(6,6)  
    }  
</script>
</head>
<body>
<div id="lists">
	<h2 align="center">音视频后台数据管理系统</h2>
	<table width="100%" class="gridtable">
		<tbody>
			<tr>
				<td style="padding: 8px;">用户名</td>
				<td style="padding: 8px;">账号</td>
				<td style="padding: 8px;">密码</td>
			</tr>
			<tr>
				<td style="padding: 8px;" id="userName"></td>
				<td style="padding: 8px;" id="account"></td>
				<td style="padding: 8px;" id="password"></td>
			</tr>
		</tbody>
	</table>
</div>  
    <!-- 主菜单"工具"——Internet选项——安全——自定义级别， 将"安全设置"中"对没有标记为安全的ActiveX"控件进行初始化和脚本运行由"禁用"改为"启用"  -->
    <div class="noprint" align="center">
		<object id="printWB" style="dispaly:none" classid="clsid:8856F961-340A-11D0-A96B-00C04FD705A2" height="0"></object>  
	    <input type="button" value="打印预览" onclick="prn1_preview();" class="noprint"></input> 
	    <input type="button" value="直接打印" onclick="prn1_print();" class="noprint"></input>  
    </div>
    <script language="javascript" type="text/javascript">   
    var LODOP; //声明为全局变量 
    //打印预览
	function prn1_preview() {	
		CreateOneFormPage();	
		LODOP.PREVIEW();
	};
	//直接打印
	function prn1_print() {		
		CreateOneFormPage();
		LODOP.PRINT();	
	};
	//打印样式设置
	function CreateOneFormPage(){
		LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
		LODOP.SET_PRINT_STYLE("FontSize",18);
		LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.ADD_PRINT_TEXT(50,231,260,39,"");
		LODOP.ADD_PRINT_HTM(88,200,350,600,document.getElementById("lists").innerHTML);
	};	                     	
</script> 
</body>
</html>
