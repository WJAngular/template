<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<html>
<head>
	<script type="text/javascript" src="${ctx}/config/configList.js"></script>
</head>
<body class="tbg">
	<div class="b_frame">
		<h4 class="tit">配置管理</h4>
		<div class="key_body">
			 配置项名：<input id="searchName" name="searchName" type="text"/>&nbsp;&nbsp;&nbsp;
		   	<input type="button" onclick="searchRecord();" id="search_btn" value="查询" class="bt_search" />
		   	<ct:operation operationCode="config_insert">
	    		<input type="button" id="add_show_btn" value="新增" class="bt_add" />
	    	</ct:operation>
		</div>
		<table id="table_list" class="table_base">
			<tr>
				<th width="20%" align="left" sgfm-binddata="name">配置项名称</th>
				<th width="20%" align="left" sgfm-binddata="code">配置项键</th>
				<th width="20%" align="left" sgfm-binddata="value">配置项值</th>
				<th width="35%" align="left" sgfm-binddata="description">配置描述</th>
				<th width="8%" align="center" sgfm-binddata="configId" sgfm-bindmode="function|
				<ct:operation operationCode="config_update">getModifyBtn({0})</ct:operation>@
				<ct:operation operationCode="config_delete">getDelBtn({0})</ct:operation>">操作</th>
			</tr>
		</table>
	</div>

	<div id="modifyDiv" class="float_div" style="position:absolute;width:600px;top:150px;display:none;" >
	<h4 class="tit">编制配置管理<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyForm">
        	<table class="table_edit">
				<tr>
					<td width="20%" align="right">配置项名<font color="red">*</font></td>
					<td width="80%" align="left">
						<input type="text" name="name" size="60" maxlength="40" datatype="*"  nullmsg="请输入配置项名"/>
					</td>
				</tr>
				<tr>
					<td align="right">配置项键<font color="red">*</font></td>
					<td align="left">
						<input type="text" name="code" size="60" maxlength="50" datatype="*"  nullmsg="请输入配置项键"/>
					</td>
				</tr>
				<tr>
					<td align="right">配置项值</td>
					<td align="left">
						<textarea name ="value" cols="40" rows="5"></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">配置描述</td>
					<td align="left">
						<textarea name ="description" cols="40" rows="5"></textarea>
					</td>
				</tr>
				<tr>
                 	<td colspan="4" align="center">
	                 	<input type="hidden" id="configId" name="configId" />
	                 	<input type="hidden" id="sortNo" name="sortNo" />
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

