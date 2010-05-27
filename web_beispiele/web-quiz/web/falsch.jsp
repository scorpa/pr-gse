<%-- 
    Document   : falsch
    Created on : 25.05.2010, 23:14:46
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="quiz" uri="/WEB-INF/tld/quiz"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry ...</title>
    </head>
    <body>
        Leider Stimmt Ihre Antwort nicht. <br/>
        Die richtige Antwort lautet: <br/>
        <b><quiz:ausgabe feld="richtig" /></b><br/>
        
        <a href="index.jsp">weiter ...</a>


    </body>
</html>
