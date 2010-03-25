<%-- 
    Document   : fehler
    Created on : 25.03.2010, 00:59:05
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="flugreservierung" uri="/WEB-INF/tld/flugreservierung"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fehler</title>
    </head>
    <body>
        <h1>Leider hat Ihre Reservierung nicht geklappt: </h1>
        <flugreservierung:attribut name="fehler" />

    </body>
</html>
