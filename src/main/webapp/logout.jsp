<%-- 
    Document   : logout
    Author     : Ben Rose
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            <title>Log out</title>
            <script>
                window.location = "Carousel.jsp";
            </script>
    </head>

     <%@ include file="Includes/Carsoul.html" %> 
    <body>
        <%
            Object Value = session.getAttribute("CurrentUser");
            
            if (Value != null)
            {
                session.removeAttribute("CurrentUser");
                %>
                <h1>You have successfully logged out</h1>
                <%
                    
            }else{
            %>
        <h1>You need to be logged in to log out</h1>
        <p><a href="loginform.jsp">Login</a></p>
        <%
            }
            %>
    </body>
</html>
