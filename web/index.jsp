<%-- 
    Document   : index
    Created on : 13/05/2015, 12:18:46 PM
    Author     : Fabrizzio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String sesion = (String) request.getSession(true).getAttribute("sesion");

    if (sesion != null) {

        RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
        rd.forward(request, response);

    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="LoginServlet">
            <fieldset>
                <div >
                    <input placeholder="Usuario" name="usuario" type="text">
                </div>
                <div >
                    <input  placeholder="Password" name="password" type="password" value="">
                </div>

                <input  type="submit" value="Ingresar">

            </fieldset>
        </form>
        <form method="post" action="Registro.html">
            <fieldset>
                <input  type="submit" value="Nuevo Usuario">
            </fieldset>
        </form>
    </body>
</html>
