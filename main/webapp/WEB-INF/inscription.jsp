<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            height: 100vh;
            background: linear-gradient(135deg, #0f0f0f, #1a3d1a);
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0, 255, 0, 0.3);
            width: 350px;
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
            color: #aaffaa;
        }

        label {
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Inscription</h1>
        <form action="InscriptionServlet" method="post">
            <label for="pseudo">Pseudo</label>
            <input type="text" name="pseudo" id="pseudo" required>

            <label for="motdepasse">Mot de passe</label>
            <input type="password" name="motdepasse" id="motdepasse" required>

            <label for="confirm">Confirmer le mot de passe</label>
            <input type="password" name="confirm" id="confirm" required>

            <button type="submit">S'inscrire</button>
        </form>
    </div>
</body>
</html>
