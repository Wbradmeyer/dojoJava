<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">Burger Name</th>
					<th scope="col">Restaurant Name</th>
					<th scope="col">Rating (out of 5)</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
						<td><c:out value="${burger.burgerName}"/></td>
						<td><c:out value="${burger.restaurantName}"/></td>
						<td><c:out value="${burger.rating}"/></td>
						<td><a href="/burgers/${burger.id}/edit" class="btn btn-warning">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="form">
			<h2>Add a Burger:</h2>
			<form:form action="/new" method="post" modelAttribute="burger">
				<p>
					<form:label path="burgerName">Burger Name:</form:label>
					<form:errors path="burgerName"/>
					<form:input path="burgerName" class="form-control"/>
				</p>
				<p>
					<form:label path="restaurantName">Restaurant Name:</form:label>
					<form:errors path="restaurantName"/>
					<form:input path="restaurantName" class="form-control"/>
				</p>
				<p>
					<form:label path="rating">Rating:</form:label>
					<form:errors path="rating"/>
					<form:input type="number" path="rating" class="form-control" style="width: 50px;"/>
				</p>
				<p>
					<form:label path="notes">Notes:</form:label>
					<form:errors path="notes"/>
					<form:textarea path="notes" class="form-control"/>
				</p>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>