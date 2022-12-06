<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<a style="position:absolute;left:90%;top:0%;display:inline-block;" href="/">loginHomePage</a>

	<h1>Add Student Form</h1>
	<form:form modelAttribute="student" action="postAddStudent" >
Name:<form:input path="name" />
<form:hidden path="id"/>
		<form:select path="evaluatorId">
			<br>
			
			<c:forEach var="theEvaluator" items="${evaluators}">
				<c:choose>
					<c:when test="${(student.evaluator).equals(theEvaluator)}">
                       <form:option  value="${theEvaluator.id}" selected="true">${theEvaluator.name}</form:option>
						<br />
					</c:when>
					<c:otherwise>
					<form:option value="${theEvaluator.id}">${theEvaluator.name}</form:option>
						<br />
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select>
		<br>
		<input style="margin:5px;padding:7px;" type="submit" value="Submit">
	</form:form>
	<div>
		<a href="adminPage" id="goback">Go Back</a>
	</div>
</body>
</html>
