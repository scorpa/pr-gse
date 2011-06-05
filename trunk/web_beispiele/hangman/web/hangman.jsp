<%-- 
    Document   : index
    Created on : 30.05.2011, 23:38:46
    Author     : Rudolf Radlbauer
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
        <c:set var="alphabet"
               value="A,B,C,D,E,F,G,H,I,J,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z" />

        <h1><c:out value="${hangman.anzeige}"/></h1>
        <c:choose>
            <c:when test="${!hangman.fertig}">
                <c:forEach items="${alphabet}" var="buchstabe">
                    <a href="input?buchstabe=<c:out value="${buchstabe}"/>">
                       <c:out value=" ${buchstabe} "/>
                    </a>
                    &nbsp;
                </c:forEach>
            </c:when>
            <c:otherwise>
                Erraten! <br/>
                <a href="input">neues Spiel</a>
            </c:otherwise>
        </c:choose>


        <p>Fehlversuche: <c:out value="${hangman.fehlVersuche}"/></p>
    </body>
</html>
