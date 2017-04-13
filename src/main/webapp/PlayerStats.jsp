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
        <title>LOL-Section</title>
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
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
        <header>
            <h1>Welcome to League of Legends</h1>
            <%@ include file="Includes/nav.jsp" %>
        </header>
        
            <%
                String name = request.getParameter("name");
                String region = request.getParameter("region");
                    RankedStats stats = new RankedStats();
                    RankedObject ro = new RankedObject();
                    
                    //Getting the champions IDs
                    Champ champ = new Champ();
                    ChampObject co = new ChampObject();
                    Champ champ2 = new Champ();
                    ChampObject co2 = new ChampObject();
                    Champ champ3 = new Champ();
                    ChampObject co3 = new ChampObject();
                    
                    
                    //Getting the users stats
                    PlayerObject po = new PlayerObject();
                    Player player = new Player();
                    //player = po.getPlayer(name);
                    player = po.getPlayer(name, region);
                    int id = player.getSummonerID();
                    
                    //Get the champions name
                    stats = ro.getRankedStats(id, region);
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
                    String winrate;
                    String winrate2;
                    String winrate3;
                    winrate = formatter.format(win/loss);
                    winrate2 = formatter.format(win2/loss2);
                    winrate3 = formatter.format(win3/loss3);
                    
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
                    
                    
            
                
            %>
        <article>
            <section>
                
                <p>Player name: <%=player.getName()%>
                <h2>3 most recent champions played</h2>
                <div id="champ">
                    <p>Champion name: <%=champ.getName()%> <%=champ.getTitle()%>
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
                    <p>Champion name: <%=champ2.getName()%> <%=champ2.getTitle()%>
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
                    <p>Champion name: <%=champ3.getName()%> <%=champ3.getTitle()%>
                    <p class="win">Total Wins: <%=stats.getWins3()%></p>
                    <p class="loss">Total Losses: <%=stats.getLosses3()%></p>
                    <p>Win rate: <%=winrate3%>%
                    <p class="damageDealt">Total Damage Dealt: <%=stats.getTotalDamageDealt3()%>
                    <p class="damageTaken">Total Damage taken:  <%=stats.getTotalDamage3()%>
                    <p class="kills">Most Kills: <%=stats.getMostKills3()%>
                    <P class="deaths">Most Deaths: <%=stats.getMostDeaths3()%>
                    <p class="KD">KD Ratio: <span id="KD3"><%=formatter.format(kills3/deaths3)%></span>
                </div>
            </section>
                
        </article>
        </div>
                <%@ include file="Includes/footer.jsp" %>
            
    </body>
</html>
