<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加会议室</title>
<style>
.addmeeting_center_buttom {
	padding-left: 150px;
	padding-bottom: 10px;
}
.addmeet_center_middle {
	padding-top: 10px;
	padding-bottom: 10px;
	height:300px;
}
.room {
	padding-bottom: 15px;
}
body {
	background-color:  lightcyan;
}
.bbb{
	width:500px;
	height:1000px;
	margin-left:100px;
}
</style>
</head>
<body>
	<div class="center-right">
		<div class="room">会议预定&gt;添加会议室</div>
		<div class="bbb">
			<form
				action="${pageContext.request.contextPath }/roleManage/roomadd.do"
				method="post">
				<fieldset>
					<legend>
						<strong>会议室信息</strong>
					</legend>
					<table class="addmeet_center_middle">
						<tr>
							<td>门牌号：</td>
							<td><input type="text" name="door" placeholder="例如：201" /></td>
						</tr>
						<tr>
							<td>会议室名称：</td>
							<td><input type="text" name="name" placeholder="例如：第一会议室" /></td>
						</tr>
						<tr>
							<td>最多容纳人数：</td>
							<td><input type="text" name="hold" placeholder="填写一个正整数" /></td>
						</tr>
						<tr>
							<td>当前状态：</td>
							<td><input type="radio" name="status" value="0" />启用 <input
								type="radio" name="status" value="1" />停用 <input type="radio"
								name="status" value="2" />删除</td>
						</tr>
						<tr>
							<td>备注：</td>
							<td><textarea rows="5" cols="40" maxlength="200"
									placeholder="200字以内的文字描述" name="note"></textarea></td>
						</tr>
					</table>
					<div class="addmeeting_center_buttom">
						<input type="submit" value="添加" /> &nbsp;&nbsp;&nbsp; <input
							type="reset" value="重置" />
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>