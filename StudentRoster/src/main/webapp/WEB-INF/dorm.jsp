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
		<h1>${dorm.name}</h1>
		<p><a href="/">Dashboard</a></p>
		<div>
			<form action="/dorms/add-student" method="post">
				<input type="hidden" name="dormId" value="${dorm.id}">
				<label id="studentId">Students:</label>
					<select name="studentId" class="form-control" style="width: 400px;">
						<c:forEach var="student" items="${allStudents}">
							<option value="${student.id}">${student.name}</option>
						</c:forEach>
					</select>
				<input type="submit" value="Add">
			</form>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
			<c:forEach var="assigned" items="${assignedStudents}">
				<tr>
					<td>${assigned.name}</td>
					<td><a href="#">See Students</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>