<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            background-color: #337ab7;
            color: #fff;
            padding: 10px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #337ab7;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        form {
            width: 80%;
            margin: 20px auto;
        }

        fieldset {
            border: 1px solid #ddd;
            padding: 10px;
        }

        legend {
            font-weight: bold;
            font-size: 20px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
        }

        input[type="submit"] {
            background-color: #337ab7;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #235a9f;
        }

        p {
            text-align: center;
            margin-top: 20px;
        }
        
        select {
            width: 100%;
            height: 35px;
        }

        a {
            text-decoration: none;
            color: #337ab7;
        }

        a:hover {
            text-decoration: underline;
        }
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
            z-index: 1000;
        }

        /* Styles pour l'arrière-plan obscurci */
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }
    </style>
    </head>
    <body>
        <a href="CommandeController">Gestion des Commandes</a>
        <form action="CategorieController">
                           

            <fieldset>
                <legend>Gestion des catégories</legend>
                <table border="0">
                   
                        <tr>
                            <td>Code: </td>
                            <td><input type="text" name="code" value="" /></td>
                        </tr>
                        <tr>
                            <td>Libelle : </td>
                            <td><input type="text" name="libelle" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Ajouter" name="Ajouter" /></td>
                            <td></td>
                        </tr>
               
                </table>

            </fieldset>
        </form>
        
        <fieldset>
            <legend>Liste des catégories</legend>
            <table border="0">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Libelle</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategorieService cs = new CategorieService();
                      for(Categorie c : cs.findAll()){  
                    %>
                    <tr>
                        <td><%= c.getCode() %></td>
                        <td><%= c.getLibelle() %></td>
                        <td><a href="CategorieController?op=delete&id=<%=c.getId() %>">Supprimer</a></td>
                        <td><a href="">Modifier</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </fieldset>
    </body>
</html>