<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<%@ include file="/include/formhead.jsp" %>
<%@ page import = "com.lckj.base.systeminit.AppCache" %>
<html>
<head>
	<script type="text/javascript" src="${ctx}/resource/js/layer/layer.js"></script>
	<script type="text/JavaScript" src="${ctx}/security/user/userList.js"></script>
 	<script type="text/javascript" language="javascript"></script>
</head>
<body class="tbg">
<div class="b_frame">
	<h4 class="tit">用户信息</h4>
	<div class="key_body">	
		<input type="hidden" id="searchDeptCode" name="searchDeptCode"/>
		 所属组织：<input id="searchDeptName" name="searchDeptName" type="text" relationCode="searchDeptCode" onclick="selectOrganization(this,getCurrDeptCode())" readonly="readonly" class="input_ro"/>&nbsp;
		 用户名称：<input id="searchUserName" name="searchUserName" type="text"/>&nbsp;
		 用户帐号：<input id="searchAccount" name="searchAccount" type="text"/>&nbsp;
		<!--  
		<input type="button" onclick="clsSearchCondition();" id="search_btn" value="清空条件" class="bt_del_2" />
		-->
	   	<input type="button" onclick="searchRecord();" id="search_btn" value="查询" class="bt_search" />
		<ct:operation operationCode="user_insert">
	    	<input type="button" id="add_show_btn" value="新增" class="bt_add" />
	    </ct:operation>
	    <!-- 
	    <ct:operation operationCode="user_print">
	    	<input type="button" id="print_btn" value="打印密码" class="bt_print" onclick="printPasswords();"/>
	    </ct:operation>
	    -->
	    <!--  
	    <input type="button" id="export_show_btn" value="用户导出" class="bt_down" onclick="exportExcel();"/>
	    -->
    </div>
	<table id="table_list" class="table_base">
		<input type="hidden" id="postTypeJson" value="<ct:dict controlType='5' id='postType' name='postType' dictType='PostType'/>">
		<tr>
			<th width="2%" align="center" sgfm-binddata="userId" sgfm-bindmode="function|getCheckBox({0})">
				<input type="checkbox" id="check_all" onclick="checkChange()" />
			</th>
			<th align="left" sgfm-binddata="deptName" sgfm-rowclick="true">所属组织</th>
			<th width="10%" align="left" sgfm-binddata="userName" sgfm-rowclick="true">用户名称</th>
			<th width="10%" align="left" sgfm-binddata="account" sgfm-rowclick="true">用户帐号</th>
			<th width="10%" align="center" sgfm-binddata="mobilephone" sgfm-rowclick="true">手机</th>
			<th width="5%" align="center" sgfm-binddata="post" sgfm-rowclick="true" sgfm-bindmode="<ct:dict controlType="6" name="post" dictType="PostType"/>">岗位</th>
			<!--  
			<th width="5%" align="center" sgfm-binddata="postType" sgfm-rowclick="true" sgfm-bindmode="function|formatPostType({0})">岗位</th>
			-->
			<th width="5%" align="center" sgfm-binddata="sex" sgfm-rowclick="true" sgfm-bindmode="<ct:dict controlType="6" name="sex" dictType="SexFlag"/>">性别</th>
			<th width="8%" align="center" sgfm-binddata="creatorName" sgfm-rowclick="true">创建人</th>
			<th width="5%" align="center" sgfm-binddata="userSort" sgfm-rowclick="true">排序</th>
			<ct:operation operationCode="user_locked">
				<th width="5%" align="center" sgfm-binddata="userId|status" sgfm-bindmode="function|getLockBtn({0},{1})">状态</th>
			</ct:operation>
			<ct:operation operationCode="user_dorole">
				<th width="5%" align="center" sgfm-binddata="userId" sgfm-bindmode="function|getRoleBtn({0})">授权角色</th>
			</ct:operation>
			<th width="8%" align="center" sgfm-binddata="userId|state" sgfm-bindmode="function|
			<ct:operation operationCode="user_update">getModifyBtn({0})</ct:operation>@
			<ct:operation operationCode="user_delete">getDelBtn({0})</ct:operation>">操作</th>
		</tr>
	</table>
</div>

<div id="userMappingRoleDiv" class="float_div" style="position:absolute;width:500px;top:150px;display:none;">
	<h4 class="tit">用户角色对应关系<div class="b_close"><a href="#">&nbsp;</a></div></h4>
	<div style="overflow-y: auto; height: 400px; ">
		<input type="hidden" id="mappingUserId">
		<table id="userMappingRole" class="table_edit">
		</table>
	</div>
		<input type="button" value="保存" onclick="saveUserRoleMapping()"  class="bt_modify"/>
		<input type="button" value="关闭" onclick="hideDiv('userMappingRoleDiv')"  class="bt_stop"/>
