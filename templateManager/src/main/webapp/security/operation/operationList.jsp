<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>
<script type="text/JavaScript" src="${ctx}/security/operation/operationList.js"></script>
</head>

<body class="tbg">
<div class="b_frame">
	<h4 class="tit">操作信息</h4>
	<div class="key_body">		
		操作名称：<input id="searchOperationName" name="searchOperationName" type="text"/>
    	<input type="button" onclick="searchRecord();" id="search_btn" value="查询" class="bt_search" />
    	<ct:operation operationCode="operation_insert">
     		<input type="button" id="add_show_btn" value="新增" class="bt_add" />		     
     	</ct:operation>	
	</div>
	<table id="table_list" class="table_base">
		<tr>
			<th width="30%" align="left" sgfm-binddata="menuName">菜单名称</th>
			<th width="25%" align="left" sgfm-binddata="operationName">操作名称</th>
			<th width="25%" align="left" sgfm-binddata="operationCode">操作编码</th>
			<ct:operation operationCode="operation_locked">
				<th width="5%" align="center" sgfm-binddata="menuId|status" sgfm-bindmode="function|getLockBtn({0},{1})">状态</th>
			</ct:operation>
			<th align="center" sgfm-binddata="operationId" sgfm-bindmode="function|
				<ct:operation operationCode="operation_update">getModifyBtn({0})</ct:operation>@
				<ct:operation operationCode="operation_delete">getDelBtn({0})</ct:operation>">操作</th>
		</tr>
	</table>
</div>

<div id="modifyDiv" class="float_div" style="position:absolute;width:400px;top:150px;display:none;">
	<h4 class="tit">编制操作<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyForm">
        	<table class="table_edit">
				<tr>
					<td width="20%" align="right">菜单ID<font color="red">*</font></td>
					<td width="80%" align="left">
						<input type="text" name="menuId" maxlength="10" datatype="*"  nullmsg="请输入菜单ID！"/>
					</td>
				</tr>
				<tr>
					<td align="right">操作名称<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="operationName" maxlength="20" datatype="*"  nullmsg="请输入操作名称！"/>
					</td>
				</tr>
				<tr>
					<td align="right">操作编码<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="operationCode" maxlength="20" datatype="*"  nullmsg="请输入操作编码！"/>
					</td>
				</tr>
				<tr>
					<td align="right">状态</td>
					<td align="left">
						<ct:dict controlType="2" id="status" name="status" dictType="StatusFlag"/>
					</td>	
				</tr>
				<tr>
                 	<td colspan="4" align="center">
	                 	<input type="hidden" name="operationId" />
	                 	<input type="submit" id="modify_btn" value="保存"  class="bt_modify"/>
	                 	<input type="button" value="关闭" onclick="hideDiv('modifyDiv')"  class="bt_stop"/>
                  	</td>
               	</tr>
         	</table>
    	</form>
	</div>
</div>
</body>
</html>
