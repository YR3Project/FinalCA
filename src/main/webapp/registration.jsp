<%-- 
    Document   : registration
    Created on : 11-Dec-2016, 15:17:45
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration - Form</title>
        <meta charset="UTF-8">
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
            <header>
            <%@include file="Includes/nav.jsp" %>
            <h1>Registration</h1>
            </header>
            <article>
               
        
       
            
            <form action="FrontController" method="post">
                <p>SIGN-UP NOW</p>
                <p>
                Username  :  <input name="userName" size=30 type="text" maxlength="20" placeholder="Username" required/>  
                </p>
                <p>
                Password  : <input name="password" size=30 type="password" placeholder="Password" required/> 
                </p>
                
                <p>
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required/> </span>
                </p>
                
                
                <input type="submit" formtarget="_blank" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
            </article>
        <%@ include file="Includes/footer.jsp" %>
            </div>

        
            
        
    </body>
</html>

