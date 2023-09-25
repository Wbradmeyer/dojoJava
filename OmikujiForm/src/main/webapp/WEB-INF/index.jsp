<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Omikuji Form</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/collect" method="post">
		<label>Pick any number from 5 to 25</label>
		<input type="number" name="quantity" min="5" max="25" class="form-control" style="width:70px;">
		
		<label>Enter the name of any city:</label>
		<input type="text" name="city" class="form-control">
		
		<label>Enter the name of any real person:</label>
		<input type="text" name="person" class="form-control">
		
		<label>Enter professional endeavor or hobby:</label>
		<input type="text" name="hobby" class="form-control">
		
		<label>Enter any type of living thing:</label>
		<input type="text" name="thing" class="form-control">
		
		<label>Say something nice to someone:</label>
		<textarea name="nice" class="form-control"></textarea>
		
		<label>Send and show a friend</label>
		<button>Submit</button>
	</form>
	</div>
</body>
</html>