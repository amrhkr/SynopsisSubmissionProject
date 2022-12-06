<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Project Details of ${project.student.name} </h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Tool Used</th>
			<th>See File</th>
			<th>Guide's Name</th>
			<th>Guide's Experience</th>
			<th>Guide's Qualification</th>
		</tr>
		
		
		<c:url var="url" value="checkStudentDetails">
		<c:param name="studentDetailsId" value="${project.id}"></c:param>
		</c:url>
			<tr>
				<td>${project.nameOfProject}</td>
				<td>${project.tools}</td>
				<td><a href="${url}">download</a></td>
				<td>${project.guideName}</td>
				<td>${project.guideExperience}</td>
				<td>${project.guideQualification}</td>
			</tr>
	</table>
</body>
</html>