package ma.projet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.projet.entity.Client;
import ma.projet.service.ClientService;
import ma.projet.util.Utils;

@WebServlet(name = "Auth", urlPatterns = {"/auth"})
public class Auth extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ClientService cs = new ClientService();
        Client client = cs.getByEmail(email);

        if (client != null) {
            // Le client existe, vérifiez le mot de passe haché
            String hashedPassword = Utils.MD5(password); // Utilisez MD5 pour hacher le mot de passe entré

            if (client.getPassword().equals(hashedPassword)) {
                // L'authentification a réussi, définissez la session et redirigez vers la page "welcome.jsp"
                HttpSession session = request.getSession(true);
                session.setAttribute("client", client);
                response.sendRedirect("welcome.jsp");
                return; // Sortez de la méthode pour éviter le traitement inutile
            }
        }

        // L'authentification a échoué, affichez un message d'erreur et redirigez vers la page d'authentification
        request.setAttribute("msg", "Email ou mot de passe incorrect");
        request.getRequestDispatcher("auth.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Contrôleur d'authentification";
    }
}
