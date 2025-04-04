<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Magasin de Skins</title>
<%@ include file="style.jsp"%>
</head>
<body>

	<%@ include file="inc/header.jsp"%>
	<div class="magasin-container">
		<h1>Magasin de Skins</h1>

		<c:if test="${empty items}">
			<h2>Aucun item disponible.</h2>
		</c:if>
		<div class="magasin">
			<c:forEach var="item" items="${items}">
				<div class="skin">
					<c:set var="formattedName"
						value="${fn:toLowerCase(fn:replace(item.nom, ' ', ''))}" />
					<img src="img/${formattedName}.png" alt="${formattedName}">
					<c:if test="${fn:contains(formattedName, 'mur')}">

					</c:if>
					<c:choose>
						<c:when test="${fn:contains(formattedName, 'mur')}">
							<div class="mur">
								<img src="img/${formattedName}.png" alt="${formattedName}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="serpent">
								<img src="img/${formattedName}.png" alt="${formattedName}">

								<img src="img/${formattedName}corps.png"
									alt="${formattedName} corps">
							</div>
						</c:otherwise>
					</c:choose>


					<div class="skin-info">
						<c:set var="words" value="${fn:split(item.nom, ' ')}" />
						<c:if test="${fn:length(words) > 1}">
							<c:set var="typeItem" value="${words[1]}" />
						</c:if>
						<p class="type">
							Type: <span>${typeItem}</span>
						</p>
						<p class="name">
							Nom: <span>${item.nom}</span>
						</p>
						<p class="price">
							Prix: <span>${item.prix}</span>
						</p>
						<c:set var="possede" value="false" />
						<c:forEach var="userItem" items="${gotItems}">
							<c:if test="${userItem.nom == item.nom}">
								<c:set var="possede" value="true" />
								<p class="deja-acheter">Vous possédez déjà cet objet</p>
							</c:if>
						</c:forEach>

						<c:if test="${!possede}">
							<button class="acheter-btn" onclick="showPopup('${item.nom}')">Acheter</button>


						</c:if>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Popup Modal -->
	<div id="popup" class="popup" style="display: none;">
		<div class="popup-content">
			<span id="popup-close" class="popup-close">&times;</span>
			<p>Êtes-vous sûr de vouloir acheter cet item ?</p>
			<form id="popup-form" action="ConfirmationAchat" method="POST">
				<input type="hidden" id="itemName" name="itemName" value="" />
				<button type="submit">Confirmer</button>
			</form>
			<button id="popup-cancel" class="popup-cancel">Annuler</button>
		</div>
	</div>

	<script>
		// Fonction pour afficher la popup
		function showPopup(itemName) {
			// Afficher la popup
			document.getElementById('popup').style.display = 'block';
			// Assigner le nom de l'item au champ caché
			document.getElementById('itemName').value = itemName;
		}

		// Cacher la popup lorsque l'utilisateur clique sur "Annuler"
		document.getElementById('popup-cancel').addEventListener('click',
				function() {
					document.getElementById('popup').style.display = 'none';
				});

		// Cacher la popup lorsque l'utilisateur clique sur la croix "×"
		document.getElementById('popup-close').addEventListener('click',
				function() {
					document.getElementById('popup').style.display = 'none';
				});
		
		

		window.onclick = function(event) {
		    let popup = document.getElementById('popup');
		    if (event.target == popup) {
		        popup.style.display = 'none';
		    }
			let popup = document.getElementById('popup');
			if (event.target == popup) {
				popup.style.display = 'none';
			}
		};
	</script>
</body>
</html>
