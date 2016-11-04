function searchRecord(){
}

// 初始化树设置
var setting = {
	async: { 
		enable: true, 
		url:ctx+"/organization/list.do", 
		autoParam:["id", "name"]
	},
	view: {
		addHoverDom: addHoverDom,
		removeHoverDom: removeHoverDom,
		selectedMulti: false
	},
	edit: {
		enable: true,
		showRenameBtn:false,
		showRemoveBtn: true,
		removeTitle: "删除节点"
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: zTreeOnClick,
		beforeRemove: beforeRemove,
		onRename: onRename,
		onRemove: onRemove
	}
};

// 点击事件
function zTreeOnClick(event, treeId, treeNode) {
	// 异步获取节点信息节点信息
	$.post(ctx+"/organization/OrganizationRead.do?id="+treeNode.id, null,
		function(data){
		 	$("#id").val(treeNode.id);
		 	$("#tId").val(treeNode.tId);
		 	$("#name").val(treeNode.name);
		}
	);
	
 	//$("#id").val(treeNode.id);
 	//$("#tId").val(treeNode.tId);
 	//$("#name").val(treeNode.name);
};

// 删除前事件
function beforeRemove(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("orgTree");
	zTree.selectNode(treeNode);
	return confirm("您确认删除" + treeNode.name + " 吗？");
}

// 执行删除操作
function onRemove(e, treeId, treeNode) {
	$.post(ctx+"/organization/OrganizationDelete.do?id="+treeNode.id, null,
		function(data){
			alert("删除成功！");
		}
	);
}

function onRename() {
	var treeId = $("#id").val();
	var tId = $("#tId").val();
	var treeObj = $.fn.zTree.getZTreeObj("orgTree");
	var treeNode = treeObj.getNodeByTId(tId);
	var treeName = $("#name").val();
	treeNode.name = treeName; 
	var orgType = $('input:radio[name="orgType"]:checked').val();
	alert(orgType);
	treeObj.updateNode(treeNode);
	$.post(ctx+"/organization/OrganizationUpdate.do", {id:treeId,name:treeName,type:orgType},
		function(data){
			alert("修改成功！");
		}
	);
}

// 显示删除按钮
function showRemoveBtn(treeId, treeNode) {
	return !treeNode.isFirstNode;
}

// 节点悬停显示新增按钮
var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='增加组织节点' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		var id = 100+parseInt(treeNode.id) + newCount;
		var pId = treeNode.id;
		var name = "组织" + (newCount++);
		var zTree = $.fn.zTree.getZTreeObj("orgTree");
		zTree.addNodes(treeNode, {id:id, pId:pId, name:name});
		$.post(ctx+"/organization/OrganizationAdd.do", {id:id,pId:pId,name:name,open:'true'},
			function(data){
				alert("添加成功！");
			}
		);
		return false;
	});
};

// 节点悬停显示删除按钮
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};
