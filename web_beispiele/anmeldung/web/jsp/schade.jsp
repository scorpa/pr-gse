<%-- 
    Document   : schade
    Created on : 21.02.2010, 19:46:11
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="anmeldung" uri="/anmeldung"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Schade</title>
    </head>
    <body>
        <h1>Schade, dass du nicht kommen kannst!</h1>
        Hier siehst du, wer sich bisher angemeldet hat:
        <table border="1">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>eingetragen am/um </th>
                    <th>zugesagt</th>
                </tr>
            </thead>
            <tbody>
                <anmeldung:liste>
                    <tr>
                        <td><anmeldung:eintrag feld="email"/></td>
                        <td><anmeldung:eintrag feld="zeitpunkt"/></td>
                        <td><anmeldung:eintrag feld="zusage"/></td>
                    </tr>
                </anmeldung:liste>
            </tbody>
        </table>
    </body>
</html>
