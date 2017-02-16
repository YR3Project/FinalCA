<%-- 
    Document   : riotapitest
    Created on : 16-Feb-2017, 10:12:35
    Author     : d00165195
--%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
                    Object Value2 = session.getAttribute("sumName");
                    RiotApiDao sumName = (RiotApiDao) Value2;
                        

                %>
                <%=sumName.summonerName("chips97")%>
                        
                       
    </body>
</html>
