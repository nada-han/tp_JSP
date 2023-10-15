package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import ma.projet.entities.Produit;
import ma.projet.services.ProduitService;
import ma.projet.entities.Commande;
import ma.projet.services.CommandeService;

public final class commande_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Liste des produits</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            background-color: #337ab7;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            width: 80%;\n");
      out.write("            margin: 20px auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            padding: 8px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #337ab7;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        tr:nth-child(even) {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form {\n");
      out.write("            width: 80%;\n");
      out.write("            margin: 20px auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        fieldset {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        legend {\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            background-color: #337ab7;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #235a9f;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        button {\n");
      out.write("             background-color: #337ab7;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("\n");
      out.write("        p {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        select {\n");
      out.write("            width: 100%;\n");
      out.write("            height: 35px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: #337ab7;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        .popup {\n");
      out.write("            display: none;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            transform: translate(-50%, -50%);\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);\n");
      out.write("            z-index: 1000;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Styles pour l'arrière-plan obscurci */\n");
      out.write("        .overlay {\n");
      out.write("            display: none;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("            background-color: rgba(0, 0, 0, 0.5);\n");
      out.write("            z-index: 999;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    <a href=\"CategorieController\">Gestion des Categories</a>\n");
      out.write("    <form action=\"CommandeController\" method=\"get\">\n");
      out.write("    <fieldset>\n");
      out.write("\n");
      out.write("        <legend>Gestion des commandes de produits</legend>\n");
      out.write("        <table border=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Choisir une commande : </td>\n");
      out.write("                <td>\n");
      out.write("                    <select name=\"commandeId\">\n");
      out.write("                        ");

                            CommandeService commandeService = new CommandeService();
                            List<Commande> commandes = commandeService.findAll();
                            for (Commande commande : commandes) {
                                // Vérifier si cette commande est celle sélectionnée précédemment
                                String selected = "";
                                if (request.getParameter("commandeId") != null && 
                                    request.getParameter("commandeId").equals(String.valueOf(commande.getId()))) {
                                    selected = "selected";
                                }
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( commande.getId() );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(">Commande ");
      out.print( commande.getId() );
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\"><input type=\"submit\" value=\"Afficher les produits\" name=\"valider\" /></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </fieldset>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    <fieldset>\n");
      out.write("                <legend>Gestion des produits</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Reference</th>\n");
      out.write("            <th>Prix</th>\n");
      out.write("            <th>Action</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

            List<Produit> produits = (List<Produit>) request.getAttribute("produits");

            if (produits != null) {
                for (Produit produit : produits) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( produit.getReference() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( produit.getPrix() );
      out.write(" DH</td>\n");
      out.write("            <td><a href=\"CommandeController?op=delete&id=");
      out.print( produit.getId() );
      out.write("\">Supprimer</a></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("    <!-- Le lien pour afficher la boîte de dialogue -->\n");
      out.write("    <p><a href=\"#\" id=\"ajouterCommandeLink\">Ajouter une commande</a></p>\n");
      out.write("    <p><a href=\"#\" id=\"ajouterProduitLink\">Ajouter un produit</a></p>\n");
      out.write("    \n");
      out.write("    <!-- La boîte de dialogue -->\n");
      out.write("    <div class=\"popup\" id=\"ajouterCommandePopup\">\n");
      out.write("        <h2>Ajouter une commande</h2>\n");
      out.write("        <!-- Formulaire pour ajouter un produit -->\n");
      out.write("        <form action=\"CommandeController\" method=\"post\">\n");
      out.write("            <!-- Les champs du formulaire -->\n");
      out.write("            <label for=\"date\">Date du commande :</label>\n");
      out.write("            <input type=\"date\" id=\"date\" name=\"date\" required>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            <!-- Bouton de soumission -->\n");
      out.write("            <input type=\"submit\" value=\"Ajouter\">\n");
      out.write("            <button onclick=\"closePopup()\">Fermer</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- L'arrière-plan obscurci -->\n");
      out.write("    <div class=\"overlay\" id=\"overlay\"></div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Fonction pour afficher la boîte de dialogue\n");
      out.write("        function openPopup() {\n");
      out.write("            document.getElementById(\"ajouterCommandePopup\").style.display = \"block\";\n");
      out.write("            document.getElementById(\"overlay\").style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Fonction pour fermer la boîte de dialogue\n");
      out.write("        function closePopup() {\n");
      out.write("            document.getElementById(\"ajouterCommandePopup\").style.display = \"none\";\n");
      out.write("            document.getElementById(\"overlay\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Écouteur d'événement pour le lien \"Ajouter un produit\"\n");
      out.write("        document.getElementById(\"ajouterCommandeLink\").addEventListener(\"click\", openPopup);\n");
      out.write("    </script>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <!-- La boîte de dialogue -->\n");
      out.write("    <div class=\"popup\" id=\"ajouterProduitPopup\">\n");
      out.write("        <h2>Ajouter un produit</h2>\n");
      out.write("        <!-- Formulaire pour ajouter un produit -->\n");
      out.write("        <form action=\"CommandeController\" method=\"post\">\n");
      out.write("            <!-- Les champs du formulaire -->\n");
      out.write("            <!-- Exemple : -->\n");
      out.write("            <label for=\"nomProduit\">Choisir une commande :</label>\n");
      out.write("            <br>\n");
      out.write("            <select name=\"commandeId\">\n");
      out.write("                        ");

                            for (Commande commande : commandes) {
                                // Vérifier si cette commande est celle sélectionnée précédemment
                                String selected = "";
                                if (request.getParameter("commandeId") != null && 
                                    request.getParameter("commandeId").equals(String.valueOf(commande.getId()))) {
                                    selected = "selected";
                                }
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( commande.getId() );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(">Commande ");
      out.print( commande.getId() );
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <br>\n");
      out.write("            <label for=\"nomProduit\">Reference du produit :</label>\n");
      out.write("            <input type=\"text\" id=\"reference\" name=\"reference\" required>\n");
      out.write("            \n");
      out.write("            <label for=\"nomProduit\">Prix du produit :</label>\n");
      out.write("            <input type=\"text\" id=\"prix\" name=\"prix\" required>\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <!-- Bouton de soumission -->\n");
      out.write("            <input type=\"submit\" value=\"Ajouter\">\n");
      out.write("            <button onclick=\"closePopup()\">Fermer</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- L'arrière-plan obscurci -->\n");
      out.write("    <div class=\"overlay\" id=\"overlay\"></div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Fonction pour afficher la boîte de dialogue\n");
      out.write("        function openPopup() {\n");
      out.write("            document.getElementById(\"ajouterProduitPopup\").style.display = \"block\";\n");
      out.write("            document.getElementById(\"overlay\").style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Fonction pour fermer la boîte de dialogue\n");
      out.write("        function closePopup() {\n");
      out.write("            document.getElementById(\"ajouterProduitPopup\").style.display = \"none\";\n");
      out.write("            document.getElementById(\"overlay\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Écouteur d'événement pour le lien \"Ajouter un produit\"\n");
      out.write("        document.getElementById(\"ajouterProduitLink\").addEventListener(\"click\", openPopup);\n");
      out.write("    </script>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
