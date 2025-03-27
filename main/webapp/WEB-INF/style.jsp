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
    </style>