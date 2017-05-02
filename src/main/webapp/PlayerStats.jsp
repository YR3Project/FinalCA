<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
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
        <link href="CSS/playerstats.css" rel="stylesheet" type="text/css"/>
        
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.min.js"></script>
        <script>
            
            $(function(){
               
                var value = $('#KD3').text();
                var value2 = $('#KD2').text(); 
                var value3 = $('#KD').text();
                
                var color = 'red';
                if(!isNaN(value))
                {
                    if(value < 1 && value >= 0)
                    {
                        color = 'red';
                    }
                   
                    else if(value >= 1)
                    {
                        color = '#66ff66';
                    }
                  
                 $('#KD3').css('color', color);
                 
                }
                if(!isNaN(value2))
                {
                    if(value2 < 1 && value2 >= 0)
                    {
                        color = 'red;'
                    }
                    else if(value2 >= 1)
                    {
                        color = '#66ff66';
                    }
                 $('#KD2').css('color', color);
                }
                if(!isNaN(value3))
                {
                    if(value3 < 1 && value3 >= 0)
                    {
                        color = 'red';
                    }
                    else if(value3 >= 1)
                    {
                        color = '#66ff66';
                    }
                    $('#KD').css('color', color);
                }
               
               
            });
        </script>
    </head>

     
    <body>
        <div id="wrapper">
        <header>
                 <br />
                 <br />
                 <br />
                 <br />
                 <br />
            <h1>Welcome to League of Legends</h1>
            <%@ include file="Includes/nav.jsp" %>
        </header>
        
            <%
                String name = request.getParameter("name");
                String region = request.getParameter("region");
                String season = request.getParameter("season");
                
                if(season.equals("Season 7"))
                {
                    season = "SEASON2017";
                }else if(season.equals("Season 6"))
                {
                    season = "SEASON2016";
                }
                else if(season.equals("Season 5"))
                {
                    season = "SEASON2015";
                }
                else if(season.equals("SEASON 4"))
                {
                    season = "SEASON2014";
                }
                //Getting the  champions ranked stats
                    RankedStats stats = new RankedStats();
                    RankedObject ro = new RankedObject();
                    //Getting the players ID object
                    PlayerObject po = new PlayerObject();
                    Player player = new Player();
                    //Getting the players rank wins/losses etc.
                    PlayerRank pr = new PlayerRank();
                    PlayerRankObject pro = new PlayerRankObject();
                    //Getting the champions IDs
                    Champ champ = new Champ();
                    ChampObject co = new ChampObject();
                    Champ champ2 = new Champ();
                    ChampObject co2 = new ChampObject();
                    Champ champ3 = new Champ();
                    ChampObject co3 = new ChampObject();
                    
                if(name == "" || region == "")
                { 
                %>
                <article>
                    <section>
                        <h2>Your region may be down or account name is not valid, please try again</h2>
                <%
                }
                else
                {
                    //Getting unranked stats
                    Unranked unranked = new Unranked();
                    UnrankedObject uro = new UnrankedObject();
                    

                    //Getting the users stats
                    
                    //player = po.getPlayer(name);
                    player = po.getPlayer(name, region);
                    int id = player.getSummonerID();
                    //Gets the player tier division and points
                    //String url = "http://avatar.leagueoflegends.com/"+region+"/"+name+".png";
                    //unranked = uro.getUnranked(region, Integer.toString(id));
                    pr = pro.getPlayerRank(Integer.toString(id), region);
                    
                    //Get the champions name
                    stats = ro.getRankedStats(id, region, season);
                    int champID = stats.getChampID();
                    int champID2 = stats.getChampID2();
                    int champID3 = stats.getChampID3();
                    champ = co.getChampID(champID);
                    champ2 = co.getChampID(champID2);
                    champ3 = co.getChampID(champID3);
                    
                    
                    
                    //Getting the winrate
                    NumberFormat formatter = new DecimalFormat("#.00");
                    float win = stats.getWins();
                    float loss = stats.getLosses();
                    
                    float kills = stats.getMostKills();
                    float deaths = stats.getMostDeaths();
       
                    float win2 = stats.getWins2();
                    float loss2 = stats.getLosses2();
                    float kills2 = stats.getMostKills2();
                    float deaths2 = stats.getMostDeaths2();
                    
                    float win3 = stats.getWins3();
                    float loss3 = stats.getLosses3();
                    float kills3 = stats.getMostKills3();
                    float deaths3 = stats.getMostDeaths3();
                    float total = (win + loss);
                    float total2 = (win2 + loss2);
                    float total3 = (win3 + loss3);
                    String winrate;
                    String winrate2;
                    String winrate3;
                    winrate = formatter.format(win/total);
                    winrate2 = formatter.format(win2/total2);
                    winrate3 = formatter.format(win3/total3);
                    
                    if(loss == 0)
                    {
                        winrate = "100";
                    }
                    else if(win == 0)
                    {
                        winrate = "0";
                    }
                    if(loss2 == 0)
                    {
                        winrate2 = "100";
                    }
                    else if(win2 == 0)
                    {
                        winrate2 = "0";
                    }
                    if(loss3 == 0)
                    {
                        winrate3 = "100";
                    }
                    else if(win3 == 0)
                    {
                        winrate3 = "0";
                    }
                    
                    ServerStatus serverStatus = new ServerStatus();
                    ServerObject so = new ServerObject();
                    serverStatus = so.getServerStatus(region);
            
              if(player != null || stats != null)
              {
            %>
        <article>
            <section>
                
                <div class="Articles">
                <h2 id="title">Your server <%=serverStatus.getName() %> is currently <%=serverStatus.getStatus()%></h2>
                <h2 id="title">Your rank</h2>
                
                <p>Player name: <%=player.getName()%>
                <p>Player rank: <%=pr.getTierName()%> <%=pr.getTier()%> <%=pr.getDivision()%>
                <p>League Points: <%=pr.getLeaguePoints()%>
                <p>Player Wins: <%=pr.getWins()%>
                <p>Player Losses: <%=pr.getLosses()%>
                
                
                
                
                    
                    
                <h2 id="title">3 most recent champions played</h2>
                <div id="champ">
                    <p id="title">Champion name: <%=champ.getName()%> <%=champ.getTitle()%>
                    <p class="win">Total Wins: <%=stats.getWins()%></p>
                    <p class="loss">Total Losses: <%=stats.getLosses()%></p>
                    <p>Win rate: <%=winrate%>%
                    <p class="damageDealt">Total Damage Dealt: <%=stats.getTotalDamageDealt()%>
                    <p class="damageTaken">Total Damage taken:  <%=stats.getTotalDamage()%>
                    <p class="kills">Most Kills: <%=stats.getMostKills()%>
                    <P class="deaths">Most Deaths: <%=stats.getMostDeaths()%>
                    <p class="KD">KD Ratio: <span id="KD"><%=formatter.format(kills/deaths)%></span></p>
                </div>
                <div id="champ2">        
                    <p id="title">Champion name: <%=champ2.getName()%> <%=champ2.getTitle()%>
                    <p class="win">Total Wins: <%=stats.getWins2()%></p>
                    <p class="loss">Total Losses: <%=stats.getLosses2()%></p>
                    <p>Win rate: <%=winrate2%>%
                    <p class="damageDealt">Total Damage Dealt: <%=stats.getTotalDamageDealt2()%>
                    <p class="damageTaken">Total Damage taken:  <%=stats.getTotalDamage2()%>
                    <p class="kills">Most Kills: <%=stats.getMostKills2()%>
                    <P class="deaths">Most Deaths: <%=stats.getMostDeaths2()%>
                    <p class="KD2">KD Ratio: <span id="KD2"><%=formatter.format(kills2/deaths2)%></span>
                </div>
                <div id="champ3">
                    <p id="title">Champion name: <%=champ3.getName()%> <%=champ3.getTitle()%>
                    <p class="win">Total Wins: <%=stats.getWins3()%></p>
                    <p class="loss">Total Losses: <%=stats.getLosses3()%></p>
                    <p>Win rate: <%=winrate3%>%
                    <p class="damageDealt">Total Damage Dealt: <%=stats.getTotalDamageDealt3()%>
                    <p class="damageTaken">Total Damage taken:  <%=stats.getTotalDamage3()%>
                    <p class="kills">Most Kills: <%=stats.getMostKills3()%>
                    <P class="deaths">Most Deaths: <%=stats.getMostDeaths3()%>
                    <p class="KD">KD Ratio: <span id="KD3"><%=formatter.format(kills3/deaths3)%></span>
                </div>
                </div>
            </section>
                 <%
                    }
                    else
                    {
                %>
                    Your profile is unavailable at the moment
                    Your server <%=serverStatus.getName() %> is currently <%=serverStatus.getStatus()%>
                <%
                    }
                }
                %>
        </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
                
            
    </body>
    
</html>
