<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看会议室</title>
</head>
<style>
body {
	background-color: lightcyan;
}
.click {
	border: 1px solid black;
	padding: 0 5px;
	text-align: center;
	text-decoration: none;
	background-color:gainsboro;
}
.click:link{
	color:black;
}
.click:visited{
	color:black;
}
.click:hover{
	color:black;
}
.click:active{
	color:black;
	background-color:gray;
}
.check {
	border-collapse: collapse;
	align-content: center;
	border: 1px solid gray;
	width: 700px;
}
.check caption {
	text-align: left;
	font-size: 18px;
	font-weight: bold;
}

.check tr {
	text-align: center;
	height:30px;
}
.check .tr1 {
	background-color: skyblue;
}

.check tr:nth-child(2n+3) {
	background-color: lightblue;
}

.check tr:nth-child(2n) {
	background-color:white;
}
.room {
	padding-bottom: 15px;
}
</style>
<body>
	<div class="center-right">
		<div class="room">会议预定&gt;查看会议室</div>
		<div>
			<table border="1" class="check" cellpadding="0" cellspacing="0">
				<caption>所有会议室：</caption>
				<tr class="tr1">
					<td><strong>门牌编号</strong></td>
					<td><strong>会议室名称</strong></td>
					<td><strong>容纳人数</strong></td>
					<td><strong>当前状态</strong></td>
					<td><strong>操作</strong></td>
				</tr>
				<c:forEach items="${rooms }" var="room">
					<tr>
						<td>${room.roomid }</td>
						<td>${room.roomname }</td>
						<td>${room.capacity }</td>
						<td>${room.roomstate }</td>
						<td><a class="click" href="roomshowbyid.do?id=${room.roomid}">查看详情</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>