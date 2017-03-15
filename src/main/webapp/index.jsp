
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            
        <title>SWGW</title>
        
    </head>
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
    <%@ include file="Includes/Slideshow.php" %>
    <script>
        window.onload = function () {
        document.getElementById('MainForms').style.display = 'none';
            document.getElementById('more').onclick = function () {
        if (this.checked)
            document.getElementById('MainForms').style.display = 'block';
        else
            document.getElementById('MainForms').style.display = 'none';  
    }
    
    document.getElementById('MainForms2').style.display = 'none';
            document.getElementById('more2').onclick = function () {
        if (this.checked)
            document.getElementById('MainForms2').style.display = 'block';
        else
            document.getElementById('MainForms2').style.display = 'none';  
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
           <p>
                <input id="more" type="checkbox">Add an Article</input>
           </p>
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
        %>
        <article>
        <section>    
        <div class="Articles">
            <h3 class id="title"><%=(allArticles.get(i)).getTitle()%></h3> <p>by <%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%><img src="getImageDetails.jsp?your_id=<%=(allArticles.get(i)).getAuthorID()%>" height="20" width="20" /> on <%=(allArticles.get(i)).getDate()%></p>
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
                
                <input type="submit" value="Delete Article" />
                
                <p>
                <input type="hidden" name="action" value="delArtc" />
                </p>
            </form>
                <p>
                <input id="more2" type="checkbox">Edit </input>
                </p>
                <div id="MainForms2">
                    <h3 class id="title">Edit an Article</h3>
            <form name="editform" id="editform" action="FrontController" method="post">
                <p>
                Title:
                </p>
                <input name="title" value="<%=(allArticles.get(i)).getTitle()%>" size=30 type="text" />
                <br />
                <textarea rows="4" cols="50" name="content" form="editform"></textarea>
                <br />
                
                <select name="game">
                    <option value="def">General</option>
                    <option value="wow">World of Warcraft</option>
                    <option value="lol">League of Legends</option>
                </select>
               
                <input type="hidden" name="artID" value="<%=allArticles.get(i).getArticleID()%>" />
                <input type="submit" value="Edit" />
                <input type="hidden" name="action" value="editArtc" />
                
            </form>
                </div>
            </section>
        <%
            }
        %>
         <%
                int artID = (allArticles.get(i)).getArticleID();
                ArrayList<Comments> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
                for (int j = 0; j < allComments.size(); j++) {
            %>
            <section class id="commentsection">
                <h3 class id="commentTitle">Comment</h3>
                <p><%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%> <img src="getImageDetails.jsp?your_id=<%=(allComments.get(j)).getcAuthor()%>" height="20" width="20" /> on <%=(allComments.get(j)).getDate()%></p>
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
                
                <input type="submit" value="Delete Comment" />
                
                <p>
                <input type="hidden" name="action" value="delComm" />
                </p>
            </form>
            </section>    
            <%
                }
                }
                if (Value4 != null) {
            %>
            <section class id="leavecommentsection">
               
            <h3 class id="leavecomment">Leave a Comment</h3>
            
            <form action="FrontController" method="post">
                <p>
                Text:
                </p>
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
