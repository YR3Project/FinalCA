<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <link href="CSS/index.css" rel="stylesheet" type="text/css"/>
        <title>Stat-Tacking Website</title>
        <script>
            $(document).ready(function () {
                $("button").click(function () {
                    $("#editform").toggle();
                });
            });
        </script>
    </head>
    <div id="wrapper">
        <h1>Stat-Tacking Website</h1>
        <%@ include file="Includes/nav.jsp" %>
        <%            Users successUser2 = new Users();
            Object Value4 = session.getAttribute("CurrentUser");
            if (Value4 != null) {
                successUser2 = (Users) Value4;
                int a2 = successUser2.getAdmin();
                if (a2 != 0) {
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
            CommentsDao cDao = new CommentsDao("swgw");
            ArrayList<Article> allArticles = new ArrayList(aDao.getAllArticles());
            for (int i = 0; i < allArticles.size(); i++) {
        %>
        <h3><%=(allArticles.get(i)).getTitle()%></h3> by <%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%> on <%=(allArticles.get(i)).getDate()%>
        <p><%=(allArticles.get(i)).getArticleText()%></p>
        <%
            if (allArticles.get(i).getAuthorID() == successUser2.getUserID()) {
        %>

        <button>Edit post</button>
        <form name="editform" id="editform" action="FrontController" method="post">
            <span id='title'> Title: </span> <span id='textbox'>  <input name="title" value="<%=(allArticles.get(i)).getTitle()%>" size=30 type="text" /> </span>
            <span id='content'> Text: </span> <span id='textbox'>  <input name="content" value="<%=(allArticles.get(i)).getArticleText()%>" size=50 type="text" /> </span>
            <select name="game">
                <option value="def">General</option>
                <option value="wow">World of Warcraft</option>
                <option value="lol">League of Legends</option>
            </select>

            <input type="submit" value="Edit Article" />
            <input type="hidden" name="action" value="editArtc" />
        </form>
        <%
            }
        %>
        <%
            int artID = (allArticles.get(i)).getArticleID();
            ArrayList<Comments> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
            for (int j = 0; j < allComments.size(); j++) {
        %>
        <%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%> on <%=(allComments.get(j)).getDate()%>
        <p><%=(allComments.get(j)).getCommentText()%></p>
        <%
                }
            }
        %>
        <%@ include file="Includes/footer.jsp" %>
    </div>
</body>
</html>
