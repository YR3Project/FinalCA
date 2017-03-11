
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>Stat-Tacking Website</title>
        
    </head>
    <%@ include file="Includes/Slideshow.php" %>
         <%@ include file="Includes/nav.jsp" %>
    <body>
         
    <div id="wrapper">
      
        <header>
        
        <h1>Stat-Tacking Website</h1>
        </header>
        
        <%    Object Value4 = session.getAttribute("CurrentUser");
            if (Value4 != null) {
                Users successUser2 = (Users) Value4;
                int a2 = successUser2.getAdmin();
                if (a2 != 0) {
                    int id = successUser2.getUserID();
        %>
        <article>
       <picture>
            <img src="Images/Drogheda-Ariel.jpg" alt="Ariel photo of Drogheda" width="600" height="398" >
      </picture>
       <section>
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
        </section>
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
        <section>    
        <div class="Articles">
        <h3><%=(allArticles.get(i)).getTitle()%></h3> by <%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%> on <%=(allArticles.get(i)).getDate()%>
        <p><%=(allArticles.get(i)).getArticleText()%></p>
        </div>
        </section>
        <%
            }
        %>
        
        <h3>Most popular Streamer Currently</h3>
        <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol2"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "imaqtpie",
                };
                var player = new Twitch.Player("Lol2", options);
                player.setVolume(0);
        </script>
        
        </article>
        
    
</body>
<%@ include file="Includes/footer.jsp" %>

</html>
