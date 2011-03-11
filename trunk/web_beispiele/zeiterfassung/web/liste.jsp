<%-- 
    Document   : liste
    Created on : 11.03.2011, 22:59:57
    Author     : Rudolf Radlbauer
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="z" uri="/WEB-INF/tld/zeiterfassung.tld"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Zeiterfassung</title>
    </head>
 
    <body>
        <h1>Zeiterfassung für <z:mitarbeiter feld="name" /></h1>
        Beschäftigungsausmaß: <z:mitarbeiter feld="stunden" /><br/>

        <form action="zeiterfassung" method="POST">
            <input type="submit" value="Kommen" name="kommen" <z:kommen_gehen typ="kommen" /> />
            <input type="submit" value="Gehen" name="gehen" <z:kommen_gehen typ="gehen" /> />
        </form>

        <h2>Zeiten in dieser Woche:</h2>
        <table>

            <z:zeit_iterator>
                <tr>
                    <td><z:zeitstempel feld="kommen" /></td>
                    <td><z:zeitstempel feld="zeit" /></td>
                </tr>
            </z:zeit_iterator>
        </table>

        <h2>Aktueller Zeitsaldo: <z:zeit_saldo /></h2>


    </body>
</html>
