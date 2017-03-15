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
        <title>Try-Again</title>
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
    <div id="wrapper"> 
        <header>
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
            
            
            <form action="FrontController" method="post">
                <h3>
                The following problem seems to have happened during your registration :  <%=(SecurityMeassage)%>.
                </h3>
                Username  : 
                <br />
                <input name="userName" size=30 type="text" maxlength="20" placeholder="Username" required/>
                
                Password  :  
                <br />
                <input name="password" size=30 type="password" placeholder="Password" required/>
                
                Email  : 
                <br />
                <input name="email" size=30 type="text" maxlength="30" placeholder="Email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
                <input type="submit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                 <a href="registration.jsp" class="button">Back to Form</a>
                 <a href="index.jsp" class="button">Back to index</a>
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
