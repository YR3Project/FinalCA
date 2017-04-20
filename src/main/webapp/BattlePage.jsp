<%-- 
    Document   : BattlePage
    Created on : 14-Apr-2017, 17:24:58
    Author     : PC
--%>

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
    <script>
        window.onload = function () {
        document.getElementById('MainForms').style.display = 'none';
            document.getElementById('more').onclick = function () {
        if (this.checked)
            document.getElementById('MainForms').style.display = 'block';
        else
            document.getElementById('MainForms').style.display = 'none';  
    }
    
    document.getElementById('MainForms2').style.display = 'none';
            document.getElementById('more2').onclick = function () {
        if (this.checked)
            document.getElementById('MainForms2').style.display = 'block';
        else
            document.getElementById('MainForms2').style.display = 'none';  
    }
    
}
    </script>    
    <body>
         <div id="wrapper">
      
        <header>
        <%@ include file="Includes/nav.jsp" %>
        <h1>StatWiseGameWise</h1>
        </header>
         </div>
        <%
            BattleSystemDao bDao = new BattleSystemDao("swgw");
            BattleSystem battle = new BattleSystem();
            
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
        %>
        
         
   
        <article>
        <section>
            <form action="FrontController" method="get">
                <span id="spantop">Top lane:</span> 
            <br />
            <select name="topChamp" id="topChamp">
            <%
            for(int k = 0; k < bDao.getChampsBasedOnPosition("Top").size(); k++)
            {
            %>
            <option value="<%=bDao.getChampsBasedOnPosition("top").get(k).getChampName()%>">
                <%=bDao.getChampsBasedOnPosition("top").get(k).getChampName()%>
            </option>
            <br />
            <%
            }
            %>
            </select>
            <br />
            <span id="spanjung">Jungle</span>
            <br />
            <select name="jungChamp" id="jungChamp">
            <br />
            <%
            for(int j = 0; j < bDao.getChampsBasedOnPosition("Jung").size(); j++)
            {
            %>
            
            
            <br />
            <option value="<%=bDao.getChampsBasedOnPosition("jung").get(j).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("jung").get(j).getChampName()%>
            </option>
            <%
            }
            %>
            <br />
            </select>
            <br />
            <span id="spanmid">Mid</span>
            <br />
            <select name="midChamp" id="midChamp">
            <br />
            <%
            for(int h = 0; h < bDao.getChampsBasedOnPosition("Mid").size(); h++)
            {
            %>
            <br/>
            
            <br />
            <option value="<%=bDao.getChampsBasedOnPosition("Mid").get(h).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("Mid").get(h).getChampName()%>
            </option>
            <br />
            <%
            }
            %>
            </select>
            <br />
            <span id="spanadc">ADC</span>
            <br />
            <select name="adcChamp" id="adcChamp">
            <br />
            <%
            for(int g = 0; g < bDao.getChampsBasedOnPosition("ADC").size(); g++)
            {
            %>
            <br/>
            
            <br />
            <option value="<%=bDao.getChampsBasedOnPosition("ADC").get(g).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("ADC").get(g).getChampName()%>
            </option>

            <%
            }
            %>
            </select>
            <br />
            <span id="spansup">Support</span>
            <br />
            <select name="supportChamp" id="supportChamp">
            <br />
            <%
            for(int f = 0; f < bDao.getChampsBasedOnPosition("Support").size(); f++)
            {
            %>
            <br />
            <option value="<%=bDao.getChampsBasedOnPosition("support").get(f).getChampName()%>">
                    <%=bDao.getChampsBasedOnPosition("support").get(f).getChampName()%>
            </option>

            <br />
            <%
            }
            %>
            </select>
            <br />
            
            <br />
            <input type="submit" value="Battle!" id="battle">
            <input type="hidden" name="action" value="battle">
        </form>
        </section>
</article>
        <%
            
            }
            else{
        %>
        <h2>You must be logged in to use the Battle System</h2>
        <%
            }
        %>
    </body>
</html>
