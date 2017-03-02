<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/nav.css" rel="stylesheet" type="text/css"/>
    </head>
    <nav>
        <ul>

           
                <%
                    Object Value2  = session.getAttribute("CurrentUser");

                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="viewProfile.jsp">View your own profile</a></li>
                <li><a href ="Lol-Section.jsp">League Of Legends</a></li>
                <li><a href ="Wow-Section.jsp">World of Warcraft</a></li>
                <li><a href="CommentTest.jsp">test</a></li>
                <li><a href="logout.jsp">Log Out</a></li>
                <%  
                    int a = successUser.getAdmin();
                    if (a!=0) {
                %>
                   <li><a href="viewProfiles.jsp">View other Users</a></li>  
                <%
                    }
                %>
        </ul>
    </nav>
           
        <%
        } else {
        %>
                   <li><a href="index.jsp">Home</a></li>      
 <span id="reglog"><li><a href="LoginForm.jsp">Login</a></li>
<span id="reglog"><li><a href="registration.jsp">Register</a></li>
</ul>
</nav>
<%
    }
%>  
</html>
