
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        </head> 
        <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
     <body>
         <div id="wrapper">
             <header> 
                 <h1>Your Profile:</h1>
        <%@ include file="Includes/nav.jsp" %>
             </header>
             <article>
                 <section>
        <%
            Object Value3 = session.getAttribute("EditSuccess");
            
            if (Value3 != null)
            {
                String message = (String) Value3;
                %>
                <br/><h3><% out.println(message); %></h3>
                
                <%
            }
            Object Value4 = session.getAttribute("CurrentUser");
                int isAdmin;
            if (Value4 != null) {
                Users successUser = (Users) Value4;
                isAdmin = successUser.getAdmin();
        %>
        <title>Profile</title>
   
        
        <img src="getImageDetails.jsp?your_id=<%=successUser.getUserID()%>" width="120" height="100" />
        
           
            <a href='ChangePic.jsp' class="button">Change profile Picture</a>
            
             
             
        <h3><%=successUser.getUserName()%>'s Profile</h3>
        
           
        
            <div style="overflow-x:auto;">
        <table>
            <tr><%
                    if(isAdmin!=0){
                    %>
                    
                    <th>ID</th>
                
                    <%
                    }
                    %>
                    <th>UserName</th>
                    <th>Email</th>
            </tr>
            <tr>
                <%
                    if(isAdmin!=0){
                    %>
            
                <td><%=successUser.getUserID()%></td>
            <br>
                    <%
                    }
                    %>
                <td><%=successUser.getUserName()%></td>
                <br>
                <td><%=successUser.getEmail()%></td>

            </tr>
        </table>
                </div>
                            <%
                    if(isAdmin!=0){
                    %>
                    <h3><%=successUser.getUserName()%> is an administrator on this site.</h3>
                    <!--placeholder-->
                    <p>
                        <!--for spacing-->
                    </p>
                    
                <%
                    }
                    %>
            <%
                }else{

            %>
            <title>View Profile Failed</title>
    
   
        <h1>You Aren't logged in</h1>
        <p>
            You have to be logged in to view your own profile.
        </p>
            <%
                }
                session.removeAttribute("EditSuccess");
                session.setAttribute("EditSuccess", "");
                %>
                <p>
            <a href='editUser.jsp' class="button">Edit Your Profile</a>
                </p>
                <p>
            <a href='ChangePassword.jsp' class="button">Change Password</a>
                </p>
            <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
                 </section>
             </article>
             <%@ include file="Includes/footer.jsp" %>
        </div>
    
    </body>
    
</html>
