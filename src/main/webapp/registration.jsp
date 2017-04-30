<%-- 
    Document   : registration
    Created on : 11-Dec-2016, 15:17:45
    Author     : ben
http://www.javatpoint.com/oprweb/test.jsp?filename=jsvalidation2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SWGW</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            
    </head>
    
     <%@ include file="Includes/Carousel.html" %> 
    <body>
        <script src="Includes/CommonValidation.js"></script>
        <div id="wrapper">
            <header>
            <%@include file="Includes/nav.jsp" %>
            <h1>Registration</h1>
            </header>
            <article>

            
            <form name="reg" action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>  
                
                
                Password  : <input name="password"  size=30 type="password" placeholder="Password" /><span id="passwordlocation" style="color:red"></span><br>
                Re-Enter Password: <input name="password2"  size=30 type="password" placeholder="Re-Enter Password" /><span id="passwordlocation2" style="color:red"></span><br>
                
                
               <!--[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$-->
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><span id="emaillocation" style="color:red"></span><br>
                
                
                <input type="submit" id="btnSubmit" value="Register" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
                

            
<!--
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
function validateForm(){  
        $('reg').submit(function(){
            var Name = $("#txtUsername").val();
            var password = $("#txtPassword").val();
            var passwordlength = $("#txtPassword").val().length;
            var confirmPassword = $("#txtConfirmPassword").val();
            if(Name = null || Name == "") {
               /*$("#namelocation").html(" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter your name");
                return false;*/
            alert("testing name");
            }
            else{
               $("#namelocation").html(" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>");
               
            }
            if(passwordlength < 8) {
               /*$("#namelocation").html(" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter your name");
                return false;*/
            alert("testing name"); 
            }
            else{
               $("#passwordlocation").html(" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>");
               
            }
            
            if (password != confirmPassword) {
                /*$("#namelocation").html(" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter your name");
                return false;*/
            alert("testing name");
            }
            else{
               $("#passwordlocation2").html(" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>");
               
            }

            
            
            
        });
    };
</script>                
              
 -->    

            </article>
        <%@ include file="Includes/footer.jsp" %>
            </div>

        
            
        
    </body>
</html>

