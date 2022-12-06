<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Add Evaluator</title>
</head>
<body>
<a style="position:absolute;left:90%;top:0%;display:inline-block;" href="/">loginHomePage</a>
	
	<h1>Add Evaluator Form</h1>
	<form:form action="postAddEvaluator" modelAttribute="evaluator" style="margin:5px;padding:7px;">
	<form:hidden path="id"/>
Name:<form:input path="name" />
		<br>
		<input style="margin:5px;padding:7px;" type="submit" />
	</form:form>
	<div>
		<a href="adminPage" id="goback">Go Back</a>
	</div>
</body>
</html>