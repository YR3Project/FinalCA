<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Users"%>
<%@page import="Daos.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!--
Author Aleks,Ben
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
       
        <title>SWGW</title>
    </head>

     
    <body>
        <br />
        <br />
        <br />
        <br />
        <br />
        <div id="wrapper">
        <header>
   
        <h1>Successful registered in User</h1>
        <%@ include file="Includes/nav.jsp" %>
        </header>
        <%
            Object Value = session.getAttribute("RegSuccess");
            
            if (Value != null)
            {
                Users successRegUser = (Users) Value;
            
            %>
            
            <p>
                Congratulations on successful Registering into are service <%=(successRegUser.getUserName())%>.
            </p>
          <div style="overflow-x:auto;"> 
          <table id="userTable">
            <tr>
                <th>UserName</th>
                <th></th>
                <th>Email</th>
            </tr>
            <tr>
                <td><%=successRegUser.getUserName()%></td>
                <td></td>
                <td><%=successRegUser.getEmail()%></td>

            </tr>
            <%
              }  
            %>
        </table>
        </div>
        
        <%
           
            session.removeAttribute("RegSuccess");
         %>
         <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
