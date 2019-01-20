<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color:  lightcyan;
}

.table {
	border-collapse: collapse; /*让表格边线变成单根实线*/
	width: 700px;
	/*height: 300px;*/
	border: 1px solid red;
	margin-top: 30px;
	font-size: 14px;
}

.center_right caption {
	text-align: left;
	font-size: 10px;
	font-family: "微软雅黑";
	margin-bottom: 15px;
}

.table tr {
	height: 30px;
	background-color: lightblue;
}

.table td {
	border: 1px solid gray;
	text-align: center;
}

.table tr:nth-child(2n) { /*对偶数行的表格内容进行修改*/
	background-color: white;
}


.clickbutton {
	border: 1px solid black;
	font-size: 15px;
	width: 30px;
	height: 16px;
	margin-left:380px;
	margin-top:50px;
	padding: 4px 3px;
}
.clickbutton a{
	text-decoration: none;
}
.clickbutton a:link {
	color: black;
}

.clickbutton a:visited {
	color: black;
}

.clickbutton a:hover {
	color: black;
}

.clickbutton a:active {
	color: black;
}
</style>
</head>
<body>
		<table class="table" border="1">
			<caption>
				<strong><h3>查看详情</h3></strong>
			</caption>
			<tr class="tr1">
				<td>会议名称</td>
				<td>${mine.meeting_name }</td>
			</tr>
			<tr>
				<td>会议室名称</td>
				<td>${mine.room_name }</td>
			</tr>
			<tr>
				<td>开始时间</td>
				<td><fmt:formatDate value="${mine.starttime }"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td><fmt:formatDate value="${mine.endtime }"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>预定时间</td>
				<td><fmt:formatDate value="${mine.booktime }"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>预订者</td>
				<td>${mine.role_name }</td>
			</tr>
			<tr>
				<td>备注</td>
				<td>${mine.meeting_notes }</td>
			</tr>
			<tr>
				<td>与会人员</td>
				<td>${partners }</td>
			</tr>
		</table>
		<div class="clickbutton">
			<a href="showmymeeting.do?rid=${admin.role_id }" target="middle_right">返回</a>
		</div>
</body>
</html>