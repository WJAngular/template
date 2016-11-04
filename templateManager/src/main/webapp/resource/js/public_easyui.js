/** 基础变量 */


/** 显示提示信息 */
function showMessage(tips){
	if(tips != undefined && tips != ''){
		$.messager.show({
			 title:'提醒',
			 msg:tips,
			 timeout:3000,
			 showType:'slide'
		});
	}
}

/** 打开居中窗口 */
function openwindow(url,name,iWidth,iHeight){
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(url,name,'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}