<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>THIS IS CAT CITY</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/Header.jsp"/>
	<h1>Hello, ${myName}.</h1>
	<h3>Your roles:</h3>
	<ul>
		<c:forEach var="arrayVar" items="${roles}">
			<li>${arrayVar}</li>
		</c:forEach>
	</ul>
	<br>
	<h4>Here's a table:</h4>
	<table border="10" bordercolor="green" background="/images/steve_harvey.jpg">
		<tr>
			<td><b>Name</b></td>
			<td><b>Occupation</b></td>
			<td><b>Age</b></td>
			<td><b>Has "c"</b></td>
		</tr>
		<c:forEach var="PeopleVar" items="${users}">
			<tr>
				<td>${PeopleVar.name}</td>
				<td>${PeopleVar.occupation}</td>
				<td>${PeopleVar.age}</td>
				<td><c:if test="${fn:contains(PeopleVar.occupation, 'c')}">
					Yes</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<p>${sentence}</p>
	<c:set var="SentenceArray" value="${fn:split(sentence, ' ')}"/>
	<ul>
		<c:forEach var="SentenceVar" items="${SentenceArray}">
			<li>${SentenceVar}</li>
		</c:forEach>
	</ul>
	<br>
	<br>
	<jsp:include page="/WEB-INF/pages/Footer.jsp"/>
	
</body>
</html>