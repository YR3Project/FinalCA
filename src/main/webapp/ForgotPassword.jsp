
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SWGW</title>
    <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
       <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
         <div id="wrapper">
             <header>
             <h1>Password Change</h1>
            <%@ include file="Includes/nav.jsp" %>
             </header>
             <article>
            

            <form action="FrontController" method="post">
                <h3>Are You Sure</h3>
                
                Username  :<input name="userName" size=30 type="text" maxlength="30" placeholder="Username"/>

  
                
                <input type="submit" value="Continue" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="forgot" />
            </form>
             </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>

</html>

