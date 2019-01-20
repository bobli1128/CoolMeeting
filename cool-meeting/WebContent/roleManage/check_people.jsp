<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="cool-meeting/js/jquery-1.6.js"></script>
<title>注册审批</title>
<style>
body {
	background-color:  lightcyan;
}

.center_right {
	margin-left: 5px;
	margin-top: 15px;
}

.table caption {
	text-align: left;
	font-size: 18px;
	margin-bottom: 15px;
	margin-left:270px;
}

.table {
	border-collapse: collapse;
	border: 1px solid gray;
	width: 700px;
	ladding: 300px;
}
.table tr{
	height:30px;
}
.table td {
	text-align: center;
}

.clickbutton {
	border: 1px solid black;
	padding: 0 8px;
	text-align: center;
	text-decoration: none;
	background-color: gainsboro;
}
.clickbutton:link {
	color: black;
}

.clickbutton:visited {
	color: black;
}

.clickbutton:hover {
	color: black;
}

.clickbutton:active {
	color: black;
	background-color: gray;
}

.table tr:nth-child(2n-1) {
	background-color: white;
}
</style>
</head>
<body>
	<div class="center_right">
		<div>
			人员管理&nbsp;&gt;&nbsp;注册审批
		</div>
		<form action="${pageContext.request.contextPath}/pass.do"
			method="get" id="form2">
			<table border="1" class="table"
				style="float: left; margin-left: 0px; font-size:15px;">
				<caption>
					<strong>所有待审批注册信息</strong>
				</caption>
				<tr style="background-color: lightskyblue;">
					<td><strong>姓名</strong></td>
					<td><strong>账号名</strong></td>
					<td><strong>联系电话</strong></td>
					<td><strong>电子邮件</strong></td>
					<td><strong>操作</strong></td>
				</tr>
				<c:forEach items="${roles }" var="role">
					<tr>
						<td>${role.role_name }</td>
						<td>${role.role_username }</td>
						<td>${role.role_tele }</td>
						<td>${role.role_mail }</td>
						<td>
							<a class="clickbutton" href="${pageContext.request.contextPath}/pass.do?role_username=${role.role_username }" onclick="return confirm('是否确定通过？')">通过</a>
							<a class="clickbutton" href="${pageContext.request.contextPath}/delete.do?role_username=${role.role_username }" onclick="return confirm('是否确定删除？')">删除</a></td>
					</tr>
				</c:forEach>	
			</table>
		</form>
	</div>
</body>
</html>