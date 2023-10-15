<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Réinitialisation de votre mot de passe :</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        section {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        legend {
            font-size: 1.2em;
            font-weight: bold;
        }

        h3 {
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="email"] {
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

        h4 {
            color: #f00;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <section>
        <form action="MdpOublie" method="POST">
            <fieldset>
                <legend>Réinitialisation :</legend>
                <h3>Entrez votre E-mail pour recevoir un code de réinitialisation</h3>
                <table>
                    <tr>
                        <td>E-mail :</td>
                        <td><input type="email" name="email" required></td>
                        <td><input type="submit" value="Envoyer"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><h4>${msg}</h4></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </section>
</body>
</html>
