
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>SWGW</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        </head> 

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
            UsersDao account = new UsersDao("swgw");
            CommentsDao cDao = new CommentsDao("swgw");
                int isAdmin;
            if (Value4 != null) {
                Users successUser = (Users) Value4;
                ArrayList<Comments> commentsMade = new ArrayList(cDao.getCommentsByAuthor(successUser.getUserID()));
                isAdmin = successUser.getAdmin();
        %>
       
        
        <div class="Articles">

        <h2 id="title"><%=successUser.getUserName()%>'s Profile</h2>
        <img src="<%=account.GetPicPath(successUser.getUserID())%>" width="150" height="150" />
        <a href='ChangeProfilePic.jsp' class="button">Change profile Picture</a>
            
           
        
            <div style="overflow-x:auto;">
        <table id="userTable">
            <tr>
                <%  
                    if(isAdmin!=0){
                        %>
                <th>ID</th>
                <%
                        }
                %>    
                    <th>UserName</th>
                    <th>Email</th>
                    <th></th>
                    <th>Comments by this Account</th>
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
                
                <td><%=successUser.getEmail()%></td>
                <td></td>
                <td><%=commentsMade.size()%></td>
            </tr>
        </table>
                </div>
                            <%
                    if(isAdmin!=0){
                    %>
                    <h4 id="title"><%=successUser.getUserName()%> is an administrator on this site.</h4>

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
                </div>
                <p>
            <a href='editUser.jsp' class="button">Edit Your Profile</a>
                </p>
                <p>
            <a href='ChangePassword.jsp' class="button">Change Password</a>
                </p>
            <h1 id="secret">&zwnj;</h1>
                 </section>
             </article>
             <%@ include file="Includes/footer.jsp" %>
        </div>
    
    </body>
    
</html>
