<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp" %>
<html>
<head>
<title>文件导入页面</title>
</head>
<body>
<div class="b_frame" id="taskContent">
	<h4 id="titleName" class="tit"></h4>
	<table border="0" cellpadding="0" cellspacing="0" class="table_edit">
		<tr>
			<td height="100px;" valign="top" align="left">
				<input type="button" value="bt_search" class="bt_search"/>
				<input type="button" value="bt_add" class="bt_add"/>
				<input type="button" value="bt_folder" class="bt_folder"/>
				<input type="button" value="bt_hand" class="bt_hand"/>
				<input type="button" value="bt_stop" class="bt_stop"/>
				<input type="button" value="bt_yse" class="bt_yse"/>
				<input type="button" value="bt_emotion" class="bt_emotion"/>
				<input type="button" value="bt_return" class="bt_return"/>
				<input type="button" value="bt_save" class="bt_save"/>
				<input type="button" value="bt_money" class="bt_money"/>
				<input type="button" value="bt_back" class="bt_back"/>
				<input type="button" value="bt_up" class="bt_up"/>
				<input type="button" value="bt_del_1" class="bt_del_1"/>
				<input type="button" value="bt_del_2" class="bt_del_2"/>
				<input type="button" value="bt_down" class="bt_down"/>
				<input type="button" value="bt_next" class="bt_next"/>
				<input type="button" value="bt_modify" class="bt_modify"/>
				<input type="button" value="bt_power" class="bt_power"/>
				<input type="button" value="bt_acitve" class="bt_acitve"/>
				<input type="button" value="bt_player" class="bt_player"/>
			</td>
		</tr>
		
		<tr>
			<td valign="top" align="left">
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_modify" class="a_modify"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_set" class="a_set"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_power" class="a_power"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_del" class="a_del"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_flag_y" class="a_flag_y"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_flag_n" class="a_flag_n"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_ys" class="a_ys"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_no" class="a_no"></a>
				<br><br>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_locked" class="a_locked"></a>	
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_unlock" class="a_unlock"></a>
				<br><br>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_unfold" class="a_unfold"></a>	
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="a_packup" class="a_packup"></a>
				<br><br>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="test1" class="test1"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="test2" class="test2"></a>
				<br><br>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="test3" class="test3"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="test4" class="test4"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="test5" class="test5"></a>
				<br><br>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="to_right" class="to_right"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="to_left" class="to_left"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="to_up" class="to_up"></a>
				<a href="javascript:void(0)" onclick="modifyShow('0')" title="to_down" class="to_down"></a>
			</td>
		</tr>
	</table>
</div>
	
</body>
</html>