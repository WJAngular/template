<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>
<script type="text/JavaScript" src="${ctx}/security/menu/menuList.js"></script>
</head>

<body class="tbg">
<div class="b_frame"  style="overflow-y: auto; height:340px; ">
	<h4 class="tit">基础菜单</h4>
	<div class="key_body">		
		菜单名称：<input id="baseMenuName" name="baseMenuName" type="text"/>
    	<input type="button" onclick="searchRecord();" id="search_btn" value="查询" class="bt_search" />
		<ct:operation operationCode="menu_insert">
	     	<input type="button" id="add_base_show_btn" value="新增" class="bt_add" />		     	
		</ct:operation>
	</div>
	<table id="base_list" class="table_base">
		<tr>
			<th width="2%" align="center" sgfm-binddata="menuId" sgfm-bindmode="function|getRadioByFunction('queryChildRecord',{0})"></th>					
			<th align="left" sgfm-binddata="menuName" sgfm-rowclick="true">菜单名称</th>
			<th width="30%" align="left" sgfm-binddata="menuUrl" sgfm-rowclick="true">菜单地址</th>
			<th width="30%" align="left" sgfm-binddata="menuIcon" sgfm-rowclick="true">菜单图标</th>
			<ct:operation operationCode="menu_locked">
				<th width="5%" align="center" sgfm-binddata="menuId|status" sgfm-bindmode="function|getLockBtn1({0},{1},'parent')">状态</th>
			</ct:operation>
			<th width="5%" align="left" sgfm-binddata="menuSort" sgfm-rowclick="true">排序</th>
			<th width="8%" align="center" sgfm-binddata="menuId" sgfm-bindmode="function|
			<ct:operation operationCode="menu_update">getModifyBtn1({0},'parent')</ct:operation>@
			<ct:operation operationCode="menu_delete">getDelBtn1({0},'parent')</ct:operation>">操作</th>
		</tr>
	</table>
</div>
<div class="b_frame">
	<h4 class="tit">子菜单</h4>
	<ct:operation operationCode="menu_insert">
		<div class="key_body">		
	     	<input type="button" id="add_child_show_btn" value="新增" class="bt_add" />		     	
		</div>
	</ct:operation>
	<table id="child_list" class="table_base">
		<tr>
			<th align="left" sgfm-binddata="menuName" sgfm-rowclick="true">菜单名称</th>
			<th width="30%" align="left" sgfm-binddata="menuUrl">菜单地址</th>
			<th width="30%" align="left" sgfm-binddata="menuIcon">菜单图标</th>
			<!-- <th width="20%" align="left" sgfm-binddata="disableIcon">菜单禁用图标</th> -->
			<ct:operation operationCode="menu_locked">
				<th width="5%" align="center" sgfm-binddata="menuId|status" sgfm-bindmode="function|getLockBtn1({0},{1},'child')">状态</th>
			</ct:operation>
			<th width="5%" align="left" sgfm-binddata="menuSort">排序</th>
			<th width="8%" align="center" sgfm-binddata="menuId" sgfm-bindmode="function|
			<ct:operation operationCode="menu_update">getModifyBtn1({0},'child')</ct:operation>@
			<ct:operation operationCode="menu_delete">getDelBtn1({0},'child')</ct:operation>">操作</th>
		</tr>
	</table>
</div>

<div id="modifyDiv" class="float_div" style="position:absolute;width:600px;top:150px;display:none;" >
	<h4 class="tit">编制菜单<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyForm">
        	<table class="table_edit">
				<tr>
					<td width="15%" align="right">菜单名称<font color="red">*</font></td>
					<td width="85%" align="left">
						<input type="text" size="50" name="menuName" maxlength="50" datatype="*"  nullmsg="请输入菜单名称！"/>
					</td>
				</tr>
				<tr>
					<td align="right">菜单地址</td>
					<td align="left">
						<input type="text" name="menuUrl" size="50"/>
					</td>	
				</tr>
				<tr>
					<td align="right">菜单图标</td>
					<td align="left">
						<input type="text" name="menuIcon" size="50"/>
					</td>
				</tr>
				<!--
				<tr>
					<td align="right">菜单禁用图标</td>
					<td align="left">
						<input type="text" name="disableIcon" size="30"/>
					</td>	
				</tr>
				 -->
				<tr>
					<td align="right">状态</td>
					<td align="left">
						<ct:dict controlType="2" id="status" name="status" dictType="StatusFlag"/>
					</td>
				</tr>
				<tr>	
					<td align="right">排序</td>
					<td align="left">
						<input type="text" name="menuSort"/>
					</td>	
				</tr>
				<tr>
					<td align="right">菜单描述</td>
					<td align="left">
						<textarea name="description" cols="50" rows="5"></textarea>
					</td>	
				</tr>
				<tr>
                 	<td colspan="4" align="center">
						<input type="hidden" id="isChildMenuOpt" value="false">
	                 	<input type="hidden" name="menuId" />
      					<input type="hidden" name="parentMenuId"/>
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
