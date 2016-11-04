$(function(){
	searchRecord();
	
	// 新增按钮事件
	$("#add_show_btn").click(function(){
		add();
		clsModifyForm();  
		showModifyDiv();
	});
	//文本框焦点事件
	$("#userSort").focus(function(){changeZeroToNull(this);}).blur(function(){changeNullToZero(this);});
});
var LODOP = document.getElementById("LODOP"); //声明为全局变量 
//判断插件是否能够使用以及获得LODOP属性
function getLodop(oOBJECT,oEMBED){
	        var strHtml1="<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='install_lodop.exe'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
	        var strHtml2="<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='install_lodop.exe'>执行升级</a>,升级后请重新进入。</font>";
	        var strHtml3="<br><br><font color='#FF00FF'>(注：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸载它)</font>";
	        var LODOP=oEMBED;		
		try{		     
		     if (navigator.appVersion.indexOf("MSIE")>=0) LODOP=oOBJECT;
		     if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
			 if (navigator.userAgent.indexOf('Firefox')>=0)
	  	         document.documentElement.innerHTML=strHtml3+document.documentElement.innerHTML;
			 if (navigator.appVersion.indexOf("MSIE")>=0) document.write(strHtml1); else
			 document.documentElement.innerHTML=strHtml1+document.documentElement.innerHTML;
		     } else if (LODOP.VERSION<"6.0.1.2") {
			 if (navigator.appVersion.indexOf("MSIE")>=0) document.write(strHtml2); else
			 document.documentElement.innerHTML=strHtml2+document.documentElement.innerHTML; 
		     }
		     //*****如下空白位置适合调用统一功能:*********	     


		     //*******************************************
		     return LODOP; 
		}catch(err){
		     document.documentElement.innerHTML="Error:"+strHtml1+document.documentElement.innerHTML;
		     return LODOP; 
		}
	}
/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/user/add.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			if(data.returncode == 1){
				$.sgfmdialog(data.message,1);
				$.Hidemsg();
			}else{
				$.sgfmdialog("新增成功!",2);
				$.Hidemsg();
				searchRecord();
			}
		}
	});
}

/** 执行修改 */
function modify(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/user/update.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			if(data.returncode == 1){
				$.sgfmdialog(data.message,1);
				$.Hidemsg();
			}else{
				$.sgfmdialog("修改成功!",2);
				$.Hidemsg();
				searchRecord();
			}
		}
	});
}

/** 改变用户状态 */
function changeState(oId,status){
	var stateTip = (status==1?"激活":"禁用");
	if(confirm("您确定要"+stateTip+"此用户信息吗？")){
		var sendData = {
			userId : oId,
			status : status
		};
		$.ajaxSetup({cache: false}); 
		$.getJSON(ctx+"/user/changestate.do",sendData,
			function(data){
				operationTips("changestate",stateTip,data.returncode);
			}
		);
	}
}

