
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>Edit Profile</title>
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
            <header>
            <h1>Edit Profile</h1>
        <%@ include file="Includes/nav.jsp" %>
            </header>
            <article>
        <%
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
                %>
       
        <form action="FrontController" method="post">
                 <h3>READY TO EDIT YOUR PROFILE <%=successUser.getUserName() %></h3>
            Username  :<input name="username" value="<%=successUser.getUserName() %>" size=30 type="text" maxlength="20" required/> </span>
                    <br />
            Email  :</span>  <span id='textbox'><input name="email" size=30 value="<%=successUser.getEmail() %>" type="text" maxlength="30" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
            <input type="submit" value="Update" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="edit" />
            </form>
        <%
            }
            %>
            </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
