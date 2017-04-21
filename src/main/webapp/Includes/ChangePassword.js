 
        function validateForm(){  
            var oldpassword=document.changepass.oldpass.value;
            var newpassword=document.changepass.newpass.value;
            var confirmPassword=document.changepass.compass.value;
            var oldpasswordlength=document.changepass.oldpass.value.length;
            var newpasswordlength=document.changepass.newpass.value.length;
            var confirmlength=document.changepass.compass.value.length;
         

            var status=false;  
            
            
            
            if(oldpassword = null || oldpassword == "") {
                document.getElementById("oldpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter a Password";  
                status=false;
            }
            
            else if(newpassword = null || newpassword == ""){ 
                 document.getElementById("newpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please enter a New Password";  
                status=false;
            }

            

            else if(confirmPassword = null || confirmPassword == "") {
                document.getElementById("confirmpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Please re-enter the New Password";  
                status=false;
            }

             

            else if(oldpasswordlength < 8){  
                document.getElementById("oldpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> Password must be greater than 8";  
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
             
             else if (oldpassword.equals(newpassword)){
                document.getElementById("newpasswordlocation").innerHTML=  
                " <img src='http://www.javatpoint.com/javascriptpages/images/unchecked.gif'/> New Password must not match Old Password";  
                status=false;     
             }

           
            

            
      
            else{  
                document.getElementById("oldpasswordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                document.getElementById("newpasswordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";
                document.getElementById("confirmpasswordlocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";                
                status=true;
            }
            
            return status; 
            
            }
            


