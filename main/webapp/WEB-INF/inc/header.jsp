<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="left">
		<a href="<c:url value="Accueil"/>">Classement</a>

	</div>
	<div class="right">
		<c:choose>
			<c:when test="${not empty sessionScope.utilisateur}">
				<a href="<c:url value="Compte"/>">Mon Compte</a>
				<a href="<c:url value="Magasin"/>">Magasin</a>
				<a class="money-display">
					<img src="img/money-icon.png" alt="Money" class="money-icon"/>
					<span>${sessionScope.utilisateur.money}</span>
				</a>
				<a href="Deconnexion" class="logout-button">
                    
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24" fill="white">
                        <path d="M10 17L15 12L10 7V10H3V14H10V17ZM21 5H13V7H21V17H13V19H21C22.1 19 23 18.1 23 17V7C23 5.9 22.1 5 21 5Z"/>
                    </svg>
                  
                </a>
			</c:when>
			<c:otherwise>

				<a href="<c:url value="Connexion"/>">Connexion</a>
				<a href="<c:url value="Inscription"/>">Inscription</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>

