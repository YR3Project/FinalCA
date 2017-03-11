
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>Stat-Tacking Website</title>
        
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
    <%@ include file="Includes/Slideshow.php" %>
         
    <body>
        
         
    <div id="wrapper">
      
        <header>
        <%@ include file="Includes/nav.jsp" %>
        <h1>Stat-Tacking Website</h1>
        </header>
        
        <%  
            Users successUser2 = new Users();
            Object Value4 = session.getAttribute("CurrentUser");
            if (Value4 != null) {
                successUser2 = (Users) Value4;
                int a2 = successUser2.getAdmin();
                if (a2 != 0) {
                    int id = successUser2.getUserID();
        %>
        <article>
       
       <section>
        <h3>Write an Article</h3>
        <form action="FrontController" method="post" id="Article">
            <p>
            Title: <input name="title" size=30 type="text" /> 
            </p>
            <p>
            Text:
            </p>
            <p>
            <textarea rows="4" cols="50" name="content" form="Article"></textarea>
            </p>
            <p>
            <select name="game">
                <option value="def">General</option>
                <option value="wow">World of Warcraft</option>
                <option value="lol">League of Legends</option>
            </select>
            </p>
            <p>
            <span id='post'>  <input type="submit" value="Post" /></span>
            </p>
            <input type="hidden" name="action" value="postArtc" />
        </form>
        </section>
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
        <article>
        <section>    
        <div class="Articles">
        <h3><%=(allArticles.get(i)).getTitle()%></h3> by <%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%> on <%=(allArticles.get(i)).getDate()%>
        <p><%=(allArticles.get(i)).getArticleText()%></p>
        </div>
        </section>
        <%
                if (allArticles.get(i).getAuthorID() == successUser2.getUserID()) {
            %>
            <section>
            <form name="del" action="FrontController" method="post">
                <p>
                <input type="hidden" name="artID" value="<%=allArticles.get(i).getArticleID()%>" />
                </p>
                <p>
                <input type="submit" value="Delete Article" />
                </p>
                <p>
                <input type="hidden" name="action" value="delArtc" />
                </p>
            </form>

            <form name="editform" id="editform" action="FrontController" method="post">
                <p>
                <span id='title'> Title: </span> <span id='textbox'>  <input name="title" value="<%=(allArticles.get(i)).getTitle()%>" size=30 type="text" /> </span>
                </p>
                <p>
                <textarea rows="4" cols="50" name="content" form="editform"></textarea>
                </p>
                <p>
                <select name="game">
                    <option value="def">General</option>
                    <option value="wow">World of Warcraft</option>
                    <option value="lol">League of Legends</option>
                </select>
                <input type="hidden" name="artID" value="<%=allArticles.get(i).getArticleID()%>" />
                <input type="submit" value="Edit" />
                <input type="hidden" name="action" value="editArtc" />
                </p>
            </form>
            </section>
        <%
            }
        %>
         <%
                int artID = (allArticles.get(i)).getArticleID();
                ArrayList<Comments> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
                for (int j = 0; j < allComments.size(); j++) {
            %>
            <section>
            <%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%> on <%=(allComments.get(j)).getDate()%>
            <p><%=(allComments.get(j)).getCommentText()%></p>
            </section>
            <%
            if (allComments.get(j).getcAuthor() == successUser2.getUserID()) {
            %>
            <section>
            <form name="delc" action="FrontController" method="post">
                <p>
                <input type="hidden" name="commID" value="<%=allComments.get(j).getCommentID()%>" />
                </p>
                <p>
                <input type="submit" value="Delete Comment" />
                </p>
                <p>
                <input type="hidden" name="action" value="delComm" />
                </p>
            </form>
            <%
                }
                }
                if (Value4 != null) {
            %>
            <section>
            <h3>Leave a Comment</h3>
            <form action="FrontController" method="post">
                <p>
                <span id='content'> Text: </span> <span id='textbox'>  <input name="comment" size=50 type="text" /> </span>
                </p>
                <p>
                <span id='post'>  <input type="submit" value="Post" /> </span>
                </p>
                <p>
                <input type="hidden" name="action" value="writeComm" />
                </p>
                <input type="hidden" name="artID" value="<%=allArticles.get(i).getArticleID()%>" />
            </form>
            </section>
            <%
                    }
                }
            %>
        <section>
        <h3>Most popular Streamer Currently</h3>
        <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="HomeStream"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "imaqtpie",
                };
                var player = new Twitch.Player("HomeStream", options);
                player.setVolume(0);
        </script>
        </section>
     </article>
        
    
</body>
<%@ include file="Includes/footer.jsp" %>

</html>
