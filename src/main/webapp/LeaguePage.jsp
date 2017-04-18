<%@page import="java.util.*"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page import="javax.json.*"%>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<%@page import="LeagueAPI.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOL-Section</title>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/LeaguePage.css" rel="stylesheet" type="text/css"/>
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
    
  }
    </script>
    
    <body>
        <div id="wrapper">
            
            <header>
                <%@ include file="Includes/nav.jsp" %>
                
                <h1>League of Legions</h1>
            </header>
            
                <article>
                    
                    <section>
                <h2>View your profile</h2>
                
                    <form action="PlayerStats.jsp" method="get" id="Article">
                        
                        Name: <input name="name" id="leagueName" size=30 type="text" /> 
                        <br />
                        <br />
                        
                        Region: <input name="region" id="leagueRegion" size=30 type="text" /> 
                        <br />
                            <input type="submit" value="View Your Profile" id="submitLeague"/>
                        
                    </form>
                    </section>
                
            <%    Users successUser2 = new Users();
                Object Value4 = session.getAttribute("CurrentUser");
                if (Value4 != null) {
                    successUser2 = (Users) Value4;
                    int a2 = successUser2.getAdmin();
                    if (a2 != 0) {
                        int id = successUser2.getUserID();
            %>
            

                <section>
                    <p>
                <input id="more" type="checkbox">Add an Article</input>
           </p>
                <div id="MainForms">
                    <h3>Write a League Article</h3>
                    <form action="FrontController" method="post" id="Article">
                        
                            Title: <input name="title" size=30 type="text" /> 
                        <br />
                        
                            Text:
                        <br />
                        
                            <textarea rows="4" cols="50" name="content" form="Article"></textarea>
                        <br />
                        
                            <span id='post'>  <input type="submit" value="Post" /></span>
                        
                        <input type="hidden" name="game" value="lol" />
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
                        <%=author.GetAuthorByID((allComments.get(j)).getcAuthor())%> <img src="<%=author.GetPicPath((allComments.get(j)).getcAuthor())%>" height="20" width="20" /> on <%=(allComments.get(j)).getDate()%>
                        <p><%=(allComments.get(j)).getCommentText()%></p>
                    </section>
                    <%
                        if (allComments.get(j).getcAuthor() == successUser2.getUserID()) {
                    %>
                    <section>
                        <form name="delc" action="FrontController" method="post">
                            
                                <input type="hidden" name="commID" value="<%=allComments.get(j).getCommentID()%>" />
                            <br />
                            
                                <input type="submit" value="Delete Comment" />
                            <br />
                            
                                <input type="hidden" name="action" value="delComm" />
                            <br />
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
                               
                                    <span id='content'> Text: </span> <span id='textbox'>  <input name="comment" size=50 type="text" /> </span>
                                <br />
                               
                                    <span id='post'>  <input type="submit" value="Post" /> </span>
                                <br />
                                
                                    <input type="hidden" name="action" value="writeComm" />
                                <br />
                                <input type="hidden" name="artID" value="<%=allArticles.get(i).getArticleID()%>" />
                            </form>
                        </section>
                        <%
                                }
                            }
                        %>
                </article>
                <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>