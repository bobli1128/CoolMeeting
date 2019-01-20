<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background-color:  lightcyan;
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
}

.check caption {
	text-align: left;
	font-size: 18px;
	font-weight: bold;
}

.check tr {
	/*border: 1px solid gray;*/
	text-align: center;
	height:30px;
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
</head>
<body>
	<div class="room">个人中心&nbsp;&gt;&nbsp;搜索会议</div>
	<table border="1" class="check" cellpadding="0" cellspacing="0">
		<caption>会议详情</caption>
		<tr>
			<td>名称</td>
			<td>${booking.meeting_name }</td>
		</tr>
		<tr>
			<td>会议室门牌号</td>
			<td>${booking.room_id }</td>
		</tr>
		<tr>
			<td>开始时间</td>
			<td>${booking.startime }</td>
		</tr>
		<tr>
			<td>结束时间</td>
			<td>${booking.endtime }</td>
		</tr>
		<tr>
			<td>预定时间</td>
			<td>${booking.booktime }</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>${booking.state }</td>
		</tr>
		<tr>
			<td>参加人数</td>
			<td>${booking.meeting_number }</td>
		</tr>
		<tr>
			<td>预订者</td>
			<td>${booking.rolename }</td>
		</tr>
		<tr>
			<td>备注</td>
			<td>${booking.meeting_notes }</td>
		</tr>
		<tr>
			<td>撤销理由</td>
			<td>${booking.meeting_reason }</td>
		</tr>
		<tr>
			<td>与会人员</td>
			<td>${partner }</td>
		</tr>
	</table>
	<div class="d">
		<a class="click"
			href="${pageContext.request.contextPath }/meetingorder/searchmeeting.do?pages=${pageindex}">返回</a>
	</div>
</body>
</html>