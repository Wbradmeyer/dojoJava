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
	<title>Ninja Gold Game</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<div class="wrapper">
		<h3>Your Gold: <c:out value="${gold}"/></h3>
		<div id="box_line">
			<div class="box">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<form action="/count_gold" method="post">
					<input type="hidden" name="id" value="farm">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<form action="/count_gold" method="post">
					<input type="hidden" name="id" value="cave">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<form action="/count_gold" method="post">
					<input type="hidden" name="id" value="house">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h3>Quest</h3>
				<p>(earns/loses 0-50 gold)</p>
				<form action="/count_gold" method="post">
					<input type="hidden" name="id" value="quest">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h3>Spa</h3>
				<p>(loses 5-20 gold)</p>
				<form action="/count_gold" method="post">
					<input type="hidden" name="id" value="spa">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
		</div>
		<h3>Activities:</h3>
		<div class="logs">
			<c:forEach var="log" items="${activities}">
				<c:out escapeXml="false" value="${log}"/>
			</c:forEach>
		</div>
		<a href="/restart">RESTART GAME</a>
	</div>
</body>
</html>