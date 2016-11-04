$(function(){
	searchRecord();
	// 新增父菜单按钮事件
	$("#add_base_show_btn").click(function(){
		add();
		$("#isChildMenuOpt").val(false);
		clsModifyForm();
		$("input[name='menuSort']").val(parseInt($("#base_list tr:eq(1) td:eq(5)").text())+1);
		showModifyDiv();
	});
	
	// 新增子菜单按钮事件
	$("#add_child_show_btn").click(function(){
		add();
		$("#isChildMenuOpt").val(true);
		clsModifyForm();
		$("input[name='parentMenuId']").val($("#base_list").find("input[name='check_list']:checked").val());
		if($("#child_list tr:eq(1) td:eq(4)").text() == ''){
			$("input[name='menuSort']").val(1);
		}else{
			$("input[name='menuSort']").val(parseInt($("#child_list tr:eq(1) td:eq(4)").text())+1);
		}
		showModifyDiv();
	});
});

/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/menu/add.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips1("add","新增",data.returncode,data.menuId,data.parentMenuId);
		}
	});
}

/** 执行修改 */
function modify(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/menu/update.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips1("update","修改",data.returncode,data.menuId,data.parentMenuId);
		}
	});
}

/** 打印提示信 */
function operationTips1(optType,message,returncode,menuId,parentMenuId){
	if(optType == 'add' || optType == 'update'){
		$.Hidemsg();
	}
	if(returncode == 0){
		$.sgfmdialog(message+"成功！",2);
		var optType = $("#isChildMenuOpt").val();
		if(parentMenuId == 0 && optType=='false'){
			searchRecord(menuId);
		}else{
			queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
		}
	}else{
		$.sgfmdialog(message+"失败！",1);
	}
}

/** 查询基础菜单 */
function searchRecord(menuId){
	var sendData = {
		menuName:$("#baseMenuName").val(),
		pageSize:10
	};
	$("#base_list").sgfmtable({url:ctx+'/menu/list.do',
	params:sendData,
	"ajaxtype":"post",
	pagenoname:"pageNo",
	isaddrow:true,
	"rowClickCallback":function(data,td){
		$("#base_list").find("input[name='check_list'][value='"+data.menuId+"']").attr("checked",'checked');
		queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
	}},function(){
		//alert(menuId == undefined || menuId == 0);
		if(menuId == undefined || menuId == 0){
			$("#base_list").find("input[name='check_list']:first").attr("checked",'checked');
		}else{
			$("#base_list").find("input[type='radio'][name='check_list']").each(function(e){
				if($(this).val() == menuId){
					$(this).attr("checked",'checked');
				}
			});
		}
		queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
	});
}

/** 查询子菜单 */
function queryChildRecord(parentMenuId){
	var sendData = {
		parentMenuId:parentMenuId,
		pageSize:10
	};
	$("#child_list").sgfmtable({url:ctx+'/menu/list.do',
	params:sendData,
	"ajaxtype":"post",
	pagenoname:"pageNo",
	isaddrow:true,
	"rowClickCallback":function(data,td){
	}},function(){
	});
}

/** 初始化修改 */
function getModifyInfo(oId,optType){
	changChildFlag(optType);
	modify();
	$.getJSON(ctx+"/menu/read.do?menuId="+oId,"",
		function(data){
			$("input[name='menuId']").val(data.menuId);
			$("input[name='parentMenuId']").val(data.parentMenuId);
			$("input[name='menuName']").val(data.menuName);
			$("input[name='menuIcon']").val(data.menuIcon);
			$("input[name='menuUrl']").val(data.menuUrl);
			$("input[name='status'][value='"+data.status+"']").attr("checked",'checked');
			$("input[name='menuSort']").val(data.menuSort);
			$("textarea[name='description']").val(data.description);
		}
	);
}

/** 执行删除 */
function delRecord1(oId,optType){
	changChildFlag(optType);
	if(confirm("您确定要删除菜单吗？")){
		$.getJSON(ctx+"/menu/delete.do?menuId="+oId,"",
			function(data){
				operationTips1("delete","删除",data.returncode,0,0);
			}
		);
	}
}

/** 改变菜单状态 */
function changeState1(oId,status,optType){
	changChildFlag(optType);
	var stateTip = (status==1?"激活":"禁用");
	if(confirm("您确定要"+stateTip+"此菜单信息吗？")){
		var sendData = {
			menuId : oId,
			status : status
		};
		$.getJSON(ctx+"/menu/changestate.do",sendData,
			function(data){
				operationTips1("changestate",stateTip,data.returncode,data.menuId,data.parentMenuId);
			}
		);
	}
}

/** 修改是否子菜单标识 */
function changChildFlag(optType){
	if(optType == 'child'){
		$("#isChildMenuOpt").val(true);
	}else{
		$("#isChildMenuOpt").val(false);
	}
}

/** 清空表单 */
function clsModifyForm(){
	$("input[name='menuId']").val(0);
	$("input[name='parentMenuId']").val(0);
	$("input[name='menuName']").val('');
	$("input[name='menuIcon']").val('');
	$("input[name='menuUrl']").val('');
	$("input[name='status']").val(['1']);
	$("input[name='menuSort']").val('');
	$("textarea[name='description']").val('');
}