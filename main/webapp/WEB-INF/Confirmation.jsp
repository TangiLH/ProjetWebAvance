<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Confirmation d'Achat</title>
<%@ include file="style.jsp"%>
</head>
<body>

	<%@ include file="inc/header.jsp"%>
	<div class="confirmation-container">
		<h1>Confirmation d'Achat</h1>

		<c:choose>
			<c:when test="${achatReussi}">
				<p>${message}</p>
				<p>
					Vous avez acheté : <strong>${sessionScope.item.nom}</strong>
				</p>
				<p>
					Prix : <strong>${sessionScope.item.prix} crédits</strong>
				</p>
				<c:set var="formattedName"
					value="${fn:toLowerCase(fn:replace(sessionScope.item.nom, ' ', ''))}" />
				<img src="img/${formattedName}.png" alt="${formattedName}">
				<a href="Magasin.jsp">Retour au magasin</a>
			</c:when>
			<c:otherwise>
				<p class="error">${message}</p>
				<a href="Compte.jsp" class="compte-btn">Ajouter des crédits</a>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>

