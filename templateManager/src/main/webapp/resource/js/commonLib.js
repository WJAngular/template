function CommonLib(){
	this.tagName=null;
	this.getColumVal = function(key){
		 var sex;
      for(temp in this.tagName){
    	  
		    if(key==temp){
		    	sex=this.tagName[temp];
		    	break;
		    } 
	   }
	    return sex;
    }
	
   //设置标签名字
    this.setTagName = function(tagName){
    	if(tagName==''){
    		this.tagName=eval('({})');
    	}else{
    		this.tagName=eval('(' + tagName + ')');
    	}
		
	} 

}

/**
 * 获取字典表显示的值。
 * @param tagName
 * @param val
 * @returns
 */
function getDictName(tagName,val){
	var tagNameJson = eval('(' + tagName + ')');
	return tagNameJson[val];
}


/**
 * 限制文本域最大长度。
 * @param Objs 文本域对象
 * @param MaxCount 最大长度
 * @returns
 */
function TxtMaxlength(Objs,MaxCount){
	if(MaxCount==null || typeof(Number(MaxCount))!=="number") MaxCount=50;
	var ObjCou=Objs.value.length;
	if (ObjCou > MaxCount){
		Objs.value=Objs.value.substr(0, MaxCount);
	}
}
