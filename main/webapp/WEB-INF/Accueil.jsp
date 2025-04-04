
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Classement des joueurs</title>
<%@ include file="style.jsp"%>
</head>
<body>

	<%@ include file="inc/header.jsp"%>
	<div class="container">
		<h1>Classement des Joueurs</h1>
		<table>

			<tr>
				<th>Position</th>
				<th>Pseudo</th>
				<th>Date</th>
				<th>Score</th>

			</tr>


			<c:forEach var="entry" items="${classement}" varStatus="rank">
				<tr>
					<td>${rank.index + 1}</td>
					<td>${entry.pseudo}</td>
					<td>${entry.date}</td>
					<td>${entry.score}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>