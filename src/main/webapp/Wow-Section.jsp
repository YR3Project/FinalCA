

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SWGW</title>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
 </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
        <header>
        <h1>Welcome to World of Warcraft</h1>
        <%@ include file="Includes/nav.jsp" %>
        </header>
        <article>
            <section>
    
                <h3 class id="title">Towelliee Stream</h3>
             <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Wow1"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "towelliee",
                };
                var player = new Twitch.Player("Wow1", options);
                player.setVolume(0);
                </script>
                <!--
                <iframe frameborder="0" 
                        scrolling="no" 
                        id="chat_embed" 
                        src="http://www.twitch.tv/towelliee/chat" 
                        height="500" 
                        width="350">
                </iframe>
                -->
                <h3 class id="title">Boetargg Stream</h3>
                 <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Wow2"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "boetargg",
                };
                var player = new Twitch.Player("Wow2", options);
                player.setVolume(0);
                </script>
                
                <h3 class id="title">Slootbag Stream</h3>
                <script src= "http://player.twitch.tv/js/embed/v1.js"></script>
                <div id="Wow3"></div>
                <script type="text/javascript">
                var options = {
                    width: 720,
                    height: 500,
                    channel: "slootbag",
                };
                var player = new Twitch.Player("Wow3", options);
                player.setVolume(0);
                </script>
            </section>
        </article>
        <%@ include file="Includes/footer.jsp" %>        
 </div>
    </body>
    
</html>
