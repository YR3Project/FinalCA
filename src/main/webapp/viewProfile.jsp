
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <div id="wrapper">
        </head>        
        <%@ include file="Includes/nav.jsp" %> 
        <%
            Object Value3 = session.getAttribute("EditSuccess");
            
            if (Value3 != null)
            {
                String message = (String) Value3;
                %>
                <br/><p><% out.println(message); %></p>
                
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
        <ul>
            <li><a href='ChangePic.jsp'>Change profile Picture</a></li>
        </ul>    
             
             
        <h1><%=successUser.getUserName()%>'s Profile</h1>
        <ul>
            <li><a href='editUser.jsp'>Edit Your Profile</a></li>
            <li><a href='ChangePassword.jsp'>Change Password</a></li>
        </ul>
        
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
                    <%
                    }
                    %>
                <td><%=successUser.getUserName()%></td>
                <td><%=successUser.getEmail()%></td>

            </tr>
        </table>
                            <%
                    if(isAdmin!=0){
                    %>
                    <p><%=successUser.getUserName()%> is an administrator on this site.</p>
                    <!--placeholder-->
                    
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
                %>
                
        </div>
    
    </body>
    <%@ include file="Includes/footer.jsp" %>
</html>
