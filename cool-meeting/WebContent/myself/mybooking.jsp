<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的预定</title>
<script type="text/javascript" src="/cool-meeting/js/jquery-1.6.js"></script>
<script>
	$(function() {
		$(".clicka")
				.click(
						function() {
							var tt = td = $(this).parent().parent()
							var td = $(this).parent().parent().prev().prev()
									.prev().prev().prev().prev().text();
							var f = "<div id='check'>请输入理由："
									+ "<form action='${pageContext.request.contextPath }/myself/bookingupdate.do' method='post'>"
									+ "<input type='text' name='reason'/>"
									+ "<input type='hidden' name='id' value='"+td+"'>"
									+ "<input type='submit' value='确定'/>"
									+ "<input type='button' class='in' value='取消'/>"
									+ "</form></div>";
							tt.append(f);
							$(".in").click(function() {
								$("#check").remove();
							})
						})
	})
</script>
<style>
body {
	background-color:  lightcyan;
}

.title {
	margin-top: 15px;
}
.center_right caption {
	text-align: left;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-bottom: 15px;
}

.table td {
	border: 1px solid gray;
	text-align: center;
	width: 120px;
}

.table tr:nth-child(2n) { /*对偶数行的表格内容进行修改*/
	background-color: white;
}

.tr1 {
	background-color: skyblue;
	font-size: 14px;
	height: 40px;
}

.clickbutton {
	border: 1px solid black;
	width: 80px;
	height: 16px;
	font-size: 14px;
	margin-left: 20px;
	padding: 4px 0;
}

.clickbutton a:link {
	text-decoration: none;
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
	background-color:gray;
}

.table {
	border-collapse: collapse; /*让表格边线变成单根实线*/
	border: 1px solid red;
	margin-top: 50px;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="center_right">
		<div class="title">个人中心&nbsp;&gt;&nbsp;我的预定</div>
		<table border="1" class="table" style="margin-top: 20px">
			<caption>
				<strong>我预定的会议</strong>
			</caption>
			<tr class="tr1">
				<td style="display: none;">会议编号</td>
				<td><strong>会议名称</strong></td>
				<td><strong>会议室名称</strong></td>
				<td><strong>会议起始时间</strong></td>
				<td><strong>会议结束时间</strong></td>
				<td><strong>会议预定时间</strong></td>
				<td><strong>操作</strong></td>
			</tr>
			<c:forEach items="${mybookings }" var="booking">
				<tr style="height: 40px;">
					<td style="display: none;">${booking.meeting_id }</td>
					<td>${booking.meeting_name }</td>
					<td>${booking.roomname }</td>
					<td>${booking.startime }</td>
					<td>${booking.endtime }</td>
					<td>${booking.booktime }</td>
					<td><div class="clickbutton">
							<a
								href="${pageContext.request.contextPath }/myself/meetingshowbyid.do?id=${booking.meeting_id}">查看</a>
							&nbsp;/&nbsp;<a class="clicka" href="#">撤销</a>
						</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>