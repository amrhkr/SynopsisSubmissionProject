<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Evaluators List</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Update</th>
			<th>Associated With</th>
		</tr>
		<c:forEach var="item" items="${evaluators}">
		<c:url var="update" value="updateEvaluator">
		<c:param name="evaluatorId" value="${item.id}"></c:param>
		</c:url>
			
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td><a href="${update}">Update</a></td>
					<td>
					<c:forEach var="student" items="${item.students}">
					${student.name},
					</c:forEach>
					</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>