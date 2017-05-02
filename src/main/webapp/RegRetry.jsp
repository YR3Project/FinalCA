<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Users"%>
<%@page import="Daos.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!-- 
Authors Aleks, Ben
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <title>SWGW</title>
    </head>

     
    <body>
        <script src="Includes/CommonValidation.js"></script>
    <div id="wrapper"> 
        <header>
                 <br />
                 <br />
                 <br />
                 <br />
                 <br />
        <h1>Try-Again</h1>
       <%@ include file="Includes/nav.jsp" %>
        </header>
   
        <article>
        <%
            Object Value = session.getAttribute("Complexity");
            
            if (Value != null)
            {
                String SecurityMeassage = (String) Value;
            
            %>
            
            
            <form name="reg" action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" id="txtUsername" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>  
                
                
                Password  : <input name="password" id="txtPassword" size=30 type="password" placeholder="Password" /><span id="passwordlocation" style="color:red"></span><br>
                Re-Enter Password: <input name="password2" id="txtConfirmPassword" size=30 type="password" placeholder="Re-Enter Password" /><span id="passwordlocation2" style="color:red"></span><br>
                
                
               <!--[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$-->
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><span id="emaillocation" style="color:red"></span><br>
                
                
                
                <input type="submit" id="btnSubmit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
            
            
            <%
              }  
            %>

        
        <%
           
            session.removeAttribute("Complexity");
         %>
        </article>
         <%@ include file="Includes/footer.jsp" %>
    </div> 
    </body>
</html>
