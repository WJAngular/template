<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>
<script type="text/JavaScript">

function searchRecord(){
}

function checkPassword(){
	var sendData = {
		account:$("#account").val(), 
		password:$("#oldPassword").val()
	};
	$.ajaxSetup({cache: false}); 
	$.getJSON("${ctx}/user/checklogin.do",sendData,
		function(data){
			if(data.returncode == 1){
				$.sgfmdialog("用户名或密码错误，请重新输入！",1);
			}
		}
	);
}

function checkConfirePassword(){
	var newPassword = $("#newPassword").val();
	var confirePassword = $("#confirePassword").val();
	if(newPassword != confirePassword){
		$.sgfmdialog("确认密码不正确，请重新输入！",1);
	}
}

/** 修改密码 */
function modifyPassword(){
	var sendData = {
		userId : $("#userId").val(),
		password : $("#newPassword").val()
	};
	$.ajaxSetup({cache: false}); 
	$.getJSON(ctx+"/user/modifyPassword.do",sendData,
		function(data){
			if(data.returncode == 1){
				$.sgfmdialog("修改密码失败！",1);
			}else{
				$.sgfmdialog("修改密码成功!",2);
			}
		}
	);
}
</script>
</head>

<body class="tbg">
<div id="modifyDiv" class="float_div">
	<h4 class="tit">修改用户密码</h4>
 	<div class="key_body">
       	<table class="table_edit">
			<tr>
				<td align="right">用户帐号</td>
				<td align="left">
					<input size="30" type="text" id="account" name="account" value="${param.account}" readonly="readonly" class="input_ro"/>
				</td>
			</tr>
			<tr>
				<td align="right">旧密码<font color="red">*</font></td>
				<td align="left">
					<input size="30" type="password" id="oldPassword" name="oldPassword" maxlength="20" datatype="*"  nullmsg="请输入旧密码！" onblur="checkPassword();"/>
				</td>	
			</tr>
			<tr>
				<td align="right">新密码<font color="red">*</font></td>
				<td align="left">
					<input size="30" type="password" id="newPassword" name="newPassword" maxlength="20" datatype="*"  nullmsg="请输入新密码！"/>
				</td>
			</tr>
			<tr>
				<td align="right">确认密码<font color="red">*</font></td>
				<td align="left">
					<input size="30" type="password" id="confirePassword" name="confirePassword" maxlength="20" datatype="*"  nullmsg="请输入确认密码！" onblur="checkConfirePassword();"/>
				</td>
			</tr>
			<tr>
               	<td colspan="4" align="center">
                 	<input type="hidden" id="userId" name="userId" value="${param.userId}"/>
                 	<input type="button" id="modify_btn" value="保存"  class="bt_modify" onclick="modifyPassword();"/>
                 	<input type="button" value="关闭" onclick="window.close()"  class="bt_stop"/>
               	</td>
           	</tr>
       	</table>
	</div>
</div>
</body>
</html>
