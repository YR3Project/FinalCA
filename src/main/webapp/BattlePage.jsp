

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <link href="CSS/Battle.css" rel="stylesheet" type="text/css">

        <title>SWGW</title>
        
    </head>

    <%@ include file="Includes/Slideshow.php" %>
      
    <body>
        <div id="wrapper">
             
        <header>
        <%@ include file="Includes/nav.jsp" %>
        <h1>The Battle Begins</h1>
        </header>
         
        <%
            BattleSystemDao bDao = new BattleSystemDao("swgw");
            BattleSystem battle = new BattleSystem();
            
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
        %>
        
         
   
        <article>
        
            <form action="FrontController" method="get" >
            <h2 id="title">Let Battle Begin</h2>
            
            <div id="centerform">
                <span id="Battletitle">Top lane:</span> 
            <br />
            
            <div class="styled-select black rounded">
                
            <select name="topChamp" id="topChamp">
            <%
            for(int k = 0; k < bDao.getChampsBasedOnPosition("Top").size(); k++)
            {
            %>
            <option value="<%=bDao.getChampsBasedOnPosition("top").get(k).getChampName()%>">
                <%=bDao.getChampsBasedOnPosition("top").get(k).getChampName()%>
            </option>
            
            <%
            }
            %>
            </select>
            </div>
            
            
            <span id="Battletitle">Jungle:</span>
            
            
            <div class="styled-select black rounded">
            <select name="jungChamp" id="jungChamp">
            
            <%
            for(int j = 0; j < bDao.getChampsBasedOnPosition("Jung").size(); j++)
            {
            %>
            
            
            
            <option value="<%=bDao.getChampsBasedOnPosition("jung").get(j).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("jung").get(j).getChampName()%>
            </option>
            <%
            }
            %>
            
            </select>
            </div>
            
            
            <span id="Battletitle">Mid:</span>
            
            
            <div class="styled-select black rounded">
            <select name="midChamp" id="midChamp">
            
            <%
            for(int h = 0; h < bDao.getChampsBasedOnPosition("Mid").size(); h++)
            {
            %>
            
            
            
            <option value="<%=bDao.getChampsBasedOnPosition("Mid").get(h).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("Mid").get(h).getChampName()%>
            </option>
            
            <%
            }
            %>
            </select>
            </div>
            
            
            <span id="Battletitle">ADC:</span>
            
            
            <div class="styled-select black rounded">
            <select name="adcChamp" id="adcChamp">
            
            <%
            for(int g = 0; g < bDao.getChampsBasedOnPosition("ADC").size(); g++)
            {
            %>
      
            
            
            <option value="<%=bDao.getChampsBasedOnPosition("ADC").get(g).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("ADC").get(g).getChampName()%>
            </option>

            <%
            }
            %>
            </select>
            </div>
            
            
            <span id="Battletitle">Support:</span>
            
            
            <div class="styled-select black rounded">
            <select name="supportChamp" id="supportChamp">
            
            <%
            for(int f = 0; f < bDao.getChampsBasedOnPosition("Support").size(); f++)
            {
            %>
            
            <option value="<%=bDao.getChampsBasedOnPosition("support").get(f).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("support").get(f).getChampName()%>
            </option>

            
            <%
            }
            %>
            </select>
            </div>
            
            <p>
            </p>
            
            </div>
            <div id="buttonmove">
            <input type="submit" value="Battle!" id="battle">
            </div>
            <input type="hidden" name="action" value="battle">
        </form>
        
</article>

        <%
            
            }
            else{
        %>
        <h2>You must be logged in to use the Battle System</h2>
      
        
        <%
            }
        %>
            <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
