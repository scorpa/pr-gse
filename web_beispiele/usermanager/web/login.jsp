<%-- 
    Document   : login
    Created on : 17.04.2012, 12:28:14
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="error">
            ${error}
        </div>
        
        <div id="login">
            <form action="login" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td>
                                <input type="text" name="user"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <input type="password" name="pwd" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Login"/>
            </form>
            
        </div>
    </body>
</html>
