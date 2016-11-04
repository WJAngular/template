<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<script type="text/javascript">
	var counter = 0; // 加个计数参数
	// 伸缩 frame
	function folder() {
		counter++;
		if (counter % 2 == 1) { // 单数点击
			parent.erpframe.cols = "0,8,*";
		} else {
			parent.erpframe.cols = "160,8,*";
		}
	}
</script>
</head>
<body leftmargin="0" topmargin="0" style="cursor:pointer" onclick="folder()" bgcolor="#E4EDFB">
</body>
</html>