</div>

<div id="modifyDiv" class="float_div" style="position:absolute;width:900px;top:150px;display:none;">
	<h4 class="tit">编辑用户信息<div class="b_close"><a href="#">&nbsp;</a></div></h4>
 	<div class="key_body">
      	<form id="modifyForm">
        	<table class="table_edit">
				<tr>
					<td width="10%" align="right">用户名称<font color="red">*</font></td>
					<td width="40%" align="left">
						<input size="20" type="text" name="userName" maxlength="20" datatype="*"  nullmsg="请输入用户名称"/>
					</td>
					<td width="10%" align="right">所属组织<font color="red">*</font></td>
					<td width="40%" align="left">
      					<input type="hidden" id="deptId" name="deptId"/>
      					<input type="hidden" id="deptCode" name="deptCode"/>
						<input type="text" relationId="deptId" relationCode="deptCode" id="deptName" name="deptName" readonly="readonly" onclick="selectOrganization(this,getCurrDeptCode())" class="input_ro" datatype="*" nullmsg="请输入组织系信息"/>
					</td>
				</tr>
				<tr>
					<td align="right">用户帐号<font color="red">*</font></td>
					<td align="left">
						<input size="20" type="text" id="account" name="account" onblur="checkAccountRepeat();" maxlength="20" datatype="*"  nullmsg="请输入用户帐号"/>
					</td>
					<td align="right">手机<font color="red">*</font></td>
					<td align="left">
						<input type="text" id="mobilephone" name="mobilephone" maxlength="11" datatype="m" nullmsg="请输入手机号" errormsg="请输入正确的手机信息"/>
					</td>
				</tr>
				<tr>
					<td align="right">联系电话</td>
					<td align="left">
						<input type="text" name="telephone"/>
					</td>
					<td align="right">身份证号</td>
					<td align="left">
						<input type="text" id="identityCard" name="identityCard"/>
					</td>	
				</tr>
				<tr>
					<td align="right">籍贯</td>
					<td align="left">
						<input type="text" id="nativePlace" name="nativePlace"/>
					</td>
					<td align="right">出生日期</td>
					<td align="left">
						<input type="text" id="birthday" name="birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					</td>	
				</tr>
				<tr>
					<td align="right">性别</td>
					<td align="left">
						<ct:dict controlType="2" id="sex" name="sex" dictType="SexFlag"/>
					</td>
					<td align="right">QQ号码</td>
					<td align="left">
						<input type="text" id="qqNumber" name="qqNumber"/>
					</td>	
				</tr>
				<tr>
					<td align="right">文化程度</td>
					<td align="left">
						<ct:dict controlType="1" id="educationDegree" name="educationDegree" dictType="EducationDegree"/>
					</td>	
					<td align="right">邮箱</td>
					<td align="left">
						<input size="40" type="text" name="email"/>
					</td>
				</tr>
				<tr>
					<td align="right">岗位</td>
					<td align="left">
						<ct:dict controlType="2" id="post" name="post" dictType="PostType"/>
					</td>	
					<td align="right">用户类型</td>
					<td align="left">
						<ct:dict controlType="2" id="userType" name="userType" dictType="UserType"/>
					</td>	
				</tr>
				<tr>	
					<td align="right">联系地址</td>
					<td align="left">
						<input type="text" id="relationAddress" name="relationAddress" size="40"/>
					</td>	
					<td align="right">人员排序：</td>
					<td align="left">
						<input type="text" id="userSort" name="userSort" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td align="right">备注</td>
					<td align="left" colspan="3">
						<textarea name="remark" cols="40" rows="5"></textarea>
					</td>	
				</tr>
				<tr>
					<td align="right">照片</td>
					<td align="left" colspan="3">
						<input type="text" id="photo" name="photo" size="100" readonly="readonly" class="flat_n_ro_right"/>
                  		<input type="hidden" id="photoPath" name="photoPath"/>
						<input type="button" id="uploadFile" name="uploadFile" value="请选择文件" onclick="fileUploadInit();">
					</td>	
				</tr>
				<tr>
                 	<td colspan="4" align="center">
						<input type="hidden" id="printUserId" name="printUserId">
			      		<input type="hidden" id="creatorId" name="creatorId"/>
			      		<input type="hidden" id="creatorName" name="creatorName"/>
	                 	<input type="hidden" id="userId" name="userId" />
	                 	<input type="hidden" id="status" name="status" />
	                 	<input type="hidden" id="printFlag"  name="printFlag" />
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
