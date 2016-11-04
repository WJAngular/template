var showMenuFlag=0;
function show_menuC(){
		if (showMenuFlag==0){
		 document.getElementById('LeftBox').style.display='none';
	  	 //document.getElementById('RightBox').style.marginLeft='0';
		 document.getElementById('RightBox').style.float='none';
		 document.getElementById('RightBox').style.width='96%';
		 document.getElementById('Mobile').style.background='url(../images/center.gif)';

		 showMenuFlag=1;
		}else{
		//document.getElementById('RightBox').style.marginLeft='190px';
		document.getElementById('RightBox').style.float='right';
		document.getElementById('RightBox').style.width='830px';
	   	document.getElementById('LeftBox').style.display='block';
		document.getElementById('Mobile').style.background='url(../images/center0.gif)';

	   showMenuFlag=0;
			}
	 }
var ajaxErrMsg="操作失败，请联系管理员【0755-110】";