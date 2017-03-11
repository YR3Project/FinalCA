<%-- 
    Document   : registration
    Created on : 11-Dec-2016, 15:17:45
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration - Form</title>
        <meta charset="UTF-8">
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="wrapper">
            <h1>Registration</h1>
        <%@include file="Includes/nav.jsp" %>
        <div class="mainscreen">
            <p>Form to Register customers (Using servlet)</p>
            <div class="login_form">
            <form action="FrontController" method="post">
                Username  :  <input name="userName" size=30 type="text" />  
                <br />
                <p id="pass">
                Password  : <input name="password" size=30 type="password" /> 
                </p>
                
                <p id="email">
                    Email  : <span><input name="email" size=30 type="email" /> </span>
                </p>
                
                
                <input type="submit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
            </form>
            </div>
        </div>
        <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
