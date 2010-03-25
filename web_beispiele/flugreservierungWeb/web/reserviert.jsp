<%-- 
    Document   : reserviert
    Created on : 25.03.2010, 00:40:53
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%@taglib prefix="flugreservierung" uri="/WEB-INF/tld/flugreservierung"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservierung erfolgreich</title>
    </head>
    <body>
        <h1>Vielen Dank für Ihre Reservierung</h1>
        Hier Ihre Daten: <br/>
        Name: <flugreservierung:attribut name="passagiername" /><br/>
        Flugnummer: <flugreservierung:attribut name="flugnummer" /><br/>
        Reservierungsnummer: <flugreservierung:attribut name="reservierungsnummer" /><br/>
    </body>
</html>
