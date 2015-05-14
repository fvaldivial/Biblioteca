<%-- 
    Document   : ListaLibros
    Created on : 14/05/2015, 02:43:51 PM
    Author     : Fabrizzio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="ListaLibros" scope="session" value="${sessionScope.ListaLibros}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:forEach var ="libro" items="${ListaLibros}">

            <c:out value="${libro.getIsbn()}"/><br>
            <c:out value="${libro.getTitulo()}"/><br>
            <c:out value="${libro.getAutor()}"/><br>
            <c:out value="${libro.getPaginas()}"/><br>


        </c:forEach>

    </body>
</html>
