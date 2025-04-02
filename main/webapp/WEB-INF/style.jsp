<style>
/* Styles généraux */
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', sans-serif;
	height: 100vh;
	background: linear-gradient(135deg, #0f0f0f, #1a3d1a);
	display: flex;
	flex-direction: column;
	align-items: center;
	color: white;
}

/* Header */
.header {
	width: 100%;
	background: rgba(0, 0, 0, 0.8);
	padding: 15px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 0 10px rgba(0, 255, 0, 0.3);
}

.header .left {
	display: flex;
}

.header .right {
	display: flex;
	gap: 20px;
}

.header a {
	color: white;
	text-decoration: none;
	font-weight: bold;
	padding: 10px 20px;
	transition: color 0.3s;
}

.header a:hover {
	color: #00e676;
}

/* Conteneur principal */
.container {
	background-color: rgba(0, 0, 0, 0.7);
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 0 15px rgba(0, 255, 0, 0.3);
	width: 400px;
	text-align: center;
	margin-top: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 25px;
	color: #aaffaa;
}

/* Tableau de classement */
table {
	width: 100%;
	border-collapse: collapse;
	background: transparent;
	color: white;
}

th, td {
	border: 1px solid #444;
	padding: 10px;
}

th {
	background: #aaffaa;
	color: black;
}

tr:nth-child(even) {
	background: rgba(255, 255, 255, 0.1);
}

/* Formulaire */
label {
	text-align: left;
	display: block;
	margin-top: 15px;
	font-size: 14px;
}

input {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: none;
	border-radius: 5px;
	background-color: #222;
	color: white;
}

button {
	width: 100%;
	margin-top: 25px;
	padding: 12px;
	background: linear-gradient(to right, #00cc66, #009944);
	border: none;
	color: white;
	font-weight: bold;
	border-radius: 5px;
	cursor: pointer;
	transition: background 0.3s ease;
}

button:hover {
	background: linear-gradient(to right, #00e676, #00c853);
}

.magasin-container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
}

.magasin-container h1 {
	text-align: center;
	color: #aaffaa;
	margin-bottom: 30px;
}

.magasin-container h2 {
	text-align: center;
	color: #white;
	margin-bottom: 30px;
}

.magasin {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 20px;
	justify-items: center;
}

.skin {
	background-color: rgba(0, 0, 0, 0.7);
	border-radius: 10px;
	width: 300px;
	overflow: hidden;
	box-shadow: 0 0 10px rgba(0, 255, 0, 0.3);
	text-align: center;
}

.skin img {
	width: 200px; /* Largeur de l'image */
	height: 200px; /* Hauteur de l'image */
	object-fit: cover;
}

.skin-info {
	padding: 10px;
}

.type, .name, .price {
	margin: 10px 0;
}

.type span, .name span, .price span {
	font-weight: bold;
}

.deja-acheter {
	background: rgba(0, 0, 0, 0.7);
	color: white;
	padding-top: 30px;
	border: none;
	border-radius: 5px;
	font-weight: bold;
}

.acheter-btn {
	background: linear-gradient(to right, #00cc66, #009944);
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background 0.3s ease;
	font-weight: bold;
}

.acheter-btn:hover {
	background: linear-gradient(to right, #00e676, #00c853);
}

/* Confirmation d'achat */
.confirmation-container {
    background: rgba(0, 0, 0, 0.8);
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 15px rgba(0, 255, 0, 0.3);
    width: 450px;
    text-align: center;
    margin-top: 20px;
}

.confirmation-container img {
    width: 200px;
    height: auto;
    margin: 20px 0;
    border-radius: 10px;
}

.recap p {
    font-size: 18px;
    margin: 10px 0;
}

.recap strong {
    color: #00ff00;
}

/* Style pour la fenêtre modale */
.popup {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    backdrop-filter: blur(5px);
}

/* Contenu de la fenêtre modale */
.popup-content {
    background-color: black;
    margin: 15% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 300px;
    text-align: center;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 255, 0, 0.4);
}

.close-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    font-size: 30px;
    font-weight: bold;
    color: #aaa;
    cursor: pointer;
}

.close-btn:hover, .close-btn:focus {
    color: #fff;
}

/* Bouton de retour */
a {
    display: inline-block;
    margin-top: 15px;
    color: #00ff00;
    text-decoration: none;
    font-weight: bold;
    transition: color 0.3s ease;
}

a:hover {
    color: #00e676;
}
.error {
    color: red;
    font-size: 18px;
    font-weight: bold;
    text-align: center;
    margin-top: 15px;
}

.compte-btn {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background: linear-gradient(to right, #ff3333, #cc0000);
    color: white;
    text-decoration: none;
    font-weight: bold;
    border-radius: 5px;
    transition: background 0.3s ease, transform 0.2s;
}

.compte-btn:hover {
    background: linear-gradient(to right, #ff6666, #ff3333);
    transform: scale(1.05);
}
</style>