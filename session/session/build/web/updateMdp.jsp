<%-- 
    Document   : updateMdp
    Created on : Oct 10, 2023, 9:30:24 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>nouveau mot de passe</legend>
            <form action="updatemotdepasse" method="post">
                <table>
                    <tr>
                        <td>password:</td>
                        <td><input type="password" name="password"></td>
                        <td>confirmer password :</td>
                        <td><input type="password" name="passwordcnf"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Modifier"</td>
                    </tr>
                    <tr><td><h4><%= request.getParameter("msg")%></h4></td></tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>

