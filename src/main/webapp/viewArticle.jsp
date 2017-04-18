<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Article</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        
        <link href="CSS/Articles.css" rel="stylesheet" type="text/css"/>
    </head> 

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
                <%
                    ArticleDao aDao = new ArticleDao("swgw");
                    UsersDao author = new UsersDao("swgw");
                    CommentsDao cDao = new CommentsDao("swgw");
                    int artID = Integer.parseInt(request.getParameter("article"));
                    Article artc = aDao.getArticleByID(artID);
                    Users successUser2 = new Users();
                    Object Value4 = session.getAttribute("CurrentUser");
                    if (Value4 != null) {
                        successUser2 = (Users) Value4;
                        int a2 = successUser2.getAdmin();
                    }
                %>
                <h1><%=artc.getTitle()%></h1>
                <h3>by <a id="AccountLink" href="viewUser.jsp?user=<%=author.GetAuthorByID(artc.getAuthorID())%>"><%= author.GetAuthorByID(artc.getAuthorID())%><img src="<%=author.GetPicPath(artc.getAuthorID())%>" height="40" width="40"/></a> on <%=artc.getDate()%></h3>
                        <%@ include file="Includes/nav.jsp" %>
            </header>
            <article>
             
                    <%
                        
                        if (artc.getAuthorID() == successUser2.getUserID()) {
                    %>
                    <section>
                        <img id="Articleimage"  src="<%=aDao.GetPicPath(artc.getAuthorID())%>" height="200" width="500" />
                        <br />
                    
                        <form name="del" action="FrontController" method="post">
                            
                            <div class="Articles">
                            <br />
                             <p id="viewArticle">
                             <%=artc.getArticleText()%>
                             </p>
                            </div>
                                <input type="hidden" name="artID" value="<%=artc.getArticleID()%>" />
                            

                                <input type="submit" value="Delete Article" />

                            
                                <input type="hidden" name="action" value="delArtc" />
                            
                        </form>
                                </section>
                        <%

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
                        <input type="hidden" name="artID" value="<%=artID%>" />
                    </form>

                    </section>
                         
                        <%  
                            
                            Users currentuser = new Users();
                            Object currentobject = session.getAttribute("CurrentUser");
                            if (currentobject != null) {
                                currentuser = (Users) currentobject;
                                int a2 = currentuser.getAdmin();
                                if (a2 != 0) {
                                    int id = currentuser.getUserID();
                        %>
                            <input id="more" type="checkbox"></input>
                        
                        <div id="MainForms">
                            <h3 class id="title">Edit an Article</h3>
                            <form name="editform" id="editform" action="FrontController" method="post">
                                
                                 Title:
                                
                                <input name="title" value="<%=artc.getTitle()%>" size=30 type="text" />
                                <br />
                                <textarea rows="4" cols="50" name="content" form="editform"></textarea>
                                <br />

                                <select name="game">
                                    <option value="def">General</option>
                                    <option value="wow">World of Warcraft</option>
                                    <option value="lol">League of Legends</option>
                                </select>

                                <input type="hidden" name="artID" value="<%=artc.getArticleID()%>" />
                                <input type="submit" value="Edit" />
                                <input type="hidden" name="action" value="editArtc" />
                                <img src="<%=aDao.GetPicPath(artc.getAuthorID())%>" height="180" width="500" />
                                <a href='ChangeArticlePic.jsp' class="button">Change profile Picture</a>

                            </form>
                        </div>
                    
                    <%
                        
                        }
                        }
                        }
                        }

                        
                    %>
                    
                
            </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>

    </body>

</html>
