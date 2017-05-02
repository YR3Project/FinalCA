<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Users"%>
<%@page import="Daos.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
      
        <title>SWGW</title>
    </head>

     
    <body>
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
        <%
            Object Value = session.getAttribute("Complexity");
            
            if (Value != null)
            {
                String SecurityMeassage = (String) Value;
            
            %>
            <p>
                The following problem seems to have happened during your attempt to change :  <%=(SecurityMeassage)%>.
            </p>
            <form action="FrontController" method="post">
                <table>
                    <tr>
                        <td> UserName : </td><td> <input name="name" size=30 type="text" maxlength="20" placeholder="UserName" required/> </td> 
                    </tr>
                    <tr>
                        <td> oldPassword : </td><td> <input name="oldpass" size=30 type="password" placeholder="Old Password" required/> </td> 
                    </tr>
                    <tr>
                        <td> NewPassword  : </td><td> <input name="newpass" size=30 type="password" placeholder="New Password" required/> </td> 
                    </tr>
                    <tr>
                        <td> ConfirmPassword  : </td><td> <input name="compass" size=30 type="password" placeholder="Re-Enter New Password" required/> </td> 
                    </tr>
                </table>
                <input type="submit" value="Change Password" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="change" />
            </form>
            <%
              }  
            %>
        </table>
        
        <%
           
            session.removeAttribute("Complexity");
         %>
         
         </div>
         
    </body>
    <%@ include file="Includes/footer.jsp" %>
</html>
