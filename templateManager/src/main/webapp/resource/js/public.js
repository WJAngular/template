
/**********************架构处理需要的js*****************/
/** 获取当前用户Id */
function getCurrUserId() {
    return window.parent.frames["BASE_TOP"].currUserId;
}

/** 获取当前用户名称 */
function getCurrUserName() {
    return window.parent.frames["BASE_TOP"].currUserName;
}

/** 获取当前用户电话 */
function getCurrUserMobilephone() {
	return window.parent.frames["BASE_TOP"].currUserMobilephone;
}

/** 获取当前用户所属部门Id */
function getCurrDeptId() {
	return window.parent.frames["BASE_TOP"].currDeptId;
}

/** 获取当前用户所属部门code */
function getCurrDeptCode() {
	return window.parent.frames["BASE_TOP"].currDeptCode;
}

/** 获取当前用户所属部门name */
function getCurrDeptName() {
	return window.parent.frames["BASE_TOP"].currDeptName;
}

/** 获取当前用户对应的客户编号 */
function getCurrOwnerId() {
	return window.parent.frames["BASE_TOP"].currOwnerId;
}

/** 获取当前用户对应的客户名称 */
function getCurrOwnerName() {
	return window.parent.frames["BASE_TOP"].currOwnerName;
}

/** 获取当前用户对应的房间编号 */
function getCurrRoomId() {
	return window.parent.frames["BASE_TOP"].currRoomId;
}

/** 获取当前用户对应的房间名称 */
function getCurrRoomName() {
	return window.parent.frames["BASE_TOP"].currRoomName;
}

/** 获取当前用户对应的房间全编码 */
function getCurrRoomFullCode() {
	return window.parent.frames["BASE_TOP"].currRoomFullCode;
}

/** 获取当前用户对应的房间全名称 */
function getCurrRoomFullName() {
	return window.parent.frames["BASE_TOP"].currRoomFullName;
}

/** 隐藏浮动窗口 */
function hideDiv(divNm) {
    //$.Hidemsg();
    $("#" + divNm).sgfmdialog("close_dialog");
}

/** 显示修改层 */
function modifyShow(oId) {
    $("#modifyForm input:enabled").removeClass('Validform_error');
    clsModifyForm();
    getModifyInfo(oId);
    showModifyDiv();
}

/** 显示修改层 */
function modifyShow1(oId,otherValue) {
	$("#modifyForm input:enabled").removeClass('Validform_error');
	clsModifyForm();
	getModifyInfo(oId,otherValue);
	showModifyDiv();
}

/** 显示新增层 */
function showAddDiv() {
    $("#addDiv").sgfmdialog({
	"url" : "",
	"params" : "",
	"haserrmsg" : true,
	"ajaxtype" : "",
	"isModel" : true,
	"middle" : true,
	"isremove" : false,
	"needclose" : true,
	"maskclick" : true,
	"initpage" : function() {
	},
	"closeCallback" : function() {
	},
	"callback" : function(isFirst) {
	}
    }, function(isFirst) {
    });
}
	
function showDiv(flag,msg){
	$("#"+flag).sgfmdialog({
	"haserrmsg" : true,
	"isModel" : true,
	"middle" : true,
	"isremove" : false,
	"needclose" : true,
	"maskclick" : true,
	"controlMsg" : msg+"，请耐心等候！",
	"initpage" : function() {
	},
	"closeCallback" : function() {
	},
	"callback" : function(isFirst) {
	}
    }, function(isFirst) {
    });
}

/** 显示指定层 */
function showFlagDiv(flag) {
	$("#"+flag).sgfmdialog({
		"url" : "",
		"params" : "",
		"haserrmsg" : true,
		"ajaxtype" : "",
		"isModel" : true,
		"middle" : true,
		"isremove" : false,
		"needclose" : true,
		"maskclick" : true,
		"initpage" : function() {
		},
		"closeCallback" : function() {
		},
		"callback" : function(isFirst) {
		}
	}, function(isFirst) {
	});
}

