
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            
        <title>SWGW</title>
        
    </head>

    <%@ include file="Includes/Slideshow.php" %>
    <script>
        function myFunction() {
            var x = document.getElementById('MainForms');
            if (x.style.display === 'block') {
                x.style.display = 'none';
            } else {
                x.style.display = 'block';
            }
        }
    </script>    
    <body>
        
         
    <div id="wrapper">
      
        <header>
        <%@ include file="Includes/nav.jsp" %>
        <h1>StatWiseGameWise</h1>
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
         
        <button onclick="myFunction()">Add Article</button>
           
        <div id="MainForms">
        <h3 class id="title">Write an Article</h3>
        <form action="FrontController" method="post" id="Article">
            <p>
            Title: 
            </p>
            <input name="title" size=30 type="text" /> 
            <p>
            Text:
            </p>
            
            <textarea rows="4" cols="50" name="content" form="Article"></textarea>
           
            <br />
            <select name="game">
                <option value="def">General</option>
                <option value="wow">World of Warcraft</option>
                <option value="lol">League of Legends</option>
            </select>
        
            <input type="submit" value="Post" />
            
            <input type="hidden" name="action" value="postArtc" />
        </form>
         </div>
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
           String artText = (allArticles.get(i)).getArticleText();
            if(artText.length() > 200){
            artText = artText.substring(0, 199) + "...";
            }
        %>
        <article>
        <section>    
        <div class="Articles">
            <h3 class id="title"><%=(allArticles.get(i)).getTitle()%></h3> <p>by <a id="AccountLink" href="viewUser.jsp?user=<%=author.GetAuthorByID((allArticles.get(i)).getAuthorID())%>"><%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%><img src="<%=author.GetPicPath((allArticles.get(i)).getAuthorID())%>" height="20" width="20" /></a> on <%=(allArticles.get(i)).getDate()%></p>
         	<img src="<%=aDao.GetPicPath((allArticles.get(i)).getAuthorID())%>" height="200" width="500" />   
	<p><%=artText%>  <a id="AccountLink" href="viewArticle.jsp?article=<%=(allArticles.get(i)).getArticleID()%>">See more</a></p>
        </div>
        </section>
 
         <%
                int artID = (allArticles.get(i)).getArticleID();
                ArrayList<Comments> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
                for (int j = 0; j < allComments.size(); j++) {
            %>
            <section class id="commentsection">
                <h3 class id="commentTitle">Comment</h3>
               <p><a id="AccountLink" href="viewUser.jsp?user=<%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%>">
                    <%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%> 
                    <img src="<%=author.GetPicPath((allComments.get(j)).getcAuthor())%>" height="20" width="20" /></a> 
                    on <%=(allComments.get(j)).getDate()%></p>
               <%=(allComments.get(j).getCommentText())%>
            </section>
            <%
                }
                if (Value4 != null) {
            %>
            <section class id="leavecommentsection">
               
            <h3 class id="leavecomment">Leave a Comment</h3>
            
            <form action="FrontController" method="post">

                <input name="comment" size=50 type="text" />
                
                <input type="submit" value="Post" />
               
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
        <h3 class id="title">Most popular Streamer Currently</h3>
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
        <%@ include file="Includes/footer.jsp" %>
    </div>
</body>


</html>
