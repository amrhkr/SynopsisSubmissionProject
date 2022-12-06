<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<script async defer src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script async defer
	src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body >
	<h1 >Welcome to AdminPage</h1>
	<a
		style="position: absolute; left: 90%; top: 0%; display: inline-block;"
		href="/">loginHomePage</a>
	<div class="d-grid gap-2">
	<button type="button" class="btn btn-primary" id="getStudent">Students List</button>
	<button type="button" class="btn btn-primary" id="getEvaluator">Evaluator List</button>
	</div>
	<div>
	<a class="add" href="addStudent">Add Student</a>
	<a class="add" href="addEvaluator">Add Evaluator</a>
	</div>
	<div id="content"></div>
	
</body>
</html>