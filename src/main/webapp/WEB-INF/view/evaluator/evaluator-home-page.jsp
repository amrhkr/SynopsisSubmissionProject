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
<title>Evaluator Home</title>
</head>
<body>
<a style="position:absolute;left:90%;top:0%;display:inline-block;" href="/">loginHomePage</a>

<h1>Evaluator Login Page</h1>

<c:if test="${data ==false}">
<h1 style="color:red">Invalid Login Credentials</h1>
</c:if>

<form:form action="checkLogin" modelAttribute="evaluator">
Enter the ID you are registered in University<br>
<form:input style="border:solid 1px red;" path="id"/><br>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>