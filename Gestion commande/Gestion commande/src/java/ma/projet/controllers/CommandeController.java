package ma.projet.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.entities.Produit;
import ma.projet.services.CommandeService;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;

@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

    // ...

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String selectedCommandeId = request.getParameter("commandeId");

        if (selectedCommandeId != null && !selectedCommandeId.isEmpty()) {
            int commandeId = Integer.parseInt(selectedCommandeId);
            
            // Récupérer l'objet Commande en fonction de l'ID
            CommandeService commandeService = new CommandeService();
            Commande commande = commandeService.getById(commandeId); // Assurez-vous que la méthode getById existe

            if (commande != null) {
                // Utiliser l'objet Commande pour obtenir la liste des produits
                ProduitService produitService = new ProduitService();
                List<Produit> produits = produitService.findProduitByCommande(commande);
                
                // Placer la liste des produits dans un attribut de la requête
                request.setAttribute("produits", produits);
            }
        }

        // Rediriger vers la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("commande.jsp");
        dispatcher.forward(request, response);
    }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Récupérer les paramètres du formulaire
    String commandeIdStr = request.getParameter("commandeId");
    String reference = request.getParameter("reference");
    String prixStr = request.getParameter("prix");

    // Vérifier si les champs sont remplis
    if (commandeIdStr != null && !commandeIdStr.isEmpty() && reference != null && !reference.isEmpty() && prixStr != null && !prixStr.isEmpty()) {
        int commandeId = Integer.parseInt(commandeIdStr);
        double prix = Double.parseDouble(prixStr);

        // Créer le produit en utilisant le service de produit
        ProduitService produitService = new ProduitService();
        Produit produit = new Produit(reference, prix);

        boolean produitCreated = produitService.create(produit);

        if (produitCreated) {
            // Maintenant, obtenez la commande associée
            CommandeService commandeService = new CommandeService();
            Commande commande = commandeService.getById(commandeId);
            LigneCommandeProduitService lcps = new LigneCommandeProduitService();

           
           int produitId = produit.getId(); // Assurez-vous que cela récupère l'ID du produit correctement
           Produit p = produitService.getById(produitId);

           

           LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(p.getId(), commande.getId());
           
        
           LigneCommandeProduit lp = new LigneCommandeProduit(lpk, 1);
           
           lcps.create(lp);
          
            // Rediriger l'utilisateur vers la page de liste des produits mise à jour
            response.sendRedirect("CommandeController?commandeId=" + commandeId);
        } else {
            // Gestion de l'erreur de création du produit
            // Vous pouvez rediriger vers une page d'erreur ou afficher un message d'erreur
        }
    } else {
        request.setAttribute("erreur", "Veuillez remplir tous les champs.");
    
        // Rediriger l'utilisateur vers la page du formulaire d'ajout de produit
        RequestDispatcher dispatcher = request.getRequestDispatcher("commande.jsp");
        dispatcher.forward(request, response);
    }
}
    protected void doCreateCommande(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les paramètres du formulaire pour la nouvelle commande
        String dateStr = request.getParameter("date"); // Assurez-vous que le nom du paramètre correspond à votre formulaire

        // Vérifier si les champs sont remplis
        if (dateStr != null && !dateStr.isEmpty()) {
            // Convertir la date en un format approprié (par exemple, en utilisant SimpleDateFormat)
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateCommande = null;
            try {
                dateCommande = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Gérer l'erreur de conversion de date
            }

            // Créer la nouvelle commande en utilisant le service de commande
            CommandeService commandeService = new CommandeService();
            Commande nouvelleCommande = new Commande(dateCommande);

            boolean commandeCreated = commandeService.create(nouvelleCommande);

            if (commandeCreated) {
                // Rediriger l'utilisateur vers la page de liste des commandes ou une autre page appropriée
                response.sendRedirect("CommandeController"); // Vous pouvez ajuster la redirection selon votre structure de navigation
            } else {
                // Gestion de l'erreur de création de la commande
                // Vous pouvez rediriger vers une page d'erreur ou afficher un message d'erreur
            }
        } else {
            request.setAttribute("erreur", "Veuillez remplir tous les champs.");

            // Rediriger l'utilisateur vers la page du formulaire de création de commande
            RequestDispatcher dispatcher = request.getRequestDispatcher("commande.jsp");
            dispatcher.forward(request, response);
        }
    }


}