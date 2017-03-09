
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stat-Tacking Website</title>
    </head>
    <div id="wrapper">
        

        <%@ include file="Includes/nav.jsp" %>
        <h1>Stat-Tacking Website</h1>
        
        <%    Object Value4 = session.getAttribute("CurrentUser");
            if (Value4 != null) {
                Users successUser2 = (Users) Value4;
                int a2 = successUser2.getAdmin();
                if (a2 != 0) {
                    int id = successUser2.getUserID();
        %>
        <h3>Write an Article</h3>
        <form action="FrontController" method="post">
            <span id='title'> Title: </span> <span id='textbox'>  <input name="title" size=30 type="text" /> </span>
            <span id='content'> Text: </span> <span id='textbox'>  <input name="content" size=50 type="text" /> </span>
            <select name="game">
                <option value="def">General</option>
                <option value="wow">World of Warcraft</option>
                <option value="lol">League of Legends</option>
            </select>
            <span id='post'>  <input type="submit" value="Post" /></span>
            <input type="hidden" name="action" value="postArtc" />
        </form>
        <%
                }
            }
        %>
        <%
            ArticleDao aDao = new ArticleDao("swgw");
            UsersDao author = new UsersDao("swgw");
            ArrayList<Article> allArticles = new ArrayList(aDao.getAllArticles());
            for (int i = 0; i < allArticles.size(); i++) {
        %>
        <div class="Articles">
        <h3><%=(allArticles.get(i)).getTitle()%></h3> by <%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%> on <%=(allArticles.get(i)).getDate()%>
        <p><%=(allArticles.get(i)).getArticleText()%></p>
        <%
            }
        %>
        </div>
    </div>
</body>
<%@ include file="Includes/footer.jsp" %>
</html>
