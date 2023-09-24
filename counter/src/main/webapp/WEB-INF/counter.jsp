<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Server Visit Counter</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Visit Counter</h1>
	<p>You have visited <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${count}"/> times.</p>
	<p><a href="http://localhost:8080/addtwo">Add Two</a></p>
	<a class="button" href="http://localhost:8080/clear">Reset Counter</a>
</body>
</html>