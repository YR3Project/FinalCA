<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/nav.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <nav>
        <ul>
            <li><a href="index.jsp"><span class="homenav">Home</span></a></li>
            <li><a href="League.jsp"><span class="leaguenav">League Of Legends</span></a></li>
            <li><a href="WowCharStats.php"><span class="worldnav">World of Warcraft</span></a></li>
            <li><a href="CommentTest.jsp">test</a></li>
           
                <%
                    Object Value2  = session.getAttribute("CurrentUser");
                    Object Value3 = session.getAttribute("commentSuccess");
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                %>
                
                <li><a href="logout.jsp">Log Out</a></li>
                <%  
                    int a = successUser.getAdmin();
                    if (a!=0) {
                %>
                   <li><a href="viewProfiles.jsp">View other Users</a></li>  
                <%
                    }
                %>
      
   
           <p>Logged in as <%=(successUser.getUserName())%></p>
           
            <%
            } else {
            %>
            <span id="reglog"><li><a href="LoginForm.jsp">Login</a></li></span>
            <span id="reglog"><li><a href="registration.jsp">Register</a></li></span>
        </ul>
</nav>
<%
    }
%>  
</html>
