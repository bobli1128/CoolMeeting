<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Role/add.do"
		method="post">
		<table>
			<tr>
				<td>用户姓名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>用户年龄：</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>用户性别：</td>
				<td><input type="text" name="sex"></td>
			</tr>
			<tr>
				<td>用户部门编号：</td>
				<td><input type="text" name="dep"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>