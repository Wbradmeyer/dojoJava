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
    <title>Edit Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="form">
			<div id="header">
				<h2>Edit Expense</h2>
				<a href="/expenses" class="btn btn-warning">Go Back</a>
			</div>
			<form:form action="/expenses/edit" method="post" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<input type="hidden" name="id" value="${expense.id}">
				<p>
					<form:label path="name">Expense Name:</form:label>
					<form:errors path="name"/>
					<form:input path="name" class="form-control"/>
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor"/>
					<form:input path="vendor" class="form-control"/>
				</p>
				<p>
					<form:label path="amount">Amount: $</form:label>
					<form:errors path="amount"/>
					<form:input type="number" step="0.01" path="amount" class="form-control" style="width: 100px;"/>
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:errors path="description"/>
					<form:textarea path="description" class="form-control"/>
				</p>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>