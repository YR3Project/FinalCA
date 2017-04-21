
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>SWGW</title>
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <script src="Includes/EditValidation.js"></script>
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
       
        <form action="FrontController" method="post" onsubmit="return validateForm();">
          <h3>READY TO EDIT YOUR PROFILE <%=successUser.getUserName() %></h3>
                
                Username  :  <input name="userName" id="txtUsername" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>  
                
               <!--[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$-->
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><span id="emaillocation" style="color:red"></span><br>
                
                
                
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
