<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Demo JSP</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script type="text/javascript" src="/js/app.js"></script>
	</head>
<body>
	<h1>SEC East Teams</h1>
	<c:forEach var="oneTeam" items="${teamsFromController}">
		<p><c:out value="${oneTeam}"></c:out></p>
	</c:forEach>
	
	
</body>
</html>