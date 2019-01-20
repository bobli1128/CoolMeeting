<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索员工</title>

<style>
.clickbutton {
	border: 1px solid black;
	padding: 0 5px;
	text-align: center;
	color: gray;
	text-decoration: none;
	background-color:gainsboro;
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
	background-color:gray;
}
.result {
	border-collapse: collapse;
	align-content: center;
	float: right;
	margin-right: 200px;
	border: 1px solid gray;
	width: 700px;
	border: 1px solid gray;
	font-size:15px;
}

.result td {
	text-align: center;
	height: 30px;
}

.result .tr1 {
	background-color: skyblue;
}

.result tr:nth-child(2n+3) {
	background-color: lightblue;
}

.result tr:nth-child(2n) {
	background-color: white;
}

.room {
	padding-bottom: 15px;
}

.searchworker_div3 {
	text-align: center;
}

.searchworker_div2 {
	width:800px;
}
.searchworker_div2 .div2_button {
	padding-top:10px;
	padding-left: 300px;
}

.searchworker_div4 {
	float: left;
}

.searchworker_div5 {
	float:right;
	margin-right:86px;
	font-size:14px;
	width:230px;
}
.searchworker_d{
	margin-left:52px;
	width:150px;
	padding-top:4px;
	font-size:16px;
}
.page{
	border: 1px solid black;
	padding: 0 8px;
	font-size:14px;
	text-align: center;
	text-decoration: none;
	background-color: white;
}
.page:link{
	color:black;
}
.page:visited{
	color:black;
}
.page:hover{
	color:black;
}
.page:active{
	color:black;
	background-color: gray;
}
body {
	background-color:  lightcyan;
}
</style>

</head>
<body>
	<div class="center-right">
		<div class="room">人员管理&gt;搜索员工</div>
		<div class="searchworker_div2">
			<form action="${pageContext.request.contextPath}/search.do"
				method="post">
				<fieldset>
					<legend>
						<strong>搜索员工</strong>
					</legend>
					<table style="margin-left:80px;">
						<tr>
							<td>姓名：</td>
							<td><input type="text" style="width: 100px;"
								name="search_name" /></td>
							<td>账号名：</td>
							<td><input type="text" style="width: 100px;"
								name="search_username" /></td>
							<td>状态：</td>
							<td>
								<input type="radio" name="status"  value="1" checked="checked" />已批准 
								<input type="radio" name="status" value="2" />待审批 
								<input type="radio" name="status" value="3" />已关闭</td>
						</tr>
					</table>
					<div class="div2_button">
						<input type="submit" value="查询" /> &nbsp;&nbsp;&nbsp; <input
							type="reset" value="重置" />
					</div>
				</fieldset>
			</form>
		</div>
		</br>
		<div class="searchworker_div3">
			<strong>查询结果</strong>
		</div>
		<div class="searchworker_div4">
			共<strong>${total_page }</strong>条结果，分成<strong>${pages }</strong>页显示，当前第<strong>${current_page }</strong>页
		</div>
		<div class="searchworker_div5">
			<a class="page" href="${pageContext.request.contextPath}/search.do?pages=1">首页</a>
			<c:if test="${current_page gt 1 }">
			<a class="page" href="${pageContext.request.contextPath}/search.do?pages=${current_page-1 }">上页</a>
			</c:if>
			<c:if test="${current_page lt pages }">
			<a class="page" href="${pageContext.request.contextPath}/search.do?pages=${current_page+1 }">下页</a>
			</c:if>
			<a class="page" href="${pageContext.request.contextPath}/search.do?pages=${pages }">尾页</a>
		<div class="searchworker_d">
			<form action="${pageContext.request.contextPath}/search.do" method="post">
				跳到第 <input type="text" name="pages" style="width: 15px;" /> 页&nbsp;&nbsp;<input type="submit" value="跳转"/>
			</form>
		</div>
		</div>
		<div class="searchworker_div6">
			<table border="1" class="result" cellpadding="0" cellspacing="0">
				<tr class="tr1">
					<td><strong>姓名</strong></td>
					<td><strong>账号名</strong></td>
					<td><strong>联系电话</strong></td>
					<td><strong>电子邮件</strong></td>
					<td><strong>操作</strong></td>
				</tr>
					<c:forEach items="${search_worker }" var="role">
					<tr>
						<td>${role.role_name }</td>
						<td>${role.role_username }</td>
						<td>${role.role_tele }</td>
						<td>${role.role_mail }</td>
						<td><a class="clickbutton" href="${pageContext.request.contextPath}/close.do?role_username=${role.role_username }" onclick="return confirm('是否确定关闭账号？')">关闭账号</a></td>
					</tr>
				</c:forEach> 
			</table>
		</div>
	</div>
</body>

</html>