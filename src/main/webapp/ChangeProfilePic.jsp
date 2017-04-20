<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<!DOCTYPE html>
<html>
<head>

<title>SWGW</title>
<meta charset="UTF-8">
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
</head>

     <%@ include file="Includes/Slideshow.php" %>
<body>
     <div id="wrapper">
         <header>
        <h1>Upload Profile Picture</h1>
        <%@include file="Includes/nav.jsp" %>
         </header>
         <article>
        <div class="mainscreen">
            <%
            Object user = session.getAttribute("CurrentUser");
            int neededid;
            if (user != null) 
                {
                Users successUser = (Users) user;
                neededid = successUser.getUserID();
            %>
            <p>Profile Picture Upload</p>
            <div class="Pic-Form">
            <form action="FrontController" method="post" enctype="multipart/form-data">
                
                <td>Portrait Photo: <input type="file" name="file" size="50"/>
                <input type='hidden'  name='id' value='<%=neededid%>'/>   

                <input type="submit" value="Change Picture" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name="action" value="ProPic" />
            </form>
            </div>
            <%
                }
                %>
        </div>
         </article>
        <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
