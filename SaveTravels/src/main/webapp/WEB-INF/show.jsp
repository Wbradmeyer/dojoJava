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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div id="header">
			<h2>Expense Details</h2>
			<a href="/expenses" class="btn btn-warning">Go Back</a>
		</div>
		<table class="table table-bordered">
			<tr>
				<td class="show">Expense Name:</td>
				<td class="show">${expense.name}</td>
			</tr>
			<tr>
				<td class="show">Expense Description:</td>
				<td class="show">${expense.description}</td>
			</tr>
			<tr>
				<td class="show">Vendor:</td>
				<td class="show">${expense.vendor}</td>
			</tr>
			<tr>
				<td class="show">Amount Spent:</td>
				<td class="show">$${expense.amount}</td>
			</tr>
		</table>
	</div>
</body>
</html>