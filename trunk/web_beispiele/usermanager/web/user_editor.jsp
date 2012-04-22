<%-- 
    Document   : edit_user
    Created on : 17.04.2012, 14:01:43
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<hr/>
<div id="user_editor">
    <form action="save_user" method="POST">
        <table border="0">
            <tbody>
            	<c:if test="${edit.id > 0}">
            		<td>ID</td>
            		<td>${edit.id}</td>
            	</c:if>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="${edit.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td>
                        <input type="text" name="uname" value="${edit.uname}"/>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="pwd"/>
                    </td>
                </tr>
                <tr>
                    <td>Password (re-type)</td>
                    <td>
                        <input type="password" name="pwd2"/>
                    </td>
                </tr>
                <tr>
                    <td>Admin user</td>
                    <td>
                        <input type="checkbox" name="admin" value="admin" <c:if test="${edit.admin}">checked="checked"</c:if>/>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Save" />

    </form>
</div>
