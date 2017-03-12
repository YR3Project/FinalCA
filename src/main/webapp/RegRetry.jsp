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
        
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <title>Try-Again</title>
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
    <div id="wrapper"> 
        
        <h1>Try-Again</h1>
       <%@ include file="Includes/nav.jsp" %> 
        <%
            Object Value = session.getAttribute("Complexity");
            
            if (Value != null)
            {
                String SecurityMeassage = (String) Value;
            
            %>
            
            <p>
                The following problem seems to have happened during your registration :  <%=(SecurityMeassage)%>.
            </p>
            <form action="FrontController" method="post">
                <p>
                <span id='name'> Username  : <span><input name="userName" size=30 type="text" maxlength="20" placeholder="Username" required/> </span></span>
                </p>
                <p>
                <span id='name'> Password  :  <span><input name="password" size=30 type="password" placeholder="Password" required/> </span></span>
                </p>
                <p>
                <span id='name'> Email  : <span> <input name="email" size=30 type="text" maxlength="30" placeholder="Email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>  </span></span>
                </p> 
                <input type="submit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
            </form>
            <br>
            <a href="registration.jsp" class="button">Back to Form</a>

            <a href="index.jsp" class="button">Back to index</a>
            <%
              }  
            %>

        
        <%
           
            session.removeAttribute("Complexity");
         %>
         <%@ include file="Includes/footer.jsp" %>
    </div> 
    </body>
</html>
