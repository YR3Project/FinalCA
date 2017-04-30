<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page import="javax.json.*"%>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<%@page import="WOWApi.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/WoW.css" rel="stylesheet" type="text/css"/>
        <title>SWGW</title>

    </head>
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
    <%@ include file="Includes/Carousel.html" %> 
    <body>
        <div id="wrapper">
            
            <header>
                <%@ include file="Includes/nav.jsp" %>
                
                <h1>World of Warcraft Legion</h1>
            </header>
            
                <article>
                    <img src="Images/Wowlogo.png" alt="logo" style="width: 70%; display: block; margin: 0 auto;"/>
                <section>
                <h3 id="title">View your Character</h3>
                <div class="Articles">
                <p>View some of the statistics of your WoW Character!</p>
                </div>
                
                <img id="wowpic" src="Images/HUMAN.PNG" alt="human"/>
              
                </section>
                    <form id="WowChar" action="WoWApi.jsp" method="post">
                        <h2 id="title">Enter the details to see info</h2>
                        <div id="centerform">
                        
                        <h3 id="wowitle">Name:</h3>  <input name="name" size=30 type="text" />
                        <br />
                        <br />
                        <h3 id="wowtitle">Realm:</h3>  <input name="realm" size=30 type="text" />
                        <br />
                        <br />
                        <input type="submit" value="View Your Character" id="stats"/>
                        </div>
                    </form>
                    
                
            <%    Users successUser2 = new Users();
                Object Value4 = session.getAttribute("CurrentUser");
                if (Value4 != null) {
                    successUser2 = (Users) Value4;
                    int a2 = successUser2.getAdmin();
                    if (a2 != 0) {
                        int id = successUser2.getUserID();
            %>
            

                <section>
                 <br />   
                <button onclick="myFunction()">Add Article</button>
          
                <div id="MainForms">
                    
                    <form id="WOWEdit" action="FrontController" method="get" id="Article">
                        <h3 class id="title">Write a WoW Article</h3>
                        <br />
                        
                            Title: <input name="title" size=30 type="text" /> 
                        <br />
                        
                            Text:
                        <br />
                        
                            <textarea rows="4" cols="50" name="content" form="Article"></textarea>
                        <br />
                        
                            <span id='post'>  <input type="submit" value="Post" /></span>
                        
                        <input type="hidden" name="game" value="wow" />
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
                    ArrayList<Article> allArticles = new ArrayList(aDao.getWowArticles());
                    for (int i = 0; i < allArticles.size(); i++) {
                    String artText = (allArticles.get(i)).getArticleText();
                     if(artText.length() > 200){
                     artText = artText.substring(0, 199) + "...";
                     }
                %>
                
                    <section>    
                        
                        <h3 class id="title"><%=(allArticles.get(i)).getTitle()%></h3> <p>by <a id="AccountLink" href="viewUser.jsp?user=<%=author.GetAuthorByID((allArticles.get(i)).getAuthorID())%>"><%= author.GetAuthorByID((allArticles.get(i)).getAuthorID())%><img src="<%=author.GetProfPicPath((allArticles.get(i)).getAuthorID())%>" height="20" width="20" /></a> on <%=(allArticles.get(i)).getDate()%></p>
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
                </article>
                <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
