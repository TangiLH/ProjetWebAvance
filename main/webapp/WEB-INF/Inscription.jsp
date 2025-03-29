<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <%@ include file="style.jsp" %>
</head>
<body>
	<%@ include file="inc/header.jsp" %>
    <div class="container">
        <h1>Inscription</h1>
        <form action="Inscription" method="post">
            <label for="pseudo">Pseudo</label>
            <input type="text" name="pseudo" id="pseudo" required>

            <label for="motdepasse">Mot de passe</label>
            <input type="password" name="password" id="password" required>

            <label for="confirm">Confirmer le mot de passe</label>
            <input type="password" name="confirm" id="confirm" required>

            <button type="submit">S'inscrire</button>
        </form>
    </div>
</body>
</html>