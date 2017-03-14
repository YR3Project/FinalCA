
<html>
    <head>
        <title>Change Password - Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
       <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
         <div id="wrapper">
             <header>
             <h1>Password Change</h1>
            <%@ include file="Includes/nav.jsp" %>
             </header>
             <article>
            
            <%
            Object Value3 = session.getAttribute("ChangeFail");
            
            if (Value3 != null)
            {
                String message = (String) Value3;
            
            %>
            <p><%=message%></p>
            <%
                }
                session.removeAttribute("ChangeFail");
                session.setAttribute("ChangeFail", "");
                %>
            <%
            Object Value = session.getAttribute("Expired");
            
            if (Value != null)
            {
                String message2 = (String) Value;
            
            %>
            <p><%=message2%></p>
            <%
                }
                session.removeAttribute("Expired");
                session.setAttribute("Expired", "");
                %>
            
            <form action="FrontController" method="post">
                <p>HERE IS WHERE YOU CHANGE YOUR PASSWORD</p>
                <p>
                <span id='name'>UserName :  </span><span id='textbox'><input name="name" size=30 type="text" maxlength="20" placeholder="Username" required/> </span>
                </p>
                <p>
                <span id='name'>oldPassword :</span> <span id='textbox'> <input name="oldpass" size=30 type="password" placeholder="Old Password" required/>  </span>
                </p>
                <p>
                <span id='name'>NewPassword   :</span><span id='textbox'> <input name="newpass" size=30 type="password" placeholder="New Password" required/> </span>
                </p>
                <p>
                <span id='name'>ConfirmPassword  :</span> <span id='textbox'><input name="compass" size=30 type="password" placeholder="Re-enter New Password" required/> </span>
                </p>
                <span id='textbox'> <input type="submit" value="Change Password" /></span>
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="change" />
            </form>
             </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
    
</html>