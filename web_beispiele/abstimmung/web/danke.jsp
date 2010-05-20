<%-- 
    Document   : danke
    Created on : 16.05.2010, 00:47:48
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="abstimmung" uri="/WEB-INF/tld/abstimmung"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vielen Dank</title>
    </head>
    <body>
        <h1>Vielen Dank für Ihre Stimme</h1>
        Bisherige Stimmen:<br/>
        Ja: <abstimmung:statistik typ="ja"/> (<abstimmung:statistik typ="prozent" />%)<br/>
        Nein: <abstimmung:statistik typ="nein" />
    </body>
</html>