/** 显示修改层 */
function showModifyDiv() {
    $("#modifyDiv").sgfmdialog({
	"url" : "",
	"params" : "",
	"haserrmsg" : true,
	"ajaxtype" : "",
	"isModel" : true,
	"middle" : true,
	"isremove" : false,
	"needclose" : true,
	"maskclick" : true,
	"initpage" : function() {
	},
	"closeCallback" : function() {
	},
	"callback" : function(isFirst) {
	}
    }, function(isFirst) {
    });
}

/** 显示详情层 */
function showDetailDiv() {
    clsModifyForm();
    $("#detailDiv").sgfmdialog({
	"url" : "",
	"params" : "",
	"haserrmsg" : true,
	"ajaxtype" : "",
	"isModel" : true,
	"middle" : true,
	"isremove" : false,
	"needclose" : true,
	"maskclick" : false,
	"initpage" : function() {
	},
	"closeCallback" : function() {
	},
	"callback" : function(isFirst) {
	}
    }, function(isFirst) {
    });
}

/** 打印提示信 */
function operationTips(optType,message,returncode){
	if(optType == 'add' || optType == 'update'){
		$.Hidemsg();
	}
	if(returncode == 0){
		$.sgfmdialog(message+"成功！",2);
		searchRecord();
	}else{
		$.sgfmdialog(message+"失败！",1);
	}
	if(optType == 'delete'){
		$("#check_all").prop("checked",'');
	}
}

/** 将对象值置空或置零 */
function changeZeroToNull(obj) {
	if(obj.value == '0'){
		obj.value = '';
	}
}
function changeNullToZero(obj) {
	if(obj.value==''){
		obj.value='0';
	}
}

/** 将对象值置空格或置空 */
function changeNullToSpace(obj) {
	if(obj.value == ' '){
		obj.value = '';
	}
}
function changeSpaceToNull(obj) {
	if(obj.value==' '){
		obj.value='';
	}
}

/** 获取修改按钮 */
function getModifyBtn(oId) {
    return "<a href=\"javascript:void(0)\" onclick=\"modifyShow('" + oId + "')\" title=\"修改\" class=\"a_modify\">&nbsp;</a>";
}

/** 获取修改按钮 */
function getModifyBtn(oId) {
	return "<a href=\"javascript:void(0)\" onclick=\"modifyShow('" + oId + "')\" title=\"修改\" class=\"a_modify\">&nbsp;</a>";
}

/**  获取修改按钮 */
function getModifyBtn1(oId, otherValue) {
    return "<a href=\"javascript:void(0)\" onclick=\"modifyShow1('" + oId + "','" + otherValue + "')\" title=\"修改\" class=\"a_modify\">&nbsp;</a>";
}

/** 获取删除按钮 */
function getDelBtn(oId) {
    return "<a href=\"javascript:void(0)\" onclick=\"delRecord('" + oId + "')\" title=\"删除\" class=\"a_del\">&nbsp;</a>";
}

/** 获取删除按钮 */
function getDelBtn1(oId, otherValue) {
	return "<a href=\"javascript:void(0)\" onclick=\"delRecord1('" + oId + "','" + otherValue + "')\" title=\"删除\" class=\"a_del\">&nbsp;</a>";
}

/**  获取锁按钮 */
function getLockBtn(oId, state) {
	if(state == '1'){
		return "<a href=\"javascript:void(0)\" onclick=\"changeState('" + oId + "','2')\" title=\"停用\" class=\"a_unlock\">&nbsp;</a>";
	}else if(state == '2'){
		return "<a href=\"javascript:void(0)\" onclick=\"changeState('" + oId + "','1')\" title=\"启用\" class=\"a_locked\">&nbsp;</a>";
	}
}

/**  获取锁按钮 */
function getLockBtn1(oId, state, otherValue) {
	if(state == '1'){
		return "<a href=\"javascript:void(0)\" onclick=\"changeState1('" + oId + "','2','"+otherValue+"')\" title=\"停用\" class=\"a_unlock\">&nbsp;</a>";
	}else if(state == '2'){
		return "<a href=\"javascript:void(0)\" onclick=\"changeState1('" + oId + "','1','"+otherValue+"')\" title=\"启用\" class=\"a_locked\">&nbsp;</a>";
	}
}

/**  获取打印按钮按钮 */
function getPrintBtn(oId,printFlag) {
	if(printFlag == 1){
		return "<a href=\"javascript:void(0)\" onclick=\"printPassword('" + oId + "')\" title=\"打印密码\" class=\"a_power\">&nbsp;</a>";
	}
}

