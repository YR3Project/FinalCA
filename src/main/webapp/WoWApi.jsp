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
        <link href="CSS/WoW.css" rel="stylesheet" type="text/css"/>
        <title>SWGW</title>

    </head>

    <%@ include file="Includes/Carousel.html" %> 
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
            Mounts mounts = new Mounts();
            MountsObject mo = new MountsObject();
            
            mounts = mo.getMount(realm, name);
            int arraySize = mounts.getName().size();
            
            
            Pets pets = new Pets();
            PetsObject po = new PetsObject();
            
            pets = po.getPets(realm, name);
            int petArraySize = pets.getName().size();
            %>
            
            <div class="Articles">
                <center> 
                    <img src="<%=url%>" alt="Thumbnail" style="width: 100px;">
                    <h3 id="title">UserName</h3>
                    <p><%=character.getName()%></p>
                    <h3 id="title">Realm</h3>
                    <p><%=character.getRealm()%></p>
                    <h3 id="title">Race</h3>
                    <p><%=races[race]%> <%=classes[charClass]%></p>
                    <p> </p>
                    <h3 id="title">Gender</h3>
                    <p><%=genderArray[gender]%></p>
                    <h3 id="title">Kills</h3>
                    <p>Honorable Kills: <%=character.getTotalHonorableKills()%></p>
                    <h3 id="title">Helmet</h3>
                    <p><%=charItems.getHeadName()%></p>
                    <h3 id="title">Neck</h3>
                    <p><%=charItems.getNeckName()%></p>
                    <h3 id="title">Shoulder</h3>
                    <p><%=charItems.getShoulderName()%></p>
                    <h3 id="title">Chest</h3>
                    <p><%=charItems.getChestName()%></p>
                    <h3 id="title">Back</h3>
                    <p><%=charItems.getBackLevel()%></p>
                    <h3 id="title">Wrist</h3>
                    <p><%=charItems.getWristName()%></p>
                    <h3 id="title">Hand</h3>
                    <p><%=charItems.getHandName()%></p>
                    <h3 id="title">Finger 1</h3>
                    <p><%=charItems.getFinger1Name()%></p>
                    <h3 id="title">Finger 2</h3>
                    <p><%=charItems.getFinger2Name()%></p>
                    <h3 id="title">Trinket 1</h3>
                    <p><%=charItems.getTrinket1Name()%></p>
                    <h3 id="title">Trinket 2</h3>
                    <p><%=charItems.getTrinket2Name()%></p>
                    <h3 id="title">Leg</h3>
                    <p><%=charItems.getLegName()%></p>
                    
                    
               
                    <h3 id="title">Mounts</h3>
                        <%
                        for(int i = 0; i < arraySize; i++)
                        {
                        %>
                        <P> <%=mounts.getName().get(i).toString()%> <br />
                        <%
                        }
                        
                        %>
                        <h3 id="title">Pets</h3>
                       <%
                        for(int i = 0; i < petArraySize; i++)
                        {
                        %>
                        <P> <%=pets.getName().get(i).toString()%> <br />
                        <%
                        }
                        
                        %>
                    </div>
                </center> 
            </section>
            </article>
            <%@ include file="Includes/footer.jsp" %>
        </div>
            
    </body>
</html>
