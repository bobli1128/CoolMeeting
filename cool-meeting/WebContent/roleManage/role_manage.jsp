<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工注册</title>
<style>
body {
	background-color:  lightcyan;
}
.center-right {
	margin-top: 15px;
	margin-left: 5px;
	/*height: 200px;*/
}
.linkg {
	text-decoration: none;
}
.aaa {
	width: 500px;
	margin-left:100px;
}

.bbb {
	margin-left: 100px;
	height:400px;
	font-size:15px;
}
</style>
</head>
<body>
	<div class="center-right">
		<div>
			<font size="3">人员管理&nbsp;&gt;&nbsp;</font><font size="3">员工注册</font>
		</div>
		<div style="margin-top:15px">
			<form class="aaa"
				action="${pageContext.request.contextPath}/create.do" method="post">
				<fieldset style="border-width: 1px; border-color: black;"
					class="spec">
					<legend>
						<font size="4"><strong>员工信息</strong></font>
					</legend>
					<table class="bbb">
						<tr>
							<td><font size="3">姓名：</font></td>
							<td><input type="text" name="create_role_name" id="name" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">账户名：</font></td>
							<td><input type="text" name="create_role_username"
								id="username" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">密码：</font></td>
							<td><input type="password" name="create_role_password"
								id="password" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">确认密码：</font></td>
							<td><input type="password" id="confirm" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">联系电话：</font></td>
							<td><input type="text" name="create_role_tele" id="tele" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">电子邮件：</font></td>
							<td><input type="text" name="create_role_mail" id="mail" /><br /></td>
						</tr>
						<tr>
							<td><font size="3">所在部门：</font></td>
							<td>
								<select name="create_role_dep">
									<c:forEach items="${dep }" var="deps">
										<option value=${deps.dep_name }>${deps.dep_name }</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="注册" id="zhuce"/>&nbsp;&nbsp; <input
								type="reset" value="重置" /></td>
						</tr>
						<script>
							var text1 = document.getElementById("name");
							var text2 = document.getElementById("username");
							var text3 = document.getElementById("password");
							var text4 = document.getElementById("confirm");
							var text5 = document.getElementById("tele");
							var text6 = document.getElementById("mail");
							var text7 = document.getElementById("zhuce");
							text5.onclick = showa;
							text6.onclick = showb;
							text7.onclick = showc;
							function showa() {
								if (text3.value != text4.value) {
									alert("密码不一致，请重新输入！");
								}
							}
							function showb() {
								var mobile = /^(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/;
								if (!mobile.test(text5.value)) {
									alert("手机号码输入有错误，请重新输入！");
								}
							}
							function showc() {
								if (text1.value == "" || text2.value == ""
										|| text3.value == ""
										|| text4.value == ""
										|| text5.value == ""
										|| text6.value == "") {
									alert("请将信息填写完整！");
								}
							}
						</script>
						</fieldset>

					</table>
			</form>
		</div>
		</div>
		<div>${message }</div>
</body>
</html>