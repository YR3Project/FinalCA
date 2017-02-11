<%-- 
    Document   : CommentTest
    Created on : 11-Feb-2017, 14:14:42
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="FrontController" method="Post">
            Comment: <input type="text" name="comment">
            
            userID: <input type="text" name="userID">
            Article <input type="text" name="article">
            Date <input type="text" name="date">
            commentID <input type="text" name="commentID">
            <input type="submit" value="Comment" />
            <!-- Include a hidden field to identify what the user wants to do -->
            <input type="hidden" name ="action" value="comment" />
            
            
            
        </form>
    </body>
</html>
