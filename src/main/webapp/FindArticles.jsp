<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SWGW</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/Articles.css" rel="stylesheet" type="text/css"/>
        <%@ include file="Includes/Carousel.html" %> 
    <body>
        <div id="wrapper">
            <header>
                
                 <br />
                 <br />
                 <br />
                 <br />
                 <br />
                <%
                    ArticleDao aDao = new ArticleDao("swgw");
                    UsersDao author = new UsersDao("swgw");
                    String title = request.getParameter("title");
                    ArrayList<Article> foundArticles = new ArrayList(aDao.getArticlesByTitle(title));
                %>
                <%@ include file="Includes/nav.jsp" %>
                <h1><% if(foundArticles.size()==0){ %>
                No 
                <%  }%> 
                Articles Found</h1>
            </header>
            <article>
                <section>
                <%
                    for (int i = 0; i < foundArticles.size(); i++) {
                %>
                <div class="Articlesfound">
                <a id="AccountLink" href="viewArticle.jsp?article=<%=(foundArticles.get(i)).getArticleID()%>"><h1><%=(foundArticles.get(i)).getTitle()%></h1></a>
                </div>
                <%
                    }
                %>
                </section>
            </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>

    </body>

</html>

