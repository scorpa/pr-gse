<%-- 
    Document   : index
    Created on : 25.05.2010, 21:41:20
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="quiz" uri="/WEB-INF/tld/quiz"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Frage</title>
    </head>
    <body>
        <quiz:naechste-frage />
        <quiz:ausgabe feld="frage" /><br/>
        <form action="ergebnis">
            <input type="radio" name="antwort" value="0" checked />
            <quiz:ausgabe feld="antwort" index="0" /> <br/>
            <input type="radio" name="antwort" value="1"/>
            <quiz:ausgabe feld="antwort" index="1" /> <br/>
            <input type="radio" name="antwort" value="2"/>
            <quiz:ausgabe feld="antwort" index="2" /> <br/>
            <input type="radio" name="antwort" value="3"/>
            <quiz:ausgabe feld="antwort" index="3" /> <br/>
            <input type="submit" value="weiter" />
        </form>
        
    </body>
</html>
