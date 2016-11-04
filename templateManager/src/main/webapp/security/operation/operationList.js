$(function(){
	searchRecord();
	
	// 新增按钮事件
	$("#add_show_btn").click(function(){
		add();
		clsModifyForm();  
		showModifyDiv();
	});
});

/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/operation/add.do",
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
		ajaxurl:ctx+"/operation/update.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips("update","修改",data.returncode);
		}
	});
}

/** 改变操作状态 */
function changeState(oId,status){
	var stateTip = (status==1?"激活":"禁用");
	if(confirm("您确定要"+stateTip+"此操作信息吗？")){
		var sendData = {
			operationId : oId,
			status : status
		};
		$.getJSON(ctx+"/operation/changestate.do",sendData,
			function(data){
				operationTips("changestate",stateTip,data.returncode);
			}
		);
	}
}

/** 执行删除 */
function delRecord(oId){
	if(confirm("您确定要删除操作吗？")){
		$.getJSON(ctx+"/operation/delete.do?operationId="+oId,"",
			function(data){
				operationTips("delete","删除",data.returncode);
			}
		);
	}
}
	
/** 执行查询 */
function searchRecord(){
	var sendData = {
		operationName:$("#searchOperationName").val()
	};
	$("#table_list").sgfmtable({url:ctx+'/operation/list.do',
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
	$.getJSON(ctx+"/operation/read.do?operationId="+oId,"",
		function(data){
			$("input[name='operationId']").val(data.operationId);
			$("input[name='menuId']").val(data.menuId);
			$("input[name='operationName']").val(data.operationName);
			$("input[name='operationCode']").val(data.operationCode);
			$("input[name='status'][value='"+data.status+"']").attr("checked",'checked');
		}
	);
}

/** 清空表单 */
function clsModifyForm(){
	$("input[name='operationId']").val(0);
	$("input[name='menuId']").val(0);
	$("input[name='operationName']").val('');
	$("input[name='operationCode']").val('');
	$("input[name='status']").val(['1']);
}