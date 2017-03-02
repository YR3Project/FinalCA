
<html>
    <head>
        <title>Change Password - Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
       <link href="css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div id="wrapper"> 
             <h1>Password Change</h1>
            <%@ include file="Includes/nav.jsp" %> 
            
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
            <p>Change Details(Using servlet)</p>
            <form action="FrontController" method="post">
                <span id='name'>UserName :  </span><span id='textbox'><input name="name" size=30 type="text" maxlength="20" placeholder="Username" required/> </span>
                 <br />
                <span id='name'>oldPassword :</span> <span id='textbox'> <input name="oldpass" size=30 type="password" placeholder="Old Password" required/>  </span>
                <br />
                <span id='name'>NewPassword   :</span><span id='textbox'> <input name="newpass" size=30 type="password" placeholder="New Password" required/> </span>
                <br />
                <span id='name'>ConfirmPassword  :</span> <span id='textbox'><input name="compass" size=30 type="password" placeholder="Re-enter New Password" required/> </span>
                  
                <span id='textbox'> <input type="submit" value="Change Password" /></span>
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="change" />
            </form>
            
        </div>
    </body>
    <%@ include file="Includes/footer.jsp" %>
</html>