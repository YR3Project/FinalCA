
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
    <h1 id="secert">DONT MIND THIS IS TO HELP THE LOOOK OF THE PAGE</h1>
     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
        <header>
        <h1>Welcome to league of legends</h1>
        <%@ include file="Includes/nav.jsp" %>
        </header>
        <article>
            <section>
                <h3 class id="title">Your League Champion</h3>
                 <%
                    RootObject r = new RootObject();
                    //String champID = request.getParameter("champID");
                    Champion champ = r.getChamp();
                    %>
                <p>
                    <%=champ.getName()%>
                    <%=champ.getTitle()%>
                </p>
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
