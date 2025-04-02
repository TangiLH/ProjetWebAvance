<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<%@ include file="style.jsp" %>
</head>
<body>
<c:import url="/WEB-INF/inc/header.jsp"/>
<div class="container">
            <form method="post" action="Connexion">
               
                        
				<h1>Connexion</h1>
    
                    <label for="userName">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="userName" name="userName" value="<c:out value="${param.userName}"/>" size="20" maxlength="20" />
                    <span class="erreur">${erreursUtilisateur['userName']}</span>
                    <br />
                    
                    <label for="mdp">Mot de Passe </label>
                    <input type="text" id="mdp" name="mdp" value="<c:out value="${param.mdp}"/>" size="20" maxlength="20" />
                    <span class="erreur">${erreursUtilisateur['mdp']}</span>
                    <br />
                 
                <input type="submit" value="Valider"  />
            </form>
        </div>
</body>
</html>