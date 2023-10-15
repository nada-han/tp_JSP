/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.projet.entity.Client;
import ma.projet.service.ClientService;
import ma.projet.util.EmailSender;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "MdpOublieController", urlPatterns = {"/MdpOublieController"})
public class MdpOublieController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        ClientService cl = new ClientService();
        Client c = cl.getByEmail(email);
        if (c != null) {

            double i = Math.random() * 100000;
            String code = (int) i + "";  // Convert to int to remove decimal places
            c.setCode(code);
            cl.update(c);
            HttpSession session = request.getSession();
            session.setAttribute("client", c);
            
            // Use EmailSender to send the email
            EmailSender.sendEmail(email, "Password Reset Code", "Your verification code is: " + code);
            
            response.sendRedirect("VerificationMail.jsp");
        } else {
            response.sendRedirect("MdpOublie.jsp?msg=Email n’existe pas ");
        }
    }
}
