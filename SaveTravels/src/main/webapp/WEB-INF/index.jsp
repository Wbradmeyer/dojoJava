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
		<h1>Save Travels</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td><c:out value="$${expense.amount}"/></td>
						<td class="action">
							<a href="/expenses/${expense.id}/edit" class="btn btn-warning">Edit</a>
							<form action="/expenses/${expense.id}/delete" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="form">
			<h2>Add an Expense:</h2>
			<form:form action="/expenses/new" method="post" modelAttribute="expense">
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
					<form:input type="number" step="0.01" placeholder="1.00" path="amount" class="form-control" style="width: 100px;"/>
				</p>
				<p>
					<form:label path="description">Notes:</form:label>
					<form:errors path="description"/>
					<form:textarea path="description" class="form-control"/>
				</p>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>