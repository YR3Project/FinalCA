<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Common.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/nav.css" rel="stylesheet" type="text/css"/>
        <link
    </head>
    <nav>
        <div  id="navcontainer">
        <ul id="navlist">

           
                <%
                    Object Value2  = session.getAttribute("CurrentUser");

                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                %>
                <li id="active"><a href="index.jsp" id="current">Home</a></li>
                <li><a href="viewProfile.jsp">View your own profile</a></li>
                <li><a href ="">Twitch-Area</a>
                 <ul>
                       <li><a href ="Lol-Section.jsp">League Of Legends</a>
                       <li><a href ="Wow-Section.jsp">World of Warcraft</a></li>
                        </ul>
                 </li>   
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
        </div>
    </nav>
           
        <%
        } else {
        %>
 <li><a href="index.jsp">Home</a></li>      
<li><a href="LoginForm.jsp">Login</a></li>
<li><a href="registration.jsp">Register</a></li>
</ul>
</nav>
<%
    }
%>  
</html>
