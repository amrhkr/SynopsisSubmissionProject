<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Students List</h1>
	<table>
		<tr>
			<th>RollNo</th>
			<th>Name</th>
			<th>Updates</th>
			<th>Associated With</th>
		</tr>
		<c:forEach var="item" items="${students}">
		<c:url var="update" value="updateStudent">
		<c:param name="studentId" value="${item.id}"></c:param>
		</c:url>
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><a href="${update}">Update</a></td>
				<td>${item.evaluator.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>