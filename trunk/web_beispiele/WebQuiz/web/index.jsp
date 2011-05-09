<%-- 
    Document   : index
    Created on : 03.05.2011, 21:18:10
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="q" uri="/WEB-INF/quiz.tld"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
    </head>
    <body>
        <form action="antwort">
            <q:frage feld="text" /><br/>
            <input type="radio" name="antwort" value="0" checked="checked" />
            <q:frage feld="antwort" index="0"/><br/>
            <input type="radio" name="antwort" value="1" />
            <q:frage feld="antwort" index="1"/><br/>
            <input type="radio" name="antwort" value="2" />
            <q:frage feld="antwort" index="2"/><br/>
            <input type="submit" value="OK" />
        </form>
            <p><q:status/></p>
    </body>
</html>
