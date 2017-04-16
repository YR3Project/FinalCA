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
        
        <%
            BattleSystemDao bDao = new BattleSystemDao("swgw");
            BattleSystem battle = new BattleSystem();
            
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
        %>
        
         
   
<article>
    </section>
            <form action="FrontController" method="get">
            Top lane: 
            <br />
            <%
            for(int k = 0; k < bDao.getChampsBasedOnPosition("Top").size(); k++)
            {
            %>
            <%=bDao.getChampsBasedOnPosition("top").get(k).getChampName()%>
            <br />
            <%
            }
            %>
            <br />
            <input type="text" name="topChamp" id="topChamp" placeholder="Top">
            <br />
            <%
            for(int j = 0; j < bDao.getChampsBasedOnPosition("Jung").size(); j++)
            {
            %>
            
            Jungle:
            <br />
            <%=bDao.getChampsBasedOnPosition("jung").get(j).getChampName()%>
            <%
            }
            %>
            <br />
            <input type="text" name="jungChamp" id="jungChamp" placeholder="Jungle">
            <br />
            <%
            for(int h = 0; h < bDao.getChampsBasedOnPosition("Mid").size(); h++)
            {
            %>
            <br/>
            Mid Lane:
            <br />
            <%=bDao.getChampsBasedOnPosition("Mid").get(h).getChampName()%>
            <%
            }
            %>
            <br />
            <input type="text" name="midChamp" id="midChamp" placeholder="Mid">
            <br />
            <%
            for(int g = 0; g < bDao.getChampsBasedOnPosition("ADC").size(); g++)
            {
            %>
            <br/>
            ADC:
            <br />
            <%=bDao.getChampsBasedOnPosition("ADC").get(g).getChampName()%>
            <%
            }
            %>
            <br />
            <input type="text" name="adcChamp" id="adcChamp" placeholder="ADC">
            <br />
            <%
            for(int f = 0; f < bDao.getChampsBasedOnPosition("Support").size(); f++)
            {
            %>
            <br/>
            Support:
            <br />
            <%=bDao.getChampsBasedOnPosition("Support").get(f).getChampName()%>
            
            <%
            }
            %>
            <br />
            <input type="text" name="supportChamp" id="supportChamp" placeholder="Support">
            <br />
            <input type="submit" values="Battle!">
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
