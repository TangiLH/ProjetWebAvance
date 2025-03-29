<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page session="true" %>
    
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Classement des joueurs</title>
    <%@ include file="style.jsp" %>
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	
	<c:if test="${not empty sessionScope.utilisateur}">
    <div style="padding: 10px; background-color: #e6ffe6; border: 1px solid #00cc66; margin: 15px 0;">
         Bienvenue, <strong>${sessionScope.utilisateur.pseudo}</strong> !
    </div>
	</c:if>
	
	
    <div class="container">
        <h1>Classement des Joueurs</h1>
        <table>
            <tr>
                <th>Position</th>
                <th>Pseudo</th>
                <th>Date</th>
                <th>Score</th>
                
            </tr>
            
            <!--TODO faire une boucle avec la bdd  -->  
            
            <tr>
                <td>1</td>
                <td>Joueur1</td>
                <td>date</td>
                <td>1500</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Joueur2</td>
                <td>date</td>
                <td>1450</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Joueur3</td>
                <td>date</td>
                <td>1400</td>
            </tr>
        </table>
    </div>
</body>
</html>