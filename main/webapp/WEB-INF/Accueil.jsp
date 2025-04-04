<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< Updated upstream
	pageEncoding="UTF-8"%>
=======
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
=======
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page session="true" %>
    
>>>>>>> 3efd0f735dd11fb0261e9bcf18bd291fe89333d9
>>>>>>> Stashed changes
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Classement des joueurs</title>
<%@ include file="style.jsp"%>
</head>
<body>
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
=======
	<%@ include file="inc/header.jsp" %>
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
>>>>>>> 3efd0f735dd11fb0261e9bcf18bd291fe89333d9
>>>>>>> Stashed changes
</body>
</html>