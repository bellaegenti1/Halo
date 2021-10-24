<%-- 
    Document   : register
    Created on : 24-Oct-2021, 12:20:48 PM
    Author     : itsd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            <label>Username: </label>
            <input type="text" name="username" value="${userName}">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
            
            <c:if test="${nameIsNull}">
                <p style="color: red" >Please enter a username.</p>
            </c:if>
                
        </form>
        
    </body>
</html>
