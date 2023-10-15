package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class auth_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Authentification</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form {\n");
      out.write("                width: 50%;\n");
      out.write("                margin: 50px auto;\n");
      out.write("                background-color: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            fieldset {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            legend {\n");
      out.write("                font-size: 1.2em;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            td {\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"text\"],\n");
      out.write("            input[type=\"password\"] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 8px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                background-color: #4caf50;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h3 {\n");
      out.write("                color: #f00;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"auth\" method=\"POST\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Authentification :</legend>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for=\"email\">Email :</label></td>\n");
      out.write("                        <td><input type=\"text\" id=\"email\" name=\"email\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for=\"password\">Mot de passe :</label></td>\n");
      out.write("                        <td><input type=\"password\" id=\"password\" name=\"password\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Connexion\"></td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><p><a href=\"MdpOublie.jsp\">Mot de passe oublié ?</a></p></td>\n");
      out.write("                        <td><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3></td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
