<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/cool-meeting/js/jquery-1.6.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		 $(".clickbuttonLook").click(function(){
			 var a=$(this).parent().prev().text();
			 alert(a);
			 
		}); 
	});
</script> -->
</head>
<style>
body {
	background-color:  lightcyan;
}

.center-right {
	margin-top: 5px;
	float: right;
	margin-right: 250px;
	width: 73%;
}

.center-right .page {
	margin-top: 20px;
}

.center-right .table1 {
	border-collapse: collapse;
	border: 1px solid red;
	width: 730px;
	font-size: 15px;
}

.center-right caption {
	text-align: left;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-bottom: 15px;
}

.center-right .table1 td {
	border: 1px solid gray;
	text-align: center;
}

.center-right .table1 tr:nth-child(2n) {
	background-color: white;
}

.t2 {
	background-color: skyblue;
	height: 35px;
}
.t1 {
	height: 35px;
}

.clickbuttonLook {
	border: 1px solid black;
	text-align: center;
	text-decoration: none;
	font-size: 15px;
	padding:0 8px;
	background-color:gainsboro;
}

.t1 a:link {
	color: black;
}

.t1 a:visited {
	color: black;
}

.t1 a:hover {
	color: black;
}

.t1 a:active {
	color: black;
	background-color:gray;
}
</style>
<body>
	<div class="center-right">
		<div class="page_top">个人中心&nbsp;&gt;&nbsp;最新通知</div>
		<div class="page">
			<table border="1" class="table1">
				<caption>
					<strong>未来七天我要参加的会议:</strong>
				</caption>
				<tr class="t2">
					<td><strong>会议名称</strong></td>
					<td><strong>会议室</strong></td>
					<td><strong>起始时间</strong></td>
					<td><strong>结束时间</strong></td>
					<td><strong>操作</strong></td>
				</tr>
				<c:forEach items="${meets}" var="meet">
					<tr class="t1">
						<td>${meet.meeting_name }</td>
						<td>${meet.room_name }</td>
						<td><fmt:formatDate value="${meet.startime }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><fmt:formatDate value="${meet.endtime  }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><a class="clickbuttonLook"
							href="meetshowD.do?mid=${meet.meeting_id}&rid=${meet.room_id}&flags=0">查看详情</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<table>
				<table border="1" class="table1">
					<caption>
						<strong>已取消的会议:</strong>
					</caption>
					<tr class="t2">
						<td><strong>会议名称</strong></td>
						<td><strong>会议室</strong></td>
						<td><strong>起始时间</strong></td>
						<td><strong>结束时间</strong></td>
						<td><strong>取消原因</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach items="${canceleeets}" var="cancelmeet">
						<tr class="t1">
							<td>${cancelmeet.meeting_name }</td>
							<td>${cancelmeet.room_name }</td>
							<td><fmt:formatDate value="${cancelmeet.startime  }"
									pattern="yyyy-MM-dd hh:mm:ss" /></td>
							<td><fmt:formatDate value="${cancelmeet.endtime  }"
									pattern="yyyy-MM-dd hh:mm:ss" /></td>
							<td>${cancelmeet.meeting_reason }</td>
							<td><a class="clickbuttonLook"
								href="meetshowD.do?mid=${cancelmeet.meeting_id}&rid=${cancelmeet.room_id}&flags=1">查看详情</a></td>
						</tr>
					</c:forEach>
				</table>
				</div>
				</div>
</body>
</html>