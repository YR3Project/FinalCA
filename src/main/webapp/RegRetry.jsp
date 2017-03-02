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
    <body>
    <div id="wrapper"> 
        <a href="registration.html">Back to Form</a>
        <a href="index.jsp">Back to index</a>
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
                Username  : <span><input name="userName" size=30 type="text" maxlength="20" placeholder="Username" required/> </span>
                Password  :  <span><input name="password" size=30 type="password" placeholder="Password" required/> </span>
                Email  : <span> <input name="email" size=30 type="text" maxlength="30" placeholder="Email" required/>  </span>
                  
                <input type="submit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
            </form>
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
