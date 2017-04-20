
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
      
        <title>SWGW</title>
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
         <header>    
        <h1>Something went wrong</h1>
        <%@ include file="Includes/nav.jsp" %>
         </header>
         <article>
        <%
            
            Object msg = session.getAttribute("errorMessage");
           
            String error = (String) msg;
            
%>

        <h3> <%=error%> </h3>
        <%
          
            session.removeAttribute("errorMessage");
            
%> 

<a href="javascript:history.back()" class="button">Back</a>
<%@ include file="Includes/footer.jsp" %>
         </article>
        </div>
    </body>
</html>
