<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Magasin de Skins</title>
    <%@ include file="style.jsp" %>
</head>
<body>

	<%@ include file="inc/header.jsp" %>
    <div class="magasin-container">
        <h1>Magasin de Skins</h1>
        <div class="magasin">
            <!-- Exemple de skin 1 -->
            <div class="skin">
                <img src="img/wall.png" alt="Skin 1">
                <div class="skin-info">
                    <p class="type">Type: <span>Mur</span></p>
                    <p class="name">Nom: <span>Skin Mur Merveilleux</span></p>
                    <p class="price">Prix: <span>100 Euros</span></p>
                    <button class="acheter-btn">Acheter</button>
                </div>
            </div>

            <!-- Exemple de skin 2 -->
            <div class="skin">
                <img src="img/snake_green_0.png" alt="Skin 2">
                <div class="skin-info">
                    <p class="type">Type: <span>Peau</span></p>
                    <p class="name">Nom: <span>Skin Peau de Goblin</span></p>
                    <p class="price">Prix: <span>200 Euros</span></p>
                    <button class="acheter-btn">Acheter</button>
                </div>
            </div>

            <!-- Exemple de skin 3 -->
            <div class="skin">
                <img src="img/snake_red_0.png" alt="Skin 3">
                <div class="skin-info">
                    <p class="type">Type: <span>Peau</span></p>
                    <p class="name">Nom: <span>Skin Peau Royale</span></p>
                    <p class="price">Prix: <span>150 Euros</span></p>
                    <button class="acheter-btn">Acheter</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
