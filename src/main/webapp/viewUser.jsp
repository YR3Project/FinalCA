<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SWGW</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Common.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
    </head> 

    
    <body>
        <div id="wrapper">
            <header>
                 <br />
                 <br />
                 <br />
                 <br />
                 <br /> 
                <%
                    UsersDao uDao = new UsersDao("swgw");
                    String username = request.getParameter("user");
                    if (username.contains(" ")) {
                        int spaceIndex = (username.indexOf(" ") - 1);
                        username = username.substring(0, spaceIndex);
                    }
                    Users user = uDao.getUserbyName(username);
                    Object Value4 = session.getAttribute("CurrentUser");
                    
                    int isAdmin= 0;
                    int loggedInID = 0;
                    if (Value4 != null) {
                        Users successUser2 = (Users) Value4;
                        loggedInID = successUser2.getUserID();
                        isAdmin = successUser2.getAdmin();
                    }
                %>
                <h1><%=username%>'s Profile:</h1>

                <%@ include file="Includes/nav.jsp" %>
            </header>
            <article>
                <section>
                    <table>
                        <tr><%
                            if (isAdmin != 0 || loggedInID == user.getUserID()) {
                            %>

                            <th>ID</th>

                            <%
                                }
                            %>
                            <th>UserName</th>
                            <%
                            if (isAdmin != 0 || loggedInID == user.getUserID()) {
                            %>
                            <th>Email</th>
                            <%
                                }
                            %>
                            <th>Country</th>
                        </tr>
                        <tr>
                            <%
                                if (isAdmin != 0 || loggedInID == user.getUserID()) {
                            %>

                            <td><%=user.getUserID()%></td>
                        <br>
                        <%
                            }
                        %>
                        <td><%=user.getUserName()%></td>
                        <br>
                        <%
                            if (isAdmin != 0 || loggedInID == user.getUserID()) {
                            %>
                        <td><%=user.getEmail()%></td>
                        <%
                                }
                            %>
                        <td><%=user.getCountry()%></td>    
                        </tr>
                    </table>


                 <h1 id="secret">&zwnj;</h1>
                </section>
            </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>

    </body>

</html>
Chat Conversation End
Type a message...