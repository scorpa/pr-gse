<%-- 
    Document   : gaestebuch
    Created on : 21.05.2011, 23:30:02
    Author     : Rudi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gästebuch</title>
    </head>
    <body>
        <h1>Guten Tag <c:out value="${name}" /></h1>
        Erstelle hier deinen neuen Eintrag

        <form action="neu">
            <textarea name="text" rows="5" cols="80"></textarea>
            <br/>
            <input type="submit" value="abschicken" />
        </form>

        <hr />

        <h2>Ausgewählte Einträge</h2>



        <form action="auswahl">
            <input type="submit" value="alle" name="alle" />
            <input type="submit" value="nur meine" name="meine" />

        </form>

        <hr />

        <c:if test="${alle}">
            Alle Einträge ausgewählt
  
        </c:if>
        <c:if test="${!alle}">
            Nur meine Einträge ausgewählt
        </c:if>


        <table border="1">
            <thead>
                <tr>
                    <th>Datum</th>
                    <th>von</th>
                    <th>Text</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${eintraege}" var="eintrag">
                    <tr>
                        <td><c:out value="${eintrag.datum}"/></td>
                        <td><c:out value="${eintrag.ersteller}"/></td>
                        <td><c:out value="${eintrag.text}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
