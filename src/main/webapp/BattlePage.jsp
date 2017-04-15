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
        
         
   
        
        <form action="FrontController" method="get">
            <%
                for(int k = 0; k < bDao.getChampsBasedOnPosition("Top").size(); k++)
                {
            %>
            Top lane: <%=bDao.getChampName(2)%>
            <%
                }
            %>
        </form>
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
