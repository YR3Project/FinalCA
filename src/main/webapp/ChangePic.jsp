<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<!DOCTYPE html>
<html>
<head>

<title>Upload Profile Picture</title>
<meta charset="UTF-8">
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
<body>
     <div id="wrapper">
        <h1>Upload Profile Picture</h1>
        <%@include file="Includes/nav.jsp" %>
        <div class="mainscreen">
            <%
            Object user = session.getAttribute("CurrentUser");
            int neededid;
            if (user != null) 
                {
                Users successUser = (Users) user;
                neededid = successUser.getUserID();
            %>
            <p>Form to Register customers (Using servlet)</p>
            <div class="Pic-Form">
            <form action="uploadServlet" method="post" enctype="multipart/form-data">
                
                <td>Portrait Photo: <input type="file" name="photo" size="50"/>
                <input type='hidden'  name='id' value='<%=neededid%>'/>   

                <input type="submit" value="Change Picture" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="ChangePic" />
            </form>
            </div>
            <%
                }
                %>
        </div>
        <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
