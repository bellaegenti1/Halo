<%-- 
    Document   : shoppinglist
    Created on : 24-Oct-2021, 12:21:27 PM
    Author     : itsd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p> Hello ${userName}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        <form action="" method="post">
            
            <label>Add item: </label>
            <input type="text" name="item" value=""><input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="" method="post">
            
            <ul>
                <c:forEach items="${items}" var="value">
<!--                 <li><c:out value="${value}"/></li>-->
                 <input type="radio" id="" name="itemList" value="${value}">
                 <label for="${value}">${value}</label><br>
                </c:forEach>
            </ul>

                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">  
        </form>
        
    </body>
</html>