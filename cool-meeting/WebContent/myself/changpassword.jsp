<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color:  lightcyan;
}
  .center-right{
	  margin-top:80px;
  }
</style>
<script type="text/javascript">
  function getback(){
	  window.location.href="changpassword.jsp";
  
</script>
</head>
<body>
<div class="center-right">
				<div>修改密码</div>
				<form style="margin-top: 45px;" action="${pageContext.request.contextPath }/myself/pwdup.do" method="post" target="_top">
					<fieldset style="width:500px;">
						<legend><strong>修改密码信息</strong></legend>
						<table>
							<tr>
								<td>原密码:</td>
								<td><input type="password"  name="oldpwd"></td>
							</tr>
							<tr>
								<td>新密码:</td>
								<td><input type="password"  name="newpwd"></td>
							</tr>
							<tr>
								<td>确认新密码:</td>
								<td><input type="password"  name="confirmnewpwd"></td>
							</tr>
							<tr>
							    <td><input type="hidden" name="rightuser" value="${admin.role_id }"></td>
							</tr>
					    </table>
					    <div>${message1 }</div>
					    <div>${message2 }</div>
					    <div style="margin-left:120px;margin-top:30px">
							<input type="submit" value="确认修改"/>
							<input type="button" value="返回" onclick="getback()"/>
						</div>
					</fieldset>
				</form>
			</div>
</body>
</html>