$(function(){
	searchRecord();
	
	// 新增按钮事件
	$("#add_show_btn").click(function(){
		add();
		clsModifyForm();  
		showModifyDiv();
	});
});

/**  获取分配角色菜单按钮 */
function getMenuBtn(oId) {
	return "<a href=\"javascript:void(0)\" onclick=\"roleMappingMenuShow('roleMappingMenuDiv','" + oId + "')\" title=\"角色菜单\" class=\"a_power\">&nbsp;</a>";
}

/** 显示角色菜单映射层 */
function roleMappingMenuShow(divId,oId) {
	getRoleMappingMenu(oId);
	showFlagDiv(divId);
}

/** 显示角色用户映射层 */
function roleMappingUserShow(divId,oId) {
	getRoleMappingUser(oId);
	showFlagDiv(divId);
}

/**  获取分配用户按钮 */
function getUserBtn(oId) {
//	return "<a href=\"javascript:void(0)\" onclick=\"roleMappingUserShow('roleMappingUserDiv','" + oId + "')\" title=\"角色菜单\" class=\"a_power\">&nbsp;</a>";
	return "<a href=\"javascript:void(0)\" onclick=\"roleMapptingUser('" + oId + "')\" title=\"角色菜单\" class=\"a_power\">&nbsp;</a>";
}

/** 打开角色授权页面 */
function roleMapptingUser(roleId){
	var iWidth = 300;
	var iHeight = 500;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/security/organization/roleMappingUser.jsp?orgCode="+getCurrDeptCode()+"&roleId="+roleId,"userSelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/role/add.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips("add","新增",data.returncode);
		}
	});
}

/** 执行修改 */
function modify(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/role/update.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips("update","修改",data.returncode);
		}
	});
}

/** 改变角色状态 */
function changeState(oId,status){
	var stateTip = (status==1?"激活":"禁用");
	if(confirm("您确定要"+stateTip+"此角色信息吗？")){
		var sendData = {
			roleId : oId,
			status : status
		};
		$.getJSON(ctx+"/role/changestate.do",sendData,
			function(data){
				operationTips("changestate",stateTip,data.returncode);
			}
		);
	}
}

/** 执行删除 */
function delRecord(oId){
	if(confirm("您确定要删除角色吗？")){
		var sendData = {
			roleId : oId
		};
		$.getJSON(ctx+"/role/delete.do",sendData,
			function(data){
				operationTips("delete","删除",data.returncode);
			}
		);
	}
}

/** 执行查询 */
function searchRecord(){
	var sendData = {
		roleName:$("#searchRoleName").val(),	
		pageSize:20
	};
	$("#table_list").sgfmtable({url:ctx+'/role/list.do',
	params:sendData,
	"ajaxtype":"post",
	pagenoname:"pageNo",
	isaddrow:true,
	"rowClickCallback":function(data,td){
	}},function(){
	});
}

/** 初始化修改 */
function getModifyInfo(oId){
	modify();
	var sendData = {
		roleId : oId
	};
	$.getJSON(ctx+"/role/read.do",sendData,
		function(data){
			if(data.returncode == 0){
				$("input[name='roleId']").val(data.roleId);
				$("input[name='roleName']").val(data.roleName);
				$("input[name='roleLevel']").val(data.roleLevel);
				$("input[name='status'][value='"+data.status+"']").prop("checked",'checked');
				$("textarea[name='remark']").val(data.remark);
			}else{
				$.sgfmdialog("查询业务单据失败！",1);
			}
		}
	);
}

