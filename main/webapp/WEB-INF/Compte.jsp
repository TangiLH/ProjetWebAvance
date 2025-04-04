<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="style.jsp"%>
</head>
<body>
<c:import url="/WEB-INF/inc/header.jsp"/>
<div class="container">
            <form method="post" action="ChangementMDP">
               
                        
				<h1>Changement de mot de passe</h1>
    
                    <label for="password">Nouveau mot de passe</label>
            		<input type="password" name="password" id="password" required>

            		<label for="confirm">Confirmer nouveau le mot de passe</label>
           			 <input type="password" name="confirm" id="confirm" required>
                 
                <button type="submit">Changer le mot de passe</button>
            </form>
            <form method="post" action="AjouterArgent">
               
                        
				<h1>Ajouter de l'argent</h1>
                 <label for="montant">Nouveau mot de passe</label>
            		<input type="number" name="montant" id="montant" required>
                <button type="submit">Ajouter de l'argent</button>
            </form>
        </div>
</body>
</html>