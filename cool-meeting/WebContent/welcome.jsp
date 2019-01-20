<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: lightcyan;
}

.top {
	width: 1000px;
	height: 110px;
	background-color: #87CEEB;
	margin-left: 250px;
	border-radius: 10px;
}

.top .top-left {
	float: left;
	width: 20%;
	height: 100px;
	margin-left: 20px;
}

.top .top-middle {
	float: left;
	font-family: "微软雅黑";
	font-size: 28px;
	margin: 40px;
	margin-left: 120px;
	height: 20px;
}

.top .top-right {
	float: right;
	margin-top: 120px;
}

.top img {
	width: 200px;
	height: 100px;
	margin-top: 10px;
}

ul {
	list-style-type: none;
}

a {
	cursor: pointer;
	font-size: 14px;
}

a:link {
	color: gray;
}

a:visited {
	color: gray;
}

a:hover {
	color: blue;
}

a:active {
	color: blue;
}

.center {
	width: 900px;
	height: 500px;
	margin-left: 250px;
}

.center .center-right {
	margin-top: 80px;
	margin-left: 250px;
}

td {
	height: 50px;
	vertical-align: bottom;
	text-align: right;
}

.buttom {
	width: 900px;
	height: 100px;
	margin-left: 250px;
}

.buttom .buttom-left {
	float: left;
	margin-left: 300px;
}

.buttom .buttom-right {
	float: left;
	margin-top: 40px;
}

.buttom .buttom-left img {
	height: 80px;
	width: 100px;
}

.linkg {
	text-decoration: none;
}

.table {
	margin-left: 100px;
}
</style>
</head>
<body>
	<div class="top">
		<div class="top-left">
			<img src="img/header.png">
		</div>
		<div class="top-middle">欢迎访问Cool-Meeting管理系统</div>
	</div>
	<div class="center">
		<div class="center-right">
			<div>登录</div>
			</br>
			<form action="${pageContext.request.contextPath }/loginshow.do"
				method="post">
				<fieldset style="width: 500px;">
					<legend>登录信息</legend>
					<table class="table">
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="password" name="code" /></td>
						</tr>
					</table>
					<div style="margin-left: 170px; margin-top: 50px;">
						<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="reset" value="重置" />
					</div>
				</fieldset>
			</form>
			<div>${message}</div>
		</div>
	</div>
	<div class="buttom">
		<div class="buttom-left">
			<img src="img/footer.png" />
		</div>
		<div class="buttom-right">
			如有问题，请联系 <a href="#" class="linkg">管理员</a>
		</div>
	</div>
</body>
</html>