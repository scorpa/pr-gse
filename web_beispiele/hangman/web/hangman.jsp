<%-- 
    Document   : index
    Created on : 30.05.2011, 23:38:46
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Hangman</title>
    </head>
    <body>
        <h1><c:out value="${hangman.anzeige}"/></h1>
        <form action="input">
            <c:choose>
                <c:when test="${!hangman.fertig}">
                    <input type="text" name="buchstabe" value="" size="1" />
                </c:when>
                <c:otherwise>
                    Erraten!
                </c:otherwise>
            </c:choose>
            <input type="submit" value="WEITER" />
        </form>

        <p>Fehlversuche: <c:out value="${hangman.fehlVersuche}"/></p>
    </body>
</html>
