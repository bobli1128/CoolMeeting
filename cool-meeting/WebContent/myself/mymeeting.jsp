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
<style type="text/css">
body {
	background-color: lightcyan;
}

.table {
	border-collapse: collapse; /*让表格边线变成单根实线*/
	width: 740px;
	/*height: 300px;*/
	border: 1px solid red;
	margin-top: 20px;
	font-size: 14px;
}
.center_right{
 margin-top:15px;
}

.center_right caption {
	text-align: left;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-bottom: 15px;
}

.table tr {
	height: 20px;
}

.table td {
	border: 1px solid gray;
	text-align: center;
}

.table tr:nth-child(2n) { /*对偶数行的表格内容进行修改*/
	background-color: white;
}

.tr1 {
	background-color: skyblue;
	font-size:14px;
	
}

.clickbutton {
	border: 1px solid black;
	font-size: 14px;
	width: 58px;
	height: 16px;
	margin-left: 5px;
	padding: 4px 3px;
}

.clickbutton a:link {
	text-decoration: none;
	color: black;
}

.clickbutton a:visited {
	color: black;
}

.clickbutton a:hover {
	color: gray;
}

.clickbutton a:active {
	color: gray;
}
</style>
<body>
	<div class="center_right">
		<div class="title">
			个人中心&nbsp;&gt;&nbsp;我的会议
		</div>
			<table border="1" class="table">
				<caption><strong>我将参加的会议</strong></caption>
				<tr class="tr1" style="height:40px">
					<td><strong>会议名称</strong></td>
					<td><strong>会议室名称</strong></td>
					<td><strong>会议起始时间</strong></td>
					<td><strong>会议结束时间</strong></td>
					<td><strong>会议预定时间</strong></td>
					<td><strong>预定者</strong></td>
					<td>操作</td>
				</tr>
				<c:forEach items="${mymeetings }" var="mymeeting">
					<tr style="height:40px">
						<td>${mymeeting.meeting_name }</td>
						<td>${mymeeting.room_name }</td>
						<td><fmt:formatDate value="${mymeeting.starttime }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><fmt:formatDate value="${mymeeting.endtime }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><fmt:formatDate value="${mymeeting.booktime }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td>${mymeeting.role_name }</td>
						<td>
							<div class="clickbutton">
								<a href="detailshow.do?mid=${mymeeting.meeting_id}">查看详情</a>
							</div> <!-- <input type="button" value="查看详情"/>-->
						</td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>