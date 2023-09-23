<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fruit Store</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table">
			<tbody>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="fruit" items="${listOfFruits}">
					<tr>
						<c:if test = "${fruit.name.startsWith('G')==true}">
							<td style="color:orange;"><c:out value="${fruit.name}"></c:out></td>
						</c:if>
						<c:if test = "${fruit.name.startsWith('G')==false}">
							<td><c:out value="${fruit.name}"></c:out></td>
						</c:if>
						<td>$<c:out value="${fruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>