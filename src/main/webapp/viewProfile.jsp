
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

     <%@ include file="Includes/Carousel.html" %> 
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
                if(!(message == "")){
            %>

            <div class="alert alert-info alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Info!</strong> <%=message%>.
            </div>
            <%
                }
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
        <img src="<%=account.GetProfPicPath(successUser.getUserID())%>" width="150" height="150" />
        <br />
        <a href='ChangeProfilePic.jsp' class="Profilebutton">Change profile Picture</a>
            
           
        
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
                    <th>Country</th>
                    <th>Comments</th>
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
                
                <td><%=successUser.getCountry()%></td>

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
                
            <br />  
            <a href='editUser.jsp' class="Profilebutton">Edit Your Profile</a>
            
            <a href='ChangePassword.jsp' class="Profilebutton">Change Password</a>
            <%
                Object Value5 = session.getAttribute("CurrentUser");
                Users successUser = (Users) Value4;
                isAdmin = successUser.getAdmin();
                if(isAdmin!=0){
                %>
                <form name="del" action="FrontController" method="post" >
                <h3>Delete a User</h3>
                User-ID: 
                <br />
                <input name="uId" size=30 type="text" />
                
                <input type="submit" value="Post" />
            
                <input type="hidden" name="action" value="delUser" />
                </form>
                <%
                    }
                    %>
              
            <h1 id="secret">&zwnj;</h1>
            </div> 
                 </section>
             </article>
             <%@ include file="Includes/footer.jsp" %>
        </div>
    
    </body>
    
</html>
