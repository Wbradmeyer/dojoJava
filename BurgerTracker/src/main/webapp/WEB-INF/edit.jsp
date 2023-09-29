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
    <title>Update Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="form">
			<div id="header">
				<h2>Update a Burger:</h2>
				<a href="/" class="btn btn-warning">Go Back</a>
			</div>
			<form:form action="/burgers/edit" method="post" modelAttribute="burger">
				<input type="hidden" name="_method" value="put">
				<input type="hidden" name="id" value="${burger.id}">
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