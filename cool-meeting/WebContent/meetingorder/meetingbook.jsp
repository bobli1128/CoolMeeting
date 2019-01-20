<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.6.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<title>Insert title here</title>
</head>
<style>
.listtable {
	border-collapse: collapse;
	width: 500px;
	font-size:15px;
}
.listtable td {
	border: 1px solid gray;
	text-align:center;
}
.listtable tr {
	height: 30px;
}
.listheader{
	background-color:skyblue;
	text-align:center;
}
#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}

body {
	background-color: lightcyan;
}

.center-right {
	margin-top: 20px;
	margin-right: 300px;
	float: right;
	width: 600px;
	/*height: 200px;*/
	/* 	padding-buttom:20px; */
}

.center-right .tr {
	padding-left: 235px;
	padding-top: 10px;
}

.table {
	/* margin-left:20px; */
	witdh: 350px;
	height: 300px;
}
tr {
	width: 210px;
	height: 40px;
	vertical-align: bottom;
	text-align: left;
}

.bbb {
	padding-bottom: 65px;
}

.aaa {
	padding-top: 30px;
}

.ccc {
	padding-bottom: 200px;
}
</style>
<body>
	<div class="center-right">
		<div>会议预订&gt;预订会议</div>
		<form action="${pageContext.request.contextPath }/meeting/add.do"
			method="post" id="form1">
			<fieldset style="width: 700px;">
				<legend>
					<strong>会议信息</strong>
				</legend>
				<table>
					<tr>
						<td>会议名称:</td>
						<td><input type="text" value="" name="meeting_name"
							id="meeting_name" /></td>
						<td></td>
					</tr>
					<tr>
						<td>会议室名称:</td>
						<td><select name="room_id" value="" id="room_id">
								<c:forEach items="${room }" var="room">
									<option value="${room.roomid }">${room.roomname}</option>

								</c:forEach>
						</select></td>
						<td><span id="roomId"></span></td>
					</tr>
					<tr>
						<td>预计参加人数:</td>
						<td><input type="text" value="" name="meeting_number"
							id="meeting_number" /></td>
					</tr>
					<tr>
						<td>预计开始时间:</td>
						<td><input type="date" value="" name="starttimedate"
							id="start_date" /><input type="time" name="starttimetime"
							id="start_time" /></td>
					</tr>
					<tr>
						<td>预计结束时间:</td>
						<td><input type="date" name="endtimedate" id="end_date" /><input
							type="time" name="endtimetime" id="end_time" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<table class="listtable">
								<tr class="listheader">
									<td>会议室编号</td>
									<td>会议名称</td>
									<td>开始时间</td>
									<td>结束时间</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="bbb">会议说明:</td>
						<td class="aaa"><textarea cols="50" rows="5"
								name="meeting_notes" id="meeting_notes"></textarea></td>
					</tr>
					<tr>
						<td class="ccc">选择参会人员：</td>
						<td>
							<div id="divfrom">
								<select id="selDepartments" name="selDepartment">
									<option value="-1">选择部门</option>
									<c:forEach items="${department}" var="depa">
										<option value="${depa.dep_id}">${depa.dep_name}</option>
									</c:forEach>
								</select> <select id="selEmployees" multiple="multiple">
									<option style="display: none" class="shownode"></option>
								</select>
							</div>
							<div id="divoperator">
								<input type="button" class="clickbutton" value="&gt;"
									id="addButton" /> <input type="button" class="clickbutton"
									value="&lt;" id="deleteButton" />
							</div>
							<div id="divto">
								<select id="selSelectedEmployees" name="selSelectedEmployees"
									multiple="multiple">
								</select>
							</div>
						</td>
					</tr>

				</table>
				<div class="tr">
					<input type="submit" value="预定会议" id="btn" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" />
					<!-- <input type="hidden" id="RoomStates" value=""> -->
				</div>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		$("input[name='meeting_number']")
				.change(
						function() {
							var MeetingNumber = $(
									"input[name='meeting_number']").val();
							var RoomId = $("select[name='room_id']").val();
							//console.log(RoomId+""+MeetingNumber);
							$
									.ajax({
										type : "post",
										url : "${pageContext.request.contextPath}/meeting/searchroombyroomid.do",
										data : {
											"roomID" : RoomId,
										/* "Meeting_Number": MeetingNumber */
										},
										success : function(data) {
											var objs = JSON.parse(data);
											/* console.log(objs.room_capacity); */
											if (objs.capacity < MeetingNumber) {
												alert("超出会议室容纳人数上限");
												return false;
											}
										}
									})
						})

		$("select[name='room_id']")
				.change(
						function() {
							var RoomId = $("select[name='room_id']").val();
							$
									.ajax({
										type : "post",
										url : "${pageContext.request.contextPath}/meeting/searchroombyroomid.do",
										data : {
											"roomID" : RoomId,
										},
										success : function(data) {
											var objs = JSON.parse(data);
											if (objs.roomstate == "0") {
												alert("该会议室停用");
												return false;
											}
										}
									})
						})
		$("select[name='selDepartment']")
				.change(
						function() {
							var locationdepa = $(this).val();
							$
									.ajax({
										type : "post",
										url : "${pageContext.request.contextPath}/meeting/searchrolebydepartment.do",
										data : "locationdepa=" + locationdepa,
										success : function(data) {
											var deparole = JSON.parse(data);
											$(".shownode").nextAll().remove();
											$(deparole)
													.each(
															function() {
																var str = "<option value='"+this.role_id+"'>"
																		+ this.role_name
																		+ "</option>";
																$(".shownode")
																		.after(
																				str);
															})
										}
									})
						})
		$("input[name='endtimetime']")
				.blur(
						function() {
							var RoomID = $("select[name='room_id']").val();
							var Start_d = $("input[name='starttimedate']")
									.val();
							var Start_t = $("input[name='starttimetime']")
									.val();
							var End_d = $("input[name='endtimedate']").val();
							var End_t = $("input[name='endtimetime']").val();
							if (Start_d == End_d && Start_t > End_t) {
								alert("会议预计结束时间早于会议预计开始时间");
								return false;
							} else {
								/* alert("会议预计结束时间晚于会议预计开始时间");
								console.log(RoomID+","+Start_d+","+Start_t+","+End_d+","+End_t) */
								$
										.ajax({
											type : "post",
											url : "${pageContext.request.contextPath}/meeting/searchroombyidandtime.do",
											data : {
												"RoomID" : RoomID,
												"Start_d" : Start_d,
												/* "Start_t":Start_t, */
												"End_d" : End_d,
											/* "End_t":End_t */
											},

											success : function(data) {
												var compare = "0";
												var Start = Start_d + " "
														+ Start_t;
												var End = End_d + " " + End_t;
												$(".listtable")
														.css(name, value)
												$(".listheader").nextAll()
														.remove();
												var objs = JSON.parse(data);
												$(objs)
														.each(
																function() {
																	var trcontent = "<tr><td>"
																			+ this.room_id
																			+ "</td><td>"
																			+ this.meeting_name
																			+ "</td><td>"
																			+ this.startime
																			+ "</td><td>"
																			+ this.endtime
																			+ "</td></tr>";
																	$(
																			".listheader")
																			.after(
																					trcontent);
																	if (this.startime > End || this.endtime < Start) {} 
																	else {
																		console.log(this.startime);
																		console.log(this.endtime);
																		compare = "1";
																	} 
																	
																	
																})
												if (compare == "1") {
													alert("与其他会议时间冲突");
													return false;
												}
											}
										})
							}

						})
	</script>
	<script>
		window.onload = function() {
			var Meeting_Name = document.getElementById("meeting_name");
			var Room_Id = document.getElementById("room_id");
			var Meeting_Number = document.getElementById("meeting_number");
			var Start_Date = document.getElementById("start_date");
			var Start_Time = document.getElementById("start_time");
			var End_Date = document.getElementById("end_date");
			var End_Time = document.getElementById("end_time");
			var Meeting_Notes = document.getElementById("meeting_notes");
			var oBTN = document.getElementById("btn");
			var Form = document.getElementById("form1");
			var selDepartments = document.getElementById("selDepartments");
			var selEmployees = document.getElementById("selEmployees");
			var selSelectedEmployees = document
					.getElementById("selSelectedEmployees");
			var AddButton = document.getElementById("addButton");
			var DeleteButton = document.getElementById("deleteButton");

			function addEmployee(optEmployee) {

				var options = selSelectedEmployees.options;
				/* alert(options.length); */
				/* 	var i=0; */
				var insertIndex = -1;
				for (var i = 0; i < options.length; i++) {
					/* console.log(optEmployee.value+"----"+options[i].value) */
					if (optEmployee.value == options[i].value) {
						return;
					} else if (optEmployee.value < options[i].value) {
						insertIndex = 0;
						break;
					}
				}
				var opt = document.createElement("option");
				opt.value = optEmployee.value;
				opt.text = optEmployee.text;

				if (insertIndex == -1) {
					selSelectedEmployees.appendChild(opt);
				} else {
					selSelectedEmployees
							.insertBefore(opt, options[insertIndex]);
				}
			}
			oBTN.onclick = function() {
				var isSuccess = 1;
				if (Meeting_Name.value == "") {
					alert("未填写会议名称");
					isSuccess = 0;
				} else if (Room_Id.value == "") {
					alert("未填写会议室编号");
					isSuccess = 0;
				} else if (Meeting_Number.value == "") {
					alert("未填写参会人数");
					isSuccess = 0;
				} else if (Start_Date.value == "") {
					alert("未填写会议预计开始日期");
					isSuccess = 0;
				} else if (Start_Time.value == "") {
					alert("未填写会议名称预计开始时间");
					isSuccess = 0;
				} else if (End_Date.value == "") {
					alert("未填写会议预计结束日期");
					isSuccess = 0;
				} else if (End_Time.value == "") {
					alert("未填写会议预计结束时间");
					isSuccess = 0;
				} else if (Meeting_Notes == "") {
					alert("未填写会议备注");
					isSuccess = 0;
				}

				if (isSuccess == 1) {
					return true;
				} else {
					return false;
				}

			}
			Start_Date.onchange = function() {
				var myDate = new Date();
				/* var MYDATE = toDouble(myDate.getFullYear())+toDouble(myDate.getMonth())+toDouble(myDate.getDate()); */
				/* alert(MYDATE); */
				var myDate_year = myDate.getFullYear().toString();
				var myDate_month = myDate.getMonth().toString();
				var myDate_day = myDate.getDate().toString();
				var time = new Date(Start_Date.value);
				/* var TIME=time.getFullYear().toString()+"-"+time.getMonth().toString()+"-"+time.getDate().toString(); */
				var time_year = time.getFullYear().toString();
				var time_month = time.getMonth().toString();
				var time_day = time.getDate().toString();
				if (myDate_year > time_year) {
					alert("会议预计开始时间早于今天");
					return false;
				} else if (myDate_year == time_year
						&& myDate_month > time_month) {
					alert("会议预计开始时间早于今天");
					return false;
				} else if (myDate_year == time_year
						&& myDate_month == time_month && myDate_day > time_day) {
					alert("会议预计开始时间早于今天");
					return false;
				}

			}
			End_Date.onchange = function() {
				if (Start_Date.value > End_Date.value) {
					alert("会议预计结束时间早于会议预计开始时间");
					return false;
				}
			}

			AddButton.onclick = function() {

				for (var i = 0; i < selEmployees.options.length; i++) {
					if (selEmployees.options[i].selected) {
						addEmployee(selEmployees.options[i]);
						/* console.log(selEmployees.options[i].value); */
						selEmployees.options[i].selected = false;
					}
				}

			}

			DeleteButton.onclick = function() {

				var elementsToRemoved = new Array();
				var options = selSelectedEmployees.options;
				for (var i = 0; i < options.length; i++) {
					if (options[i].selected) {
						elementsToRemoved.push(options[i]);
					}
				}
				for (i = 0; i < elementsToRemoved.length; i++) {
					selSelectedEmployees.removeChild(elementsToRemoved[i]);
				}
			}

		}
	</script>
</body>
</html>