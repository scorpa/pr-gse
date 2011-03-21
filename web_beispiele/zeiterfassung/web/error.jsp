<%-- 
    Document   : error
    Created on : 11.03.2011, 23:41:00
    Author     : Rudi

    Fehlerseite. Dient zum Anzeigen einer Fehlermeldung
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="z" uri="/WEB-INF/tld/zeiterfassung.tld"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Fehler</title>
    </head>
    <body>
        <h1>Es ist ein Fehler aufgetreten: <z:error /></h1>
    </body>
</html>
