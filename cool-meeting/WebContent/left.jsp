<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左面</title>
</head>
<link rel="stylesheet" href="css/login.css"/>
<body>
<div class="center-left">
				<div>
					<div>个人中心</div>
					<ul>
						<li><a href="myself/meetshow1.do?id=${admin.role_id}" class="linkg" target="middle_right">最新通知</a></li>
						<li><a href="myself/mybookingshow.do" class="linkg" target="middle_right">我的预定</a></li>
						<li><a href="myself/showmymeeting.do?rid=${admin.role_id}" class="linkg" target="middle_right">我的会议</a></li>
					</ul>
				</div>
				<div>
					<div>人员管理</div>
					<ul>
						<li><a href="roleManage/deptshow.do?" class="linkg" target="middle_right">部门管理</a></li>
						<li><a href="roleManage/createrole_dep.do" class="linkg" target="middle_right">员工注册</a></li>
						<li><a href="roleManage/check.do" class="linkg" target="middle_right">注册审批</a></li>
						<li><a href="roleManage/search_worker.jsp" class="linkg" target="middle_right">搜索员工</a></li>
					</ul>
				</div>
				<div>
					<div>会议预订</div>
					<ul>
						<li><a href="roleManage/addmeeting.jsp" class="linkg" target="middle_right">添加会议室</a></li>
						<li><a href="meetingorder/roomshow.do" class="linkg" target="middle_right">查看会议室</a></li>
						<li><a href="meetingorder/adddepartmentandroom.do" class="linkg" target="middle_right">预订会议</a></li>
						<li><a href="meetingorder/search_meeting.jsp" class="linkg" target="middle_right">搜索会议</a></li>
					</ul>
				</div>
			</div>
</body>
</html>