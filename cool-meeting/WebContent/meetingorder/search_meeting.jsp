<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索会议</title>
<style type="text/css">
body {
	background-color:  lightcyan;
}
.center_right_top{
	width:750px;
}
.table {
	border-collapse: collapse; /*让表格边线变成单根实线*/
	width: 800px;
	border: 1px solid red;
	margin-top: 10px;
}
.center_right caption {
	text-align: left;
	font-size: 18px;
	font-family: "微软雅黑";
}

.table tr{
	border: 1px solid gray;
	text-align: center;
	font-size:15px;
}

.table tr:nth-child(2n) { /*对偶数行的表格内容进行修改*/
	background-color: white;
}
.table tr:nth-child(2n+3) { /*对偶数行的表格内容进行修改*/
background-color: lightblue;
}

.tr1 {
	height: 45px;
	background-color: skyblue;
}
.clickbutton {
	border: 1px solid black;
	padding: 0 5px;
	text-align: center;
	background-color:gainsboro;
}
.clickbutton a{
	text-decoration:none;
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
	background-color:gray;
}
.title {
	width: 200px;
}

.searchworker_div3 {
	text-align: center;
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
	margin-left:60px;
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
</style>
</head>
<body>
	<div class="center_right">
		<div class="title">
			会议预定&nbsp;&gt;&nbsp;搜索会议
		</div>
		<div class="center_right_top">
			<form
				action="${pageContext.request.contextPath }/meetingorder/searchmeeting.do"
				method="post">
				<fieldset id="">
					<legend>搜索会议</legend>
					<table>
						<tr>
							<td>会议名称：<input type="text" style="width: 120px;"
								name="meetingname"></td>
							<td>会议室名称：<input type="text" style="width: 120px;"
								name="roomname"></td>
							<td>预定者姓名：<input type="text" style="width: 120px;"
								name="rolename"></td>
						</tr>
					</table>
					<div>
						预定日期：从<input type="date" name="bookstime">到<input
							type="date" name="bookbtime">
					</div>
					<div>
						会议日期：从<input type="date" name="starttime">到<input
							type="date" name="endtime">
					</div>
					<div style="margin-left: 200px;">
						<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="重置">
					</div>
				</fieldset>
			</form>
		</div>
		<table border="1" class="table">
			<div class="searchworker_div3">
				<strong>查询结果</strong>
			</div>
			<div class="searchworker_div4">
				共<strong>${all }</strong>条结果，分成<strong>${pages }</strong>页显示，当前第<strong>${current }</strong>页
			</div>
			<div class="searchworker_div5">
				<a class="page"
					href="${pageContext.request.contextPath }/meetingorder/searchmeeting.do?pages=1">首页</a>
				<c:if test="${current gt 1 }">
					<a class="page"
						href="${pageContext.request.contextPath }/meetingorder/searchmeeting.do?pages=${current-1 }">上页</a>
				</c:if>
				<c:if test="${current lt pages }">
					<a class="page"
						href="${pageContext.request.contextPath }/meetingorder/searchmeeting.do?pages=${current+1 }">下页</a>
				</c:if>
				<a class="page"
					href="${pageContext.request.contextPath }/meetingorder/searchmeeting.do?pages=${pages }">尾页</a>
				<div class="searchworker_d">
				<form
					action="${pageContext.request.contextPath }/meetingorder/searchmeeting.do" 
					method="post">
					跳到第 <input type="text" style="width: 10px;" name="pages" /> 页 <input type="submit" value="跳转" />
				</form>
				</div>
			</div>
			<tr class="tr1">
				<td>会议名称</td>
				<td>会议室名称</td>
				<td>会议起始时间</td>
				<td>会议结束时间</td>
				<td>会议预定时间</td>
				<td>预定者</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${meetings }" var="meeting">
				<tr style="height: 40px;">
					<td>${meeting.meeting_name }</td>
					<td>${meeting.roomname }</td>
					<td>${meeting.startime }</td>
					<td>${meeting.endtime }</td>
					<td>${meeting.booktime }</td>
					<td>${meeting.rolename }</td>
					<td><div class="clickbutton">
							<a href="${pageContext.request.contextPath }/meetingorder/searchmeetingshowbyid.do?id=${meeting.meeting_id}">查看详情</a>
						</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>