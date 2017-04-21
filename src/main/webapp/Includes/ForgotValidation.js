 
        function validateForm(){  

            var newpassword=document.forg.newpass.value;
            var confirmPassword=document.forg.compass.value;

            var newpasswordlength=document.forg.newpass.value.length;
            var confirmlength=document.forg.compass.value.length;
         

            var status=false;  
            
            
            
            
            if(newpassword = null || newpassword == ""){ 
                 document.getElementById("newpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter a New Password";  
                status=false;
            }

            

            else if(confirmPassword = null || confirmPassword == "") {
                document.getElementById("confirmpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please re-enter the New Password";  
                status=false;
            }

        
            else if(newpasswordlength < 8){
                document.getElementById("newpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> new Password must be greater than 8";  
                status=false;  
            }
            
            else if(confirmlength < 8){  
                document.getElementById("confirmpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Confirm New Password must be greater than 8";  
                status=false; 
            }
            
            else if (newpassword !== confirmPassword) {
                document.getElementById("confirmpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> New Password must not match New Old Password";  
                status=false;     
             }
             
  
            else{  

                document.getElementById("newpasswordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                document.getElementById("confirmpasswordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";                
                status=true;
            }
            
            return status; 
            
            }
            


