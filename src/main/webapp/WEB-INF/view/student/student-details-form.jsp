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
<title>Student Form</title>
</head>
<body>
	<a
		style="position: absolute; left: 90%; top: 0%; display: inline-block;"
		href="/">loginHomePage</a>

	<h1>Welcome ${student.name}</h1>
	<h2>Your Roll No. ${student.id}</h2>
	<c:url var="id" value="addStudentDetails">
		<c:param name="studentId">${student.id}</c:param>
	</c:url>
	<form:form modelAttribute="studentDetails" action="${id}" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name of Project <form:input path="nameOfProject" /></td>
			</tr>
			<tr>
				<td>Tools Used <form:input path="tools" /></td>
			</tr>
			<tr>
				<td>Guide Name:<form:input path="guideName" /></td>
			</tr>
			<tr>
				<td>GuideExperience: <form:input path="guideExperience" /></td>
			</tr>
			<tr>
				<td>GuideQualifications: <form:input path="guideQualification" /></td>
			</tr>
			<tr>
				<td>Upload File:<input name="file1" type="file" accept="application/pdf" /></td>
			</tr>
		</table>
		<br>
		<input class="sub" type="submit" value="Submit" />
	</form:form>
	<div>
		<a href="home" id="goback">Go Back</a>
	</div>

</body>
</html>