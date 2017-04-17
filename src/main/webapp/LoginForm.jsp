<%--
    Document   : LoginForm
    Created on : Jan 29, 2017, 12:02:38 PM
    Author     : ben
--%>
<html>
    <head>
        <title>Login - Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <script src="Includes/CommonValidation.js"></script>
        <div id="wrapper">
            <header>
            <h1>Login-Form</h1>
            <%@ include file="Includes/nav.jsp" %>
            </header>
        <article>
            <%
            Object Value = session.getAttribute("ChangeSuccess");
            
            if (Value != null)
            {
                String message = (String) Value;
            
            %>
            <p><%=message%></p>
            <%
                }
                session.removeAttribute("ChangeSuccess");
                session.setAttribute("ChangeSuccess", "");
                %>
            
            <form action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>WELCOME BACK TO THE PARTY</h3>
                <!--"[A-Za-z0-9_]{1,15}$"-->
                Username  :<input name="userName" size=30 type="text" maxlength="30" placeholder="Username"/> 
                
                
                Password  : <input name="password" size=20 type="password" placeholder="Password"/> 
                
                
                <input type="submit"  value="Login" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="login" />
                <br />
                <a href='registration.jsp' >Don't Have a Account? Sign-Up</a>
                <a href="ForgotPassword.jsp"> Forgot Password</a>
                
            </form>
        </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>