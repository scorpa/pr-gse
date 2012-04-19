<%-- 
    Document   : main
    Created on : 17.04.2012, 12:36:05
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
    </head>
    <body>
        <jsp:include page="welcome.jsp"/>
        
        <c:if test="${user.admin}">
            <jsp:include page="new_user.html"/>
        </c:if>
        
        <jsp:include page="list.jsp" />
    </body>
</html>
