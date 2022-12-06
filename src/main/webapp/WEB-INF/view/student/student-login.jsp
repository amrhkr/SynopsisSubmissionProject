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
<title>Student Login Page</title>
</head>
<body>
<h1>Welcome to Student Login Page</h1>
<a style="position:absolute;left:90%;top:0%;display:inline-block;" href="/">loginHomePage</a>

<c:if test="${data==false}">
<p style="color:red;border:solid 2px red">Invalid Credentials</p>
</c:if>
<form action="check" method="post">
Enter the Roll no.<input name="rollNo"> <br>
<input type="submit" value="submit" />
</form>
</body>
</html>