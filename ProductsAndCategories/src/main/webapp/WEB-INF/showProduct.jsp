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
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="top-box">
			<h1>${product.name}</h1>
			<p><a href="/">Home</a></p>
		</div>
		<div class="middle-box">
			<h3>Categories</h3>
			<c:forEach var="category" items="${product.categories}">
				<p>- <c:out value="${category.name}"/></p>
			</c:forEach>
		</div>
		<div class="bottom-box">
			<form action="/products/add-category" method="post">
				<input type="hidden" name="productId" value="${product.id}">
				<select name="categoryId">
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add" class="btn btn-primary">
			</form>
		</div>
	</div>
</body>
</html>