/** 打印密码 */
function printPasswords(){
	$("#printUserId").val(getCheckValue());
	window.open(ctx+"/security/user/printPassword.jsp","printUserInfo",'toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}


/** 点击打印密码 */
function printPassword(oId){
	var sendData = {
		userId : oId
	};
	$.getJSON(ctx+"/user/changeprint.do",sendData);
	searchRecord();
}

/** 执行删除 */
function delRecord(oId){
	if(confirm("您确定要删除用户信息吗？")){
		var sendData = {
			userId : oId
		};
		$.ajaxSetup({cache: false}); 
		$.getJSON(ctx+"/user/delete.do",sendData,
			function(data){
				if(data.returncode == 1){
					$.sgfmdialog(data.message,1);
				}else{
					$.sgfmdialog("删除成功!",2);
					searchRecord();
				}
			}
		);
	}
}

/** 导出excel */
function exportExcel(){
	status=1;
	deptCode=$("#searchDeptCode").val();
	window.location.href= ctx+"/user/export.do?deptCode="+deptCode;
}

/** 执行查询 */
function searchRecord(){
	if($("#searchDeptCode").val() != undefined && ($("#searchDeptCode").val() == null || $("#searchDeptCode").val() == "")){
		$("#searchDeptName").val(getCurrDeptName());
		$("#searchDeptCode").val(getCurrDeptCode());
	}
	var sendData = {
		userName:$("#searchUserName").val(),
		account:$("#searchAccount").val(),
		deptCode:$("#searchDeptCode").val()
	};
	$("#table_list").sgfmtable({url:ctx+'/user/list.do',
	params:sendData,
	"ajaxtype":"post",
	pagenoname:"pageNo",
	isaddrow:true,
	"rowClickCallback":function(data,td){
		if($("input[name='check_list'][value='"+data.userId+"']").attr("checked")){
			$("input[name='check_list'][value='"+data.userId+"']").attr("checked",'');
			$(td).parent().parent().css('background','#ffffff');
		}else{
			$("input[name='check_list'][value='"+data.userId+"']").attr("checked",'checked');
		}
	}},function(){
	});
}
/** 初始化修改 */
function getModifyInfo(oId){
	modify();
	var sendData = {
		userId : oId
	};
	$.ajaxSetup({cache: false}); 
	$.getJSON(ctx+"/user/read.do",sendData,
		function(data){
			if(data.returncode == 0){
				$("input[name='userId']").val(data.userId);
				$("input[name='deptId']").val(data.deptId);
				$("input[name='deptCode']").val(data.deptCode);
				$("input[name='deptName']").val(data.deptName);
				$("input[name='userName']").val(data.userName);
				$("input[name='account']").val(data.account);
				$("input[name='identityCard']").val(data.identityCard);
				$("input[name='nativePlace']").val(data.nativePlace);
				$("input[name='qqNumber']").val(data.qqNumber);
				$("input[name='email']").val(data.email);
				$("input[name='mobilephone']").val(data.mobilephone);
				$("input[name='telephone']").val(data.telephone);
				$("input[name='birthday']").val(data.birthday);
				$("input[name='relationAddress']").val(data.relationAddress);
				$("input[name='creatorId']").val(data.creatorId);
				$("input[name='creatorName']").val(data.creatorName);
				$("input[name='userSort']").val(data.userSort);
				$("#educationDegree").find("option[value='"+data.educationDegree+"']").attr("selected",true);
				$("input[name='sex'][value='"+data.sex+"']").attr("checked",'checked');
				$("input[name='status']").val(data.status);
				$("input[name='post'][value='"+data.post+"']").attr("checked",'checked');
				$("input[name='userType'][value='"+data.userType+"']").attr("checked",'checked');
				$("input[name='photo']").val(data.photo);
				$("input[name='photoPath']").val(data.photoPath);
				$("textarea[name='remark']").val(data.remark);
			}else{
				$.sgfmdialog("查询业务单据失败！",1);
			}
		}
	);
}

/** 用户类型json转换 ***/
function formatPostType(value){
	var json = eval('('+$("#postTypeJson").val()+')');
	var result = "";
	if(value != null){
		var postTypes =  value.split(",");
		if(postTypes.length > 1){
			for(var i = 0;i < postTypes.length;i++){
				result = result + json[postTypes[i]]+" "
			}
		}else{
			result = json[postTypes]
		}
	}
	return result;
}

/**  获取分配用户角色按钮 */
function getRoleBtn(oId) {
	return "<a href=\"javascript:void(0)\" onclick=\"userMappingRoleShow('userMappingRoleDiv','" + oId + "')\" title=\"用户角色\" class=\"a_power\">&nbsp;</a>";
}

/** 显示用户角色映射层 */
function userMappingRoleShow(divId,oId) {
	getUserMappingRole(oId);
	showFlagDiv(divId);
}

/** 获取用户角色对应关系 */
function getUserMappingRole(oId){
	$.ajaxSetup({cache: false}); 
	$.getJSON(ctx+"/user/query/role.do?userId="+oId,"",
		function(data){
			var html = '';
			$.each(data.all, function(i, v) {
				html += "<tr height='22px;'><td align='left'><label>&nbsp;<input id='role"+v.roleId+"' type='checkbox' value='"+v.roleId+"'>&nbsp;"+v.roleName+"</label></td></tr>";
			});
			$("#userMappingRole").html(html);

			$.each(data.current, function(i, v) {
				$("#userMappingRole").find("#role"+v.roleId).attr("checked",'checked');
			});
			$("#mappingUserId").val(oId);
		});
}

/** 保存用户角色对应关系 */
function saveUserRoleMapping(){
	var selectRoles = "";
	$("#userMappingRole").find("input[type=checkbox]:checked").each(function() {
		selectRoles += $(this).val() + ";";
	 })
	var userId = $("#mappingUserId").val();
	var sendData = {
		userId : userId,
		roleId : selectRoles
	};
	$.ajaxSetup({cache: false}); 
	$.getJSON(ctx+"/user/mapping/role.do",sendData,
		function(data){
			$.sgfmdialog("成功给该用户授权了"+data+"个权限",2);
			searchRecord();
		}
	);
}

/**判断用户账号是否重复*/
function checkAccountRepeat(){
	var account = $("#account").val();
	if(account != null && account != ""){
		var sendData = {
			account : account,
			userId : $("#userId").val()
		};
		$.getJSON(ctx+"/user/checkAccountRepeat.do",sendData,
			function(data){ 
				if(data.returncode == 1){
					$.sgfmdialog(data.message,1);
				}
			}
		);
	}
}


/** 清空表单 */
function clsModifyForm(){
	$("input[name='password']").val('');
	$("input[name='userId']").val('0');
	$("input[name='deptId']").val(getCurrDeptId());
	$("input[name='deptCode']").val(getCurrDeptCode());
	$("input[name='deptName']").val(getCurrDeptName());
	$("input[name='userName']").val('');
	$("input[name='account']").val('');
	$("input[name='identityCard']").val('');
	$("input[name='nativePlace']").val('');
	$("input[name='qqNumber']").val('');
	$("input[name='email']").val('');
	$("input[name='mobilephone']").val('');
	$("#educationDegree").find("option[value='4']").attr("selected",true);
	$("input[name='telephone']").val('');
	$("input[name='birthday']").val('');
	$("input[name='relationAddress']").val('');
	$("input[name='creatorId']").val(getCurrUserId());
	$("input[name='creatorName']").val(getCurrUserName());
	$("input[name='userSort']").val('');
	$("input[name='sex'][value='1']").attr("checked",'checked');
	$("input[name='status']").val('');
	$("input[name='post'][value='1']").attr("checked",'checked');
	$("input[name='userType'][value='1']").attr("checked",'checked');
	$("input[name='photo']").val('');
	$("input[name='photoPath']").val('');
	$("textarea[name='remark']").val('');
}

//清空查询条件
function clsSearchCondition(){
	$("#searchDeptName").val('');
	$("#searchDeptCode").val('');
	$("#searchUserName").val('');
	$("#searchAccount").val('');
}

//文件上传按钮-弹出文件上传窗口 方式二(多文件上传)
function fileUploadInit(){
	var extensions = "";
	var mimeTypes = "";
	indexStart = layer.open({
		type : 2,
		title : '上传文件',
		area : ['600px', '250px'], //宽高
		shadeClose : false, //开启遮罩关闭
		skin : 'layui-layer-rim', //加上边框callBackParamsString
		content: ctx+'/upload/fileUploadZip.jsp?extensions=' + extensions + '&mimeTypes=' + mimeTypes + '&fileSizeLimit=524288000&callBackFunctionName=setFilePath&=uploadFile&fileNumLimit=1&fileType=user'
	});
}


//设置文件路径
function setFilePath(json,callbackParam){
	console.log(json);
	var fileHtml = "";
	var attachment="";//上传的文件路径以","分开
	var fileNames="";//文件名称
	for (var i = 0; i < json.length; i++){
		$("#photo").val(json[i].fileName);
		$("#photoPath").val(json[i].filePath);
	}
	layer.close(indexStart);
}