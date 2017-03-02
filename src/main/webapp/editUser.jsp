
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <title>Edit Profile</title>
    </head>
    <body>
        <div id="wrapper">
            <h1>Edit Profile</h1>
        <%@ include file="Includes/nav.jsp" %> 
        <%
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
                %>
        <h1>Edit <%=successUser.getUserName() %>'s Profile</h1>
        <form action="FrontController" method="post">
                
            <span id='name'> Username  :</span> <span id='textbox'><input name="username" value="<%=successUser.getUserName() %>" size=30 type="text" maxlength="20" required/> </span>
                    <br />
            <span id='name'> Email  :</span>  <span id='textbox'><input name="email" size=30 value="<%=successUser.getEmail() %>" type="text" maxlength="30" required/> </span>
            <span id='name'><input type="submit" value="Update" /></span>
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="edit" />
            </form>
        <%
            }
            %>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
