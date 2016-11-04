$(function(){
	searchRecord();
	// 新增字典类型按钮事件
	$("#add_base_show_btn").click(function(){
		add("parent");
		$("#isChildMenuOpt").val(false);
		clsModifyForm("parent");
		showFlagDiv("modifyTypeDiv");
	});
	
	// 新增字典明细按钮事件
	$("#add_child_show_btn").click(function(){
		add("child");
		$("#isChildMenuOpt").val(true);
		clsModifyForm("child");
		$("input[name='dictionaryId']").val($("#base_list").find("input[name='check_list']:checked").val());
		if($("#child_list tr:eq(1) td:eq(2)").text() == ''){
			$("input[name='itemSort']").val(1);
		}else{
			$("input[name='itemSort']").val(parseInt($("#child_list tr:eq(1) td:eq(2)").text())+1);
		}
		showFlagDiv("modifyItemDiv");
	});
});

/** 执行新增字典类型 **/
function add(optType){
	if(optType == 'child'){
		$("#modifyItemForm").sgfmform({
			ajaxurl:ctx+"/dictionary/item/add.do",
			submittype:2,
			tiptype:1,
			callback:function(data,url){
				operationTipsDict("add","新增",data.returncode,data.dictionaryId);
			}
		});
	}else{
		$("#modifyTypeForm").sgfmform({
			ajaxurl:ctx+"/dictionary/type/add.do",
			submittype:2,
			tiptype:1,
			callback:function(data,url){
				operationTipsDict("add","新增",data.returncode,data.dictionaryId);
			}
		});
	}
}

/** 执行新增字典信息 **/
function modify(optType){
	if(optType == 'child'){
		$("#modifyItemForm").sgfmform({
			ajaxurl:ctx+"/dictionary/item/update.do",
			submittype:2,
			tiptype:1,
			callback:function(data,url){
				operationTipsDict("update","修改",data.returncode,data.dictionaryId);
			}
		});
	}else{
		$("#modifyTypeForm").sgfmform({
			ajaxurl:ctx+"/dictionary/type/update.do",
			submittype:2,
			tiptype:1,
			callback:function(data,url){
				operationTipsDict("update","修改",data.returncode,data.dictionaryId);
			}
		});
	}
}

/** 执行查询 */
function searchRecord(dictionaryId){
	var sendData = {
	};
	$("#base_list").sgfmtable({url:ctx+'/dictionary/type/list.do',
		params:sendData,
		"ajaxtype":"post",
		"rowClickCallback":function(data,td){
			$("#base_list").find("input[name='check_list'][value='"+data.dictionaryId+"']").attr("checked",'checked');			
			queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
			
			$("input[name='check_list'][value='"+data.dictionaryId+"']").attr("checked",'checked');
			queryChildRecord(data.dictionaryId);
		}},function(){
			if(dictionaryId == undefined || dictionaryId == 0){
				$("#base_list").find("input[name='check_list']:first").attr("checked",'checked');
			}else{
				$("#base_list").find("input[type='radio'][name='check_list']").each(function(e){
					if($(this).val() == dictionaryId){
						$(this).attr("checked",'checked');
					}
				});
			}
			queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
	});
}

/** 查询字典明细 */
function queryChildRecord(dictionaryId){
	var sendData = {
		dictionaryId:dictionaryId
	};
	$("#child_list").sgfmtable({url:ctx+'/dictionary/item/list.do',params:sendData,"ajaxtype":"post"});
}

/**  获取修改按钮 */
function getModifyBtnDict(oId, otherValue) {
    return "<a href=\"javascript:void(0)\" onclick=\"modifyShowDict('" + oId + "','" + otherValue + "')\" title=\"修改\" class=\"a_modify\">&nbsp;</a>";
}

/** 显示修改层 */
function modifyShowDict(oId,otherValue) {
	$("#modifyForm input:enabled").removeClass('Validform_error');
	clsModifyForm(otherValue);
	getModifyInfo(oId,otherValue);
	if(otherValue == 'child'){
		showFlagDiv("modifyItemDiv");
	}else{
		showFlagDiv("modifyTypeDiv");
	}
}

/** 初始化修改 */
function getModifyInfo(oId,optType){
	changChildFlag(optType);
	modify(optType);
	if(optType == 'child'){
		$.getJSON(ctx+"/dictionary/item/read.do?itemId="+oId,"",
			function(data){
				$("input[name='dictionaryId']").val(data.dictionaryId);
				$("input[name='itemId']").val(data.itemId);
				$("input[name='itemName']").val(data.itemName);
				$("input[name='itemValue']").val(data.itemValue);
				$("input[name='itemSort']").val(data.itemSort);
			}
		);
	}else{
		$.getJSON(ctx+"/dictionary/type/read.do?dictionaryId="+oId,"",
			function(data){
				$("input[name='dictionaryId']").val(data.dictionaryId);
				$("input[name='dictionaryCode']").val(data.dictionaryCode);
				$("input[name='dictionaryName']").val(data.dictionaryName);
			}
		);
	}
}

/** 执行删除 */
function delRecord1(oId,optType){
	changChildFlag(optType);
	if(optType == 'child'){
		if(confirm("您确定要删除字典明细吗？")){
			$.getJSON(ctx+"/dictionary/item/delete.do?itemId="+oId,"",
				function(data){
					operationTipsDict("delete","删除",data.returncode,0);
				}
			);
		}
	}else{
		if(confirm("您确定要删除字典类型吗？")){
			$.getJSON(ctx+"/dictionary/type/delete.do?dictionaryId="+oId,"",
				function(data){
					operationTipsDict("delete","删除",data.returncode,0);
				}
			);
		}
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

/** 打印提示信 */
function operationTipsDict(optType,message,returncode,dictionaryId){
	if(optType == 'add' || optType == 'update'){
		$.Hidemsg();
	}
	if(returncode == 0){
		$.sgfmdialog(message+"成功！",2);
		var optType = $("#isChildMenuOpt").val();
		if(dictionaryId == 0 && optType=='false'){
			searchRecord(dictionaryId);
		}else{
			queryChildRecord($("#base_list").find("input[name='check_list']:checked").val());
		}
	}else{
		$.sgfmdialog(message+"失败！",1);
	}
}

/** 清空字典表单 */
function clsModifyForm(optType){
	if(optType == 'child'){
		$("input[name='dictionaryId']").val(0);
		$("input[name='itemId']").val(0);
		$("input[name='itemName']").val('');
		$("input[name='itemValue']").val('');
		$("input[name='itemSort']").val(0);
	}else{
		$("input[name='dictionaryId']").val(0);
		$("input[name='dictionaryCode']").val('');
		$("input[name='dictionaryName']").val('');
	}
}