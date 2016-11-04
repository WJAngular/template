<%@page contentType= "text/html;charset=UTF-8" %>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<head>
	<title>Code Factory!</title>
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
			    $("#ignoreTablePrefix").val(selectTables.split("_")[0]+"_");
			}else{
			    $("#ignoreTablePrefix").val("");
			}
		}

		function setDefault(){
			 $("#driver").val("com.mysql.jdbc.Driver");
			 $("#userName").val("root");
			 $("#url").val("jdbc:mysql://127.0.0.1:3306/property");
			 $("#password").val("root");
			 $("#tableSchem").val("");
			 $("#tablePrefix").val("");
		}
    </script>
</head>
<body class="tbg">
	<div class="b_frame">
	<h4 class="tit">数据库连接</h4>
	<form method="post" action="${ctx}/codefactory/connect.do">
		<table class="table_edit">
			<tr>
				<td width="8%" align="right">Driver:</td>
				<td width="20%" align="left">
					<input type="text" id="driver" size="30" name="driver" value="com.mysql.jdbc.Driver">
				</td>
				<td width="8%" align="right">URL:</td>
				<td width="20%" align="left">
					<input type="text" id="url" name="url" size="30" value="jdbc:mysql://127.0.0.1:3306/property">
				</td>
				<td width="8%" align="right">Schem:</td>
				<td width="35%" align="left">
					<input type="text" id="tableSchem" size="20" name="tableSchem" value="">
				</td>
			</tr>
			<tr>
				<td align="right">UserName:</td>
				<td align="left">
					<input type="text" id="userName" size="30" name="userName" value="root">
				</td>
				<td align="right">Password:</td>
				<td align="left">
					<input type="text" id="password" size="30" name="password" value="root">
				</td>
				<td align="right">过滤条件:</td>
				<td align="left">
					<input type="text" id="tablePrefix" size="20" name="tablePrefix" value="PP"/>
					<button id="connect" type="submit" class="bt_save">连接 </button>
					<input type="button" value="默认" onclick="setDefault();" class="bt_del_1"/>
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
				<div class="b_frame_center">
					<h4 class="tit">数据库表 </h4>
					<div style="overflow-y: auto; height: 450px; ">
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
				<input type="button" value="选择" onclick="chooseTable();" class="bt_add"/></br></br> 
				<input type="button" value="移除" onclick="removeTable();" class="bt_del_1"/>
			</td>
			<td width="47%">
				<div class="b_frame_center">
					<h4 class="tit">待生成表</h4>
					<div style="overflow-y: auto; height: 450px; ">
					<table id="selecttable">
					</table>
					</div>
				</div>
			</td>
		</tr>
	</table>	
	<div class="b_frame">
	<table class="table_edit">
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
				<input type="text" id="author" size="8" name="author" value="吴景"/>
			</td>
			<td width="7%" align="right">文件路径:</td>
			<td width="30%" align="left">
				<input type="text" id="filePath" size="40" name="filePath" value="F:/property/PropertyManager/src/main/java/com/lckj/property"/>
			</td>
			<td width="7%" align="right">模块名称:</td>
			<td width="15%" align="left">
				<input type="text" id="modelName" size="20" name="modelName" value=""/>
			</td>
			<td width="6%" align="right">前缀:</td>
			<td width="10%" align="left">
				<input type="text" id="ignoreTablePrefix" size="10" name="ignoreTablePrefix"/>
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
<!--

//-->
</script>
