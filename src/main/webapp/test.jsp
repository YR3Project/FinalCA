<%-- 
    Document   : test
    Created on : 09-Mar-2017, 11:30:03
    Author     : AleksMtt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="Includes/nav.jsp" %>
        <%
            CommentsDao cDao = new CommentsDao("swgw");
            ArrayList <Comments> allComments = new ArrayList (cDao.getCommentsByArticle(1));
            int author = 1
            for(int j=0; j<allComments.size(); j++){
        %>
            <%=author.GetAuthorByID((allComments.get(i)).getcAuthor())%> on <%=(allComments.get(i)).getDate()%>
            <p><%=(allComments.get(i)).getCommentText()%></p>
        <%
                }
            %>
    </body>
</html>
