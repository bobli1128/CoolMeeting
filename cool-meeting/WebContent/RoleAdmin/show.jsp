<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 第三方开源标签库JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>用户信息 表</caption>
		<thead>
			<tr>
				<th>标识</th><th>姓名</th><th>年龄</th><th>性别</th><th>部门</th><th>电话</th><th>用户名</th><th>密码</th><th>操作</th>
			</tr>
		</thead>
		<tbody>
			<!-- 循环遍历集合，集合数据是请求对象中的属性内容，通过EL表达式获取，EL表达式写法${属性名} -->
			<c:forEach items="${list }" var="u">
				<tr>
					<td>${u.role_id }</td>
					<td>${u.role_name }</td>
					<td>${u.role_age }</td>
					<td>${u.role_sex }</td>
					<td>${u.role_dep }</td>
					<td>${u.role_tele }</td>
					<td>${u.role_account }</td>
					<td>${u.role_password }</td>
 					<td><a href="${pageContext.request.contextPath }/Role/delete.do?id=${u.role_id}"
					onclick="return confirm('是否删除该用户？')">删除</a>
					<a href="${pageContext.request.contextPath }/Role/update.do?id=${u.role_id}">更新</a>
					</td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 判断属性中的集合是否为空 -->
	<c:if test="${empty list }">
		用户信息表中无任何记录！
	</c:if>
</body>
</html>