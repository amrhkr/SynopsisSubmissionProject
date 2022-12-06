<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Student List</title>
</head>
<body>
	<h1>Welcome ${evaluator.name}</h1>
	Following Students are associated:
	<hr>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<th>RollNo.</th>
			<th>Name</th>
			<th>Synopsis Submission Status</th>
			<th>Current Status</th>
			<th>Review</th>
			<th>Action</th>
			<th>Feedback</th>
		</tr>

		<c:if test="${empty evaluator.students}">
			<tr>
				<td>NA</td>
				<td>NA</td>
				<td>NA</td>
				<td>NA</td>
				<td>NA</td>
				<td>NA</td>
				<td>NA</td>
			</tr>
		</c:if>
		<c:forEach var="student" items="${evaluator.students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.submitted}</td>
				<c:choose>
					<c:when test="${student.submitted==false }">
						<td>No submissions made</td>
					</c:when>
					<c:when test="${student.pending==true }">
						<td>Pending</td>
					</c:when>
					<c:when test="${student.approval==true }">
						<td>Approved</td>
					</c:when>
					<c:otherwise>
						<td>2nd Submission not made</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${student.submitted==true}">
					<!-- feature adding -->
						<td><button type="button" class="getProjectDetails">Project Details</button></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${student.submitted==true}">
						<td class="action"><button>Approve</button> | <button>Disapprove</button></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<td><c:if test="${student.submitted==true}">
						<%-- <input type="text" id="feedback" value="${student.feedback}"> --%>
						<textarea rows="2" cols="20" id="feedback" >${student.feedback}</textarea>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="home" id="goback">Go Back</a>
	</div>
	<!-- window to show Project details -->
	<div id="content1"></div>
	
	<script async defer src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script async defer
	src="${pageContext.request.contextPath}/js/script.js"></script>
	<!-- 
	<script src="https://code.jquery.com/jquery-3.6.1.js"
		integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
		crossorigin="anonymous"></script> -->
	<script type="text/javascript">
		var action = document.getElementsByClassName("action");
		// approve.addEventListener("click",approve_func);
		// disapprove.addEventListener("click",disapprove_func);
		for (var i = 0; i < action.length; i++) {
			var approve = action[i].children[0];
			var disapprove = action[i].children[1];
			approve.addEventListener("click", approve_func);
			disapprove.addEventListener("click", disapprove_func);

			function approve_func(event) {
				//console.log(event.path[2].cells[2]);
				console.log(event.path[2].cells[6].value);
				console.log(event);
				event.path[2].cells[3].innerText = "Approved";
				var studentId = (event.path[2].cells[0].innerText);
				var feedback = (event.path[2].cells[6].children[0].value);
				$.ajax({
					url : "/student/approvedOrNot?&data=true&studentId="
							+ studentId + "&feedback=" + feedback,
					type : "GET",
					//data: JSON.stringify({ studentId: studentId}),
					contentType : "application/json",
					success : function(result) {
						// when call is sucessfull
						console.log("success");
					},
					error : function(err) {
						// check the err for error details
						console.log("error in ajax");
					}
				}); // ajax call closing
			}
			function disapprove_func() {
				console.log(event.path[2].cells[2]);
				event.path[2].cells[3].innerText = "Disapproved";
				var studentId = (event.path[2].cells[0].innerText);
				var feedback = (event.path[2].cells[6].children[0].value);
				$.ajax({
					url : "/student/approvedOrNot?data=false&studentId="
							+ studentId + "&feedback=" + feedback,
					type : "GET",
					//data: JSON.stringify({ studentId: studentId}),
					contentType : "application/json",
					success : function(result) {
						//when call is sucessfull
						console.log("success");
					},
					error : function(err) {
						//check the err for error details
						console.log("error in ajax");
					}
				}); // ajax call closing

			}
		}
	</script>
</body>
</html>