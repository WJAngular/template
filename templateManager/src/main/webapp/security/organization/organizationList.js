/**声明全局变量**/  
//组织机构类别(3:支队  4：大队  5中队)
var deptType;
//父节点id
var parentIds=$("#parentId").val();
$(document).ready(function() {
	$("#rowParent").hide();
	$("#organizationTree").tree({
		checkbox: false,   
	    lines:true,
        url: ctx+'/organization/list.do?code='+getCurrDeptCode(),
        onLoadSuccess:function(node,data){
        },
		onClick: function(node){
			modify();
			$("#modifyForm").find("#id").val(node.id);  
			$("#modifyForm").find("#parentId").val(node.parentId);
			$("#modifyForm").find("#name").val(node.name);
			$("#modifyForm").find("#shortName").val(node.shortName);
			//父节点id
			parentIds=$("#parentId").val();
			//机构类别(默认为0)
			deptType=node.type;
			$("#type").find("option[value='"+node.type+"']").attr("selected",true);
			$("#modifyForm").find("#code").val(node.code);
			$("#modifyForm").find("#linkMan").val(node.linkMan);
			$("#modifyForm").find("#telephone").val(node.telephone);
			$("#modifyForm").find("#manager").val(node.manager);
			$("#modifyForm").find("#mobilephone").val(node.mobilephone);
			$("#modifyForm").find("#address").val(node.address);
			$("#modifyForm").find("#email").val(node.email);
			$("#modifyForm").find("#postCode").val(node.postCode);
			$("#modifyForm").find("#sortNo").val(node.sortNo);
			$("#modifyForm").find("#leafMark").val(node.leafMark);
			$("#modifyForm").find("input[name='status'][value='"+node.status+"']").attr("checked",'checked');
			$("#modifyForm").find("#remark").val(node.remark);
			$("#rowParent").hide();
		}
	});
	
	//新增下一级
	$('#addInit').click(function(){
		add();
		var parentId = $('#id').val();
		var parentName = $('#name').val();
		var parentCode = $('#code').val();
		$("#modifyForm").form("clear");
		$("#modifyForm").find("#id").val(0);  
		$("#modifyForm").find("#parentId").val(parentId);
		$("#modifyForm").find("#sortNo").val(0);
		$("#modifyForm").find("#parentOrgName").val(parentName);
		
		//机构类别
		if(parentIds==0){     //如果父节点id为0
			if(deptType==3){  //父节点的机构类别为支队时
				deptType=4;   //本身机构类别类别为大队
			}
		}else if(parentIds==1){//如果父节点为1时(代表父节点是大队)
			if(deptType==4){   //父节点的机构类别为大队时
				deptType=5;    //本身机构类别类别为中队
			}
		}
		$("#type").find("option[value='"+deptType+"']").attr("selected",true);
		$("#modifyForm").find("#code").val(parentCode);
		
		$("#modifyForm").find("#leafMark").val(1);
		$("#modifyForm").find("input[name='status'][value='1']").attr("checked",'checked');
		$("#rowParent").show();
	});
}); 

/** 执行新增 */
function add(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/organization/edit.do",
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
			reloadTree(data.code);
		}
	});
}


function reloadTree(parentCode){
	$('#organizationTree').tree({
	    url:ctx+"/organization/list.do",
	    lines:true,
	    onLoadSuccess:function(node,data){
	         var t = $(this);
		     if(data){
		         $(data).each(function(index,d){
		        	var currLength = this.code.length;
		        	var parentSubCode = parentCode.substring(0,currLength); 
		        	//alert("thisCode:"+this.code+"  currLength:"+currLength+"  parentSubCode:"+parentSubCode + "  parentCode:"+parentCode);
			        if(this.code == parentSubCode){
			            t.tree('expandAll');
			        }
		         });
		     }
	    }
	});
}

/** 执行修改 */
function modify(){
	$("#modifyForm").sgfmform({
		ajaxurl:ctx+"/organization/edit.do",
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
			reloadTree(data.code);
		}
	});
}


/** 执行删除 */
function deleteRecord(){
	var leafMark = $("#leafMark").val();
	if(leafMark == 2){
		if(confirm("确认要删除该组织信息吗，删除该节点对应的子节点信息将一起删除？")){
			executeDeleteRecord();
		}
	}else{
		if(confirm("确认要删除该组织信息吗？")){
			executeDeleteRecord();
		}
	}
	reloadTree($('#code').val());
}

function executeDeleteRecord(){
	var sendData = {
		id : $("#id").val(),
		parentId : $("#parentId").val(),
		code : $("#code").val()
	};
	$.getJSON(ctx+"/organization/delete.do",sendData,
		function(data){
			operationTips("delete","删除",data.returncode);
			reloadTree(code);
		}
	);
}

/** 查询数据 */
function searchRecord(){
}

/** 组装查询条件 */
function getSearchCondition(){
	var sendData = {
		//userName:$("#userListForm").find("#userName").val()
	};
	return sendData;
}
//判断组织编码是否重复
function checkRepeat(){
	var code = $("#code").val();
	if(code != null && code != ""){
		var sendData = {
			code : code,
			id : $("#id").val()
		};
		$.getJSON(ctx+"/organization/checkRepeat.do",sendData,
			function(data){ 
				if(data.returncode == 1){
					$.sgfmdialog(data.message,1);
				}
			}
		);
	}
}
