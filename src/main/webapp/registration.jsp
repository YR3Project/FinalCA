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
        <title>Registration - Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
        
        <div id="wrapper">
            <header>
            <%@include file="Includes/nav.jsp" %>
            <h1>Registration</h1>
            </header>
            <article>
               
        
       
            
            <form name="reg" action="FrontController" method="post" onsubmit="return validateForm()">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" id="txtUsername" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>  
                
                
                Password  : <input name="password" id="txtPassword" size=30 type="password" placeholder="Password" /><span id="passwordlocation" style="color:red"></span><br>
                Re-Enter Password: <input name="password2" id="txtConfirmPassword" size=30 type="password" placeholder="Re-Enter Password" /><span id="passwordlocation2" style="color:red"></span><br>
                
                
               
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" /> </span>
                
                
                
                <input type="submit" id="btnSubmit" value="Register" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
<script type="text/javascript">  
function validateForm(){  
var name=document.reg.userName.value;
var password=document.reg.password.value;
var confirmPassword=document.reg.password2.value;
var passwordlength=document.reg.password.value.length;  
var status=false;  
if(name = null || name == "") {
document.getElementById("namelocation").innerHTML=  
" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter your name";  
status=false;
}

else{  
document.getElementById("namelocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";  
status=true;
}  
  
if(passwordlength<8){  
document.getElementById("passwordlocation").innerHTML=  
" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Password must be greater than 6";  
status=false; 
}
else{  
document.getElementById("passwordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";  
}

if (password != confirmPassword) {
document.getElementById("passwordlocation2").innerHTML=  
" <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Passwords must match each other";  
status=false;     
 }
 
else{  
document.getElementById("passwordlocation2").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";  
}  
  
return status;  
}  
</script>  
<!--                
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#btnSubmit").click(function () {
            var Name = $("#txtUsername").val();
            var password = $("#txtPassword").val();
            var passwordlength = $("#txtPassword").val().length;
            var confirmPassword = $("#txtConfirmPassword").val();
            if(Name = null || Name == "") {
               alert("Please enter a UserName.");
                return false; 
            }
            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            if(passwordlength < 8) {
               alert("Passwords must be longer than 8 letters.");
               return false; 
            }
            
            
            return true;
        });
    });
</script>
-->
            </article>
        <%@ include file="Includes/footer.jsp" %>
            </div>

        
            
        
    </body>
</html>

