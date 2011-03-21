<%-- 
    Document   : login
    Created on : 11.03.2011, 22:37:58
    Author     : Rudolf Radlbauer

    Login-Seite
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="z" uri="/WEB-INF/tld/zeiterfassung.tld" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Anmeldung</title>
    </head>
    <body>
        <!-- falls beim letzen Login-Versuch ein Fehler aufgetreten ist -->
        <p><z:error/></p>
      <form action="login" method="POST">
          Mitarbeiternummer
          <input type="text" name="nr" value="" size="5" /><br/>
          Kennwort
          <input type="password" name="pwd" value="" size="16" /><br/>
          <input type="submit" value="Anmelden" />
      </form>
    </body>
</html>
