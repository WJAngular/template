<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<%@ include file="/include/include.jsp"%>
<style type="text/css">
	.tit {border-bottom:1px #d3dbe7 solid;background:#e8ecee;height:25px;line-height:25px;font-weight:bold;font-size:12px;color:#000;margin:0;padding:0 0 0 10px; text-align:center; position:relative;}
	.b_frame_center {margin:5px; border:1px #d3dbe7 solid;background:#FFFFFF;min-height:60px;_height:60px;margin-bottom:10px;clear:both; width:99%; }
	.b_frame_center .tit {border-bottom:1px #d3dbe7 solid;background:#e8ecee;height:28px;line-height:28px;font-weight:bold;font-size:12px;color:#000;margin:0;padding:0 0 0 10px; text-align:center;}
</style>
<script type="text/javascript">
	function chooseTable(){
		$("#initable").find("input[type=checkbox]:checked").each(function() {
			$("#selecttable").append("<tr height='22px;'>"+$(this).parent().parent().parent().html()+"</tr>");
			$(this).parent().parent().parent().remove();
		 })
		 setSelectTable();
	}
	
	function removeTable(){
	    $("#selecttable").find("input[type=checkbox]:checked").each(function() {
			$("#initable").append("<tr height='22px;'>"+$(this).parent().parent().parent().html()+"</tr>");
			$(this).parent().parent().parent().remove();
		 })
		 setSelectTable();
	}
	
	function setSelectTable(){
		var selectTables = "";
		$("#selecttable").find("input[type=checkbox]").each(function() {
			selectTables += $(this).val() + ";";
		 })
		$("#generateTable").val(selectTables);
		if(selectTables.length > 0 && selectTables.split("_").length > 1){
		    $("#ignoreTablePrefix").textbox('setValue',selectTables.split("_")[0]+"_");
		}else{
		    $("#ignoreTablePrefix").textbox('setValue',"");
		}
	}

	function setDefault(){
		 $("#driver").textbox('setValue',"oracle.jdbc.driver.OracleDriver");
		 $("#userName").textbox('setValue',"pvm_new");
		 $("#url").textbox('setValue',"jdbc:oracle:thin:@192.168.1.125:1521:ORCL");
		 $("#password").textbox('setValue',"pvm_1234");
		 $("#tableSchem").textbox('setValue',"PVM_NEW");
		 $("#tablePrefix").textbox('setValue',"");
	}
</script>
</head>
<body class="default">
	<div>
	<h4 class="tit">数据库连接</h4>
		<form method="post" action="${ctx}/codefactory/connect.do">
			<table class="form-layout">
				<tr>
					<td width="8%" align="right">Driver:</td>
					<td width="20%" align="left">
						<input class="easyui-textbox" id="driver" size="30" name="driver" value="oracle.jdbc.driver.OracleDriver">
					</td>
					<td width="8%" align="right">URL:</td>
					<td width="20%" align="left">
						<input class="easyui-textbox" id="url" name="url" size="30" value="jdbc:oracle:thin:@192.168.1.125:1521:ORCL">
					</td>
					<td width="8%" align="right">Schem:</td>
					<td width="35%" align="left">
						<input class="easyui-textbox" id="tableSchem" size="20" name="tableSchem" value="PVM_NEW">
					</td>
				</tr>
				<tr>
					<td align="right">UserName:</td>
					<td align="left">
						<input class="easyui-textbox" id="userName" size="30" name="userName" value="pvm_new">
					</td>
					<td align="right">Password:</td>
					<td align="left">
						<input class="easyui-textbox" id="password" size="30" name="password" value="pvm_1234">
					</td>
					<td align="right">过滤条件:</td>
					<td align="left">
						<input class="easyui-textbox" id="tablePrefix" size="20" name="tablePrefix" value="road"/>
						<button id="saveBtn" class="easyui-linkbutton">连接 </button>
						<a id="saveBtn" href="#" onclick="setDefault();" class="easyui-linkbutton">默认</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<form method="post" action="${ctx}/codefactory/generate.do">
	<input type="hidden" id="driver" name="driver" value="${dbInfo.driver}">
	<input type="hidden" id="url" name="url" value="${dbInfo.url}">
	<input type="hidden" id="userName" name="userName" value="${dbInfo.userName}">
	<input type="hidden" id="password" name="password" value="${dbInfo.password}">
	<input type="hidden" id="tableSchem" name="tableSchem" value="${dbInfo.tableSchem}">
	<input type="hidden" id="generateTable" name="generateTable" size="100">
	<table width="99%" cellpadding="5" cellspacing="0">
		<tr>
			<td width="47%">
				<div class="b_frame_center"><h4 class="tit">数据库表 </h4>
					<div style="overflow-y: auto; height:300px; ">
					<table id="initable">
						<c:forEach items="${tableNames}" var="tableName">
							<tr height="22px;">
								<td align="left"><label>&nbsp;<input type="checkbox" value="${tableName}">&nbsp;${tableName}</label></td>
							</tr>
						</c:forEach>
					</table>
					</div>
				</div>
			</td>
			<td align="center" valign="middle">
				<a id="chooseBtn" href="#" onclick="chooseTable();" class="easyui-linkbutton">选择</a><br><br>
				<a id="removeBtn" href="#" onclick="removeTable();" class="easyui-linkbutton">移除</a>
			</td>
			<td width="47%">
				<div class="b_frame_center"><h4 class="tit">数据库表 </h4>
					<div style="overflow-y: auto; height:300px; ">
					<table id="selecttable">
					</table>
					</div>
				</div>
			</td>
		</tr>
	</table>	
	<div class="form-layout">
	<table>
		<tr>
			<td align="right">模板:</td>
			<td align="left" colspan="8">
				<div>
	                <input type="checkbox" name="codeTemplate" value="Controller.java"/>Controller.java
	                <input type="checkbox" name="codeTemplate" value="Mapper.java"/>Mapper.java
	                <input type="checkbox" name="codeTemplate" value="Mapper.xml"/>Mapper.xml
	                <input type="checkbox" name="codeTemplate" value="VO.java"/>VO.java
	                <input type="checkbox" name="codeTemplate" value="Service.java"/>Service.java
	                <input type="checkbox" name="codeTemplate" value="List.jsp"/>List.jsp
	                <!-- 
	                <input type="checkbox" name="codeTemplate" value="Add.jsp"/>Add.jsp
	                <input type="checkbox" name="codeTemplate" value="Edit.jsp"/>Edit.jsp
	                <input type="checkbox" name="codeTemplate" value="Read.jsp"/>Read.jsp 
	                -->
                </div>
			</td>
		</tr>
		<tr>
			<td width="6%" align="right">作者:</td>
			<td width="10%" align="left">
				<input class="easyui-textbox" id="author" size="8" name="author" value="吴景"/>
			</td>
			<td width="7%" align="right">文件路径:</td>
			<td width="30%" align="left">
				<input class="easyui-textbox" id="filePath" size="40" name="filePath" value="F:\pvm\VideoManager\src\main\java\com\lckj\security"/>
			</td>
			<td width="7%" align="right">模块名称:</td>
			<td width="15%" align="left">
				<input class="easyui-textbox" id="modelName" size="20" name="modelName" value=""/>
			</td>
			<td width="6%" align="right">前缀:</td>
			<td width="10%" align="left">
				<input class="easyui-textbox" id="ignoreTablePrefix" size="10" name="ignoreTablePrefix"/>
			</td>
			<td width="8%" align="center">
				<button id="generateCode" class="easyui-linkbutton">生成代码</button>
			</td>
		</tr>
		<tr>
			<td colspan="8" align="center">
				<c:if test="${message!=''}">
					${message}
				</c:if>
			</td>
		</tr>
	</table>
	</div>
</form>
</body>
<script type="text/javascript">
	$("input[name='codeTemplate']").attr("checked",'checked');
</script>