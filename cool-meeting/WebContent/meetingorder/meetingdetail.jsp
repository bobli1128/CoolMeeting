<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: lightcyan;
}

.center-right caption {
	text-align: left;
	font-size: 20px;
}

.click {
	border: 1px solid black;
	padding: 0 5px;
	text-align: center;
	color: black;
	text-decoration: none;
	font-size: 15px;
}

.check {
	border-collapse: collapse;
	align-content: center;
	border: 1px solid gray;
	width: 700px;
	margin-top:10px;
}

.check caption {
	text-align: left;
	font-size: 18px;
	font-weight: bold;
}

.check tr {
	text-align: center;
	height:35px;
	font-size:15px;
}

.check tr:nth-child(2n+1) {
	background-color: lightblue;
}

.check tr:nth-child(2n) {
	background-color: white;
}

.room {
	padding-bottom: 15px;
}

.d {
	margin-top: 20px;
	margin-left: 300px;
}
</style>
<body>
	<div class="center-right">
		<div class="room">会议预定&gt;查看会议室</div>
		<div>
			<table border="1" class="check" cellpadding="0" cellspacing="0">
				<caption>会议室详情：</caption>
				<tr>
					<td><strong>门牌编号</strong></td>
					<td>${room.roomid }</td>
				</tr>
				<tr>
					<td><strong>会议室名称</strong></td>
					<td>${room.roomname }</td>
				</tr>
				<tr>
					<td><strong>容纳人数</strong></td>
					<td>${room.capacity }</td>
				</tr>
				<tr>
					<td><strong>当前状态</strong></td>
					<td>${room.roomstate }</td>
				</tr>
				<tr>
					<td><strong>备注</strong></td>
					<td>${room.notes }</td>
				</tr>
			</table>
		</div>
		<div class="d">
			<a class="click" href="roomshow.do">返回</a>
		</div>
	</div>
</body>
</html>