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
        <title>SWGW</title>

    </head>

    <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
            <header>
                <%@ include file="Includes/nav.jsp" %>
                <h1>World of Warcraft Legion</h1>
            </header>
            <article>
            <section>
                 <%
            String name = request.getParameter("name");
            String realm = request.getParameter("realm");
                     
            WOWRootObject r = new WOWRootObject();   
            CharacterProfile character = r.getChar(realm, name);
            
            int charClass = character.getCharClass();
            
            int gender = character.getGender();
            int race = character.getRace();
            String [] genderArray = {"Male", "Female"};
            String [] races = {"0", "Human", "Orc", "Dwarf", "Night Elf", "Undead", "6", "Gnome", "8", "Goblin", "Blood Elf", "Draenei", "12", "13", "14", "15", "", "", "", "", "", "", "Worgen", "", "", "Pandaren"};
            String [] classes = {"Warlock", "Warrior", "Paladin", "Hunter", "Rogue", "Priest", "Death Knight", "Shaman", "Mage", "", "Monk", "Druid", "Demon Hunter"};
            String url = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + character.getThumbnail();
            WOWRootObject rItems = new WOWRootObject();
            CharacterItem charItems = rItems.getItems(realm, name);
            
            %>
            
            
            <img src="<%=url%>" alt="Thumbnail" style="width: 100px;">
            
            <p><%=character.getName()%></p>
            <p><%=character.getRealm()%></p>
            <p><%=races[race]%> <%=classes[charClass]%></p>
            <p> </p>
            <p><%=genderArray[gender]%></p>
            <p>Honorable Kills: <%=character.getTotalHonorableKills()%></p>
            <p><%=charItems.getHeadName()%></p>
                
            
            </section>
            </article>
        </div>
            <%@ include file="Includes/footer.jsp" %>
    </body>
</html>
