<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color:  lightcyan;
}

.center-right {
	margin-top: 30px;
	float: right;
	margin-right: 220px;
	width: 73%;
}

.center-right .page {
	margin-top: 20px;
}

.center-right .table1 {
	border-collapse: collapse;
	border: 1px solid red;
	width: 700px;
	height: 120px;
}

.center-right caption {
	text-align: left;
}

.center-right .table1 td {
	border: 1px solid gray;
	text-align: center;
	font-size: 16px;
	height: 30px;
}
.center-right .table1 tr{
	background-color: lightblue;
}
.center-right .table1 tr:nth-child(2n) {
	background-color: white;
}

.clickbuttonLook {
	border: 1px solid black;
	text-align: center;
	margin-left: 350px;
	width:50px;
		background-color:white;
}
.clickbuttonLook a{
	text-decoration: none;
	font-size: 16px;
}
.clickbuttonLook a:link {
	color: black;
}

.clickbuttonLook a:visited {
	color: black;
}

.clickbuttonLook a:hover {
	color: black;
}

.clickbuttonLook a:active {
	color: black;
	background-color:gray;
}
</style>
<body>
	<div class="center-right">
		<div class="page_top">
			个人中心&gt;最新通知
		</div>
		<div class="page">
			<table border="1" class="table1" style="font-size:15px;">
			<caption><strong>详细信息</strong></caption>
			<tr>
				<td>会议名称</td>
				<td>${meet.meeting_name}</td>
			</tr>
 			<tr>
				<td>会议室</td>
				<td>${meet.room_name}</td>
			</tr>
 			<tr>
				<td>起始时间</td>
				<td><fmt:formatDate value="${meet.startime  }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
				
			</tr>			
			<tr>
				<td>结束时间</td>
				<td><fmt:formatDate value="${meet.endtime  }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>预约时间</td>
				<td><fmt:formatDate value="${meet.booktime  }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>参会人数</td>
				<td>${meet.meeting_number}</td>
			</tr>									
			<tr>
				<td>会议备注</td>
				<td>${meet.meeting_notes}</td>
			</tr> 
			<tr>
				<td>与会人员</td>
				<td>${qingu }</td>
			</tr>
			</table>
		</div>
		<div class="clickbuttonLook" style="margin-top:50px;">
			<a href="meetshow1.do">返回</a>
		</div>
	</div>
</body>
</html>