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
<title>Confirmation Page</title>
</head>
<body>
	<a
		style="position: absolute; left: 90%; top: 0%; display: inline-block;"
		href="/">loginHomePage</a>

	<h1>Dear ${student.name}</h1>

	<c:choose>
		<c:when test="${empty status}">
			<h2>Your synopsis details has been submitted successfully.</h2>
		</c:when>
		<c:when test="${status==1}">
			<h2>Your synopsis is under Pending</h2>
		</c:when>
		<c:when test="${status==2}">
			<h2>Your synopsis has been approved.</h2>
			<h2>Congratulations!</h2>
		</c:when>
		<c:when test="${status==3}">
			<h2>Your synopsis could not be approved..Please try Resubmit it.</h2>
			<c:url var="url" value="resubmit">
				<c:param name="studentId">${student.id}</c:param>
			</c:url>
			<button>
				<a href="${url }">Resubmit</a>
			</button>
		</c:when>
	</c:choose>
	<c:if test="${status==2 || status==3}">
		<h2>Feedback from <span style="color:blue;"> ${student.evaluator.name} :-</span> <span style="color:darkgreen;">"${student.feedback }"</span></h2>
	</c:if>
</body>
</html>