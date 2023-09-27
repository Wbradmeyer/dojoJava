<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List of Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>All Books</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th># of Pages</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.id}</td>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td>${book.language}</td>
					<td>${book.numberOfPages}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>