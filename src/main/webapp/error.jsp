
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
      
        <title>Error</title>
    </head>
    <body>
        <div id="wrapper">
        <h1>Something went wrong</h1>
        <%@ include file="Includes/nav.jsp" %> 
        <%
            
            Object msg = session.getAttribute("errorMessage");
           
            String error = (String) msg;
            
%>

        <div> <%=error%> </div>
        <%
          
            session.removeAttribute("errorMessage");
            
%> 

<div><a href="index.jsp" class="button">Back to index</a></div>
<%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
