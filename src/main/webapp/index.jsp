
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
           <!--Add buttons to initiate auth sequence and sign out-->
    <button id="authorize-button" >Authorize</button>
    <button id="signout-button" >Sign Out</button>
    <script type="text/javascript">
      // Client ID and API key from the Developer Console
      var CLIENT_ID = '937028544573-pgqdddnpmjp03vskjf04vr6bnvk4q5qc.apps.googleusercontent.com';

      // Array of API discovery doc URLs for APIs used by the quickstart
      var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/gmail/v1/rest"];

      // Authorization scopes required by the API; multiple scopes can be
      // included, separated by spaces.
      var SCOPES = 'https://www.googleapis.com/auth/gmail.readonly';

      var authorizeButton = document.getElementById('authorize-button');
      var signoutButton = document.getElementById('signout-button');

      /**
       *  On load, called to load the auth2 library and API client library.
       */
      function handleClientLoad() {
        gapi.load('client:auth2', initClient);
      }

      /**
       *  Initializes the API client library and sets up sign-in state
       *  listeners.
       */
      function initClient() {
        gapi.client.init({
          discoveryDocs: DISCOVERY_DOCS,
          clientId: CLIENT_ID,
          scope: SCOPES
        }).then(function () {
          // Listen for sign-in state changes.
          gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);

          // Handle the initial sign-in state.
          updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
          authorizeButton.onclick = handleAuthClick;
          signoutButton.onclick = handleSignoutClick;
        });
      }

      /**
       *  Called when the signed in status changes, to update the UI
       *  appropriately. After a sign-in, the API is called.
       */
      function updateSigninStatus(isSignedIn) {
        if (isSignedIn) {
          authorizeButton.style.display = 'none';
          signoutButton.style.display = 'block';
          listLabels();
        } else {
          authorizeButton.style.display = 'block';
          signoutButton.style.display = 'none';
        }
      }

      /**
       *  Sign in the user upon button click.
       */
      function handleAuthClick(event) {
        gapi.auth2.getAuthInstance().signIn();
      }

      /**
       *  Sign out the user upon button click.
       */
      function handleSignoutClick(event) {
        gapi.auth2.getAuthInstance().signOut();
      }

      /**
       * Append a pre element to the body containing the given message
       * as its text node. Used to display the results of the API call.
       *
       * @param {string} message Text to be placed in pre element.
       */
      function appendPre(message) {
        var pre = document.getElementById('content');
        var textContent = document.createTextNode(message + '\n');
        pre.appendChild(textContent);
      }

      /**
       * Print all Labels in the authorized user's inbox. If no labels
       * are found an appropriate message is printed.
       */
      function listLabels() {
        gapi.client.gmail.users.labels.list({
          'userId': 'me'
        }).then(function(response) {
          var labels = response.result.labels;
          appendPre('Labels:');

          if (labels && labels.length > 0) {
            for (i = 0; i < labels.length; i++) {
              var label = labels[i];
              appendPre(label.name)
            }
          } else {
            appendPre('No Labels found.');
          }
        });
      }

    </script>

    <script async defer src="https://apis.google.com/js/api.js"
      onload="this.onload=function(){};handleClientLoad()"
      onreadystatechange="if (this.readyState === 'complete') this.onload()">
    </script>
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
