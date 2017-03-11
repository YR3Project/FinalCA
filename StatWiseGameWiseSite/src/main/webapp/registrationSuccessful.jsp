<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Users"%>
<%@page import="Daos.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!--
Author Aleks
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
       
        <title>Successful registered Customer</title>
    </head>
    <body>
        <div id="wrapper">
        <h1>Successful registered in User</h1>
        <%@ include file="Includes/nav.jsp" %> 
        <%
            Object Value = session.getAttribute("RegSuccess");
            
            if (Value != null)
            {
                Users successRegUser = (Users) Value;
            
            %>
            <p>
                Congratulations on successful Registering into are service <%=(successRegUser.getUserName())%>.
            </p>
            
          <table>
            <tr>
                <th>UserName</th>
                <th>Email</th>
            </tr>
            <tr>
                <td><%=successRegUser.getUserName()%></td>
                <td><%=successRegUser.getEmail()%></td>

            </tr>
            <%
              }  
            %>
        </table>
        
        <%
           
            session.removeAttribute("RegSuccess");
         %>
         <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>