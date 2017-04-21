 
        function validateForm(){  
            var name=document.login.userName.value;
            var password=document.login.password.value;

            var namelength=document.login.userName.value.length;
            var passwordlength=document.login.password.value.length;



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
            
  
            

            else if(password = null || password == "") {
                document.getElementById("passwordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter a Password";  
                status=false;
            }

            

            else if(passwordlength < 8){  
                document.getElementById("passwordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Password must be greater than 8";  
                status=false; 
            }

            

            
            else{  
                document.getElementById("namelocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                document.getElementById("passwordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                status=true;
            }
            
            return status; 
            
            }


