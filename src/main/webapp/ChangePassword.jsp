
<html>
    <head>
        <title>SWGW/title>
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
            
            <%
            Object Value3 = session.getAttribute("ChangeFail");
            
            if (Value3 != null)
            {
                String message = (String) Value3;
            
            %>
            <h3><%=message%></h3>
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
                Users User = new Users();
               Object grabUser = session.getAttribute("CurrentUser");
               if(grabUser != null){
                 User = (Users) grabUser;
                 String email = User.getEmail();
                String Username = User.getUserName();
                %>
            
            <form action="FrontController" method="post">
                <h3>HERE IS WHERE YOU CHANGE YOUR PASSWORD</h3>
                
                <input name="name" type="hidden" value="<%=Username%>"/> 

                <input name="email" type="hidden" value="<%=email%>"/>
                
                Old-Password : <input name="oldpass" size=30 type="password" placeholder="Old Password" required/>  
                <br />
                
                New-Password : <input name="newpass" size=30 type="password" placeholder="New Password" required/> 
                <br />
                
                Confirm-Password  : <input name="compass" size=30 type="password" placeholder="Re-enter New Password" required/> 
                <br />
                <input type="submit" value="Change Password" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="change" />
                
            </form>
             </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
    <%
        }
        
        %>
</html>