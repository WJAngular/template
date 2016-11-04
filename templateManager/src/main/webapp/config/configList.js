$(function(){
	searchRecord();
	
	// 新增按钮事件
	$("#add_show_btn").click(function(){
		add();
		clsModifyForm();  
		showModifyDiv();
	});
});

/** 执行查询 */
function searchRecord(){
	var sendData = {
		name:$("#searchName").val(),
	};
	$("#table_list").sgfmtable({url:ctx+'/config/list.do',
	params:sendData,
	"ajaxtype":"post",
	pagenoname:"pageNo",
	isaddrow:true,
	"rowClickCallback":function(data,td){
	}},function(){
	});
}

/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/config/add.do",
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
		ajaxurl:ctx+"/config/update.do",
		submittype:2,
		tiptype:1,
		callback:function(data,url){
			operationTips("update","修改",data.returncode);
		}
	});
}

/** 初始化修改 */
function getModifyInfo(oId){
	modify();
	var sendData = {
		configId : oId
	};
	$.getJSON(ctx+"/config/read.do",sendData,
		function(data){
			if(data.returncode == 0){
				$("input[name='configId']").val(data.configId);
				$("input[name='code']").val(data.code);
				$("input[name='name']").val(data.name);
				$("textarea[name='value']").val(data.value);
				$("input[name='sortNo']").val(data.sortNo);
				$("textarea[name='description']").val(data.description);
			}else{
				$.sgfmdialog("查询业务单据失败！",1);
			}
		}
	);
}
	
/** 执行删除 */
function delRecord(oId){
	if(confirm("您确定要删除配置管理吗？")){
		var sendData = {
			configId : oId
		};
		$.getJSON(ctx+"/config/delete.do",sendData,
			function(data){
				operationTips("delete","删除",data.returncode);
			}
		);
	}
}
	
/** 清空表单 */
function clsModifyForm(){
	$("input[name='configId']").val('0');
	$("input[name='code']").val('');
	$("input[name='name']").val('');
	$("textarea[name='value']").val('');
	$("input[name='sortNo']").val('1');
	$("textarea[name='description']").val('');
}
