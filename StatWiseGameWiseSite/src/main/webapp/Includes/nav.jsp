
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <nav>
        <ul>

            <li><a href="Item_Page_home.jsp">Browse shop</a></li>
                <%
                    Object Value2  = session.getAttribute("CurrentUser");

                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                %>
            <li><a href="viewProfile.jsp">View your own profile</a></li>
            <li><a href="editUser.jsp">Edit your Profile</a></li>
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
                <p>Logged in as <%=(successUser.getUserName())%></p>
        <%
        } else {
        %>
<li><a href="LoginForm.jsp">Login</a></li>
<li><a href="registration.jsp">Register</a></li>
</ul>
</nav>
<%
    }
%>  
</html>
