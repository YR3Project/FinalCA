 
        function validateForm(){  
            var name=document.forgotname.userName.value;

            var namelength=document.forgotname.userName.value.length;



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

            
            else{  
                document.getElementById("namelocation").innerHTML=" <img src='http://www.javatpoint.com/javascriptpages/images/checked.gif'/>";

                status=true;
            }
            
            return status; 
            
            }

