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
    <title>Create Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="top-box">
			<h1>New Product</h1>
			<p><a href="/">Home</a></p>
		</div>
		<div class="bottom-box">
			<form:form action="/products/new" method="post" modelAttribute="product">
				<p>
					<form:label path="name">Name:</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" class="form-control" style="width: 500px;"/>
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:input path="description" class="form-control" style="width: 500px;"/>
				</p>
				<p>
					<form:label path="price">Price:</form:label>
					<form:errors path="price" class="text-danger"/>
					<form:input type="number" step="0.01" path="price" class="form-control" style="width: 500px;"/>
				</p>
				<input type="submit" value="Submit" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>