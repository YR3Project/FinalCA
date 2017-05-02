
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
         <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
         <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
            
        <title>SWGW</title>
        
    </head>

    <%@ include file="Includes/Carousel.html" %>  
    <body>
        
  
    <div id="wrapper">
      
        <header>
        <%@ include file="Includes/nav.jsp" %>
        <h1>StatWiseGameWise</h1>
        </header>

        <div id="SearchArticles">
        <form action="FindArticles.jsp" method="post">
            Search For Article: 
            <input name="title" size=30 type="text" placeholder="Article title" /> 
            <button type="submit" value="Find"><span class="glyphicon glyphicon-search"></span>Search</button>
        </form>
         </div> 
        <script>
            $(document).ready(function(){
                $("#appearhidden").on("hide.bs.collapse", function(){
                $(".btn").html('<span class="glyphicon glyphicon-collapse-down"></span> Open');
            });
                $("#appearhidden").on("show.bs.collapse", function(){
                $(".btn").html('<span class="glyphicon glyphicon-collapse-up"></span> Close');
            });
            });
        </script>
        
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
            <button type="button" class="btn btn-success" data-toggle="collapse" data-target="#appearhidden">
            <span class="glyphicon glyphicon-collapse-down"></span> Open
        </button>
        
        <div id="appearhidden" class="collapsing"> 
       <section>
  
       
        <h3 class id="title">Write an Article</h3>
        <form action="FrontController" method="post" id="Article">
            
            Title: 
            <br />
            <input name="title" size=30 type="text" /> 
            <br />
            Text:
            <br />
            <textarea rows="4" cols="50" name="content">Enter Text Here</textarea>
           
            <br />
            <select name="game">
                <option value="def">General</option>
                <option value="wow">World of Warcraft</option>
                <option value="lol">League of Legends</option>
            </select>
        
            <input type="submit" value="Post" />
            
            <input type="hidden" name="action" value="postArtc" />
        </form>         
        </section>
        </div>
      
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
        <div class="ArticleTitle">
            <h3 class id="title"><%=(allArticles.get(i)).getTitle()%></h3> 
        </div>    
            <p>by <a id="AccountLink" href="viewUser.jsp?user=<%=author.GetAuthorByID((allArticles.get(i)).getAuthorID())%>"><%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%><img src="<%=author.GetProfPicPath((allArticles.get(i)).getAuthorID())%>" height="20" width="20" /></a> on <%=(allArticles.get(i)).getDate()%></p>
            <img src="<%=aDao.GetPicPath((allArticles.get(i)).getAuthorID(), allArticles.get(i).getArticleID())%>" height="200" width="500" />
        <div class="Articles">        
	<p><%=artText%>  <a href="viewArticle.jsp?article=<%=(allArticles.get(i)).getArticleID()%>">See more</a></p>
        
        
            <%
                int artID = (allArticles.get(i)).getArticleID();
                ArrayList<Comments> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
                %>
                <h5><%=allComments.size()%> Comments</h5>
                </div>
                </section>
                <%
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
