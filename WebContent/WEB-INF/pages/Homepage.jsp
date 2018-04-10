<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/jquery-1.11.3.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/MyFirstJavascript.js"></script>
<c:choose>
	<c:when test='${role.equals("Teacher")}'>
		<link rel="stylesheet" type="text/css" href="static/css/catparty1.css"/>
	</c:when>
	<c:otherwise>
		<link rel="stylesheet" type="text/css" href="static/css/catparty2.css"/>
	</c:otherwise>
</c:choose>
<title>This is a title.</title>
</head>
<body onload='loadFunction()'>
	<jsp:include page="/WEB-INF/pages/Header.jsp"/>
	
	
	<h1>Welcome ${username}</h1>
	<h3>Your available information:</h3>
	<br>
	Filter by Class <input id="searchBox" type="text"/>
	<input id="gradesButton" type="button" value="Hide Table"/>
	<div id="gradesTab">
		<table id="infoTable">
			<tr>
				<th>UserID</th>
				<th>Username</th>
				<th>Role</th>
				<th>Name</th>
				<th>Age</th>
				<th>Class</th>
				<th>Class Grade</th>
				<th>Chapter</th>
				<th>Test Grade</th>
			</tr>
			<c:forEach var="row" items="${userInfos}">
			<tr>
				<td>${row.getId()}</td>
				<td>${row.getUsername()}</td>
				<td>${row.getRole()}</td>
				<td>${row.getName()}</td>
				<td>${row.getAge()}</td>
				<td class="classCol">${row.getTheclass()}</td>
				<td>${row.getClass_grade()}</td>
				<td>${row.getChapter()}</td>
				<td>${row.getTest_grade()}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/WEB-INF/pages/Footer.jsp"/>
</body>
</html>