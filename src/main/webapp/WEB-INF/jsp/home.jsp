<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
				<div class="container alert alert-success">${message}</div>
				<div class = "container"><a href="${pageContext.request.contextPath}/secured/users">Users</a>
				<a href="${pageContext.request.contextPath}/registration">Registration</a>
				<a href="${pageContext.request.contextPath}/login">Login</a>
				<a href="${pageContext.request.contextPath}/logout">Logout</a>
				</div>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>