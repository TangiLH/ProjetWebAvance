<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<div class="left">
		<a href="#">Classement</a>
    </div>
        <div class="right">
        	<c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="">Mon Compte</a>
                    <a href="">Magasin</a>
                    <a href="">Déconnexion</a>
                </c:when>
                <c:otherwise>

                    <a href="">Connexion</a>
                    <a href="<c:url value="Inscription"/>">Inscription</a>
                </c:otherwise>
            </c:choose>
	</div>
</div>
    
    
    <!--TODO VERIFIER QU'ON EST CONNECTE -->
