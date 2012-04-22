<%-- 
    Document   : list
    Created on : 17.04.2012, 13:02:09
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="list">
    <hr/>
    <h2>Currently registered users</h2>
        
    <form action="edit_user" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>User name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${manager.users}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.uname}</td>
                        <td>${u.pwd}</td>
                        <c:if test="${user.admin}">
                            <td>
                                <input type="radio" name="id" value="${u.id}" /> 
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${user.admin}">
            <input type="submit" value="Edit" />
        </c:if>
    </form>

</div>