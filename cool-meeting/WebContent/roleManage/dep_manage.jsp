<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/cool-meeting/js/jquery-1.6.js"></script>
<script type="text/javascript">
	var deptid = "";
	var deptname = "";
	var flag = false;//默认情况下表格单元格中是文本显示
	$(function() {
		 $(".clickbuttonEdit").click(function(){
				if(!flag){
					deptname=$(this).parent().prev().text();
					deptid=$(this).parent().prev().prev().text();
					var td=$(this).parent().prev();
					td.empty();
					var formstr="<form id='form1' action='${pageContext.request.contextPath }/roleManage/deptupd.do' "+
		        			"method='post'><fieldset><input type='text' name='departmentname' maxlength='20' value='"+deptname+"'/>"+
					"<input type='hidden' name='departmentid' maxlength='20' value='"+deptid+"'/></fieldset></form>";
					td.append(formstr);
					$(this).after("<a class='clickbuttonEdit' id='cancle' href='#'>取消</a>");
					flag=true;
					$("#cancle").click(function(){
						$(this).parent().prev().empty();
						$(this).parent().prev().text(deptname);
						$(this).remove();
						flag=false;
					});
				}else{
					$("#form1").submit();
				}
		}); 
	});
</script>
</head>
<style>
body {
	background-color: lightcyan;
}

.center-right {
	width: 700px;
	height: 400px;
	margin-top: 15px;
}
.table {
	margin-left: 100px;
}

.center-right-top {
	width: 700px;
	height: 70px;
	margin-top: 20px;
}

.center-right-buttom {
	width: 700px;
	height: 300px;
}

.center-right-buttom caption {
	text-align: left;
}

.table {
	margin-left: 1px;
	width: 700px;
	border-collapse: collapse;
}
.table tr{
	height:30px;
}
.table a{
	border: 1px solid black;
	padding: 0 8px;
	text-decoration: none;
	background-color:gainsboro;
}
.table a:link{
	color:black;
}
.table a:visited{
	color:black;
}
.table a:hover{
	color:black;
}
.table a:active{
	color:black;
	background-color: gray;
}
.table tr:nth-child(2n-1) {
	background-color: white;
}

.table td {
	text-align: center;
}

.table .tr1 {
	font-weight: 900;
}
</style>
<body>
	<div class="center-right">
		<div >
			<font size="3">人员管理&nbsp;&gt;&nbsp;部门管理</font>
		</div>
		<div class="center-right-top">
			<form action="${pageContext.request.contextPath }/roleManage/deptadd.do"
				method="post">
				<fieldset style="border-width: 1px; border-color: black;">
					<legend>
						<font size="4"><strong>添加部门</strong></font>
					</legend>
					<font size="2">部门名称</font>： <input type="text" name="deptname" />
					<input type="submit" value="添加" />
				</fieldset>
			</form>
		</div>
		<div class="center-right-buttom">
			<table class="table" border="1">
				<caption>
					<strong>所有部门：</strong>
				</caption>
				<tr class="tr1" style="background-color: skyblue;">
					<td>部门编号</td>
					<td>部门名称</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${depts }" var="dept">
					<tr>
						<td>${dept.dep_id }</td>
						<td>${dept.dep_name}</td>
						<td><a class="clickbuttonEdit" href='#'>编辑</a>
					
						<a class="clickbutton" href="${pageContext.request.contextPath }/roleManage/deptdel.do?id=${dept.dep_id}"
							onclick="return confirm('是否删除该部门？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>