/** 获取角色菜单对应关系 */
function getRoleMappingMenu(oId){
	$.getJSON(ctx+"/role/query/menu.do?roleId="+oId,"",
		function(data){// 将选中的菜单的菜单ID拼接成字符串，便于显示子菜单使用
			var checkBaseId = ',,';
			$.each(data.current, function(i, v) {
				if(v.parentMenuId == 0){
					checkBaseId += v.menuId+","
				}
			});

			// 获取所有根菜单的信息
			var basehtml = '';
			$.each(data.all, function(i, base) {
				basehtml += "<tr><td align='left'><label>&nbsp;";
				basehtml += "<input id='menu"+base.menuId+"' type='checkbox' ";
				basehtml += "onclick=changeChildMenu('"+base.menuId+"')";
				basehtml += " value='"+base.menuId+"'>&nbsp;"+base.menuName;
				if(checkBaseId.indexOf(','+base.menuId+',')>0){
					basehtml += "&nbsp;<a id='amenuId"+base.menuId+"' href='javascript:void(0)' onclick='changeModel(" + base.menuId +")' title='收起' class='a_close'></a>"
				}else{
					basehtml += "&nbsp;<a id='amenuId"+base.menuId+"' href='javascript:void(0)' onclick='changeModel(" + base.menuId +")' title='展开' class='a_open'></a>"
				}
				basehtml += "</label></td></tr>";
				$.each(base.childMenuVOs, function(j, child) {
					if(checkBaseId.indexOf(','+child.parentMenuId+',')>0){
						basehtml += "<tr name='parentMenuId"+child.parentMenuId+ "'><td align='left'><label>&nbsp;&nbsp;&nbsp;&nbsp;";
						basehtml += "<input onclick=changeBaseMenu("+child.menuId+","+child.parentMenuId+") name='parentMenuId"+child.parentMenuId+ "' id='menu"+child.menuId+"' type='checkbox' ";
						basehtml += "value='"+child.menuId+"'>&nbsp;"+child.menuName;
						
						//basehtml += "&nbsp;<a id='bmenuId"+child.menuId+"' href='javascript:void(0)' onclick='changeOperation(" + child.menuId +")' title='收起' class='a_close'></a>"
						
						basehtml += "</label></td></tr>";
					}else{
						basehtml += "<tr style='display:none' name='parentMenuId"+child.parentMenuId+ "'><td align='left'><label>&nbsp;&nbsp;&nbsp;&nbsp;";
						basehtml += "<input onclick=changeBaseMenu("+child.menuId+","+child.parentMenuId+") name='parentMenuId"+child.parentMenuId+ "' id='menu"+child.menuId+"' type='checkbox' ";
						basehtml += "value='"+child.menuId+"'>&nbsp;"+child.menuName+"</label></td></tr>";
					}
					
					if(checkBaseId.indexOf(','+child.parentMenuId+',')>0){
						$.each(data.permissions, function(k, permission) {
							if(child.menuId==permission.menuId){
								basehtml += "<tr operationParentMenuId='"+permission.menuId+ "' rootMenuId='"+child.parentMenuId+ "'><td align='left'><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
								basehtml += "<input onclick=changeOperationState("+permission.menuId+","+child.parentMenuId+") rootMenuId='"+child.parentMenuId+ "' menuId='"+permission.menuId+ "' id='operation"+permission.operationId+"' type='checkbox' ";
								basehtml += "value='"+permission.operationId+"'>&nbsp;"+permission.operationName+"</label></td></tr>";
							}
						});
					}else{
						$.each(data.permissions, function(k, permission) {
							if(child.menuId==permission.menuId){
								basehtml += "<tr style='display:none' operationParentMenuId='"+permission.menuId+ "' rootMenuId='"+child.parentMenuId+ "'><td align='left'><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
								basehtml += "<input onclick=changeOperationState("+permission.menuId+","+child.parentMenuId+") rootMenuId='"+child.parentMenuId+ "' menuId='"+permission.menuId+ "' id='operation"+permission.operationId+"' type='checkbox' ";
								basehtml += "value='"+permission.operationId+"'>&nbsp;"+permission.operationName+"</label></td></tr>";
							}
						});
					}
				});	
			});
			$("#roleMappingMenu").html(basehtml);


			// 更新选中的菜单的状态
			$.each(data.current, function(i, v) {
				$("#roleMappingMenu").find("#menu"+v.menuId).prop("checked",'checked');
			});
			// 更新选中的操作权限的状态
			$.each(data.currentPermissions, function(i, v) {
				$("#roleMappingMenu").find("#operation"+v.operationId).prop("checked",'checked');
			});

			// 设置当前角色的ID信息
			$("#mappingRoleId").val(oId);
		});
}

/** 父菜单的展开收起图标点击时改变子菜单的显示状态 */
function changeModel(menuId){
	if($("#amenuId"+menuId).prop("class") == 'a_close'){
		$("#amenuId"+menuId).prop("title","展开");
		$("#amenuId"+menuId).prop("class","a_open");
		$("tr[name='parentMenuId"+menuId+"']").attr("style","display:none");
		$("tr[rootMenuId='"+menuId+"']").attr("style","display:none");
	}else{
		$("#amenuId"+menuId).prop("title","收起");
		$("#amenuId"+menuId).prop("class","a_close");
		$("tr[name='parentMenuId"+menuId+"']").attr("style","");
		$("tr[rootMenuId='"+menuId+"']").attr("style","");
	}
}

/** 子菜单的展开收起图标点击时改变菜单下操作权限的显示状态 */
function changeOperation(menuId){
	if($("#bmenuId"+menuId).prop("class") == 'a_close'){
		$("#bmenuId"+menuId).prop("title","展开");
		$("#bmenuId"+menuId).prop("class","a_open");
		$("tr[operationParentMenuId='"+menuId+"']").attr("style","display:none");
	}else{
		$("#bmenuId"+menuId).prop("title","收起");
		$("#bmenuId"+menuId).prop("class","a_close");
		$("tr[operationParentMenuId='"+menuId+"']").attr("style","");
	}
}

/** 父菜单复选框点击时改变子菜单的显示状态 */
function changeChildMenu(menuId){
	var ischeck = $("#menu"+menuId).prop("checked");
	if(ischeck == true){
		$("tr[name='parentMenuId"+menuId+"']").attr("style","");
		$("input[type='checkbox'][name='parentMenuId"+menuId+"']").prop("checked",'checked');
		$("input[type='checkbox'][rootMenuId='"+menuId+"']").prop("checked",'checked');
	}else{
		$("tr[name='parentMenuId"+menuId+"']").attr("style","display:none");
		$("input[type='checkbox'][name='parentMenuId"+menuId+"']").prop("checked",'');
		$("input[type='checkbox'][rootMenuId='"+menuId+"']").prop("checked",'');
	}
	changeModel(menuId);
}

