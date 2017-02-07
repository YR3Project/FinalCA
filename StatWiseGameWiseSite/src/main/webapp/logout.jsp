<%-- 
    Document   : logout
    Author     : Aleksander Matraszek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
            <title>Log out</title>
            <script>
                window.location = "index.jsp";
            </script>
    </head>
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
