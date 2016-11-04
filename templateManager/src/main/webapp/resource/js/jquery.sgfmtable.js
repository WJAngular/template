// JavaScript Document
(function ($) {
	var instances;
	//对话框插件的事明
	$.fn.sgfmtable = function(settings){
		var isMethodCall = (typeof settings == 'string'),
			args = Array.prototype.slice.call(arguments, 1), 
			returnValue = this;
			
		// 如果是下划线开头的方法不让访问
		if(isMethodCall && settings.substring(0, 1) == '_') { return returnValue; }
		// 如果一个方法的调用执行方法
		if(isMethodCall) {
			this.each(function() {
				if(instances && $.isFunction(instances[settings])){ instances[settings].apply(this,args); };		
			});
		} else {
			this.each(function() {
				//调用初始化的方法
				if(!settings){settings = {};}
				init.call(this,settings,args[0]);
			});
		}
		// 返加jQuery对象	
		return returnValue;
	};
	
	//初始化对话框对象
	function init(settings,callback){
		//获取表头数据
		var $this = $(this),headNames =  get_head.call($this),
		
		//请求获取数据
		PageClick = function(pageclickednumber){
			var pageName = settings.pagenoname,params;
			var pageNo = settings.pageNo;
			//alert(pageNo + "  " +(pageNo != undefined)+" " +pageclickednumber+"  "+pageName);
			if(pageNo != undefined && pageclickednumber == undefined){
				pageclickednumber = pageNo;
			}
			if(typeof pageName !== "string" || $.trim(pageName) === ""){pageName = "pageNo";}
			if(!isNaN(pageclickednumber)){
				if(typeof settings.params === "string"){
					params = $.trim(settings.params);
					if(settings.params !== ""){params += "&";}
					params += pageName + "=" + pageclickednumber
				}else{
					if(!$.isPlainObject(settings.params)){settings.params = {};}
					settings.params[pageName] = pageclickednumber;
				}
			}
			get_info.call($this,settings,params,function(json){
				if(json.returncode == 0){
					get_tbody($this).children("tr:has(td)").remove();
					if(!isNaN(json.totalPages) && json.showPageFlag == 0){
						if(!json.pageNo){json.pageNo = 1;}
						var pagebox =  this.siblings(".quotes");
						if(pagebox.length == 0){
							if(this.data("hasCheckBox")){
								pagebox = this.find(".quotes");
							}else{
								pagebox = $("<div>").addClass("quotes");
								this.after(pagebox);
							}
						}
						pagebox.sgfmpager({ "pagenumber": json.pageNo, "pagecount": json.totalPages,"totalRow":json.totalRows, "buttonClickCallback": PageClick });
					}
					
					//填充列表
					if(json.list){	
						if(json.list.length == 0){// 如果没有查到符合条件的记录
							//alert(json.list.length);
							//alert(headNames.length);
							get_tbody(this).append("<tr><td colspan='" + headNames.length+"'>无符合条件的记录</td></tr>");
						}else{
							$.each(json.list,function(i,data){
								var startRow = json.startRow;
								if(isNaN(startRow)){startRow = 0;}
								if(!data.sequence){
									data.sequence = 1 + i + startRow;
								}
								fill_info.call($this,headNames,data,settings);
							});
							if($.isFunction(callback)){callback.call(get_tbody($this).get(0),json);}
						}
					}else{
						// 处理没有数据的错误处理信息
						 if(settings.haserrmsg){
							 $.sgfmdialog("没有数据！");
						 }
					}
				}else{
					// 处理返回的错误信息
					 if(settings.haserrmsg){
						 $.sgfmdialog("返回失败返回码：" + data.returncode);
					 }
				}
			});
		};
		PageClick.call($this);
	}
	
	//获取表格主体
	function get_tbody(obj){
		if(obj.children("tbody").length > 0)
		{
			return obj.children("tbody");
		}else{
			return obj;
		}
	}
	
	//获取表格每一列需要存放的内容
	function get_head(){
		var head,headNames = this.data("sgfmhead"),hasCheckBox = false;
		var newHeadNames;
//		alert("ss:"+get_tbody(this).html());
		if(!headNames){
			head = get_tbody(this).find("th[sgfm-binddata]");
			headNames = new Array();
			newHeadNames = new Array();
			head.each(function(i){
				var name = $(this).attr("sgfm-binddata");
				var	rowclick = $(this).attr("sgfm-rowclick");
				var	bindmode = $(this).attr("sgfm-bindmode");
				var	bindkey = $(this).attr("sgfm-bindkey");
				var	align = $(this).attr("align");
				var	colNo =  $(this).attr("colNo");
				var	tdbg =  $(this).attr("sgfm-tdbg");
				var	viewlength = $(this).attr("view-length");
				
				if(typeof name !== "string"){name = "";}
				rowclick = rowclick ? true : false;
				if(typeof bindmode !== "string"){bindmode = "";}
				if(bindmode === "checkbox"){hasCheckBox = true;}
				if(!align){align = "";}
				if(!colNo){colNo = i;}
				if(!viewlength){viewlength = 0;}
				headNames.push({"name": name,
							   "rowclick" : rowclick,
							   "bindmode" : bindmode,
							   "bindkey" : bindkey,
							   "align" : align,
							   "tdbg" : tdbg,
							   "colNo" : colNo,
							   "viewlength" : viewlength});
			});
			
			for(var i=0;i<headNames.length;i++){ 
				newHeadNames[headNames[i].colNo] = headNames[i];
			}
			
			headNames = newHeadNames;
			
			//将信息添加到表的数据中
			this.data("sgfmhead",headNames).data("colnum",headNames.length).data("hasCheckBox",hasCheckBox);
		}
		return headNames;
	}
	
	//获取列信息，返回true有链接已经发送请求，返回false链不正确没有发送请求
	function get_info(settings,params,callback){
		var type = settings.ajaxtype ? settings.ajaxtype : "GET";
		if(!params){params = settings.params;}
		if(settings.url){
			$.ajax({
				"url": settings.url,
				"context": this,
				"data": params,
				"type": type,
				"dataType": "json",
				"success": function(html){
					if(html.returncode == 0){
						callback.call(this,html);
					}else{
						$.sgfmdialog("查询失败！",1);
					}
				},"error": function(jqXHR,textStatus,errorThrown){//*对请求错误信息进行处理
					 if(settings.haserrmsg){
						 $.sgfmdialog("返回失败返回码：" + data.returncode);
					 }
				}
			});
			return true;
		}else{
			return false;
		}
	}
	
	//通过参数获取到链接地址
	function get_url(settings){
		var url = settings.url,params = settings.params;
		if(typeof url == 'string'){
			url += "?";
			if($.isPlainObject(params)){
				$.each(params, function(key, value){
					url += key + "=" + value + "&";
				});
			}
			url = url.substr(0,url.length-1);
		}else{
			url = false;
		}
		return url;
	}
	
	//填充列表信息
	function fill_info(headNames,json,settings){
		var td,td2,tr = $("<tr>").data("metadata",json),isaddrow = true,colclick = json.colclick,tmpcol,colnum = headNames.length,table = this,pk=0;
		if(typeof settings.isaddrow === "boolean"){isaddrow = settings.isaddrow;}
		//支持点击的列
		if(typeof colclick == 'string'){
			tmpcol = colclick.split(",");
			colclick = "{";
			$.each(tmpcol,function(i,col){
				colclick += '"' + col + '": true ,';
			});
			colclick = colclick.substr(0,colclick.length-1);
			colclick += "}";
			colclick = $.parseJSON(colclick)
		}else{colclick = {};}
		$.each(headNames,function(i,headInfo){
			//获取单元格显示内容
			td = getTD(headInfo,json);
			
			//如果是序号列居中
			if("" !== headInfo.align){td.attr("align",headInfo.align);}
			if(headInfo.bindkey != undefined){
				td.attr("key",json[headInfo.bindkey]);
			}
			tr.append(td);
			if(headInfo.rowclick){
				td.click(function(event){
					if(isaddrow){
						get_tbody(table).children("tr.sgfmaddtd").remove();
						td2 = $("<td>").attr("colspan",colnum).attr("align","center");
						tr.after($("<tr>").addClass("sgfmaddtd").append(td2));
						if($.isFunction(settings.rowClickCallback)){settings.rowClickCallback.call(tr.get(0),tr.data("metadata"),td2.get(0));};
					}else{
						if($.isFunction(settings.rowClickCallback)){settings.rowClickCallback.call(tr.get(0),tr.data("metadata"));};
					}
				}).css({"cursor":"pointer"});
			}
		});
		//alert(tr.html());
		get_tbody(this).append(tr);
		if($.isFunction(settings.callback)){settings.callback.call(tr.get(0));};
	}
	
	//组装TD的显示内容
	function getTD(headInfo,json){
		var html="",names=[],modes=[],td = $("<td>").css("word-break", "break-all");
		
		// td的背景颜色设置
		if(headInfo.tdbg){
			tdbgs = headInfo.tdbg.split("|");
			var tdName = tdbgs[0];
			if(json[tdName] == "" || json[tdName] == null){
				td.css("background-color", tdbgs[1]);
			}
		}
		
		if("checkbox" === headInfo.bindmode){
			return "<input type='checkbox' name='"+headInfo.name+"' value='"+json[headInfo.name]+"'  />"
		}
		if(headInfo.name){names = headInfo.name.split("|");}
		if(headInfo.bindmode){modes = headInfo.bindmode.split("|");}
		
		if(modes.length === 0){
			//将所有信息的值连接起来
			if(names.length > 0){
				$.each(names,function(i,name){
					var tmp = json[name];
					if(!tmp){tmp = "";}
					if(headInfo.viewlength > 0 && tmp.length > headInfo.viewlength){
						td.attr("title", tmp);
						tmp = tmp.substr(0,headInfo.viewlength)+"...";
					}
					html += tmp;
				});
			}
			td.html(html);
		}else if(modes.length > 1){
			var tmpMode = modes[0].toLowerCase(),evalString;
			if(tmpMode === "function"){
				var isEnd=false,objs=[]; //对象是否在后面
				evalString = modes[1].split("@");
				$.each(evalString,function(j,fun){
					var tmpHtml = "",tmp=[];
					if(names.length > 0){
						$.each(names,function(i,name){
							var stmp = "";
							tmp[i] = json[name];
							if(!tmp){
								stmp = "''";
							}else if(typeof tmp === "string"){
								stmp = "'"+tmp+"'";
							}else{
								stmp = "tmp["+i+"]";
							}
							fun = fun.replace("{"+i+"}", stmp);
						});
					}
					tmpHtml = eval(fun);
					if(typeof tmpHtml === "string"){
						html += tmpHtml;
						if(j===0){isEnd =true;}
					}else if(typeof tmpHtml !== "undefined"){
						objs.push(tmpHtml);
					}
				});
				//添加信息
				td.html(html);
				
				if(isEnd){
					$.each(objs,function(i,obj){
						td.append(obj);
					});
				}else{
					//反插入
					for(var c = objs.length - 1;c >= 0;c--){
						td.prepend(objs[c]);
					}
				}
			}else if(tmpMode === "array" || tmpMode === "json"){
				evalString = eval(modes[1]);
				if(($.isArray(evalString) || $.isPlainObject(evalString)) && names.length > 0){
					$.each(names,function(i,name){
						var tmp = json[name];
						if(typeof tmp === "string" || !isNaN(tmp)){
							if(tmp!=null && tmp!='' && tmp.toString().indexOf(",") != -1){
								var detail = tmp.split(",");
								for(var i=0;i<detail.length;i++){
									html += evalString[detail[i]]+" ";
								}
							}else{
								html += evalString[tmp];
							}
						}
					});
					
					if(html == undefined || html == 'undefined'){
						td.html("");
					}else if(typeof html === "string"){
						td.html(html);
					}else{
						td.append(html);
					}
				}
			}
		}
		return td;
	}
	
	$.sgfmtable = function(){};
	instances = $.sgfmtable._fn = {
		
	};
})(jQuery);