/** 子菜单复选框点击时改变父菜单的显示状态 */
function changeBaseMenu(menuId,parentMenuId){
	var isChecked = false;
	$("input[type='checkbox'][name='parentMenuId"+parentMenuId+"']").each(function() {
		if($(this).prop("checked") == true){
			isChecked = true;
			return;
		}
	})
	if(isChecked){
		$("input[type='checkbox'][id='menu"+parentMenuId+"']").prop("checked",'checked');
	}else{
		$("input[type='checkbox'][id='menu"+parentMenuId+"']").prop("checked",'');
	}
	
	//操作权限
	if($("input[type='checkbox'][id='menu"+menuId+"']").prop("checked") == true){
		$("input[type='checkbox'][menuId='"+menuId+"']").prop("checked",'checked');
	}else{
		$("input[type='checkbox'][menuId='"+menuId+"']").prop("checked",'');
	}
}

/** 操作权限复选框点击时改变父菜单的显示状态 */
function changeOperationState(menuId,rootMenuId){
	var isChecked = false;
	$("input[type='checkbox'][menuId='"+menuId+"']").each(function() {
		if($(this).prop("checked") == true){
			isChecked = true;
			return;
		}
	})
	if(isChecked){
		$("input[type='checkbox'][id='menu"+menuId+"']").prop("checked",'checked');
	}else{
		$("input[type='checkbox'][id='menu"+menuId+"']").prop("checked",'');
	}
	
	$("input[type='checkbox'][name='parentMenuId"+rootMenuId+"']").each(function() {
		if($(this).prop("checked") == true){
			isChecked = true;
			return;
		}
	})
	if(isChecked){
		$("input[type='checkbox'][id='menu"+rootMenuId+"']").prop("checked",'checked');
	}else{
		$("input[type='checkbox'][id='menu"+rootMenuId+"']").prop("checked",'');
	}
}

/** 保存角色菜单对应关系 */
function saveRoleMappingMenu(){
	var selectMenusCount=0;
	var selectOperationsCount=0;
	var selectMenus = "";
	var selectOperations = "";
	$("#roleMappingMenu").find("input[type=checkbox][id^='menu']:checked").each(function() {
		selectMenus += $(this).val() + ";";
		selectMenusCount++;
	});
	$("#roleMappingMenu").find("input[type=checkbox][id^='operation']:checked").each(function() {
		selectOperations += $(this).val() + ";";
		selectOperationsCount++;
	});
	var roleId = $("#mappingRoleId").val();
	var sendData = {
			roleId : roleId,
			menuId : selectMenus,
			operationId : selectOperations
	};
	$.getJSON(ctx+"/role/mapping/menu.do",sendData,
		function(data){
			if(data > 0){
				$.sgfmdialog("成功给该角色授权了"+selectMenusCount+"个菜单权限,"+selectOperationsCount+"个菜单操作权限",2);
				searchRecord();
			}else{
				$.sgfmdialog("授权失败",1);
		    }
		}
	);
}

/** 获取角色用户对应关系 */
function getRoleMappingUser(oId){
	$.getJSON(ctx+"/role/query/user.do?roleId="+oId,"",
		function(data){
			// 获取所有人员
			var basehtml = '';
			$.each(data.all, function(i, user) {
				basehtml += "<tr height='22px;'><td align='left'><label>&nbsp;";
				basehtml += "<input id='user"+user.userId+"' type='checkbox' value='"+user.userId+"'>&nbsp;"+user.userName;
				basehtml += "</label></td></tr>";
			});
			$("#roleMappingUser").html(basehtml);

			// 更新选中的菜单的状态
			$.each(data.current, function(i, v) {
				$("#roleMappingUser").find("#user"+v.userId).prop("checked",'checked');
			});

			// 设置当前角色的ID信息
			$("#mappingRoleUserId").val(oId);
		});
}

/** 保存角色用户对应关系 */
function saveRoleMappingUser(roleId,orgCode,selectUsers){
	var sendData = {
			roleId : roleId,
			userId : selectUsers
	};
	$.getJSON(ctx+"/role/mapping/user.do",sendData,
		function(data){
			if(data > 0){
				$.sgfmdialog("成功给该角色授权了"+data+"个用户",2);
				searchRecord();
			}else{
				$.sgfmdialog("授权失败",1);
		    }
		}
	);
}


/** 清空表单 */
function clsModifyForm(){
	$("input[name='roleId']").val(0);
	$("input[name='roleName']").val('');
	$("input[name='roleLevel']").val(1);
	$("input[name='status'][value='1']").prop("checked",'checked');
	$("textarea[name='remark']").val('');
}