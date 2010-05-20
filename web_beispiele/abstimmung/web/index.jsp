<%-- 
    Document   : index
    Created on : 15.05.2010, 23:58:16
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="abstimmung" uri="/WEB-INF/tld/abstimmung"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Willkommen bei der Abstimmung des Tages</title>
    </head>
    <body>
        <h1>Willkommen bei der Abstimmung des Tages</h1>
        Bisher haben bei der Abstimmung des Tages <abstimmung:statistik typ="prozent"/>
        % zugestimmt.

        <form action="Abstimmen">
            Stimmen Sie mit:<br/>
            <input type="radio" name="zustimmung" value="ja" checked="checked" />ja<br/>
            <input type="radio" name="zustimmung" value="nein" /> nein<br/>
            <input type="submit" value="Abstimmen" />
        </form>
    </body>
</html>
