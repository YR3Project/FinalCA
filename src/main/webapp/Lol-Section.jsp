

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOL-Section</title>
<div id="wrapper">
        <%@ include file="Includes/nav.jsp" %> 
    </head>
    
    <body>
        <h1>Welcome to league of legends</h1>
         
               <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol1"></div>
                <script type="text/javascript">
                var options = {
                    width: 1280,
                    height: 720,
                    channel: "nalcs1",
                };
                var player = new Twitch.Player("Lol1", options);
                player.setVolume(0);
                </script>
                <iframe frameborder="0" 
                        scrolling="no" 
                        id="chat_embed" 
                        src="http://www.twitch.tv/nalcs1/chat" 
                        height="500" 
                        width="350">
                </iframe>
                
                
                <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol2"></div>
                <script type="text/javascript">
                var options = {
                    width: 1280,
                    height: 720,
                    channel: "imaqtpie",
                };
                var player = new Twitch.Player("Lol2", options);
                player.setVolume(0);
                </script>
                <iframe frameborder="0" 
                        scrolling="no" 
                        id="chat_embed" 
                        src="http://www.twitch.tv/imaqtpie/chat" 
                        height="500" 
                        width="350">
                </iframe>
                
                
                 <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Lol3"></div>
                <script type="text/javascript">
                var options = {
                    width: 1280,
                    height: 720,
                    channel: "mushisgosu",
                };
                var player = new Twitch.Player("Lol3", options);
                player.setVolume(0);
                </script>
                <iframe frameborder="0" 
                        scrolling="no" 
                        id="chat_embed" 
                        src="http://www.twitch.tv/mushisgosu/chat" 
                        height="500" 
                        width="350">
                </iframe>
</div>
    </body>
    <%@ include file="Includes/footer.jsp" %>
</html>
