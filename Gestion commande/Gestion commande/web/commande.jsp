<%@ page import="java.util.List" %>
<%@ page import="ma.projet.entities.Produit" %>
<%@ page import="ma.projet.services.ProduitService" %>
<%@ page import="ma.projet.entities.Commande" %>
<%@ page import="ma.projet.services.CommandeService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des produits</title>
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
        
        button {
             background-color: #337ab7;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
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
    
    <a href="CategorieController">Gestion des Categories</a>
    <form action="CommandeController" method="get">
    <fieldset>

        <legend>Gestion des commandes de produits</legend>
        <table border="0">
            <tr>
                <td>Choisir une commande : </td>
                <td>
                    <select name="commandeId">
                        <%
                            CommandeService commandeService = new CommandeService();
                            List<Commande> commandes = commandeService.findAll();
                            for (Commande commande : commandes) {
                                // Vérifier si cette commande est celle sélectionnée précédemment
                                String selected = "";
                                if (request.getParameter("commandeId") != null && 
                                    request.getParameter("commandeId").equals(String.valueOf(commande.getId()))) {
                                    selected = "selected";
                                }
                        %>
                        <option value="<%= commande.getId() %>" <%= selected %>>Commande <%= commande.getId() %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Afficher les produits" name="valider" /></td>
            </tr>
        </table>
    </fieldset>
</form>

    <fieldset>
                <legend>Gestion des produits</legend>
                <table border="0">
    <thead>
        <tr>
            <th>Reference</th>
            <th>Prix</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Produit> produits = (List<Produit>) request.getAttribute("produits");

            if (produits != null) {
                for (Produit produit : produits) {
        %>
        <tr>
            <td><%= produit.getReference() %></td>
            <td><%= produit.getPrix() %> DH</td>
            <td><a href="CommandeController?op=delete&id=<%= produit.getId() %>">Supprimer</a></td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

    <!-- Le lien pour afficher la boîte de dialogue -->
    <p><a href="#" id="ajouterCommandeLink">Ajouter une commande</a></p>
    <p><a href="#" id="ajouterProduitLink">Ajouter un produit</a></p>
    
    <!-- La boîte de dialogue -->
    <div class="popup" id="ajouterCommandePopup">
        <h2>Ajouter une commande</h2>
        <!-- Formulaire pour ajouter un produit -->
        <form action="CommandeController" method="post">
            <!-- Les champs du formulaire -->
            <label for="date">Date du commande :</label>
            <input type="date" id="date" name="date" required>
            
            <br>
            <!-- Bouton de soumission -->
            <input type="submit" value="Ajouter">
            <button onclick="closePopup()">Fermer</button>
        </form>
    </div>

    <!-- L'arrière-plan obscurci -->
    <div class="overlay" id="overlay"></div>

    <script>
        // Fonction pour afficher la boîte de dialogue
        function openPopup() {
            document.getElementById("ajouterCommandePopup").style.display = "block";
            document.getElementById("overlay").style.display = "block";
        }

        // Fonction pour fermer la boîte de dialogue
        function closePopup() {
            document.getElementById("ajouterCommandePopup").style.display = "none";
            document.getElementById("overlay").style.display = "none";
        }

        // Écouteur d'événement pour le lien "Ajouter un produit"
        document.getElementById("ajouterCommandeLink").addEventListener("click", openPopup);
    </script>
</div>

    <!-- La boîte de dialogue -->
    <div class="popup" id="ajouterProduitPopup">
        <h2>Ajouter un produit</h2>
        <!-- Formulaire pour ajouter un produit -->
        <form action="CommandeController" method="post">
            <!-- Les champs du formulaire -->
            <!-- Exemple : -->
            <label for="nomProduit">Choisir une commande :</label>
            <br>
            <select name="commandeId">
                        <%
                            for (Commande commande : commandes) {
                                // Vérifier si cette commande est celle sélectionnée précédemment
                                String selected = "";
                                if (request.getParameter("commandeId") != null && 
                                    request.getParameter("commandeId").equals(String.valueOf(commande.getId()))) {
                                    selected = "selected";
                                }
                        %>
                        <option value="<%= commande.getId() %>" <%= selected %>>Commande <%= commande.getId() %></option>
                        <% } %>
                    </select>
                    <br>
            <label for="nomProduit">Reference du produit :</label>
            <input type="text" id="reference" name="reference" required>
            
            <label for="nomProduit">Prix du produit :</label>
            <input type="text" id="prix" name="prix" required>
            

            <!-- Bouton de soumission -->
            <input type="submit" value="Ajouter">
            <button onclick="closePopup()">Fermer</button>
        </form>
    </div>

    <!-- L'arrière-plan obscurci -->
    <div class="overlay" id="overlay"></div>

    <script>
        // Fonction pour afficher la boîte de dialogue
        function openPopup() {
            document.getElementById("ajouterProduitPopup").style.display = "block";
            document.getElementById("overlay").style.display = "block";
        }

        // Fonction pour fermer la boîte de dialogue
        function closePopup() {
            document.getElementById("ajouterProduitPopup").style.display = "none";
            document.getElementById("overlay").style.display = "none";
        }

        // Écouteur d'événement pour le lien "Ajouter un produit"
        document.getElementById("ajouterProduitLink").addEventListener("click", openPopup);
    </script>
</div>
</body>
</html>