
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
        
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
        <header>
        <h1>Welcome to League of Legends</h1>
        <%@ include file="Includes/nav.jsp" %>
        </header>
        <article>
            <section>
                
                
                 <%
                    RootObject r = new RootObject();
                    //String champID = request.getParameter("champID");
                    
                    RankedStats stats = new RankedStats();
                    RankedObject ro = new RankedObject();
                    
                    PlayerObject po = new PlayerObject();
                    Player player = new Player();
                    player = po.getPlayer("chips97");
                    int id = player.getSummonerID();
                    stats = ro.getRankedStats(id);
                    
                    ServerStatus status = new ServerStatus();
                    ServerObject so = new ServerObject();
                   
                    status = so.getServerStatus();
                    
                    //Ranks
                    Master master = new Master();
                    MasterObject mo = new MasterObject();
                    master = mo.getMaster();
                    Challenger challenger = new Challenger();
                    ChallengerObject co = new ChallengerObject();
                    challenger = co.getChallenger();
                    
                %>  
                
                <h1><%=stats.getMostDeaths()%></h1>
                <h1><%=stats.getId()%></h1>
                <h2><%=status.getName()%></h2>
                <%=status.getStatus()%>
                <h2>Challenger Ladder</h2>
                <table id="challengerladder">
                    <thead>
                    <th>Rank</th><th>Name</th><th>Win</th><th>Losses</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><%=challenger.getPlayerName()%></td>
                            <td><%=challenger.getWins()%></td>
                            <td><%=challenger.getLosses1()%></td>
                        </tr>
                        <tr>  
                            <td>2</td>
                            <td><%=challenger.getPlayerName2()%></td>
                            <td><%=challenger.getWins2()%></td>
                            <td><%=challenger.getLosses2()%></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td><%=challenger.getPlayerName3()%></td>
                            <td><%=challenger.getWins3()%></td>
                            <td><%=challenger.getLosses3()%></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td><%=challenger.getPlayerName4()%></td>
                            <td><%=challenger.getWins4()%></td>
                            <td><%=challenger.getLosses4()%></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td><%=challenger.getPlayerName5()%></td>
                            <td><%=challenger.getWins5()%></td>
                            <td><%=challenger.getLosses5()%></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td><%=challenger.getPlayerName6()%></td>
                            <td><%=challenger.getWins6()%></td>
                            <td><%=challenger.getLosses6()%></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td><%=challenger.getPlayerName7()%></td>
                            <td><%=challenger.getWins7()%></td>
                            <td><%=challenger.getLosses7()%></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td><%=challenger.getPlayerName8()%></td>
                            <td><%=challenger.getWins8()%></td>
                            <td><%=challenger.getLosses8()%></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td><%=challenger.getPlayerName9()%></td>
                            <td><%=challenger.getWins9()%></td>
                            <td><%=challenger.getLosses9()%></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td><%=challenger.getPlayerName10()%></td>
                            <td><%=challenger.getWins10()%></td>
                            <td><%=challenger.getLosses10()%></td>
                           
                                
                            
                        </tr>
                    </tbody>
                </table>
                <h2>Master ladder</h2>
                <table id="masterladder">
                    <thead>
                    <th>Rank</th><th>Name</th><th>Wins</th><th>Losses</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><%=master.getPlayerName()%></td>
                            <td><%=master.getWins()%></td>
                            <td><%=master.getLosses1()%></td>
                        </tr>
                        <tr>  
                            <td>2</td>
                            <td><%=master.getPlayerName2()%></td>
                            <td><%=master.getWins2()%></td>
                            <td><%=master.getLosses2()%></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td><%=master.getPlayerName3()%></td>
                            <td><%=master.getWins3()%></td>
                            <td><%=master.getLosses3()%></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td><%=master.getPlayerName4()%></td>
                            <td><%=master.getWins4()%></td>
                            <td><%=master.getLosses4()%></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td><%=master.getPlayerName5()%></td>
                            <td><%=master.getWins5()%></td>
                            <td><%=master.getLosses5()%></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td><%=master.getPlayerName6()%></td>
                            <td><%=master.getWins6()%></td>
                            <td><%=master.getLosses6()%></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td><%=master.getPlayerName7()%></td>
                            <td><%=master.getWins7()%></td>
                            <td><%=master.getLosses7()%></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td><%=master.getPlayerName8()%></td>
                            <td><%=master.getWins8()%></td>
                            <td><%=master.getLosses8()%></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td><%=master.getPlayerName9()%></td>
                            <td><%=master.getWins9()%></td>
                            <td><%=master.getLosses9()%></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td><%=master.getPlayerName10()%></td>
                            <td><%=master.getWins10()%></td>
                            <td><%=master.getLosses10()%></td>
                        </tr>
                    </tbody>
                </table>
                    
                
                <h3 class id="title">ESports Stream</h3>
               <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol1"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "nalcs1",
                };
                var player = new Twitch.Player("Lol1", options);
                player.setVolume(0);
                </script>
                <!--
                <iframe frameborder="0" 
                        scrolling="no" 
                        id="chat_embed" 
                        src="http://www.twitch.tv/nalcs1/chat" 
                        height="500" 
                        width="350">
                </iframe>
                -->
                
                <h3 class id="title">Imaqtpie Stream</h3>
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
                
                
                <h3 class id="title">Scarra Stream</h3>
                 <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol3"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "scarra",
                };
                var player = new Twitch.Player("Lol3", options);
                player.setVolume(0);
                </script>
                  
               
            </section>
        </article> 
        <%@ include file="Includes/footer.jsp" %>
</div>
    </body>
    
</html>