/** 打开组织选择窗口 */
function selectOrganization(obj,orgCode,divId){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/security/organization/organizationSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id+"&divId="+divId,"orgSelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 选择组织回调函数 */
function selectOrganizationCallBack(id,node){
	if($("#"+id).attr("relationCode") != undefined){
		var relationCode = $("#"+id).attr("relationCode");
		$("#"+relationCode).val(node.code);
	}
	if($("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+id).attr("relationId");
		$("#"+relationId).val(node.id);
	}
	if($("#"+id).attr("relationCallBack") != undefined){
		var relationCallBack = $("#"+id).attr("relationCallBack");
		eval(relationCallBack+"()");
	}
	$("#"+id).val(node.name);
}

/** 选择组织回调函数 */
function selectOrganizationDivCallBack(id,node,divId){
	if($("#"+divId).find("#"+id).attr("relationCode") != undefined){
		var relationCode = $("#"+divId).find("#"+id).attr("relationCode");
		$("#"+divId).find("#"+relationCode).val(node.code);
	}
	if($("#"+divId).find("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+divId).find("#"+id).attr("relationId");
		$("#"+divId).find("#"+relationId).val(node.id);
	}
	$("#"+divId).find("#"+id).val(node.name);
}

/** 打开人员选择窗口 */
function selectUser(obj,orgCode,divId){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/security/organization/userSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id+"&divId="+divId,"userSelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}


/** 选择人员回调函数 */
function selectUserCallBack(id,node){
	if($("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+id).attr("relationId");
		$("#"+relationId).val(node.id);
	}
	if($("#"+id).attr("relationName") != undefined){
		var relationName = $("#"+id).attr("relationName");
		$("#"+relationName).val(node.name);
	}
	if($("#"+id).attr("relationMobile") != undefined){
		var relationMobile = $("#"+id).attr("relationMobile");
		$("#"+relationMobile).val(node.mobilephone);
	}
	// 如果有 updateName 属性，则不修改对应的值，否则修改，主要用于按钮操作上面，如巡查日记上报
	if($("#"+id).attr("updateName") == undefined){
		$("#"+id).val(node.name);
	}
	
	// 如果需要触发按键回调事件
	if($("#"+id).attr("relationCallBack") != undefined){
		var relationCallBack = $("#"+id).attr("relationCallBack");
		eval(relationCallBack+"()");
	}
}

/** 选择人员回调函数 */
function selectUserDivCallBack(id,node,divId){
	if($("#"+divId).find("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+divId).find("#"+id).attr("relationId");
		$("#"+divId).find("#"+relationId).val(node.id);
	}
	if($("#"+divId).find("#"+id).attr("relationName") != undefined){
		var relationName = $("#"+divId).find("#"+id).attr("relationName");
		$("#"+divId).find("#"+relationName).val(node.name);
	}
	if($("#"+divId).find("#"+id).attr("relationMobile") != undefined){
		var relationMobile = $("#"+divId).find("#"+id).attr("relationMobile");
		$("#"+divId).find("#"+relationMobile).val(node.mobilephone);
	}
	// 如果有 updateName 属性，则不修改对应的值，否则修改，主要用于按钮操作上面，如巡查日记上报
	if($("#"+divId).find("#"+id).attr("updateName") == undefined){
		$("#"+divId).find("#"+id).val(node.name);
	}
	
	// 如果需要触发按键回调事件
	if($("#"+divId).find("#"+id).attr("relationCallBack") != undefined){
		var relationCallBack = $("#"+divId).find("#"+id).attr("relationCallBack");
		eval(relationCallBack+"()");
	}
}

/** 打开房产选择窗口 */
function selectSimpleProperty(obj,orgCode){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 打开房产选择窗口 */
function selectSimpleDivProperty(obj,orgCode,divId){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id+"&divId="+divId,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 打开房产选择窗口,带房产类型 */
function selectMuiltProperty(obj,landType){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+getCurrDeptCode()+"&inputId="+obj.id+"&landType="+landType,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 打开房产选择窗口，判断是否入住，1：代表选择未入住房间，2：代表选择已入住房间 */
function selectPropertyRoomState(obj,roomState){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+getCurrDeptCode()+"&inputId="+obj.id+"&landType="+4+"&roomState="+roomState,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 打开房产选择窗口 */
function selectDeptMuiltProperty(obj,orgCode,landType){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id+"&landType="+landType,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 打开房产选择窗口 */
function selectMuiltDivProperty(obj,orgCode,landType,divId){
	var iWidth = 300;
	var iHeight = 400;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/land/landSelect.jsp?orgCode="+orgCode+"&inputId="+obj.id+"&divId="+divId+"&landType="+landType,"propertySelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/** 选择房产回调函数 */
function selectPropertyCallBack(id,node){
	if($("#"+id).attr("relationCode") != undefined){
		var relationCode = $("#"+id).attr("relationCode");
		$("#"+relationCode).val(node.code);
	}
	if($("#"+id).attr("relationFullCode") != undefined){
		var relationFullCode = $("#"+id).attr("relationFullCode");
		$("#"+relationFullCode).val(node.fullCode);
	}
	if($("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+id).attr("relationId");
		$("#"+relationId).val(node.landId);
	}
	if($("#"+id).attr("relationFullName") != undefined){
		var relationFullName = $("#"+id).attr("relationFullName");
		$("#"+relationFullName).val(node.fullName);
	}
	if($("#"+id).attr("relationName") != undefined){
		var relationName = $("#"+id).attr("relationName");
		$("#"+relationName).val(node.name);
	}
	if($("#"+id).attr("relationOwnerId") != undefined){
		var relationOwnerId = $("#"+id).attr("relationOwnerId");
		$("#"+relationOwnerId).val(node.ownerId);
	}
	if($("#"+id).attr("relationOwnerName") != undefined){
		var relationOwnerName = $("#"+id).attr("relationOwnerName");
		$("#"+relationOwnerName).val(node.ownerName);
	}
	if($("#"+id).attr("relationLandType") != undefined){
		var relationLandType = $("#"+id).attr("relationLandType");
		$("#"+relationLandType).val(node.type);
	}
	// 如果需要触发按键回调事件
	if($("#"+id).attr("relationCallBack") != undefined){
		var relationCallBack = $("#"+id).attr("relationCallBack");
//		window[relationCallBack]();
		eval(relationCallBack+"()");
	}
	$("#"+id).val(node.fullName);
//	if(node.type == 4){
//		$("#"+id).val(node.fullName);
//	}else{
//		$("#"+id).val(node.name);
//	}
}

/** 选择房产回调函数 */
function selectPropertyDivCallBack(id,node,divId){
	if($("#"+divId).find("#"+id).attr("relationCode") != undefined){
		var relationCode = $("#"+divId).find("#"+id).attr("relationCode");
		$("#"+divId).find("#"+relationCode).val(node.code);
	}
	if($("#"+divId).find("#"+id).attr("relationId") != undefined){
		var relationId = $("#"+divId).find("#"+id).attr("relationId");
		$("#"+divId).find("#"+relationId).val(node.landId);
	}
	if($("#"+divId).find("#"+id).attr("relationFullName") != undefined){
		var relationFullName = $("#"+divId).find("#"+id).attr("relationFullName");
		$("#"+divId).find("#"+relationFullName).val(node.fullName);
	}
	if($("#"+divId).find("#"+id).attr("relationName") != undefined){
		var relationName = $("#"+divId).find("#"+id).attr("relationName");
		$("#"+divId).find("#"+relationName).val(node.name);
	}
	if($("#"+divId).find("#"+id).attr("relationOwnerId") != undefined){
		var relationOwnerId = $("#"+divId).find("#"+id).attr("relationOwnerId");
		$("#"+divId).find("#"+relationOwnerId).val(node.ownerId);
	}
	if($("#"+divId).find("#"+id).attr("relationOwnerName") != undefined){
		var relationOwnerName = $("#"+divId).find("#"+id).attr("relationOwnerName");
		$("#"+divId).find("#"+relationOwnerName).val(node.ownerName);
	}
	if($("#"+divId).find("#"+id).attr("relationLandType") != undefined){
		var relationLandType = $("#"+divId).find("#"+id).attr("relationLandType");
		$("#"+divId).find("#"+relationLandType).val(node.type);
	}
	// 如果需要触发按键回调事件
	if($("#"+divId).find("#"+id).attr("relationCallBack") != undefined){
		var relationCallBack = $("#"+divId).find("#"+id).attr("relationCallBack");
		eval(relationCallBack+"()");
	}
	$("#"+divId).find("#"+id).val(node.fullName);
//	if(node.type == 4){
//		$("#"+divId).find("#"+id).val(node.fullName);
//	}else{
//		$("#"+divId).find("#"+id).val(node.name);
//	}
}

/** 打开车位选择窗口 */
function selectCarSpace(obj){
	var iWidth = 900;
	var iHeight = 600;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(ctx+"/property/car/spaceSelect.jsp","spaceSelect",'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

/**  获取复选框  */
function getCheckBox(oId) {
    return "<input type='checkBox' name='check_list' value='" + oId + "'/>";
}

/**  获取复选框  */
function getOtherCheckBox(oId,otherId) {
	return "<input type='checkBox' name='check_list' value='" + oId+"-"+otherId + "'/>";
}

/** 获取单选框 */
function getRadioBox(oId) {
    return "<input type='radio' name='check_list' value='" + oId + "'/>";
}

/** 获取单选框，带点击事件 */
function getRadio(oId){
	return "<input type='radio' name='check_list' value='" + oId + "' onclick=\"getModifyInfo(" + oId + ")\"/>";
}

/** 获取单选框 */
function getRadioByFunction(functionName,param1,param2,param3,param4) {
	var radioValue = param1;
	var functionParam = "\'"+param1+"\'";
	if(param2 != undefined){
		radioValue += "--"+param2;
		functionParam += ",\'"+param2+"\'";
	}
	if(param3 != undefined){
		radioValue += "--"+param3;
		functionParam += ",\'"+param3+"\'";
	}
	if(param4 != undefined){
		radioValue += "--"+param4;
		functionParam += ",\'"+param4+"\'";
	}
	return "<input type='radio' name='check_list' value='" + radioValue + "' onclick=\""+functionName+"(" + functionParam + ")\"/>";
}

/** 列表复选框全选、全不选 */
function checkChange() {
    var isCheck = false;
    if ($("#check_all").prop("checked")) {
    	isCheck = true;
    }

    $('input[name="check_list"]').each(function() {
    	$(this).attr("checked", isCheck);
    });
}

/** 列表复选框全选、全不选 */
function checkChangeByListName(listName){
	var isCheck = false;
	if ($("#"+listName).find("#check_all").prop("checked")) {
		isCheck = true;
	}
	
	$("#"+listName).find('input[name="check_list"]').each(function() {
		$(this).attr("checked", isCheck);
	});
}

/** 获取选择的项目数量 */
function getCheckNum(){
	return $("input[name='check_list']:checked").length;
}

/** 获取选中的记录ID */
function getCheckValue(){
	var selProjectId="";
	$("input[name='check_list']:checked").each(function(){
		selProjectId = selProjectId+$(this).val() +",";
    });
	if(selProjectId.length > 1){
		return selProjectId.substr(0,selProjectId.length -1);
	}else{
		return selProjectId;
	}
}

/** 获取选择的项目数量 */
function getCheckNumByListName(listName){
	return $("#"+listName).find("input[name='check_list']:checked").length;
}

/** 获取选中的记录ID */
function getCheckValueByListName(listName){
	var selProjectId="";
	$("#"+listName).find("input[name='check_list']:checked").each(function(){
		selProjectId = selProjectId+$(this).val() +",";
    });
	if(selProjectId.length > 1){
		return selProjectId.substr(0,selProjectId.length -1);
	}else{
		return selProjectId;
	}
}

/** 统计报表格式化数据，为空时返回“ - ” **/
function formatStatNumber(num){
	if(num == 0){
		return ' - ';
	}else{
		return num;
	}
}

/** ********************功能优化需要的js**************** */
/**
 * 根据步长修改文本框中的值
 * 
 * @param obj
 *                文本框对象
 * @param step
 *                操作的步长
 * @param pointSize
 *                最后结果保留的小数点的位数
 * @return
 */
function chageValue(obj, step, pointSize) {
    var vIntStep = parseFloat(step);
    var vIntObjValue = 0;
    if (pointSize == undefined) {
	pointSize = 0;
    }
    // 如果文本框中的值不为空或不是“+ - =”，则将文本框的值转换成数字
    if (obj.value != "" && obj.value != "+" && obj.value != "-" && obj.value != "=") {
	vIntObjValue = parseFloat(obj.value);
    }
    // 如果操作的是小键盘上的“+”或正常的“+=”键则将文本框本身的值加上步长
    if ((event.keyCode == 107 || event.keyCode == 187) && vIntStep > 0) {
	obj.value = (vIntObjValue + vIntStep).toFixed(pointSize);
    } else if ((event.keyCode == 109 || event.keyCode == 189) && vIntStep > 0) {// 如果操作的是小键盘上的“-”或正常的“-”键则将文本框本身的值加上步长
	obj.value = (vIntObjValue - vIntStep).toFixed(pointSize);
    }
}

/** 框架页中页面加载的时候触发默认加载的链接 */
function loaddefault() {
    $("a").click();
}

/** 收缩层控制器 */
function mobileControl(obj) {
    if (showMenuFlag == 0) {
	obj.style.display = '';
	document.getElementById('mobile').className = 'mobile_div_up';
	showMenuFlag = 1;
    } else {
	obj.style.display = 'none';
	document.getElementById('mobile').className = 'mobile_div_down';
	showMenuFlag = 0;
    }
}

/** 获取系统当前月份 */
function currMonth() {
    var d = new Date();
    var result = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month > 9) {
	result = result + "-" + month;
    } else {
	result = result + "-0" + month;
    }
    return result;
}

/** 获取系统当前月份的前N个月 */
function preParamMonth(param) {
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	if(month - param < 0){
		year = year-1;
		month = month - param + 12;
	}
	if (month > 9) {
		return year + "-" + month;
	} else {
		return year + "-0" + month;
	}
}

/** 获取系统当前日期 */
function currDate() {
    var d = new Date();
    var result = d.getFullYear();
    var month = d.getMonth() + 1;
    var date = d.getDate();
    if (month > 9) {
	result = result + "-" + month;
    } else {
	result = result + "-0" + month;
    }
    if (date > 9) {
	result = result + "-" + date;
    } else {
	result = result + "-0" + date;
    }
    return result;
}

/** 获取系统当前时间 */
function currDateTime() {
    var d = new Date();
    var result = d.getFullYear();
    var month = d.getMonth() + 1;
    var date = d.getDate();
    var hour = d.getHours();
    var minute = d.getMinutes();
    var second = d.getSeconds();
    if (month > 9) {
    	result = result + "-" + month;
    } else {
    	result = result + "-0" + month;
    }
    if (date > 9) {
    	result = result + "-" + date;
    } else {
    	result = result + "-0" + date;
    }
    if (hour > 9) {
    	result = result + " " + hour;
    } else {
    	result = result + " 0" + hour;
    }
    if (minute > 9) {
    	result = result + ":" + minute;
    } else {
    	result = result + ":0" + minute;
    }
    if (second > 9) {
    	result = result + ":" + second;
    } else {
    	result = result + ":0" + second;
    }
    return result;
}

/** 
 * 获取本周、本季度、本月、上月的开始日期、结束日期 
 */  
var now = new Date();                    //当前日期     
var nowDayOfWeek = now.getDay();         //今天本周的第几天     
var nowDay = now.getDate();              //当前日     
var nowMonth = now.getMonth();           //当前月     
var nowYear = now.getYear();             //当前年   
var oneDay = 1000 * 60 * 60 * 24;
nowYear += (nowYear < 2000) ? 1900 : 0;  //    
  
var lastMonthDate = new Date();  //上月日期  
lastMonthDate.setDate(1);  
lastMonthDate.setMonth(lastMonthDate.getMonth()-1);  
var lastYear = lastMonthDate.getYear();  
var lastMonth = lastMonthDate.getMonth();  

//格式化日期：yyyy-MM-dd     
function formatDate(date) {      
    var myyear = date.getFullYear();     
    var mymonth = date.getMonth()+1;     
    var myweekday = date.getDate();      
         
    if(mymonth < 10){     
        mymonth = "0" + mymonth;     
    }      
    if(myweekday < 10){     
        myweekday = "0" + myweekday;     
    }     
    return (myyear+"-"+mymonth + "-" + myweekday);      
}  

// 获取条形码需要的日期
function getBarCodeDate(){
	var myyear = nowYear%10; 
	var mymonth = nowMonth+1;
	if(mymonth < 10){     
        mymonth = "0" + mymonth;     
    } 
    var mydate = nowDay;      
    if(mydate < 10){     
    	mydate = "0" + mydate;     
    }  
    return myyear+mymonth+mydate;
}
    
//获得某月的天数     
function getMonthDays(myMonth){     
    var monthStartDate = new Date(nowYear, myMonth, 1);      
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);      
    var days = (monthEndDate - monthStartDate)/oneDay;      
    return days;      
}     
    
//获得本季度的开始月份     
function getQuarterStartMonth(){     
    var quarterStartMonth = 0;     
    if(nowMonth<3){     
       quarterStartMonth = 0;     
    }     
    if(2<nowMonth && nowMonth<6){     
       quarterStartMonth = 3;     
    }     
    if(5<nowMonth && nowMonth<9){     
       quarterStartMonth = 6;     
    }     
    if(nowMonth>8){     
       quarterStartMonth = 9;     
    }     
    return quarterStartMonth;     
}     
    
//获得本周的开始日期     
function getWeekStartDate() {      
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek+1);      
    return formatDate(weekStartDate);     
} 

// 获取当前时间加减天数后的日期
function getCurrAddDate(days) {
	var paramDate = new Date(nowYear,nowMonth,nowDay + parseInt(days));  
	return formatDate(paramDate);     
} 

// 时间加法
function getAddDate(param,days) {
	var arr = param.split("-");  
    var paramDate = new Date(Number(arr[0]), Number(arr[1])-1, Number(arr[2]) + parseInt(days));  
    return formatDate(paramDate);     
} 
    
//获得本周的结束日期     
function getWeekEndDate() {      
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek)+1);      
    return formatDate(weekEndDate);     
}      
    
//获得本月的开始日期     
function getMonthStartDate(){     
    var monthStartDate = new Date(nowYear, nowMonth, 1);      
    return formatDate(monthStartDate);     
}     
    
//获得本月的结束日期     
function getMonthEndDate(){     
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));      
    return formatDate(monthEndDate);     
}     
  
//获得前一月开始时间  
function getPreMonthStartDate(param){  
	var arr = param.split("-"); 
	var year = Number(arr[0]);
	var month = Number(arr[1])-1; 
	var day = Number(arr[2]);
	if(month == 0){
		year = year-1;
		month =1;
	}
    return formatDate(new Date(year, month, 1));    
} 
//获得前一月结束时间  
function getPreMonthEndDate(param){
	var lastMonthStartDate = new Date(nowYear, lastMonth, 1);  
	return formatDate(lastMonthStartDate);    
}  


//获得上月开始时间  
function getLastMonthStartDate(){  
	var lastMonthStartDate = new Date(nowYear, lastMonth, 1);  
	return formatDate(lastMonthStartDate);    
}  
  
//获得上月结束时间  
function getLastMonthEndDate(){  
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));  
    return formatDate(lastMonthEndDate);    
}  
    
//获得本季度的开始日期     
function getQuarterStartDate(){     
    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);      
    return formatDate(quarterStartDate);     
}     
    
//或的本季度的结束日期     
function getQuarterEndDate(){     
    var quarterEndMonth = getQuarterStartMonth() + 2;     
    var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));      
    return formatDate(quarterStartDate);     
}

//计算两个时间相差天数
function getMergDays(startDate,endDate){
   var strSeparator = "-"; //日期分隔符
   var oDate1;
   var oDate2;
   var iDays;
   oDate1= startDate.split(strSeparator);
   oDate2= endDate.split(strSeparator);
   var strDateS = new Date(oDate1[0], oDate1[1]-1, oDate1[2]);
   var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
   iDays = parseInt(Math.abs(strDateE - strDateS) / 1000 / 60 / 60 /24)//把相差的毫秒数转换为天数 
   return iDays ;
}
