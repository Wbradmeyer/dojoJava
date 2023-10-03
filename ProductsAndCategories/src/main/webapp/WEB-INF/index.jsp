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
    <title>Home Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="top-box">
			<h1>Home Page</h1>
			<p><a href="/products/new">New Product</a></p>
			<p><a href="/categories/new">New Category</a></p>
		</div>
		<div class="bottom-box">
			<table class="table table-bordered">
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
				<tr>
					<td>
						<c:forEach var="product" items="${products}">
							<p>- 
								<a href="/products/${product.id}"><c:out value="${product.name}"/></a>
							</p>
								
						</c:forEach>
					</td>
					<td>
						<c:forEach var="category" items="${categories}">
							<p>- 
								<a href="/categories/${category.id}"><c:out value="${category.name}"/></a>
							</p>
						</c:forEach>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>