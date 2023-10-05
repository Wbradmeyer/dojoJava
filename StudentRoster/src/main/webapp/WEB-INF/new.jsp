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
    <title>Create New</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div>
		<div class="container">
		<a href="/">Dashboard</a>
			<h2>New Dorm</h2>
			<form:form action="/dorms/new" method="post" modelAttribute="dorm">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control" style="width: 400px;"/>
				<input type="submit" value="Add" class="btn btn-success">
			</form:form>
		</div>
		<div class="container">
			<h2>New Student</h2>
			<form:form action="/students/new" method="post" modelAttribute="student">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control" style="width: 400px;"/>
				<input type="submit" value="Add" class="btn btn-success">
			</form:form>
		</div>
		<div class="container">
			<h2>New Class</h2>
			<form:form action="/classes/new" method="post" modelAttribute="classEx">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control" style="width: 400px;"/>
				<input type="submit" value="Add" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>