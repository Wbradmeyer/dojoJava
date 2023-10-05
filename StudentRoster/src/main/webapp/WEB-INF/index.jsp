<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dorms</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<h1>Dorms</h1>
		<p><a href="/new">Add a new dorm</a></p>
		<p><a href="/new">Add a new student</a></p>
		<p><a href="/new">Add a new class</a></p>
		<p><a href="/classes">View all classes</a></p>
		<table class="table table-bordered">
			<tr>
				<th>Dorm</th>
				<th>Action</th>
			</tr>
			<c:forEach var="dorm" items="${dorms}">
				<tr>
					<td>${dorm.name}</td>
					<td><a href="#">See Students</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>