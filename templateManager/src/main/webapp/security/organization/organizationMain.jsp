<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.lckj.core.web.Path"%>
<%@ taglib uri="/WEB-INF/tld/common.tld" prefix="ct" %>
<% request.setAttribute("ctx",Path.getContextPath()); %>
<head>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<link href="${ctx}/resource/css/sgfmtree.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/css/sgfmdialog.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/css/sgfmpager.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/include/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/JavaScript" src="${ctx}/resource/js/public_easyui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
<script type="text/JavaScript" src="${ctx}/resource/js/left_menu.js"></script>
<script type="text/JavaScript" src="${ctx}/resource/js/public.js"></script>
<script type="text/JavaScript" src="${ctx}/resource/js/jquery.sgfmdialog.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/include/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/security/organization/organizationList.js"></script>
<link href="${ctx}/resource/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/css/sgfmform.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resource/js/jquery.sgfmform.js"></script>
<style type="text/css">
	.tdfont{
		font-size: 12px;
	}
</style>
</head>
<body class='easyui-layout' style="padding:0px;">
	<div region="west" style="width:300px;padding:1px">
		<ul id="organizationTree"></ul>
	</div>
	<div region="center" style="padding:5px">
		<div>
			<form id="modifyForm">
				<input type="hidden" id="id" name="id"/>
				<input type="hidden" id="parentId" name="parentId"/>
				<input type="hidden" id="leafMark" name="leafMark"/>
				<table class="table_edit">
					<tr id="rowParent">
						<td align="right" class="tdfont">父组织名称</td>
						<td align="left" colspan="3" class="tdfont">
							<input type="text" id="parentOrgName" name="parentOrgName" readonly="readonly" class="input_ro" size="87"/>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">组织名称<font color="red">*</font></td>
						<td align="left" colspan="3" class="tdfont">
							<input type="text" id="name" name="name" size="87" datatype="*"  nullmsg="请输入组织名称！"/>
						</td>
					</tr>
					<!-- 
					<tr>
						<td align="right" class="tdfont">组织简称</td>
						<td colspan="3" class="tdfont">
							<input type="text" id="shortName" name="shortName" size="78"/>
						</td>
					</tr>
					 -->
					<tr>
						<td align="right" width="15%" class="tdfont">机构类别<font color="red" >*</font></td>
						<td class="tdfont">
							<ct:dict controlType="1" dictType="OrgType" id="type" name="type"></ct:dict>
						</td>
						<td align="right" class="tdfont">组织编码</td>
						<td class="tdfont">
							<input type="text" id="code" name="code" onblur="checkRepeat();" />
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">负责人</td>
						<td class="tdfont">
							<input type="hidden" id="managerId" name="managerId"/>
	        				<input type="text" relationId="managerId" id="managerName" name="managerName" onclick="selectUser(this,getCurrDeptCode())" readonly="readonly" class="input_ro"/>
						</td>
						<td align="right" class="tdfont">联系电话</td>
						<td class="tdfont">
							<input type="text" id="telephone" name="telephone"/>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">手机号码</td>
						<td class="tdfont">
							<input type="text" id="mobilephone" name="mobilephone" ignore="ignore" datatype="m" errormsg="请输入正确的手机信息！"/>
						</td>
						<td align="right" class="tdfont">邮箱</td>
						<td class="tdfont">
							<input type="text" id="email" name="email"/>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">联系地址</td>
						<td colspan="3" class="tdfont">
							<input type="text" id="address" name="address" size="87"/>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">邮编</td>
						<td class="tdfont">
							<input type="text" id="postCode" name="postCode"/>
						</td>
						<td align="right" class="tdfont">排序号</td>
						<td class="tdfont">
							<input type="text" id="sortNo" name="sortNo"/>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">状态</td>
						<td class="tdfont">
							<ct:dict controlType="2" dictType="StatusFlag"  id="status" name="status" ></ct:dict>
						</td>
					</tr>
					<tr>
						<td align="right" class="tdfont">备注</td>
						<td align="left" colspan="3" class="tdfont">
							<textarea name="remark" cols="40" rows="5"></textarea>
						</td>
					</tr>
				</table>
				<div style="text-align:left;padding:8px">
					<ct:operation operationCode="org_update">
		                <input type="submit" id="modify_btn" value="保存"  class="bt_modify"/>
		            </ct:operation>
		            <ct:operation operationCode="org_delete">
					    <input type="button" onclick="deleteRecord();" id="deleteBtn" value="删除" class="bt_del_1"/>
		            </ct:operation>
					<ct:operation operationCode="org_insert">
					    <input type="button" id="addInit" value="新增下级" class="bt_add" />	
		            </ct:operation>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
