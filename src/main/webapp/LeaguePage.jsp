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
        <title>SWGW</title>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/LeaguePage.css" rel="stylesheet" type="text/css"/>

    </head>

     <%@ include file="Includes/Carousel.html" %> 
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
                
                <h1>League of Legends</h1>
            </header>

                <article>
                    
                    <br />
                    <img src="Images/Lollogo.png" alt="logo" style="width: 70%; display: block; margin: 0 auto;"/>
                    <br />
                    <form id="playerst" action="PlayerStats.jsp" method="get">
                    <div id="centerform">
                            <h3 class id="title">View your profile</h3>
                            <h2 id="Leaguetitle">Name:</h2> 
                        <input name="name" id="leagueName" size=30 type="text" /> 
                        <br />
                        <h2 id="Leaguetitle">Region:</h2>
                        <div class="styled-select black rounded">
                        <Select name='region' id='leagueRegion'>
                            <option selected="selected">EUW</option>
                            <option>NA</option>
                        </Select>
                        </div>
                        <h2 id="Leaguetitle">Season:</h2>
                        <div class="styled-select black rounded">
                        <Select name='season' id='leagueRegion'>
                            <option selected="selected">Season 7</option>
                            <option>Season 6</option>
                            <option>Season 5</option>
                            <option>Season 4</option>
                        </Select>
                        </div>
                        <br />
                            <input type="submit" value="View Your Profile" id="stats"/>
                    </div>
                    </form>

                        
                    
                       
                    
                 <%

                    //Ranks
                    String region = "NA";
                    Master master = new Master();
                    MasterObject mo = new MasterObject();
                    master = mo.getMaster();
                    
                    Challenger challenger = new Challenger();
                    ChallengerObject co = new ChallengerObject();
                    
                    challenger = co.getChallenger(region);
                    
                    
                    
                %>  
                
                
            <section class="rankTables">
                <div class="Ladders"> 
                <h2 id="title">Challenger Ladder</h2>
                <div class="Laddersdata">
                <table id="rankTables">
                    <thead>
                    <th>Rank</th><th>Name</th><th>Win</th><th>Losses</th><th>Points</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><%=challenger.getPlayerName()%></td>
                            <td><%=challenger.getWins()%></td>
                            <td><%=challenger.getLosses1()%></td>
                            <td><%=challenger.getLeaguePoints()%></td>
                        </tr>
                        <tr>  
                            <td>2</td>
                            <td><%=challenger.getPlayerName2()%></td>
                            <td><%=challenger.getWins2()%></td>
                            <td><%=challenger.getLosses2()%></td>
                            <td><%=challenger.getLeaguePoints2()%></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td><%=challenger.getPlayerName3()%></td>
                            <td><%=challenger.getWins3()%></td>
                            <td><%=challenger.getLosses3()%></td>
                            <td><%=challenger.getLeaguePoints3()%></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td><%=challenger.getPlayerName4()%></td>
                            <td><%=challenger.getWins4()%></td>
                            <td><%=challenger.getLosses4()%></td>
                            <td><%=challenger.getLeaguePoints4()%></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td><%=challenger.getPlayerName5()%></td>
                            <td><%=challenger.getWins5()%></td>
                            <td><%=challenger.getLosses5()%></td>
                            <td><%=challenger.getLeaguePoints5()%></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td><%=challenger.getPlayerName6()%></td>
                            <td><%=challenger.getWins6()%></td>
                            <td><%=challenger.getLosses6()%></td>
                            <td><%=challenger.getLeaguePoints6()%></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td><%=challenger.getPlayerName7()%></td>
                            <td><%=challenger.getWins7()%></td>
                            <td><%=challenger.getLosses7()%></td>
                            <td><%=challenger.getLeaguePoints7()%></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td><%=challenger.getPlayerName8()%></td>
                            <td><%=challenger.getWins8()%></td>
                            <td><%=challenger.getLosses8()%></td>
                            <td><%=challenger.getLeaguePoints8()%></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td><%=challenger.getPlayerName9()%></td>
                            <td><%=challenger.getWins9()%></td>
                            <td><%=challenger.getLosses9()%></td>
                            <td><%=challenger.getLeaguePoints9()%></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td><%=challenger.getPlayerName10()%></td>
                            <td><%=challenger.getWins10()%></td>
                            <td><%=challenger.getLosses10()%></td>
                            <td><%=challenger.getLeaguePoints10()%></td>
                           
                                
                            
                        </tr>
                    </tbody>
                </table>
                </div>            
                <h2 id="title">Master ladder</h2>
                <div class="Laddersdata">
                <table id="rankTables">
                    <thead>
                    <th>Rank</th><th>Name</th><th>Wins</th><th>Losses</th><th>Points</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><%=master.getPlayerName()%></td>
                            <td><%=master.getWins()%></td>
                            <td><%=master.getLosses1()%></td>
                            <td><%=master.getLeaguePoints()%></td>
                        </tr>
                        <tr>  
                            <td>2</td>
                            <td><%=master.getPlayerName2()%></td>
                            <td><%=master.getWins2()%></td>
                            <td><%=master.getLosses2()%></td>
                            <td><%=master.getLeaguePoints2()%></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td><%=master.getPlayerName3()%></td>
                            <td><%=master.getWins3()%></td>
                            <td><%=master.getLosses3()%></td>
                            <td><%=master.getLeaguePoints3()%></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td><%=master.getPlayerName4()%></td>
                            <td><%=master.getWins4()%></td>
                            <td><%=master.getLosses4()%></td>
                            <td><%=master.getLeaguePoints4()%></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td><%=master.getPlayerName5()%></td>
                            <td><%=master.getWins5()%></td>
                            <td><%=master.getLosses5()%></td>
                            <td><%=master.getLeaguePoints5()%></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td><%=master.getPlayerName6()%></td>
                            <td><%=master.getWins6()%></td>
                            <td><%=master.getLosses6()%></td>
                            <td><%=master.getLeaguePoints6()%></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td><%=master.getPlayerName7()%></td>
                            <td><%=master.getWins7()%></td>
                            <td><%=master.getLosses7()%></td>
                            <td><%=master.getLeaguePoints7()%></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td><%=master.getPlayerName8()%></td>
                            <td><%=master.getWins8()%></td>
                            <td><%=master.getLosses8()%></td>
                            <td><%=master.getLeaguePoints8()%></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td><%=master.getPlayerName9()%></td>
                            <td><%=master.getWins9()%></td>
                            <td><%=master.getLosses9()%></td>
                            <td><%=master.getLeaguePoints9()%></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td><%=master.getPlayerName10()%></td>
                            <td><%=master.getWins10()%></td>
                            <td><%=master.getLosses10()%></td>
                            <td><%=master.getLeaguePoints10()%></td>
                        </tr>
                    </tbody>
                </table>
                </div>
                </div>
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
               <br />   
                <button onclick="myFunction()">Add Article</button>
                
                <div id="MainForms">
                    <h3 id="title">Write a League Article</h3>
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
                ArrayList<Article> allArticles = new ArrayList(aDao.getLolArticles());
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
                        <p><%=artText%>  <a  href="viewArticle.jsp?article=<%=(allArticles.get(i)).getArticleID()%>">See more</a></p>
                        
                    


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
