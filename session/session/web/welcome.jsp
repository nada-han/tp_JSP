<%@page import="ma.projet.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
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

        h1 {
            color: #333;
        }

        p {
            color: #777;
        }

        a {
            color: #4caf50;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <section>
        <%
            String nom = request.getParameter("nom");
            Client c = (Client) session.getAttribute("client");
            if (c == null && nom != null) {
                // Utilisateur vient de s'inscrire, affichez un message de bienvenue avec le nom
        %>
        <h1>Bienvenue, <%= nom%> !</h1>
        <p>Merci de vous être inscrit. Connectez-vous <a href="auth.jsp">ici</a>.</p>
        <%
        } else if (c != null) {
            // L'utilisateur est connecté, affichez un message de bienvenue avec son nom
        %>
        <h1>Bienvenue, <%= c.getNom()%> !</h1>
        <p>Vous êtes connecté. <a href="Deconnexion">Déconnexion</a></p>
        <%
        } else {
            // L'utilisateur n'est ni connecté ni vient de s'inscrire, redirigez-le vers la page d'authentification
            response.sendRedirect("auth.jsp");
        }
        %>
    </section>
</body>
</html>
