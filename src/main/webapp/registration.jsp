<%-- 
    Document   : registration
    Created on : 11-Dec-2016, 15:17:45
    Author     : ben

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SWGW</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="CSS/easy-autocomplete.min.css">
    </head>
   
     <%@ include file="Includes/Carousel.html" %> 
    <body>
        <script src="Includes/CommonValidation.js"></script>
        
        
        <div id="wrapper">
            <header>
            <%@include file="Includes/nav.jsp" %>
            <h1>Registration</h1>
            </header>
            <article>
            <script src="Includes/jquery.easy-autocomplete.min.js"></script>     
            <form name="reg" action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>
                
                Country : <input id="provider-json"  name="country" placeholder="Country"/><br>
                <script src="Includes/autocomplete.js"></script>
                
                Password  : <input name="password"  size=30 type="password" placeholder="Password" /><span id="passwordlocation" style="color:red"></span><br>
                Re-Enter Password: <input name="password2"  size=30 type="password" placeholder="Re-Enter Password" /><span id="passwordlocation2" style="color:red"></span><br>
                
                
               <!--[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$-->
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><span id="emaillocation" style="color:red"></span><br>
                
                
                <input type="submit" id="btnSubmit" value="Register" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
             
 
            

            

            </article>
        <%@ include file="Includes/footer.jsp" %>
            </div>

        
            
        
    </body>
</html>

