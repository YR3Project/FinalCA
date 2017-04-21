 
        function validateForm(){  
            var name=document.reg.userName.value;

            var namelength=document.reg.userName.value.length;

            var useremail=document.reg.email.value;
            var mailformat=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

            var status=false;  
            
            if(name = null || name == "") {
                document.getElementById("namelocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter your name";  
                status=false;
            }

            
            
            else if(namelength < 3){  
                document.getElementById("namelocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> UserName must be greater than 3";  
                status=false; 
            }

            
            else if(!(useremail.match(mailformat))){  
                document.getElementById("emaillocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Email does not match the requirements";  
                status=false; 
            }
            
            else{  
                document.getElementById("namelocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";

                document.getElementById("emaillocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                status=true;
            }
            
            return status; 
            
            }
            
            /*
             * 
 Example of valid email id

mysite@ourearth.com
my.ownsite@ourearth.org
mysite@you.me.net

Example of invalid email id

mysite.ourearth.com [@ is not present] 
mysite@.com.my [ tld (Top Level domain) can not start with dot "." ]
@you.me.net [ No character before @ ]
mysite123@gmail.b [ ".b" is not a valid tld ]
mysite@.org.org [ tld can not start with dot "." ]
.mysite@mysite.org [ an email should not be start with "." ]
mysite()*@gmail.com [ here the regular expression only allows character, digit, underscore, and dash ]
mysite..1234@yahoo.com [double dots are not allowed]
             */


