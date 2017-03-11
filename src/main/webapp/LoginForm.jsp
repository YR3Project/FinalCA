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
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <h1>Login-Form</h1>
            <%@ include file="Includes/nav.jsp" %> 
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
            <p>Form to Login customers (Using servlet)</p>
            <form action="FrontController" method="post">
                <p>
                <span id='name'> Username  :</span> <span id='textbox'>  <input name="username" size=30 type="text" maxlength="30" placeholder="Username" required/> </span>
                </p>
                <p>
                <span id='name'> Password  : </span> <span id='textbox'>  <input name="password" size=20 type="password" placeholder="Password" required/> </span>
                </p>
                <p>
                <span id='name'>  <input type="submit"  value="Login" /></span>
                </p>
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="login" />
                <p>
                <a href='registration.jsp' class="button">Don't Have a Account? Sign-Up</a>
                </p>
            </form>

            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>