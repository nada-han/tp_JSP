<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }

            form {
                width: 50%;
                margin: 50px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            fieldset {
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 10px;
                margin-bottom: 20px;
            }

            legend {
                font-size: 1.2em;
                font-weight: bold;
            }

            table {
                width: 100%;
            }

            td {
                padding: 10px;
            }

            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            h3 {
                color: #f00;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <form action="auth" method="POST">
            <fieldset>
                <legend>Authentification :</legend>
                <table>
                    <tr>
                        <td><label for="email">Email :</label></td>
                        <td><input type="text" id="email" name="email" required></td>
                    </tr>
                    <tr>
                        <td><label for="password">Mot de passe :</label></td>
                        <td><input type="password" id="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Connexion"></td>
                        
                    </tr>
                    <tr>
                        <td><p><a href="MdpOublie.jsp">Mot de passe oublié ?</a></p></td>
                        <td><h3>${msg}</h3></td>
                        
                    </tr>
                    
                </table>
            </fieldset>
        </form>
        
    </body>
</html>
