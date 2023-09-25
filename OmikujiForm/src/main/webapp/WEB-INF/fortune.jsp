<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Fortune</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>Here's Your Omikuji!</h1>
		<div class="box">
		<p>In <c:out value="${quantity}"/> years, you will live in <c:out value="${city}"/> 
		with <c:out value="${person}"/> as your roommate, <c:out value="${hobby}"/> for a living. 
		The next time you see a(n) <c:out value="${thing}"/>, you will have good luck.
		Also, <c:out value="${nice}"/></p>
		<a href="/omikuji">Go Back</a>
		</div>
	</div>
</body>
</html>