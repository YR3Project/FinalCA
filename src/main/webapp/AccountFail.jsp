<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Users"%>
<%@page import="Daos.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>

<!DOCTYPE html>
<!--Author Ben -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <title>Account Failure</title>
    </head>
    <body>
        <%@ include file="Includes/nav.jsp" %>
        <div id="wrapper">
       <a href="javascript:history.back()" class="button">Back to Form</a>
         <a href='index.jsp' class="button">Back to index</a>
        <h1>Failed to Register User</h1>
        <%
             Object Value = session.getAttribute("AccountFail");
             Object Type = session.getAttribute("Type");
             if(Value != null && Type != null)
             {
                  String User = (String) Value;
                  String type = (String) Type;
            %>
            <p>
                A problem has appeared with <%=type%> For User: <%=User%>
                please check if all your values are added in correctly.
            </p>
            <%
                }
                %>
                <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>

