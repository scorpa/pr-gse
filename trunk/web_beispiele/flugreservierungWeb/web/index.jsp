<%-- 
    Document   : index
    Created on : 18.03.2010, 14:10:57
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="flugreservierung" uri="/WEB-INF/tld/flugreservierung"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flugreservierung</title>
    </head>
    <body>
        <form action="reservieren">
            <table border="1">
                <thead>
                    <tr>
                        <th>Flugnummer</th>
                        <th>von</th>
                        <th>nach</th>
                        <th>Abflug</th>
                        <th>Ankunft</th>
                        <th>Auswahl</th>
                    </tr>
                </thead>
                <tbody>

                    <flugreservierung:flug-iterator>
                        <tr>
                            <td><flugreservierung:flug-ausgabe feld="nummer"/></td>
                            <td><flugreservierung:flug-ausgabe feld="von"/></td>
                            <td><flugreservierung:flug-ausgabe feld="nach"/></td>
                            <td><flugreservierung:flug-ausgabe feld="abflug"/></td>
                            <td><flugreservierung:flug-ausgabe feld="ankunft"/></td>
                            <td>
                                <input type="radio" name="auswahl"
                                       value="<flugreservierung:flug-ausgabe feld="nummer"/>" />
                            </td>
                        </tr>
                    </flugreservierung:flug-iterator>
                </tbody>
            </table>
            Name: 
            <input type="text" name="name" value="" size="50" />
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
