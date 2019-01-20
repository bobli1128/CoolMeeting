<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上面</title>
</head>
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript">
	function open_win() {
		if (confirm("您确定要退出吗？")) {
			window.opener = null;
			window.open("welcome.jsp", "_blank");
			parent.window.close();
		}
	}
</script>
<style>
.top-right a{
	cursor: pointer;
	font-size: 15px;
}
.top-right a:link{
	color:black;
}
.top-right a:visited{
	color:black;
}
.top-right a:hover{
	color:white;
}
.top-right a:active{
	color:white;
}
</style>
<body>
	<div class="top">
		<div class="top-left">
			<img src="img/header.png">
		</div>
		<div class="top-middle">欢迎访问Cool-Meeting管理系统</div>
		<div class="top-right">
			欢迎您，<strong>${admin.role_name}</strong> <a href="myself/changpassword.jsp" class="linkg" target="middle_right">[修改密码]</a><input type="button" value="退出" onclick="open_win()" /> 
		</div>
	</div>
</body>
</html>