<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>
<script type="text/JavaScript" src="${ctx}/dictionary/dictionaryList.js"></script>
</head>
<body class="tbg">
<table width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td width="35%" valign="top">
			<div class="b_frame">
				<div style="overflow-y: auto; height: 580px; ">
					<h4 class="tit">字典类型</h4>
					<ct:operation operationCode="dictionary_insert">
						<div class="key_body" align="right">		
					     	<input type="button" id="add_base_show_btn" value="新增" class="bt_add" />		     	
						</div>
					</ct:operation>
					<table id="base_list" class="table_base">
						<tr>
							<th width="2%" align="center" sgfm-bindkey="dictionaryId" sgfm-binddata="dictionaryId" sgfm-bindmode="function|getRadioByFunction('queryChildRecord',{0})"></th>					
							<th width="30%" align="left" sgfm-binddata="dictionaryName" sgfm-rowclick="true">字典名称</th>
							<th width="30%" align="left" sgfm-binddata="dictionaryCode" sgfm-rowclick="true">字典编码</th>
							<th width="8%" align="center" sgfm-binddata="dictionaryId" sgfm-bindmode="function|<ct:operation operationCode="dictionary_update">getModifyBtnDict({0},'parent')</ct:operation>@<ct:operation operationCode="dictionary_delete">getDelBtn1({0},'parent')</ct:operation>">操作</th>
						</tr>
					</table>
				</div>
			</div>
		</td>
		<td width="60%" valign="top">
			<div class="b_frame">
				<div style="overflow-y: auto; height: 580px; ">
				<h4 class="tit">字典明细</h4>
				<ct:operation operationCode="dictionary_insert">
					<div class="key_body" align="right">		
				     	<input type="button" id="add_child_show_btn" value="新增" class="bt_add" />		     	
					</div>
				</ct:operation>
				<table id="child_list" class="table_base">
					<tr>
						<th width="30%" align="left" sgfm-binddata="itemName">字典条目</th>
						<th width="25%" align="left" sgfm-binddata="itemValue">字典值</th>
						<th width="25%" align="left" sgfm-binddata="itemSort">排序</th>
						<th width="8%" align="center" sgfm-binddata="itemId" sgfm-bindmode="function|<ct:operation operationCode="dictionary_update">getModifyBtnDict({0},'child')</ct:operation>@<ct:operation operationCode="dictionary_delete">getDelBtn1({0},'child')</ct:operation>">操作</th>
					</tr>
				</table>
				</div>
			</div>
		</td>
	</tr>
</table>

<!--编制字典类型-->
<div id="modifyTypeDiv" class="float_div" style="position:absolute;width:400px;top:150px;display:none;" >
	<h4 class="tit">编制字典类型<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyTypeForm">
        	<table class="table_edit">
				<tr>
					<td align="right">字典名称<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="dictionaryName" datatype="*"  nullmsg="请输入字典名称"/>
					</td>
				</tr>
				<tr>
					<td align="right">字典编码<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="dictionaryCode" datatype="*"  nullmsg="请输入字典编码！"/>
					</td>
				</tr>
				<tr>
                 	<td colspan="2" align="center">
	                 	<input type="hidden" name="dictionaryId" />
	                 	<input type="submit" id="modify_btn" value="保存"  class="bt_modify"/>
	                 	<input type="button" value="关闭" onclick="hideDiv('modifyTypeDiv')"  class="bt_stop"/>
                  	</td>
               	</tr>
         	</table>
    	</form>
	</div>
</div>

<!--编制字典明细-->
<div id="modifyItemDiv" class="float_div" style="position:absolute;width:400px;top:150px;display:none;" >
	<h4 class="tit">编制字典明细<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyItemForm">
        	<table class="table_edit">
				<tr>
					<td align="right">字典条目<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="itemName" datatype="*"  nullmsg="请输入字典条目！" maxlength="15"/>
					</td>	
				</tr>
				<tr>
					<td align="right">字典值<font color="red">*</font></td>
					<td align="left">
						<input type="text" id="itemValue" name="itemValue" maxlength="3" datatype="n" errormsg="字典值只能为数字！"  nullmsg="请输入字典值！"/>
					</td>	
				</tr>
				<tr>
					<td align="right">排序</td>
					<td align="left">
						<input type="text" id="itemSort" name="itemSort" maxlength="10"/>
					</td>	
				</tr>
				<tr>
                 	<td colspan="2" align="center">
						<input type="hidden" id="isChildMenuOpt" value="false">
	                 	<input type="hidden" name="dictionaryId" />
	                 	<input type="hidden" name="itemId" />
	                 	<input type="submit" id="modify_btn" value="保存"  class="bt_modify"/>
	                 	<input type="button" value="关闭" onclick="hideDiv('modifyItemDiv')"  class="bt_stop"/>
                  	</td>
               	</tr>
         	</table>
    	</form>
	</div>
</div>
</body>
</html>
